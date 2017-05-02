package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;

public abstract class UnaryRelationExpr extends RelationExpr {
    protected final Expr child;

    public UnaryRelationExpr(Expr child) {
        this.child = child;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { child };
    }
}
