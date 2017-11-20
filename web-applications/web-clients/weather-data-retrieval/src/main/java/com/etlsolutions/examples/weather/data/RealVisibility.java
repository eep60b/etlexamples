package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class RealVisibility {

    private final double value;

    public RealVisibility(String value) {

        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }
}
