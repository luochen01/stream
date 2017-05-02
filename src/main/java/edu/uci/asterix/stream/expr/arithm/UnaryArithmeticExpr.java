package edu.uci.asterix.stream.expr.arithm;

import edu.uci.asterix.stream.expr.Expr;

public abstract class UnaryArithmeticExpr extends ArithmeticExpr {

    protected final Expr child;

    public UnaryArithmeticExpr(Expr child) {
        this.child = child;

        assert (this.child.getResultType().getFieldTypeName().isNumerical());
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { child };
    }

}
