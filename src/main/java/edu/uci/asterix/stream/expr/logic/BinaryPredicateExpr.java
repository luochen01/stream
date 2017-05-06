package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.expr.Expr;

public abstract class BinaryPredicateExpr extends PredicateExpr {
    protected final Expr left;
    protected final Expr right;

    public BinaryPredicateExpr(String symbol, Expr left, Expr right) {
        super(symbol);
        this.left = left;
        this.right = right;
    }

    @Override
    public Expr[] children() {
        return new Expr[] { left, right };
    }

    @Override
    public String toString() {
        return left.toString() + " " + symbol + " " + right.toString();
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }
}
