package openpolitica.jne.infogob;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;

public class MilitanciaEtl2021 {
  public static void main(String[] args) throws IOException, SQLException {
    var main = new MilitanciaExtract();
    {
      var inputCandidatos = Path.of("data/plataformaelectoral/2021-candidatos-presidenciales.avro");
      var output = Path.of("data/infogob/2021-militancia-candidatos-presidenciales.avro");

      var militancias = main.getMilitancias(inputCandidatos, main);
      main.save(output, militancias);
    }
    {
      var inputCandidatos = Path.of("data/plataformaelectoral/2021-candidatos-congresales.avro");
      var output = Path.of("data/infogob/2021-militancia-candidatos-congresales.avro");

      var militancias = main.getMilitancias(inputCandidatos, main);
      main.save(output, militancias);
    }
    {
      var inputCandidatos =
          Path.of("data/plataformaelectoral/2021-candidatos-parlamento-andino.avro");
      var output = Path.of("data/infogob/2021-militancia-candidatos-parlamento-andino.avro");

      var militancias = main.getMilitancias(inputCandidatos, main);
      main.save(output, militancias);
    }

    var load = new MilitanciaLoadSqlite();
    load.save(Path.of("data/infogob/2021-militancia-candidatos-presidenciales.avro"),
        Path.of("data/infogob/2021-militancia-candidatos-presidenciales.db"));
    load.save(Path.of("data/infogob/2021-militancia-candidatos-congresales.avro"),
        Path.of("data/infogob/2021-militancia-candidatos-congresales.db"));
    load.save(Path.of("data/infogob/2021-militancia-candidatos-parlamento-andino.avro"),
        Path.of("data/infogob/2021-militancia-candidatos-parlamento-andino.db"));
  }
}
