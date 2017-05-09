package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;

public class EqualTo extends BinaryPredicateExpr {

    public EqualTo(Expr left, Expr right) {
        super("=", left, right);
    }

    @Override
    public Object eval(Tuple input) {
        Object leftEval = left.eval(input);
        Object rightEval = right.eval(input);
        if (leftEval == null || rightEval == null) {
            return null;
        }
        return leftEval.equals(rightEval);
    }

    @Override
    public PredicateExpr dual() {
        return new NotEqualTo(left, right);
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new EqualTo(children[0], children[1]);
    }

}
