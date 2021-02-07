package openpolitica.jne.infogob;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import openpolitica.jne.infogob.data.Militancia;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MilitanciaLoadSqlite {
  static final Logger LOG = LoggerFactory.getLogger(MilitanciaLoadSqlite.class);
  static List<TableLoad> tableLoadList = List.of(
      new AfiliacionTableLoad(),
      new ProcesoElectoralTableLoad()
  );

  public MilitanciaLoadSqlite() {
  }

  public void save(Path input, Path output) throws SQLException, IOException {
    var jdbcUrl = "jdbc:sqlite:" + output.toAbsolutePath();
    try (var connection = DriverManager.getConnection(jdbcUrl)) {
      var statement = connection.createStatement();
      for (var tableLoad : tableLoadList) {
        LOG.info("Loading {}", tableLoad.tableName);
        statement.executeUpdate(tableLoad.dropTableStatement());
        statement.executeUpdate(tableLoad.createTableStatement());
        LOG.info("Table {} created", tableLoad.tableName);

        var ps = connection.prepareStatement(tableLoad.prepareStatement());
        LOG.info("Statement for {} prepared", tableLoad.tableName);

        var reader = load(input);
        while (reader.hasNext()) tableLoad.addBatch(ps, reader.next());
        LOG.info("Batch for {} ready", tableLoad.tableName);
        ps.executeBatch();
        LOG.info("Table {} updated", tableLoad.tableName);
      }
    }
  }

  DataFileReader<Militancia> load(Path input) throws IOException {
    var reader = new SpecificDatumReader<>(Militancia.class);
    return new DataFileReader<>(input.toFile(), reader);
  }

  abstract static class TableLoad {
    final String tableName;

    public TableLoad(String tableName) {
      this.tableName = tableName;
    }

    String dropTableStatement() {
      return "drop table if exists %s".formatted(tableName);
    }

    abstract String createTableStatement();

    abstract String prepareStatement();

    abstract void addBatch(PreparedStatement ps, Militancia m) throws SQLException;
  }

  static class AfiliacionTableLoad extends TableLoad {

    public AfiliacionTableLoad() {
      super("afiliacion");
    }

    @Override String createTableStatement() {
      return """
          create table %s (
            dni string,
            nombre_completo string,
            vigente boolean,
            org_politica string,
            org_politica_tipo string,
            org_politica_alcance string,
            org_politica_estado string,
            org_politica_fecha_inscripcion string,
            afiliacion_estado string,
            afiliacion_inicio string,
            afiliacion_cancelacion string,
            afiliacion_representante string,
            afiliacion_comite string
          )
          """.formatted(tableName);
    }

    @Override String prepareStatement() {
      return """
          insert into %s values (
            ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
          )
          """.formatted(tableName);
    }

    @Override void addBatch(PreparedStatement ps, Militancia m) throws SQLException {
      if (m.getFichaHistorial() != null && m.getFichaHistorial().getAfiliacionVigente() != null) {
        ps.setString(1, m.getDni());
        ps.setString(2, m.getNombreCompleto());
        ps.setBoolean(3, true);
        ps.setString(4, m.getFichaHistorial().getAfiliacionVigente().getOrgPolitica());
        ps.setString(5, m.getFichaHistorial().getAfiliacionVigente().getOrgPoliticaTipo());
        ps.setString(6, m.getFichaHistorial().getAfiliacionVigente().getOrgPoliticaAlcance());
        ps.setString(7, m.getFichaHistorial().getAfiliacionVigente().getOrgPoliticaEstado());
        ps.setString(8,
            m.getFichaHistorial().getAfiliacionVigente().getOrgPoliticaFechaInscripcion());

        ps.setString(9, m.getFichaHistorial().getAfiliacionVigente().getAfiliacionEstado());
        ps.setString(10, m.getFichaHistorial().getAfiliacionVigente().getAfiliacionInicio());
        ps.setString(11, m.getFichaHistorial().getAfiliacionVigente().getAfiliacionCancelacion());
        ps.setString(12, m.getFichaHistorial().getAfiliacionVigente().getAfiliacionRepresentante());
        ps.setString(13, m.getFichaHistorial().getAfiliacionVigente().getAfiliacionComite());

        ps.addBatch();

        for (var b : m.getFichaHistorial().getHistorialAfiliaciones()) {
          ps.setString(1, m.getDni());
          ps.setString(2, m.getNombreCompleto());
          ps.setBoolean(3, false);
          ps.setString(4, b.getOrgPolitica());
          ps.setString(5, b.getOrgPoliticaTipo());
          ps.setString(6, b.getOrgPoliticaAlcance());
          ps.setString(7, b.getOrgPoliticaEstado());
          ps.setString(8, b.getOrgPoliticaFechaInscripcion());

          ps.setString(9, b.getAfiliacionEstado());
          ps.setString(10, b.getAfiliacionInicio());
          ps.setString(11, b.getAfiliacionCancelacion());
          ps.setString(12, b.getAfiliacionRepresentante());
          ps.setString(13, b.getAfiliacionComite());

          ps.addBatch();
        }
      }
    }
  }

  static class ProcesoElectoralTableLoad extends TableLoad {

    public ProcesoElectoralTableLoad() {
      super("proceso_electoral");
    }

    @Override String createTableStatement() {
      return """
          create table %s (
            dni string,
            nombre_completo string,
            cargo string,
            proceso_electoral string,
            org_politica string,
            circunscripcion string,
            elegido string
          )
          """.formatted(tableName);
    }

    @Override String prepareStatement() {
      return """
          insert into %s values (
            ?, ?, ?, ?, ?, ?, ?
          )
          """.formatted(tableName);
    }

    @Override void addBatch(PreparedStatement ps, Militancia m) throws SQLException {
      for (var b : m.getProcesosElectorales()) {
        ps.setString(1, m.getDni());
        ps.setString(2, m.getNombreCompleto());
        ps.setString(3, b.getCargoPostulo());
        ps.setString(4, b.getProcesoElectoral());
        ps.setString(5, b.getOrgPolitica());
        ps.setString(6, b.getCircunscripcion());
        ps.setString(7, b.getElegido());

        ps.addBatch();
      }
    }
  }

  public static void main(String[] args) throws IOException, SQLException {
    var main = new MilitanciaLoadSqlite();
    main.save(Path.of("data/infogob/2021-militancia-candidatos-presidenciales.avro"),
        Path.of("data/infogob/2021-militancia-candidatos-presidenciales.db"));
    main.save(Path.of("data/infogob/2021-militancia-candidatos-congresales.avro"),
        Path.of("data/infogob/2021-militancia-candidatos-congresales.db"));
  }
}
