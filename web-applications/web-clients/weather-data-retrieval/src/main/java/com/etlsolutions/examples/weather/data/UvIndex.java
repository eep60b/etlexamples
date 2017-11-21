package com.etlsolutions.examples.weather.data;

/**
 * The UvIndex class represents a UV index.
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

    @Override
    public String toString() {
        return "UV index: " + value;
    }
}
