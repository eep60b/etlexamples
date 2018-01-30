package com.etlsolutions.examples.weather.data;

/**
 * The RelativeHumidity class represents the relative humidity.
 *
 * @author zc
 */
public class RelativeHumidity extends AbstractDoubleValuable {

    public static final String SHORT_PARAMETER_NAME = "H";

    private RelativeHumidity(String value) {

        super(value, "Relative Humidity");
    }

    /**
     * Get an instance of the relative humidity class.
     *
     * @param value - The relative humidity value.
     * @return the relative humidity value. If the given value is invalid, an
     * unknown object is returned. No exception will be thrown.
     */
    public static RelativeHumidity getInstance(String value) {

        return new RelativeHumidity(value);
    }

    @Override
    public String getShortName() {
        return "Humid";
    }

    @Override
    public String toString() {
        return "Relative humidity: " + value;
    }
}
