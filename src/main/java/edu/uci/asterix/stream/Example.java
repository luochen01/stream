package edu.uci.asterix.stream;

import java.util.ArrayList;
import java.util.List;

import org.apache.calcite.config.Lex;
import org.apache.calcite.plan.Contexts;
import org.apache.calcite.plan.ConventionTraitDef;
import org.apache.calcite.plan.RelOptRule;
import org.apache.calcite.plan.RelTraitDef;
import org.apache.calcite.rel.RelCollationTraitDef;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.rel.rules.FilterMergeRule;
import org.apache.calcite.rel.rules.FilterProjectTransposeRule;
import org.apache.calcite.rel.rules.LoptOptimizeJoinRule;
import org.apache.calcite.rel.rules.ProjectFilterTransposeRule;
import org.apache.calcite.rel.rules.ProjectMergeRule;
import org.apache.calcite.rel.stream.StreamRules;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeField;
import org.apache.calcite.rel.type.RelDataTypeFieldImpl;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.asterix.stream.catalog.BaseTable;
import edu.uci.asterix.stream.catalog.Catalog;
import edu.uci.asterix.stream.catalog.CatalogException;
import edu.uci.asterix.stream.catalog.StreamSchema;
import edu.uci.asterix.stream.catalog.StreamTable;
import edu.uci.asterix.stream.execution.operators.IStreamOperator;
import edu.uci.asterix.stream.execution.rules.StreamConvention;
import edu.uci.asterix.stream.execution.rules.StreamRel;
import edu.uci.asterix.stream.global.StreamGlobal;

public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args)
            throws SqlParseException, CatalogException, ValidationException, RelConversionException {
        logger.error("Start");
        initCatalog();

        List<RelTraitDef> traitDefs = new ArrayList<RelTraitDef>();

        traitDefs.add(ConventionTraitDef.INSTANCE);
        traitDefs.add(RelCollationTraitDef.INSTANCE);

        ConfigBuilder builder = Frameworks.newConfigBuilder();

        builder.parserConfig(SqlParser.configBuilder().setLex(Lex.MYSQL).build());
        builder.traitDefs(traitDefs);
        builder.context(Contexts.EMPTY_CONTEXT);

        List<RelOptRule> rules = new ArrayList<>();
        rules.add(ProjectFilterTransposeRule.INSTANCE);
        rules.add(FilterProjectTransposeRule.INSTANCE);
        rules.add(ProjectMergeRule.INSTANCE);
        rules.add(FilterMergeRule.INSTANCE);
        rules.add(LoptOptimizeJoinRule.INSTANCE);
        rules.addAll(StreamRules.RULES);

        builder.ruleSets(RuleSets.ofList(rules));
        builder.costFactory(StreamGlobal.DEFAULT_COST_FACTORY);
        builder.typeSystem(StreamGlobal.DEFAULT_TYPE_SYSTEM);
        builder.defaultSchema(StreamGlobal.DEFAULT_CATALOG.plus());

        Planner planner = Frameworks.getPlanner(builder.build());

        //parse syntax tree
        SqlNode sqlNode = planner.parse("select stream user_name from sample.users where user_name = 'Chen'");

        //validation
        SqlNode validatedSqlNode = planner.validate(sqlNode);

        //syntax tree -> logical plan
        RelRoot root = planner.rel(validatedSqlNode);

        System.out.println(root.project());

        //query optimization
        RelNode optimized = planner.transform(0, planner.getEmptyTraitSet().replace(StreamConvention.INSTANCE),
                root.rel);
        System.out.println(optimized);

        //planning
        StreamRel physical = (StreamRel) planner.transform(0,
                planner.getEmptyTraitSet().replace(StreamConvention.INSTANCE), optimized);
        System.out.println(physical);

        //from optimized plan -> stream operators
        IStreamOperator operatorTree = physical.implement();
        while (operatorTree.hasNext()) {
            System.out.println(operatorTree.next());
        }
    }

    private static void initCatalog() throws CatalogException {
        Catalog.INSTANCE.add("sample", getSampleSchema(StreamGlobal.DEFAULT_TYPE_FACTORY));

    }

    private static Schema getSampleSchema(RelDataTypeFactory typeFactory) throws CatalogException {
        StreamSchema schema = new StreamSchema("sample");
        List<RelDataTypeField> fields = new ArrayList<>();
        fields.add(new RelDataTypeFieldImpl("user_id", 0, typeFactory.createSqlType(SqlTypeName.INTEGER)));
        fields.add(new RelDataTypeFieldImpl("user_name", 1, typeFactory.createSqlType(SqlTypeName.VARCHAR, 50)));

        BaseTable table = new StreamTable(schema, "users", null, fields);
        schema.addTable(table.getTableName(), table);
        return schema;
    }

}
