package edu.uci.asterix.stream.execution.operators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.aggr.AggregateExpr;
import edu.uci.asterix.stream.logical.LogicalGroupby;
import edu.uci.asterix.stream.utils.Utils;

public class GroupbyOperator extends UnaryOperator<LogicalGroupby> {

    protected final List<Expr> byFields;

    //e.g., count(*) as count
    protected final List<AggregateExpr> aggregateExprs;

    private Iterator<Object[]> iterator;

    private Map<Object[], Object[]> groups = new HashMap<>();

    public GroupbyOperator(Operator child, LogicalGroupby logicalGroupby) {
        super(child, logicalGroupby);
        this.byFields = logicalGroupby.getByFields();
        this.aggregateExprs = logicalGroupby.getAggregateExprs();

    }

    @Override
    public Tuple next() {
        if (iterator.hasNext()) {
            Object[] byFields = iterator.next();
            Object[] aggValues = groups.get(byFields);

            Object[] mergedValues = new Object[byFields.length+aggValues.length];
            int index = 0;
            for (Object value : byFields) {
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

        Object[] key = new Object[byFields.size()];
        Object[] aggValues = new Object[aggregateExprs.size()];

        Tuple tuple;

        while ((tuple = child.next()) != null) {

            //Get key using byFields

            int index = 0;
            for (Expr expr : byFields) {
                key[index++] = expr.eval(tuple);
            }

            //Get aggregate values
            Object[] groupValues = groups.get(key);

            if (groupValues != null) {
                aggValues = groupValues;
                int currentPosition = 0;
                for (AggregateExpr agg : aggregateExprs) {
                    Object currentValue = aggValues[currentPosition];
                    aggValues[currentPosition] = agg.compute(key, currentValue, tuple);
                    currentPosition++;
                }
            } else {
                int currentPosition = 0;
                for (AggregateExpr agg : aggregateExprs) {
                    aggValues[currentPosition++] = agg.compute(key, null, tuple);
                }
            }

            groups.put(key, aggValues);

        }
        iterator = groups.keySet().iterator();
    }

    @Override
    public void reset() {
        super.reset();

        if (groups != null) {
            groups.clear();
            groups = null;
        }
        iterator = null;
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(Utils.format(byFields, ","));
        sb.append("\t");
        sb.append(Utils.format(aggregateExprs, ","));
        sb.append("\t");
    }
}
