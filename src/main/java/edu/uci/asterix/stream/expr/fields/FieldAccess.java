package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.LeafExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Assertion;

public class FieldAccess extends LeafExpr {

    private final Field field;

    private final int fieldIndex;

    public FieldAccess(Field field, StructType schema) {
        this.field = field;
        this.fieldIndex = schema.getFieldIndex(field);
        Assertion.asserts(schema.getFieldIndex(field) >= 0);
    }

    @Override
    public FieldType getResultType() {
        return field.getFieldType();
    }

    @Override
    public Object eval(Tuple input) {
        return input.get(fieldIndex);
    }

}
