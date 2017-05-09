package edu.uci.asterix.stream.logical;

import java.util.ArrayList;
import java.util.List;

import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public class LogicalJoin extends BinaryLogicalPlan {

    private final LogicExpr condition;

    private final StructType schema;

    private final boolean equiJoin;

    public LogicalJoin(LogicalPlan left, LogicalPlan right, LogicExpr condition, boolean equiJoin) {
        super(left, right);
        this.condition = condition;
        this.equiJoin = equiJoin;
        List<Field> fields = new ArrayList<>();
        fields.addAll(left.getSchema().getFields());
        fields.addAll(right.getSchema().getFields());
        schema = new StructType(fields);
    }

    public LogicExpr getJoinCondition() {
        return condition;
    }

    public boolean isEquiJoin() {
        return equiJoin;
    }

    @Override
    public StructType getSchema() {
        return schema;
    }

    @Override
    public String getName() {
        return "LOGICAL JOIN";
    }

    @Override
    protected void printContent(StringBuilder sb, int level) {
        sb.append(condition);

    }

}
