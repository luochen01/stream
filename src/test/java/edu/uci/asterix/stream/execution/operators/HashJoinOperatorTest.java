package edu.uci.asterix.stream.execution.operators;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.HashJoinOperator;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.expr.logic.LogicExpr;

public class HashJoinOperatorTest extends OperatorTest {

    @Test
    public void testBasic() throws Exception {
        List<Tuple> tuplesL = Arrays.asList(getTuple(111, lSchema), getTuple(222, lSchema), getTuple(333, lSchema),
                getTuple(444, lSchema));
        List<Tuple> tuplesR = Arrays.asList(getTuple(111, rSchema), getTuple(777, rSchema), getTuple(222, rSchema),
                getTuple(333, rSchema));

        HashJoinOperator hashJoinOperator = new HashJoinOperator(new ListOperator(lSchema, tuplesL),
                new ListOperator(rSchema, tuplesR), mockJoin(schema, joinCondition, lSchema, rSchema));
        hashJoinOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(hashJoinOperator);

        Assert.assertEquals(3, resultTuples.size());

        Assert.assertTrue(resultTuples.contains(getResultTuple(111, 111, schema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222, 222, schema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(333, 333, schema)));

        Assert.assertEquals(schema, resultTuples.get(0).getSchema());

    }

    @Test
    public void testEmptyRight() throws Exception {
        List<Tuple> tuplesL = Arrays.asList(getTuple(111, lSchema), getTuple(222, lSchema), getTuple(333, lSchema),
                getTuple(444, lSchema));
        List<Tuple> tuplesR = Arrays.asList();

        HashJoinOperator hashJoinOperator = new HashJoinOperator(new ListOperator(lSchema, tuplesL),
                new ListOperator(rSchema, tuplesR), mockJoin(schema, joinCondition, lSchema, rSchema));
        hashJoinOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(hashJoinOperator);

        Assert.assertEquals(0, resultTuples.size());

    }

    @Test
    public void testEmptyLeft() throws Exception {
        List<Tuple> tuplesL = Arrays.asList();
        List<Tuple> tuplesR = Arrays.asList(getTuple(111, rSchema), getTuple(777, rSchema), getTuple(222, rSchema),
                getTuple(333, rSchema));

        HashJoinOperator hashJoinOperator = new HashJoinOperator(new ListOperator(lSchema, tuplesL),
                new ListOperator(rSchema, tuplesR), mockJoin(schema, joinCondition, lSchema, rSchema));
        hashJoinOperator.initialize();
        List<Tuple> resultTuples = fetchTuples(hashJoinOperator);

        Assert.assertEquals(0, resultTuples.size());

    }

    @Test
    public void testMultipleJoinRecords() throws Exception {
        List<Tuple> tuplesL = Arrays.asList(getTuple(111, 3, multiLSchema), getTuple(111, 2, multiLSchema),
                getTuple(222, 7, multiLSchema), getTuple(222, 5, multiLSchema), getTuple(444, 5, multiLSchema));

        List<Tuple> tuplesR = Arrays.asList(getTuple(111, multiRSchema), getTuple(777, multiRSchema),
                getTuple(222, multiRSchema), getTuple(333, multiRSchema));

        Expr idL = new FieldAccess(senId, multiSchema);
        Expr idR = new FieldAccess(infId, multiSchema);
        LogicExpr filterExpr = new EqualTo(idL, idR);

        HashJoinOperator hashJoinOperator = new HashJoinOperator(new ListOperator(multiLSchema, tuplesL),
                new ListOperator(multiRSchema, tuplesR), mockJoin(multiSchema, filterExpr, multiLSchema, multiRSchema));
        hashJoinOperator.initialize();

        List<Tuple> resultTuples = fetchTuples(hashJoinOperator);

        Assert.assertEquals(4, resultTuples.size());

        Assert.assertTrue(resultTuples.contains(getResultTuple(111, 3, 111, multiSchema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(111, 2, 111, multiSchema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222, 7, 222, multiSchema)));
        Assert.assertTrue(resultTuples.contains(getResultTuple(222, 5, 222, multiSchema)));

        Assert.assertEquals(multiSchema, resultTuples.get(0).getSchema());
    }

}
