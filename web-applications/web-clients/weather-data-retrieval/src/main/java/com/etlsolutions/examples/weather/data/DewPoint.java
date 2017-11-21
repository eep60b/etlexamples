package com.etlsolutions.examples.weather.data;

/**
 * The DewPoint class represents a dew point.
 *
 * @author zc
 */
public final class DewPoint {

    private final double value;

    public DewPoint(String value) {

        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Dew point: " + value;
    }
}
