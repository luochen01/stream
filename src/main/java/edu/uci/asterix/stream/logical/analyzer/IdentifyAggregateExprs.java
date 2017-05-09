package edu.uci.asterix.stream.logical.analyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.Exprs;
import edu.uci.asterix.stream.expr.aggr.AggregateExpr;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalFilter;
import edu.uci.asterix.stream.logical.LogicalGroupby;
import edu.uci.asterix.stream.logical.LogicalPlan;
import edu.uci.asterix.stream.logical.LogicalProject;
import edu.uci.asterix.stream.utils.Assertion;

public class IdentifyAggregateExprs implements LogicalPlanAnalyzer {

    @Override
    public LogicalPlan analyze(LogicalPlan plan) {
        if (!(plan instanceof LogicalProject)) {
            return plan;
        }

        LogicalProject project = (LogicalProject) plan;
        LogicalPlan child = project.getChild();
        if (!(child instanceof LogicalGroupby)) {
            return plan;
        }

        LogicalGroupby groupBy = (LogicalGroupby) child;

        List<AggregateExpr> aggregateExprs = new ArrayList<>();
        List<Expr> projectList = project.getProjectList();
        projectList.forEach(expr -> {
            identify(expr, aggregateExprs);
        });

        LogicalPlan resultPlan = new LogicalGroupby(groupBy.getChild(), groupBy.getByFields(), aggregateExprs,
                groupBy.getHavingCondition());
        StructType resultSchema = resultPlan.getSchema();

        List<Expr> resultProjectList = projectList.stream().map(expr -> replace(expr, aggregateExprs, resultSchema))
                .collect(Collectors.toList());

        //analyze having condition
        LogicExpr havingCondition = groupBy.getHavingCondition();
        if (havingCondition != null) {
            LogicExpr replacedHavingCondition = (LogicExpr) replace(havingCondition, aggregateExprs, resultSchema);
            resultPlan = new LogicalFilter(resultPlan, replacedHavingCondition);
        }

        resultPlan = new LogicalProject(resultPlan, resultProjectList);

        return resultPlan;
    }

    private void identify(Expr projectExpr, List<AggregateExpr> aggregateExprs) {
        List<AggregateExpr> aggrs = Exprs.collect(projectExpr, AggregateExpr.class);
        for (AggregateExpr aggr : aggrs) {
            if (!aggregateExprs.contains(aggr)) {
                aggregateExprs.add((AggregateExpr) aggr);
            }
        }

    }

    private Expr replace(Expr expr, List<AggregateExpr> aggregateExprs, StructType schema) {
        if (expr instanceof AggregateExpr) {
            int index = aggregateExprs.indexOf(expr);
            Assertion.asserts(index >= 0, "Invalid AggregateExpr " + expr);
            return new FieldAccess(aggregateExprs.get(index).toField(), schema);
        } else {
            Expr[] children = expr.children();
            Expr[] replacedChildren = new Expr[children.length];
            for (int i = 0; i < children.length; i++) {
                replacedChildren[i] = replace(children[i], aggregateExprs, schema);
            }
            return expr.withChildren(replacedChildren);
        }
    }

}
