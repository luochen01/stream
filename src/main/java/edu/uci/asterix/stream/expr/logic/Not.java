package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;

public class Not extends UnaryExpr<LogicExpr> implements LogicExpr {

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

    @Override
    public Expr withChildren(Expr... children) {
        return new Not((LogicExpr) children[0]);
    }

}
