package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;

public abstract class BinaryRelationExpr extends PredicateExpr {
    protected final Expr left;
    protected final Expr right;

    public BinaryRelationExpr(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { left, right };
    }

}
