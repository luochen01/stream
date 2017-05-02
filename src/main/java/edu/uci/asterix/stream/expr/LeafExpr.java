package edu.uci.asterix.stream.expr;

public abstract class LeafExpr extends Expr {

    @Override
    public Expr[] operands() {
        return new Expr[0];
    }
}
