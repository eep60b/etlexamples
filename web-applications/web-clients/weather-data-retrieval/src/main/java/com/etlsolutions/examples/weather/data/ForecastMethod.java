package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum ForecastMethod {
    
    HOURLY("hourly"), HOURLY_3("3hourly");
    
    private final String value;
    
    private ForecastMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static ForecastMethod getForecastMethod(String value) {
        
        for(ForecastMethod method : values()) {
            if(method.value.equals(value)) {
                return method;
            }
        }
        
        throw new IllegalArgumentException("Unknow forecast method code.");
    }

    @Override
    public String toString() {
        return "Forecast mehtod: " + value;
    }
}
