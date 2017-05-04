package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;

public abstract class AggregateExpr extends Expr {

    protected final Expr child;

    public AggregateExpr(String symbol, Expr child) {
        super(symbol);
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

    @Override
    public String toString() {
        return symbol + "(" + child + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        AggregateExpr other = (AggregateExpr) obj;
        if (child == null) {
            if (other.child != null)
                return false;
        } else if (!child.equals(other.child))
            return false;
        return true;
    }

}
