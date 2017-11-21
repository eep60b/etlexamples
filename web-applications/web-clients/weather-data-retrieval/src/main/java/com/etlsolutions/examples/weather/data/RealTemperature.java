package com.etlsolutions.examples.weather.data;

/**
 * The RealTemperature class represents the temperature either forecasted or
 * observed.
 *
 * @author zc
 */
public final class RealTemperature {

    private final double value;

    public RealTemperature(String value) {

        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Temperature: " + value;
    }

}
