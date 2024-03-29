/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package openpolitica.jne.infogob.data;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Cargo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7286245448099316907L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Cargo\",\"namespace\":\"openpolitica.jne.infogob.data\",\"fields\":[{\"name\":\"cargo_nombre\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"cargo_periodo\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Cargo> ENCODER =
      new BinaryMessageEncoder<Cargo>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Cargo> DECODER =
      new BinaryMessageDecoder<Cargo>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Cargo> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Cargo> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Cargo> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Cargo>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Cargo to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Cargo from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Cargo instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Cargo fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String cargo_nombre;
   private java.lang.String cargo_periodo;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Cargo() {}

  /**
   * All-args constructor.
   * @param cargo_nombre The new value for cargo_nombre
   * @param cargo_periodo The new value for cargo_periodo
   */
  public Cargo(java.lang.String cargo_nombre, java.lang.String cargo_periodo) {
    this.cargo_nombre = cargo_nombre;
    this.cargo_periodo = cargo_periodo;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return cargo_nombre;
    case 1: return cargo_periodo;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: cargo_nombre = value$ != null ? value$.toString() : null; break;
    case 1: cargo_periodo = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'cargo_nombre' field.
   * @return The value of the 'cargo_nombre' field.
   */
  public java.lang.String getCargoNombre() {
    return cargo_nombre;
  }


  /**
   * Sets the value of the 'cargo_nombre' field.
   * @param value the value to set.
   */
  public void setCargoNombre(java.lang.String value) {
    this.cargo_nombre = value;
  }

  /**
   * Gets the value of the 'cargo_periodo' field.
   * @return The value of the 'cargo_periodo' field.
   */
  public java.lang.String getCargoPeriodo() {
    return cargo_periodo;
  }


  /**
   * Sets the value of the 'cargo_periodo' field.
   * @param value the value to set.
   */
  public void setCargoPeriodo(java.lang.String value) {
    this.cargo_periodo = value;
  }

  /**
   * Creates a new Cargo RecordBuilder.
   * @return A new Cargo RecordBuilder
   */
  public static openpolitica.jne.infogob.data.Cargo.Builder newBuilder() {
    return new openpolitica.jne.infogob.data.Cargo.Builder();
  }

  /**
   * Creates a new Cargo RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Cargo RecordBuilder
   */
  public static openpolitica.jne.infogob.data.Cargo.Builder newBuilder(openpolitica.jne.infogob.data.Cargo.Builder other) {
    if (other == null) {
      return new openpolitica.jne.infogob.data.Cargo.Builder();
    } else {
      return new openpolitica.jne.infogob.data.Cargo.Builder(other);
    }
  }

  /**
   * Creates a new Cargo RecordBuilder by copying an existing Cargo instance.
   * @param other The existing instance to copy.
   * @return A new Cargo RecordBuilder
   */
  public static openpolitica.jne.infogob.data.Cargo.Builder newBuilder(openpolitica.jne.infogob.data.Cargo other) {
    if (other == null) {
      return new openpolitica.jne.infogob.data.Cargo.Builder();
    } else {
      return new openpolitica.jne.infogob.data.Cargo.Builder(other);
    }
  }

  /**
   * RecordBuilder for Cargo instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Cargo>
    implements org.apache.avro.data.RecordBuilder<Cargo> {

    private java.lang.String cargo_nombre;
    private java.lang.String cargo_periodo;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(openpolitica.jne.infogob.data.Cargo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.cargo_nombre)) {
        this.cargo_nombre = data().deepCopy(fields()[0].schema(), other.cargo_nombre);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.cargo_periodo)) {
        this.cargo_periodo = data().deepCopy(fields()[1].schema(), other.cargo_periodo);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing Cargo instance
     * @param other The existing instance to copy.
     */
    private Builder(openpolitica.jne.infogob.data.Cargo other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.cargo_nombre)) {
        this.cargo_nombre = data().deepCopy(fields()[0].schema(), other.cargo_nombre);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.cargo_periodo)) {
        this.cargo_periodo = data().deepCopy(fields()[1].schema(), other.cargo_periodo);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'cargo_nombre' field.
      * @return The value.
      */
    public java.lang.String getCargoNombre() {
      return cargo_nombre;
    }


    /**
      * Sets the value of the 'cargo_nombre' field.
      * @param value The value of 'cargo_nombre'.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Cargo.Builder setCargoNombre(java.lang.String value) {
      validate(fields()[0], value);
      this.cargo_nombre = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'cargo_nombre' field has been set.
      * @return True if the 'cargo_nombre' field has been set, false otherwise.
      */
    public boolean hasCargoNombre() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'cargo_nombre' field.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Cargo.Builder clearCargoNombre() {
      cargo_nombre = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'cargo_periodo' field.
      * @return The value.
      */
    public java.lang.String getCargoPeriodo() {
      return cargo_periodo;
    }


    /**
      * Sets the value of the 'cargo_periodo' field.
      * @param value The value of 'cargo_periodo'.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Cargo.Builder setCargoPeriodo(java.lang.String value) {
      validate(fields()[1], value);
      this.cargo_periodo = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'cargo_periodo' field has been set.
      * @return True if the 'cargo_periodo' field has been set, false otherwise.
      */
    public boolean hasCargoPeriodo() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'cargo_periodo' field.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Cargo.Builder clearCargoPeriodo() {
      cargo_periodo = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Cargo build() {
      try {
        Cargo record = new Cargo();
        record.cargo_nombre = fieldSetFlags()[0] ? this.cargo_nombre : (java.lang.String) defaultValue(fields()[0]);
        record.cargo_periodo = fieldSetFlags()[1] ? this.cargo_periodo : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Cargo>
    WRITER$ = (org.apache.avro.io.DatumWriter<Cargo>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Cargo>
    READER$ = (org.apache.avro.io.DatumReader<Cargo>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.cargo_nombre);

    out.writeString(this.cargo_periodo);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.cargo_nombre = in.readString();

      this.cargo_periodo = in.readString();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.cargo_nombre = in.readString();
          break;

        case 1:
          this.cargo_periodo = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










