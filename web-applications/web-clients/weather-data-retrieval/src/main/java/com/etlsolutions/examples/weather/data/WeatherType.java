package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum WeatherType {
         
    RAIN(1);
    
    private final int code;
    
    private WeatherType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
    public static WeatherType getWeatherType(String code) {
        
        for(WeatherType value : values()) {
            if(value.code == Integer.parseInt(code)) {
                return value;
            }
        }
        
        throw new IllegalArgumentException("Unknow weather type code.");
    }
}
