package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.LeafExpr;

public class True extends LeafExpr<Expr> implements PredicateExpr {

    public static final True INSTANCE = new True();

    public True() {
        super("TRUE");
    }

    @Override
    public PredicateExpr dual() {
        return False.INSTANCE;
    }

    @Override
    public Expr[] children() {
        return new Expr[0];
    }

    @Override
    public Object eval(Tuple input) {
        return true;
    }

    @Override
    public String toString() {
        return "TRUE";
    }

    @Override
    public Expr withChildren(Expr... children) {
        return this;
    }

}
