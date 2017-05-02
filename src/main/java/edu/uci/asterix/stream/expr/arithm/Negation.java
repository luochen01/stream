package edu.uci.asterix.stream.expr.arithm;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;

public class Negation extends UnaryArithmeticExpr {

    public Negation(Expr child) {
        super(child);
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

    @Override
    public Object eval(Tuple input) {
        Object childEval = child.eval(input);
        if (childEval == null) {
            return null;
        }
        if (getResultType().getFieldTypeName() == FieldTypeName.INTEGER) {
            return -(int) childEval;
        } else {
            return -(double) childEval;
        }
    }

}
