package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.catalog.TableImpl;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.aggr.*;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalGroupby;

import edu.uci.asterix.stream.logical.LogicalTableScan;
import edu.uci.asterix.stream.logical.analyzer.LogicalPlanAnalyzerTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

public class GroupByOperatorTest extends LogicalPlanAnalyzerTest {

    private final StructType testSchema = new StructType(
            Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                    new Field("count", PrimitiveType.get(FieldTypeName.INTEGER))));
    private final StructType byFieldSchema = new StructType(
            Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                    new Field("stat", PrimitiveType.get(FieldTypeName.INTEGER))));

    private final List<Expr> byFields = Arrays.asList(senId);


    @Test
    public void testBasic() throws Exception {
        Count count = new Count(new FieldAccess(Field.ALL_FIELDS, leftScan.getSchema()));
        StructType schema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field("count", PrimitiveType.get(FieldTypeName.INTEGER))));
        List<Tuple> tuples = Arrays.asList(getTuple(111, 5), getTuple(111, 2), getTuple(222, 7), getTuple(222, 5), getTuple(333, 1));
        GroupbyOperator groupbyOperator = new GroupbyOperator(new ListOperator(schema, tuples), mockLogicalGroupBy(Arrays.asList(new Count(count)), schema));
        groupbyOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(groupbyOperator);

        Assert.assertEquals(3, resultTuples.size());

        Assert.assertTrue(resultTuples.contains(getResultTuple(111,2)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222,2)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(333,1)));

        Assert.assertEquals(schema, resultTuples.get(0).getSchema());

    }

    @Test
    public void testAggregateMax() throws Exception {
        StructType schema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field("max", PrimitiveType.get(FieldTypeName.INTEGER))));

        Max max = new Max(new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.INTEGER)),  byFieldSchema));


        List<Tuple> tuples = Arrays.asList(getTuple(111, 5), getTuple(111, 2), getTuple(222, 7), getTuple(222, 5), getTuple(333, 1));
        GroupbyOperator groupbyOperator = new GroupbyOperator(new ListOperator(schema, tuples), mockLogicalGroupBy(Arrays.asList(max), schema));
        groupbyOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(groupbyOperator);

        Assert.assertEquals(3, resultTuples.size());

        Assert.assertTrue(resultTuples.contains(getResultTuple(111,5)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222,7)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(333,1)));

        Assert.assertEquals(schema, resultTuples.get(0).getSchema());
    }

    @Test
    public void testAggregateMin() throws Exception {
        StructType schema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field("min", PrimitiveType.get(FieldTypeName.INTEGER))));

        Min min = new Min(new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.INTEGER)),  byFieldSchema));


        List<Tuple> tuples = Arrays.asList(getTuple(111, 5), getTuple(111, 2), getTuple(222, 7), getTuple(222, 5), getTuple(333, 1));
        GroupbyOperator groupbyOperator = new GroupbyOperator(new ListOperator(schema, tuples), mockLogicalGroupBy(Arrays.asList(min), schema));
        groupbyOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(groupbyOperator);

        Assert.assertEquals(3, resultTuples.size());

        Assert.assertTrue(resultTuples.contains(getResultTuple(111,2)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222,5)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(333,1)));

        Assert.assertEquals(schema, resultTuples.get(0).getSchema());
    }

    @Test
    public void testAggregateSum() throws Exception {
        StructType schema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field("sum", PrimitiveType.get(FieldTypeName.INTEGER))));

        Sum sum = new Sum(new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.INTEGER)),  byFieldSchema));


        List<Tuple> tuples = Arrays.asList(getTuple(111, 5), getTuple(111, 2), getTuple(222, 7), getTuple(222, 5), getTuple(333, 1));
        GroupbyOperator groupbyOperator = new GroupbyOperator(new ListOperator(schema, tuples), mockLogicalGroupBy(Arrays.asList(sum), schema));
        groupbyOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(groupbyOperator);

        Assert.assertEquals(3, resultTuples.size());

        Assert.assertTrue(resultTuples.contains(getResultTuple(111,7)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222,12)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(333,1)));

        Assert.assertEquals(schema, resultTuples.get(0).getSchema());
    }

    @Test
    public void testAggregateAvg() throws Exception {
        StructType schema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field("avg", PrimitiveType.get(FieldTypeName.REAL))));
        StructType gBySchema = new StructType(
                Arrays.asList(new Field(senId.toField().getFieldName(), PrimitiveType.get(FieldTypeName.INTEGER)),
                        new Field("stat", PrimitiveType.get(FieldTypeName.REAL))));
        Avg avg = new Avg(new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.REAL)),  gBySchema));


        List<Tuple> tuples = Arrays.asList(getTuple(111, 5.0), getTuple(111, 2.0), getTuple(222, 7.0), getTuple(222, 5.0), getTuple(333, 1.0));
        GroupbyOperator groupbyOperator = new GroupbyOperator(new ListOperator(schema, tuples), mockLogicalGroupBy(Arrays.asList(avg), schema));
        groupbyOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(groupbyOperator);

        Assert.assertEquals(3, resultTuples.size());

        Assert.assertTrue(resultTuples.contains(getResultTuple(111,3.5)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222,6.0)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(333,1.0)));

        Assert.assertEquals(schema, resultTuples.get(0).getSchema());

    }



    private Tuple getTuple(int id, int number) {

        return new Tuple(byFieldSchema, new Object[] { id, number});
    }

    private Tuple getTuple(int id, double number) {

        return new Tuple(byFieldSchema, new Object[] { id, number});
    }


    private Tuple getResultTuple(int number, int count) {

        return new Tuple(testSchema, new Object[] { number, count });
    }

    private Tuple getResultTuple(int number, double count) {

        return new Tuple(testSchema, new Object[] { number, count });
    }

    private LogicalGroupby mockLogicalGroupBy(List<AggregateExpr> exprs, StructType schema) {
        LogicalGroupby groupby = Mockito.mock(LogicalGroupby.class);
        Mockito.when(groupby.getAggregateExprs()).thenReturn(exprs);
        Mockito.when(groupby.getByFields()).thenReturn(byFields);
        Mockito.when(groupby.getSchema()).thenReturn(schema);
        return groupby;
    }

    private LogicalTableScan mockLogicalTableScan() {
        LogicalTableScan groupby = Mockito.mock(LogicalTableScan.class);
        TableImpl t = new TableImpl("test");
        Mockito.when(groupby.getTable()).thenReturn(t);


        Mockito.when(t.getTablePath()).thenReturn("test/resources/test.tql");
        return groupby;
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
