package openpolitica.jne.elecciones;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExpedientesExtract {

  static final HttpClient httpClient = HttpClient.newBuilder()
      .connectTimeout(Duration.ofMinutes(1))
      .build();
  static final ObjectMapper objectMapper = new ObjectMapper();

  public void extract(Path baseDir, String tipo, int idEleccion, int idCargo)
      throws IOException, InterruptedException {
    var httpRequest = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(
            "https://plataformaelectoral.jne.gob.pe/Candidato/GetExpedientesLista/" + idEleccion
                + "-" + idCargo + "-------0-"))
        .build();
    var httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
    var jsonResponse = objectMapper.readTree(httpResponse.body());
    var jsonNode = (ArrayNode) jsonResponse.get("data");
    Files.writeString(
        baseDir.resolve("expedientes-" + tipo + ".json"),
        objectMapper.writer()
            .withDefaultPrettyPrinter()
            .writeValueAsString(jsonNode));

    var expBaseDir = baseDir.resolve("expedientes-" + tipo);
    if (Files.notExists(expBaseDir)) {
      Files.createDirectories(expBaseDir);
    }
    var orgExps = new LinkedHashMap<Integer, Map<Integer, String>>();
    for (var node : jsonNode) {
      var listaSolicitudId = node.get("idSolicitudLista").intValue();
      var expedienteId = node.get("idExpediente").intValue();
      var orgPolitica = node.get("idOrganizacionPolitica").intValue();
      var url = "https://plataformaelectoral.jne.gob.pe/Candidato/GetCandidatos/" + idCargo + "-"
          + idEleccion + "-"
          + listaSolicitudId + "-" + expedienteId;
      //System.out.println(url);
      var orgExp = orgExps.get(orgPolitica);
      if (orgExp == null) {
        orgExp = new LinkedHashMap<>();
      }
      orgExp.put(expedienteId, url);
      orgExps.put(orgPolitica, orgExp);
    }

    var map = new LinkedHashMap<Integer, ArrayNode>();
    orgExps.entrySet().parallelStream().forEach(entry -> {
      var orgPolitica = entry.getKey();
      entry.getValue().forEach((expId, url) -> {
        try {
          var expHttpRequest = HttpRequest.newBuilder()
              .GET()
              .uri(URI.create(url))
              .build();
          var expHttpResponse = httpClient.send(expHttpRequest, BodyHandlers.ofString());
          var expJsonResponse = objectMapper.readTree(expHttpResponse.body());
          var array = (ArrayNode) expJsonResponse.get("data");
          var out = objectMapper.createArrayNode();
          array.forEach(n -> {
            var o = (ObjectNode) n;
            o.put("idExpediente", expId);
            out.add(o);
          });

          var result = map.get(orgPolitica);
          if (result == null) result = objectMapper.createArrayNode();
          result.addAll(out);

          map.put(orgPolitica, result);
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    });

    map.entrySet().parallelStream().forEach(entry -> {
      var orgPolitica = entry.getKey();
      var out = entry.getValue();

      try {
        var path = expBaseDir.resolve("%s".formatted(orgPolitica));
        if (Files.notExists(path)) {
          Files.createFile(path);
        }
        Files.writeString(
            path,
            objectMapper.writer()
                .withDefaultPrettyPrinter()
                .writeValueAsString(out)
        );

      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
