package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.expr.Expr;

public abstract class BinaryLogicExpr extends LogicExpr {
    protected final LogicExpr left;
    protected final LogicExpr right;

    public BinaryLogicExpr(String symbol, LogicExpr left, LogicExpr right) {
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

    public LogicExpr getLeft() {
        return left;
    }

    public LogicExpr getRight() {
        return right;
    }
}
