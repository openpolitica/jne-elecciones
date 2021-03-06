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
public class CargoEleccion extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6146607982517914898L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CargoEleccion\",\"namespace\":\"openpolitica.jne.elecciones.data\",\"fields\":[{\"name\":\"org_politica\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"TXORGPOLCARGOELEC\"},{\"name\":\"cargo\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"TXCARGOELECCION2\"},{\"name\":\"anio_desde\",\"type\":[\"int\",\"null\"],\"doc\":\"TXANIOCARGOELECDESDE\"},{\"name\":\"anio_hasta\",\"type\":[\"int\",\"null\"],\"doc\":\"TXANIOCARGOPARTIHASTA\"},{\"name\":\"hasta_actualidad\",\"type\":\"boolean\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CargoEleccion> ENCODER =
      new BinaryMessageEncoder<CargoEleccion>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CargoEleccion> DECODER =
      new BinaryMessageDecoder<CargoEleccion>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CargoEleccion> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CargoEleccion> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CargoEleccion> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CargoEleccion>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CargoEleccion to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CargoEleccion from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CargoEleccion instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CargoEleccion fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** TXORGPOLCARGOELEC */
   private java.lang.String org_politica;
  /** TXCARGOELECCION2 */
   private java.lang.String cargo;
  /** TXANIOCARGOELECDESDE */
   private java.lang.Integer anio_desde;
  /** TXANIOCARGOPARTIHASTA */
   private java.lang.Integer anio_hasta;
   private boolean hasta_actualidad;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CargoEleccion() {}

  /**
   * All-args constructor.
   * @param org_politica TXORGPOLCARGOELEC
   * @param cargo TXCARGOELECCION2
   * @param anio_desde TXANIOCARGOELECDESDE
   * @param anio_hasta TXANIOCARGOPARTIHASTA
   * @param hasta_actualidad The new value for hasta_actualidad
   */
  public CargoEleccion(java.lang.String org_politica, java.lang.String cargo, java.lang.Integer anio_desde, java.lang.Integer anio_hasta, java.lang.Boolean hasta_actualidad) {
    this.org_politica = org_politica;
    this.cargo = cargo;
    this.anio_desde = anio_desde;
    this.anio_hasta = anio_hasta;
    this.hasta_actualidad = hasta_actualidad;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return org_politica;
    case 1: return cargo;
    case 2: return anio_desde;
    case 3: return anio_hasta;
    case 4: return hasta_actualidad;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: org_politica = value$ != null ? value$.toString() : null; break;
    case 1: cargo = value$ != null ? value$.toString() : null; break;
    case 2: anio_desde = (java.lang.Integer)value$; break;
    case 3: anio_hasta = (java.lang.Integer)value$; break;
    case 4: hasta_actualidad = (java.lang.Boolean)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'org_politica' field.
   * @return TXORGPOLCARGOELEC
   */
  public java.lang.String getOrgPolitica() {
    return org_politica;
  }


  /**
   * Sets the value of the 'org_politica' field.
   * TXORGPOLCARGOELEC
   * @param value the value to set.
   */
  public void setOrgPolitica(java.lang.String value) {
    this.org_politica = value;
  }

  /**
   * Gets the value of the 'cargo' field.
   * @return TXCARGOELECCION2
   */
  public java.lang.String getCargo() {
    return cargo;
  }


  /**
   * Sets the value of the 'cargo' field.
   * TXCARGOELECCION2
   * @param value the value to set.
   */
  public void setCargo(java.lang.String value) {
    this.cargo = value;
  }

  /**
   * Gets the value of the 'anio_desde' field.
   * @return TXANIOCARGOELECDESDE
   */
  public java.lang.Integer getAnioDesde() {
    return anio_desde;
  }


  /**
   * Sets the value of the 'anio_desde' field.
   * TXANIOCARGOELECDESDE
   * @param value the value to set.
   */
  public void setAnioDesde(java.lang.Integer value) {
    this.anio_desde = value;
  }

  /**
   * Gets the value of the 'anio_hasta' field.
   * @return TXANIOCARGOPARTIHASTA
   */
  public java.lang.Integer getAnioHasta() {
    return anio_hasta;
  }


  /**
   * Sets the value of the 'anio_hasta' field.
   * TXANIOCARGOPARTIHASTA
   * @param value the value to set.
   */
  public void setAnioHasta(java.lang.Integer value) {
    this.anio_hasta = value;
  }

  /**
   * Gets the value of the 'hasta_actualidad' field.
   * @return The value of the 'hasta_actualidad' field.
   */
  public boolean getHastaActualidad() {
    return hasta_actualidad;
  }


  /**
   * Sets the value of the 'hasta_actualidad' field.
   * @param value the value to set.
   */
  public void setHastaActualidad(boolean value) {
    this.hasta_actualidad = value;
  }

  /**
   * Creates a new CargoEleccion RecordBuilder.
   * @return A new CargoEleccion RecordBuilder
   */
  public static openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder newBuilder() {
    return new openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder();
  }

  /**
   * Creates a new CargoEleccion RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CargoEleccion RecordBuilder
   */
  public static openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder newBuilder(openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder other) {
    if (other == null) {
      return new openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder();
    } else {
      return new openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder(other);
    }
  }

  /**
   * Creates a new CargoEleccion RecordBuilder by copying an existing CargoEleccion instance.
   * @param other The existing instance to copy.
   * @return A new CargoEleccion RecordBuilder
   */
  public static openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder newBuilder(openpolitica.jne.plataformaelectoral.data.CargoEleccion other) {
    if (other == null) {
      return new openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder();
    } else {
      return new openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder(other);
    }
  }

  /**
   * RecordBuilder for CargoEleccion instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CargoEleccion>
    implements org.apache.avro.data.RecordBuilder<CargoEleccion> {

    /** TXORGPOLCARGOELEC */
    private java.lang.String org_politica;
    /** TXCARGOELECCION2 */
    private java.lang.String cargo;
    /** TXANIOCARGOELECDESDE */
    private java.lang.Integer anio_desde;
    /** TXANIOCARGOPARTIHASTA */
    private java.lang.Integer anio_hasta;
    private boolean hasta_actualidad;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.org_politica)) {
        this.org_politica = data().deepCopy(fields()[0].schema(), other.org_politica);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.cargo)) {
        this.cargo = data().deepCopy(fields()[1].schema(), other.cargo);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.anio_desde)) {
        this.anio_desde = data().deepCopy(fields()[2].schema(), other.anio_desde);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.anio_hasta)) {
        this.anio_hasta = data().deepCopy(fields()[3].schema(), other.anio_hasta);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.hasta_actualidad)) {
        this.hasta_actualidad = data().deepCopy(fields()[4].schema(), other.hasta_actualidad);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing CargoEleccion instance
     * @param other The existing instance to copy.
     */
    private Builder(openpolitica.jne.plataformaelectoral.data.CargoEleccion other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.org_politica)) {
        this.org_politica = data().deepCopy(fields()[0].schema(), other.org_politica);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.cargo)) {
        this.cargo = data().deepCopy(fields()[1].schema(), other.cargo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.anio_desde)) {
        this.anio_desde = data().deepCopy(fields()[2].schema(), other.anio_desde);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.anio_hasta)) {
        this.anio_hasta = data().deepCopy(fields()[3].schema(), other.anio_hasta);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.hasta_actualidad)) {
        this.hasta_actualidad = data().deepCopy(fields()[4].schema(), other.hasta_actualidad);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'org_politica' field.
      * TXORGPOLCARGOELEC
      * @return The value.
      */
    public java.lang.String getOrgPolitica() {
      return org_politica;
    }


    /**
      * Sets the value of the 'org_politica' field.
      * TXORGPOLCARGOELEC
      * @param value The value of 'org_politica'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder setOrgPolitica(java.lang.String value) {
      validate(fields()[0], value);
      this.org_politica = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'org_politica' field has been set.
      * TXORGPOLCARGOELEC
      * @return True if the 'org_politica' field has been set, false otherwise.
      */
    public boolean hasOrgPolitica() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'org_politica' field.
      * TXORGPOLCARGOELEC
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder clearOrgPolitica() {
      org_politica = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'cargo' field.
      * TXCARGOELECCION2
      * @return The value.
      */
    public java.lang.String getCargo() {
      return cargo;
    }


    /**
      * Sets the value of the 'cargo' field.
      * TXCARGOELECCION2
      * @param value The value of 'cargo'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder setCargo(java.lang.String value) {
      validate(fields()[1], value);
      this.cargo = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'cargo' field has been set.
      * TXCARGOELECCION2
      * @return True if the 'cargo' field has been set, false otherwise.
      */
    public boolean hasCargo() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'cargo' field.
      * TXCARGOELECCION2
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder clearCargo() {
      cargo = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'anio_desde' field.
      * TXANIOCARGOELECDESDE
      * @return The value.
      */
    public java.lang.Integer getAnioDesde() {
      return anio_desde;
    }


    /**
      * Sets the value of the 'anio_desde' field.
      * TXANIOCARGOELECDESDE
      * @param value The value of 'anio_desde'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder setAnioDesde(java.lang.Integer value) {
      validate(fields()[2], value);
      this.anio_desde = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'anio_desde' field has been set.
      * TXANIOCARGOELECDESDE
      * @return True if the 'anio_desde' field has been set, false otherwise.
      */
    public boolean hasAnioDesde() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'anio_desde' field.
      * TXANIOCARGOELECDESDE
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder clearAnioDesde() {
      anio_desde = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'anio_hasta' field.
      * TXANIOCARGOPARTIHASTA
      * @return The value.
      */
    public java.lang.Integer getAnioHasta() {
      return anio_hasta;
    }


    /**
      * Sets the value of the 'anio_hasta' field.
      * TXANIOCARGOPARTIHASTA
      * @param value The value of 'anio_hasta'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder setAnioHasta(java.lang.Integer value) {
      validate(fields()[3], value);
      this.anio_hasta = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'anio_hasta' field has been set.
      * TXANIOCARGOPARTIHASTA
      * @return True if the 'anio_hasta' field has been set, false otherwise.
      */
    public boolean hasAnioHasta() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'anio_hasta' field.
      * TXANIOCARGOPARTIHASTA
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder clearAnioHasta() {
      anio_hasta = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'hasta_actualidad' field.
      * @return The value.
      */
    public boolean getHastaActualidad() {
      return hasta_actualidad;
    }


    /**
      * Sets the value of the 'hasta_actualidad' field.
      * @param value The value of 'hasta_actualidad'.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder setHastaActualidad(boolean value) {
      validate(fields()[4], value);
      this.hasta_actualidad = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'hasta_actualidad' field has been set.
      * @return True if the 'hasta_actualidad' field has been set, false otherwise.
      */
    public boolean hasHastaActualidad() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'hasta_actualidad' field.
      * @return This builder.
      */
    public openpolitica.jne.plataformaelectoral.data.CargoEleccion.Builder clearHastaActualidad() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CargoEleccion build() {
      try {
        CargoEleccion record = new CargoEleccion();
        record.org_politica = fieldSetFlags()[0] ? this.org_politica : (java.lang.String) defaultValue(fields()[0]);
        record.cargo = fieldSetFlags()[1] ? this.cargo : (java.lang.String) defaultValue(fields()[1]);
        record.anio_desde = fieldSetFlags()[2] ? this.anio_desde : (java.lang.Integer) defaultValue(fields()[2]);
        record.anio_hasta = fieldSetFlags()[3] ? this.anio_hasta : (java.lang.Integer) defaultValue(fields()[3]);
        record.hasta_actualidad = fieldSetFlags()[4] ? this.hasta_actualidad : (java.lang.Boolean) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CargoEleccion>
    WRITER$ = (org.apache.avro.io.DatumWriter<CargoEleccion>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CargoEleccion>
    READER$ = (org.apache.avro.io.DatumReader<CargoEleccion>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.org_politica);

    out.writeString(this.cargo);

    if (this.anio_desde == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeInt(this.anio_desde);
    }

    if (this.anio_hasta == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeInt(this.anio_hasta);
    }

    out.writeBoolean(this.hasta_actualidad);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.org_politica = in.readString();

      this.cargo = in.readString();

      if (in.readIndex() != 0) {
        in.readNull();
        this.anio_desde = null;
      } else {
        this.anio_desde = in.readInt();
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.anio_hasta = null;
      } else {
        this.anio_hasta = in.readInt();
      }

      this.hasta_actualidad = in.readBoolean();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.org_politica = in.readString();
          break;

        case 1:
          this.cargo = in.readString();
          break;

        case 2:
          if (in.readIndex() != 0) {
            in.readNull();
            this.anio_desde = null;
          } else {
            this.anio_desde = in.readInt();
          }
          break;

        case 3:
          if (in.readIndex() != 0) {
            in.readNull();
            this.anio_hasta = null;
          } else {
            this.anio_hasta = in.readInt();
          }
          break;

        case 4:
          this.hasta_actualidad = in.readBoolean();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










