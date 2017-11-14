package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class FeelTemperature {

    private final int value;
    
    public FeelTemperature(String value) {
        
        this.value = Integer.parseInt(value);
    } 

    public int getValue() {
        return value;
    }
}
