package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;

public class NotNull extends UnaryExpr<Expr> implements PredicateExpr {

    public NotNull(Expr child) {
        super("NOT NULL", child);
    }

    @Override
    public Object eval(Tuple input) {
        return child.eval(input) != null;
    }

    @Override
    public PredicateExpr dual() {
        return new IsNull(child);
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new NotNull(children[0]);
    }

}
