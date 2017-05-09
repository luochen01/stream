package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.expr.BinaryExpr;
import edu.uci.asterix.stream.expr.Expr;

public abstract class BinaryPredicateExpr extends BinaryExpr<Expr> implements PredicateExpr {

    public BinaryPredicateExpr(String symbol, Expr left, Expr right) {
        super(symbol, left, right);
    }

}
