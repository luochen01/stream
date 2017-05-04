package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.LeafExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public class FieldAccess extends LeafExpr {

    private final Field field;

    private final int fieldIndex;

    public FieldAccess(Field field, int fieldIndex) {
        super(field.getFieldName());
        this.field = field;
        this.fieldIndex = fieldIndex;
        if (this.field != Field.ALL_FIELDS) {
            Assertion.asserts(fieldIndex >= 0);
        }
    }

    @Override
    public FieldType getResultType() {
        return field.getFieldType();
    }

    @Override
    public Object eval(Tuple input) {
        return input.get(fieldIndex);
    }

    @Override
    public Field toField() {
        return field;
    }

    @Override
    public String toString() {
        return field.getFieldName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        FieldAccess other = (FieldAccess) obj;
        if (field == null) {
            if (other.field != null)
                return false;
        } else if (!field.equals(other.field))
            return false;
        return true;
    }

}
