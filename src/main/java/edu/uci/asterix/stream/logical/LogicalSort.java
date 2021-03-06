package edu.uci.asterix.stream.logical;

import java.util.List;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.SortOrder;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Utils;

public class LogicalSort extends UnaryLogicalPlan {

    protected final List<Expr> sortFields;
    protected final SortOrder order;

    public LogicalSort(LogicalPlan child, List<Expr> sortFields, SortOrder order) {
        super(child);
        this.sortFields = sortFields;
        this.order = order;
    }

    public List<Expr> getSortFields() {
        return sortFields;
    }

    public SortOrder getOrder() {
        return order;
    }

    @Override
    public StructType getSchema() {
        return child.getSchema();
    }

    @Override
    public String getName() {
        return "LOGICAL SORT";
    }

    @Override
    protected void printContent(StringBuilder sb, int level) {
        sb.append(Utils.format(sortFields, ","));
        sb.append("  ");
        sb.append(order);

    }

}
