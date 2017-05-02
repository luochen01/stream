package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;

public class Count extends AggregateExpr {

    public Count(Expr child) {
        super(child);
    }

    @Override
    public FieldType getResultType() {
        return PrimitiveType.get(FieldTypeName.INTEGER);
    }

}
