/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package openpolitica.jne.elecciones.data;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** Educacion Primaria, Secundaria. EDUCACIONBASICAS */
@org.apache.avro.specific.AvroGenerated
public class EducacionBasica extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -91603210528017503L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EducacionBasica\",\"namespace\":\"openpolitica.jne.elecciones.data\",\"doc\":\"Educacion Primaria, Secundaria. EDUCACIONBASICAS\",\"fields\":[{\"name\":\"tiene_basica\",\"type\":\"boolean\",\"doc\":\"SI/NO, TXTIENEBASICA\"},{\"name\":\"tiene_primaria\",\"type\":\"boolean\",\"doc\":\"SI/NO, TXTIENEPRIMARIA\"},{\"name\":\"primaria_concluida\",\"type\":\"boolean\",\"doc\":\"SI/NO, TXCONCLUYOPRIMARIA\"},{\"name\":\"tiene_secundaria\",\"type\":\"boolean\",\"doc\":\"SI/NO, TXTIENESECUNDARIA\"},{\"name\":\"secundaria_concluida\",\"type\":\"boolean\",\"doc\":\"SI/NO, TXCONCLUYOSECUNDARIA\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EducacionBasica> ENCODER =
      new BinaryMessageEncoder<EducacionBasica>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EducacionBasica> DECODER =
      new BinaryMessageDecoder<EducacionBasica>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EducacionBasica> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EducacionBasica> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EducacionBasica> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EducacionBasica>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EducacionBasica to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EducacionBasica from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EducacionBasica instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EducacionBasica fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** SI/NO, TXTIENEBASICA */
   private boolean tiene_basica;
  /** SI/NO, TXTIENEPRIMARIA */
   private boolean tiene_primaria;
  /** SI/NO, TXCONCLUYOPRIMARIA */
   private boolean primaria_concluida;
  /** SI/NO, TXTIENESECUNDARIA */
   private boolean tiene_secundaria;
  /** SI/NO, TXCONCLUYOSECUNDARIA */
   private boolean secundaria_concluida;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EducacionBasica() {}

  /**
   * All-args constructor.
   * @param tiene_basica SI/NO, TXTIENEBASICA
   * @param tiene_primaria SI/NO, TXTIENEPRIMARIA
   * @param primaria_concluida SI/NO, TXCONCLUYOPRIMARIA
   * @param tiene_secundaria SI/NO, TXTIENESECUNDARIA
   * @param secundaria_concluida SI/NO, TXCONCLUYOSECUNDARIA
   */
  public EducacionBasica(java.lang.Boolean tiene_basica, java.lang.Boolean tiene_primaria, java.lang.Boolean primaria_concluida, java.lang.Boolean tiene_secundaria, java.lang.Boolean secundaria_concluida) {
    this.tiene_basica = tiene_basica;
    this.tiene_primaria = tiene_primaria;
    this.primaria_concluida = primaria_concluida;
    this.tiene_secundaria = tiene_secundaria;
    this.secundaria_concluida = secundaria_concluida;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return tiene_basica;
    case 1: return tiene_primaria;
    case 2: return primaria_concluida;
    case 3: return tiene_secundaria;
    case 4: return secundaria_concluida;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: tiene_basica = (java.lang.Boolean)value$; break;
    case 1: tiene_primaria = (java.lang.Boolean)value$; break;
    case 2: primaria_concluida = (java.lang.Boolean)value$; break;
    case 3: tiene_secundaria = (java.lang.Boolean)value$; break;
    case 4: secundaria_concluida = (java.lang.Boolean)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'tiene_basica' field.
   * @return SI/NO, TXTIENEBASICA
   */
  public boolean getTieneBasica() {
    return tiene_basica;
  }


  /**
   * Sets the value of the 'tiene_basica' field.
   * SI/NO, TXTIENEBASICA
   * @param value the value to set.
   */
  public void setTieneBasica(boolean value) {
    this.tiene_basica = value;
  }

  /**
   * Gets the value of the 'tiene_primaria' field.
   * @return SI/NO, TXTIENEPRIMARIA
   */
  public boolean getTienePrimaria() {
    return tiene_primaria;
  }


  /**
   * Sets the value of the 'tiene_primaria' field.
   * SI/NO, TXTIENEPRIMARIA
   * @param value the value to set.
   */
  public void setTienePrimaria(boolean value) {
    this.tiene_primaria = value;
  }

  /**
   * Gets the value of the 'primaria_concluida' field.
   * @return SI/NO, TXCONCLUYOPRIMARIA
   */
  public boolean getPrimariaConcluida() {
    return primaria_concluida;
  }


  /**
   * Sets the value of the 'primaria_concluida' field.
   * SI/NO, TXCONCLUYOPRIMARIA
   * @param value the value to set.
   */
  public void setPrimariaConcluida(boolean value) {
    this.primaria_concluida = value;
  }

  /**
   * Gets the value of the 'tiene_secundaria' field.
   * @return SI/NO, TXTIENESECUNDARIA
   */
  public boolean getTieneSecundaria() {
    return tiene_secundaria;
  }


  /**
   * Sets the value of the 'tiene_secundaria' field.
   * SI/NO, TXTIENESECUNDARIA
   * @param value the value to set.
   */
  public void setTieneSecundaria(boolean value) {
    this.tiene_secundaria = value;
  }

  /**
   * Gets the value of the 'secundaria_concluida' field.
   * @return SI/NO, TXCONCLUYOSECUNDARIA
   */
  public boolean getSecundariaConcluida() {
    return secundaria_concluida;
  }


  /**
   * Sets the value of the 'secundaria_concluida' field.
   * SI/NO, TXCONCLUYOSECUNDARIA
   * @param value the value to set.
   */
  public void setSecundariaConcluida(boolean value) {
    this.secundaria_concluida = value;
  }

  /**
   * Creates a new EducacionBasica RecordBuilder.
   * @return A new EducacionBasica RecordBuilder
   */
  public static openpolitica.jne.elecciones.data.EducacionBasica.Builder newBuilder() {
    return new openpolitica.jne.elecciones.data.EducacionBasica.Builder();
  }

  /**
   * Creates a new EducacionBasica RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EducacionBasica RecordBuilder
   */
  public static openpolitica.jne.elecciones.data.EducacionBasica.Builder newBuilder(openpolitica.jne.elecciones.data.EducacionBasica.Builder other) {
    if (other == null) {
      return new openpolitica.jne.elecciones.data.EducacionBasica.Builder();
    } else {
      return new openpolitica.jne.elecciones.data.EducacionBasica.Builder(other);
    }
  }

  /**
   * Creates a new EducacionBasica RecordBuilder by copying an existing EducacionBasica instance.
   * @param other The existing instance to copy.
   * @return A new EducacionBasica RecordBuilder
   */
  public static openpolitica.jne.elecciones.data.EducacionBasica.Builder newBuilder(openpolitica.jne.elecciones.data.EducacionBasica other) {
    if (other == null) {
      return new openpolitica.jne.elecciones.data.EducacionBasica.Builder();
    } else {
      return new openpolitica.jne.elecciones.data.EducacionBasica.Builder(other);
    }
  }

  /**
   * RecordBuilder for EducacionBasica instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EducacionBasica>
    implements org.apache.avro.data.RecordBuilder<EducacionBasica> {

    /** SI/NO, TXTIENEBASICA */
    private boolean tiene_basica;
    /** SI/NO, TXTIENEPRIMARIA */
    private boolean tiene_primaria;
    /** SI/NO, TXCONCLUYOPRIMARIA */
    private boolean primaria_concluida;
    /** SI/NO, TXTIENESECUNDARIA */
    private boolean tiene_secundaria;
    /** SI/NO, TXCONCLUYOSECUNDARIA */
    private boolean secundaria_concluida;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(openpolitica.jne.elecciones.data.EducacionBasica.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.tiene_basica)) {
        this.tiene_basica = data().deepCopy(fields()[0].schema(), other.tiene_basica);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.tiene_primaria)) {
        this.tiene_primaria = data().deepCopy(fields()[1].schema(), other.tiene_primaria);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.primaria_concluida)) {
        this.primaria_concluida = data().deepCopy(fields()[2].schema(), other.primaria_concluida);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.tiene_secundaria)) {
        this.tiene_secundaria = data().deepCopy(fields()[3].schema(), other.tiene_secundaria);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.secundaria_concluida)) {
        this.secundaria_concluida = data().deepCopy(fields()[4].schema(), other.secundaria_concluida);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing EducacionBasica instance
     * @param other The existing instance to copy.
     */
    private Builder(openpolitica.jne.elecciones.data.EducacionBasica other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.tiene_basica)) {
        this.tiene_basica = data().deepCopy(fields()[0].schema(), other.tiene_basica);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tiene_primaria)) {
        this.tiene_primaria = data().deepCopy(fields()[1].schema(), other.tiene_primaria);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.primaria_concluida)) {
        this.primaria_concluida = data().deepCopy(fields()[2].schema(), other.primaria_concluida);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.tiene_secundaria)) {
        this.tiene_secundaria = data().deepCopy(fields()[3].schema(), other.tiene_secundaria);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.secundaria_concluida)) {
        this.secundaria_concluida = data().deepCopy(fields()[4].schema(), other.secundaria_concluida);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'tiene_basica' field.
      * SI/NO, TXTIENEBASICA
      * @return The value.
      */
    public boolean getTieneBasica() {
      return tiene_basica;
    }


    /**
      * Sets the value of the 'tiene_basica' field.
      * SI/NO, TXTIENEBASICA
      * @param value The value of 'tiene_basica'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder setTieneBasica(boolean value) {
      validate(fields()[0], value);
      this.tiene_basica = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'tiene_basica' field has been set.
      * SI/NO, TXTIENEBASICA
      * @return True if the 'tiene_basica' field has been set, false otherwise.
      */
    public boolean hasTieneBasica() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'tiene_basica' field.
      * SI/NO, TXTIENEBASICA
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder clearTieneBasica() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'tiene_primaria' field.
      * SI/NO, TXTIENEPRIMARIA
      * @return The value.
      */
    public boolean getTienePrimaria() {
      return tiene_primaria;
    }


    /**
      * Sets the value of the 'tiene_primaria' field.
      * SI/NO, TXTIENEPRIMARIA
      * @param value The value of 'tiene_primaria'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder setTienePrimaria(boolean value) {
      validate(fields()[1], value);
      this.tiene_primaria = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'tiene_primaria' field has been set.
      * SI/NO, TXTIENEPRIMARIA
      * @return True if the 'tiene_primaria' field has been set, false otherwise.
      */
    public boolean hasTienePrimaria() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'tiene_primaria' field.
      * SI/NO, TXTIENEPRIMARIA
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder clearTienePrimaria() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'primaria_concluida' field.
      * SI/NO, TXCONCLUYOPRIMARIA
      * @return The value.
      */
    public boolean getPrimariaConcluida() {
      return primaria_concluida;
    }


    /**
      * Sets the value of the 'primaria_concluida' field.
      * SI/NO, TXCONCLUYOPRIMARIA
      * @param value The value of 'primaria_concluida'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder setPrimariaConcluida(boolean value) {
      validate(fields()[2], value);
      this.primaria_concluida = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'primaria_concluida' field has been set.
      * SI/NO, TXCONCLUYOPRIMARIA
      * @return True if the 'primaria_concluida' field has been set, false otherwise.
      */
    public boolean hasPrimariaConcluida() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'primaria_concluida' field.
      * SI/NO, TXCONCLUYOPRIMARIA
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder clearPrimariaConcluida() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'tiene_secundaria' field.
      * SI/NO, TXTIENESECUNDARIA
      * @return The value.
      */
    public boolean getTieneSecundaria() {
      return tiene_secundaria;
    }


    /**
      * Sets the value of the 'tiene_secundaria' field.
      * SI/NO, TXTIENESECUNDARIA
      * @param value The value of 'tiene_secundaria'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder setTieneSecundaria(boolean value) {
      validate(fields()[3], value);
      this.tiene_secundaria = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'tiene_secundaria' field has been set.
      * SI/NO, TXTIENESECUNDARIA
      * @return True if the 'tiene_secundaria' field has been set, false otherwise.
      */
    public boolean hasTieneSecundaria() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'tiene_secundaria' field.
      * SI/NO, TXTIENESECUNDARIA
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder clearTieneSecundaria() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'secundaria_concluida' field.
      * SI/NO, TXCONCLUYOSECUNDARIA
      * @return The value.
      */
    public boolean getSecundariaConcluida() {
      return secundaria_concluida;
    }


    /**
      * Sets the value of the 'secundaria_concluida' field.
      * SI/NO, TXCONCLUYOSECUNDARIA
      * @param value The value of 'secundaria_concluida'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder setSecundariaConcluida(boolean value) {
      validate(fields()[4], value);
      this.secundaria_concluida = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'secundaria_concluida' field has been set.
      * SI/NO, TXCONCLUYOSECUNDARIA
      * @return True if the 'secundaria_concluida' field has been set, false otherwise.
      */
    public boolean hasSecundariaConcluida() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'secundaria_concluida' field.
      * SI/NO, TXCONCLUYOSECUNDARIA
      * @return This builder.
      */
    public openpolitica.jne.elecciones.data.EducacionBasica.Builder clearSecundariaConcluida() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EducacionBasica build() {
      try {
        EducacionBasica record = new EducacionBasica();
        record.tiene_basica = fieldSetFlags()[0] ? this.tiene_basica : (java.lang.Boolean) defaultValue(fields()[0]);
        record.tiene_primaria = fieldSetFlags()[1] ? this.tiene_primaria : (java.lang.Boolean) defaultValue(fields()[1]);
        record.primaria_concluida = fieldSetFlags()[2] ? this.primaria_concluida : (java.lang.Boolean) defaultValue(fields()[2]);
        record.tiene_secundaria = fieldSetFlags()[3] ? this.tiene_secundaria : (java.lang.Boolean) defaultValue(fields()[3]);
        record.secundaria_concluida = fieldSetFlags()[4] ? this.secundaria_concluida : (java.lang.Boolean) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EducacionBasica>
    WRITER$ = (org.apache.avro.io.DatumWriter<EducacionBasica>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EducacionBasica>
    READER$ = (org.apache.avro.io.DatumReader<EducacionBasica>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeBoolean(this.tiene_basica);

    out.writeBoolean(this.tiene_primaria);

    out.writeBoolean(this.primaria_concluida);

    out.writeBoolean(this.tiene_secundaria);

    out.writeBoolean(this.secundaria_concluida);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.tiene_basica = in.readBoolean();

      this.tiene_primaria = in.readBoolean();

      this.primaria_concluida = in.readBoolean();

      this.tiene_secundaria = in.readBoolean();

      this.secundaria_concluida = in.readBoolean();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.tiene_basica = in.readBoolean();
          break;

        case 1:
          this.tiene_primaria = in.readBoolean();
          break;

        case 2:
          this.primaria_concluida = in.readBoolean();
          break;

        case 3:
          this.tiene_secundaria = in.readBoolean();
          break;

        case 4:
          this.secundaria_concluida = in.readBoolean();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









