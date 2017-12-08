package com.etlsolutions.examples.weather.data;

/**
 * The DewPoint class represents a dew point.
 *
 * @author zc
 */
public final class DewPoint extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "Dp";    
    
    /**
     * Construct an object using the given value.
     *
     * @param value - The given value.
     * @throws NumberFormatException if the value cannot be parsed to a double
     * value
     */
    public DewPoint(String value) {

        super(Double.parseDouble(value));
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
