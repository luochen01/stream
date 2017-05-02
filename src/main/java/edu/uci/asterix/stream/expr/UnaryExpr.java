package edu.uci.asterix.stream.expr;

public abstract class UnaryExpr extends Expr {

    protected final Expr child;

    public UnaryExpr(Expr child) {
        this.child = child;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { child };
    }
}
