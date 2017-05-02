package edu.uci.asterix.stream.logical;

import java.util.List;

import edu.uci.asterix.stream.expr.SortOrder;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public class LogicalSort extends UnaryLogicalPlan {

    protected final List<Field> sortFields;
    protected final SortOrder order;

    public LogicalSort(LogicalPlan child, List<Field> sortFields, SortOrder order) {
        super(child);
        this.sortFields = sortFields;
        this.order = order;
    }

    @Override
    public StructType getSchema() {
        return child.getSchema();
    }

}
