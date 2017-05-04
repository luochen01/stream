package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.LeafExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;

public class Literal extends LeafExpr {

    private final Object value;

    private final FieldType fieldType;

    public Literal(Object value, FieldTypeName typeName) {
        super(value.toString());
        this.value = value;
        this.fieldType = PrimitiveType.get(typeName);
    }

    @Override
    public FieldType getResultType() {
        return fieldType;
    }

    @Override
    public Object eval(Tuple input) {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Field toField() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Literal other = (Literal) obj;
        if (fieldType == null) {
            if (other.fieldType != null)
                return false;
        } else if (!fieldType.equals(other.fieldType))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
