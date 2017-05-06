package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

/**
 * Get an array item
 * 
 * @author luochen
 */
public class ArrayGetItem extends Expr {

    protected final Expr child;

    protected final Expr ordinal;

    public ArrayGetItem(Expr child, Expr ordinal) {
        super("[]");
        this.child = child;
        this.ordinal = ordinal;
        Assertion.asserts(child.getResultType().getFieldTypeName() == FieldTypeName.ARRAY,
                "[] only applies to array field");
        Assertion.asserts(ordinal.getResultType().getFieldTypeName() == FieldTypeName.INTEGER,
                "[] only applies to int ordinal");
    }

    @Override
    public Expr[] children() {
        return new Expr[] { child, ordinal };
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType().getElementType();
    }

    @Override
    public Object eval(Tuple input) {
        Object childEval = child.eval(input);
        if (childEval == null) {
            return null;
        }
        Object ordinalEval = ordinal.eval(input);
        if (ordinalEval == null) {
            return null;
        }
        return ((Object[]) childEval)[(int) ordinalEval];
    }

    @Override
    public String toString() {
        return child.toString() + "[" + ordinal.toString() + "]";
    }

}
