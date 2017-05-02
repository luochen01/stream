package edu.uci.asterix.stream.field;

public class Field {

    private final String fieldName;

    private final FieldType fieldType;

    public Field(String fieldName, FieldType fieldType) {
        super();
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public FieldType getFieldType() {
        return fieldType;
    }
}
