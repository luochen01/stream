package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.LeafExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Assertion;

public class FieldAccess extends LeafExpr<Expr> {

    private final Field field;

    private final int fieldIndex;

    public FieldAccess(Field field, StructType schema) {
        super(field.getFieldName());
        this.field = field;
        if (this.field != Field.ALL_FIELDS) {
            this.fieldIndex = schema.getFieldIndex(field.getFieldName());
            Assertion.asserts(this.fieldIndex >= 0);
        } else {
            this.fieldIndex = -1;
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

    @Override
    public Expr withChildren(Expr... children) {
        return this;
    }

}
