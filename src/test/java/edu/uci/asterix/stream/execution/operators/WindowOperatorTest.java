package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import edu.uci.asterix.stream.conf.StreamConfig;
import edu.uci.asterix.stream.execution.SystemTimeProvider;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Window;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalStreamScan;
import edu.uci.asterix.stream.utils.Utils;

public class WindowOperatorTest {

    private final StructType testSchema = new StructType(
            Arrays.asList(new Field(StreamConfig.Instance.streamTimeField(), PrimitiveType.get(FieldTypeName.STRING))));

    private class TestTimeProvider implements SystemTimeProvider {

        long nextValue = 0;

        @Override
        public long currentTimeMillis() {
            return nextValue;
        }

    }

    @Test
    public void testQueue() {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();

        queue.add(1);

        Iterator<Integer> it = queue.iterator();
        queue.add(2);
        Assert.assertEquals(Integer.valueOf(1), it.next());
        it.remove();
        Assert.assertEquals(Integer.valueOf(2), it.next());

        queue.add(3);
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void testSlide3Range3() {
        List<Tuple> tuples = Arrays.asList(getTuple(0), getTuple(1000), getTuple(2000), getTuple(3000), getTuple(4000),
                getTuple(5000), getTuple(6000), getTuple(7000));
        TestTimeProvider provider = new TestTimeProvider();
        WindowOperator windowOperator = new WindowOperator(new ListOperator(testSchema, tuples),
                mockLogicalScan(new Window(3, 3)), provider);
        windowOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(windowOperator);

        Assert.assertEquals(4, resultTuples.size());
        Assert.assertEquals(getTuple(0), resultTuples.get(0));
        Assert.assertEquals(getTuple(1000), resultTuples.get(1));
        Assert.assertEquals(getTuple(2000), resultTuples.get(2));
        Assert.assertEquals(getTuple(3000), resultTuples.get(3));
        Assert.assertEquals(5, windowOperator.getBufferSize());

        provider.nextValue = 3500;

        resultTuples = fetchTuples(windowOperator);
        Assert.assertEquals(4, resultTuples.size());
        Assert.assertEquals(getTuple(3000), resultTuples.get(0));
        Assert.assertEquals(getTuple(4000), resultTuples.get(1));
        Assert.assertEquals(getTuple(5000), resultTuples.get(2));
        Assert.assertEquals(getTuple(6000), resultTuples.get(3));
        Assert.assertEquals(2, windowOperator.getBufferSize());
    }

    @Test
    public void testSlide3Range1() {
        List<Tuple> tuples = Arrays.asList(getTuple(0), getTuple(1000), getTuple(2000), getTuple(3000), getTuple(4000),
                getTuple(5000), getTuple(6000), getTuple(7000));
        TestTimeProvider provider = new TestTimeProvider();
        WindowOperator windowOperator = new WindowOperator(new ListOperator(testSchema, tuples),
                mockLogicalScan(new Window(1, 3)), provider);
        windowOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(windowOperator);

        Assert.assertEquals(2, resultTuples.size());
        Assert.assertEquals(getTuple(2000), resultTuples.get(0));
        Assert.assertEquals(getTuple(3000), resultTuples.get(1));
        Assert.assertEquals(4, windowOperator.getBufferSize());

        provider.nextValue = 3500;

        resultTuples = fetchTuples(windowOperator);
        Assert.assertEquals(2, resultTuples.size());
        Assert.assertEquals(getTuple(5000), resultTuples.get(0));
        Assert.assertEquals(getTuple(6000), resultTuples.get(1));
        Assert.assertEquals(1, windowOperator.getBufferSize());
    }

    @Test
    public void testSlide3Range4() {
        List<Tuple> tuples = Arrays.asList(getTuple(0), getTuple(1000), getTuple(2000), getTuple(3000), getTuple(4000),
                getTuple(5000), getTuple(6000), getTuple(7000));
        TestTimeProvider provider = new TestTimeProvider();
        WindowOperator windowOperator = new WindowOperator(new ListOperator(testSchema, tuples),
                mockLogicalScan(new Window(4, 3)), provider);
        windowOperator.initialize();

        List<Tuple> resultTuples = fetchTuples(windowOperator);
        Assert.assertEquals(4, resultTuples.size());
        Assert.assertEquals(getTuple(0), resultTuples.get(0));
        Assert.assertEquals(getTuple(1000), resultTuples.get(1));
        Assert.assertEquals(getTuple(2000), resultTuples.get(2));
        Assert.assertEquals(getTuple(3000), resultTuples.get(3));
        Assert.assertEquals(6, windowOperator.getBufferSize());

        provider.nextValue = 3500;

        resultTuples = fetchTuples(windowOperator);
        Assert.assertEquals(5, resultTuples.size());
        Assert.assertEquals(getTuple(2000), resultTuples.get(0));
        Assert.assertEquals(getTuple(3000), resultTuples.get(1));
        Assert.assertEquals(getTuple(4000), resultTuples.get(2));
        Assert.assertEquals(getTuple(5000), resultTuples.get(3));
        Assert.assertEquals(getTuple(6000), resultTuples.get(4));
        Assert.assertEquals(3, windowOperator.getBufferSize());
    }

    private List<Tuple> fetchTuples(Operator operator) {
        List<Tuple> resultTuples = new ArrayList<>();
        Tuple tuple = null;
        while ((tuple = operator.next()) != null) {
            resultTuples.add(tuple);
        }
        return resultTuples;
    }

    private LogicalStreamScan mockLogicalScan(Window window) {
        LogicalStreamScan scan = Mockito.mock(LogicalStreamScan.class);
        Mockito.when(scan.getWindow()).thenReturn(window);
        Mockito.when(scan.getSchema()).thenReturn(testSchema);
        return scan;
    }

    private Tuple getTuple(long timestamp) {
        return new Tuple(testSchema, new Object[] { Utils.getTimeString(timestamp) });
    }

}
