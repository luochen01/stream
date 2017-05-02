package edu.uci.asterix.stream.field;

import java.util.List;

public class StructType extends AbstractFieldType {

    private final List<Field> fields;

    public StructType(List<Field> fields) {
        super(FieldTypeName.STRUCT);
        this.fields = fields;
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
    public int getFieldIndex(Field field) {
        return fields.indexOf(field);
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
