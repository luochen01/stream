package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.BinaryExpr;
import edu.uci.asterix.stream.expr.Expr;

public class Or extends BinaryExpr<LogicExpr> implements LogicExpr {

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

    @Override
    public Expr withChildren(Expr... children) {
        return new Or((LogicExpr) children[0], (LogicExpr) children[1]);
    }

}
