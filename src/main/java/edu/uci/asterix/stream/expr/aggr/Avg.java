package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avg extends AggregateExpr {

    private FieldTypeName resultType;
    private int fieldID;
    private Map<Object[], Integer> groupCounts;

    public Avg(Expr child) {
        super("AVG", child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "AVG only applies to numerical field");
        resultType = child.getResultType().getFieldTypeName();
        fieldID = child.getId();
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

        if (child.getResultType().getFieldTypeName().isNumerical()) {


            int totalSlot = 1;
            if(groupCounts.get(key) != null){
                totalSlot = groupCounts.get(key)+1;
            }

            groupCounts.put(key, totalSlot);

            if (currentValue == null ) {
                return input.get(fieldID);
            }
            if(resultType == FieldTypeName.INTEGER){
                return (int)currentValue + (int)input.get(fieldID) / totalSlot;
            }
            else{
                return (double)currentValue + (double)input.get(fieldID) / totalSlot;
            }

        }

        return null;
    }

}
