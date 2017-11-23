package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class WindSpeed {

    private final double value;

    public WindSpeed(String value) {

        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }
}
