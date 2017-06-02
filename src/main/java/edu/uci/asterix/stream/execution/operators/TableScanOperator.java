package edu.uci.asterix.stream.execution.operators;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.uci.asterix.stream.field.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.uci.asterix.stream.catalog.TableImpl;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.logical.LogicalTableScan;

public class TableScanOperator extends AbstractStreamOperator<LogicalTableScan> {

    private final TableImpl table;

    private Iterator items;

    private StructType schema;

    public TableScanOperator(LogicalTableScan logicalScan) {
        super(logicalScan);
        this.table = logicalScan.getTable();
        this.schema = table.getSchema();
    }

    @Override
    public Tuple next() {
        // TODO Auto-generated method stub

        JSONObject row;
        Object obj;
        if(items.hasNext()&& (obj = items.next()) != null){
            row = (JSONObject) obj;
            List<Object> values = new ArrayList<>();
            values.addAll(Arrays.asList(parseJson(row, table.getSchema())));
            return new Tuple(schema, values.toArray());
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

    private Object[] parseJson(JSONObject row, StructType schema){

        List<Object> values = new ArrayList<>();
        Object obj;

        for (Field f : schema.getFields()) {

            switch (f.getFieldType().getFieldTypeName()) {
                case BOOLEAN:{
                    if((obj = row.get(f.getFieldName())) != null){
                        values.add(Boolean.parseBoolean(obj.toString()));
                    }
                    else{
                        values.add(null);
                    }
                    break;
                }

                case INTEGER: {
                    if ((obj = row.get(f.getFieldName())) != null) {
                        values.add(Integer.parseInt(obj.toString()));
                    } else {
                        values.add(null);
                    }
                    break;
                }
                case REAL:{
                    if ((obj = row.get(f.getFieldName())) != null) {
                        values.add(Double.parseDouble(obj.toString()));
                    } else {
                        values.add(null);
                    }
                    break;
                }
                case STRING:{
                    if((obj = row.get(f.getFieldName())) != null){
                        values.add(obj.toString());
                    }
                    else{
                        values.add(null);
                    }
                    break;
                }
                case STRUCT: {
                    if((obj = row.get(f.getFieldName())) != null){
                        JSONObject struct = (JSONObject) obj;
                        Object[] structValue = parseJson(struct, new StructType(f.getFieldType().getFields()));
                        values.add(structValue);
                    }
                    else{
                        values.add(null);
                    }
                    break;
                }
                case ARRAY: {
                    FieldType elementType = f.getFieldType().getElementType();
                    List<Object> retArray = new ArrayList<>();
                    if((obj = row.get(f.getFieldName())) != null){
                        JSONArray array = (JSONArray)obj;
                        if(array != null && array.size() > 0){
                            array.forEach((item) -> retArray.add(parseJson((JSONObject) item, new StructType(elementType.getFields()))));

                        }
                        values.add(retArray.toArray());
                    }
                    else{
                        values.add(null);
                    }

                    break;
                }

                default:
                    throw new UnsupportedOperationException(
                            "Field type is not supported on " + f.getFieldName());
            }
        }


        return values.toArray();
    }

    @Override
    public void initialize(){
        try {
            FileReader fileReader = new FileReader(table.getTablePath());
            JSONParser parser = new JSONParser();
            JSONObject table = (JSONObject) parser.parse(fileReader);
            JSONArray rows = (JSONArray) table.get("rows");
            items = rows.iterator();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reset() {
        super.reset();

        items = null;
        schema = null;

    }

}
