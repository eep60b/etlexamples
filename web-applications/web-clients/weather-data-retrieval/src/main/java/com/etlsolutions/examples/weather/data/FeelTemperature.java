package com.etlsolutions.examples.weather.data;

/**
 * The FeelTemperature class represents a temperature felt by humans.
 *
 * @author zc
 */
public final class FeelTemperature {

    private final int value;

    public FeelTemperature(String value) {

        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Feel Temperature: " + value;
    }
}
