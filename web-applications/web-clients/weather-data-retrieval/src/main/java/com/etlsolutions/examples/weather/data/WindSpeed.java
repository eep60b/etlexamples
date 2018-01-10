package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.apache.log4j.Logger;

/**
 * The WindSpeed class represents the wind speed in data.
 *
 * @author zc
 */
public final class WindSpeed extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "S";

    private WindSpeed(String value) {

        super(Double.parseDouble(value));
    }

    /**
     * Get an instance of the WindSpeed class for the given value.
     *
     * @param value - The wind speed value.
     * @return the wind speed value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static WindSpeed getInstance(String value) {
        try {
            return new WindSpeed(value);
        } catch (Exception ex) {
            Logger.getLogger(WindSpeed.class).warn("Unknown wind speed value: " + value, ex);
            return new WindSpeed(UNKNOW_VALUE);
        }
    }

    @Override
    public String getShortName() {
        return "WnSpd";
    }

    @Override
    public String toString() {
        return "WindSpeed: " + value;
    }
}
