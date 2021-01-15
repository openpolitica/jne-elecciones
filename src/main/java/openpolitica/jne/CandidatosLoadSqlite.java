package openpolitica.jne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import openpolitica.jne.elecciones.Candidato;
import openpolitica.jne.elecciones.EducacionNoUniversitaria;
import openpolitica.jne.elecciones.EducacionPostgrado;
import openpolitica.jne.elecciones.EducacionTecnica;
import openpolitica.jne.elecciones.EducacionUniversitaria;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CandidatosLoadSqlite {

  static final Logger LOG = LoggerFactory.getLogger(CandidatosLoadSqlite.class);
  static List<TableLoad> tableLoadList = List.of(
      new CandidatoTableLoad(),
      new BienesTableLoad(),
      new EducacionTableLoad(),
      new ExperienciaTableLoad(),
      new IngresoTableLoad(),
      new SentenciaCivilTableLoad(),
      new SentenciaPenalTableLoad()
  );

  public CandidatosLoadSqlite() {
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

  DataFileReader<Candidato> load(Path input) throws IOException {
    var reader = new SpecificDatumReader<>(Candidato.class);
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

    abstract void addBatch(PreparedStatement ps, Candidato c) throws SQLException;
  }

  static class CandidatoTableLoad extends TableLoad {
    public CandidatoTableLoad() {
      super("candidato");
    }

    @Override
    protected void addBatch(PreparedStatement ps, Candidato candidato)
        throws SQLException {
      ps.setInt(1, candidato.getHojaVidaId());
      ps.setString(2, candidato.getIdDni());
      ps.setString(3, candidato.getIdCe());
      ps.setString(4, candidato.getIdNombres());
      ps.setString(5, candidato.getIdApellidoPaterno());
      ps.setString(6, candidato.getIdApellidoMaterno());
      ps.setString(7, candidato.getIdSexo());
      ps.setString(8, candidato.getNacimientoFecha());
      ps.setString(9, candidato.getNacimientoPais());
      ps.setString(10, candidato.getNacimientoUbigeo());
      ps.setString(11, candidato.getNacimientoDepartamento());
      ps.setString(12, candidato.getNacimientoProvincia());
      ps.setString(13, candidato.getNacimientoDistrito());
      ps.setString(14, candidato.getDomicilioUbigeo());
      ps.setString(15, candidato.getDomicilioDepartamento());
      ps.setString(16, candidato.getDomicilioProvincia());
      ps.setString(17, candidato.getDomicilioDistrito());
      ps.setString(18, candidato.getDomicilioDireccion());
      ps.setString(19, candidato.getPostulaUbigeo());
      ps.setString(20, candidato.getPostulaDepartamento());
      ps.setString(21, candidato.getPostulaProvincia());
      ps.setString(22, candidato.getPostulaDistrito());
      ps.setInt(23, candidato.getPostulaAnio());
      ps.setInt(24, candidato.getProcesoElectoralId());
      ps.setInt(25, candidato.getCandidatoId());
      ps.setInt(26, candidato.getPosicion());
      ps.setInt(27, candidato.getCargoId());
      ps.setString(28, candidato.getCargoNombre());
      ps.setInt(29, candidato.getOrgPoliticaId());
      ps.setString(30, candidato.getOrgPoliticaNombre());
      ps.setString(31, candidato.getExpediente().getOrgPoliticaTipo());
      ps.setString(32, candidato.getHojaVida());
      ps.setInt(33, candidato.getEstadoId());
      ps.setString(34, candidato.getEstadoNombre());
      ps.setInt(35, candidato.getExpediente().getExpedienteId());
      ps.setInt(36, candidato.getExpediente().getTipoEleccionId());
      ps.setString(37, candidato.getExpediente().getExpedienteCodigo());
      ps.setString(38, candidato.getExpediente().getUbigeo());
      ps.setString(39, candidato.getExpediente().getRegion());
      ps.setString(40, candidato.getExpediente().getProvincia());
      ps.setString(41, candidato.getExpediente().getDistrito());
      ps.setInt(42, candidato.getExpediente().getListaSolicitudId());
      ps.setString(43, candidato.getExpediente().getListaSolicitudEstado());
      ps.setInt(44, candidato.getExpediente().getJuradoElectoralId());
      ps.setString(45, candidato.getExpediente().getJuradoElectoralNombre());
      ps.setInt(46, candidato.getExpediente().getCandidatosMujeres());
      ps.setInt(47, candidato.getExpediente().getCandidatosHombres());
      ps.setInt(48, candidato.getExpediente().getUbicacionJuradoId());
      ps.setString(49, candidato.getExpediente().getDistritoElectoral());

      ps.addBatch();
    }

    @Override
    protected String createTableStatement() {
      return """
          create table %s (
            hoja_vida_id int,
            id_dni string,
            id_ce string,
            id_nombres string,
            id_apellido_paterno string,
            id_apellido_materno string,
            id_sexo string,
            nacimiento_fecha string,
            nacimiento_pais string,
            nacimiento_ubigeo string,
            nacimiento_departamento string,
            nacimiento_provincia string,
            nacimiento_distrito string,
            domicilio_ubigeo string,
            domicilio_departamento string,
            domicilio_provincia string,
            domicilio_distrito string,
            domicilio_direccion string,
            postula_ubigeo string,
            postula_departamento string,
            postula_provincia string,
            postula_distrito string,
            postula_anio int,
            proceso_electoral_id int,
            candidato_id int,
            posicion int,
            cargo_id int,
            cargo_nombre string,
            org_politica_id int,
            org_politica_nombre string,
            org_politica_tipo string,
            hoja_vida string,
            estado_id int,
            estado_nombre string,
            expediente_id int,
            tipo_eleccion_id int,
            expediente_codigo string,
            exp_ubigeo string,
            exp_region string,
            exp_provincia string,
            exp_distrito string,
            lista_solicitud_id int,
            lista_solicitud_estado string,
            jurado_electoral_id int,
            jurado_electoral_nombre string,
            candidatos_mujeres int,
            candidatos_hombres int,
            ubicacion_jurado_id int,
            distrito_electoral string
          )
          """.formatted(tableName);
    }

    @Override String prepareStatement() {
      return """
          insert into %s values (
            ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
            ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
            ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
            ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
            ?, ?, ?, ?, ?, ?, ?, ?, ?
          )
          """.formatted(tableName);
    }
  }

  static class BienesTableLoad extends TableLoad {

    public BienesTableLoad() {
      super("experiencia");
    }

    @Override
    protected void addBatch(PreparedStatement ps, Candidato candidato)
        throws SQLException {
      for (var exp : candidato.getExperiencia().getLaboral()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "LABORAL");
        ps.setString(3, exp.getCentroTrabajo());
        ps.setString(4, exp.getOcupacionProfesion());
        ps.setInt(5, exp.getAnioDesde());
        if (exp.getAnioHasta() != null) {
          ps.setInt(6, exp.getAnioHasta());
        }
        ps.setBoolean(7, exp.getHastaActualidad());

        ps.addBatch();
      }

      for (var exp : candidato.getExperiencia().getCargosElecciones()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "CARGO_ELECCIONES");
        ps.setString(3, exp.getOrgPolitica());
        ps.setString(4, exp.getCargo());
        if (exp.getAnioDesde() != null) {
          ps.setInt(5, exp.getAnioDesde());
        }
        if (exp.getAnioHasta() != null) {
          ps.setInt(6, exp.getAnioHasta());
        }
        ps.setBoolean(7, exp.getHastaActualidad());

        ps.addBatch();
      }

      for (var exp : candidato.getExperiencia().getCargosPartidarios()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "CARGO_PARTIDARIO");
        ps.setString(3, exp.getOrgPolitica());
        ps.setString(4, exp.getCargo());
        if (exp.getAnioDesde() != null) {
          ps.setInt(5, exp.getAnioDesde());
        }
        if (exp.getAnioHasta() != null) {
          ps.setInt(6, exp.getAnioHasta());
        }
        ps.setBoolean(7, exp.getHastaActualidad());

        ps.addBatch();
      }
    }

    @Override
    protected String createTableStatement() {
      return """
        create table %s (
          hoja_vida_id int,
          tipo string,
          centro_trabajo_org_politica string,
          ocupacion_profesion_cargo string,
          anio_desde int,
          anio_hasta int,
          hasta_actualidad boolean
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
  }

  static class EducacionTableLoad extends TableLoad {

    public EducacionTableLoad() {
      super("educacion");
    }

    @Override
    protected void addBatch(PreparedStatement ps, Candidato candidato)
        throws SQLException {
      ps.setInt(1, candidato.getHojaVidaId());
      ps.setString(2, "BASICA");
      ps.setBoolean(3, candidato.getEducacion().getBasica().getTieneBasica());

      ps.addBatch();

      for (EducacionTecnica tecnica : candidato.getEducacion().getTecnica()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "TECNICA");
        ps.setBoolean(3, tecnica.getConcluida());
        ps.setString(4, tecnica.getCentroEstudio());
        ps.setString(5, tecnica.getCarrera());

        ps.addBatch();
      }

      for (EducacionNoUniversitaria noUniv : candidato.getEducacion().getNoUniversitaria()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "NO_UNIVERSITARIA");
        if (noUniv.getConcluida() != null) {
          ps.setBoolean(3, noUniv.getConcluida());
        }
        ps.setString(4, noUniv.getCentroEstudio());
        ps.setString(5, noUniv.getCarrera());

        ps.addBatch();
      }

      for (EducacionUniversitaria univ : candidato.getEducacion().getUniversitaria()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "UNIVERSITARIA");
        ps.setBoolean(3, univ.getConcluida());
        ps.setString(4, univ.getCentroEstudio());
        ps.setString(5, univ.getCarrera());

        ps.addBatch();
      }

      for (EducacionPostgrado post : candidato.getEducacion().getPostgrado()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "POSTGRADO");
        if (post.getConcluida() != null) {
          ps.setBoolean(3, post.getConcluida());
        }
        ps.setString(4, post.getCentroEstudio());
        ps.setString(5, post.getEspecialidad());

        ps.addBatch();
      }
    }

    @Override
    protected String createTableStatement() {
      return """
        create table %s (
          hoja_vida_id int,
          tipo string,
          concluyo boolean,
          centro_estudio string,
          carrera string
        )
        """.formatted(tableName);
    }

    @Override String prepareStatement() {
      return """
        insert into %s values (
          ?, ?, ?, ?, ?
        )
        """.formatted(tableName);
    }
  }

  static class ExperienciaTableLoad extends TableLoad {

    public ExperienciaTableLoad() {
      super("experiencia");
    }

    @Override
    protected void addBatch(PreparedStatement ps, Candidato candidato)
        throws SQLException {
      for (var exp : candidato.getExperiencia().getLaboral()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "LABORAL");
        ps.setString(3, exp.getCentroTrabajo());
        ps.setString(4, exp.getOcupacionProfesion());
        ps.setInt(5, exp.getAnioDesde());
        if (exp.getAnioHasta() != null) {
          ps.setInt(6, exp.getAnioHasta());
        }
        ps.setBoolean(7, exp.getHastaActualidad());

        ps.addBatch();
      }

      for (var exp : candidato.getExperiencia().getCargosElecciones()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "CARGO_ELECCIONES");
        ps.setString(3, exp.getOrgPolitica());
        ps.setString(4, exp.getCargo());
        if (exp.getAnioDesde() != null) {
          ps.setInt(5, exp.getAnioDesde());
        }
        if (exp.getAnioHasta() != null) {
          ps.setInt(6, exp.getAnioHasta());
        }
        ps.setBoolean(7, exp.getHastaActualidad());

        ps.addBatch();
      }

      for (var exp : candidato.getExperiencia().getCargosPartidarios()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, "CARGO_PARTIDARIO");
        ps.setString(3, exp.getOrgPolitica());
        ps.setString(4, exp.getCargo());
        if (exp.getAnioDesde() != null) {
          ps.setInt(5, exp.getAnioDesde());
        }
        if (exp.getAnioHasta() != null) {
          ps.setInt(6, exp.getAnioHasta());
        }
        ps.setBoolean(7, exp.getHastaActualidad());

        ps.addBatch();
      }
    }

    @Override
    protected String createTableStatement() {
      return """
        create table %s (
          hoja_vida_id int,
          tipo string,
          centro_trabajo_org_politica string,
          ocupacion_profesion_cargo string,
          anio_desde int,
          anio_hasta int,
          hasta_actualidad boolean
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
  }

  static class IngresoTableLoad extends TableLoad {

    public IngresoTableLoad() {
      super("ingreso");
    }

    @Override
    protected void addBatch(PreparedStatement ps, Candidato candidato)
        throws SQLException {
      var in = candidato.getIngresos();
      ps.setInt(1, candidato.getHojaVidaId());
      ps.setDouble(2, in.getRemuneracionBrutaPrivado());
      ps.setDouble(3, in.getRemuneracionBrutaPublico());
      ps.setDouble(4, in.getRentaIndividualPrivado());
      ps.setDouble(5, in.getRentaIndividualPublico());
      ps.setDouble(6, in.getOtroIngresoPrivado());
      ps.setDouble(7, in.getOtroIngresoPublico());
      ps.setDouble(8, in.getTotalRemuneracionBruta());
      ps.setDouble(9, in.getTotalRenta());
      ps.setDouble(10, in.getTotalOtro());
      ps.setDouble(11, in.getTotal());
      ps.setDouble(12, in.getTotalPrivado());
      ps.setDouble(13, in.getTotalPublico());

      ps.addBatch();
    }

    @Override String prepareStatement() {
      return """
        insert into %s values (
          ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
          ?, ?, ?
        )
        """.formatted(tableName);
    }

    @Override
    protected String createTableStatement() {
      return """
        create table %s (
          hoja_vida_id int,
          remuneracion_bruta_publico double,
          remuneracion_bruta_privado double,
          renta_individual_publico double,
          renta_individual_privado double,
          otro_ingreso_publico double,
          otro_ingreso_privado double,
          total_remuneracion_bruta double,
          total_renta double,
          total_otro double,
          total double,
          total_privado double,
          total_publico double
        )
        """.formatted(tableName);
    }
  }

  static class SentenciaCivilTableLoad extends TableLoad {

    public SentenciaCivilTableLoad() {
      super("sentencia_civil");
    }

    @Override
    protected void addBatch(PreparedStatement ps, Candidato candidato)
        throws SQLException {
      for (var sent : candidato.getSentencias().getSentenciasCiviles()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, sent.getMateriaSentencia());
        ps.setString(3, sent.getExpedienteObliga());
        ps.setString(4, sent.getOrganoJudicialObliga());
        ps.setString(5, sent.getFalloObliga());

        ps.addBatch();
      }
    }

    @Override
    protected String prepareStatement() {
      return """
        insert into %s values (
          ?, ?, ?, ?, ?
        )
        """.formatted(tableName);
    }

    @Override
    protected String createTableStatement() {
      return """
        create table %s (
          hoja_vida_id int,
          materia_sentencia string,
          expediente_obliga string,
          organo_judicial_obliga string,
          fallo_obliga string
        )
        """.formatted(tableName);
    }
  }

  static class SentenciaPenalTableLoad extends TableLoad {

    public SentenciaPenalTableLoad() {
      super("sentencia_penal");
    }

    @Override
    protected void addBatch(PreparedStatement ps, Candidato candidato)
        throws SQLException {
      for (var sent : candidato.getSentencias().getSentenciasPenales()) {
        ps.setInt(1, candidato.getHojaVidaId());
        ps.setString(2, sent.getExpedientePenal());
        ps.setString(3, sent.getOrganoJudicialPenal());
        ps.setString(4, sent.getDelitoPenal());
        ps.setString(5, sent.getFalloPenal());
        ps.setString(6, sent.getModalidad());
        ps.setString(7, sent.getFalloCumple());

        ps.addBatch();
      }
    }

    @Override
    protected String prepareStatement() {
      return """
        insert into %s values (
          ?, ?, ?, ?, ?, ?, ?
        )
        """.formatted(tableName);
    }

    @Override
    protected String createTableStatement() {
      return """
        create table %s (
          hoja_vida_id int,
          expediente_penal string,
          organo_penal_judicial string,
          delito_penal string,
          fallo_penal string,
          modalidad string,
          cumple_fallo string
        )
        """.formatted(tableName);
    }
  }
}
