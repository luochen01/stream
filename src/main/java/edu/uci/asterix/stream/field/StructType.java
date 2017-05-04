package edu.uci.asterix.stream.field;

import java.util.List;

public class StructType extends AbstractFieldType {

    private final List<Field> fields;

    public StructType(List<Field> fields) {
        super(FieldTypeName.STRUCT);
        this.fields = fields;
    }

    @Override
    public int getFieldIndex(String field) {
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).getFieldName().equals(field)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Field> getFields() {
        return fields;
    }

    @Override
    public int getFieldCount() {
        return fields.size();
    }

    @Override
    public Field getField(String fieldName) {
        for (Field field : fields) {
            if (field.getFieldName().equals(fieldName)) {
                return field;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((fields == null) ? 0 : fields.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        StructType other = (StructType) obj;
        if (fields == null) {
            if (other.fields != null)
                return false;
        } else if (!fields.equals(other.fields))
            return false;
        return true;
    }

}
