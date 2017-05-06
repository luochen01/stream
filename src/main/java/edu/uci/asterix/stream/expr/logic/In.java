package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

public class In extends BinaryPredicateExpr {

    public In(Expr left, Expr right) {
        super("IN", left, right);

        Assertion.asserts(right.getResultType().getFieldTypeName() == FieldTypeName.ARRAY,
                "RHS of IN must be array field");
        Assertion.asserts(left.getResultType().equals(right.getResultType().getElementType()),
                "LHS and RHS of IN must have same data type");
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

    @Override
    public LogicExpr dual() {
        return new NotIn(left, right);
    }

}
