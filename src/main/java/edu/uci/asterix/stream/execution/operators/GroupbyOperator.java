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

import static edu.uci.asterix.stream.field.FieldTypeName.*;

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
            Object[] aggValues = new Object[aggregateExprs.size()];
            //Get key using byFields

            int index = 0;
            Object result;
            for (Expr expr : byFields) {
                key[index++] = expr.eval(tuple);
            }

            //Get aggregate values

            Object[] groupValues = groups.get(new GroupbyKey(key));

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

            groups.put(new GroupbyKey(key), aggValues);

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
        iterator = null;
    }

//    @Override public boolean equals(Object[] o) {
//
//
//        return groups.equals(that.groups);
//    }

    @Override public int hashCode() {
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
