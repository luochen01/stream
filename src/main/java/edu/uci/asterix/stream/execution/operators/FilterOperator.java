package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalFilter;

public class FilterOperator extends UnaryOperator<LogicalFilter> {

    protected final LogicExpr condition;

    public FilterOperator(Operator child, LogicalFilter logicalFilter) {
        super(child, logicalFilter);
        this.condition = logicalFilter.getFilterCondition();
    }

    @Override
    public Tuple nextImpl() {
        //TODO implement
        throw new UnsupportedOperationException();
    }

    @Override
    public String getName() {
        return "FILTER";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(condition.toString());

    }

    @Override
    public StructType getSchema() {
        return child.getSchema();
    }

}
