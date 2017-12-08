package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class WindSpeed extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "S";

    public WindSpeed(String value) {

        super(Double.parseDouble(value));
    }

    @Override
    public String getShortName() {
        return "WnSpd";
    }
}
