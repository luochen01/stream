package edu.uci.asterix.stream.execution;

public class DefaultSystemTimeProvider implements SystemTimeProvider {

    public static final DefaultSystemTimeProvider INSTANCE = new DefaultSystemTimeProvider();

    private DefaultSystemTimeProvider() {
    }

    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
