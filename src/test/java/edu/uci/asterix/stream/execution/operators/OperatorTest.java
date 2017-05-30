package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mockito.Mockito;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.logical.LogicalPlan;

public abstract class OperatorTest {

    protected final Field senId = new Field("senId", PrimitiveType.get(FieldTypeName.INTEGER));
    protected final Field infId = new Field("infId", PrimitiveType.get(FieldTypeName.INTEGER));
    protected final Field stat = new Field("stat", PrimitiveType.get(FieldTypeName.INTEGER));

    protected final StructType schema = new StructType(Arrays.asList(senId, infId));

    protected final StructType lSchema = new StructType(Arrays.asList(senId));
    protected final StructType rSchema = new StructType(Arrays.asList(infId));

    protected final StructType multiSchema = new StructType(Arrays.asList(senId, stat, infId));

    protected final StructType multiLSchema = new StructType(Arrays.asList(senId, stat));
    protected final StructType multiRSchema = new StructType(Arrays.asList(infId));

    protected final Expr idL = new FieldAccess(senId, schema);
    protected final Expr idR = new FieldAccess(infId, schema);
    protected final LogicExpr joinCondition = new EqualTo(idL, idR);

    protected List<Tuple> fetchTuples(Operator operator) {
        List<Tuple> resultTuples = new ArrayList<>();
        Tuple tuple = null;
        while ((tuple = operator.next()) != null) {
            resultTuples.add(tuple);
        }
        return resultTuples;
    }

    protected Tuple getTuple(int id, StructType schema) {

        return new Tuple(schema, new Object[] { id });
    }

    protected Tuple getTuple(int id, int number, StructType schema) {

        return new Tuple(schema, new Object[] { id, number });
    }

    protected Tuple getResultTuple(int field1, int field2, StructType schema) {

        return new Tuple(schema, new Object[] { field1, field2 });
    }

    protected Tuple getResultTuple(int field1, int field2, int field3, StructType schema) {

        return new Tuple(schema, new Object[] { field1, field2, field3 });
    }

    protected LogicalJoin mockJoin(StructType schema, LogicExpr logicExpr, StructType leftSchema,
            StructType rightSchema) {
        LogicalJoin logicalJoin = Mockito.mock(LogicalJoin.class);
        Mockito.when(logicalJoin.getJoinCondition()).thenReturn(logicExpr);
        Mockito.when(logicalJoin.isEquiJoin()).thenReturn(true);
        Mockito.when(logicalJoin.getSchema()).thenReturn(schema);

        LogicalPlan left = Mockito.mock(LogicalJoin.class);
        Mockito.when(left.getSchema()).thenReturn(leftSchema);
        Mockito.when(logicalJoin.getLeft()).thenReturn(left);

        LogicalPlan right = Mockito.mock(LogicalJoin.class);
        Mockito.when(right.getSchema()).thenReturn(rightSchema);
        Mockito.when(logicalJoin.getRight()).thenReturn(right);

        return logicalJoin;
    }
}
