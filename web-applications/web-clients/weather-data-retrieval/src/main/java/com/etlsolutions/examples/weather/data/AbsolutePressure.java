package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.apache.log4j.Logger;

/**
 * The AbsolutePressure class represents the air pressure.
 *
 * @author zc
 */
public final class AbsolutePressure extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "P";
    
    private AbsolutePressure(String value) {

        super(Double.parseDouble(value));
    }

    /**
     * Get an instance of the AbsolutePressure class.
     *
     * @param value - The absolute pressure value.
     * @return the absolute pressure value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static AbsolutePressure getInstance(String value) {
        try {
            return new AbsolutePressure(value);
        } catch (Exception ex) {
            Logger.getLogger(AbsolutePressure.class).warn("Unknown absolute pressure value: " + value, ex);
            return new AbsolutePressure(UNKNOW_VALUE);
        }
    }

    @Override
    public String toString() {
        return "AbsolutePressure: " + value;
    }

    @Override
    public String getShortName() {
        return "Press";
    }
}
