package edu.uci.asterix.stream.execution.rules;

import org.apache.calcite.plan.Convention;
import org.apache.calcite.plan.ConventionTraitDef;
import org.apache.calcite.plan.RelOptPlanner;
import org.apache.calcite.plan.RelTrait;
import org.apache.calcite.plan.RelTraitDef;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.convert.ConverterRule;

public enum StreamConvention implements Convention {
    INSTANCE;

    public static final double COST_MULTIPLIER = 1.0d;

    @Override
    public String toString() {
        return getName();
    }

    public Class<StreamRel> getInterface() {
        return StreamRel.class;
    }

    public String getName() {
        return "STREAM";
    }

    public RelTraitDef<?> getTraitDef() {
        return ConventionTraitDef.INSTANCE;
    }

    public boolean satisfies(RelTrait trait) {
        return this == trait;
    }

    public void register(RelOptPlanner planner) {
        for (ConverterRule rule : StreamConverterRules.RULES) {
            planner.addRule(rule);
        }
    }

    public boolean canConvertConvention(Convention toConvention) {
        return false;
    }

    public boolean useAbstractConvertersForConversion(RelTraitSet fromTraits, RelTraitSet toTraits) {
        return false;
    }
}