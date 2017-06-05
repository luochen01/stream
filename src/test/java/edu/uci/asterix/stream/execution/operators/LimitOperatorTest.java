package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.LimitOperator;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalLimit;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class LimitOperatorTest {
    private StructType testSchema = new StructType(
            Arrays.asList(new Field("name", PrimitiveType.get(FieldTypeName.STRING)),new Field("id" ,PrimitiveType.get(FieldTypeName.INTEGER)),
                    new Field("stat", PrimitiveType.get(FieldTypeName.REAL)),new Field("isTrue",PrimitiveType.get(FieldTypeName.BOOLEAN))));
    List<Tuple> tuples =  Arrays.asList(getTuple("a",1,8,Boolean.TRUE),getTuple("a",1,3,Boolean.FALSE),getTuple("a",12,1.5,Boolean.FALSE));
    public LogicalLimit mockitoLogicalLimit(int limit, int offset){
        LogicalLimit logicalLimit = Mockito.mock(LogicalLimit.class);
        Mockito.when(logicalLimit.getLimit()).thenReturn(limit);
        Mockito.when(logicalLimit.getOffset()).thenReturn(offset);
        return  logicalLimit;
    }
    @Test
    public void testPrintContent(){
        LogicalLimit ll = mockitoLogicalLimit(2,5);
        LimitOperator lo = new LimitOperator(new ListOperator(testSchema,tuples),ll);
        lo.initialize();
        StringBuilder sb=new StringBuilder();
        StringBuilder sbActual = new StringBuilder();
        sbActual.append(2).append(",OFFSET").append(5);
        lo.printContent(sb);
        Assert.assertTrue(sb.toString().equals(sbActual.toString()));
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testFailure(){
        LogicalLimit ll = mockitoLogicalLimit(-1,5);
        LimitOperator lo = new LimitOperator(new ListOperator(testSchema,tuples),ll);
        lo.initialize();
    }
    @Test
    public void successFulExecution(){
        LogicalLimit ll = mockitoLogicalLimit(3,1);
        LimitOperator lo = new LimitOperator(new ListOperator(testSchema,tuples),ll);
        lo.initialize();
        Assert.assertEquals(lo.limit,3);
        Assert.assertEquals(lo.offset,1);
        Assert.assertEquals(lo.next(),getTuple("a",1,3,Boolean.FALSE));
        Assert.assertEquals(lo.next(),getTuple("a",12,1.5,Boolean.FALSE));
        Assert.assertNull(lo.next());

    }
    private Tuple getTuple(String name, int id, double stat, Boolean isTrue ) {
        return new Tuple(testSchema, new Object[] { name,id, stat,isTrue});
    }

}
