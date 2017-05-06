package edu.uci.asterix.stream.logical.analyzer;

import org.junit.Assert;
import org.junit.Test;

import edu.uci.asterix.stream.expr.logic.And;
import edu.uci.asterix.stream.expr.logic.False;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.expr.logic.Not;
import edu.uci.asterix.stream.expr.logic.Or;
import edu.uci.asterix.stream.expr.logic.True;

public class CNFNormalizerTest {

    public LogicExpr t = True.INSTANCE;

    public LogicExpr f = False.INSTANCE;

    @Test
    public void test() {
        LogicExpr expr1 = new And(new And(t, f), f);
        LogicExpr result1 = CNFNormalizer.INSTANCE.toCNF(expr1);
        Assert.assertEquals(expr1, result1);

        LogicExpr expr2 = new Or(new Or(f, t), t);
        LogicExpr result2 = CNFNormalizer.INSTANCE.toCNF(expr2);
        Assert.assertEquals(expr2, result2);

        LogicExpr expr3 = new And(new Or(t, t), new Or(f, f));
        LogicExpr result3 = CNFNormalizer.INSTANCE.toCNF(expr3);
        Assert.assertEquals(expr3, result3);

        LogicExpr expr4 = new Or(new And(t, t), new Or(f, f));
        LogicExpr result4 = CNFNormalizer.INSTANCE.toCNF(expr4);
        Assert.assertEquals(new And(new Or(t, new Or(t, t)), new Or(t, new Or(f, f))), result4);

        LogicExpr expr5 = new Not(new And(t, t));
        LogicExpr result5 = CNFNormalizer.INSTANCE.toCNF(expr5);
        Assert.assertEquals(new Or(f, f), result5);
    }

}
