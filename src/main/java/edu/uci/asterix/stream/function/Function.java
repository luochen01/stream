package edu.uci.asterix.stream.function;

import edu.uci.asterix.stream.field.FieldType;

/**
 * Defines function applied on fields (possibely UDFs?)
 * 
 * @author luochen
 */
public interface Function {

    public String getName();

    public int numParams();

    public FieldType getParamType(int i);

    public FieldType getReturnType();

    public Object eval(Object... params);
}
