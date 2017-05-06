package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.expr.Expr;

public abstract class UnaryPredicateExpr extends PredicateExpr {
    protected final Expr child;

    public UnaryPredicateExpr(String symbol, Expr child) {
        super(symbol);
        this.child = child;
    }

    @Override
    public Expr[] children() {
        return new Expr[] { child };
    }

    @Override
    public String toString() {
        return child.toString() + " " + symbol;
    }
}
