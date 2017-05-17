package edu.uci.asterix.stream.execution.operators;


import edu.uci.asterix.stream.catalog.TableImpl;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.logical.LogicalTableScan;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TableScanOperator extends AbstractStreamOperator<LogicalTableScan> {

    private final TableImpl table;

    private Iterator<JSONObject> items;

    public TableScanOperator(LogicalTableScan logicalScan) {
        super(logicalScan);
        this.table = logicalScan.getTable();

        try {
            FileReader fileReader = new FileReader("src/test/resources/data.json");
            JSONParser parser = new JSONParser();
            JSONObject table = (JSONObject) parser.parse(fileReader);
            JSONArray rows = (JSONArray) table.get("rows");
            items = rows.iterator();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tuple next() {
        // TODO Auto-generated method stub

       JSONObject row = items.next();
       if(row != null)
       {

            String id = (String) row.get("id");

            String payload = (String) row.get("payload");

            String timeStamp = (String) row.get("timeStamp");

            String sensorId = (String) row.get("sensor_id");

            String obs = (String) row.get("observation_type_id");

            Object[] values = {id, payload,timeStamp,sensorId,obs};

            return new Tuple(this.getSchema(), values);

        }

        return null;
    }

    @Override
    public Operator[] children() {
        return new Operator[0];
    }

    @Override
    public String getName() {
        return "TABLE";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(table.getTableName());
        if (!logicalPlan.getAlias().equals(table.getTableName())) {
            sb.append(" AS ");
            sb.append(logicalPlan.getAlias());
        }
    }

}
