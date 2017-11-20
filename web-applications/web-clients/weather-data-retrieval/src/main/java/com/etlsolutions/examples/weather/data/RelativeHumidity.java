package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public class RelativeHumidity {

    private final double value;

    public RelativeHumidity(String value) {

        this.value = Double.parseDouble(value);

        if (this.value < 0 || this.value > 100) {
            throw new IllegalArgumentException("Invalid relative humidity value.");
        }
    }

    public double getValue() {
        return value;
    }
}
