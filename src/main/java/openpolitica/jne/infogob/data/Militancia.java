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
public class Militancia extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6793430117568250638L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Militancia\",\"namespace\":\"openpolitica.jne.infogob.data\",\"fields\":[{\"name\":\"dni\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"nombre_completo\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"ficha_historial\",\"type\":[{\"type\":\"record\",\"name\":\"FichaHistorial\",\"fields\":[{\"name\":\"afiliacion_vigente\",\"type\":{\"type\":\"record\",\"name\":\"Afiliacion\",\"fields\":[{\"name\":\"org_politica\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"org_politica_estado\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"org_politica_tipo\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"org_politica_alcance\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"org_politica_fecha_inscripcion\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"default\":\"null\"},{\"name\":\"afiliacion_estado\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"afiliacion_inicio\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"afiliacion_representante\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"afiliacion_comite\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"default\":\"null\"},{\"name\":\"afiliacion_cancelacion\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"default\":\"null\"}]}},{\"name\":\"historial_afiliaciones\",\"type\":{\"type\":\"array\",\"items\":\"Afiliacion\"}}]},\"null\"]},{\"name\":\"procesos_electorales\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ProcesoElectoral\",\"fields\":[{\"name\":\"proceso_electoral\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"cargo_postulo\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"org_politica\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"circunscripcion\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"elegido\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Militancia> ENCODER =
      new BinaryMessageEncoder<Militancia>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Militancia> DECODER =
      new BinaryMessageDecoder<Militancia>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Militancia> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Militancia> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Militancia> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Militancia>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Militancia to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Militancia from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Militancia instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Militancia fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String dni;
   private java.lang.String nombre_completo;
   private openpolitica.jne.infogob.data.FichaHistorial ficha_historial;
   private java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral> procesos_electorales;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Militancia() {}

  /**
   * All-args constructor.
   * @param dni The new value for dni
   * @param nombre_completo The new value for nombre_completo
   * @param ficha_historial The new value for ficha_historial
   * @param procesos_electorales The new value for procesos_electorales
   */
  public Militancia(java.lang.String dni, java.lang.String nombre_completo, openpolitica.jne.infogob.data.FichaHistorial ficha_historial, java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral> procesos_electorales) {
    this.dni = dni;
    this.nombre_completo = nombre_completo;
    this.ficha_historial = ficha_historial;
    this.procesos_electorales = procesos_electorales;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return dni;
    case 1: return nombre_completo;
    case 2: return ficha_historial;
    case 3: return procesos_electorales;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: dni = value$ != null ? value$.toString() : null; break;
    case 1: nombre_completo = value$ != null ? value$.toString() : null; break;
    case 2: ficha_historial = (openpolitica.jne.infogob.data.FichaHistorial)value$; break;
    case 3: procesos_electorales = (java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'dni' field.
   * @return The value of the 'dni' field.
   */
  public java.lang.String getDni() {
    return dni;
  }


  /**
   * Sets the value of the 'dni' field.
   * @param value the value to set.
   */
  public void setDni(java.lang.String value) {
    this.dni = value;
  }

  /**
   * Gets the value of the 'nombre_completo' field.
   * @return The value of the 'nombre_completo' field.
   */
  public java.lang.String getNombreCompleto() {
    return nombre_completo;
  }


  /**
   * Sets the value of the 'nombre_completo' field.
   * @param value the value to set.
   */
  public void setNombreCompleto(java.lang.String value) {
    this.nombre_completo = value;
  }

  /**
   * Gets the value of the 'ficha_historial' field.
   * @return The value of the 'ficha_historial' field.
   */
  public openpolitica.jne.infogob.data.FichaHistorial getFichaHistorial() {
    return ficha_historial;
  }


  /**
   * Sets the value of the 'ficha_historial' field.
   * @param value the value to set.
   */
  public void setFichaHistorial(openpolitica.jne.infogob.data.FichaHistorial value) {
    this.ficha_historial = value;
  }

  /**
   * Gets the value of the 'procesos_electorales' field.
   * @return The value of the 'procesos_electorales' field.
   */
  public java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral> getProcesosElectorales() {
    return procesos_electorales;
  }


  /**
   * Sets the value of the 'procesos_electorales' field.
   * @param value the value to set.
   */
  public void setProcesosElectorales(java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral> value) {
    this.procesos_electorales = value;
  }

  /**
   * Creates a new Militancia RecordBuilder.
   * @return A new Militancia RecordBuilder
   */
  public static openpolitica.jne.infogob.data.Militancia.Builder newBuilder() {
    return new openpolitica.jne.infogob.data.Militancia.Builder();
  }

  /**
   * Creates a new Militancia RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Militancia RecordBuilder
   */
  public static openpolitica.jne.infogob.data.Militancia.Builder newBuilder(openpolitica.jne.infogob.data.Militancia.Builder other) {
    if (other == null) {
      return new openpolitica.jne.infogob.data.Militancia.Builder();
    } else {
      return new openpolitica.jne.infogob.data.Militancia.Builder(other);
    }
  }

  /**
   * Creates a new Militancia RecordBuilder by copying an existing Militancia instance.
   * @param other The existing instance to copy.
   * @return A new Militancia RecordBuilder
   */
  public static openpolitica.jne.infogob.data.Militancia.Builder newBuilder(openpolitica.jne.infogob.data.Militancia other) {
    if (other == null) {
      return new openpolitica.jne.infogob.data.Militancia.Builder();
    } else {
      return new openpolitica.jne.infogob.data.Militancia.Builder(other);
    }
  }

  /**
   * RecordBuilder for Militancia instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Militancia>
    implements org.apache.avro.data.RecordBuilder<Militancia> {

    private java.lang.String dni;
    private java.lang.String nombre_completo;
    private openpolitica.jne.infogob.data.FichaHistorial ficha_historial;
    private openpolitica.jne.infogob.data.FichaHistorial.Builder ficha_historialBuilder;
    private java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral> procesos_electorales;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(openpolitica.jne.infogob.data.Militancia.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.dni)) {
        this.dni = data().deepCopy(fields()[0].schema(), other.dni);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.nombre_completo)) {
        this.nombre_completo = data().deepCopy(fields()[1].schema(), other.nombre_completo);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.ficha_historial)) {
        this.ficha_historial = data().deepCopy(fields()[2].schema(), other.ficha_historial);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (other.hasFichaHistorialBuilder()) {
        this.ficha_historialBuilder = openpolitica.jne.infogob.data.FichaHistorial.newBuilder(other.getFichaHistorialBuilder());
      }
      if (isValidValue(fields()[3], other.procesos_electorales)) {
        this.procesos_electorales = data().deepCopy(fields()[3].schema(), other.procesos_electorales);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing Militancia instance
     * @param other The existing instance to copy.
     */
    private Builder(openpolitica.jne.infogob.data.Militancia other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.dni)) {
        this.dni = data().deepCopy(fields()[0].schema(), other.dni);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.nombre_completo)) {
        this.nombre_completo = data().deepCopy(fields()[1].schema(), other.nombre_completo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.ficha_historial)) {
        this.ficha_historial = data().deepCopy(fields()[2].schema(), other.ficha_historial);
        fieldSetFlags()[2] = true;
      }
      this.ficha_historialBuilder = null;
      if (isValidValue(fields()[3], other.procesos_electorales)) {
        this.procesos_electorales = data().deepCopy(fields()[3].schema(), other.procesos_electorales);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'dni' field.
      * @return The value.
      */
    public java.lang.String getDni() {
      return dni;
    }


    /**
      * Sets the value of the 'dni' field.
      * @param value The value of 'dni'.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Militancia.Builder setDni(java.lang.String value) {
      validate(fields()[0], value);
      this.dni = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'dni' field has been set.
      * @return True if the 'dni' field has been set, false otherwise.
      */
    public boolean hasDni() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'dni' field.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Militancia.Builder clearDni() {
      dni = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'nombre_completo' field.
      * @return The value.
      */
    public java.lang.String getNombreCompleto() {
      return nombre_completo;
    }


    /**
      * Sets the value of the 'nombre_completo' field.
      * @param value The value of 'nombre_completo'.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Militancia.Builder setNombreCompleto(java.lang.String value) {
      validate(fields()[1], value);
      this.nombre_completo = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'nombre_completo' field has been set.
      * @return True if the 'nombre_completo' field has been set, false otherwise.
      */
    public boolean hasNombreCompleto() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'nombre_completo' field.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Militancia.Builder clearNombreCompleto() {
      nombre_completo = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'ficha_historial' field.
      * @return The value.
      */
    public openpolitica.jne.infogob.data.FichaHistorial getFichaHistorial() {
      return ficha_historial;
    }


    /**
      * Sets the value of the 'ficha_historial' field.
      * @param value The value of 'ficha_historial'.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Militancia.Builder setFichaHistorial(openpolitica.jne.infogob.data.FichaHistorial value) {
      validate(fields()[2], value);
      this.ficha_historialBuilder = null;
      this.ficha_historial = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'ficha_historial' field has been set.
      * @return True if the 'ficha_historial' field has been set, false otherwise.
      */
    public boolean hasFichaHistorial() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'ficha_historial' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public openpolitica.jne.infogob.data.FichaHistorial.Builder getFichaHistorialBuilder() {
      if (ficha_historialBuilder == null) {
        if (hasFichaHistorial()) {
          setFichaHistorialBuilder(openpolitica.jne.infogob.data.FichaHistorial.newBuilder(ficha_historial));
        } else {
          setFichaHistorialBuilder(openpolitica.jne.infogob.data.FichaHistorial.newBuilder());
        }
      }
      return ficha_historialBuilder;
    }

    /**
     * Sets the Builder instance for the 'ficha_historial' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public openpolitica.jne.infogob.data.Militancia.Builder setFichaHistorialBuilder(openpolitica.jne.infogob.data.FichaHistorial.Builder value) {
      clearFichaHistorial();
      ficha_historialBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'ficha_historial' field has an active Builder instance
     * @return True if the 'ficha_historial' field has an active Builder instance
     */
    public boolean hasFichaHistorialBuilder() {
      return ficha_historialBuilder != null;
    }

    /**
      * Clears the value of the 'ficha_historial' field.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Militancia.Builder clearFichaHistorial() {
      ficha_historial = null;
      ficha_historialBuilder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'procesos_electorales' field.
      * @return The value.
      */
    public java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral> getProcesosElectorales() {
      return procesos_electorales;
    }


    /**
      * Sets the value of the 'procesos_electorales' field.
      * @param value The value of 'procesos_electorales'.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Militancia.Builder setProcesosElectorales(java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral> value) {
      validate(fields()[3], value);
      this.procesos_electorales = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'procesos_electorales' field has been set.
      * @return True if the 'procesos_electorales' field has been set, false otherwise.
      */
    public boolean hasProcesosElectorales() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'procesos_electorales' field.
      * @return This builder.
      */
    public openpolitica.jne.infogob.data.Militancia.Builder clearProcesosElectorales() {
      procesos_electorales = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Militancia build() {
      try {
        Militancia record = new Militancia();
        record.dni = fieldSetFlags()[0] ? this.dni : (java.lang.String) defaultValue(fields()[0]);
        record.nombre_completo = fieldSetFlags()[1] ? this.nombre_completo : (java.lang.String) defaultValue(fields()[1]);
        if (ficha_historialBuilder != null) {
          try {
            record.ficha_historial = this.ficha_historialBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("ficha_historial"));
            throw e;
          }
        } else {
          record.ficha_historial = fieldSetFlags()[2] ? this.ficha_historial : (openpolitica.jne.infogob.data.FichaHistorial) defaultValue(fields()[2]);
        }
        record.procesos_electorales = fieldSetFlags()[3] ? this.procesos_electorales : (java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral>) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Militancia>
    WRITER$ = (org.apache.avro.io.DatumWriter<Militancia>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Militancia>
    READER$ = (org.apache.avro.io.DatumReader<Militancia>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.dni);

    out.writeString(this.nombre_completo);

    if (this.ficha_historial == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      this.ficha_historial.customEncode(out);
    }

    long size0 = this.procesos_electorales.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (openpolitica.jne.infogob.data.ProcesoElectoral e0: this.procesos_electorales) {
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
      this.dni = in.readString();

      this.nombre_completo = in.readString();

      if (in.readIndex() != 0) {
        in.readNull();
        this.ficha_historial = null;
      } else {
        if (this.ficha_historial == null) {
          this.ficha_historial = new openpolitica.jne.infogob.data.FichaHistorial();
        }
        this.ficha_historial.customDecode(in);
      }

      long size0 = in.readArrayStart();
      java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral> a0 = this.procesos_electorales;
      if (a0 == null) {
        a0 = new SpecificData.Array<openpolitica.jne.infogob.data.ProcesoElectoral>((int)size0, SCHEMA$.getField("procesos_electorales").schema());
        this.procesos_electorales = a0;
      } else a0.clear();
      SpecificData.Array<openpolitica.jne.infogob.data.ProcesoElectoral> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<openpolitica.jne.infogob.data.ProcesoElectoral>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          openpolitica.jne.infogob.data.ProcesoElectoral e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new openpolitica.jne.infogob.data.ProcesoElectoral();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.dni = in.readString();
          break;

        case 1:
          this.nombre_completo = in.readString();
          break;

        case 2:
          if (in.readIndex() != 0) {
            in.readNull();
            this.ficha_historial = null;
          } else {
            if (this.ficha_historial == null) {
              this.ficha_historial = new openpolitica.jne.infogob.data.FichaHistorial();
            }
            this.ficha_historial.customDecode(in);
          }
          break;

        case 3:
          long size0 = in.readArrayStart();
          java.util.List<openpolitica.jne.infogob.data.ProcesoElectoral> a0 = this.procesos_electorales;
          if (a0 == null) {
            a0 = new SpecificData.Array<openpolitica.jne.infogob.data.ProcesoElectoral>((int)size0, SCHEMA$.getField("procesos_electorales").schema());
            this.procesos_electorales = a0;
          } else a0.clear();
          SpecificData.Array<openpolitica.jne.infogob.data.ProcesoElectoral> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<openpolitica.jne.infogob.data.ProcesoElectoral>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              openpolitica.jne.infogob.data.ProcesoElectoral e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new openpolitica.jne.infogob.data.ProcesoElectoral();
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










