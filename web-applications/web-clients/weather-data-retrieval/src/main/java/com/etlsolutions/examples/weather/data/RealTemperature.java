package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class RealTemperature {
    
       private final int value;
    
    public RealTemperature(String value) {
        
        this.value = Integer.parseInt(value);
    } 

    public int getValue() {
        return value;
    } 
}
