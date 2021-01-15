package openpolitica.jne;

import com.fasterxml.jackson.databind.JsonNode;
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

import static java.util.stream.Collectors.toList;

public class CandidatosExtract {

  static final HttpClient httpClient = HttpClient.newBuilder()
      .connectTimeout(Duration.ofMinutes(1))
      .build();
  static final ObjectMapper objectMapper = new ObjectMapper();

  final Path baseDir;

  public CandidatosExtract(Path baseDir) {
    this.baseDir = baseDir;
  }

  void start(Path outputDir, String tipo) throws IOException {
    if (Files.notExists(outputDir)) {
      Files.createDirectories(outputDir);
    }
    var exp = Files.list(baseDir.resolve("expedientes-" + tipo))
        .map(Path::getFileName)
        .map(Path::toString)
        .map(Integer::parseInt)
        .collect(toList());
    System.out.println("Orgs: " + exp.size());
    exp.forEach(orgPoliticaId -> {
      try {
        var expOrg = Files
            .readString(baseDir.resolve("expedientes-" + tipo + "/" + orgPoliticaId));
        var expJson = objectMapper.readTree(expOrg);
        var expArray = (ArrayNode) expJson;
        System.out.println("Org: " + orgPoliticaId + " - Total: " + expArray.size());
        var ids = new LinkedHashMap<Integer, JsonNode>();
        expArray.forEach(n -> {
          var hojaVidaId = n.get("idHojaVida").intValue();
          ids.put(hojaVidaId, n);
        });
        ids.entrySet().parallelStream().forEach(entry -> {
          try {
            var output = outputDir.resolve(String.valueOf(orgPoliticaId));
            if (Files.notExists(output)) {
              Files.createDirectories(output);
            }
            var hojaVidaId = entry.getKey();
            var expediente = entry.getValue();
            extract(output, hojaVidaId, orgPoliticaId, expediente);
          } catch (IOException | InterruptedException e) {
            e.printStackTrace();
          }
        });
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  void extract(Path output, int hojaVidaId, int orgPoliticoId,
      JsonNode expediente)
      throws IOException, InterruptedException {
    var url = "https://plataformaelectoral.jne.gob.pe/HojaVida/GetHVConsolidado?param="
        + hojaVidaId + "-0-" + orgPoliticoId + "-110";
    var httpRequest = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create(url))
        .build();
    var httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
    var jsonResponse = objectMapper.readTree(httpResponse.body());
    var data = (ObjectNode) jsonResponse.get("data");
    data.put("idExpediente", expediente.get("idExpediente").intValue());
    data.put("intPosicion", expediente.get("intPosicion").intValue());
    data.put("strRutaArchivo", expediente.get("strRutaArchivo").textValue());
    data.put("strEstadoExp", expediente.get("strEstadoExp").textValue());
    Files.writeString(
        output.resolve(hojaVidaId + ".json"),
        objectMapper.writer()
            .withDefaultPrettyPrinter()
            .writeValueAsString(data));
  }
}
