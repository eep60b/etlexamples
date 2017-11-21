package com.etlsolutions.examples.weather.data;

/**
 * The AbsolutePressure class represents the air pressure.
 *
 * @author zc
 */
public final class AbsolutePressure {

    private final double value;

    public AbsolutePressure(String value) {

        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pressure: " + value;
    }
}
