package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.BinaryLogicalPlan;

public abstract class BinaryOperator<T extends BinaryLogicalPlan> extends AbstractStreamOperator<T> {
    protected final Operator left;

    protected final Operator right;

    protected final PairedTuple joinedTuple;

    public BinaryOperator(Operator left, Operator right, T logicalPlan) {
        super(logicalPlan);
        this.left = left;
        this.right = right;
        joinedTuple = new PairedTuple(logicalPlan.getSchema(), logicalPlan.getLeft().getSchema(),
                logicalPlan.getRight().getSchema());
    }

    @Override
    public Operator[] children() {
        return new Operator[] { left, right };
    }

    /**
     * A simple trick to avoid create tuples every time when we test the join condition
     *
     * @author luochen
     */
    protected class PairedTuple extends Tuple {

        public Tuple left;

        public Tuple right;

        private final StructType leftSchema;

        private final StructType rightSchema;

        public PairedTuple(StructType schema, StructType leftSchema, StructType rightSchema) {
            super(schema);
            this.leftSchema = leftSchema;
            this.rightSchema = rightSchema;
        }

        @Override
        public Object get(int i) {
            assert (left != null && right != null);
            if (i < leftSchema.getFieldCount()) {
                return left.get(i);
            } else {
                return right.get(i - leftSchema.getFieldCount());
            }
        }

        public Tuple toTuple() {
            return Tuple.merge(left, right, schema);
        }
    }

}
