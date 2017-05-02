package edu.uci.asterix.stream.expr;

public class Window {

    //in seconds
    protected final int range;

    //in seconds
    protected final int slide;

    public Window(int range, int slide) {
        this.range = range;
        this.slide = slide;
    }

    public int getRange() {
        return range;
    }

    public int getSlide() {
        return slide;
    }
}
