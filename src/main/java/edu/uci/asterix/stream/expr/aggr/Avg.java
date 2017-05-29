package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.GroupbyKey;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

import java.security.acl.Group;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avg extends AggregateExpr {

    private FieldTypeName resultType;
    private String fieldName;
    private Map<GroupbyKey, Integer> groupCounts;

    public Avg(Expr child) {
        super("AVG", child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "AVG only applies to numerical field");
        resultType = child.getResultType().getFieldTypeName();
        fieldName = child.toField().getFieldName();
        groupCounts = new HashMap<>();
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Avg(children[0]);
    }

    @Override
    public Object compute(Object[] key, Object currentValue, Tuple input) {

        GroupbyKey groupbyKey = new GroupbyKey(key);

        int id = input.getSchema().getFieldIndex(fieldName);
        if (child.getResultType().getFieldTypeName().isNumerical()) {


            int totalSlot = 1;
            if(groupCounts.get(groupbyKey) != null){
                totalSlot = groupCounts.get(groupbyKey)+1;
            }

            groupCounts.put(groupbyKey, totalSlot);


            if(resultType == FieldTypeName.INTEGER){
                if (currentValue == null ) {
                    return input.get(id);
                }
                return ((Integer)currentValue + (Integer) input.get(id)) / totalSlot;
            }
            else{
                if (currentValue == null ) {
                    return Double.parseDouble(input.get(id).toString());
                }
                return ((Double)currentValue + (Double) input.get(id)) / (double)totalSlot;
            }

        }

        return null;
    }

}
