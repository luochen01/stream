package edu.uci.asterix.stream.expr;

public abstract class LeafExpr<T extends Expr> extends AbstractExpr<T> {

    public LeafExpr(String symbol) {
        super(symbol);
    }

    @Override
    public Expr[] children() {
        return new Expr[0];
    }
}
