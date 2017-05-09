package edu.uci.asterix.stream.expr.arithm;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

public class Mod extends BinaryArithmeticExpr {

    public Mod(Expr left, Expr right) {
        super("%", left, right);

        Assertion.asserts(left.getResultType().getFieldTypeName() == FieldTypeName.INTEGER,
                "% only applies to Integer field");
        Assertion.asserts(right.getResultType().getFieldTypeName() == FieldTypeName.INTEGER,
                "% only applies to Integer field");
    }

    @Override
    public Object eval(Tuple input) {
        Object leftVal = left.eval(input);
        Object rightVal = right.eval(input);
        if (leftVal == null || rightVal == null) {
            return null;
        }
        return (int) leftVal % (int) rightVal;
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Mod(children[0], children[1]);
    }

}
