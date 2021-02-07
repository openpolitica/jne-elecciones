package openpolitica.jne.elecciones;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;

public class CandidatosLoad2021 {
  public static void main(String[] args) throws IOException, SQLException {
    var baseDir = Path.of("data");

    var export = new CandidatosLoadSqlite();

    export.save(baseDir.resolve("2021-candidatos-presidenciales.avro"),
        baseDir.resolve("2021-candidatos-presidenciales.db"));

    export.save(baseDir.resolve("2021-candidatos-congresales.avro"),
        baseDir.resolve("2021-candidatos-congresales.db"));
  }
}
