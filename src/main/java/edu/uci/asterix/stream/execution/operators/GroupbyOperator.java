package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<String, List<Tuple>>groups = new HashMap<>();

    public GroupbyOperator(Operator child, LogicalGroupby logicalGroupby) {
        super(child, logicalGroupby);
        this.byFields = logicalGroupby.getByFields();
        this.aggregateExprs = logicalGroupby.getAggregateExprs();

        Tuple tuple;
        while((tuple = child.next()) != null)
        {
            String keyString ="";
            for(Expr expr: byFields)
            {

                keyString+=expr.eval(tuple).toString();
            }
            List<Tuple> groupValues = groups.get(keyString);
            if(groupValues != null)
            {
                groupValues.add(tuple);
                groups.put(keyString, groupValues);
            }
            else{
                List<Tuple> valueList = new ArrayList<>();
                valueList.add(tuple);
                groups.put(keyString, valueList);
            }

        }

        for(AggregateExpr agexpr:aggregateExprs)
        {
            for(String key :groups.keySet()){
                List<Tuple> tuples = groups.get(key);
                for(Tuple t: tuples){
                    //TODO:Check the correctness
                   agexpr.eval(t);
                }
            }
        }

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
