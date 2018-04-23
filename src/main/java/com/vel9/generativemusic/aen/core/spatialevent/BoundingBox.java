package com.vel9.generativemusic.aen.core.spatialevent;

/**
 * Represents corner points, with latitude and logitude values, making up a "box" overlaid on a map
 */
public class BoundingBox {

    private Location center;
    private Location topLeft;
    private Location bottomLeft;
    private Location topRight;
    private Location bottomRight;

    public static BoundingBox createBoundingBox(double left, double right, double bottom, double top){
        double width = right - left;
        double height = top - bottom;

        Location origin = new Location(left + width/2, bottom + height/2);
        Location topLeft = new Location(left, top);
        Location topRight = new Location(right, top);
        Location bottomLeft = new Location(left, bottom);
        Location bottomRight = new Location(right, bottom);
        return new BoundingBox(origin, topLeft, bottomLeft, topRight, bottomRight);
    }

    private BoundingBox(Location center, Location topLeft, Location bottomLeft, Location topRight, Location bottomRight) {
        this.center = center;
        this.topLeft = topLeft;
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
    }

    public Location getCenter() {
        return center;
    }

    public Location getTopLeft() {
        return topLeft;
    }

    public Location getBottomLeft() {
        return bottomLeft;
    }

    public Location getTopRight() {
        return topRight;
    }

    public Location getBottomRight() {
        return bottomRight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("center: ").append(center).append(System.lineSeparator());
        sb.append("topLeft: ").append(topLeft).append(System.lineSeparator());
        sb.append("bottomLeft: ").append(bottomLeft).append(System.lineSeparator());
        sb.append("topRight: ").append(topRight).append(System.lineSeparator());
        sb.append("bottomRight: ").append(bottomRight).append(System.lineSeparator());
        return sb.toString();
    }

}
