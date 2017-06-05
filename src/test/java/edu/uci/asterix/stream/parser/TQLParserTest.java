package edu.uci.asterix.stream.parser;

import java.io.IOException;

import org.junit.Test;

import edu.uci.asterix.stream.api.IQueryConfig;
import edu.uci.asterix.stream.api.QueryConfig;
import edu.uci.asterix.stream.api.QueryContext;
import edu.uci.asterix.stream.execution.eval.StreamQueryExecutor;
import edu.uci.asterix.stream.execution.operators.Operator;
import edu.uci.asterix.stream.planner.QueryPlanner;

public class TQLParserTest {

    @Test
    public void test() throws IOException {
        IQueryConfig config = new QueryConfig();

        TQLParser parser = new TQLParser(config);

        QueryContext context = parser.parse("src/test/resources/test_csv.tql");

        System.out.println("Logical Plan");
        System.out.println(context.getQuery().getLogicalPlan());

        QueryPlanner planner = new QueryPlanner(context);

        Operator operator = planner.plan(context.getQuery().getLogicalPlan());

        System.out.println("Operator Tree");
        System.out.println(operator);

        StreamQueryExecutor.INSTANCE.syncExecute(operator, config.createTupleWriter());
    }

}
