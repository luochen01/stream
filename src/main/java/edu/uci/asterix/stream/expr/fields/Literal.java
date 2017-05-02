package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.LeafExpr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;

public class Literal extends LeafExpr {

    private final Object value;

    private final FieldType fieldType;

    public Literal(Object value, FieldTypeName typeName) {
        this.value = value;
        this.fieldType = PrimitiveType.get(typeName);
    }

    @Override
    public FieldType getResultType() {
        return fieldType;
    }

    @Override
    public Object eval(Tuple input) {
        return value;
    }

}
