package edu.uci.asterix.stream.parser;

import java.io.IOException;

import org.junit.Test;

public class TQLParserTest {

    @Test
    public void test() throws IOException {
        TQLParser parser = new TQLParser();

        QueryContext context = parser.parse("src/test/resources/test.tql");
        
        
        System.out.println(context.getQuery().getLogicalPlan());

    }

}
