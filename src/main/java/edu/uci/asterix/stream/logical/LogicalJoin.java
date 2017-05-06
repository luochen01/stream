package edu.uci.asterix.stream.logical;

import java.util.ArrayList;
import java.util.List;

import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public class LogicalJoin extends BinaryLogicalPlan {

    private LogicExpr condition;

    private StructType schema;

    private boolean equiJoin;

    public LogicalJoin(LogicalPlan left, LogicalPlan right, LogicExpr condition, boolean equiJoin) {
        super(left, right);
        this.condition = condition;

        List<Field> fields = new ArrayList<>();
        fields.addAll(left.getSchema().getFields());
        fields.addAll(right.getSchema().getFields());
        schema = new StructType(fields);
    }

    @Override
    public StructType getSchema() {
        return schema;
    }

    @Override
    public String getName() {
        return "JOIN";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(condition);

    }

    public boolean equiJoin() {
        return equiJoin;
    }

}
