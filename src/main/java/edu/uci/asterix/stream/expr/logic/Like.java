package edu.uci.asterix.stream.expr.logic;

import java.util.regex.Pattern;

import edu.uci.asterix.stream.exception.StreamExecutionException;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;

public class Like extends UnaryExpr<Expr> implements PredicateExpr {

    private final String pattern;

    private final Pattern regexPattern;

    public Like(Expr child, String pattern) {
        super("LIKE", child);
        this.pattern = pattern;

        pattern = pattern.replace(".", "\\."); // "\\" is escaped to "\" (thanks, Alan M)
        // ... escape any other potentially problematic characters here
        pattern = pattern.replace("?", ".");
        pattern = pattern.replace("%", ".*");
        regexPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public Object eval(Tuple input) throws StreamExecutionException {
        Object value = child.eval(input);
        if (value == null) {
            return null;
        } else {
            return regexPattern.matcher((String) value).matches();
        }

    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Like(children[0], pattern);
    }

    @Override
    public PredicateExpr dual() {
        return new NotLike(child, pattern);
    }

    @Override
    public String toString() {
        return child.toString() + " " + symbol + " " + pattern;
    }

}
