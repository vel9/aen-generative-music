package com.vel9.generativemusic.aen.core.geoevent;

/**
 * Simple container for a "geo event"
 *
 * Contains its location, timestamp and the source
 *
 */
public class GeoEvent {

    private Location location;
    private long timestamp;
    private String source;

    public GeoEvent(Location location, long timestamp, String source) {
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
        sb.append("geoevent: ").append(location).append(System.lineSeparator());
        sb.append("timestamp: ").append(timestamp).append(System.lineSeparator());
        sb.append("source: ").append(source).append(System.lineSeparator());
        return sb.toString();
    }
}
