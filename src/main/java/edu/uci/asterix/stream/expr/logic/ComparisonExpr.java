package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class ComparisonExpr extends BinaryPredicateExpr {

    public ComparisonExpr(String symbol, Expr left, Expr right) {
        super(symbol, left, right);
        Assertion.asserts(left.getResultType().getFieldTypeName().isNumerical(),
                "Numerical comparator only applies to numerical fields");
        Assertion.asserts(right.getResultType().getFieldTypeName().isNumerical(),
                "Numerical comparator only applies to numerical fields");
    }
}
