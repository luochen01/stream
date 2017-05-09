package edu.uci.asterix.stream.logical;

import java.util.List;
import java.util.stream.Collectors;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Assertion;
import edu.uci.asterix.stream.utils.Utils;

public class LogicalProject extends UnaryLogicalPlan {

    protected final List<Expr> projectList;
    protected StructType schema;

    public LogicalProject(LogicalPlan child, List<Expr> projectList) {
        super(child);
        this.projectList = projectList;

        List<Field> fields = projectList.stream().map(expr -> expr.toField()).collect(Collectors.toList());
        if (fields.get(0) == Field.ALL_FIELDS) {
            Assertion.asserts(fields.size() == 1);
            schema = child.getSchema();
        } else {
            schema = new StructType(fields);
        }
    }

    @Override
    public StructType getSchema() {
        return schema;
    }

    @Override
    protected void printContent(StringBuilder sb, int level) {
        sb.append(Utils.format(projectList, ","));
    }

    public List<Expr> getProjectList() {
        return projectList;
    }

    @Override
    public String getName() {
        return "LOGICAL PROJECT";
    }
}
