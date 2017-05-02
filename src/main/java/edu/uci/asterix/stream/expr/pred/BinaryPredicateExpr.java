package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;

public abstract class BinaryPredicateExpr extends PredicateExpr {
    protected final RelationExpr left;
    protected final RelationExpr right;

    public BinaryPredicateExpr(RelationExpr left, RelationExpr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { left, right };
    }

}
