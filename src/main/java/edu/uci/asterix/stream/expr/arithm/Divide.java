package edu.uci.asterix.stream.expr.arithm;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldTypeName;

public class Divide extends BinaryArithmeticExpr {

    public Divide(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public Object eval(Tuple input) {
        Object leftVal = left.eval(input);
        Object rightVal = right.eval(input);

        FieldTypeName leftType = left.getResultType().getFieldTypeName();
        FieldTypeName rightType = right.getResultType().getFieldTypeName();
        if (leftVal == null || rightVal == null) {
            return null;
        }
        if (leftType == FieldTypeName.INTEGER) {
            if (rightType == FieldTypeName.INTEGER) {
                return (int) leftVal / (int) rightVal;
            } else {
                return (int) leftVal / (double) rightVal;
            }
        } else {
            if (rightType == FieldTypeName.INTEGER) {
                return (double) leftVal / (int) rightVal;
            } else {
                return (double) leftVal / (double) rightVal;
            }
        }
    }

}
