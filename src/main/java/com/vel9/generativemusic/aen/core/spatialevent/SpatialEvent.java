package com.vel9.generativemusic.aen.core.spatialevent;

/**
 * Simple container for a "spatial event"
 *
 * Contains its location, timestamp and the source
 *
 */
public class SpatialEvent {

    private Location location;
    private long timestamp;
    private String source;

    public SpatialEvent(Location location, long timestamp, String source) {
        this.location = location;
        this.timestamp = timestamp;
        this.source = source;
    }

    public Location getLocation() {
        return location;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("spatialevent: ").append(location).append(System.lineSeparator());
        sb.append("timestamp: ").append(timestamp).append(System.lineSeparator());
        sb.append("source: ").append(source).append(System.lineSeparator());
        return sb.toString();
    }
}
