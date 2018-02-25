package com.vel9.generativemusic.aen.core.geoevent;

public interface GeoEventConverterStrategy {

    /**
     * Converts a a GeoEvent within a bounding box to a NoteLocation
     *
     * Implementations could provide pan and velocity values based on where
     * an event occurred within a bounding box
     *
     * For example, events occurring near the left-most edge of a bounding box
     * could receive a "extreme-left" pan value
     *
     * @param event geo located event
     * @param boundingBox bounding box within which the event occurred
     * @return musical instruction representing event's location within bounding box
     */
    NoteLocation toMusicalInstruction(GeoEvent event, BoundingBox boundingBox);

    /**
     * Returns the maximum pan value which may be provided by the implementation
     *
     * @return maximum pan amount
     */
    int getMaxPanAmount();
}

