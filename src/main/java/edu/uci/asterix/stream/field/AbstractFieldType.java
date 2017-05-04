package edu.uci.asterix.stream.field;

import java.util.List;

public abstract class AbstractFieldType implements FieldType {

    protected final FieldTypeName typeName;

    public AbstractFieldType(FieldTypeName typeName) {
        this.typeName = typeName;
    }

    @Override
    public FieldTypeName getFieldTypeName() {
        return typeName;
    }

    @Override
    public FieldType getElementType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Field> getFields() {
        throw new UnsupportedOperationException();
    }

    public int getFieldCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public FieldType upcast(FieldType another) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean compatible(FieldType another) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFieldIndex(String field) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Field getField(String field) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
        AbstractFieldType other = (AbstractFieldType) obj;
        if (typeName != other.typeName)
            return false;
        return true;
    }

}
