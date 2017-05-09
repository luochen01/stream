package edu.uci.asterix.stream.logical.analyzer;

import edu.uci.asterix.stream.catalog.Catalog;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.fields.ArrayGetItem;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.fields.Literal;
import edu.uci.asterix.stream.expr.fields.StructGetField;
import edu.uci.asterix.stream.expr.logic.False;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.expr.logic.True;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.logical.LogicalTableScan;

public abstract class LogicalPlanAnalyzerTest {
    protected LogicalTableScan leftScan = new LogicalTableScan(Catalog.INSTANCE.getTable("Sensor"), "sen");

    protected LogicalTableScan leftScan2 = new LogicalTableScan(Catalog.INSTANCE.getTable("Sensor"), "sen2");

    protected LogicalTableScan rightScan = new LogicalTableScan(Catalog.INSTANCE.getTable("Infrastructure"), "inf");

    protected LogicalJoin join = new LogicalJoin(leftScan, rightScan, null, false);

    protected LogicalJoin multiJoin = new LogicalJoin(new LogicalJoin(leftScan, rightScan, null, false), leftScan2,
            null, false);

    protected Expr senId = new FieldAccess(getLeftField("sen.id"), leftScan.getSchema());
    protected Expr sen2Id = new FieldAccess(getLeft2Field("sen2.id"), leftScan2.getSchema());
    protected Expr infId = new FieldAccess(getRightField("inf.id"), rightScan.getSchema());

    protected Expr senName = new FieldAccess(getLeftField("sen.name"), leftScan.getSchema());
    protected Expr sen2Name = new FieldAccess(getLeft2Field("sen2.name"), leftScan2.getSchema());
    protected Expr infName = new FieldAccess(getRightField("inf.name"), rightScan.getSchema());

    protected Expr senLocation = new FieldAccess(getLeftField("sen.location"), leftScan.getSchema());
    protected Expr sen2Location = new FieldAccess(getLeft2Field("sen2.location"), leftScan2.getSchema());
    protected Expr infLocation = new ArrayGetItem(
            new StructGetField(new FieldAccess(getRightField("inf.region"), rightScan.getSchema()), "geometry"),
            new Literal(0, FieldTypeName.INTEGER));

    protected LogicExpr t = True.INSTANCE;
    protected LogicExpr f = False.INSTANCE;

    private Field getLeftField(String name) {
        return leftScan.getSchema().getField(name);
    }

    private Field getLeft2Field(String name) {
        return leftScan2.getSchema().getField(name);
    }

    private Field getRightField(String name) {
        return rightScan.getSchema().getField(name);
    }

}
