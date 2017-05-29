package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.catalog.TableImpl;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.aggr.*;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.logic.And;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalGroupby;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.logical.LogicalTableScan;
import edu.uci.asterix.stream.logical.analyzer.LogicalPlanAnalyzerTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashJoinOperatorTest extends LogicalPlanAnalyzerTest {

    @Test
    public void testBasic() throws Exception {

        StructType schema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field(infId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));

        StructType lSchema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));
        StructType rSchema = new StructType(
                Arrays.asList(new Field(infId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));
        List<Tuple> tuplesL = Arrays.asList(getTuple(111, lSchema), getTuple(222, lSchema), getTuple(333, lSchema), getTuple(444, lSchema));
        List<Tuple> tuplesR = Arrays.asList(getTuple(111, rSchema), getTuple(777, rSchema), getTuple(222, rSchema),getTuple(333, rSchema));


        LogicExpr filterExpr = new EqualTo(senId, infId);

        HashJoinOperator hashJoinOperator = new HashJoinOperator(new ListOperator(lSchema, tuplesL), new ListOperator(rSchema, tuplesR), mockHashJoin(schema,filterExpr));
        hashJoinOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(hashJoinOperator);

        Assert.assertEquals(3, resultTuples.size());

        Assert.assertTrue(resultTuples.contains(getResultTuple(111,111, schema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222,222, schema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(333,333, schema)));

        Assert.assertEquals(schema, resultTuples.get(0).getSchema());

    }

    @Test
    public void testEmptyRight() throws Exception {

        StructType schema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field(infId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));

        StructType lSchema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));
        StructType rSchema = new StructType(
                Arrays.asList(new Field(infId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));
        List<Tuple> tuplesL = Arrays.asList(getTuple(111, lSchema), getTuple(222, lSchema), getTuple(333, lSchema), getTuple(444, lSchema));
        List<Tuple> tuplesR = Arrays.asList();


        LogicExpr filterExpr = new EqualTo(senId, infId);

        HashJoinOperator hashJoinOperator = new HashJoinOperator(new ListOperator(lSchema, tuplesL), new ListOperator(rSchema, tuplesR), mockHashJoin(schema,filterExpr));
        hashJoinOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(hashJoinOperator);

        Assert.assertEquals(0, resultTuples.size());


    }

    @Test
    public void testEmptyLeft() throws Exception {

        StructType schema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field(infId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));

        StructType lSchema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));
        StructType rSchema = new StructType(
                Arrays.asList(new Field(infId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));
        List<Tuple> tuplesL = Arrays.asList();
        List<Tuple> tuplesR = Arrays.asList(getTuple(111, rSchema), getTuple(777, rSchema), getTuple(222, rSchema),getTuple(333, rSchema));



        LogicExpr filterExpr = new EqualTo(senId, infId);

        HashJoinOperator hashJoinOperator = new HashJoinOperator(new ListOperator(lSchema, tuplesL), new ListOperator(rSchema, tuplesR), mockHashJoin(schema,filterExpr));
        hashJoinOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(hashJoinOperator);

        Assert.assertEquals(0, resultTuples.size());


    }

    @Test
    public void testMultipleJoinRecords() throws Exception {

        StructType schema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field("stat", PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field(infId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));

        StructType lSchema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field("stat", PrimitiveType.get(FieldTypeName.INTEGER))));
        StructType rSchema = new StructType(
                Arrays.asList(new Field(infId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER))));
        List<Tuple> tuplesL = Arrays.asList(getTuple(111,3, lSchema), getTuple(111,2, lSchema), getTuple(222, 7, lSchema), getTuple(222, 5, lSchema), getTuple(444,5, lSchema));
        List<Tuple> tuplesR = Arrays.asList(getTuple(111, rSchema), getTuple(777, rSchema), getTuple(222, rSchema),getTuple(333, rSchema));


        LogicExpr filterExpr = new EqualTo(senId, infId);

        HashJoinOperator hashJoinOperator = new HashJoinOperator(new ListOperator(lSchema, tuplesL), new ListOperator(rSchema, tuplesR), mockHashJoin(schema,filterExpr));
        hashJoinOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(hashJoinOperator);

        Assert.assertEquals(4, resultTuples.size());

        Assert.assertTrue(resultTuples.contains(getResultTuple(111, 3,111, schema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(111, 2,111, schema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222, 7,222, schema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222, 5,222, schema)));

        Assert.assertEquals(schema, resultTuples.get(0).getSchema());

    }

    private Tuple getTuple(int id, StructType schema) {

        return new Tuple(schema, new Object[] { id});
    }
    private Tuple getTuple(int id, int number, StructType schema) {

        return new Tuple(schema, new Object[] { id, number});
    }

    private Tuple getResultTuple(int field1, int field2, StructType schema) {

        return new Tuple(schema, new Object[] { field1, field2 });
    }

    private Tuple getResultTuple(int field1, int field2, int field3, StructType schema) {

        return new Tuple(schema, new Object[] { field1, field2, field3 });
    }

    private LogicalJoin mockHashJoin(StructType schema, LogicExpr logicExpr) {
        LogicalJoin logicalJoin = Mockito.mock(LogicalJoin.class);
        Mockito.when(logicalJoin.getJoinCondition()).thenReturn(logicExpr);
        Mockito.when(logicalJoin.isEquiJoin()).thenReturn(true);
        Mockito.when(logicalJoin.getSchema()).thenReturn(schema);
        return logicalJoin;
    }

    private List<Tuple> fetchTuples(Operator operator) {
        List<Tuple> resultTuples = new ArrayList<>();
        Tuple tuple = null;
        while ((tuple = operator.next()) != null) {
            resultTuples.add(tuple);
        }
        return resultTuples;
    }


}
