package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;

public class NotNull extends UnaryPredicateExpr {

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

}
