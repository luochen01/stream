package edu.uci.asterix.stream.execution.operators;

import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.logical.LogicalProject;
import edu.uci.asterix.stream.utils.Utils;

public class ProjectOperator extends UnaryOperator<LogicalProject> {

    protected final List<Expr> projectList;

    public ProjectOperator(Operator child, LogicalProject logicalProject) {
        super(child, logicalProject);
        this.projectList = logicalProject.getProjectList();
    }

    @Override
    protected Tuple nextImpl() {
        //TODO implement
        return null;
    }

    @Override
    public String getName() {
        return "PROJECT";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(Utils.format(projectList, ","));
    }

}
