package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

import java.util.List;

public class Sum extends AggregateExpr {

    private FieldTypeName resultType;
    private String fieldName;

    public Sum(Expr child) {
        super("SUM", child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "SUM only applies to numerical field");

        resultType = child.getResultType().getFieldTypeName();
        fieldName = child.toField().getFieldName();
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Sum(children[0]);
    }

    @Override
    public Object compute(Object[] key, Object currentValue, Tuple input) {

        int id = input.getSchema().getFieldIndex(fieldName);

        if (child.getResultType().getFieldTypeName().isNumerical()) {
            if(resultType == FieldTypeName.INTEGER){
                if (currentValue == null) {
                    return input.get(id);
                }
                return (int)currentValue + (int)input.get(id);
            }
            else{
                if(currentValue == null ){
                    return input.get(id);
                }
                return (double)currentValue + (double)input.get(id);
            }
        }

        return null;
    }

}
