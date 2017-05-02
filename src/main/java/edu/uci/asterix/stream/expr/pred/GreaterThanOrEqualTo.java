package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldTypeName;

public class GreaterThanOrEqualTo extends BinaryRelationExpr {

    public GreaterThanOrEqualTo(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public Object eval(Tuple input) {
        Object leftEval = left.eval(input);
        Object rightEval = right.eval(input);
        if (leftEval == null || rightEval == null) {
            return null;
        }
        FieldTypeName leftType = left.getResultType().getFieldTypeName();
        FieldTypeName rightType = left.getResultType().getFieldTypeName();
        if (leftType == FieldTypeName.INTEGER) {
            if (rightType == FieldTypeName.INTEGER) {
                return (int) leftEval >= (int) rightEval;
            } else {
                return (int) leftEval >= (double) rightEval;
            }
        } else {
            if (rightType == FieldTypeName.INTEGER) {
                return (double) leftEval >= (int) rightEval;
            } else {
                return (double) leftEval >= (double) rightEval;
            }
        }
    }

}
