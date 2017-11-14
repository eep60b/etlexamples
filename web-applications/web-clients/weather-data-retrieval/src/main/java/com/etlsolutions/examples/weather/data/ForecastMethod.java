package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum ForecastMethod {
    
    HOURLY_3(3);
    
    private final int value;
    
    private ForecastMethod(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static ForecastMethod getForecastMethod(String value) {
        
        for(ForecastMethod method : values()) {
            if(method.value == Integer.parseInt(value)) {
                return method;
            }
        }
        
        throw new IllegalArgumentException("Unknow forecast method code.");
    }
}
