package edu.uci.asterix.stream.execution.operators;

import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.SortOrder;
import edu.uci.asterix.stream.logical.LogicalSort;
import edu.uci.asterix.stream.utils.Utils;

public class SortOperator extends UnaryOperator<LogicalSort> {

    protected final List<Expr> sortFields;
    protected final SortOrder order;

    public SortOperator(Operator child, LogicalSort logicalSort) {
        super(child, logicalSort);
        this.sortFields = logicalSort.getSortFields();
        this.order = logicalSort.getOrder();
    }

    @Override
    public Tuple next() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        return "SORT";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(Utils.format(sortFields, ","));
        sb.append("  ");
        sb.append(order);
    }

}
