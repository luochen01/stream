package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.LeafExpr;
import edu.uci.asterix.stream.field.FieldType;

/**
 * Should only be used by count()
 * 
 * @author luochen
 */
public class AllFields extends LeafExpr {

    public static final AllFields INSTANCE = new AllFields();

    private AllFields() {
    }

    @Override
    public FieldType getResultType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object eval(Tuple input) {
        throw new UnsupportedOperationException();
    }

}
