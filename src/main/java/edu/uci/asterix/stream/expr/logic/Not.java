package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;

public class Not extends UnaryLogicExpr {

    public Not(LogicExpr child) {
        super("NOT", child);
    }

    @Override
    public Object eval(Tuple input) {
        Object childEval = child.eval(input);
        if (childEval == null) {
            return null;
        }
        return !(boolean) childEval;
    }

}
