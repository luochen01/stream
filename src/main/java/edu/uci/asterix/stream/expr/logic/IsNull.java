package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;

public class IsNull extends UnaryPredicateExpr {

    public IsNull(Expr child) {
        super("Is NULL", child);
    }

    @Override
    public Object eval(Tuple input) {
        return child.eval(input) != null;
    }

    @Override
    public PredicateExpr dual() {
        return new NotNull(child);
    }

}
