package com.chamexxxx;

public class StageOptions {
    private final double width;
    private final double height;
    private final boolean maximized;

    public StageOptions(double width, double height, boolean maximized) {
        this.width = width;
        this.height = height;
        this.maximized = maximized;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isMaximized() {
        return maximized;
    }
}
