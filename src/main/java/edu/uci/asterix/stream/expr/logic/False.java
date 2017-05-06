package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;

public class False extends PredicateExpr {

    public static final False INSTANCE = new False();

    public False() {
        super("FALSE");
    }

    @Override
    public LogicExpr dual() {
        return True.INSTANCE;
    }

    @Override
    public Expr[] children() {
        return new Expr[0];
    }

    @Override
    public Object eval(Tuple input) {
        return false;
    }

    @Override
    public String toString() {
        return "FALSE";
    }

}
