package com.etlsolutions.examples.weather.data;

/**
 * The FeelTemperature class represents a temperature felt by humans.
 *
 * @author zc
 */
public final class FeelTemperature implements Valuable{

    public static final String SHORT_PARAMETER_NAME = "F";
    
    private final double value;

    public FeelTemperature(String value) {

        this.value = Double.parseDouble(value);
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Feel Temperature: " + value;
    }

    @Override
    public String getShortName() {
        return "FTemp";
    }
}
