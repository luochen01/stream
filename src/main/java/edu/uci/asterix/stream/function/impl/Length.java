package edu.uci.asterix.stream.function.impl;

import edu.uci.asterix.stream.catalog.Catalog;
import edu.uci.asterix.stream.catalog.CatalogException;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.function.Function1;

public class Length extends Function1 {

    public static final Length INSTANCE = new Length();

    static {
        try {
            Catalog.INSTANCE.addFunction(INSTANCE);
        } catch (CatalogException e) {
            e.printStackTrace();
        }
    }

    private Length() {
        super("length", PrimitiveType.get(FieldTypeName.STRING));
    }

    @Override
    public FieldType getReturnType() {
        return PrimitiveType.get(FieldTypeName.INTEGER);
    }

    @Override
    public Object eval(Object param) {
        if (param == null) {
            return null;
        } else {
            return ((String) param).length();
        }
    }

}
