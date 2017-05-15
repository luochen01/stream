package edu.uci.asterix.stream.expr.logic;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;

public class LikeTest {

    @Test
    public void test() {
        Like like = mockLike("stream processing", "%process%");
        Tuple tuple = Mockito.mock(Tuple.class);
        Assert.assertTrue((Boolean) like.eval(tuple));
    }

    private Like mockLike(String value, String pattern) {
        Expr expr = Mockito.mock(Expr.class);
        Mockito.when(expr.eval(Mockito.any(Tuple.class))).thenReturn(value);
        return new Like(expr, pattern);
    }

}
