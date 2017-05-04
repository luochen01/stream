package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;

public abstract class BinaryPredicateExpr extends LogicExpr {
    protected final TermExpr left;
    protected final TermExpr right;

    public BinaryPredicateExpr(String symbol, TermExpr left, TermExpr right) {
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
