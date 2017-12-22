package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.apache.log4j.Logger;

/**
 * The RealTemperature class represents the temperature either forecasted or
 * observed.
 *
 * @author zc
 */
public final class RealTemperature extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "T";

    private RealTemperature(String value) {

        super(Double.parseDouble(value));
    }

    /**
     * Get an instance of the RealTemperature class.
     *
     * @param value - The real temperature value.
     * @return the real temperature value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static RealTemperature getInstance(String value) {
        try {
            return new RealTemperature(value);
        } catch (Exception ex) {
            Logger.getLogger(DewPoint.class).warn("Unknown real temperature value: " + value, ex);
            return new RealTemperature(UNKNOW_VALUE);
        }
    }
     
    @Override
    public String toString() {
        return "RealTemperature: " + value;
    }

    @Override
    public String getShortName() {
        return "Tempt";
    }
}
