package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.execution.Tuple;

public class Or extends BinaryPredicateExpr {

    public Or(TermExpr left, TermExpr right) {
        super("OR", left, right);
    }

    @Override
    public Object eval(Tuple input) {
        Object leftEval = left.eval(input);
        if (leftEval == null) {
            return null;
        }
        if ((boolean) leftEval) {
            return true;
        }
        return right.eval(input);
    }

}
