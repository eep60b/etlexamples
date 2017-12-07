package com.etlsolutions.examples.weather.data;

/**
 * The DewPoint class represents a dew point.
 *
 * @author zc
 */
public final class DewPoint implements Valuable {

    public static final String SHORT_PARAMETER_NAME = "Dp";    
    
    private final double value;

    /**
     * Construct an object using the given value.
     *
     * @param value - The given value.
     * @throws NumberFormatException if the value cannot be parsed to a double
     * value
     */
    public DewPoint(String value) {

        this.value = Double.parseDouble(value);
    }

    /**
     * Get the dew point value.
     *
     * @return the dew point value
     */
    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Dew point: " + value;
    }

    @Override
    public String getShortName() {
        return "DwPnt";
    }
}
