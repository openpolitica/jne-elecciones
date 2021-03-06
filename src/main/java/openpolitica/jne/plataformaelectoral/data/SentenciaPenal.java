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
public class SentenciaPenal extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3387254663560348510L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SentenciaPenal\",\"namespace\":\"openpolitica.jne.elecciones.data\",\"fields\":[{\"name\":\"expediente_penal\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"organo_judicial_penal\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"delito_penal\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"fallo_penal\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"modalidad\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"fallo_cumple\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"sentencia_fecha\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SentenciaPenal> ENCODER =
      new BinaryMessageEncoder<SentenciaPenal>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SentenciaPenal> DECODER =
      new BinaryMessageDecoder<SentenciaPenal>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<SentenciaPenal> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<SentenciaPenal> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<SentenciaPenal> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SentenciaPenal>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this SentenciaPenal to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a SentenciaPenal from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a SentenciaPenal instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static SentenciaPenal fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String expediente_penal;
   private java.lang.String organo_judicial_penal;
   private java.lang.String delito_penal;
   private java.lang.String fallo_penal;
   private java.lang.String modalidad;
   private java.lang.String fallo_cumple;
   private java.lang.String sentencia_fecha;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SentenciaPenal() {}

  /**
   * All-args constructor.
   * @param expediente_penal The new value for expediente_penal
   * @param organo_judicial_penal The new value for organo_judicial_penal
   * @param delito_penal The new value for delito_penal
   * @param fallo_penal The new value for fallo_penal
   * @param modalidad The new value for modalidad
   * @param fallo_cumple The new value for fallo_cumple
   * @param sentencia_fecha The new value for sentencia_fecha
   */
  public SentenciaPenal(java.lang.String expediente_penal, java.lang.String organo_judicial_penal, java.lang.String delito_penal, java.lang.String fallo_penal, java.lang.String modalidad, java.lang.String fallo_cumple, java.lang.String sentencia_fecha) {
    this.expediente_penal = expediente_penal;
    this.organo_judicial_penal = organo_judicial_penal;
    this.delito_penal = delito_penal;
    this.fallo_penal = fallo_penal;
    this.modalidad = modalidad;
    this.fallo_cumple = fallo_cumple;
    this.sentencia_fecha = sentencia_fecha;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return expediente_penal;
    case 1: return organo_judicial_penal;
    case 2: return delito_penal;
    case 3: return fallo_penal;
    case 4: return modalidad;
    case 5: return fallo_cumple;
    case 6: return sentencia_fecha;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: expediente_penal = value$ != null ? value$.toString() : null; break;
    case 1: organo_judicial_penal = value$ != null ? value$.toString() : null; break;
    case 2: delito_penal = value$ != null ? value$.toString() : null; break;
    case 3: fallo_penal = value$ != null ? value$.toString() : null; break;
    case 4: modalidad = value$ != null ? value$.toString() : null; break;
    case 5: fallo_cumple = value$ != null ? value$.toString() : null; break;
    case 6: sentencia_fecha = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'expediente_penal' field.
   * @return The value of the 'expediente_penal' field.
   */
  public java.lang.String getExpedientePenal() {
    return expediente_penal;
  }


  /**
   * Sets the value of the 'expediente_penal' field.
   * @param value the value to set.
   */
  public void setExpedientePenal(java.lang.String value) {
    this.expediente_penal = value;
  }

  /**
   * Gets the value of the 'organo_judicial_penal' field.
   * @return The value of the 'organo_judicial_penal' field.
   */
  public java.lang.String getOrganoJudicialPenal() {
    return organo_judicial_penal;
  }


  /**
   * Sets the value of the 'organo_judicial_penal' field.
   * @param value the value to set.
   */
  public void setOrganoJudicialPenal(java.lang.String value) {
    this.organo_judicial_penal = value;
  }

  /**
   * Gets the value of the 'delito_penal' field.
   * @return The value of the 'delito_penal' field.
   */
  public java.lang.String getDelitoPenal() {
    return delito_penal;
  }


  /**
   * Sets the value of the 'delito_penal' field.
   * @param value the value to set.
   */
  public void setDelitoPenal(java.lang.String value) {
    this.delito_penal = value;
  }

  /**
   * Gets the value of the 'fallo_penal' field.
   * @return The value of the 'fallo_penal' field.
   */
  public java.lang.String getFalloPenal() {
    return fallo_penal;
  }


  /**
   * Sets the value of the 'fallo_penal' field.
   * @param value the value to set.
   */
  public void setFalloPenal(java.lang.String value) {
    this.fallo_penal = value;
  }

  /**
   * Gets the value of the 'modalidad' field.
   * @return The value of the 'modalidad' field.
   */
  public java.lang.String getModalidad() {
    return modalidad;
  }


  /**
   * Sets the value of the 'modalidad' field.
   * @param value the value to set.
   */
  public void setModalidad(java.lang.String value) {
    this.modalidad = value;
  }

  /**
   * Gets the value of the 'fallo_cumple' field.
   * @return The value of the 'fallo_cumple' field.
   */
  public java.lang.String getFalloCumple() {
    return fallo_cumple;
  }


  /**
   * Sets the value of the 'fallo_cumple' field.
   * @param value the value to set.
   */
  public void setFalloCumple(java.lang.String value) {
    this.fallo_cumple = value;
  }

  /**
   * Gets the value of the 'sentencia_fecha' field.
   * @return The value of the 'sentencia_fecha' field.
   */
  public java.lang.String getSentenciaFecha() {
    return sentencia_fecha;
  }


  /**
   * Sets the value of the 'sentencia_fecha' field.
   * @param value the value to set.
   */
  public void setSentenciaFecha(java.lang.String value) {
    this.sentencia_fecha = value;
  }

  /**
   * Creates a new SentenciaPenal RecordBuilder.
   * @return A new SentenciaPenal RecordBuilder
   */
  public static openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder newBuilder() {
    return new openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder();
  }

  /**
   * Creates a new SentenciaPenal RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SentenciaPenal RecordBuilder
   */
  public static openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder newBuilder(openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder other) {
    if (other == null) {
      return new openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder();
    } else {
      return new openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder(other);
    }
  }

  /**
   * Creates a new SentenciaPenal RecordBuilder by copying an existing SentenciaPenal instance.
   * @param other The existing instance to copy.
   * @return A new SentenciaPenal RecordBuilder
   */
  public static openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder newBuilder(openpolitica.jne.plataformaelectoral.data.SentenciaPenal other) {
    if (other == null) {
      return new openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder();
    } else {
      return new openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder(other);
    }
  }

  /**
   * RecordBuilder for SentenciaPenal instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SentenciaPenal>
    implements org.apache.avro.data.RecordBuilder<SentenciaPenal> {

    private java.lang.String expediente_penal;
    private java.lang.String organo_judicial_penal;
    private java.lang.String delito_penal;
    private java.lang.String fallo_penal;
    private java.lang.String modalidad;
    private java.lang.String fallo_cumple;
    private java.lang.String sentencia_fecha;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.expediente_penal)) {
        this.expediente_penal = data().deepCopy(fields()[0].schema(), other.expediente_penal);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.organo_judicial_penal)) {
        this.organo_judicial_penal = data().deepCopy(fields()[1].schema(), other.organo_judicial_penal);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.delito_penal)) {
        this.delito_penal = data().deepCopy(fields()[2].schema(), other.delito_penal);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.fallo_penal)) {
        this.fallo_penal = data().deepCopy(fields()[3].schema(), other.fallo_penal);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.modalidad)) {
        this.modalidad = data().deepCopy(fields()[4].schema(), other.modalidad);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.fallo_cumple)) {
        this.fallo_cumple = data().deepCopy(fields()[5].schema(), other.fallo_cumple);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.sentencia_fecha)) {
        this.sentencia_fecha = data().deepCopy(fields()[6].schema(), other.sentencia_fecha);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing SentenciaPenal instance
     * @param other The existing instance to copy.
     */
    private Builder(openpolitica.jne.plataformaelectoral.data.SentenciaPenal other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.expediente_penal)) {
        this.expediente_penal = data().deepCopy(fields()[0].schema(), other.expediente_penal);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.organo_judicial_penal)) {
        this.organo_judicial_penal = data().deepCopy(fields()[1].schema(), other.organo_judicial_penal);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.delito_penal)) {
        this.delito_penal = data().deepCopy(fields()[2].schema(), other.delito_penal);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.fallo_penal)) {
        this.fallo_penal = data().deepCopy(fields()[3].schema(), other.fallo_penal);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.modalidad)) {
        this.modalidad = data().deepCopy(fields()[4].schema(), other.modalidad);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.fallo_cumple)) {
        this.fallo_cumple = data().deepCopy(fields()[5].schema(), other.fallo_cumple);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.sentencia_fecha)) {
        this.sentencia_fecha = data().deepCopy(fields()[6].schema(), other.sentencia_fecha);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'expediente_penal' field.
      * @return The value.
      */
    public java.lang.String getExpedientePenal() {
      return expediente_penal;
    }


    /**
      * Sets the value of the 'expediente_penal' field.
      * @param value The value of 'expediente_penal'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder setExpedientePenal(java.lang.String value) {
      validate(fields()[0], value);
      this.expediente_penal = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'expediente_penal' field has been set.
      * @return True if the 'expediente_penal' field has been set, false otherwise.
      */
    public boolean hasExpedientePenal() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'expediente_penal' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder clearExpedientePenal() {
      expediente_penal = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'organo_judicial_penal' field.
      * @return The value.
      */
    public java.lang.String getOrganoJudicialPenal() {
      return organo_judicial_penal;
    }


    /**
      * Sets the value of the 'organo_judicial_penal' field.
      * @param value The value of 'organo_judicial_penal'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder setOrganoJudicialPenal(java.lang.String value) {
      validate(fields()[1], value);
      this.organo_judicial_penal = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'organo_judicial_penal' field has been set.
      * @return True if the 'organo_judicial_penal' field has been set, false otherwise.
      */
    public boolean hasOrganoJudicialPenal() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'organo_judicial_penal' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder clearOrganoJudicialPenal() {
      organo_judicial_penal = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'delito_penal' field.
      * @return The value.
      */
    public java.lang.String getDelitoPenal() {
      return delito_penal;
    }


    /**
      * Sets the value of the 'delito_penal' field.
      * @param value The value of 'delito_penal'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder setDelitoPenal(java.lang.String value) {
      validate(fields()[2], value);
      this.delito_penal = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'delito_penal' field has been set.
      * @return True if the 'delito_penal' field has been set, false otherwise.
      */
    public boolean hasDelitoPenal() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'delito_penal' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder clearDelitoPenal() {
      delito_penal = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'fallo_penal' field.
      * @return The value.
      */
    public java.lang.String getFalloPenal() {
      return fallo_penal;
    }


    /**
      * Sets the value of the 'fallo_penal' field.
      * @param value The value of 'fallo_penal'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder setFalloPenal(java.lang.String value) {
      validate(fields()[3], value);
      this.fallo_penal = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'fallo_penal' field has been set.
      * @return True if the 'fallo_penal' field has been set, false otherwise.
      */
    public boolean hasFalloPenal() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'fallo_penal' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder clearFalloPenal() {
      fallo_penal = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'modalidad' field.
      * @return The value.
      */
    public java.lang.String getModalidad() {
      return modalidad;
    }


    /**
      * Sets the value of the 'modalidad' field.
      * @param value The value of 'modalidad'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder setModalidad(java.lang.String value) {
      validate(fields()[4], value);
      this.modalidad = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'modalidad' field has been set.
      * @return True if the 'modalidad' field has been set, false otherwise.
      */
    public boolean hasModalidad() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'modalidad' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder clearModalidad() {
      modalidad = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'fallo_cumple' field.
      * @return The value.
      */
    public java.lang.String getFalloCumple() {
      return fallo_cumple;
    }


    /**
      * Sets the value of the 'fallo_cumple' field.
      * @param value The value of 'fallo_cumple'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder setFalloCumple(java.lang.String value) {
      validate(fields()[5], value);
      this.fallo_cumple = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'fallo_cumple' field has been set.
      * @return True if the 'fallo_cumple' field has been set, false otherwise.
      */
    public boolean hasFalloCumple() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'fallo_cumple' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder clearFalloCumple() {
      fallo_cumple = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'sentencia_fecha' field.
      * @return The value.
      */
    public java.lang.String getSentenciaFecha() {
      return sentencia_fecha;
    }


    /**
      * Sets the value of the 'sentencia_fecha' field.
      * @param value The value of 'sentencia_fecha'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder setSentenciaFecha(java.lang.String value) {
      validate(fields()[6], value);
      this.sentencia_fecha = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'sentencia_fecha' field has been set.
      * @return True if the 'sentencia_fecha' field has been set, false otherwise.
      */
    public boolean hasSentenciaFecha() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'sentencia_fecha' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.SentenciaPenal.Builder clearSentenciaFecha() {
      sentencia_fecha = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SentenciaPenal build() {
      try {
        SentenciaPenal record = new SentenciaPenal();
        record.expediente_penal = fieldSetFlags()[0] ? this.expediente_penal : (java.lang.String) defaultValue(fields()[0]);
        record.organo_judicial_penal = fieldSetFlags()[1] ? this.organo_judicial_penal : (java.lang.String) defaultValue(fields()[1]);
        record.delito_penal = fieldSetFlags()[2] ? this.delito_penal : (java.lang.String) defaultValue(fields()[2]);
        record.fallo_penal = fieldSetFlags()[3] ? this.fallo_penal : (java.lang.String) defaultValue(fields()[3]);
        record.modalidad = fieldSetFlags()[4] ? this.modalidad : (java.lang.String) defaultValue(fields()[4]);
        record.fallo_cumple = fieldSetFlags()[5] ? this.fallo_cumple : (java.lang.String) defaultValue(fields()[5]);
        record.sentencia_fecha = fieldSetFlags()[6] ? this.sentencia_fecha : (java.lang.String) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SentenciaPenal>
    WRITER$ = (org.apache.avro.io.DatumWriter<SentenciaPenal>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SentenciaPenal>
    READER$ = (org.apache.avro.io.DatumReader<SentenciaPenal>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.expediente_penal);

    out.writeString(this.organo_judicial_penal);

    out.writeString(this.delito_penal);

    out.writeString(this.fallo_penal);

    out.writeString(this.modalidad);

    out.writeString(this.fallo_cumple);

    out.writeString(this.sentencia_fecha);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.expediente_penal = in.readString();

      this.organo_judicial_penal = in.readString();

      this.delito_penal = in.readString();

      this.fallo_penal = in.readString();

      this.modalidad = in.readString();

      this.fallo_cumple = in.readString();

      this.sentencia_fecha = in.readString();

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.expediente_penal = in.readString();
          break;

        case 1:
          this.organo_judicial_penal = in.readString();
          break;

        case 2:
          this.delito_penal = in.readString();
          break;

        case 3:
          this.fallo_penal = in.readString();
          break;

        case 4:
          this.modalidad = in.readString();
          break;

        case 5:
          this.fallo_cumple = in.readString();
          break;

        case 6:
          this.sentencia_fecha = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










