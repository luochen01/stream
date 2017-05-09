package edu.uci.asterix.stream.expr.logic;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;

public interface LogicExpr extends Expr {

    @Override
    public default FieldType getResultType() {
        return PrimitiveType.get(FieldTypeName.BOOLEAN);
    }

}
