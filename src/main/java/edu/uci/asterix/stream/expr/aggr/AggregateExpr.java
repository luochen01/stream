package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;

public abstract class AggregateExpr extends Expr {

    protected final Expr child;

    public AggregateExpr(Expr child) {
        this.child = child;
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { child };
    }

    @Override
    public Object eval(Tuple input) {
        //TODO: we might implement aggregate functions separately?
        throw new UnsupportedOperationException();
    }
}
