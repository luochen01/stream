package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.BinaryExpr;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

/**
 * Get an array item
 * 
 * @author luochen
 */
public class ArrayGetItem extends BinaryExpr<Expr> {

    public ArrayGetItem(Expr child, Expr ordinal) {
        super("[]", child, ordinal);
        Assertion.asserts(child.getResultType().getFieldTypeName() == FieldTypeName.ARRAY,
                "[] only applies to array field");
        Assertion.asserts(ordinal.getResultType().getFieldTypeName() == FieldTypeName.INTEGER,
                "[] only applies to int ordinal");
    }

    @Override
    public FieldType getResultType() {
        return left.getResultType().getElementType();
    }

    @Override
    public Object eval(Tuple input) {
        Object childEval = left.eval(input);
        if (childEval == null) {
            return null;
        }
        Object ordinalEval = right.eval(input);
        if (ordinalEval == null) {
            return null;
        }
        return ((Object[]) childEval)[(int) ordinalEval];
    }

    @Override
    public String toString() {
        return left.toString() + "[" + right.toString() + "]";
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new ArrayGetItem(children[0], children[1]);
    }

}
