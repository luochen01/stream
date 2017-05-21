package edu.uci.asterix.stream.execution.operators;

import java.util.*;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.aggr.AggregateExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.logical.LogicalGroupby;
import edu.uci.asterix.stream.utils.Utils;

public class GroupbyOperator extends UnaryOperator<LogicalGroupby> {

    protected final List<Expr> byFields;

    //e.g., count(*) as count
    protected final List<AggregateExpr> aggregateExprs;

    private Map<List<Object>, Object>groups = new HashMap<>();
    //TODO:Gift-shiva -each eval works on it's operator and returns based on that. read the comments from chen. We need to implement aggregate. Aggregation should be done on the fly based on aggregation type(make a map<List<Object>,int/double>
    public GroupbyOperator(Operator child, LogicalGroupby logicalGroupby) {
        super(child, logicalGroupby);
        this.byFields = logicalGroupby.getByFields();
        this.aggregateExprs = logicalGroupby.getAggregateExprs();

        Tuple tuple;
        while((tuple = child.next()) != null)
        {
            List<Object> key = new LinkedList<>();
            for(Expr expr: byFields)
            {
                key.add(expr.eval(tuple));
            }
            Object groupValues = groups.get(key);
            if(groupValues != null)
            {
                groupValues = (double) groupValues +1;
                groups.put(key, groupValues);
            }
            else{
                double value=0;
                groups.put(key, value);
            }

        }

//        for(AggregateExpr agexpr:aggregateExprs)
//        {
//            for(String key :groups.keySet()){
//                List<Tuple> tuples = groups.get(key);
//                for(Tuple t: tuples){
//                    //TODO:Check the correctness
//                   agexpr.eval(t);
//                }
//            }
//        }

    }

    @Override
    public Tuple next() {
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
