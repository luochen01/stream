package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.pred.PredicateExpr;
import edu.uci.asterix.stream.field.StructType;

public class FilterOperator extends UnaryOperator {

    protected final PredicateExpr condition;

    public FilterOperator(Operator child, PredicateExpr condition) {
        super(child);
        this.condition = condition;
    }

    @Override
    public Tuple nextImpl() {
        //TODO implement
        throw new UnsupportedOperationException();
    }

    @Override
    public StructType getSchema() {
        return child.getSchema();
    }

}
