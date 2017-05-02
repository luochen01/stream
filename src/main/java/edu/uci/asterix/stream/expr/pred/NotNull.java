package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;

public class NotNull extends UnaryRelationExpr {

    public NotNull(Expr child) {
        super(child);
    }

    @Override
    public Object eval(Tuple input) {
        return child.eval(input) != null;
    }

}
