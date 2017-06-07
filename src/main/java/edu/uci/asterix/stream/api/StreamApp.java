package edu.uci.asterix.stream.api;

import java.io.IOException;

import edu.uci.asterix.stream.execution.eval.StreamQueryExecutor;
import edu.uci.asterix.stream.execution.operators.Operator;
import edu.uci.asterix.stream.parser.TQLParser;
import edu.uci.asterix.stream.planner.QueryPlanner;

public class StreamApp {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: query file");
            System.exit(0);
        }
        StreamApp app = new StreamApp();
        try {
            app.run(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(String queryPath) throws IOException {
        IQueryConfig config = new QueryConfig();

        TQLParser parser = new TQLParser(config);

        QueryContext context = parser.parse(queryPath);

        System.out.println("Logical Plan");
        System.out.println(context.getQuery().getLogicalPlan());

        QueryPlanner planner = new QueryPlanner(context);

        Operator operator = planner.plan(context.getQuery().getLogicalPlan());

        System.out.println("Operator Tree");
        System.out.println(operator);

        StreamQueryExecutor.INSTANCE.asyncExecute(operator, config.createTupleWriter());
    }

}
