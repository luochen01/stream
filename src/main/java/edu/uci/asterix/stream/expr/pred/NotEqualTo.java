package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;

public class NotEqualTo extends BinaryTermExpr {

    public NotEqualTo(Expr left, Expr right) {
        super("!=", left, right);
    }

    @Override
    public Object eval(Tuple input) {
        Object leftEval = left.eval(input);
        Object rightEval = right.eval(input);
        if (leftEval == null || rightEval == null) {
            return null;
        }
        return !leftEval.equals(rightEval);
    }

}
