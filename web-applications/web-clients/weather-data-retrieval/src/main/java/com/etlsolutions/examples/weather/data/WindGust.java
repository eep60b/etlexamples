package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.apache.log4j.Logger;

/**
 * The WindGust class represents the wind gust in data.
 *
 * @author zc
 */
public final class WindGust extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "G";

    private WindGust(WindSpeed windSpeed) {
        super(windSpeed.getValue());
    }

    private WindGust(String value) {

        this(WindSpeed.getInstance(value));
    }

    /**
     * Get an instance of the WindGust class.
     *
     * @param value - The wind gust value.
     * @return the wind gust value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static WindGust getInstance(String value) {
        try {
            return new WindGust(value);
        } catch (Exception ex) {
            Logger.getLogger(WindGust.class).warn("Unknown wind gust value: " + value, ex);
            return new WindGust(UNKNOW_VALUE);
        }
    }

    /**
     * Get an instance of the WindGust class for the given wind speed.
     *
     * @param value - The wind speed value.
     * @return the wind gust value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static WindGust getInstance(WindSpeed value) {
        try {
            return new WindGust(value);
        } catch (Exception ex) {
            Logger.getLogger(WindGust.class).warn("Unknown wind gust value: " + value, ex);
            return new WindGust(UNKNOW_VALUE);
        }
    }

    @Override
    public String getShortName() {
        return "WdGst";
    }

    @Override
    public String toString() {
        return "WindGust: " + value;
    }
}
