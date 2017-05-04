package edu.uci.asterix.stream.expr;

public abstract class UnaryExpr extends Expr {

    protected final Expr child;

    public UnaryExpr(String symbol, Expr child) {
        super(symbol);
        this.child = child;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { child };
    }
}
