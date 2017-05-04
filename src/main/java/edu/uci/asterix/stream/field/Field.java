package edu.uci.asterix.stream.field;

public class Field {

    public static final Field ALL_FIELDS = new Field("*", PrimitiveType.get(FieldTypeName.STRING));

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

    public Field withTableAlias(String alias) {
        return new Field(alias + "." + fieldName, fieldType);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
        result = prime * result + ((fieldType == null) ? 0 : fieldType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Field other = (Field) obj;
        if (fieldName == null) {
            if (other.fieldName != null)
                return false;
        } else if (!fieldName.equals(other.fieldName))
            return false;
        if (fieldType == null) {
            if (other.fieldType != null)
                return false;
        } else if (!fieldType.equals(other.fieldType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return fieldName;
    }

}
