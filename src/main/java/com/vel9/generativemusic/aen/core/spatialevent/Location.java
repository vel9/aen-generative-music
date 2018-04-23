package com.vel9.generativemusic.aen.core.spatialevent;

/**
 * Simple holder for x and y values
 */
public class Location {

    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x: ").append(x).append(", ");
        sb.append("y: ").append(y);
        return sb.toString();
    }
}

