package com.etlsolutions.examples.weather.data;

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

        this(WindSpeed.getInstance(value, "Wind Gust"));
    }

    /**
     * Get an instance of the WindGust class.
     *
     * @param value - The wind gust value.
     * @return the wind gust value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static WindGust getInstance(String value) {

        return new WindGust(value);
    }

    /**
     * Get an instance of the WindGust class for the given wind speed.
     *
     * @param value - The wind speed value.
     * @return the wind gust value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static WindGust getInstance(WindSpeed value) {

        return new WindGust(value);
    }

    @Override
    public String getShortName() {
        return "WdGst";
    }

    @Override
    public String toString() {
        return "Wind gust: " + value;
    }
}
