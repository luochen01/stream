package edu.uci.asterix.stream.execution;

import java.util.Arrays;
import java.util.List;

import edu.uci.asterix.stream.field.ArrayType;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Assertion;

public class Tuple {

    public static Tuple merge(Tuple left, Tuple right, StructType resultSchema) {
        Object[] values = new Object[left.values.length + right.values.length];
        int index = 0;
        for (Object value : left.values) {
            values[index++] = value;
        }
        for (Object value : right.values) {
            values[index++] = value;
        }
        return new Tuple(resultSchema, values);
    }

    protected final Object[] values;

    protected StructType schema;

    public Tuple(StructType schema) {
        this.schema = schema;
        this.values = new Object[schema.getFieldCount()];
    }

    public Tuple(StructType schema, Object[] values) {
        this.schema = schema;
        this.values = values;
        Assertion.asserts(this.schema.getFieldCount() == values.length);
    }

    public int getFieldCount() {
        return values.length;
    }

    public Object get(int i) {
        return values[i];
    }

    public void set(int i, Object value) {
        values[i] = value;
    }

    public Object[] getAllValues() {
        return values;
    }

    public StructType getSchema() {
        return schema;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        toStructString(builder, this, schema);
        return builder.toString();
    }

    private void toStructString(StringBuilder sb, Tuple tuple, StructType schema) {
        List<Field> fields = schema.getFields();
        sb.append("{");
        for (int i = 0; i < tuple.values.length; i++) {
            sb.append(fields.get(i).getFieldName());
            sb.append(":");
            toFieldString(sb, tuple.values[i], fields.get(i).getFieldType());
            if (i < tuple.values.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
    }

    private void toArrayString(StringBuilder sb, Object[] values, ArrayType type) {
        sb.append("[");
        for (int i = 0; i < values.length; i++) {
            toFieldString(sb, values[i], type.getElementType());
            if (i < values.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

    }

    private void toFieldString(StringBuilder sb, Object value, FieldType type) {
        if (value == null) {
            sb.append("NULL");
            return;
        }
        FieldTypeName typeName = type.getFieldTypeName();
        switch (typeName) {
            case BOOLEAN:
            case INTEGER:
            case STRING:
            case REAL:
                sb.append(value);
                break;
            case ARRAY:
                toArrayString(sb, (Object[]) value, (ArrayType) type);
                break;
            case STRUCT:
                toStructString(sb, (Tuple) value, (StructType) type);
                break;
        }
    }

    public void setSchema(StructType schema) {
        this.schema = schema;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tuple other = (Tuple) obj;
        if (!Arrays.equals(values, other.values))
            return false;
        return true;
    }

}
