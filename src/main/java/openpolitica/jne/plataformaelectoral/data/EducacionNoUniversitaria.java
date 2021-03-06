/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package openpolitica.jne.plataformaelectoral.data;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EducacionNoUniversitaria extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7514362024823090983L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EducacionNoUniversitaria\",\"namespace\":\"openpolitica.jne.elecciones.data\",\"fields\":[{\"name\":\"centro_estudio\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"TXCENTROESTUDIONOUNI\"},{\"name\":\"carrera\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"concluida\",\"type\":[\"boolean\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EducacionNoUniversitaria> ENCODER =
      new BinaryMessageEncoder<EducacionNoUniversitaria>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EducacionNoUniversitaria> DECODER =
      new BinaryMessageDecoder<EducacionNoUniversitaria>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EducacionNoUniversitaria> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EducacionNoUniversitaria> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EducacionNoUniversitaria> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EducacionNoUniversitaria>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EducacionNoUniversitaria to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EducacionNoUniversitaria from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EducacionNoUniversitaria instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EducacionNoUniversitaria fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** TXCENTROESTUDIONOUNI */
   private java.lang.String centro_estudio;
   private java.lang.String carrera;
   private java.lang.Boolean concluida;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EducacionNoUniversitaria() {}

  /**
   * All-args constructor.
   * @param centro_estudio TXCENTROESTUDIONOUNI
   * @param carrera The new value for carrera
   * @param concluida The new value for concluida
   */
  public EducacionNoUniversitaria(java.lang.String centro_estudio, java.lang.String carrera, java.lang.Boolean concluida) {
    this.centro_estudio = centro_estudio;
    this.carrera = carrera;
    this.concluida = concluida;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return centro_estudio;
    case 1: return carrera;
    case 2: return concluida;
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
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'centro_estudio' field.
   * @return TXCENTROESTUDIONOUNI
   */
  public java.lang.String getCentroEstudio() {
    return centro_estudio;
  }


  /**
   * Sets the value of the 'centro_estudio' field.
   * TXCENTROESTUDIONOUNI
   * @param value the value to set.
   */
  public void setCentroEstudio(java.lang.String value) {
    this.centro_estudio = value;
  }

  /**
   * Gets the value of the 'carrera' field.
   * @return The value of the 'carrera' field.
   */
  public java.lang.String getCarrera() {
    return carrera;
  }


  /**
   * Sets the value of the 'carrera' field.
   * @param value the value to set.
   */
  public void setCarrera(java.lang.String value) {
    this.carrera = value;
  }

  /**
   * Gets the value of the 'concluida' field.
   * @return The value of the 'concluida' field.
   */
  public java.lang.Boolean getConcluida() {
    return concluida;
  }


  /**
   * Sets the value of the 'concluida' field.
   * @param value the value to set.
   */
  public void setConcluida(java.lang.Boolean value) {
    this.concluida = value;
  }

  /**
   * Creates a new EducacionNoUniversitaria RecordBuilder.
   * @return A new EducacionNoUniversitaria RecordBuilder
   */
  public static openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder newBuilder() {
    return new openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder();
  }

  /**
   * Creates a new EducacionNoUniversitaria RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EducacionNoUniversitaria RecordBuilder
   */
  public static openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder newBuilder(openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder other) {
    if (other == null) {
      return new openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder();
    } else {
      return new openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder(other);
    }
  }

  /**
   * Creates a new EducacionNoUniversitaria RecordBuilder by copying an existing EducacionNoUniversitaria instance.
   * @param other The existing instance to copy.
   * @return A new EducacionNoUniversitaria RecordBuilder
   */
  public static openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder newBuilder(openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria other) {
    if (other == null) {
      return new openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder();
    } else {
      return new openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder(other);
    }
  }

  /**
   * RecordBuilder for EducacionNoUniversitaria instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EducacionNoUniversitaria>
    implements org.apache.avro.data.RecordBuilder<EducacionNoUniversitaria> {

    /** TXCENTROESTUDIONOUNI */
    private java.lang.String centro_estudio;
    private java.lang.String carrera;
    private java.lang.Boolean concluida;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder other) {
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
    }

    /**
     * Creates a Builder by copying an existing EducacionNoUniversitaria instance
     * @param other The existing instance to copy.
     */
    private Builder(openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria other) {
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
    }

    /**
      * Gets the value of the 'centro_estudio' field.
      * TXCENTROESTUDIONOUNI
      * @return The value.
      */
    public java.lang.String getCentroEstudio() {
      return centro_estudio;
    }


    /**
      * Sets the value of the 'centro_estudio' field.
      * TXCENTROESTUDIONOUNI
      * @param value The value of 'centro_estudio'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder setCentroEstudio(java.lang.String value) {
      validate(fields()[0], value);
      this.centro_estudio = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'centro_estudio' field has been set.
      * TXCENTROESTUDIONOUNI
      * @return True if the 'centro_estudio' field has been set, false otherwise.
      */
    public boolean hasCentroEstudio() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'centro_estudio' field.
      * TXCENTROESTUDIONOUNI
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder clearCentroEstudio() {
      centro_estudio = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'carrera' field.
      * @return The value.
      */
    public java.lang.String getCarrera() {
      return carrera;
    }


    /**
      * Sets the value of the 'carrera' field.
      * @param value The value of 'carrera'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder setCarrera(java.lang.String value) {
      validate(fields()[1], value);
      this.carrera = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'carrera' field has been set.
      * @return True if the 'carrera' field has been set, false otherwise.
      */
    public boolean hasCarrera() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'carrera' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder clearCarrera() {
      carrera = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'concluida' field.
      * @return The value.
      */
    public java.lang.Boolean getConcluida() {
      return concluida;
    }


    /**
      * Sets the value of the 'concluida' field.
      * @param value The value of 'concluida'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder setConcluida(java.lang.Boolean value) {
      validate(fields()[2], value);
      this.concluida = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'concluida' field has been set.
      * @return True if the 'concluida' field has been set, false otherwise.
      */
    public boolean hasConcluida() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'concluida' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.EducacionNoUniversitaria.Builder clearConcluida() {
      concluida = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EducacionNoUniversitaria build() {
      try {
        EducacionNoUniversitaria record = new EducacionNoUniversitaria();
        record.centro_estudio = fieldSetFlags()[0] ? this.centro_estudio : (java.lang.String) defaultValue(fields()[0]);
        record.carrera = fieldSetFlags()[1] ? this.carrera : (java.lang.String) defaultValue(fields()[1]);
        record.concluida = fieldSetFlags()[2] ? this.concluida : (java.lang.Boolean) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EducacionNoUniversitaria>
    WRITER$ = (org.apache.avro.io.DatumWriter<EducacionNoUniversitaria>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EducacionNoUniversitaria>
    READER$ = (org.apache.avro.io.DatumReader<EducacionNoUniversitaria>)MODEL$.createDatumReader(SCHEMA$);

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

    if (this.concluida == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeBoolean(this.concluida);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.centro_estudio = in.readString();

      this.carrera = in.readString();

      if (in.readIndex() != 0) {
        in.readNull();
        this.concluida = null;
      } else {
        this.concluida = in.readBoolean();
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.centro_estudio = in.readString();
          break;

        case 1:
          this.carrera = in.readString();
          break;

        case 2:
          if (in.readIndex() != 0) {
            in.readNull();
            this.concluida = null;
          } else {
            this.concluida = in.readBoolean();
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










