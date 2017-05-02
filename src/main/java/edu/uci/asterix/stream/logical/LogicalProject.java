package edu.uci.asterix.stream.logical;

import java.util.List;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.StructType;

public class LogicalProject extends UnaryLogicalPlan {

    protected final List<Expr> projectList;

    public LogicalProject(LogicalPlan child, List<Expr> projectList) {
        super(child);
        this.projectList = projectList;
    }

    @Override
    public StructType getSchema() {
        //TODO
        return null;
    }

}
