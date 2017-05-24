package edu.uci.asterix.stream.execution.operators;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.uci.asterix.stream.catalog.TableImpl;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.logical.LogicalTableScan;

public class TableScanOperator extends AbstractStreamOperator<LogicalTableScan> {

    private final TableImpl table;

    private Iterator<JSONObject> items;

    //TODO:GIFT-Shiva: When we read a json object, we should parse it(either here or have another method to parse it) to struct,etc.
    public TableScanOperator(LogicalTableScan logicalScan) {
        super(logicalScan);
        this.table = logicalScan.getTable();

        try {
            FileReader fileReader = new FileReader(table.getTablePath());
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
        if (row != null) {
            List<Object> values = new ArrayList<>();
            for (Field field : this.getSchema().getFields()) {
                values.add(row.get(field));
            }
            return new Tuple(this.getSchema(), values.toArray());
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
