package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

import java.util.List;

public class Min extends AggregateExpr {

    private FieldTypeName resultType;
    private String fieldName;

    public Min(Expr child) {
        super("MIN", child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "MIN only applies to numerical field");
        resultType = child.getResultType().getFieldTypeName();
        fieldName = child.toField().getFieldName();
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Min(children[0]);
    }

    @Override
    public Object compute(Object[] key, Object currentValue, Tuple input) {

        int id = input.getSchema().getFieldIndex(fieldName);

        if (child.getResultType().getFieldTypeName().isNumerical()) {
            if(resultType == FieldTypeName.INTEGER){
                if (currentValue == null || (int)input.get(id) < (int)currentValue) {
                    return input.get(id);
                }
            }
            else{
                if(currentValue == null || (double)input.get(id) < (double)currentValue){
                    return input.get(id);
                }
            }
            return currentValue;
        }

        return null;
    }

}
