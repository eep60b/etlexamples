package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class WindGust {
    
     private final double value;
    
    public WindGust(String value) {
        
        this.value = Double.parseDouble(value);
    } 

    public WindGust(WindSpeed windSpeed) {
        this.value = windSpeed.getValue();
    }

    public double getValue() {
        return value;
    }   
}
