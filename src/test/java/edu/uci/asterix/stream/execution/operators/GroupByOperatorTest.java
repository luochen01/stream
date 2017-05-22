package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.aggr.AggregateExpr;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalGroupby;

import edu.uci.asterix.stream.logical.analyzer.LogicalPlanAnalyzerTest;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.*;

public class GroupByOperatorTest extends LogicalPlanAnalyzerTest {

    private final StructType testSchema = new StructType(
            Arrays.asList(new Field("level", PrimitiveType.get(FieldTypeName.INTEGER)),
                    new Field("avg", PrimitiveType.get(FieldTypeName.INTEGER))));

    private final List<Expr> byFields = new ArrayList<>();

    @Test
    public void testBasic() throws Exception {


    }



    private Tuple getTuple(int number) {
        return new Tuple(testSchema, new Object[] { number });
    }

    private LogicalGroupby mockLogicalGroupBy(List<AggregateExpr> exprs) {
        LogicalGroupby groupby = Mockito.mock(LogicalGroupby.class);
        Mockito.when(groupby.getAggregateExprs()).thenReturn(exprs);
        Mockito.when(groupby.getByFields()).thenReturn(byFields);
        Mockito.when(groupby.getSchema()).thenReturn(testSchema);
        return groupby;
    }


}
