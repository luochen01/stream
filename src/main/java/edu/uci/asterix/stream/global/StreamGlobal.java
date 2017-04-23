package edu.uci.asterix.stream.global;

import java.util.Collections;

import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.plan.RelOptCostFactory;
import org.apache.calcite.prepare.CalciteCatalogReader;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeSystem;
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;

import edu.uci.asterix.stream.catalog.Catalog;

public class StreamGlobal {

    public static final CalciteSchema DEFAULT_CATALOG = Catalog.INSTANCE;

    public static final RelDataTypeSystem DEFAULT_TYPE_SYSTEM = RelDataTypeSystem.DEFAULT;

    public static final RelDataTypeFactory DEFAULT_TYPE_FACTORY = new SqlTypeFactoryImpl(DEFAULT_TYPE_SYSTEM);

    public static final CalciteCatalogReader CATALOG_READER = new CalciteCatalogReader(Catalog.INSTANCE,
            StreamConfig.Instance.caseSensitive(), Collections.emptyList(), DEFAULT_TYPE_FACTORY);

    public static final RelOptCostFactory DEFAULT_COST_FACTORY = StreamCostImpl.FACTORY;
}
