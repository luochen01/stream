package edu.uci.asterix.stream.function;

public abstract class AbstractFunction implements Function {

    protected final String name;

    public AbstractFunction(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
