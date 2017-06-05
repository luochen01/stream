package edu.uci.asterix.stream.execution.operators;

import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.logical.LogicalProject;
import edu.uci.asterix.stream.utils.Utils;

public class ProjectOperator extends UnaryOperator<LogicalProject> {

    protected final List<Expr> projectList;

    protected final boolean allFields;

    public ProjectOperator(Operator child, LogicalProject logicalProject) {
        super(child, logicalProject);
        this.projectList = logicalProject.getProjectList();
        this.allFields = (projectList.size() == 1)
                && projectList.get(0).equals(new FieldAccess(Field.ALL_FIELDS, child.getSchema()));
    }

    @Override
    public Tuple next() {
        Tuple tuple = child.next();
        if (tuple == null) {
            return null;
        }
        if (allFields) {
            return tuple;
        } else {
            Object[] objects = new Object[projectList.size()];
            for (int i = 0; i < objects.length; i++) {
                objects[i] = projectList.get(i).eval(tuple);
            }
            return new Tuple(getSchema(), objects);
        }
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
