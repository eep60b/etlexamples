package com.etlsolutions.examples.weather.data;

/**
 * The RealTemperature class represents the temperature either forecasted or
 * observed.
 *
 * @author zc
 */
public final class RealTemperature extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "T";

    public RealTemperature(String value) {

        super(Double.parseDouble(value));
    }

    @Override
    public String toString() {
        return "Temperature: " + value;
    }

    @Override
    public String getShortName() {
        return "Tempt";
    }
}
