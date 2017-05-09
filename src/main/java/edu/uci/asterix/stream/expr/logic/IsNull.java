package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;

public class IsNull extends UnaryExpr<Expr> implements PredicateExpr {

    public IsNull(Expr child) {
        super("IS NULL", child);
    }

    @Override
    public Object eval(Tuple input) {
        return child.eval(input) != null;
    }

    @Override
    public PredicateExpr dual() {
        return new NotNull(child);
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new IsNull(children[0]);
    }

}
