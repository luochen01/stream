package edu.uci.asterix.stream.field;

import java.util.HashMap;
import java.util.Map;

public class PrimitiveType extends AbstractFieldType {

    private static final Map<FieldTypeName, PrimitiveType> types = new HashMap<>();

    static {
        types.put(FieldTypeName.BOOLEAN, new PrimitiveType(FieldTypeName.BOOLEAN));
        types.put(FieldTypeName.INTEGER, new PrimitiveType(FieldTypeName.INTEGER));
        types.put(FieldTypeName.REAL, new PrimitiveType(FieldTypeName.REAL));
        types.put(FieldTypeName.STRING, new PrimitiveType(FieldTypeName.STRING));
    }

    public static PrimitiveType get(FieldTypeName typeName) {
        if (typeName == null) {
            return null;
        } else {
            PrimitiveType type = types.get(typeName);
            return type;
        }
    }

    private PrimitiveType(FieldTypeName typeName) {
        super(typeName);
    }

    @Override
    public FieldType upcast(FieldType another) {
        if (!typeName.isNumerical() || !another.getFieldTypeName().isNumerical()) {
            throw new UnsupportedOperationException();
        }
        if (another.getFieldTypeName() == FieldTypeName.REAL) {
            return another;
        } else {
            return this;
        }
    }

    @Override
    public boolean compatible(FieldType another) {
        if (this.getFieldTypeName() == another.getFieldTypeName()) {
            return true;
        }
        return this.getFieldTypeName().isNumerical() && another.getFieldTypeName().isNumerical();
    }

    @Override
    public String toString() {
        return typeName.toString();
    }

}
