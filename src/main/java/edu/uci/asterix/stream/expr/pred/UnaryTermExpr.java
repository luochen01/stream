package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;

public abstract class UnaryTermExpr extends TermExpr {
    protected final Expr child;

    public UnaryTermExpr(String symbol, Expr child) {
        super(symbol);
        this.child = child;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { child };
    }

    @Override
    public String toString() {
        return child.toString() + " " + symbol;
    }
}
