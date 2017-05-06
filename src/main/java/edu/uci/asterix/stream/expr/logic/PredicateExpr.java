package edu.uci.asterix.stream.expr.logic;

public abstract class PredicateExpr extends LogicExpr {

    public PredicateExpr(String symbol) {
        super(symbol);
    }

    public abstract LogicExpr dual();

}
