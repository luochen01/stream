package edu.uci.asterix.stream.expr;

import java.util.ArrayList;
import java.util.List;

public class Exprs {

    public static <T extends Expr> List<T> collect(Expr expr, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        collectImpl(expr, clazz, list);
        return list;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Expr> void collectImpl(Expr expr, Class<T> clazz, List<T> list) {
        for (Expr child : expr.children()) {
            collectImpl(child, clazz, list);
        }
        if (clazz.isInstance(expr)) {
            list.add((T) expr);
        }
    }

}
