package edu.uci.asterix.stream.execution;

public class DefaultSystemTimeProvider implements SystemTimeProvider {

    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
