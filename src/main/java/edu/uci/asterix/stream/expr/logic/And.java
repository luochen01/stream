package edu.uci.asterix.stream.expr.logic;

import java.util.List;
import java.util.Optional;

import edu.uci.asterix.stream.execution.Tuple;

public class And extends BinaryLogicExpr {

    public And(LogicExpr left, LogicExpr right) {
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

    public static LogicExpr create(List<LogicExpr> children) {
        return children.stream().reduce((left, right) -> new And(left, right)).orElse(True.INSTANCE);
    }

}
