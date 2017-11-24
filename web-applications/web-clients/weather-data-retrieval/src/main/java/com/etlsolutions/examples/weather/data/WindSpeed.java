package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class WindSpeed implements Valuable {

    private final double value;

    public WindSpeed(String value) {

        this.value = Double.parseDouble(value);
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String getShortName() {
        return "WnSpd";
    }
}
