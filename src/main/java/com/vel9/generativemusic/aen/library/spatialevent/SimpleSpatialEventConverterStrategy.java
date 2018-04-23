package com.vel9.generativemusic.aen.library.spatialevent;

import com.vel9.generativemusic.aen.core.spatialevent.*;

import java.awt.geom.Point2D;

/**
 * Simple implementation of the SpatialEvent to NoteLocation converter which uses
 * the center of the bounding box and the location of event to determine
 * how far the event occurred from the center relative to the outer
 * boundaries of the bounding box
 */
public class SimpleSpatialEventConverterStrategy implements SpatialEventConverterStrategy {

    private static final int MAX_PAN_AMOUNT = 100;

    /* Coverts GeoEvent to NoteLocation */
    @Override
    public NoteLocation toMusicalInstruction(SpatialEvent spatialEvent, BoundingBox boundingBox) {
        int pan = getPanAmount(boundingBox, spatialEvent);
        int velocity = getVelocityAmount(boundingBox, spatialEvent);
        return new NoteLocation(pan, velocity);
    }

    @Override
    public int getMaxPanAmount(){
        return MAX_PAN_AMOUNT;
    }

    /**
     * Converts SpatialEvent's x value to a pan amount
     *
     * Considers only the x value of the SpatialEvent from the BoundingBox's center.
     *
     * If an event occurs at the far left edge of the bounding box, pan value will be 0
     * If an event occurs at the far right edge of the bounding box, pan value will be 100
     * If an event occurs at the center of the bounding box, pan value will be 50
     *
     * @param boundingBox bounding box
     * @param spatialEvent spatial event location
     * @return computed pan amount (0 - 100)
     */
    int getPanAmount(BoundingBox boundingBox, SpatialEvent spatialEvent) {
        Location location = spatialEvent.getLocation();
        double topLeftLong = boundingBox.getTopLeft().getX();
        double width = boundingBox.getTopRight().getX() - topLeftLong;
        double relativeEventLongitude = location.getX() - topLeftLong;
        double panPercentage = relativeEventLongitude/width;
        return (int) Math.round((panPercentage * 100));
    }

    /**
     * Measures the SpatialEvent's distance from the center and divides it
     * by the distance from the center to the top left corner of the bounding box
     *
     * The resulting "percentage" is then "reversed"
     * E.g. a 0.8 value, which would be far from the center, is turned
     * into a 0.2 value.
     *
     * Closer the SpatialEvent is to the center the greater the velocity value
     *
     * @param boundingBox bounding box
     * @param spatialEvent geo event location
     * @return computed velocity amount (0 - 100)
     */
    int getVelocityAmount(BoundingBox boundingBox, SpatialEvent spatialEvent) {
        Location eventLocation = spatialEvent.getLocation();
        double topLeftLongitude = boundingBox.getTopLeft().getX();
        Location center = boundingBox.getCenter();
        // event's distance from center
        double distance = Point2D.distance(center.getX(),
                center.getY(),
                eventLocation.getX(),
                eventLocation.getY());
        // furthest possible distance
        double topLeftLat = boundingBox.getTopLeft().getY();
        double furthestDistance = Point2D.distance(center.getY(),
                center.getX(),
                topLeftLat,
                topLeftLongitude);
        // if 0.2 distance, 1.0 furthest distance
        // need to return 80 and not 20
        // the further away the softer the velocity should be
        double velocityPercentage = distance/furthestDistance;
        double reversedPercentage = ((1. - velocityPercentage) * 100);
        return (int) Math.round(reversedPercentage);
    }

}
