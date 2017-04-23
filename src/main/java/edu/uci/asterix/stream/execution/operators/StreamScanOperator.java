package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.calcite.rel.type.RelDataType;

import edu.uci.asterix.stream.catalog.Catalog;
import edu.uci.asterix.stream.catalog.StreamTable;
import edu.uci.asterix.stream.execution.ITuple;
import edu.uci.asterix.stream.execution.impl.ObjectTuple;

public class StreamScanOperator extends LeafStreamOperator {

    private List<ITuple> data;

    private Iterator<ITuple> it;

    public StreamScanOperator(StreamTable table) {
        super(table);

        data = new ArrayList<>();
        data.add(new ObjectTuple(new Object[] { 1, "Mike" }));
        data.add(new ObjectTuple(new Object[] { 2, "Chen" }));
        data.add(new ObjectTuple(new Object[] { 3, "Smith" }));
        data.add(new ObjectTuple(new Object[] { 4, "Nick" }));
        it = data.iterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public ITuple next() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return it.next();
    }

    @Override
    public RelDataType getFields() {
        return table.getRowType(Catalog.defaultTypeFactory());
    }

}
