package openpolitica.jne.infogob;

import java.io.IOException;
import java.nio.file.Path;

public class MilitanciaExtract2021 {
  public static void main(String[] args) throws IOException {
    var main = new MilitanciaExtract();
    {
      var inputCandidatos = Path.of("data/2021-candidatos-presidenciales.avro");
      var output = Path.of("data/infogob/2021-militancia-candidatos-presidenciales.avro");

      var militancias = main.getMilitancias(inputCandidatos, main);
      main.save(output, militancias);
    }
    {
      var inputCandidatos = Path.of("data/2021-candidatos-congresales.avro");
      var output = Path.of("data/infogob/2021-militancia-candidatos-congresales.avro");

      var militancias = main.getMilitancias(inputCandidatos, main);
      main.save(output, militancias);
    }
  }
}
