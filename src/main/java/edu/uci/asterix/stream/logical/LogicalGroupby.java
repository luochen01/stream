package edu.uci.asterix.stream.logical;

import java.util.List;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.pred.PredicateExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public class LogicalGroupby extends UnaryLogicalPlan {

    protected final List<Field> byFields;
    protected final List<Expr> aggregateExprs;
    protected final PredicateExpr havingCondition;

    public LogicalGroupby(LogicalPlan child, List<Field> byFields, List<Expr> aggregateExprs,
            PredicateExpr havingCondition) {
        super(child);

        this.byFields = byFields;
        this.aggregateExprs = aggregateExprs;
        this.havingCondition = havingCondition;
    }

    @Override
    public StructType getSchema() {
        //TODO
        return null;
    }

}
