package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;

public abstract class AggregateExpr extends UnaryExpr<Expr> {

    public AggregateExpr(String symbol, Expr child) {
        super(symbol, child);
    }

    @Override
    public Object eval(Tuple input) {
        //TODO: we might implement aggregate functions separately?
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return symbol + "(" + child + ")";
    }

}
