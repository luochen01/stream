package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;

public abstract class UnaryPredicateExpr extends LogicExpr {

    protected final TermExpr child;

    public UnaryPredicateExpr(String symbol, TermExpr child) {
        super(symbol);
        this.child = child;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { child };
    }

    @Override
    public String toString() {
        return symbol + " " + child.toString();
    }
}
