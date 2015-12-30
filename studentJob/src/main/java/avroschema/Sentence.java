/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package avroschema;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Sentence extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Sentence\",\"namespace\":\"avroschema\",\"fields\":[{\"name\":\"s_id\",\"type\":\"int\"},{\"name\":\"span\",\"type\":{\"type\":\"record\",\"name\":\"Span\",\"fields\":[{\"name\":\"start_index\",\"type\":\"int\"},{\"name\":\"end_index\",\"type\":\"int\"}]}},{\"name\":\"tokens\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Token\",\"fields\":[{\"name\":\"pos\",\"type\":\"string\"},{\"name\":\"ner\",\"type\":\"string\"},{\"name\":\"t_span\",\"type\":\"Span\"}]}}]},{\"name\":\"dp\",\"type\":[\"string\",\"null\"]},{\"name\":\"sg\",\"type\":[\"string\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int s_id;
  @Deprecated public avroschema.Span span;
  @Deprecated public java.util.List<avroschema.Token> tokens;
  @Deprecated public java.lang.CharSequence dp;
  @Deprecated public java.lang.CharSequence sg;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Sentence() {}

  /**
   * All-args constructor.
   */
  public Sentence(java.lang.Integer s_id, avroschema.Span span, java.util.List<avroschema.Token> tokens, java.lang.CharSequence dp, java.lang.CharSequence sg) {
    this.s_id = s_id;
    this.span = span;
    this.tokens = tokens;
    this.dp = dp;
    this.sg = sg;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return s_id;
    case 1: return span;
    case 2: return tokens;
    case 3: return dp;
    case 4: return sg;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: s_id = (java.lang.Integer)value$; break;
    case 1: span = (avroschema.Span)value$; break;
    case 2: tokens = (java.util.List<avroschema.Token>)value$; break;
    case 3: dp = (java.lang.CharSequence)value$; break;
    case 4: sg = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 's_id' field.
   */
  public java.lang.Integer getSId() {
    return s_id;
  }

  /**
   * Sets the value of the 's_id' field.
   * @param value the value to set.
   */
  public void setSId(java.lang.Integer value) {
    this.s_id = value;
  }

  /**
   * Gets the value of the 'span' field.
   */
  public avroschema.Span getSpan() {
    return span;
  }

  /**
   * Sets the value of the 'span' field.
   * @param value the value to set.
   */
  public void setSpan(avroschema.Span value) {
    this.span = value;
  }

  /**
   * Gets the value of the 'tokens' field.
   */
  public java.util.List<avroschema.Token> getTokens() {
    return tokens;
  }

  /**
   * Sets the value of the 'tokens' field.
   * @param value the value to set.
   */
  public void setTokens(java.util.List<avroschema.Token> value) {
    this.tokens = value;
  }

  /**
   * Gets the value of the 'dp' field.
   */
  public java.lang.CharSequence getDp() {
    return dp;
  }

  /**
   * Sets the value of the 'dp' field.
   * @param value the value to set.
   */
  public void setDp(java.lang.CharSequence value) {
    this.dp = value;
  }

  /**
   * Gets the value of the 'sg' field.
   */
  public java.lang.CharSequence getSg() {
    return sg;
  }

  /**
   * Sets the value of the 'sg' field.
   * @param value the value to set.
   */
  public void setSg(java.lang.CharSequence value) {
    this.sg = value;
  }

  /** Creates a new Sentence RecordBuilder */
  public static avroschema.Sentence.Builder newBuilder() {
    return new avroschema.Sentence.Builder();
  }
  
  /** Creates a new Sentence RecordBuilder by copying an existing Builder */
  public static avroschema.Sentence.Builder newBuilder(avroschema.Sentence.Builder other) {
    return new avroschema.Sentence.Builder(other);
  }
  
  /** Creates a new Sentence RecordBuilder by copying an existing Sentence instance */
  public static avroschema.Sentence.Builder newBuilder(avroschema.Sentence other) {
    return new avroschema.Sentence.Builder(other);
  }
  
  /**
   * RecordBuilder for Sentence instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Sentence>
    implements org.apache.avro.data.RecordBuilder<Sentence> {

    private int s_id;
    private avroschema.Span span;
    private java.util.List<avroschema.Token> tokens;
    private java.lang.CharSequence dp;
    private java.lang.CharSequence sg;

    /** Creates a new Builder */
    private Builder() {
      super(avroschema.Sentence.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(avroschema.Sentence.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.s_id)) {
        this.s_id = data().deepCopy(fields()[0].schema(), other.s_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.span)) {
        this.span = data().deepCopy(fields()[1].schema(), other.span);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.tokens)) {
        this.tokens = data().deepCopy(fields()[2].schema(), other.tokens);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.dp)) {
        this.dp = data().deepCopy(fields()[3].schema(), other.dp);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.sg)) {
        this.sg = data().deepCopy(fields()[4].schema(), other.sg);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Sentence instance */
    private Builder(avroschema.Sentence other) {
            super(avroschema.Sentence.SCHEMA$);
      if (isValidValue(fields()[0], other.s_id)) {
        this.s_id = data().deepCopy(fields()[0].schema(), other.s_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.span)) {
        this.span = data().deepCopy(fields()[1].schema(), other.span);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.tokens)) {
        this.tokens = data().deepCopy(fields()[2].schema(), other.tokens);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.dp)) {
        this.dp = data().deepCopy(fields()[3].schema(), other.dp);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.sg)) {
        this.sg = data().deepCopy(fields()[4].schema(), other.sg);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 's_id' field */
    public java.lang.Integer getSId() {
      return s_id;
    }
    
    /** Sets the value of the 's_id' field */
    public avroschema.Sentence.Builder setSId(int value) {
      validate(fields()[0], value);
      this.s_id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 's_id' field has been set */
    public boolean hasSId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 's_id' field */
    public avroschema.Sentence.Builder clearSId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'span' field */
    public avroschema.Span getSpan() {
      return span;
    }
    
    /** Sets the value of the 'span' field */
    public avroschema.Sentence.Builder setSpan(avroschema.Span value) {
      validate(fields()[1], value);
      this.span = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'span' field has been set */
    public boolean hasSpan() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'span' field */
    public avroschema.Sentence.Builder clearSpan() {
      span = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'tokens' field */
    public java.util.List<avroschema.Token> getTokens() {
      return tokens;
    }
    
    /** Sets the value of the 'tokens' field */
    public avroschema.Sentence.Builder setTokens(java.util.List<avroschema.Token> value) {
      validate(fields()[2], value);
      this.tokens = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'tokens' field has been set */
    public boolean hasTokens() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'tokens' field */
    public avroschema.Sentence.Builder clearTokens() {
      tokens = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'dp' field */
    public java.lang.CharSequence getDp() {
      return dp;
    }
    
    /** Sets the value of the 'dp' field */
    public avroschema.Sentence.Builder setDp(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.dp = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'dp' field has been set */
    public boolean hasDp() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'dp' field */
    public avroschema.Sentence.Builder clearDp() {
      dp = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'sg' field */
    public java.lang.CharSequence getSg() {
      return sg;
    }
    
    /** Sets the value of the 'sg' field */
    public avroschema.Sentence.Builder setSg(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.sg = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'sg' field has been set */
    public boolean hasSg() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'sg' field */
    public avroschema.Sentence.Builder clearSg() {
      sg = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public Sentence build() {
      try {
        Sentence record = new Sentence();
        record.s_id = fieldSetFlags()[0] ? this.s_id : (java.lang.Integer) defaultValue(fields()[0]);
        record.span = fieldSetFlags()[1] ? this.span : (avroschema.Span) defaultValue(fields()[1]);
        record.tokens = fieldSetFlags()[2] ? this.tokens : (java.util.List<avroschema.Token>) defaultValue(fields()[2]);
        record.dp = fieldSetFlags()[3] ? this.dp : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.sg = fieldSetFlags()[4] ? this.sg : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
