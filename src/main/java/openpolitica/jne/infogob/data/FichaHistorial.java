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
public class FichaHistorial extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1812536832954465852L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FichaHistorial\",\"namespace\":\"openpolitica.jne.infogob.data\",\"fields\":[{\"name\":\"afiliacion_vigente\",\"type\":{\"type\":\"record\",\"name\":\"Afiliacion\",\"fields\":[{\"name\":\"org_politica\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"org_politica_estado\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"org_politica_tipo\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"org_politica_alcance\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"org_politica_fecha_inscripcion\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"default\":\"null\"},{\"name\":\"afiliacion_estado\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"afiliacion_inicio\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"afiliacion_representante\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"afiliacion_comite\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"default\":\"null\"},{\"name\":\"afiliacion_cancelacion\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"default\":\"null\"},{\"name\":\"cargos\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Cargo\",\"fields\":[{\"name\":\"cargo_nombre\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"cargo_periodo\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}}]}},{\"name\":\"historial_afiliaciones\",\"type\":{\"type\":\"array\",\"items\":\"Afiliacion\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<FichaHistorial> ENCODER =
      new BinaryMessageEncoder<FichaHistorial>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<FichaHistorial> DECODER =
      new BinaryMessageDecoder<FichaHistorial>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<FichaHistorial> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<FichaHistorial> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<FichaHistorial> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<FichaHistorial>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this FichaHistorial to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a FichaHistorial from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a FichaHistorial instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static FichaHistorial fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private openpolitica.jne.infogob.data.Afiliacion afiliacion_vigente;
   private java.util.List<openpolitica.jne.infogob.data.Afiliacion> historial_afiliaciones;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public FichaHistorial() {}

