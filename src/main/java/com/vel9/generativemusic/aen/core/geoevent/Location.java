package com.vel9.generativemusic.aen.core.geoevent;

/**
 * Simple holder for longitude and latitude values
 */
public class Location {

    private double longitude;
    private double latitude;

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("longitude: ").append(longitude).append(", ");
        sb.append("latitude: ").append(latitude);
        return sb.toString();
    }
}

