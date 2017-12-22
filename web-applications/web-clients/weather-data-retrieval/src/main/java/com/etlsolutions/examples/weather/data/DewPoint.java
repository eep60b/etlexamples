package com.etlsolutions.examples.weather.data;

import org.apache.log4j.Logger;

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
    private DewPoint(String value) {

        super(Double.parseDouble(value));
    }

    /**
     * Get an instance of the DewPoint class.
     *
     * @param value - The dew point value.
     * @return the dew point value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static DewPoint getInstance(String value) {
        try {
            return new DewPoint(value);
        } catch (Exception ex) {
            Logger.getLogger(DewPoint.class).warn("Unknown dew point value: " + value, ex);
            return new DewPoint(UNKNOW_VALUE);
        }
    }

    @Override
    public String toString() {
        return "DewPoint: " + value;
    }

    @Override
    public String getShortName() {
        return "DwPnt";
    }
}
