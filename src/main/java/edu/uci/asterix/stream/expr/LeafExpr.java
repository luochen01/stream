package edu.uci.asterix.stream.expr;

public abstract class LeafExpr extends Expr {

    public LeafExpr(String symbol) {
        super(symbol);
    }

    @Override
    public Expr[] operands() {
        return new Expr[0];
    }
}
