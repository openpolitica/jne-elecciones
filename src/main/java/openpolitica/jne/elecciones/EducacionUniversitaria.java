/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package openpolitica.jne.elecciones;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EducacionUniversitaria extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 260806871304650471L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EducacionUniversitaria\",\"namespace\":\"openpolitica.jne.elecciones\",\"fields\":[{\"name\":\"centro_estudio\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"TXUNIVERSIDAD\"},{\"name\":\"carrera\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"TXCARRERAUNI\"},{\"name\":\"concluida\",\"type\":\"boolean\",\"doc\":\"SI/NO, TXCONCLUYO\"},{\"name\":\"bachiller\",\"type\":\"boolean\",\"doc\":\"SI/NO, TXBACHILLER\"},{\"name\":\"bachiller_anio\",\"type\":[\"int\",\"null\"]},{\"name\":\"titulo\",\"type\":\"boolean\",\"doc\":\"SI/NO, TXTITULO\"},{\"name\":\"titulo_anio\",\"type\":[\"int\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EducacionUniversitaria> ENCODER =
      new BinaryMessageEncoder<EducacionUniversitaria>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EducacionUniversitaria> DECODER =
      new BinaryMessageDecoder<EducacionUniversitaria>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EducacionUniversitaria> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EducacionUniversitaria> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EducacionUniversitaria> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EducacionUniversitaria>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EducacionUniversitaria to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EducacionUniversitaria from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EducacionUniversitaria instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EducacionUniversitaria fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** TXUNIVERSIDAD */
   private java.lang.String centro_estudio;
  /** TXCARRERAUNI */
   private java.lang.String carrera;
  /** SI/NO, TXCONCLUYO */
   private boolean concluida;
  /** SI/NO, TXBACHILLER */
   private boolean bachiller;
   private java.lang.Integer bachiller_anio;
  /** SI/NO, TXTITULO */
   private boolean titulo;
   private java.lang.Integer titulo_anio;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EducacionUniversitaria() {}

  /**
   * All-args constructor.
   * @param centro_estudio TXUNIVERSIDAD
   * @param carrera TXCARRERAUNI
   * @param concluida SI/NO, TXCONCLUYO
   * @param bachiller SI/NO, TXBACHILLER
   * @param bachiller_anio The new value for bachiller_anio
   * @param titulo SI/NO, TXTITULO
   * @param titulo_anio The new value for titulo_anio
   */
  public EducacionUniversitaria(java.lang.String centro_estudio, java.lang.String carrera, java.lang.Boolean concluida, java.lang.Boolean bachiller, java.lang.Integer bachiller_anio, java.lang.Boolean titulo, java.lang.Integer titulo_anio) {
    this.centro_estudio = centro_estudio;
    this.carrera = carrera;
    this.concluida = concluida;
    this.bachiller = bachiller;
    this.bachiller_anio = bachiller_anio;
    this.titulo = titulo;
    this.titulo_anio = titulo_anio;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return centro_estudio;
    case 1: return carrera;
    case 2: return concluida;
    case 3: return bachiller;
    case 4: return bachiller_anio;
    case 5: return titulo;
    case 6: return titulo_anio;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: centro_estudio = value$ != null ? value$.toString() : null; break;
    case 1: carrera = value$ != null ? value$.toString() : null; break;
    case 2: concluida = (java.lang.Boolean)value$; break;
    case 3: bachiller = (java.lang.Boolean)value$; break;
    case 4: bachiller_anio = (java.lang.Integer)value$; break;
    case 5: titulo = (java.lang.Boolean)value$; break;
    case 6: titulo_anio = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'centro_estudio' field.
   * @return TXUNIVERSIDAD
   */
  public java.lang.String getCentroEstudio() {
    return centro_estudio;
  }


  /**
   * Sets the value of the 'centro_estudio' field.
   * TXUNIVERSIDAD
   * @param value the value to set.
   */
  public void setCentroEstudio(java.lang.String value) {
    this.centro_estudio = value;
  }

  /**
   * Gets the value of the 'carrera' field.
   * @return TXCARRERAUNI
   */
  public java.lang.String getCarrera() {
    return carrera;
  }


  /**
   * Sets the value of the 'carrera' field.
   * TXCARRERAUNI
   * @param value the value to set.
   */
  public void setCarrera(java.lang.String value) {
    this.carrera = value;
  }

  /**
   * Gets the value of the 'concluida' field.
   * @return SI/NO, TXCONCLUYO
   */
  public boolean getConcluida() {
    return concluida;
  }


  /**
   * Sets the value of the 'concluida' field.
   * SI/NO, TXCONCLUYO
   * @param value the value to set.
   */
  public void setConcluida(boolean value) {
    this.concluida = value;
  }

  /**
   * Gets the value of the 'bachiller' field.
   * @return SI/NO, TXBACHILLER
   */
  public boolean getBachiller() {
    return bachiller;
  }


  /**
   * Sets the value of the 'bachiller' field.
   * SI/NO, TXBACHILLER
   * @param value the value to set.
   */
  public void setBachiller(boolean value) {
    this.bachiller = value;
  }

  /**
   * Gets the value of the 'bachiller_anio' field.
   * @return The value of the 'bachiller_anio' field.
   */
  public java.lang.Integer getBachillerAnio() {
    return bachiller_anio;
  }


  /**
   * Sets the value of the 'bachiller_anio' field.
   * @param value the value to set.
   */
  public void setBachillerAnio(java.lang.Integer value) {
    this.bachiller_anio = value;
  }

  /**
   * Gets the value of the 'titulo' field.
   * @return SI/NO, TXTITULO
   */
  public boolean getTitulo() {
    return titulo;
  }


  /**
   * Sets the value of the 'titulo' field.
   * SI/NO, TXTITULO
   * @param value the value to set.
   */
  public void setTitulo(boolean value) {
    this.titulo = value;
  }

  /**
   * Gets the value of the 'titulo_anio' field.
   * @return The value of the 'titulo_anio' field.
   */
  public java.lang.Integer getTituloAnio() {
    return titulo_anio;
  }


  /**
   * Sets the value of the 'titulo_anio' field.
   * @param value the value to set.
   */
  public void setTituloAnio(java.lang.Integer value) {
    this.titulo_anio = value;
  }

  /**
   * Creates a new EducacionUniversitaria RecordBuilder.
   * @return A new EducacionUniversitaria RecordBuilder
   */
  public static openpolitica.jne.elecciones.EducacionUniversitaria.Builder newBuilder() {
    return new openpolitica.jne.elecciones.EducacionUniversitaria.Builder();
  }

  /**
   * Creates a new EducacionUniversitaria RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EducacionUniversitaria RecordBuilder
   */
  public static openpolitica.jne.elecciones.EducacionUniversitaria.Builder newBuilder(openpolitica.jne.elecciones.EducacionUniversitaria.Builder other) {
    if (other == null) {
      return new openpolitica.jne.elecciones.EducacionUniversitaria.Builder();
    } else {
      return new openpolitica.jne.elecciones.EducacionUniversitaria.Builder(other);
    }
  }

  /**
   * Creates a new EducacionUniversitaria RecordBuilder by copying an existing EducacionUniversitaria instance.
   * @param other The existing instance to copy.
   * @return A new EducacionUniversitaria RecordBuilder
   */
  public static openpolitica.jne.elecciones.EducacionUniversitaria.Builder newBuilder(openpolitica.jne.elecciones.EducacionUniversitaria other) {
    if (other == null) {
      return new openpolitica.jne.elecciones.EducacionUniversitaria.Builder();
    } else {
      return new openpolitica.jne.elecciones.EducacionUniversitaria.Builder(other);
    }
  }

  /**
   * RecordBuilder for EducacionUniversitaria instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EducacionUniversitaria>
    implements org.apache.avro.data.RecordBuilder<EducacionUniversitaria> {

    /** TXUNIVERSIDAD */
    private java.lang.String centro_estudio;
    /** TXCARRERAUNI */
    private java.lang.String carrera;
    /** SI/NO, TXCONCLUYO */
    private boolean concluida;
    /** SI/NO, TXBACHILLER */
    private boolean bachiller;
    private java.lang.Integer bachiller_anio;
    /** SI/NO, TXTITULO */
    private boolean titulo;
    private java.lang.Integer titulo_anio;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(openpolitica.jne.elecciones.EducacionUniversitaria.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.centro_estudio)) {
        this.centro_estudio = data().deepCopy(fields()[0].schema(), other.centro_estudio);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.carrera)) {
        this.carrera = data().deepCopy(fields()[1].schema(), other.carrera);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.concluida)) {
        this.concluida = data().deepCopy(fields()[2].schema(), other.concluida);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.bachiller)) {
        this.bachiller = data().deepCopy(fields()[3].schema(), other.bachiller);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.bachiller_anio)) {
        this.bachiller_anio = data().deepCopy(fields()[4].schema(), other.bachiller_anio);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.titulo)) {
        this.titulo = data().deepCopy(fields()[5].schema(), other.titulo);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.titulo_anio)) {
        this.titulo_anio = data().deepCopy(fields()[6].schema(), other.titulo_anio);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing EducacionUniversitaria instance
     * @param other The existing instance to copy.
     */
    private Builder(openpolitica.jne.elecciones.EducacionUniversitaria other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.centro_estudio)) {
        this.centro_estudio = data().deepCopy(fields()[0].schema(), other.centro_estudio);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.carrera)) {
        this.carrera = data().deepCopy(fields()[1].schema(), other.carrera);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.concluida)) {
        this.concluida = data().deepCopy(fields()[2].schema(), other.concluida);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bachiller)) {
        this.bachiller = data().deepCopy(fields()[3].schema(), other.bachiller);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.bachiller_anio)) {
        this.bachiller_anio = data().deepCopy(fields()[4].schema(), other.bachiller_anio);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.titulo)) {
        this.titulo = data().deepCopy(fields()[5].schema(), other.titulo);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.titulo_anio)) {
        this.titulo_anio = data().deepCopy(fields()[6].schema(), other.titulo_anio);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'centro_estudio' field.
      * TXUNIVERSIDAD
      * @return The value.
      */
    public java.lang.String getCentroEstudio() {
      return centro_estudio;
    }


    /**
      * Sets the value of the 'centro_estudio' field.
      * TXUNIVERSIDAD
      * @param value The value of 'centro_estudio'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder setCentroEstudio(java.lang.String value) {
      validate(fields()[0], value);
      this.centro_estudio = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'centro_estudio' field has been set.
      * TXUNIVERSIDAD
      * @return True if the 'centro_estudio' field has been set, false otherwise.
      */
    public boolean hasCentroEstudio() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'centro_estudio' field.
      * TXUNIVERSIDAD
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder clearCentroEstudio() {
      centro_estudio = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'carrera' field.
      * TXCARRERAUNI
      * @return The value.
      */
    public java.lang.String getCarrera() {
      return carrera;
    }


    /**
      * Sets the value of the 'carrera' field.
      * TXCARRERAUNI
      * @param value The value of 'carrera'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder setCarrera(java.lang.String value) {
      validate(fields()[1], value);
      this.carrera = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'carrera' field has been set.
      * TXCARRERAUNI
      * @return True if the 'carrera' field has been set, false otherwise.
      */
    public boolean hasCarrera() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'carrera' field.
      * TXCARRERAUNI
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder clearCarrera() {
      carrera = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'concluida' field.
      * SI/NO, TXCONCLUYO
      * @return The value.
      */
    public boolean getConcluida() {
      return concluida;
    }


    /**
      * Sets the value of the 'concluida' field.
      * SI/NO, TXCONCLUYO
      * @param value The value of 'concluida'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder setConcluida(boolean value) {
      validate(fields()[2], value);
      this.concluida = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'concluida' field has been set.
      * SI/NO, TXCONCLUYO
      * @return True if the 'concluida' field has been set, false otherwise.
      */
    public boolean hasConcluida() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'concluida' field.
      * SI/NO, TXCONCLUYO
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder clearConcluida() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'bachiller' field.
      * SI/NO, TXBACHILLER
      * @return The value.
      */
    public boolean getBachiller() {
      return bachiller;
    }


    /**
      * Sets the value of the 'bachiller' field.
      * SI/NO, TXBACHILLER
      * @param value The value of 'bachiller'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder setBachiller(boolean value) {
      validate(fields()[3], value);
      this.bachiller = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'bachiller' field has been set.
      * SI/NO, TXBACHILLER
      * @return True if the 'bachiller' field has been set, false otherwise.
      */
    public boolean hasBachiller() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'bachiller' field.
      * SI/NO, TXBACHILLER
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder clearBachiller() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'bachiller_anio' field.
      * @return The value.
      */
    public java.lang.Integer getBachillerAnio() {
      return bachiller_anio;
    }


    /**
      * Sets the value of the 'bachiller_anio' field.
      * @param value The value of 'bachiller_anio'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder setBachillerAnio(java.lang.Integer value) {
      validate(fields()[4], value);
      this.bachiller_anio = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'bachiller_anio' field has been set.
      * @return True if the 'bachiller_anio' field has been set, false otherwise.
      */
    public boolean hasBachillerAnio() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'bachiller_anio' field.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder clearBachillerAnio() {
      bachiller_anio = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'titulo' field.
      * SI/NO, TXTITULO
      * @return The value.
      */
    public boolean getTitulo() {
      return titulo;
    }


    /**
      * Sets the value of the 'titulo' field.
      * SI/NO, TXTITULO
      * @param value The value of 'titulo'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder setTitulo(boolean value) {
      validate(fields()[5], value);
      this.titulo = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'titulo' field has been set.
      * SI/NO, TXTITULO
      * @return True if the 'titulo' field has been set, false otherwise.
      */
    public boolean hasTitulo() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'titulo' field.
      * SI/NO, TXTITULO
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder clearTitulo() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'titulo_anio' field.
      * @return The value.
      */
    public java.lang.Integer getTituloAnio() {
      return titulo_anio;
    }


    /**
      * Sets the value of the 'titulo_anio' field.
      * @param value The value of 'titulo_anio'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder setTituloAnio(java.lang.Integer value) {
      validate(fields()[6], value);
      this.titulo_anio = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'titulo_anio' field has been set.
      * @return True if the 'titulo_anio' field has been set, false otherwise.
      */
    public boolean hasTituloAnio() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'titulo_anio' field.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.EducacionUniversitaria.Builder clearTituloAnio() {
      titulo_anio = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EducacionUniversitaria build() {
      try {
        EducacionUniversitaria record = new EducacionUniversitaria();
        record.centro_estudio = fieldSetFlags()[0] ? this.centro_estudio : (java.lang.String) defaultValue(fields()[0]);
        record.carrera = fieldSetFlags()[1] ? this.carrera : (java.lang.String) defaultValue(fields()[1]);
        record.concluida = fieldSetFlags()[2] ? this.concluida : (java.lang.Boolean) defaultValue(fields()[2]);
        record.bachiller = fieldSetFlags()[3] ? this.bachiller : (java.lang.Boolean) defaultValue(fields()[3]);
        record.bachiller_anio = fieldSetFlags()[4] ? this.bachiller_anio : (java.lang.Integer) defaultValue(fields()[4]);
        record.titulo = fieldSetFlags()[5] ? this.titulo : (java.lang.Boolean) defaultValue(fields()[5]);
        record.titulo_anio = fieldSetFlags()[6] ? this.titulo_anio : (java.lang.Integer) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EducacionUniversitaria>
    WRITER$ = (org.apache.avro.io.DatumWriter<EducacionUniversitaria>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EducacionUniversitaria>
    READER$ = (org.apache.avro.io.DatumReader<EducacionUniversitaria>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.centro_estudio);

    out.writeString(this.carrera);

    out.writeBoolean(this.concluida);

    out.writeBoolean(this.bachiller);

    if (this.bachiller_anio == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeInt(this.bachiller_anio);
    }

    out.writeBoolean(this.titulo);

    if (this.titulo_anio == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeInt(this.titulo_anio);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.centro_estudio = in.readString();

      this.carrera = in.readString();

      this.concluida = in.readBoolean();

      this.bachiller = in.readBoolean();

      if (in.readIndex() != 0) {
        in.readNull();
        this.bachiller_anio = null;
      } else {
        this.bachiller_anio = in.readInt();
      }

      this.titulo = in.readBoolean();

      if (in.readIndex() != 0) {
        in.readNull();
        this.titulo_anio = null;
      } else {
        this.titulo_anio = in.readInt();
      }

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.centro_estudio = in.readString();
          break;

        case 1:
          this.carrera = in.readString();
          break;

        case 2:
          this.concluida = in.readBoolean();
          break;

        case 3:
          this.bachiller = in.readBoolean();
          break;

        case 4:
          if (in.readIndex() != 0) {
            in.readNull();
            this.bachiller_anio = null;
          } else {
            this.bachiller_anio = in.readInt();
          }
          break;

        case 5:
          this.titulo = in.readBoolean();
          break;

        case 6:
          if (in.readIndex() != 0) {
            in.readNull();
            this.titulo_anio = null;
          } else {
            this.titulo_anio = in.readInt();
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










