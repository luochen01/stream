package edu.uci.asterix.stream.function.impl;

import edu.uci.asterix.stream.catalog.Catalog;
import edu.uci.asterix.stream.catalog.CatalogException;
import edu.uci.asterix.stream.execution.DefaultSystemTimeProvider;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.function.Function0;
import edu.uci.asterix.stream.utils.Utils;

public class Time extends Function0 {
    public static final Time INSTANCE = new Time();

    static {
        try {
            Catalog.INSTANCE.addFunction(INSTANCE);
        } catch (CatalogException e) {
            e.printStackTrace();
        }
    }

    private Time() {
        super("time");
    }

    @Override
    public FieldType getReturnType() {
        return PrimitiveType.get(FieldTypeName.STRING);
    }

    @Override
    public Object eval() {
        return Utils.getTimeString(DefaultSystemTimeProvider.INSTANCE.currentTimeMillis());
    }
}
