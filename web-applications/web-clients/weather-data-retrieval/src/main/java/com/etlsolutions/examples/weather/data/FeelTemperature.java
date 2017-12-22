package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.apache.log4j.Logger;

/**
 * The FeelTemperature class represents a temperature felt by humans.
 *
 * @author zc
 */
public final class FeelTemperature extends AbstractValuable<Double>{

    public static final String SHORT_PARAMETER_NAME = "F";
    
    private FeelTemperature(String value) {

        super(Double.parseDouble(value));
    }

    /**
     * Get an instance of the FeelTemperature class.
     *
     * @param value - The feel temperature value.
     * @return the feel temperature value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static FeelTemperature getInstance(String value) {
        try {
            return new FeelTemperature(value);
        } catch (Exception ex) {
            Logger.getLogger(DewPoint.class).warn("Unknown feel temperature value: " + value, ex);
            return new FeelTemperature(UNKNOW_VALUE);
        }
    }
    
    @Override
    public String toString() {
        return "FeelTemperature: " + value;
    }

    @Override
    public String getShortName() {
        return "FTemp";
    }
}
