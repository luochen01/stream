package edu.uci.asterix.stream.field;

public class ArrayType extends AbstractFieldType {

    private final FieldType elementType;

    public ArrayType(FieldType elementType) {
        super(FieldTypeName.ARRAY);
        this.elementType = elementType;
    }

    @Override
    public FieldType getElementType() {
        return elementType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((elementType == null) ? 0 : elementType.hashCode());
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
        ArrayType other = (ArrayType) obj;
        if (elementType == null) {
            if (other.elementType != null)
                return false;
        } else if (!elementType.equals(other.elementType))
            return false;
        return true;
    }

}
