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
public class Renuncia extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1380341393532105426L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Renuncia\",\"namespace\":\"openpolitica.jne.elecciones\",\"fields\":[{\"name\":\"org_politica\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"anio\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Renuncia> ENCODER =
      new BinaryMessageEncoder<Renuncia>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Renuncia> DECODER =
      new BinaryMessageDecoder<Renuncia>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Renuncia> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Renuncia> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Renuncia> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Renuncia>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Renuncia to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Renuncia from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Renuncia instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Renuncia fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String org_politica;
   private int anio;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Renuncia() {}

  /**
   * All-args constructor.
   * @param org_politica The new value for org_politica
   * @param anio The new value for anio
   */
  public Renuncia(java.lang.String org_politica, java.lang.Integer anio) {
    this.org_politica = org_politica;
    this.anio = anio;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return org_politica;
    case 1: return anio;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: org_politica = value$ != null ? value$.toString() : null; break;
    case 1: anio = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'org_politica' field.
   * @return The value of the 'org_politica' field.
   */
  public java.lang.String getOrgPolitica() {
    return org_politica;
  }


  /**
   * Sets the value of the 'org_politica' field.
   * @param value the value to set.
   */
  public void setOrgPolitica(java.lang.String value) {
    this.org_politica = value;
  }

  /**
   * Gets the value of the 'anio' field.
   * @return The value of the 'anio' field.
   */
  public int getAnio() {
    return anio;
  }


  /**
   * Sets the value of the 'anio' field.
   * @param value the value to set.
   */
  public void setAnio(int value) {
    this.anio = value;
  }

  /**
   * Creates a new Renuncia RecordBuilder.
   * @return A new Renuncia RecordBuilder
   */
  public static openpolitica.jne.elecciones.Renuncia.Builder newBuilder() {
    return new openpolitica.jne.elecciones.Renuncia.Builder();
  }

  /**
   * Creates a new Renuncia RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Renuncia RecordBuilder
   */
  public static openpolitica.jne.elecciones.Renuncia.Builder newBuilder(openpolitica.jne.elecciones.Renuncia.Builder other) {
    if (other == null) {
      return new openpolitica.jne.elecciones.Renuncia.Builder();
    } else {
      return new openpolitica.jne.elecciones.Renuncia.Builder(other);
    }
  }

  /**
   * Creates a new Renuncia RecordBuilder by copying an existing Renuncia instance.
   * @param other The existing instance to copy.
   * @return A new Renuncia RecordBuilder
   */
  public static openpolitica.jne.elecciones.Renuncia.Builder newBuilder(openpolitica.jne.elecciones.Renuncia other) {
    if (other == null) {
      return new openpolitica.jne.elecciones.Renuncia.Builder();
    } else {
      return new openpolitica.jne.elecciones.Renuncia.Builder(other);
    }
  }

  /**
   * RecordBuilder for Renuncia instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Renuncia>
    implements org.apache.avro.data.RecordBuilder<Renuncia> {

    private java.lang.String org_politica;
    private int anio;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(openpolitica.jne.elecciones.Renuncia.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.org_politica)) {
        this.org_politica = data().deepCopy(fields()[0].schema(), other.org_politica);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.anio)) {
        this.anio = data().deepCopy(fields()[1].schema(), other.anio);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing Renuncia instance
     * @param other The existing instance to copy.
     */
    private Builder(openpolitica.jne.elecciones.Renuncia other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.org_politica)) {
        this.org_politica = data().deepCopy(fields()[0].schema(), other.org_politica);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.anio)) {
        this.anio = data().deepCopy(fields()[1].schema(), other.anio);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'org_politica' field.
      * @return The value.
      */
    public java.lang.String getOrgPolitica() {
      return org_politica;
    }


    /**
      * Sets the value of the 'org_politica' field.
      * @param value The value of 'org_politica'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.Renuncia.Builder setOrgPolitica(java.lang.String value) {
      validate(fields()[0], value);
      this.org_politica = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'org_politica' field has been set.
      * @return True if the 'org_politica' field has been set, false otherwise.
      */
    public boolean hasOrgPolitica() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'org_politica' field.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.Renuncia.Builder clearOrgPolitica() {
      org_politica = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'anio' field.
      * @return The value.
      */
    public int getAnio() {
      return anio;
    }


    /**
      * Sets the value of the 'anio' field.
      * @param value The value of 'anio'.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.Renuncia.Builder setAnio(int value) {
      validate(fields()[1], value);
      this.anio = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'anio' field has been set.
      * @return True if the 'anio' field has been set, false otherwise.
      */
    public boolean hasAnio() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'anio' field.
      * @return This builder.
      */
    public openpolitica.jne.elecciones.Renuncia.Builder clearAnio() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Renuncia build() {
      try {
        Renuncia record = new Renuncia();
        record.org_politica = fieldSetFlags()[0] ? this.org_politica : (java.lang.String) defaultValue(fields()[0]);
        record.anio = fieldSetFlags()[1] ? this.anio : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Renuncia>
    WRITER$ = (org.apache.avro.io.DatumWriter<Renuncia>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Renuncia>
    READER$ = (org.apache.avro.io.DatumReader<Renuncia>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.org_politica);

    out.writeInt(this.anio);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.org_politica = in.readString();

      this.anio = in.readInt();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.org_politica = in.readString();
          break;

        case 1:
          this.anio = in.readInt();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










