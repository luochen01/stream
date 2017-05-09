package edu.uci.asterix.stream.expr.arithm;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class UnaryArithmeticExpr extends UnaryExpr<Expr> implements ArithmeticExpr {

    public UnaryArithmeticExpr(String symbol, Expr child) {
        super(symbol, child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "Arithmetic operator only applies to numerical field");
    }

}
