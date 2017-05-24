package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.SortOrder;
import edu.uci.asterix.stream.logical.LogicalSort;
import edu.uci.asterix.stream.utils.Utils;

public class SortOperator extends UnaryOperator<LogicalSort> {
    protected final List<Expr> sortFields;
    protected final SortOrder order;
    private Iterator<Tuple> itr;
    private List<Tuple> sortedTuples;

    public SortOperator(Operator child, LogicalSort logicalSort) {
        super(child, logicalSort);
        this.sortFields = logicalSort.getSortFields();
        this.order = logicalSort.getOrder();
    }

    @Override
    public Tuple next() {
        if (itr != null && itr.hasNext()) {
            return itr.next();
        } else {
            return null;
        }
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

    @Override
    public void reset() {
        super.reset();
        this.sortedTuples.clear();
        this.sortedTuples = null;
        this.itr = null;
    }

    @Override
    public void initialize() {
        super.initialize();
        this.sortedTuples = new ArrayList<Tuple>();
        Tuple tuple;
        while ((tuple = child.next()) != null) {
            sortedTuples.add(tuple);
        }
        if (sortedTuples.size() > 0) {
            Collections.sort(sortedTuples, (tuple1, tuple2) -> {
                int returnValue;
                int diff = 0;
                for (Expr field : sortFields) {
                    Object leftVal = field.eval(tuple1);
                    Object rightVal = field.eval(tuple2);
                    if (leftVal == null && rightVal != null) {
                        return order.equals(SortOrder.Asc) ? -1 : 1;
                    } else if (leftVal != null && rightVal == null) {
                        return order.equals(SortOrder.Asc) ? 1 : -1;
                    } else if (leftVal != null && rightVal != null) {
                        switch (field.getResultType().getFieldTypeName()) {
                            case INTEGER: {
                                diff = ((Integer) field.eval(tuple1)).compareTo((Integer) field.eval(tuple2));
                                break;
                            }
                            case STRING: {
                                diff = ((String) field.eval(tuple1)).compareTo((String) field.eval(tuple2));
                                break;
                            }
                            case REAL: {
                                diff = ((Double) field.eval(tuple1)).compareTo((Double) field.eval(tuple2));
                                break;
                            }
                            case BOOLEAN: {
                                diff = ((Boolean) field.eval(tuple1)).compareTo((Boolean) field.eval(tuple2));
                                break;
                            }
                            default:
                                throw new UnsupportedOperationException(
                                        "Unsupported order field type " + field.getResultType().getFieldTypeName());

                        }
                        returnValue = order.equals(SortOrder.Desc) ? -diff : diff;
                        if (returnValue != 0) {
                            return returnValue;
                        }
                    }

                }
                return 0;
            });
        }

        itr = sortedTuples.iterator();

    }

}
