package edu.uci.asterix.stream.execution.operators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.aggr.AggregateExpr;
import edu.uci.asterix.stream.logical.LogicalGroupby;
import edu.uci.asterix.stream.utils.Utils;

public class GroupbyOperator extends UnaryOperator<LogicalGroupby> {

    protected final List<Expr> byFields;

    //e.g., count(*) as count
    protected final List<AggregateExpr> aggregateExprs;

    private Iterator<Entry<GroupbyKey, Object[]>> iterator;

    private Map<GroupbyKey, Object[]> groups;

    public GroupbyOperator(Operator child, LogicalGroupby logicalGroupby) {
        super(child, logicalGroupby);
        this.byFields = logicalGroupby.getByFields();
        this.aggregateExprs = logicalGroupby.getAggregateExprs();

    }

    @Override
    public Tuple next() {
        if (iterator != null && iterator.hasNext()) {
            Entry<GroupbyKey, Object[]> e = iterator.next();
            GroupbyKey byFields = e.getKey();
            Object[] aggValues = e.getValue();

            Object[] mergedValues = new Object[byFields.keys.length + aggValues.length];
            int index = 0;
            for (Object value : byFields.keys) {
                mergedValues[index++] = value;
            }
            for (Object value : aggValues) {
                mergedValues[index++] = value;
            }
            return new Tuple(getSchema(), mergedValues);
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

        this.groups = new HashMap<>();

        Tuple tuple;
        while ((tuple = child.next()) != null) {

            Object[] key = new Object[byFields.size()];

            //Get key using byFields
            int index = 0;
            for (Expr expr : byFields) {
                key[index++] = expr.eval(tuple);
            }

            //Get aggregate values
            GroupbyKey groupbyKey = new GroupbyKey(key);

            Object[] groupValues = groups.get(groupbyKey);

            if (groupValues == null) {
                groupValues = new Object[aggregateExprs.size()];
                groups.put(groupbyKey, groupValues);
            }

            int currentPosition = 0;
            for (AggregateExpr agg : aggregateExprs) {
                Object currentValue = groupValues[currentPosition];
                groupValues[currentPosition] = agg.compute(groupbyKey, currentValue, tuple);
                currentPosition++;
            }

        }
        iterator = groups.entrySet().iterator();
    }

    @Override
    public void reset() {
        super.reset();

        if (groups != null) {
            groups.clear();
            groups = null;
        }
        aggregateExprs.forEach(expr -> expr.reset());
        iterator = null;
    }

    @Override
    public int hashCode() {
        return groups.hashCode();
    }

    @Override
    protected void printContent(StringBuilder sb) {

        sb.append(Utils.format(byFields, ","));
        sb.append("\t");
        sb.append(Utils.format(aggregateExprs, ","));
        sb.append("\t");
    }

}
