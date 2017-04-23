package edu.uci.asterix.stream.catalog;

import java.util.Collections;

import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.prepare.CalciteCatalogReader;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeSystem;
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;

import edu.uci.asterix.stream.conf.StreamConfig;

/**
 * A catalog contains a set of schemas
 * 
 * @author luochen
 */
public class Catalog {
    private static CalciteSchema Instance = null;

    private static RelDataTypeFactory Default_Type_Factory = null;

    private static CalciteCatalogReader Catalog_Reader = null;

    public static synchronized CalciteSchema instance() {
        if (Instance == null) {
            Instance = CalciteSchema.createRootSchema(true);
        }
        return Instance;
    }

    public static synchronized CalciteCatalogReader catalogReader() {
        if (Catalog_Reader == null) {
            Catalog_Reader = new CalciteCatalogReader(instance(), StreamConfig.Instance.caseSensitive(),
                    Collections.emptyList(), defaultTypeFactory());
        }
        return Catalog_Reader;
    }

    public static synchronized RelDataTypeFactory defaultTypeFactory() {
        if (Default_Type_Factory == null) {
            Default_Type_Factory = new SqlTypeFactoryImpl(RelDataTypeSystem.DEFAULT);
        }
        return Default_Type_Factory;
    }
}