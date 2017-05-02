package edu.uci.asterix.stream.execution.operators;

import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.StructType;

public class ProjectOperator extends UnaryOperator {

    protected final List<Expr> projectList;

    public ProjectOperator(Operator child, List<Expr> projectList) {
        super(child);
        this.projectList = projectList;
    }

    @Override
    public StructType getSchema() {
        //TODO implement
        return null;
    }

    @Override
    protected Tuple nextImpl() {
        //TODO implement
        return null;
    }

}
