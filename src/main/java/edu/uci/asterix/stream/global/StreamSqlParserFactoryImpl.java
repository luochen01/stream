package edu.uci.asterix.stream.global;

import java.io.Reader;

import org.apache.calcite.sql.parser.SqlAbstractParserImpl;
import org.apache.calcite.sql.parser.SqlParserImplFactory;

public class StreamSqlParserFactoryImpl implements SqlParserImplFactory {

    @Override
    public SqlAbstractParserImpl getParser(Reader stream) {
        return null;
    }

}
