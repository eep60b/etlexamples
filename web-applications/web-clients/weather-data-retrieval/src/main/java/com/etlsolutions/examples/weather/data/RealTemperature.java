package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class RealTemperature {
    
       private final double value;
    
    public RealTemperature(String value) {
        
        this.value = Double.parseDouble(value);
    } 

    public double getValue() {
        return value;
    } 
}
