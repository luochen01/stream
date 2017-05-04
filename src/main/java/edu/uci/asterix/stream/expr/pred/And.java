package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.execution.Tuple;

public class And extends BinaryPredicateExpr {

    public And(TermExpr left, TermExpr right) {
        super("AND", left, right);
    }

    @Override
    public Object eval(Tuple input) {
        Object leftEval = left.eval(input);
        if (leftEval == null) {
            return null;
        }
        if (!(boolean) leftEval) {
            return false;
        }
        return right.eval(input);
    }

}