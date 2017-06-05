package edu.uci.asterix.stream.execution.operators;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.SortOperator;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.SortOrder;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalSort;

public class SortOperatorTest extends OperatorTest {

    private final StructType testSchema = new StructType(
            Arrays.asList(new Field("name", PrimitiveType.get(FieldTypeName.STRING)),
                    new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)),
                    new Field("stat", PrimitiveType.get(FieldTypeName.REAL)),
                    new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN))));
    private final StructType byFieldSchema = new StructType(
            Arrays.asList(new Field("name", PrimitiveType.get(FieldTypeName.STRING)),
                    new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)),
                    new Field("stat", PrimitiveType.get(FieldTypeName.REAL)),
                    new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN))));

    @Test
    public void testSortByString() {
        List<Tuple> tuples = Arrays.asList(getTuple("b", 1, 1.5, Boolean.TRUE), getTuple("c", 1, 1.5, Boolean.TRUE),
                getTuple("a", 1, 1.5, Boolean.TRUE));
        SortOperator sort;
        //ASC
        sort = new SortOperator(new ListOperator(testSchema, tuples),
                mockLogicalSortList(Arrays.asList(
                        (new FieldAccess(new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)), byFieldSchema)),
                        (new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.REAL)), byFieldSchema)),
                        (new FieldAccess(new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN)), byFieldSchema)),
                        (new FieldAccess(new Field("name", PrimitiveType.get(FieldTypeName.STRING)), byFieldSchema))),
                        SortOrder.Asc));
        sort.initialize();
        Assert.assertEquals(sort.next(), getTuple("a", 1, 1.5, Boolean.TRUE));
        Assert.assertEquals(sort.next(), getTuple("b", 1, 1.5, Boolean.TRUE));
        Assert.assertEquals(sort.next(), getTuple("c", 1, 1.5, Boolean.TRUE));
        Assert.assertNull(sort.next());
        //DESC
        sort = new SortOperator(new ListOperator(testSchema, tuples),
                mockLogicalSortList(Arrays.asList(
                        (new FieldAccess(new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)), byFieldSchema)),
                        (new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.REAL)), byFieldSchema)),
                        (new FieldAccess(new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN)), byFieldSchema)),
                        (new FieldAccess(new Field("name", PrimitiveType.get(FieldTypeName.STRING)), byFieldSchema))),
                        SortOrder.Desc));
        sort.initialize();
        Assert.assertEquals(sort.next(), getTuple("c", 1, 1.5, Boolean.TRUE));
        Assert.assertEquals(sort.next(), getTuple("b", 1, 1.5, Boolean.TRUE));
        Assert.assertEquals(sort.next(), getTuple("a", 1, 1.5, Boolean.TRUE));
        Assert.assertNull(sort.next());
    }

    @Test
    public void testSortByBoolean() {
        List<Tuple> tuples = Arrays.asList(getTuple("a", 1, 1.5, Boolean.TRUE), getTuple("a", 1, 1.5, Boolean.FALSE),
                getTuple("a", 1, 1.5, Boolean.FALSE));
        SortOperator sort;
        //ASC
        sort = new SortOperator(new ListOperator(testSchema, tuples), mockLogicalSortList(Arrays.asList(
                (new FieldAccess(new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)), byFieldSchema)),
                (new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.REAL)), byFieldSchema)),
                (new FieldAccess(new Field("name", PrimitiveType.get(FieldTypeName.STRING)), byFieldSchema)),
                (new FieldAccess(new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN)), byFieldSchema))),
                SortOrder.Asc));
        sort.initialize();
        Assert.assertEquals(sort.next(), getTuple("a", 1, 1.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 1, 1.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 1, 1.5, Boolean.TRUE));
        Assert.assertNull(sort.next());
        //DESC
        sort = new SortOperator(new ListOperator(testSchema, tuples), mockLogicalSortList(Arrays.asList(
                (new FieldAccess(new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)), byFieldSchema)),
                (new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.REAL)), byFieldSchema)),
                (new FieldAccess(new Field("name", PrimitiveType.get(FieldTypeName.STRING)), byFieldSchema)),
                (new FieldAccess(new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN)), byFieldSchema))),
                SortOrder.Desc));
        sort.initialize();
        Assert.assertEquals(sort.next(), getTuple("a", 1, 1.5, Boolean.TRUE));
        Assert.assertEquals(sort.next(), getTuple("a", 1, 1.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 1, 1.5, Boolean.FALSE));
        Assert.assertNull(sort.next());
    }

    @Test
    public void testSortByInteger() {
        List<Tuple> tuples = Arrays.asList(getTuple("a", 3, 1.5, Boolean.FALSE), getTuple("a", 7, 1.5, Boolean.FALSE),
                getTuple("a", 4, 1.5, Boolean.FALSE));
        SortOperator sort;
        //ASC
        sort = new SortOperator(
                new ListOperator(testSchema,
                        tuples),
                mockLogicalSortList(Arrays.asList(
                        (new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.REAL)), byFieldSchema)),
                        (new FieldAccess(new Field("name", PrimitiveType.get(FieldTypeName.STRING)), byFieldSchema)),
                        (new FieldAccess(new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN)), byFieldSchema)),
                        (new FieldAccess(new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)), byFieldSchema))),
                        SortOrder.Asc));
        sort.initialize();
        Assert.assertEquals(sort.next(), getTuple("a", 3, 1.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 4, 1.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 7, 1.5, Boolean.FALSE));
        Assert.assertNull(sort.next());
        //DESC
        sort = new SortOperator(
                new ListOperator(testSchema,
                        tuples),
                mockLogicalSortList(Arrays.asList(
                        (new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.REAL)), byFieldSchema)),
                        (new FieldAccess(new Field("name", PrimitiveType.get(FieldTypeName.STRING)), byFieldSchema)),
                        (new FieldAccess(new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN)), byFieldSchema)),
                        (new FieldAccess(new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)), byFieldSchema))),
                        SortOrder.Desc));
        sort.initialize();
        Assert.assertEquals(sort.next(), getTuple("a", 7, 1.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 4, 1.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 3, 1.5, Boolean.FALSE));
        Assert.assertNull(sort.next());
    }

    @Test
    public void testSortByReal() {
        List<Tuple> tuples = Arrays.asList(getTuple("a", 1, 6.5, Boolean.FALSE), getTuple("a", 1, 9, Boolean.FALSE),
                getTuple("a", 1, 4.5, Boolean.FALSE));
        SortOperator sort;
        //ASC
        sort = new SortOperator(
                new ListOperator(testSchema,
                        tuples),
                mockLogicalSortList(Arrays.asList(
                        (new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.REAL)), byFieldSchema)),
                        (new FieldAccess(new Field("name", PrimitiveType.get(FieldTypeName.STRING)), byFieldSchema)),
                        (new FieldAccess(new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN)), byFieldSchema)),
                        (new FieldAccess(new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)), byFieldSchema))),
                        SortOrder.Asc));
        sort.initialize();
        Assert.assertEquals(sort.next(), getTuple("a", 1, 4.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 1, 6.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 1, 9, Boolean.FALSE));
        Assert.assertNull(sort.next());
        //DESC
        sort = new SortOperator(
                new ListOperator(testSchema,
                        tuples),
                mockLogicalSortList(Arrays.asList(
                        (new FieldAccess(new Field("stat", PrimitiveType.get(FieldTypeName.REAL)), byFieldSchema)),
                        (new FieldAccess(new Field("name", PrimitiveType.get(FieldTypeName.STRING)), byFieldSchema)),
                        (new FieldAccess(new Field("isTrue", PrimitiveType.get(FieldTypeName.BOOLEAN)), byFieldSchema)),
                        (new FieldAccess(new Field("id", PrimitiveType.get(FieldTypeName.INTEGER)), byFieldSchema))),
                        SortOrder.Desc));
        sort.initialize();
        Assert.assertEquals(sort.next(), getTuple("a", 1, 9, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 1, 6.5, Boolean.FALSE));
        Assert.assertEquals(sort.next(), getTuple("a", 1, 4.5, Boolean.FALSE));
        Assert.assertNull(sort.next());
    }

    private Tuple getTuple(String name, int id, double stat, Boolean isTrue) {

        return new Tuple(testSchema, new Object[] { name, id, stat, isTrue });
    }

    private LogicalSort mockLogicalSortList(List<Expr> sortFields, SortOrder order) {
        LogicalSort sort = Mockito.mock(LogicalSort.class);
        Mockito.when(sort.getSortFields()).thenReturn(sortFields);
        Mockito.when(sort.getOrder()).thenReturn(order);
        return sort;
    }

}
