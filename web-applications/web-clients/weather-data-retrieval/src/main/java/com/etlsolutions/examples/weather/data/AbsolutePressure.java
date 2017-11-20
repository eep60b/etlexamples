package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public class AbsolutePressure {

    private final double value;
    
    public AbsolutePressure(String value) {
        
        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }
    
    
}
