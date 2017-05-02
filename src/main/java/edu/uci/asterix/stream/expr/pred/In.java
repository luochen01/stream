package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

public class In extends BinaryRelationExpr {

    public In(Expr left, Expr right) {
        super(left, right);

        Assertion.asserts(right.getResultType().getFieldTypeName() == FieldTypeName.ARRAY);
        Assertion.asserts(left.getResultType().equals(right.getResultType().getElementType()));
    }

    @Override
    public Object eval(Tuple input) {
        Object leftEval = left.eval(input);
        if (leftEval == null) {
            return null;
        }
        Object rightEval = right.eval(input);
        if (rightEval == null) {
            return null;
        }
        Object[] rightArray = (Object[]) rightEval;
        for (Object rightValue : rightArray) {
            if (leftEval.equals(rightValue)) {
                return true;
            }
        }
        return false;
    }

}
