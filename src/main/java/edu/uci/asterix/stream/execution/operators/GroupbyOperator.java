package edu.uci.asterix.stream.execution.operators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.aggr.AggregateExpr;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalGroupby;
import edu.uci.asterix.stream.utils.Utils;

public class GroupbyOperator extends UnaryOperator<LogicalGroupby> {

    protected final List<Expr> byFields;

    //e.g., count(*) as count
    protected final List<AggregateExpr> aggregateExprs;

    private final Iterator<Object[]> iterator;

    private final Map<Object[], Tuple> groups = new HashMap<>();

    public GroupbyOperator(Operator child, LogicalGroupby logicalGroupby) {
        super(child, logicalGroupby);
        this.byFields = logicalGroupby.getByFields();
        this.aggregateExprs = logicalGroupby.getAggregateExprs();

        StructType currentSchema = logicalGroupby.getSchema();
        StructType childSchema = child.getSchema();
        Object[] groupValues = new Object[currentSchema.getFields().size()];
        Object[] key = new Object[byFields.size()];

        Tuple tuple;

        while ((tuple = child.next()) != null) {

            //Get key using byFields

            for (Expr expr : byFields) {

                String byFieldName = expr.toField().getFieldName();
                int byFieldPosition = currentSchema.getFieldIndex(byFieldName);
                groupValues[byFieldPosition] = tuple.get(childSchema.getFieldIndex(byFieldName));

                key[byFieldPosition] = expr.eval(tuple);

            }

            //Get aggregate values
            Tuple groupKey = groups.get(key);

            if (groupKey != null) {
                groupValues = groupKey.getAllValues();
                for (AggregateExpr agg : aggregateExprs) {
                    int currentPosition = logicalGroupby.getSchema().getFieldIndex(agg.toField().getFieldName());
                    Object currentValue = groupValues[currentPosition];
                    groupValues[currentPosition] = agg.compute(key, currentValue, tuple);
                }
            } else {
                for (AggregateExpr agg : aggregateExprs) {
                    int currentPosition = logicalGroupby.getSchema().getFieldIndex(agg.toField().getFieldName());
                    groupValues[currentPosition] = agg.compute(key, null, tuple);
                }
            }

            Tuple newTuple = new Tuple(currentSchema, groupValues);
            groups.put(key, newTuple);

        }
        iterator = groups.keySet().iterator();

    }

    @Override
    public Tuple next() {
        if (iterator.hasNext()) {
            return groups.get(iterator.next());
        }
        return null;
    }

    @Override
    public String getName() {
        return "GROUP BY";
    }

    @Override
    public void initialize() {
        super.initialize();
        //TODO implement initialize for gorup by
    }

    @Override
    public void reset() {
        super.reset();
        //TODO implement reset for group by
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(Utils.format(byFields, ","));
        sb.append("\t");
        sb.append(Utils.format(aggregateExprs, ","));
        sb.append("\t");
    }
}
