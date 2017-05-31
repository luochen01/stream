package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.catalog.Catalog;
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
import edu.uci.asterix.stream.logical.LogicalScan;
import edu.uci.asterix.stream.logical.LogicalTableScan;
import edu.uci.asterix.stream.logical.analyzer.LogicalPlanAnalyzerTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableScanOperatorTest extends LogicalPlanAnalyzerTest {



    @Test
    public void testBasic() throws Exception {

        Catalog catalog = Catalog.INSTANCE;
        StructType schema = catalog.getTable("Observation").getSchema();

        TableImpl table = catalog.getTable("Observation");
        table.setTablePath("src/test/resources/observation.json");

        TableScanOperator tableScan = new TableScanOperator(mockLogicalTableScan(table, schema));
        tableScan.initialize();
        List<Tuple> resultTuples = fetchTuples(tableScan);

        Assert.assertEquals(2, resultTuples.size());

        Object[] jsonValue1 = new Object[5];
        jsonValue1[0] = Integer.toString(19);
        jsonValue1[1] = new Object[]{"3142-clwa-2019", null, null, null, null, null, null, null, null, null, null};
        jsonValue1[2] = "2017-04-02 11:00:57";
        jsonValue1[3] = new Object[]{null, null, null};
        jsonValue1[4] = new Object[]{Integer.toString(1),null, null, null};

        Object[] jsonValue2 = new Object[5];
        jsonValue2[0] = Integer.toString(20);
        jsonValue2[1] = new Object[]{"3141-clwa-1412", null, null, null, null, null, null, null, null, null, null};
        jsonValue2[2] = "2017-04-03 12:53:57";
        jsonValue2[3] = new Object[]{null, null, null};
        jsonValue2[4] = new Object[]{Integer.toString(2),null, null, null};


        Assert.assertEquals(schema, resultTuples.get(0).getSchema());

        Object[] tuple1 = resultTuples.get(0).getAllValues();
        Object[] tuple2 = resultTuples.get(1).getAllValues();
        AssertValues(jsonValue1, tuple1);
        AssertValues(jsonValue2, tuple2);

    }

    private void AssertValues(Object[] values, Object[] tuple1) {
        Assert.assertEquals(values[0], tuple1[0]);
        Assert.assertTrue(Arrays.equals((Object[])values[1], (Object[])tuple1[1]));
        Assert.assertEquals(values[2], tuple1[2]);
        Assert.assertTrue(Arrays.equals((Object[])values[3], (Object[])tuple1[3]));
        Assert.assertTrue(Arrays.equals((Object[])values[4], (Object[])tuple1[4]));
    }


    private LogicalTableScan mockLogicalTableScan(TableImpl table, StructType schema) {
        LogicalTableScan scan = Mockito.mock(LogicalTableScan.class);
        Mockito.when(scan.getTable()).thenReturn(table);
        Mockito.when(scan.getSchema()).thenReturn(schema);
        return scan;
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
