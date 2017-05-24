package edu.uci.asterix.stream.execution.operators;
import java.util.*;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.SortOrder;
import edu.uci.asterix.stream.logical.LogicalSort;
import edu.uci.asterix.stream.utils.Utils;

public class SortOperator extends UnaryOperator<LogicalSort> {

    protected int nextTuple = 0;
    protected final List<Expr> sortFields;
    protected final SortOrder order;
    private Iterator<Tuple> itr;
    private  List<Tuple> sortedTuples;

    public SortOperator(Operator child, LogicalSort logicalSort) {
        super(child, logicalSort);
        this.sortFields = logicalSort.getSortFields();
        this.order = logicalSort.getOrder();
        sortedTuples = new LinkedList<>();
        Tuple tuple;
        while((tuple = child.next())!=null){
            sortedTuples.add(tuple);
        }
        if (sortedTuples.size() > 0) {
            Collections.sort(sortedTuples, (tuple1, tuple2) -> {
                int returnValue = 0; int diff = 0;
                for(Expr field: sortFields){
                   switch (field.getResultType().getFieldTypeName()){
                       case INTEGER:
                       {
                            diff = (int)field.eval(tuple1) - (int)field.eval(tuple2);
                            break;
                       }
                       case STRING:
                       {
                           diff = ((String) field.eval(tuple1)).compareTo((String) field.eval(tuple2));
                           break;
                       }
                       case REAL:
                       {
                           diff = ((Double)field.eval(tuple1)).compareTo((Double)field.eval(tuple2));
                           break;
                       }
                       case BOOLEAN:
                       {
                          diff = ((Boolean)field.eval(tuple1)).compareTo((Boolean)field.eval(tuple2));
                           break;
                       }
                       case ARRAY:
                       {
                           break;
                       }
                       case STRUCT:
                       {
                           break;
                       }

                   }
                    returnValue = order.equals(SortOrder.Desc)?-diff:diff;
                   if(returnValue!=0){
                       return returnValue;
                   }
                }
                return 0;
            });
        }



    }

    @Override
    public Tuple next() {
        Tuple next = sortedTuples.get(nextTuple);
        nextTuple++;
        return next;

    }

    @Override
    public String getName() {
        return "SORT";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(Utils.format(sortFields, ","));
        sb.append("  ");
        sb.append(order);
    }


}
