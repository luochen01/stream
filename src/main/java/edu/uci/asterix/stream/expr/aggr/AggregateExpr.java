package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.GroupbyKey;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;

public abstract class AggregateExpr extends UnaryExpr<Expr> {

    public AggregateExpr(String symbol, Expr child) {
        super(symbol, child);
    }

    @Override
    public Object eval(Tuple input) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return symbol + "(" + child + ")";
    }

    public abstract Object compute(GroupbyKey key, Object currentValue, Tuple input);

    public void reset() {

    }
}
