package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

public class StructGetField extends UnaryExpr<Expr> {

    protected final Field field;

    protected final int fieldIndex;

    public StructGetField(Expr child, String field) {
        super(".", child);
        Assertion.asserts(child.getResultType().getFieldTypeName() == FieldTypeName.STRUCT,
                child + " is not a struct field");

        this.fieldIndex = child.getResultType().getFieldIndex(field);
        Assertion.asserts(fieldIndex >= 0, child + " has no field named " + field);

        this.field = child.getResultType().getFields().get(fieldIndex);
    }

    @Override
    public Expr[] children() {
        return new Expr[] { child };
    }

    @Override
    public FieldType getResultType() {
        return field.getFieldType();
    }

    @Override
    public Object eval(Tuple input) {
        Object childEval = child.eval(input);
        if (childEval == null) {
            return null;
        }
        return ((Tuple) childEval).get(fieldIndex);
    }

    @Override
    public Field toField() {
        return field;
    }

    @Override
    public String toString() {
        return child + "." + field;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        StructGetField other = (StructGetField) obj;
        if (child == null) {
            if (other.child != null)
                return false;
        } else if (!child.equals(other.child))
            return false;
        if (field == null) {
            if (other.field != null)
                return false;
        } else if (!field.equals(other.field))
            return false;
        return true;
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new StructGetField(children[0], field.getFieldName());
    }

}
