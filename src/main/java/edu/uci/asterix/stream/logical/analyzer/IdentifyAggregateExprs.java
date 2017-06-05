package edu.uci.asterix.stream.logical.analyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        List<Expr> projectList = project.getProjectList();
        List<AggregateExpr> aggregateExprs = new ArrayList<>();
        projectList.forEach(expr -> {
            identify(expr, aggregateExprs);
        });

        if (aggregateExprs.isEmpty() && !(child instanceof LogicalGroupby)) {
            //no aggregation here
            return plan;
        }

        LogicalGroupby groupBy = null;
        if (child instanceof LogicalGroupby) {
            groupBy = (LogicalGroupby) child;
        } else {
            //create a default group by operator here
            groupBy = new LogicalGroupby(child, Collections.EMPTY_LIST, Collections.EMPTY_LIST, null);
        }

        LogicalPlan resultPlan = new LogicalGroupby(groupBy.getChild(), groupBy.getByFields(), aggregateExprs,
                groupBy.getHavingCondition());

        StructType resultSchema = resultPlan.getSchema();

        List<Expr> resultProjectList = new ArrayList<>();
        for (Expr expr : projectList) {
            resultProjectList.add(replace(expr, aggregateExprs, groupBy.getByFields(), resultSchema));
        }

        //analyze having condition
        LogicExpr havingCondition = groupBy.getHavingCondition();
        if (havingCondition != null) {
            LogicExpr replacedHavingCondition = (LogicExpr) replace(havingCondition, aggregateExprs,
                    groupBy.getByFields(), resultSchema);
            resultPlan = new LogicalFilter(resultPlan, replacedHavingCondition);
        }

        resultPlan = new LogicalProject(resultPlan, resultProjectList);

        return resultPlan;
    }

    private void identify(Expr projectExpr, List<AggregateExpr> aggregateExprs) {
        List<AggregateExpr> aggrs = Exprs.collect(projectExpr, AggregateExpr.class);
        for (AggregateExpr aggr : aggrs) {
            if (!aggregateExprs.contains(aggr)) {
                aggregateExprs.add(aggr);
            }
        }
    }

    private Expr replace(Expr expr, List<AggregateExpr> aggregateExprs, List<Expr> byFields, StructType schema) {
        if (expr instanceof AggregateExpr) {
            int index = aggregateExprs.indexOf(expr);
            Assertion.asserts(index >= 0, "Invalid AggregateExpr " + expr);
            return new FieldAccess(aggregateExprs.get(index).toField(), schema);
        } else if (byFields.contains(expr)) {
            return new FieldAccess(expr.toField(), schema);
        } else if (expr instanceof FieldAccess) {
            return new FieldAccess(expr.toField(), schema);
        } else {
            Expr[] children = expr.children();
            Expr[] replacedChildren = new Expr[children.length];
            for (int i = 0; i < children.length; i++) {
                replacedChildren[i] = replace(children[i], aggregateExprs, byFields, schema);
            }
            return expr.withChildren(replacedChildren);
        }
    }

}
