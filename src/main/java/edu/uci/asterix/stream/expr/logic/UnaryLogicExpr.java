package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.expr.Expr;

public abstract class UnaryLogicExpr extends LogicExpr {

    protected final LogicExpr child;

    public UnaryLogicExpr(String symbol, LogicExpr child) {
        super(symbol);
        this.child = child;
    }

    @Override
    public Expr[] children() {
        return new Expr[] { child };
    }

    @Override
    public String toString() {
        return symbol + " " + child.toString();
    }

    public LogicExpr getChild() {
        return child;
    }
}
