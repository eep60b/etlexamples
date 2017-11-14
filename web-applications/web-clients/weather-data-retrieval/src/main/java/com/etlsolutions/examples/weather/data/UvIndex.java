package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class UvIndex {
            
    private final int value;
    
    public UvIndex(String value) {
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }
}
