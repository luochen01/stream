package edu.uci.asterix.stream.execution.operators;

import java.util.*;

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

    private Iterator<Object[]> iterator;

    private Map<Object[], Tuple>groups = new HashMap<>();


    public GroupbyOperator(Operator child, LogicalGroupby logicalGroupby) {
        super(child, logicalGroupby);
        this.byFields = logicalGroupby.getByFields();
        this.aggregateExprs = logicalGroupby.getAggregateExprs();

        StructType currentSchema = logicalGroupby.getSchema();
        StructType childSchema = child.getSchema();
        Object[] groupValues = new Object[currentSchema.getFields().size()];
        Object[] key = new Object[byFields.size()];

        Tuple tuple;

        while((tuple = child.next()) != null) {

            //Get key using byFields

            for(Expr expr: byFields) {

                String byFieldName = expr.toField().getFieldName();
                int byFieldPosition = currentSchema.getFieldIndex(byFieldName);
                groupValues[byFieldPosition] = tuple.get(childSchema.getFieldIndex(byFieldName));

                key[byFieldPosition] = expr.eval(tuple);

            }

            //Get aggregate values
            Tuple groupKey = groups.get(key);


            if(groupKey != null) {
                groupValues = groupKey.getAllValues();
                for(AggregateExpr agg:aggregateExprs) {
                    int currentPosition = logicalGroupby.getSchema().getFieldIndex(agg.toField().getFieldName());
                    Object currentValue = groupValues[currentPosition];
                    groupValues[currentPosition] = agg.compute(key, currentValue,tuple);
                }
            }
            else {
                for(AggregateExpr agg:aggregateExprs) {
                    int currentPosition = logicalGroupby.getSchema().getFieldIndex(agg.toField().getFieldName());
                    groupValues[currentPosition] = agg.compute(key,null,tuple);
                }
            }

            Tuple newTuple = new Tuple(currentSchema, groupValues);
            groups.put(key, newTuple);

        }
        iterator = groups.keySet().iterator();

    }

    @Override
    public Tuple next()
    {
        if(iterator.hasNext()) {
            return groups.get(iterator.next());
        }
        return null;
    }

    @Override
    public String getName() {
        return "GROUP BY";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(Utils.format(byFields, ","));
        sb.append("\t");
        sb.append(Utils.format(aggregateExprs, ","));
        sb.append("\t");
    }
}
