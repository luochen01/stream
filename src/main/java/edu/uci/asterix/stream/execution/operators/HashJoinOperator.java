package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.utils.Assertion;

import java.util.*;

public class HashJoinOperator extends BinaryOperator<LogicalJoin> {

    protected final EqualTo condition;
    protected Map<Integer,List<Tuple>> leftHash = new Hashtable<>();

    private Iterator<Tuple> leftItr;

    private Tuple rightTuple;

    private StructType schema;

    //TODO: load left table into memory in chunks
    public HashJoinOperator(Operator left, Operator right, LogicalJoin logicalJoin) {
        super(left, right, logicalJoin);
        Assertion.asserts(logicalJoin.isEquiJoin());
        this.condition = (EqualTo) logicalJoin.getJoinCondition();
        this.schema = logicalJoin.getSchema();


        Tuple nextChild;
        while((nextChild=left.next())!=null){
            List<Tuple> leftTuples;
            String conditionField = condition.toField().getFieldName();
            int fieldIndex = schema.getFieldIndex(conditionField);
            int leftKey = nextChild.get(fieldIndex).hashCode();

            if((leftTuples =leftHash.get(leftKey))==null){
                leftTuples = new ArrayList<>();
            }
            leftTuples.add(nextChild);
            leftHash.put(leftKey,leftTuples);

        }

    }

    @Override
    public String getName() {
        return "HASH JOIN";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(condition);
    }

    @Override
    public Tuple next() {
        // TODO Auto-generated method stub

        //Return merge tuple of left+right
        while (leftItr.hasNext()){
            List<Object> mergeTuple = new ArrayList<>();
            mergeTuple.addAll(Arrays.asList(leftItr.next().getAllValues()));
            mergeTuple.addAll(Arrays.asList(rightTuple.getAllValues()));
            return new Tuple(schema, mergeTuple.toArray());
        }

        //exhaust all entries on left -> get next right & reinitialize left array
        while((rightTuple = right.next())!=null){
            List<Tuple> leftTuples;
            String conditionField = condition.toField().getFieldName();
            int fieldIndex = schema.getFieldIndex(conditionField);
            int rightKey = rightTuple.get(fieldIndex).hashCode();

            if((leftTuples =leftHash.get(rightKey)) != null){
                leftItr = leftTuples.iterator();

                List<Object> mergeTuple = new ArrayList<>();
                mergeTuple.addAll(Arrays.asList(leftItr.next().getAllValues()));
                mergeTuple.addAll(Arrays.asList(rightTuple.getAllValues()));
                return new Tuple(schema, mergeTuple.toArray());
            }

        }
        return null;
    }

}
