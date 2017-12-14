package com.etlsolutions.examples.weather.data;

import java.util.Objects;

/**
 * The RequestLocation class represents a location where the data to be
 * acquired.
 *
 * @author zc
 */
public final class RequestLocation {

    private final String id;
    private final String name;
    private final double latitude;
    private final double longitude;
    private final double elevation;

    public RequestLocation(String id, String name, double latitude, double longitude, double elevation) {

        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getElevation() {
        return elevation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final RequestLocation other = (RequestLocation) obj;
        return Objects.equals(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return "RequestLocation{" + "id=" + id + ", name=" + name + '}';
    }
}
