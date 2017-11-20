package com.etlsolutions.examples.weather.data;

/**
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
}
