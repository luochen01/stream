package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;

public class Or extends BinaryLogicExpr {

    public Or(LogicExpr left, LogicExpr right) {
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
