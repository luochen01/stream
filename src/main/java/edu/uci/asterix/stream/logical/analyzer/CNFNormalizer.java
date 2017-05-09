package edu.uci.asterix.stream.logical.analyzer;

import edu.uci.asterix.stream.expr.logic.And;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.expr.logic.Not;
import edu.uci.asterix.stream.expr.logic.Or;
import edu.uci.asterix.stream.expr.logic.PredicateExpr;

public class CNFNormalizer {
    public static final CNFNormalizer INSTANCE = new CNFNormalizer();

    private CNFNormalizer() {

    }

    public LogicExpr toCNF(LogicExpr expr) {
        LogicExpr pushedNot = eliminateNot(expr);

        return distribute(pushedNot);
    }

    private LogicExpr eliminateNot(LogicExpr expr) {
        if (expr instanceof Not) {
            LogicExpr child = ((Not) expr).getChild();
            if (child instanceof And) {
                And and = (And) child;
                LogicExpr transformedLeft = eliminateNot(new Not(and.getLeft()));
                LogicExpr transformedRight = eliminateNot(new Not(and.getRight()));
                return new Or(transformedLeft, transformedRight);
            } else if (child instanceof Or) {
                Or or = (Or) child;
                LogicExpr transformedLeft = eliminateNot(new Not(or.getLeft()));
                LogicExpr transformedRight = eliminateNot(new Not(or.getRight()));
                return new And(transformedLeft, transformedRight);
            } else if (child instanceof Not) {
                return eliminateNot(((Not) child).getChild());
            } else if (child instanceof PredicateExpr) {
                return ((PredicateExpr) child).dual();
            }

        } else if (expr instanceof And) {
            And and = (And) expr;
            return new And(eliminateNot(and.getLeft()), eliminateNot(and.getRight()));
        } else if (expr instanceof Or) {
            Or or = (Or) expr;
            return new Or(eliminateNot(or.getLeft()), eliminateNot(or.getRight()));
        } else {
            //must be predicate expr
            return expr;
        }
        throw new IllegalArgumentException("Unknown LogicExpr " + expr);
    }

    private LogicExpr distribute(LogicExpr expr) {
        if (expr instanceof And) {
            And and = (And) expr;
            return new And(distribute(and.getLeft()), distribute(and.getRight()));
        } else if (expr instanceof Or) {
            Or or = (Or) expr;
            LogicExpr dleft = distribute(or.getLeft());
            LogicExpr dright = distribute(or.getRight());

            if (dleft instanceof And && dright instanceof And) {
                And leftAnd = (And) dleft;
                And rightAnd = (And) dright;
                LogicExpr expr1 = new Or(leftAnd.getLeft(), rightAnd.getLeft());
                LogicExpr expr2 = new Or(leftAnd.getLeft(), rightAnd.getRight());
                LogicExpr expr3 = new Or(leftAnd.getRight(), rightAnd.getLeft());
                LogicExpr expr4 = new Or(leftAnd.getRight(), rightAnd.getRight());
                return new And(new And(expr1, expr2), new And(expr3, expr4));
            } else if (dleft instanceof And) {
                And leftAnd = (And) dleft;
                return new And(new Or(leftAnd.getLeft(), dright), new Or(leftAnd.getRight(), dright));
            } else if (dright instanceof And) {
                And rightAnd = (And) dright;
                return new And(new Or(dleft, rightAnd.getLeft()), new Or(dleft, rightAnd.getRight()));
            } else {
                return or;
            }
        } else if (expr instanceof PredicateExpr) {
            return expr;
        }
        throw new IllegalArgumentException("Unknown LogicExpr " + expr);
    }

}
