package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum RequestMethod {
    
    OBS_HOURLY("wxobs", "hourly", "obs1h", "Hourly observation"), FCS_3HOURLY("wxfcs", "3hourly", "fcs3h", "3 hourly forecase");
    
    private final String methodToken;
    private final String interval;
    private final String abbreviation;
    private final String description;
    
    private RequestMethod(String methodToken, String value, String abbreviation, String description) {
        this.methodToken = methodToken;
        this.interval = value;
        this.abbreviation = abbreviation;
        this.description = description;
    }

    public String getMethodToken() {
        return methodToken;
    }

    public String getInterval() {
        return interval;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    
    public static RequestMethod getRequesttMethod(String methodToken, String interval) {
        
        for(RequestMethod method : values()) {
            if(method.methodToken.equals(methodToken) && method.interval.equals(interval)) {
                return method;
            }
        }
        
        throw new IllegalArgumentException("Unknow forecast method code.");
    }

    @Override
    public String toString() {
        return description;
    }
}
