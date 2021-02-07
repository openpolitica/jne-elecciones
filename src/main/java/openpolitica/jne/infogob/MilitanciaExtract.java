package openpolitica.jne.infogob;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import openpolitica.jne.elecciones.data.Candidato;
import openpolitica.jne.infogob.data.Afiliacion;
import openpolitica.jne.infogob.data.FichaHistorial;
import openpolitica.jne.infogob.data.Militancia;
import openpolitica.jne.infogob.data.ProcesoElectoral;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MilitanciaExtract {
  static final Logger LOG = LoggerFactory.getLogger(MilitanciaExtract.class);

  static final ObjectMapper mapper = new ObjectMapper();
  static final HttpClient httpClient = HttpClient.newBuilder().build();

  public static void main(String[] args) throws IOException {
    var m = new MilitanciaExtract().getMilitancia("18010708");
    System.out.println(m);
  }

  List<Militancia> getMilitancias(Path inputCandidatos,
      MilitanciaExtract main) throws IOException {
    var candidatos = main.loadCandidatos(inputCandidatos);

    var dnis = new ArrayList<String>();
    candidatos.forEach(candidato -> {
      var dni = candidato.getIdDni();
      dnis.add(dni);
    });

    return
        dnis.parallelStream()
            .map(this::getMilitancia)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
  }

  private Militancia getMilitancia(String dni) {
    try {

      var html = Jsoup.connect("https://infogob.jne.gob.pe/Politico").get();
      var key = html.select("input#key").attr("value");
      //{"IdDNI":"70365396","TxApePat":"","TxApeMat":"","TxNombre":"","token":"iDmIeY0KBfY=mY"}
      var requestNode = mapper.createObjectNode();
      requestNode.put("IdDNI", dni)
          .put("TxApePat", "")
          .put("TxApeMat", "")
          .put("token", key)
      ;
      var requestBody = mapper.writeValueAsString(requestNode);
      var httpRequest = HttpRequest.newBuilder()
          .uri(URI.create("https://infogob.jne.gob.pe/Politico/ListarPolitico"))
          .POST(HttpRequest.BodyPublishers.ofString(requestBody))
          .header("Content-type", "application/json")
          .build();
      var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      var responseBody = response.body();
      var responseNode = mapper.readTree(responseBody);

      if (responseNode.get("Estado").asText().equals("success")) {
        var dataArray = (ArrayNode) responseNode.get("Data");
        if (dataArray.isEmpty()) {
          System.out.println("No data for " + dni);
        } else if (dataArray.size() == 1) {

          var dataNode = dataArray.get(0);
          var rutaPolitico = dataNode.get("TxRutaPolitico").asText();

          System.out.println(rutaPolitico);

          var token = rutaPolitico.split("_")[2];
          System.out.println(token);

          var politicoDoc =
              Jsoup.connect("https://infogob.jne.gob.pe" + rutaPolitico).get().body();
          var fichaKey = politicoDoc.select("input#key").attr("value");
          var nombreCompleto = politicoDoc.select("span#TxNombreCompleto").text();

          return Militancia.newBuilder()
              .setDni(dni)
              .setNombreCompleto(nombreCompleto)
              .setFichaHistorial(getFichaHistorial(token, fichaKey))
              .setProcesosElectorales(getProcesosElectorales(token, fichaKey))
              .build();

          // TODO estabilidad cargo https://infogob.jne.gob.pe/Politico/FichaPolitico/george-patrick-forsyth-sommer_estabilidad-en-el-cargo_4b@2tWTg7S8=@W
          // TODO revocatorias promovidas https://infogob.jne.gob.pe/Politico/FichaPolitico/george-patrick-forsyth-sommer_revocatorias-promovidas_4b@2tWTg7S8=@W
        } else {
          System.out.println("Error: too many persons per DNI");
        }
      }
      return null;
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return null;
    }
  }

  void save(Path output, List<Militancia> candidatos) throws IOException {
    var current = new ArrayList<Militancia>();
    if (Files.isRegularFile(output)) {
      var reader = load(output);
      reader.forEach(current::add);
      current.sort(Comparator.comparing(Militancia::getDni));
      LOG.info("Militancias actuales: " + current.size());

      candidatos.sort(Comparator.comparing(Militancia::getDni));
      LOG.info("Militancias obtenidos: " + candidatos.size());

      if (current.equals(candidatos)) {
        LOG.info("Militancias obtenidos no han cambiado");
        return;
      }
    }
    var datumWriter = new SpecificDatumWriter<>(Militancia.class);
    try (var writer = new DataFileWriter<>(datumWriter)) {
      writer.setCodec(CodecFactory.zstandardCodec(CodecFactory.DEFAULT_ZSTANDARD_LEVEL));
      writer.create(Militancia.SCHEMA$, output.toFile());

      candidatos.forEach(s -> {
        try {
          writer.append(s);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    }
  }

  private List<ProcesoElectoral> getProcesosElectorales(String token, String fichaKey)
      throws IOException, InterruptedException {
    var politicoUrl =
        "https://infogob.jne.gob.pe/Politico/_ProcesosFichaPolitico?istrParameters="
            + URLEncoder.encode(token, StandardCharsets.UTF_8);
    System.out.println(politicoUrl);

    var fichaRequestNode = mapper.createObjectNode().put("token", fichaKey);
    String fichaRequest = mapper.writeValueAsString(fichaRequestNode);
    System.out.println(fichaRequest);
    var fichaResponse =
        httpClient.send(
            HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(fichaRequest))
                .uri(URI.create(politicoUrl))
                .header("Content-type", "application/json")
                .build(),
            HttpResponse.BodyHandlers.ofString());

    var politicoBody = Jsoup.parse(fichaResponse.body()).body();
    System.out.println(politicoBody);

    var procesos = new ArrayList<ProcesoElectoral>();
    for (var tr : politicoBody.select("tr")) {
      var tds = tr.select("td");
      if (!tds.isEmpty()) {
        var proceso = ProcesoElectoral.newBuilder()
            .setProcesoElectoral(tds.get(0).text())
            .setCargoPostulo(tds.get(1).text())
            .setOrgPolitica(tds.get(2).text())
            .setCircunscripcion(tds.get(3).text())
            .setElegido(tds.get(4).text())
            .build();

        procesos.add(proceso);
      }
    }

    return procesos;
  }

  private FichaHistorial getFichaHistorial(String token, String fichaKey)
      throws IOException, InterruptedException {
    var politicoUrl =
        "https://infogob.jne.gob.pe/Politico/_HistorialFichaPolitico?istrParameters="
            + URLEncoder.encode(token, StandardCharsets.UTF_8);
    System.out.println(politicoUrl);
    var fichaRequestNode = mapper.createObjectNode().put("token", fichaKey);
    String fichaRequest = mapper.writeValueAsString(fichaRequestNode);
    System.out.println(fichaRequest);
    var fichaResponse =
        httpClient.send(
            HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(fichaRequest))
                .uri(URI.create(politicoUrl))
                .header("Content-type", "application/json")
                .build(),
            HttpResponse.BodyHandlers.ofString());

    var politicoBody = Jsoup.parse(fichaResponse.body()).body();
    var select = politicoBody.select("div.content");
    System.out.println(select);
    if (!select.isEmpty()) {
      var divCampos = select.first().select("span.control");
      System.out.println(divCampos);

      var divHistorialCampos = select.last().children();
      var histSize = 1;
      for (var el : divHistorialCampos) {
        if (el.tagName().equals("hr")) histSize++;
      }
      System.out.println("hist size: " + histSize);
      var historial = new Afiliacion.Builder[histSize];
      for (int a = 0; a < histSize; a++) {
        historial[a] = Afiliacion.newBuilder();
      }
      int i = 0;

      for (var elem : divHistorialCampos) {
        if (elem.tagName().equals("hr")) {
          i++;
        } else {
          var divRows = elem.children();
          for (var divRow : divRows) {
            var iKey = divRow.select("span.etiqueta").text();
            var iVal = divRow.select("span.control").text();
            switch (iKey) {
              case "Organización Política:" -> historial[i].setOrgPolitica(iVal);
              case "Estado Org. Política:" -> historial[i].setOrgPoliticaEstado(iVal);
              case "Tipo partido:" -> historial[i].setOrgPoliticaTipo(iVal);
              case "Alcance:" -> historial[i].setOrgPoliticaAlcance(iVal);
              case "Fecha de inscripción:" -> historial[i].setOrgPoliticaFechaInscripcion(iVal);
              case "Fecha de cancelación:" -> historial[i].setAfiliacionCancelacion(iVal);
              case "Estado de ciudadano:" -> historial[i].setAfiliacionEstado(iVal);
              case "Inicio de afiliación:" -> historial[i].setAfiliacionInicio(iVal);
              case "Representante:" -> historial[i].setAfiliacionRepresentante(iVal);
            }
          }
        }
      }

      return FichaHistorial.newBuilder()
          .setAfiliacionVigente(Afiliacion.newBuilder()
              .setOrgPolitica(divCampos.get(0).text())
              .setOrgPoliticaEstado(divCampos.get(1).text())
              .setOrgPoliticaTipo(divCampos.get(2).text())
              .setOrgPoliticaAlcance(divCampos.get(3).text())
              .setOrgPoliticaFechaInscripcion(divCampos.get(4).text())
              .setAfiliacionEstado(divCampos.get(5).text())
              .setAfiliacionInicio(divCampos.get(6).text())
              .setAfiliacionRepresentante(divCampos.get(7).text())
              .setAfiliacionComite(divCampos.get(8).text())
              .build())
          .setHistorialAfiliaciones(Arrays.stream(historial)
              .map(Afiliacion.Builder::build)
              .collect(Collectors.toList()))
          .build();
    } else {
      return null;
    }
  }

  DataFileReader<Candidato> loadCandidatos(Path input) throws IOException {
    var reader = new SpecificDatumReader<>(Candidato.class);
    return new DataFileReader<>(input.toFile(), reader);
  }

  DataFileReader<Militancia> load(Path input) throws IOException {
    var reader = new SpecificDatumReader<>(Militancia.class);
    return new DataFileReader<>(input.toFile(), reader);
  }
}