  /**
   * All-args constructor.
   * @param afiliacion_vigente The new value for afiliacion_vigente
   * @param historial_afiliaciones The new value for historial_afiliaciones
   */
  public FichaHistorial(openpolitica.jne.infogob.data.Afiliacion afiliacion_vigente, java.util.List<openpolitica.jne.infogob.data.Afiliacion> historial_afiliaciones) {
    this.afiliacion_vigente = afiliacion_vigente;
    this.historial_afiliaciones = historial_afiliaciones;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return afiliacion_vigente;
    case 1: return historial_afiliaciones;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: afiliacion_vigente = (openpolitica.jne.infogob.data.Afiliacion)value$; break;
    case 1: historial_afiliaciones = (java.util.List<openpolitica.jne.infogob.data.Afiliacion>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'afiliacion_vigente' field.
   * @return The value of the 'afiliacion_vigente' field.
   */
  public openpolitica.jne.infogob.data.Afiliacion getAfiliacionVigente() {
    return afiliacion_vigente;
  }


  /**
   * Sets the value of the 'afiliacion_vigente' field.
   * @param value the value to set.
   */
  public void setAfiliacionVigente(openpolitica.jne.infogob.data.Afiliacion value) {
    this.afiliacion_vigente = value;
  }

  /**
   * Gets the value of the 'historial_afiliaciones' field.
   * @return The value of the 'historial_afiliaciones' field.
   */
  public java.util.List<openpolitica.jne.infogob.data.Afiliacion> getHistorialAfiliaciones() {
    return historial_afiliaciones;
  }


  /**
   * Sets the value of the 'historial_afiliaciones' field.
   * @param value the value to set.
   */
  public void setHistorialAfiliaciones(java.util.List<openpolitica.jne.infogob.data.Afiliacion> value) {
    this.historial_afiliaciones = value;
  }

  /**
   * Creates a new FichaHistorial RecordBuilder.
   * @return A new FichaHistorial RecordBuilder
   */
  public static openpolitica.jne.infogob.data.FichaHistorial.Builder newBuilder() {
    return new openpolitica.jne.infogob.data.FichaHistorial.Builder();
  }

  /**
   * Creates a new FichaHistorial RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new FichaHistorial RecordBuilder
   */
  public static openpolitica.jne.infogob.data.FichaHistorial.Builder newBuilder(openpolitica.jne.infogob.data.FichaHistorial.Builder other) {
    if (other == null) {
      return new openpolitica.jne.infogob.data.FichaHistorial.Builder();
    } else {
      return new openpolitica.jne.infogob.data.FichaHistorial.Builder(other);
    }
  }

  /**
   * Creates a new FichaHistorial RecordBuilder by copying an existing FichaHistorial instance.
   * @param other The existing instance to copy.
   * @return A new FichaHistorial RecordBuilder
   */
  public static openpolitica.jne.infogob.data.FichaHistorial.Builder newBuilder(openpolitica.jne.infogob.data.FichaHistorial other) {
    if (other == null) {
      return new openpolitica.jne.infogob.data.FichaHistorial.Builder();
    } else {
      return new openpolitica.jne.infogob.data.FichaHistorial.Builder(other);
    }
  }

  /**
   * RecordBuilder for FichaHistorial instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FichaHistorial>
    implements org.apache.avro.data.RecordBuilder<FichaHistorial> {

    private openpolitica.jne.infogob.data.Afiliacion afiliacion_vigente;
    private openpolitica.jne.infogob.data.Afiliacion.Builder afiliacion_vigenteBuilder;
    private java.util.List<openpolitica.jne.infogob.data.Afiliacion> historial_afiliaciones;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(openpolitica.jne.infogob.data.FichaHistorial.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.afiliacion_vigente)) {
        this.afiliacion_vigente = data().deepCopy(fields()[0].schema(), other.afiliacion_vigente);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (other.hasAfiliacionVigenteBuilder()) {
        this.afiliacion_vigenteBuilder = openpolitica.jne.infogob.data.Afiliacion.newBuilder(other.getAfiliacionVigenteBuilder());
      }
      if (isValidValue(fields()[1], other.historial_afiliaciones)) {
        this.historial_afiliaciones = data().deepCopy(fields()[1].schema(), other.historial_afiliaciones);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing FichaHistorial instance
     * @param other The existing instance to copy.
     */
    private Builder(openpolitica.jne.infogob.data.FichaHistorial other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.afiliacion_vigente)) {
        this.afiliacion_vigente = data().deepCopy(fields()[0].schema(), other.afiliacion_vigente);
        fieldSetFlags()[0] = true;
      }
      this.afiliacion_vigenteBuilder = null;
      if (isValidValue(fields()[1], other.historial_afiliaciones)) {
        this.historial_afiliaciones = data().deepCopy(fields()[1].schema(), other.historial_afiliaciones);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'afiliacion_vigente' field.
      * @return The value.
      */
    public openpolitica.jne.infogob.data.Afiliacion getAfiliacionVigente() {
      return afiliacion_vigente;
    }


    /**
      * Sets the value of the 'afiliacion_vigente' field.
      * @param value The value of 'afiliacion_vigente'.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.FichaHistorial.Builder setAfiliacionVigente(openpolitica.jne.infogob.data.Afiliacion value) {
      validate(fields()[0], value);
      this.afiliacion_vigenteBuilder = null;
      this.afiliacion_vigente = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'afiliacion_vigente' field has been set.
      * @return True if the 'afiliacion_vigente' field has been set, false otherwise.
      */
    public boolean hasAfiliacionVigente() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'afiliacion_vigente' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public openpolitica.jne.infogob.data.Afiliacion.Builder getAfiliacionVigenteBuilder() {
      if (afiliacion_vigenteBuilder == null) {
        if (hasAfiliacionVigente()) {
          setAfiliacionVigenteBuilder(openpolitica.jne.infogob.data.Afiliacion.newBuilder(afiliacion_vigente));
        } else {
          setAfiliacionVigenteBuilder(openpolitica.jne.infogob.data.Afiliacion.newBuilder());
        }
      }
      return afiliacion_vigenteBuilder;
    }

    /**
     * Sets the Builder instance for the 'afiliacion_vigente' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public openpolitica.jne.infogob.data.FichaHistorial.Builder setAfiliacionVigenteBuilder(openpolitica.jne.infogob.data.Afiliacion.Builder value) {
      clearAfiliacionVigente();
      afiliacion_vigenteBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'afiliacion_vigente' field has an active Builder instance
     * @return True if the 'afiliacion_vigente' field has an active Builder instance
     */
    public boolean hasAfiliacionVigenteBuilder() {
      return afiliacion_vigenteBuilder != null;
    }

    /**
      * Clears the value of the 'afiliacion_vigente' field.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.FichaHistorial.Builder clearAfiliacionVigente() {
      afiliacion_vigente = null;
      afiliacion_vigenteBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'historial_afiliaciones' field.
      * @return The value.
      */
    public java.util.List<openpolitica.jne.infogob.data.Afiliacion> getHistorialAfiliaciones() {
      return historial_afiliaciones;
    }


    /**
      * Sets the value of the 'historial_afiliaciones' field.
      * @param value The value of 'historial_afiliaciones'.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.FichaHistorial.Builder setHistorialAfiliaciones(java.util.List<openpolitica.jne.infogob.data.Afiliacion> value) {
      validate(fields()[1], value);
      this.historial_afiliaciones = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'historial_afiliaciones' field has been set.
      * @return True if the 'historial_afiliaciones' field has been set, false otherwise.
      */
    public boolean hasHistorialAfiliaciones() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'historial_afiliaciones' field.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.FichaHistorial.Builder clearHistorialAfiliaciones() {
      historial_afiliaciones = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public FichaHistorial build() {
      try {
        FichaHistorial record = new FichaHistorial();
        if (afiliacion_vigenteBuilder != null) {
          try {
            record.afiliacion_vigente = this.afiliacion_vigenteBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("afiliacion_vigente"));
            throw e;
          }
        } else {
          record.afiliacion_vigente = fieldSetFlags()[0] ? this.afiliacion_vigente : (openpolitica.jne.infogob.data.Afiliacion) defaultValue(fields()[0]);
        }
        record.historial_afiliaciones = fieldSetFlags()[1] ? this.historial_afiliaciones : (java.util.List<openpolitica.jne.infogob.data.Afiliacion>) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<FichaHistorial>
    WRITER$ = (org.apache.avro.io.DatumWriter<FichaHistorial>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<FichaHistorial>
    READER$ = (org.apache.avro.io.DatumReader<FichaHistorial>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    this.afiliacion_vigente.customEncode(out);

    long size0 = this.historial_afiliaciones.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (openpolitica.jne.infogob.data.Afiliacion e0: this.historial_afiliaciones) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (this.afiliacion_vigente == null) {
        this.afiliacion_vigente = new openpolitica.jne.infogob.data.Afiliacion();
      }
      this.afiliacion_vigente.customDecode(in);

      long size0 = in.readArrayStart();
      java.util.List<openpolitica.jne.infogob.data.Afiliacion> a0 = this.historial_afiliaciones;
      if (a0 == null) {
        a0 = new SpecificData.Array<openpolitica.jne.infogob.data.Afiliacion>((int)size0, SCHEMA$.getField("historial_afiliaciones").schema());
        this.historial_afiliaciones = a0;
      } else a0.clear();
      SpecificData.Array<openpolitica.jne.infogob.data.Afiliacion> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<openpolitica.jne.infogob.data.Afiliacion>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          openpolitica.jne.infogob.data.Afiliacion e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new openpolitica.jne.infogob.data.Afiliacion();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (this.afiliacion_vigente == null) {
            this.afiliacion_vigente = new openpolitica.jne.infogob.data.Afiliacion();
          }
          this.afiliacion_vigente.customDecode(in);
          break;

        case 1:
          long size0 = in.readArrayStart();
          java.util.List<openpolitica.jne.infogob.data.Afiliacion> a0 = this.historial_afiliaciones;
          if (a0 == null) {
            a0 = new SpecificData.Array<openpolitica.jne.infogob.data.Afiliacion>((int)size0, SCHEMA$.getField("historial_afiliaciones").schema());
            this.historial_afiliaciones = a0;
          } else a0.clear();
          SpecificData.Array<openpolitica.jne.infogob.data.Afiliacion> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<openpolitica.jne.infogob.data.Afiliacion>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              openpolitica.jne.infogob.data.Afiliacion e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new openpolitica.jne.infogob.data.Afiliacion();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










