package com.etlsolutions.examples.weather.data;

/**
 * The FeelTemperature class represents a temperature felt by humans.
 *
 * @author zc
 */
public final class FeelTemperature extends AbstractDoubleValuable {

    public static final String SHORT_PARAMETER_NAME = "F";

    private FeelTemperature(String value) {

        super(value, "Feel Temperature");
    }

    /**
     * Get an instance of the FeelTemperature class.
     *
     * @param value - The feel temperature value.
     * @return the feel temperature value. If the given value is invalid, an
     * unknown object is returned. No exception will be thrown.
     */
    public static FeelTemperature getInstance(String value) {

        return new FeelTemperature(value);
    }

    @Override
    public String toString() {
        return "FeelTemperature: " + value;
    }

    @Override
    public String getShortName() {
        return "FTemp";
    }
}
