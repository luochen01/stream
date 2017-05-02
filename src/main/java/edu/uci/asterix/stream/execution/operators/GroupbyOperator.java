package edu.uci.asterix.stream.execution.operators;

import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.fields.As;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public class GroupbyOperator extends UnaryOperator {

    protected final List<Field> byFields;

    //e.g., count(*) as count
    //if there is no as, the parser would automatically append one 
    protected final List<As> aggregateExprs;

    public GroupbyOperator(Operator child, List<Field> byFields, List<As> aggregateExprs) {
        super(child);
        this.byFields = byFields;
        this.aggregateExprs = aggregateExprs;
    }

    @Override
    public StructType getSchema() {
        //TODO
        return null;
    }

    @Override
    protected Tuple nextImpl() {
        //TODO
        return null;
    }

}
