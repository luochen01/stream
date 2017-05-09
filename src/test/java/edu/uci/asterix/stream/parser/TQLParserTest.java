package edu.uci.asterix.stream.parser;

import java.io.IOException;

import org.junit.Test;

import edu.uci.asterix.stream.execution.operators.Operator;
import edu.uci.asterix.stream.planner.QueryPlanner;

public class TQLParserTest {

    @Test
    public void test() throws IOException {
        TQLParser parser = new TQLParser();

        QueryContext context = parser.parse("src/test/resources/test.tql");

        System.out.println("Logical Plan");
        System.out.println(context.getQuery().getLogicalPlan());

        Operator operator = QueryPlanner.INSTANCE.plan(context.getQuery().getLogicalPlan());

        System.out.println("Operator Tree");
        System.out.println(operator);
    }

}
