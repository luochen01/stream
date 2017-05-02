package edu.uci.asterix.stream.execution.operators;

import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.SortOrder;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public class SortOperator extends UnaryOperator {

    protected final List<Field> sortFields;
    protected final SortOrder order;

    public SortOperator(Operator child, List<Field> sortFields, SortOrder order) {
        super(child);
        this.sortFields = sortFields;
        this.order = order;
    }

    @Override
    public StructType getSchema() {
        return child.getSchema();
    }

    @Override
    protected Tuple nextImpl() {
        //TODO
        return null;
    }

}
