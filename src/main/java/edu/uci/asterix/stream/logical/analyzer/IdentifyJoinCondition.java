package edu.uci.asterix.stream.logical.analyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.logic.And;
import edu.uci.asterix.stream.expr.logic.BinaryPredicateExpr;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.expr.logic.Or;
import edu.uci.asterix.stream.expr.logic.PredicateExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalJoin;

public class IdentifyJoinCondition {

    private final StructType leftSchema;

    private final StructType rightSchema;

    private final List<Field> allFields;

    private final LogicExpr filterExpr;

    private LogicExpr simplifiedExpr;

    private LogicExpr joinCondition;

    private List<LogicExpr> results = new ArrayList<>();

    private List<EqualTo> equis = new ArrayList<>();
    private List<EqualTo> originalEquis = new ArrayList<>();

    public IdentifyJoinCondition(LogicalJoin join, LogicExpr filterExpr) {
        this.filterExpr = filterExpr;

        this.leftSchema = join.getLeft().getSchema();
        this.rightSchema = join.getRight().getSchema();
        this.allFields = join.getSchema().getFields();
    }

    //identify join condition from expr
    public void identify() {
        traverse(filterExpr);
        //build up join condition
        List<LogicExpr> simpliedExprs = new ArrayList<>();
        if (!equis.isEmpty()) {
            joinCondition = equis.get(0);
            simpliedExprs.add(originalEquis.get(0));
        } else {
            joinCondition = And.create(results);
            simpliedExprs.addAll(results);
        }
        simplifiedExpr = simplify(filterExpr, simpliedExprs);
    }

    public LogicExpr getJoinCondition() {
        return joinCondition;
    }

    public LogicExpr getSimplifiedExpr() {
        return simplifiedExpr;
    }

    private void traverse(LogicExpr expr) {
        if (expr instanceof And) {
            And and = (And) expr;
            traverse(and.getLeft());
            traverse(and.getRight());
        } else if (expr instanceof Or) {
            List<Expr> predicates = expr.collect(PredicateExpr.class);
            if (predicates.stream().allMatch(pred -> checkPredicate((PredicateExpr) pred) != null)) {
                //add or 
                results.add(expr);
            }

        } else if (expr instanceof PredicateExpr) {
            //a predicate
            PredicateExpr resultPred = checkPredicate((PredicateExpr) expr);
            if (resultPred != null) {
                results.add(resultPred);
                EqualTo equiCondition = checkEquiCondition((PredicateExpr) expr);
                if (equiCondition != null) {
                    equis.add(equiCondition);
                    originalEquis.add((EqualTo) expr);
                }
            }
        } else {
            throw new IllegalArgumentException("Unknown LogicExpr " + expr);
        }

    }

    private PredicateExpr checkPredicate(PredicateExpr predicate) {
        if (predicate instanceof BinaryPredicateExpr) {
            BinaryPredicateExpr comp = (BinaryPredicateExpr) predicate;
            List<Field> fields = comp.collect(FieldAccess.class).stream().map(access -> access.toField())
                    .collect(Collectors.toList());
            boolean intersects = intersects(fields, leftSchema) && intersects(fields, rightSchema);
            boolean solvable = intersects && allFields.containsAll(fields);
            //the fields in the condition need to access both left and right schemas, and is evaluatble 
            if (solvable) {
                return comp;
            }
        }
        return null;
    }

    private EqualTo checkEquiCondition(PredicateExpr predicate) {
        if (predicate instanceof EqualTo) {
            EqualTo equalTo = (EqualTo) predicate;
            List<Field> leftFields = equalTo.getLeft().collect(FieldAccess.class).stream()
                    .map(access -> access.toField()).collect(Collectors.toList());
            List<Field> rightFields = equalTo.getRight().collect(FieldAccess.class).stream()
                    .map(access -> access.toField()).collect(Collectors.toList());

            boolean leftMatchLeft = intersects(leftFields, leftSchema) && !intersects(leftFields, rightSchema);
            boolean rightMatchRight = intersects(rightFields, rightSchema) && !intersects(rightFields, leftSchema);
            if (leftMatchLeft && rightMatchRight) {
                return equalTo;
            }
            boolean leftMatchRight = intersects(leftFields, rightSchema) && !intersects(leftFields, leftSchema);
            boolean rightMatchLeft = intersects(rightFields, leftSchema) && !intersects(rightFields, rightSchema);
            if (leftMatchRight && rightMatchLeft) {
                return new EqualTo(equalTo.getRight(), equalTo.getLeft());
            }
        }
        return null;
    }

    private LogicExpr simplify(LogicExpr expr, List<LogicExpr> simplifiedExprs) {
        if (expr instanceof And) {
            And and = (And) expr;
            LogicExpr left = simplify(and.getLeft(), simplifiedExprs);
            LogicExpr right = simplify(and.getRight(), simplifiedExprs);
            if (left != null) {
                if (right != null) {
                    return and;
                } else {
                    return left;
                }
            } else {
                if (right != null) {
                    return right;
                } else {
                    return null;
                }
            }
        } else if (expr instanceof Or || expr instanceof PredicateExpr) {
            for (LogicExpr simplified : simplifiedExprs) {
                if (simplified.fastEqual(expr)) {
                    return null;
                }
            }
            return expr;
        }
        throw new IllegalArgumentException("Unknown LogicExpr " + expr);

    }

    private boolean intersects(List<Field> fields, StructType schema) {
        for (Field field : fields) {
            if (schema.getField(field.getFieldName()) != null) {
                return true;
            }
        }
        return false;
    }
}
