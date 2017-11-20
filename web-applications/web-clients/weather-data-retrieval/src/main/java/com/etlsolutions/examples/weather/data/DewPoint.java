package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public class DewPoint {

    private final double value;

    public DewPoint(String value) {

        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }

}
