package com.etlsolutions.examples.weather.data;

/**
 * The AbsolutePressure class represents the air pressure.
 *
 * @author zc
 */
public final class AbsolutePressure implements Valuable {

    public static final String SHORT_PARAMETER_NAME = "P";
    
    private final double value;

    public AbsolutePressure(String value) {

        this.value = Double.parseDouble(value);
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pressure: " + value;
    }

    @Override
    public String getShortName() {
        return "Press";
    }
}
