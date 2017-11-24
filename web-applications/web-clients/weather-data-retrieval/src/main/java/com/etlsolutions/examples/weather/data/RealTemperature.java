package com.etlsolutions.examples.weather.data;

/**
 * The RealTemperature class represents the temperature either forecasted or
 * observed.
 *
 * @author zc
 */
public final class RealTemperature implements Valuable {

    private final double value;

    public RealTemperature(String value) {

        this.value = Double.parseDouble(value);
    }

    @Override
    public Double getValue() {
        return value;
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
