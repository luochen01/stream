package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import edu.uci.asterix.stream.catalog.Catalog;
import edu.uci.asterix.stream.catalog.TableImpl;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.Operator;
import edu.uci.asterix.stream.execution.operators.TableScanOperator;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalTableScan;
import edu.uci.asterix.stream.logical.analyzer.LogicalPlanAnalyzerTest;

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

        TableImpl sensor = catalog.getTable("Sensor");
        TableImpl observationType = catalog.getTable("ObservationType");
        TableImpl location = catalog.getTable("Location");

        Object[] jsonValue1 = new Object[5];
        jsonValue1[0] = Integer.toString(19);
        jsonValue1[1] = new Tuple(sensor.getSchema(),
                new Object[] { "3142-clwa-2019", null, null, null, null, null, null, null, null, null, null });
        jsonValue1[2] = "2017-04-02 11:00:57";
        jsonValue1[3] = new Tuple(location.getSchema(), new Object[] { null, null, null });
        jsonValue1[4] = new Tuple(observationType.getSchema(), new Object[] { Integer.toString(1), null, null, null });

        Object[] jsonValue2 = new Object[5];
        jsonValue2[0] = Integer.toString(20);
        jsonValue2[1] = new Tuple(sensor.getSchema(),
                new Object[] { "3141-clwa-1412", null, null, null, null, null, null, null, null, null, null });
        jsonValue2[2] = "2017-04-03 12:53:57";
        jsonValue2[3] = new Tuple(location.getSchema(), new Object[] { null, null, null });
        jsonValue2[4] = new Tuple(observationType.getSchema(), new Object[] { Integer.toString(2), null, null, null });

        Assert.assertEquals(resultTuples.get(0), new Tuple(schema, jsonValue1));
        Assert.assertEquals(resultTuples.get(1), new Tuple(schema, jsonValue2));

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
