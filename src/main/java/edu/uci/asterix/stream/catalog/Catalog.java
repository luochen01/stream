package edu.uci.asterix.stream.catalog;

import org.apache.calcite.jdbc.CalciteSchema;

/**
 * A catalog contains a set of schemas
 * 
 * @author luochen
 */
public class Catalog {
    public static final CalciteSchema INSTANCE = CalciteSchema.createRootSchema(true);
}