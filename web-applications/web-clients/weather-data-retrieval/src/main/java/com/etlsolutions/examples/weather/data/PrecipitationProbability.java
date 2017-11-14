package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class PrecipitationProbability {

    private final int value;
    
    public PrecipitationProbability(String value) {
    
        this.value = Integer.parseInt(value);
        
        if(this.value < 0 || this.value > 100) {
            throw new IllegalArgumentException("Invalid precipitation probability value.");
        }    
    }

    public int getValue() {
        return value;
    }
}
