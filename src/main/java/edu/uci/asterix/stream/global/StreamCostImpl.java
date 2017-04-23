package edu.uci.asterix.stream.global;

import org.apache.calcite.plan.RelOptCost;
import org.apache.calcite.plan.RelOptCostFactory;
import org.apache.calcite.plan.RelOptUtil;

public class StreamCostImpl implements RelOptCost {
    public static final RelOptCostFactory FACTORY = new Factory();

    //~ Instance fields --------------------------------------------------------

    private final double rows;

    private final double cpu;

    private final double io;

    //~ Constructors -----------------------------------------------------------

    public StreamCostImpl(double rows, double cpu, double io) {
        this.rows = rows;
        this.cpu = cpu;
        this.io = io;
    }

    //~ Methods ----------------------------------------------------------------

    // implement RelOptCost
    public double getRows() {
        return rows;
    }

    // implement RelOptCost
    public double getIo() {
        return io;
    }

    // implement RelOptCost
    public double getCpu() {
        return cpu;
    }

    // implement RelOptCost
    public boolean isInfinite() {
        return Double.isInfinite(rows);
    }

    // implement RelOptCost
    public boolean isLe(RelOptCost other) {
        return getRows() <= other.getRows();
    }

    // implement RelOptCost
    public boolean isLt(RelOptCost other) {
        return total(this) < total(other);
    }

    public static double total(RelOptCost cost) {
        return cost.getRows() + cost.getCpu() + 1000 * cost.getIo();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(cpu);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(io);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rows);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(RelOptCost obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StreamCostImpl other = (StreamCostImpl) obj;
        if (Double.doubleToLongBits(cpu) != Double.doubleToLongBits(other.cpu))
            return false;
        if (Double.doubleToLongBits(io) != Double.doubleToLongBits(other.io))
            return false;
        if (Double.doubleToLongBits(rows) != Double.doubleToLongBits(other.rows))
            return false;
        return true;
    }

    // implement RelOptCost
    public boolean isEqWithEpsilon(RelOptCost other) {
        return Math.abs(total(this) - total(other)) < RelOptUtil.EPSILON;
    }

    // implement RelOptCost
    public RelOptCost minus(RelOptCost other) {
        return new StreamCostImpl(getRows() - other.getRows(), getCpu() - other.getCpu(), getIo() - other.getIo());
    }

    // implement RelOptCost
    public RelOptCost plus(RelOptCost other) {
        return new StreamCostImpl(getRows() + other.getRows(), getCpu() + other.getCpu(), getIo() + other.getIo());
    }

    // implement RelOptCost
    public RelOptCost multiplyBy(double factor) {
        return new StreamCostImpl(getRows() * factor, getCpu() * factor, getIo() * factor);
    }

    public double divideBy(RelOptCost cost) {
        return total(this) / total(cost);
    }

    // implement RelOptCost
    public String toString() {
        if (rows == Double.MAX_VALUE) {
            return "huge";
        } else {
            return Double.toString(total(this));
        }
    }

    private static class Factory implements RelOptCostFactory {
        public RelOptCost makeCost(double dRows, double dCpu, double dIo) {
            return new StreamCostImpl(dRows, dCpu, dIo);
        }

        public RelOptCost makeHugeCost() {
            return new StreamCostImpl(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        }

        public RelOptCost makeInfiniteCost() {
            return new StreamCostImpl(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        }

        public RelOptCost makeTinyCost() {
            return new StreamCostImpl(1.0, 0.0, 0.0);
        }

        public RelOptCost makeZeroCost() {
            return new StreamCostImpl(0.0, 0.0, 0.0);
        }
    }

}
