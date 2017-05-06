package edu.uci.asterix.stream.logical.analyzer;

import org.junit.Assert;
import org.junit.Test;

import edu.uci.asterix.stream.catalog.Catalog;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.logic.And;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.expr.logic.False;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.expr.logic.Or;
import edu.uci.asterix.stream.expr.logic.True;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.logical.LogicalTableScan;

public class IdentifyJoinConditionTest {

    private LogicalTableScan leftScan = new LogicalTableScan(Catalog.INSTANCE.getTable("Sensor"), "sen");

    private LogicalTableScan rightScan = new LogicalTableScan(Catalog.INSTANCE.getTable("Infrastructure"), "inf");

    private LogicalJoin join = new LogicalJoin(leftScan, rightScan, null, false);

    private LogicExpr idEqual = new EqualTo(new FieldAccess(getLeftField("sen.id"), leftScan.getSchema()),
            new FieldAccess(getRightField("inf.id"), rightScan.getSchema()));

    private LogicExpr dualIdEqual = new EqualTo(new FieldAccess(getRightField("inf.id"), rightScan.getSchema()),
            new FieldAccess(getLeftField("sen.id"), leftScan.getSchema()));

    private LogicExpr nameEqual = new EqualTo(new FieldAccess(getLeftField("sen.name"), leftScan.getSchema()),
            new FieldAccess(getRightField("inf.name"), rightScan.getSchema()));

    private LogicExpr selfNameEqual = new EqualTo(new FieldAccess(getLeftField("sen.name"), leftScan.getSchema()),
            new FieldAccess(getLeftField("sen.name"), leftScan.getSchema()));

    private LogicExpr t = True.INSTANCE;

    private LogicExpr f = False.INSTANCE;

    @Test
    public void testEqui() {

        LogicExpr filterExpr = new And(f, idEqual);
        IdentifyJoinCondition identify = new IdentifyJoinCondition(join, filterExpr);
        identify.identify();

        LogicExpr joinCondition = identify.getJoinCondition();
        Assert.assertEquals(joinCondition, idEqual);

        LogicExpr simplified = identify.getSimplifiedExpr();
        Assert.assertEquals(f, simplified);

    }

    @Test
    public void testDualEqui() {

        LogicExpr filterExpr = new And(f, dualIdEqual);
        IdentifyJoinCondition identify = new IdentifyJoinCondition(join, filterExpr);
        identify.identify();

        LogicExpr joinCondition = identify.getJoinCondition();
        Assert.assertEquals(joinCondition, idEqual);

        LogicExpr simplified = identify.getSimplifiedExpr();
        Assert.assertEquals(f, simplified);

    }

    @Test
    public void testInvalid() {
        LogicExpr filterExpr = new And(f, selfNameEqual);
        IdentifyJoinCondition identify = new IdentifyJoinCondition(join, filterExpr);
        identify.identify();

        LogicExpr joinCondition = identify.getJoinCondition();
        Assert.assertEquals(joinCondition, t);

        LogicExpr simplified = identify.getSimplifiedExpr();
        Assert.assertEquals(filterExpr, simplified);
    }

    @Test
    public void testOr() {
        LogicExpr filterExpr = new And(f, new Or(idEqual, nameEqual));
        IdentifyJoinCondition identify = new IdentifyJoinCondition(join, filterExpr);
        identify.identify();

        LogicExpr joinCondition = identify.getJoinCondition();
        Assert.assertEquals(new Or(idEqual, nameEqual), joinCondition);

        LogicExpr simplified = identify.getSimplifiedExpr();
        Assert.assertEquals(f, simplified);
    }

    @Test
    public void testOrFail() {
        LogicExpr filterExpr = new And(f, new Or(idEqual, f));
        IdentifyJoinCondition identify = new IdentifyJoinCondition(join, filterExpr);
        identify.identify();

        LogicExpr joinCondition = identify.getJoinCondition();
        Assert.assertEquals(t, joinCondition);

        LogicExpr simplified = identify.getSimplifiedExpr();
        Assert.assertEquals(filterExpr, simplified);
    }

    private Field getLeftField(String name) {
        return leftScan.getSchema().getField(name);
    }

    private Field getRightField(String name) {
        return rightScan.getSchema().getField(name);
    }
}
