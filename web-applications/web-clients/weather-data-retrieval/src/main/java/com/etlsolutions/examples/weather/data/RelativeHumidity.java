package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public class RelativeHumidity {

    private final int value;

    public RelativeHumidity(String value) {

        this.value = Integer.parseInt(value);

        if (this.value < 0 || this.value > 100) {
            throw new IllegalArgumentException("Invalid relative humidity value.");
        }
    }

    public int getValue() {
        return value;
    }
}
