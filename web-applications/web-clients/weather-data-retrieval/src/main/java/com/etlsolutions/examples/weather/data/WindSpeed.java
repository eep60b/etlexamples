package com.etlsolutions.examples.weather.data;

/**
 * The WindSpeed class represents the wind speed in data.
 *
 * @author zc
 */
public final class WindSpeed extends AbstractDoubleValuable {

    public static final String SHORT_PARAMETER_NAME = "S";

    private WindSpeed(String value, String name) {

        super(value, name);
    }

    /**
     * Get an instance of the WindSpeed class for the given value.
     *
     * @param value - The wind speed value.
     * @param name - The value name. 
     * @return the wind speed value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    static WindSpeed getInstance(String value, String name) {

        return new WindSpeed(value, name);
    }

    /**
     * Get an instance of the WindSpeed class for the given value.
     *
     * @param value - The wind speed value.
     * @return the wind speed value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static WindSpeed getInstance(String value) {

        return getInstance(value, "Wind Speed");
    }

    @Override
    public String getShortName() {
        return "WnSpd";
    }

    @Override
    public String toString() {
        return "Wind speed: " + value;
    }
}
