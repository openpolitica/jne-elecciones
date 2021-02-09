package openpolitica.jne.plataformaelectoral;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class CandidatosEtl2021 {
  public static void main(String[] args) throws IOException, InterruptedException, SQLException {
    var baseDir = Path.of("data/plataformaelectoral");
    if (Files.notExists(baseDir)) {
      Files.createDirectories(baseDir);
    }
    var rawDir = baseDir.resolve("raw/plataformaelectoral/2021");
    if (Files.notExists(rawDir)) {
      Files.createDirectories(rawDir);
    }
    var expExtractor = new ExpedientesExtract();
    expExtractor.extract(rawDir, "presidenciales", 110, 1);
    expExtractor.extract(rawDir, "congresales", 110, 2);
    expExtractor.extract(rawDir, "parlamento-andino", 110, 3);

    var candExtractor = new CandidatosExtract(rawDir);
    candExtractor.start(rawDir.resolve("candidatos-presidenciales"), "presidenciales");
    candExtractor.start(rawDir.resolve("candidatos-congresales"), "congresales");
    candExtractor.start(rawDir.resolve("candidatos-parlamento-andino"), "parlamento-andino");

    var inputPresidenciales = rawDir.resolve("candidatos-presidenciales");
    var expInputPresidenciales = rawDir.resolve("expedientes-presidenciales.json");
    var tp = new CandidatosTransform(inputPresidenciales, expInputPresidenciales);
    var presidencialesAvro = baseDir.resolve("2021-candidatos-presidenciales.avro");

    var export = new CandidatosLoadSqlite();
    if (tp.save(presidencialesAvro, tp.load())) {
      export.save(presidencialesAvro, baseDir.resolve("2021-candidatos-presidenciales.db"));
    }

    var inputCongresales = rawDir.resolve("candidatos-congresales");
    var expInputCongresales = rawDir.resolve("expedientes-congresales.json");
    var tc = new CandidatosTransform(inputCongresales, expInputCongresales);
    var congresalesAvro = baseDir.resolve("2021-candidatos-congresales.avro");

    if (tc.save(congresalesAvro, tc.load())) {
      export.save(congresalesAvro, baseDir.resolve("2021-candidatos-congresales.db"));
    }

    var inputParlamentoAndino = rawDir.resolve("candidatos-parlamento-andino");
    var expInputParlamentoAndino = rawDir.resolve("expedientes-parlamento-andino.json");
    var tpa = new CandidatosTransform(inputParlamentoAndino, expInputParlamentoAndino);
    var parlamentoAndinoAvro = baseDir.resolve("2021-candidatos-parlamento-andino.avro");

    if (tpa.save(parlamentoAndinoAvro, tpa.load())) {
      export.save(parlamentoAndinoAvro, baseDir.resolve("2021-candidatos-parlamento-andino.db"));
    }
  }
}
