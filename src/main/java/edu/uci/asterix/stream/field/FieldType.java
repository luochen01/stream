package edu.uci.asterix.stream.field;

import java.util.List;

public interface FieldType {

    public FieldTypeName getFieldTypeName();

    /**
     * for array
     * 
     * @return
     */
    public FieldType getElementType();

    /**
     * for struct type
     * 
     * @return
     */
    public List<Field> getFields();

    public int getFieldCount();

    public FieldType upcast(FieldType another);

    public boolean compatible(FieldType another);

    public int getFieldIndex(Field field);

}
