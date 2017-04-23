package edu.uci.asterix.stream.execution;

/**
 * IFrame contains a set of tuples for execution
 * 
 * @author luochen
 */
public interface IFrame {
    public int numTuples();

    public ITuple readTuple(int i);

    public void writeTuple(ITuple tuple);

    public void reset();

}
