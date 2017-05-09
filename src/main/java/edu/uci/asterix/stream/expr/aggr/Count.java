package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;

/**
 * Current only support count(*)
 * child must be {@link AllFields}
 * 
 * @author luochen
 */
public class Count extends AggregateExpr {

    public Count(Expr child) {
        super("COUNT", child);
    }

    @Override
    public FieldType getResultType() {
        return PrimitiveType.get(FieldTypeName.INTEGER);
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Count(children[0]);
    }

}
