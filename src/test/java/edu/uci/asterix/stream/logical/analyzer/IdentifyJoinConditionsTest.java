package edu.uci.asterix.stream.logical.analyzer;

import org.junit.Assert;
import org.junit.Test;

import edu.uci.asterix.stream.expr.arithm.Add;
import edu.uci.asterix.stream.expr.fields.StructGetField;
import edu.uci.asterix.stream.expr.logic.And;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.expr.logic.Or;
import edu.uci.asterix.stream.expr.logic.True;
import edu.uci.asterix.stream.logical.LogicalFilter;
import edu.uci.asterix.stream.logical.LogicalJoin;

public class IdentifyJoinConditionsTest extends LogicalPlanAnalyzerTest {

    @Test
    public void testEqui() {

        LogicExpr filterExpr = new And(f, new EqualTo(senId, infId));
        LogicalFilter filter = new LogicalFilter(join, filterExpr);

        LogicalPlanAnalyzer identify = new IdentifyJoinConditions();
        LogicalFilter resultFilter = (LogicalFilter) identify.analyze(filter);
        LogicalJoin resultJoin = (LogicalJoin) resultFilter.getChild();

        Assert.assertEquals(leftScan, resultJoin.getLeft());
        Assert.assertEquals(rightScan, resultJoin.getRight());
        Assert.assertEquals(new EqualTo(senId, infId), resultJoin.getJoinCondition());
        Assert.assertEquals(true, resultJoin.isEquiJoin());
        Assert.assertEquals(resultFilter.getFilterCondition(), f);

    }

    @Test
    public void testCommuteEqui() {
        LogicExpr filterExpr = new And(f, new EqualTo(infId, senId));
        LogicalFilter filter = new LogicalFilter(join, filterExpr);

        LogicalPlanAnalyzer identify = new IdentifyJoinConditions();
        LogicalFilter resultFilter = (LogicalFilter) identify.analyze(filter);
        LogicalJoin resultJoin = (LogicalJoin) resultFilter.getChild();

        Assert.assertEquals(leftScan, resultJoin.getLeft());
        Assert.assertEquals(rightScan, resultJoin.getRight());
        Assert.assertEquals(new EqualTo(senId, infId), resultJoin.getJoinCondition());
        Assert.assertEquals(true, resultJoin.isEquiJoin());
        Assert.assertEquals(f, resultFilter.getFilterCondition());
    }

    @Test
    public void testInvalid() {

        LogicExpr filterExpr = new And(f, new EqualTo(senId, senName));
        LogicalFilter filter = new LogicalFilter(join, filterExpr);

        LogicalPlanAnalyzer identify = new IdentifyJoinConditions();
        LogicalFilter resultFilter = (LogicalFilter) identify.analyze(filter);
        LogicalJoin resultJoin = (LogicalJoin) resultFilter.getChild();

        Assert.assertEquals(leftScan, resultJoin.getLeft());
        Assert.assertEquals(rightScan, resultJoin.getRight());
        Assert.assertEquals(t, resultJoin.getJoinCondition());
        Assert.assertEquals(filterExpr, resultFilter.getFilterCondition());
    }

    @Test
    public void testStruct() {
        LogicExpr filterExpr = new And(t,
                new EqualTo(new StructGetField(senLocation, "x"), new StructGetField(infLocation, "x")));
        LogicalFilter filter = new LogicalFilter(join, filterExpr);

        LogicalPlanAnalyzer identify = new IdentifyJoinConditions();
        LogicalFilter resultFilter = (LogicalFilter) identify.analyze(filter);
        LogicalJoin resultJoin = (LogicalJoin) resultFilter.getChild();

        Assert.assertEquals(leftScan, resultJoin.getLeft());
        Assert.assertEquals(rightScan, resultJoin.getRight());
        Assert.assertEquals(new EqualTo(new StructGetField(senLocation, "x"), new StructGetField(infLocation, "x")),
                resultJoin.getJoinCondition());
        Assert.assertEquals(t, resultFilter.getFilterCondition());
    }

    @Test
    public void testOr() {
        LogicExpr idEqual = new EqualTo(senId, infId);
        LogicExpr nameEqual = new EqualTo(senName, infName);

        LogicExpr filterExpr = new And(f, new Or(idEqual, nameEqual));
        LogicalFilter filter = new LogicalFilter(join, filterExpr);

        LogicalPlanAnalyzer identify = new IdentifyJoinConditions();
        LogicalFilter resultFilter = (LogicalFilter) identify.analyze(filter);
        LogicalJoin resultJoin = (LogicalJoin) resultFilter.getChild();

        Assert.assertEquals(leftScan, resultJoin.getLeft());
        Assert.assertEquals(rightScan, resultJoin.getRight());
        Assert.assertEquals(new Or(idEqual, nameEqual), resultJoin.getJoinCondition());
        Assert.assertEquals(f, resultFilter.getFilterCondition());
    }

