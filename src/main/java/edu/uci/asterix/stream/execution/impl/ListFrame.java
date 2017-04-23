package edu.uci.asterix.stream.execution.impl;

import java.util.ArrayList;
import java.util.List;

import edu.uci.asterix.stream.execution.IFrame;
import edu.uci.asterix.stream.execution.ITuple;

public class ListFrame implements IFrame {
    private List<ITuple> list = new ArrayList<>();

    @Override
    public int numTuples() {
        return list.size();
    }

    @Override
    public ITuple readTuple(int i) {
        return list.get(i);
    }

    @Override
    public void writeTuple(ITuple tuple) {
        list.add(tuple);
    }

    @Override
    public void reset() {
        list.clear();
    }

}
