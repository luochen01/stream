package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class ComparisonExpr extends BinaryTermExpr {

    public ComparisonExpr(String symbol, Expr left, Expr right) {
        super(symbol, left, right);
        Assertion.asserts(left.getResultType().getFieldTypeName().isNumerical(),
                "Numerical comparator only applies to numerical fields");
        Assertion.asserts(right.getResultType().getFieldTypeName().isNumerical(),
                "Numerical comparator only applies to numerical fields");
    }

}
