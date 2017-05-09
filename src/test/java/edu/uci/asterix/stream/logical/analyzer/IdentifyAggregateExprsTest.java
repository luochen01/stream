package edu.uci.asterix.stream.logical.analyzer;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

import edu.uci.asterix.stream.expr.aggr.Count;
import edu.uci.asterix.stream.expr.arithm.Add;
import edu.uci.asterix.stream.expr.arithm.Multiply;
import edu.uci.asterix.stream.expr.fields.As;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.fields.Literal;
import edu.uci.asterix.stream.expr.logic.GreaterThan;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.logical.LogicalFilter;
import edu.uci.asterix.stream.logical.LogicalGroupby;
import edu.uci.asterix.stream.logical.LogicalProject;
import edu.uci.asterix.stream.parser.ParsingException;

public class IdentifyAggregateExprsTest extends LogicalPlanAnalyzerTest {

    @Test
    public void testBasic() throws Exception {
        LogicalGroupby groupBy = new LogicalGroupby(leftScan, Arrays.asList(senId, senName), Collections.EMPTY_LIST,
                null);
        Count count = new Count(new FieldAccess(Field.ALL_FIELDS, leftScan.getSchema()));
        LogicalProject project = new LogicalProject(groupBy, Arrays.asList(new As(count, "count")));

        IdentifyAggregateExprs identify = new IdentifyAggregateExprs();
        LogicalProject resultProject = (LogicalProject) identify.analyze(project);
        LogicalGroupby resultGroupby = (LogicalGroupby) resultProject.getChild();

        Assert.assertEquals(1, resultProject.getProjectList().size());
        Assert.assertEquals(new As(new FieldAccess(count.toField(), resultGroupby.getSchema()), "count"),
                resultProject.getProjectList().get(0));

        Assert.assertEquals(1, resultGroupby.getAggregateExprs().size());
        Assert.assertEquals(count, resultGroupby.getAggregateExprs().get(0));

    }

    @Test
    public void testHavingCondition() throws Exception {
        Count count = new Count(new FieldAccess(Field.ALL_FIELDS, leftScan.getSchema()));

        LogicalGroupby groupBy = new LogicalGroupby(leftScan, Arrays.asList(senId, senName), Collections.EMPTY_LIST,
                new GreaterThan(count, new Literal(5, FieldTypeName.INTEGER)));
        LogicalProject project = new LogicalProject(groupBy, Arrays.asList(new As(count, "count")));

        IdentifyAggregateExprs identify = new IdentifyAggregateExprs();
        LogicalProject resultProject = (LogicalProject) identify.analyze(project);
        LogicalFilter resultFilter = (LogicalFilter) resultProject.getChild();
        LogicalGroupby resultGroupby = (LogicalGroupby) resultFilter.getChild();

        Assert.assertEquals(1, resultProject.getProjectList().size());
        Assert.assertEquals(new As(new FieldAccess(count.toField(), resultGroupby.getSchema()), "count"),
                resultProject.getProjectList().get(0));

        Assert.assertEquals(new GreaterThan(new FieldAccess(count.toField(), resultGroupby.getSchema()),
                new Literal(5, FieldTypeName.INTEGER)), resultFilter.getFilterCondition());

        Assert.assertEquals(1, resultGroupby.getAggregateExprs().size());
        Assert.assertEquals(count, resultGroupby.getAggregateExprs().get(0));
    }

    @Test(expected = ParsingException.class)
    public void testInvalidHavingCondition() throws Exception {
        Count count = new Count(new FieldAccess(Field.ALL_FIELDS, leftScan.getSchema()));

        LogicalGroupby groupBy = new LogicalGroupby(leftScan, Arrays.asList(senId, senName), Collections.EMPTY_LIST,
                new GreaterThan(count, new Literal(5, FieldTypeName.INTEGER)));
        LogicalProject project = new LogicalProject(groupBy, Arrays.asList(senId, senName));

        IdentifyAggregateExprs identify = new IdentifyAggregateExprs();
        identify.analyze(project);
    }

    @Test
    public void testComplexExpr() throws Exception {
        Count count = new Count(new FieldAccess(Field.ALL_FIELDS, leftScan.getSchema()));

        LogicalGroupby groupBy = new LogicalGroupby(leftScan, Arrays.asList(senId, senName), Collections.EMPTY_LIST,
                new GreaterThan(new Multiply(count, new Literal(2, FieldTypeName.INTEGER)),
                        new Literal(5, FieldTypeName.INTEGER)));
        LogicalProject project = new LogicalProject(groupBy,
                Arrays.asList(new As(new Add(count, new Literal(10, FieldTypeName.INTEGER)), "count")));

        IdentifyAggregateExprs identify = new IdentifyAggregateExprs();
        LogicalProject resultProject = (LogicalProject) identify.analyze(project);
        LogicalFilter resultFilter = (LogicalFilter) resultProject.getChild();
        LogicalGroupby resultGroupby = (LogicalGroupby) resultFilter.getChild();

        Assert.assertEquals(1, resultProject.getProjectList().size());
        Assert.assertEquals(new As(new Add(new FieldAccess(count.toField(), resultGroupby.getSchema()),
                new Literal(10, FieldTypeName.INTEGER)), "count"), resultProject.getProjectList().get(0));

        Assert.assertEquals(
                new GreaterThan(new Multiply(new FieldAccess(count.toField(), resultGroupby.getSchema()),
                        new Literal(2, FieldTypeName.INTEGER)), new Literal(5, FieldTypeName.INTEGER)),
                resultFilter.getFilterCondition());

        Assert.assertEquals(1, resultGroupby.getAggregateExprs().size());
        Assert.assertEquals(count, resultGroupby.getAggregateExprs().get(0));
    }

}
