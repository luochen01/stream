package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

public class StructGetField extends Expr {

    protected final Expr child;

    protected final Field field;

    protected final int fieldIndex;

    public StructGetField(Expr child, Field field) {
        this.child = child;
        this.field = field;

        Assertion.asserts(child.getResultType().getFieldTypeName() == FieldTypeName.STRUCT);

        this.fieldIndex = child.getResultType().getFieldIndex(field);
        Assertion.asserts(fieldIndex >= 0);
    }

    @Override
    public Expr[] operands() {
        return null;
    }

    @Override
    public FieldType getResultType() {
        return null;
    }

    @Override
    public Object eval(Tuple input) {
        Object childEval = child.eval(input);
        if (childEval == null) {
            return null;
        }
        return ((Tuple) childEval).get(fieldIndex);
    }

}
