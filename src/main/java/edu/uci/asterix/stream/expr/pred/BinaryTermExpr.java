package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;

public abstract class BinaryTermExpr extends TermExpr {
    protected final Expr left;
    protected final Expr right;

    public BinaryTermExpr(String symbol, Expr left, Expr right) {
        super(symbol);
        this.left = left;
        this.right = right;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { left, right };
    }

    @Override
    public String toString() {
        return left.toString() + " " + symbol + " " + right.toString();
    }
}
