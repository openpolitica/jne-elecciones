package openpolitica.jne.plataformaelectoral;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import openpolitica.jne.plataformaelectoral.data.BienInmueble;
import openpolitica.jne.plataformaelectoral.data.BienMueble;
import openpolitica.jne.plataformaelectoral.data.BienOtro;
import openpolitica.jne.plataformaelectoral.data.Bienes;
import openpolitica.jne.plataformaelectoral.data.Candidato;
import openpolitica.jne.plataformaelectoral.data.CargoEleccion;
import openpolitica.jne.plataformaelectoral.data.CargoPartidario;
import openpolitica.jne.plataformaelectoral.data.Educacion;
import openpolitica.jne.plataformaelectoral.data.EducacionBasica;
import openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria;
import openpolitica.jne.plataformaelectoral.data.EducacionPostgrado;
import openpolitica.jne.plataformaelectoral.data.EducacionTecnica;
import openpolitica.jne.plataformaelectoral.data.EducacionUniversitaria;
import openpolitica.jne.plataformaelectoral.data.Expediente;
import openpolitica.jne.plataformaelectoral.data.Experiencia;
import openpolitica.jne.plataformaelectoral.data.ExperienciaLaboral;
import openpolitica.jne.plataformaelectoral.data.InfoAdicional;
import openpolitica.jne.plataformaelectoral.data.Ingreso;
import openpolitica.jne.plataformaelectoral.data.Renuncia;
import openpolitica.jne.plataformaelectoral.data.SentenciaCivil;
import openpolitica.jne.plataformaelectoral.data.SentenciaPenal;
import openpolitica.jne.plataformaelectoral.data.Sentencias;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CandidatosTransform {
  static final Logger LOG = LoggerFactory.getLogger(CandidatosTransform.class);
  static final ObjectMapper mapper = new ObjectMapper();

  static int candidatosCount = 0;
  static int expLaboralCount = 0;
  static int cargoPartCount = 0;
  static int cargoElecCount = 0;

  final Path input;
  final Path expInput;

  CandidatosTransform(Path input, Path expInput) {
    this.input = input;
    this.expInput = expInput;
  }

  boolean save(Path output, List<Candidato> candidatos) throws IOException {
    var current = new ArrayList<Candidato>();
    if (Files.isRegularFile(output)) {
      var reader = load(output);
      reader.forEach(current::add);
      current.sort(Comparator.comparing(Candidato::getHojaVidaId));
      LOG.info("Candidatos actuales: " + current.size());

      candidatos.sort(Comparator.comparing(Candidato::getHojaVidaId));
      LOG.info("Candidatos obtenidos: " + candidatos.size());

      if (current.equals(candidatos)) {
        LOG.info("Candidatos obtenidos no han cambiado");
        return false;
      }
    }
    var datumWriter = new SpecificDatumWriter<>(Candidato.class);
    try (var writer = new DataFileWriter<>(datumWriter)) {
      writer.setCodec(CodecFactory.zstandardCodec(CodecFactory.DEFAULT_ZSTANDARD_LEVEL));
      writer.create(Candidato.SCHEMA$, output.toFile());

      candidatos.forEach(s -> {
        try {
          writer.append(s);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    }
    LOG.info("Candidatos: " + candidatosCount);
    return true;
  }

  public static DataFileReader<Candidato> load(Path input) throws IOException {
    var reader = new SpecificDatumReader<>(Candidato.class);
    return new DataFileReader<>(input.toFile(), reader);
  }

  Candidato map(JsonNode node, Map<Integer, Expediente.Builder> expMap) {
    // Educacion
    //// Educacion Basica
    var eduBasicaNode = node.get("oEduBasica");
    var eduBasica = EducacionBasica.newBuilder()
        .setTieneBasica(eduBasicaNode.get("strTengoEduBasica").textValue().equals("1"))
        .setTienePrimaria(eduBasicaNode.get("strEduPrimaria").textValue().equals("1"))
        .setPrimariaConcluida(eduBasicaNode.get("strConcluidoEduPrimaria").textValue().equals("1"))
        .setTieneSecundaria(eduBasicaNode.get("strEduSecundaria").textValue().equals("1"))
        .setSecundariaConcluida(
            eduBasicaNode.get("strConcluidoEduSecundaria").textValue().equals("1"))
        .build();
    //// Educacion Tecnica
    var eduTecnicaNode = node.get("oEduTecnico");
    var eduTecnica = new ArrayList<EducacionTecnica>();
    if (eduTecnicaNode.get(1) != null) {
      var strTengoEduTecnico = eduTecnicaNode.get("strTengoEduTecnico");
      var tengo = strTengoEduTecnico.textValue();
      var centroEstudio = eduTecnicaNode.get("strCenEstudioTecnico").textValue();
      var carrera = eduTecnicaNode.get("strCarreraTecnico").textValue();
      if (tengo.equals("1")) {
        eduTecnica.add(EducacionTecnica.newBuilder()
            .setCentroEstudio(centroEstudio)
            .setCarrera(carrera)
            .setConcluida(eduTecnicaNode.get("strConcluidoEduTecnico").textValue().isBlank() ? null
                : eduTecnicaNode.get("strConcluidoEduTecnico").textValue().equals("1"))
            .build());
      }
    }
    //// Educacion No Universitaria
    var eduNoUnivNode = node.get("oEduNoUniversitaria");
    var eduNoUniv = new ArrayList<EducacionNoUniversitaria>(1);
    {
      var tengo = eduNoUnivNode.get("strTengoNoUniversitaria").textValue();
      var centroEstudio = eduNoUnivNode.get("strCentroEstudioNoUni").textValue();
      var carrera = eduNoUnivNode.get("strCarreraNoUni").textValue();
      if (tengo.equals("1")) {
        eduNoUniv.add(EducacionNoUniversitaria.newBuilder()
            .setCentroEstudio(centroEstudio)
            .setCarrera(carrera)
            .setConcluida(eduNoUnivNode.get("strConcluidoNoUni").textValue().isBlank() ? null
                : eduNoUnivNode.get("strConcluidoNoUni").textValue().equals("1"))
            .build());
      }
    }
    //// Educacion Universitaria
    var eduUnivArray = (ArrayNode) node.get("lEduUniversitaria");
    var eduUniv = new ArrayList<EducacionUniversitaria>(eduUnivArray.size());
    eduUnivArray.forEach(n -> {
      var tengo = n.get("strTengoEduUniversitaria").textValue();
      var centroEstudio = n.get("strUniversidad").textValue();
      var carrera = n.get("strCarreraUni").textValue();
      if (tengo.equals("1")) {
        var strAnioBachiller = n.get("strAnioBachiller").textValue();
        var strAnioTitulo = n.get("strAnioTitulo").textValue();
        eduUniv.add(EducacionUniversitaria.newBuilder()
            .setCentroEstudio(centroEstudio)
            .setCarrera(carrera)
            .setConcluida(n.get("strConcluidoEduUni").textValue().equals("1"))
            .setBachiller(n.get("strEgresadoEduUni").textValue().equals("1"))
            .setTitulo(n.get("strBachillerEduUni").textValue().equals("1"))
            .setBachillerAnio(
                strAnioBachiller.isBlank() ? null : Integer.parseInt(strAnioBachiller))
            .setTituloAnio(strAnioTitulo.isBlank() ? null : Integer.parseInt(strAnioTitulo))
            .build());
      }
    });
    //// Educacion Postgrado
    var eduPostNode = node.get("oEduPosgrago");
    var eduPost = new ArrayList<EducacionPostgrado>(1);
    {
      var tengo = eduPostNode.get("strTengoPosgrado").textValue();
      var centroEstudio = eduPostNode.get("strCenEstudioPosgrado").textValue();
      var especialidad = eduPostNode.get("strEspecialidadPosgrado").textValue();
      if (tengo.equals("1")) {
        var strAnioPosgrado = eduPostNode.get("strAnioPosgrado").textValue();
        eduPost.add(EducacionPostgrado.newBuilder()
            .setCentroEstudio(centroEstudio)
            .setEspecialidad(especialidad)
            .setConcluida(eduPostNode.get("strConcluidoPosgrado").textValue().isBlank() ? null
                : eduPostNode.get("strConcluidoPosgrado").textValue().equals("1"))
            .setEgresado(eduPostNode.get("strEgresadoPosgrado").textValue().isBlank() ? null
                : eduPostNode.get("strEgresadoPosgrado").textValue().equals("1"))
            .setPostgradoAnio(strAnioPosgrado.isBlank() ? null : Integer.parseInt(strAnioPosgrado))
            .build());
      }
    }
    // Expediencia
    //// Experiencia Laboral
    var expLaboralArray = (ArrayNode) node.get("lExperienciaLaboral");
    var expLaboral = new ArrayList<ExperienciaLaboral>(expLaboralArray.size());
    expLaboralArray.forEach(n -> {
      var centroTrabajo = n.get("strCentroTrabajo").textValue();
      var ocupacionProfesion = n.get("strOcupacionProfesion").textValue();
      if (!centroTrabajo.isBlank() && !ocupacionProfesion.isBlank()) {
        var hasta = n.get("strAnioTrabajoHasta").textValue();

        var builder = ExperienciaLaboral.newBuilder()
            .setCentroTrabajo(centroTrabajo)
            .setOcupacionProfesion(ocupacionProfesion)
            .setItem(n.get("intItemExpeLaboral").intValue())
            .setRuc(n.get("strRucTrabajo").textValue())
            .setUbicacionDireccion(n.get("strDireccionTrabajo").textValue())
            .setUbicacionPais(n.get("strTrabajoPais").textValue())
            .setUbicacionDepartamento(n.get("strTrabajoDepartamento").textValue())
            .setUbicacionProvincia(n.get("strTrabajoProvincia").textValue())
            .setUbicacionDistrito(n.get("strTrabajoDistrito").textValue())
            .setAnioDesde(Integer.parseInt(n.get("strAnioTrabajoDesde").textValue()));
        if ("HASTA LA ACTUALIDAD".equals(hasta)) {
          builder.setHastaActualidad(true).setAnioHasta(null);
        } else {
          builder.setHastaActualidad(false).setAnioHasta(Integer.parseInt(hasta));
        }
        expLaboral.add(builder.build());
      }
    });
    //// Experiencia Cargos Elecciones
    var expCargoEleccArray = (ArrayNode) node.get("lCargoEleccion");
    var expCargoElecc = new ArrayList<CargoEleccion>(expCargoEleccArray.size());
    expCargoEleccArray.forEach(n -> {
      var tengo = n.get("strCargoEleccion").textValue();
      var orgPolitica = n.get("strOrgPolCargoElec").textValue();
      var cargo = n.get("strCargoEleccion2").textValue();
      if (tengo.equals("1")) {
        var hasta = n.get("strAnioCargoElecHasta").textValue();
        var desde = n.get("strAnioCargoElecDesde").textValue();
        var builder = CargoEleccion.newBuilder()
            .setOrgPolitica(orgPolitica)
            .setCargo(cargo)
            .setAnioDesde(desde.isBlank() ? null : Integer.parseInt(desde));
        if ("HASTA LA ACTUALIDAD".equals(hasta)) {
          builder.setHastaActualidad(true).setAnioHasta(null);
        } else {
          builder.setHastaActualidad(false)
              .setAnioHasta(hasta.isBlank() ? null : Integer.parseInt(hasta));
        }
        expCargoElecc.add(builder.build());
      }
    });
    //// Experiencia Cargo Partidarios
    var expCargoPartArray = (ArrayNode) node.get("lCargoPartidario");
    var expCargoPart = new ArrayList<CargoPartidario>(expCargoPartArray.size());
    expCargoPartArray.forEach(n -> {
      var tengo = n.get("strTengoCargoPartidario").textValue();
      var orgPolitica = n.get("strOrgPolCargoPartidario").textValue();
      var cargo = n.get("strCargoPartidario").textValue();
      if (tengo.equals("1")) {
        var hasta = n.get("strAnioCargoPartiHasta").textValue();
        var desde = n.get("strAnioCargoPartiDesde").textValue();
        var builder = CargoPartidario.newBuilder()
            .setOrgPolitica(orgPolitica)
            .setCargo(cargo)
            .setAnioDesde(desde.isBlank() ? null : Integer.parseInt(desde));
        if ("HASTA LA ACTUALIDAD".equals(hasta)) {
          builder.setHastaActualidad(true).setAnioHasta(null);
        } else {
          builder.setHastaActualidad(false)
              .setAnioHasta(hasta.isBlank() ? null : Integer.parseInt(hasta));
        }
        expCargoPart.add(builder.build());
      }
    });
    //// Experiencias Renuncias
    var expRenunciaArray = (ArrayNode) node.get("lRenunciaOP");
    var expRenuncia = new ArrayList<Renuncia>(expRenunciaArray.size());
    expRenunciaArray.forEach(n -> {
      var tengo = n.get("strTengoRenunciaOP").textValue();
      var orgPolitica = n.get("strOrgPolRenunciaOP").textValue();
      if (tengo.equals("1")) {
        expRenuncia.add(Renuncia.newBuilder()
            .setOrgPolitica(orgPolitica)
            .setAnio(Integer.parseInt(n.get("strAnioRenunciaOP").textValue()))
            .build());
      }
    });
    // Sentencias
    //// Sentencias Penales
    var sentPenalesArray = (ArrayNode) node.get("lSentenciaPenal");
    var sentPenales = new ArrayList<SentenciaPenal>(sentPenalesArray.size());
    sentPenalesArray.forEach(n -> {
      var tengo = n.get("strTengoSentenciaPenal").textValue();
      var orgJudicialPenal = n.get("strOrganoJudiPenal").textValue();
      var expPenal = n.get("strExpedientePenal").textValue();
      if (tengo.equals("1")) {
        //sentPenCount++;
        //System.out.println(n);
        sentPenales.add(SentenciaPenal.newBuilder()
            .setOrganoJudicialPenal(orgJudicialPenal)
            .setExpedientePenal(expPenal)
            .setDelitoPenal(n.get("strDelitoPenal").textValue())
            .setFalloPenal(n.get("strFalloPenal").textValue())
            .setModalidad(n.get("strModalidad").textValue())
            .setFalloCumple(n.get("strCumpleFallo").textValue())
            .setSentenciaFecha(n.get("strFechaSentenciaPenal").textValue())
            .build());
      }
    });
    //// Sentencias Civiles
    var sentCivilesArray = (ArrayNode) node.get("lSentenciaObliga");
    var sentCiviles = new ArrayList<SentenciaCivil>(sentCivilesArray.size());
    sentCivilesArray.forEach(n -> {
      var tengo = n.get("strTengoSentenciaObliga").textValue();
      var materiaSentencia = n.get("strMateriaSentencia").textValue();
      if (tengo.equals("1")) {
        //sentCivCount++;
        //System.out.println(n);
        sentCiviles.add(SentenciaCivil.newBuilder()
            .setMateriaSentencia(materiaSentencia)
            .setExpedienteObliga(
                n.get("strExpedienteObliga") != null ? n.get("strExpedienteObliga").textValue()
                    : null)
            .setOrganoJudicialObliga(
                n.get("strOrganoJuridicialObliga") != null ? n.get("strOrganoJuridicialObliga")
                    .textValue() : null)
            .setFalloObliga(n.get("strFalloObliga").textValue())
            .build());
      }
    });
    // Ingresos
    var ingNode = node.get("oIngresos");

    var remBrutaAnualPublico = ingNode.get("decRemuBrutaPublico").doubleValue();
    var remBrutaAnualPrivado = ingNode.get("decRemuBrutaPrivado").doubleValue();
    var rentaIndPublico = ingNode.get("decRentaIndividualPublico").doubleValue();
    var rentaIndPrivado = ingNode.get("decRentaIndividualPrivado").doubleValue();
    var otroPublico = ingNode.get("decOtroIngresoPublico").doubleValue();
    var otroPrivado = ingNode.get("decOtroIngresoPrivado").doubleValue();
    var totalRemBruta = remBrutaAnualPrivado + remBrutaAnualPrivado;
    var totalRenta = rentaIndPrivado + rentaIndPublico;
    var totalOtro = otroPrivado + otroPublico;
    var totalPublico = rentaIndPublico + remBrutaAnualPublico + otroPublico;
    var totalPrivado = otroPrivado + rentaIndPrivado + remBrutaAnualPrivado;
    var total = totalPublico + totalPrivado;

    var strAnioIngresos = ingNode.get("strAnioIngresos").textValue();
    var ing = Ingreso.newBuilder()
        .setAnio(strAnioIngresos.isBlank() ? null : Integer.parseInt(strAnioIngresos))
        .setRemuneracionBrutaPrivado(remBrutaAnualPrivado)
        .setRemuneracionBrutaPublico(remBrutaAnualPublico)
        .setRentaIndividualPrivado(rentaIndPrivado)
        .setRentaIndividualPublico(rentaIndPublico)
        .setOtroIngresoPrivado(otroPrivado)
        .setOtroIngresoPublico(otroPublico)
        .setTotalRemuneracionBruta(totalRemBruta)
        .setTotalRenta(totalRenta)
        .setTotalOtro(totalOtro)
        .setTotal(total)
        .setTotalPrivado(totalPrivado)
        .setTotalPublico(totalPublico)
        .build();
    // Bienes
    //// Bienes Inmuebles
    var bienesInmueblesArray = (ArrayNode) node.get("lBienInmueble");
    var bienesInmuebles = new ArrayList<BienInmueble>(bienesInmueblesArray.size());
    bienesInmueblesArray.forEach(n -> {
      var tengo = n.get("strTengoInmueble").textValue();
      var tipo = n.get("strTipoBienInmueble").textValue();
      if (tengo.equals("1")) {
        var autovaluo = n.get("decAutovaluo").doubleValue();
        bienesInmuebles.add(BienInmueble.newBuilder()
            .setAutoValuo(autovaluo)
            .setUit(n.get("decUIT").doubleValue())
            .setTipoBien(tipo)
            .setUbicacionUbigeo(n.get("strUbigeoInmueble").textValue())
            .setUbicacionPais(n.get("strInmueblePais").textValue())
            .setUbicacionDepartamento(n.get("strInmuebleDepartamento").textValue())
            .setUbicacionProvincia(n.get("strInmuebleProvincia").textValue())
            .setUbicacionDistrito(n.get("strInmuebleDistrito").textValue())
            .setUbicacionDireccion(n.get("strInmuebleDireccion").textValue())
            .setSunarpPartida(n.get("strPartidaSunarp").textValue())
            .setSunarpTiene(n.get("strFichaTomoSunarp").textValue().equals("1"))
            .setComentario(n.get("strComentario").textValue())
            .build());
      }
    });
    //// Bienes Muebles
    var bienesMueblesArray = (ArrayNode) node.get("lBienMueble");
    var bienesMuebles = new ArrayList<BienMueble>(bienesMueblesArray.size());
    bienesMueblesArray.forEach(n -> {
      var tengo = n.get("strTengoBienMueble").textValue();
      var tipo = n.get("strVehiculo").textValue();
      if (tengo.equals("1")) {
        var placa = n.get("strPlaca").textValue();
        var marca = n.get("strMarca").textValue();
        var anio = n.get("strAnio").textValue();
        var modelo = n.get("strModelo").textValue();
        var caracteristica = n.get("strCaracteristica").textValue();
        var comentario = n.get("strComentario").textValue();
        var valor = n.get("decValor").doubleValue();
        bienesMuebles.add(BienMueble.newBuilder()
            .setValor(valor)
            .setTipoVehiculo(tipo)
            .setPlaca(placa)
            .setMarca(marca)
            .setAnio(anio.isBlank() ? null : Integer.parseInt(anio))
            .setModelo(modelo)
            .setCaracteristica(caracteristica)
            .setComentario(comentario)
            .build());
      }
    });
    //// Bienes Otros
    var bienesOtrosArray = (ArrayNode) node.get("lBienMuebleOtro");
    var bienesOtros = new ArrayList<BienOtro>(bienesOtrosArray.size());
    bienesOtrosArray.forEach(n -> {
      //System.out.println(n);
      //      var tipo = n.get("TXOTROBIEN").textValue();
      //      if (!tipo.isBlank()) {
      //        var desc = Optional.ofNullable(n.get("TXDESCRIPCION")).map(JsonNode::textValue)
      //            .orElse(null);
      //        var valor = n.get("FLVALOR").doubleValue();
      //        bienesOtros.add(BienOtro.newBuilder()
      //            .setValor(valor)
      //            .setTipoBien(tipo)
      //            .setDescription(desc)
      //            .build());
      //      }
    });
    //    // Trayectorias
    //    var trayArray = (ArrayNode) node.get("TRAYECTORIA");
    //    var tray = new ArrayList<Trayectoria>(trayArray.size());
    //    trayArray.forEach(n -> {
    //      var dni = n.get("TXDNI").textValue();
    //      if (!dni.isBlank()) {
    //        tray.add(Trayectoria.newBuilder()
    //            .setDni(dni)
    //            .setEleccion(n.get("TXELECCION").textValue())
    //            .setLugar(n.get("TXLUGAR").textValue())
    //            .setCargo(n.get("TXCARGO").textValue())
    //            .setOrgPolitica(n.get("TXORGANIZACIONPOLITICA").textValue())
    //            .setResultado(n.get("TXCARGOELECTO").textValue())
    //            .build());
    //      }
    //    });
    // TODO Revocatoria
    // TODO Vacancia
    // Anotaciones Marginales
    //    var anotacionesMarginalesArray = (ArrayNode) node.get("ANOTACIONMARGINAL");
    //    var anotacionesMarginales = new ArrayList<AnotacionMarginal>(anotacionesMarginalesArray.size());
    //    anotacionesMarginalesArray.forEach(n -> {
    //      var anotacionNumero = n.get("TXNROANOTACION").textValue();
    //      if (!anotacionNumero.isBlank()) {
    //        anotacionesMarginales.add(AnotacionMarginal.newBuilder()
    //            .setAnotacionNumero(anotacionNumero)
    //            .setExpedienteNumero(n.get("TXNROEXPEDIENTE").textValue())
    //            .setInformeNumero(n.get("TXNROINFORME").textValue())
    //            .setDocumentoNumero(n.get("TXNRODOCUMENTO").textValue())
    //            .setDocumentoIdentidad(n.get("TXDOCUMENTOIDENTIDAD").textValue())
    //            .setDice(n.get("TXDICE").textValue())
    //            .setDebeDecir(n.get("TXDEBEDECIR").textValue())
    //            .build());
    //      }
    //    });
    // TODO Enlaces
    // Info Adicional
    var infoAdicNode = node.get("oInfoAdicional");
    var infoAdicional = new ArrayList<InfoAdicional>(1);
    {
      var tengo = infoAdicNode.get("strTengoInfoAdicional").textValue();
      var info = infoAdicNode.get("strInfoAdicional");
      if (tengo.equals("1")) {
        infoAdicional.add(InfoAdicional.newBuilder().setInfo(info.textValue()).build());
      }
    }
    var cargos = new LinkedHashMap<Integer, String>();
    node.get("lCargoElecPostula").forEach(n -> cargos
        .put(n.get("idCargoEleccion").intValue(), n.get("strCargoEleccion").textValue()));

    var expId = node.get("idExpediente").intValue();
    var posicion = node.get("intPosicion").intValue();
    var exp = expMap.get(expId);
    if (exp != null) {
      exp.setExpedienteEstado(node.get("strEstadoExp").textValue());
      var designadoNode = node.get("strFGDesignado");
      var designado = designadoNode != null ? designadoNode.textValue() : "";
      exp.setDesignado(designado.equals("1"));
    }
    var datos = node.get("oDatosPersonales");
    // Build candidato
    var idCargoEleccion = datos.get("idCargoEleccion").intValue();
    var idHojaVida = datos.get("idHojaVida").intValue();
    if (exp == null) {
      System.out.println("ERROR: ExpId: " + expId + " HojaVidaId: " + idHojaVida);
    }
    candidatosCount++;
    expLaboralCount = expLaboralCount + expLaboralArray.size();
    cargoElecCount = cargoElecCount + expCargoEleccArray.size();
    cargoPartCount = cargoPartCount + expCargoPartArray.size();
    return Candidato.newBuilder()
        .setHojaVidaId(idHojaVida)
        // Identificacion
        .setIdDni(
            Optional.ofNullable(datos.get("strDocumentoIdentidad"))
                .map(JsonNode::textValue)
                .filter(s -> !s.isBlank())
                .orElse(null))
        .setIdCe(
            Optional.ofNullable(datos.get("strCarneExtranjeria"))
                .map(JsonNode::textValue)
                .filter(s -> !s.isBlank())
                .orElse(null))
        .setIdNombres(datos.get("strNombres").textValue())
        .setIdApellidoPaterno(datos.get("strApellidoPaterno").textValue())
        .setIdApellidoMaterno(datos.get("strApellidoMaterno").textValue())
        .setIdSexo(datos.get("strSexo").textValue().equals("1") ? "M" : "F")
        // Nacimiento
        .setNacimientoFecha(datos.get("strFechaNacimiento").textValue())
        .setNacimientoPais(datos.get("strPaisNacimiento").textValue())
        .setNacimientoDepartamento(datos.get("strNaciDepartamento").textValue())
        .setNacimientoProvincia(datos.get("strNaciProvincia").textValue())
        .setNacimientoDistrito(datos.get("strNaciDistrito").textValue())
        .setNacimientoUbigeo(datos.get("strUbigeoNacimiento").textValue())
        // Domicilio
        .setDomicilioDepartamento(datos.get("strDomiDepartamento").textValue())
        .setDomicilioProvincia(datos.get("strDomiProvincia").textValue())
        .setDomicilioDistrito(datos.get("strDomiDistrito").textValue())
        .setDomicilioUbigeo(datos.get("strUbigeoDomicilio").textValue())
        .setDomicilioDireccion(datos.get("strDomicilioDirecc").textValue())
        // Postulacion
        .setPostulaUbigeo(datos.get("strUbigeoPostula").textValue())
        .setPostulaDepartamento(datos.get("strPostulaDepartamento").textValue())
        .setPostulaProvincia(datos.get("strPostulaProvincia").textValue())
        .setPostulaDistrito(datos.get("strPostulaDistrito").textValue())
        .setPostulaAnio(Integer.parseInt(datos.get("strAnioPostula").textValue()))
        .setCargoId(idCargoEleccion)
        .setCargoNombre(cargos.get(idCargoEleccion))
        .setCandidatoId(datos.get("idCandidato").intValue())
        .setProcesoElectoralId(datos.get("idProcesoElectoral").intValue())
        .setEstadoId(datos.get("idEstado").intValue())
        .setEstadoNombre(datos.get("strEstado").textValue())
        .setHojaVida(datos.get("strHojaVida").textValue())
        .setPosicion(posicion)
        // Otro
        .setEnlaceFoto("https://declara.jne.gob.pe" + node.get("strRutaArchivo").textValue())
        // Org Politica
        .setOrgPoliticaId(exp.getOrgPoliticaId())
        .setOrgPoliticaNombre(exp.getOrgPoliticaNombre())
        // Expediente
        .setExpedienteBuilder(exp)
        // Educacion
        .setEducacion(Educacion.newBuilder()
            .setBasica(eduBasica)
            .setTecnica(eduTecnica)
            .setNoUniversitaria(eduNoUniv)
            .setUniversitaria(eduUniv)
            .setPostgrado(eduPost)
            .build())
        // Experiencia
        .setExperiencia(Experiencia.newBuilder()
            .setLaboral(expLaboral)
            .setCargosElecciones(expCargoElecc)
            .setCargosPartidarios(expCargoPart)
            .setRenuncias(expRenuncia)
            .build())
        // Ingresos
        .setIngresos(ing)
        // Sentencias
        .setSentencias(Sentencias.newBuilder()
            .setSentenciasPenales(sentPenales)
            .setSentenciasCiviles(sentCiviles)
            .build())
        // Trayectoria
        //.setTrayectorias(tray)
        // Anotaciones Marginales
        //.setAnotacionesMarginales(anotacionesMarginales)
        // Informacion Adicional
        .setInfoAdicional(infoAdicional)
        // Bienes
        .setBienes(Bienes.newBuilder()
            .setBienesInmuebles(bienesInmuebles)
            .setBienesMuebles(bienesMuebles)
            .setBienesOtros(bienesOtros)
            .build())
        //TODO
        //        .setContraloria(List.of())
        //        .setServir(List.of())
        //        .setRedam(List.of())
        //        .setRevocatoria(List.of())
        //        .setVacancia(List.of())
        //        .setEnlaces(Enlaces.newBuilder()
        //            .setHojaVida("")
        //            .setImagen("")
        //            .setResumen("")
        //            .build())
        .build();
  }

  protected List<Candidato> load() throws IOException {
    var expJsonText = Files.readString(expInput);
    var expJsonNode = mapper.readTree(expJsonText);
    var expMap = mapExpedientes((ArrayNode) expJsonNode);

    return Files.list(input)
        .flatMap(p -> {
          try {
            return Files.list(p);
          } catch (IOException e) {
            e.printStackTrace();
            return null;
          }
        })
        .map(p -> {
          try {
            var jsonText = Files.readString(p);
            var jsonNode = mapper.readTree(jsonText);
            return map(jsonNode, expMap);
          } catch (Exception e) {
            e.printStackTrace();
            return null;
          }
        })
        .collect(Collectors.toList());
  }

  private Map<Integer, Expediente.Builder> mapExpedientes(ArrayNode expJsonNode) {
    var map = new LinkedHashMap<Integer, Expediente.Builder>();
    expJsonNode.forEach(n -> {
      var expId = n.get("idExpediente").intValue();
      var tipoEleccion = n.get("idTipoEleccion").intValue();
      var candHom = n.get("intCandHombres").intValue();
      var candMuj = n.get("intCandMujeres").intValue();
      var region = n.get("strRegion").textValue();
      var provincia = n.get("strProvincia").textValue();
      var distrito = n.get("strDistrito").textValue();
      var ubigeo = n.get("strUbigeo").textValue();
      var expCodigo = n.get("strCodExpediente").textValue();
      var expCodigoPadre = n.get("strCodExpedientePadre").textValue();
      var orgPoliticaId = n.get("idOrganizacionPolitica").intValue();
      var orgPolitica = n.get("strOrganizacionPolitica").textValue();
      var orgPoliticaTipo = n.get("strTipoOrganizacion").textValue();
      var listaSolicitudId = n.get("idSolicitudLista").intValue();
      var listaSolicitudEstado = n.get("strEstadoLista").textValue();
      var juradoElectoralId = n.get("idJuradoElectoral").intValue();
      var juradoElectoral = n.get("strJuradoElectoral").textValue();
      var juradoUbicacionId = n.get("idJuradoUbicacion").intValue();
      var distritoElectoral = n.get("strDistritoElec").textValue();
      map.put(expId, Expediente.newBuilder()
          .setExpedienteId(expId)
          .setExpedienteCodigo(expCodigo)
          .setExpedienteCodigoPadre(expCodigoPadre)
          .setTipoEleccionId(tipoEleccion)
          .setOrgPoliticaId(orgPoliticaId)
          .setOrgPoliticaNombre(orgPolitica)
          .setOrgPoliticaTipo(orgPoliticaTipo)
          .setListaSolicitudId(listaSolicitudId)
          .setListaSolicitudEstado(listaSolicitudEstado)
          .setJuradoElectoralId(juradoElectoralId)
          .setJuradoElectoralNombre(juradoElectoral)
          .setRegion(region)
          .setProvincia(provincia)
          .setDistrito(distrito)
          .setUbigeo(ubigeo)
          .setCandidatosHombres(candHom)
          .setCandidatosMujeres(candMuj)
          .setUbicacionJuradoId(juradoUbicacionId)
          .setDistritoElectoral(distritoElectoral));
    });
    return map;
  }
}