    @Test
    public void testOrFail() {
        LogicExpr filterExpr = new And(f, new Or(new EqualTo(senId, infId), f));
        LogicalFilter filter = new LogicalFilter(join, filterExpr);

        LogicalPlanAnalyzer identify = new IdentifyJoinConditions();
        LogicalFilter resultFilter = (LogicalFilter) identify.analyze(filter);
        LogicalJoin resultJoin = (LogicalJoin) resultFilter.getChild();

        Assert.assertEquals(leftScan, resultJoin.getLeft());
        Assert.assertEquals(rightScan, resultJoin.getRight());
        Assert.assertEquals(t, resultJoin.getJoinCondition());
        Assert.assertEquals(filterExpr, resultFilter.getFilterCondition());
    }

    @Test
    public void testMultiJoin() {
        LogicExpr filterExpr = new And(new EqualTo(senId, infId), new EqualTo(sen2Id, senId));
        LogicalFilter filter = new LogicalFilter(multiJoin, filterExpr);

        LogicalPlanAnalyzer identify = new IdentifyJoinConditions();
        LogicalFilter resultFilter = (LogicalFilter) identify.analyze(filter);
        LogicalJoin resultJoin = (LogicalJoin) resultFilter.getChild();

        Assert.assertEquals(new EqualTo(senId, sen2Id), resultJoin.getJoinCondition());
        Assert.assertEquals(true, resultJoin.isEquiJoin());

        LogicalJoin leftJoin = (LogicalJoin) resultJoin.getLeft();
        Assert.assertEquals(leftScan, leftJoin.getLeft());
        Assert.assertEquals(rightScan, leftJoin.getRight());
        Assert.assertEquals(true, leftJoin.isEquiJoin());
        Assert.assertEquals(new EqualTo(senId, infId), leftJoin.getJoinCondition());

        Assert.assertEquals(leftScan2, resultJoin.getRight());

        Assert.assertEquals(True.INSTANCE, resultFilter.getFilterCondition());

    }

    @Test
    public void testMultiJoinWithInvalidCondition() {
        LogicExpr filterExpr = new And(new EqualTo(senId, infId), new EqualTo(sen2Id, sen2Name));
        LogicalFilter filter = new LogicalFilter(multiJoin, filterExpr);

        LogicalPlanAnalyzer identify = new IdentifyJoinConditions();
        LogicalFilter resultFilter = (LogicalFilter) identify.analyze(filter);
        LogicalJoin resultJoin = (LogicalJoin) resultFilter.getChild();

        Assert.assertEquals(True.INSTANCE, resultJoin.getJoinCondition());
        Assert.assertEquals(false, resultJoin.isEquiJoin());

        LogicalJoin leftJoin = (LogicalJoin) resultJoin.getLeft();
        Assert.assertEquals(leftScan, leftJoin.getLeft());
        Assert.assertEquals(rightScan, leftJoin.getRight());
        Assert.assertEquals(true, leftJoin.isEquiJoin());
        Assert.assertEquals(new EqualTo(senId, infId), leftJoin.getJoinCondition());

        Assert.assertEquals(leftScan2, resultJoin.getRight());
        Assert.assertEquals(new EqualTo(sen2Id, sen2Name), resultFilter.getFilterCondition());
    }

    @Test
    public void testMultiJoinWithCompositeCondition() {
        LogicExpr filterExpr = new And(new EqualTo(senId, infId),
                new EqualTo(new Add(new StructGetField(senLocation, "x"), new StructGetField(sen2Location, "x")),
                        new StructGetField(infLocation, "x")));
        LogicalFilter filter = new LogicalFilter(multiJoin, filterExpr);

        LogicalPlanAnalyzer identify = new IdentifyJoinConditions();
        LogicalFilter resultFilter = (LogicalFilter) identify.analyze(filter);
        LogicalJoin resultJoin = (LogicalJoin) resultFilter.getChild();

        Assert.assertEquals(
                new EqualTo(new Add(new StructGetField(senLocation, "x"), new StructGetField(sen2Location, "x")),
                        new StructGetField(infLocation, "x")),
                resultJoin.getJoinCondition());
        Assert.assertEquals(false, resultJoin.isEquiJoin());

        LogicalJoin leftJoin = (LogicalJoin) resultJoin.getLeft();
        Assert.assertEquals(leftScan, leftJoin.getLeft());
        Assert.assertEquals(rightScan, leftJoin.getRight());
        Assert.assertEquals(true, leftJoin.isEquiJoin());
        Assert.assertEquals(new EqualTo(senId, infId), leftJoin.getJoinCondition());

        Assert.assertEquals(leftScan2, resultJoin.getRight());
        Assert.assertEquals(t, resultFilter.getFilterCondition());
    }

}
