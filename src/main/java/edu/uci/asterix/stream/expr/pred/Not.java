package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.execution.Tuple;

public class Not extends UnaryPredicateExpr {

    public Not(TermExpr child) {
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