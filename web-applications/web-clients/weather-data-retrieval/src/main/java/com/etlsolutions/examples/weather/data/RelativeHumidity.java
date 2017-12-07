package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public class RelativeHumidity implements Valuable {

    public static final String SHORT_PARAMETER_NAME = "H";

    private final double value;

    public RelativeHumidity(String value) {

        this.value = Double.parseDouble(value);

        if (this.value < 0 || this.value > 100) {
            throw new IllegalArgumentException("Invalid relative humidity value.");
        }
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String getShortName() {
        return "Humid";
    }
}
