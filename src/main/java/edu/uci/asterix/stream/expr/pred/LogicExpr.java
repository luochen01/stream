package edu.uci.asterix.stream.expr.pred;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;

public abstract class LogicExpr extends Expr {

    public LogicExpr(String symbol) {
        super(symbol);
    }

    @Override
    public FieldType getResultType() {
        return PrimitiveType.get(FieldTypeName.BOOLEAN);
    }

}
