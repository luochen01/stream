package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class ComparisonExpr extends BinaryRelationExpr {

    public ComparisonExpr(Expr left, Expr right) {
        super(left, right);
        Assertion.asserts(left.getResultType().getFieldTypeName().isNumerical());
        Assertion.asserts(right.getResultType().getFieldTypeName().isNumerical());
    }

}
