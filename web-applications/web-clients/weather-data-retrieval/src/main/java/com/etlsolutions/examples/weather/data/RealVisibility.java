package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public final class RealVisibility extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "V";

    private RealVisibility(String value) {

        super(Double.parseDouble(value));
    }
    
    /**
     * Get an instance of the RealVisibility class.
     *
     * @param value - The real visibility value.
     * @return the real visibility value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static RealVisibility getInstance(String value) {
        try {
            return new RealVisibility(value);
        } catch (Exception ex) {
            Logger.getLogger(RealVisibility.class).warn("Unknown real visibility value: " + value, ex);
            return new RealVisibility(UNKNOW_VALUE);
        }
    }
 
    @Override
    public String getShortName() {
        return "Vsblt";
    }

    @Override
    public String toString() {
        return "RealVisibility: " + value;
    }    
}
