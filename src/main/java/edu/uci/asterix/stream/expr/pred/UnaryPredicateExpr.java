package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;

public abstract class UnaryPredicateExpr extends PredicateExpr {

    protected final RelationExpr child;

    public UnaryPredicateExpr(RelationExpr child) {
        this.child = child;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { child };
    }
}
