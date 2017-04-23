package edu.uci.asterix.stream;

import java.util.ArrayList;
import java.util.List;

import org.apache.calcite.config.Lex;
import org.apache.calcite.plan.Contexts;
import org.apache.calcite.plan.ConventionTraitDef;
import org.apache.calcite.plan.RelOptCostImpl;
import org.apache.calcite.plan.RelTraitDef;
import org.apache.calcite.rel.RelCollationTraitDef;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeField;
import org.apache.calcite.rel.type.RelDataTypeFieldImpl;
import org.apache.calcite.rel.type.RelDataTypeSystem;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Frameworks.ConfigBuilder;
import org.apache.calcite.tools.Planner;
import org.apache.calcite.tools.RelConversionException;
import org.apache.calcite.tools.RuleSets;
import org.apache.calcite.tools.ValidationException;

import edu.uci.asterix.stream.catalog.Catalog;
import edu.uci.asterix.stream.catalog.CatalogException;
import edu.uci.asterix.stream.catalog.StreamSchema;
import edu.uci.asterix.stream.catalog.StreamTable;
import edu.uci.asterix.stream.execution.operators.IStreamOperator;
import edu.uci.asterix.stream.execution.rules.StreamConvention;
import edu.uci.asterix.stream.execution.rules.StreamConverterRules;
import edu.uci.asterix.stream.execution.rules.StreamRel;

public class Example {

    public static void main(String[] args)
            throws SqlParseException, CatalogException, ValidationException, RelConversionException {
        initCatalog();

        List<RelTraitDef> traitDefs = new ArrayList<RelTraitDef>();

        traitDefs.add(ConventionTraitDef.INSTANCE);
        traitDefs.add(RelCollationTraitDef.INSTANCE);

        ConfigBuilder builder = Frameworks.newConfigBuilder();
        builder.parserConfig(SqlParser.configBuilder().setLex(Lex.MYSQL).build());
        builder.traitDefs(traitDefs);
        builder.context(Contexts.EMPTY_CONTEXT);

        builder.ruleSets(RuleSets.ofList(StreamConverterRules.RULES));
        builder.costFactory(RelOptCostImpl.FACTORY);
        builder.typeSystem(RelDataTypeSystem.DEFAULT);
        builder.defaultSchema(Catalog.instance().plus());

        Planner planner = Frameworks.getPlanner(builder.build());
        //parse syntax tree
        SqlNode sqlNode = planner.parse("select user_name from sample.users");

        //validation
        SqlNode validatedSqlNode = planner.validate(sqlNode);

        //syntax tree -> logical plan
        RelRoot root = planner.rel(validatedSqlNode);

        System.out.println(root.project());

        //query optimization/planning
        StreamRel physical = (StreamRel) planner.transform(0, root.rel.getTraitSet().replace(StreamConvention.INSTANCE),
                root.rel);
        System.out.println(physical);

        //from optimized plan -> stream operators
        IStreamOperator operatorTree = physical.implement();
        while (operatorTree.hasNext()) {
            System.out.println(operatorTree.next());
        }
    }

    private static void initCatalog() throws CatalogException {
        Catalog.instance().add("sample", getSampleSchema(Catalog.defaultTypeFactory()));

    }

    private static Schema getSampleSchema(RelDataTypeFactory typeFactory) throws CatalogException {
        StreamSchema schema = new StreamSchema("sample");
        List<RelDataTypeField> fields = new ArrayList<>();
        fields.add(new RelDataTypeFieldImpl("user_id", 0, typeFactory.createSqlType(SqlTypeName.INTEGER)));
        fields.add(new RelDataTypeFieldImpl("user_name", 1, typeFactory.createSqlType(SqlTypeName.VARCHAR, 50)));

        StreamTable table = new StreamTable(schema, "users", Schema.TableType.STREAM, null, fields);
        schema.addTable(table.getTableName(), table);
        return schema;
    }

}
