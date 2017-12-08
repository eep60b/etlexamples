package com.etlsolutions.examples.weather.data;

/**
 * The FeelTemperature class represents a temperature felt by humans.
 *
 * @author zc
 */
public final class FeelTemperature extends AbstractValuable<Double>{

    public static final String SHORT_PARAMETER_NAME = "F";
    
    public FeelTemperature(String value) {

        super(Double.parseDouble(value));
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
