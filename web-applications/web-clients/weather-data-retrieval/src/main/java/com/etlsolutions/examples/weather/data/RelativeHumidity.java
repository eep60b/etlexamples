package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.apache.log4j.Logger;

/**
 * The RelativeHumidity class represents the relative humidity.
 * @author zc
 */
public class RelativeHumidity extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "H";


    private RelativeHumidity(String value) {

        super(Double.parseDouble(value));
    }

    /**
     * Get an instance of the relative humidity class.
     *
     * @param value - The relative humidity value.
     * @return the relative humidity value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static RelativeHumidity getInstance(String value) {
        try {
            return new RelativeHumidity(value);
        } catch (Exception ex) {
            Logger.getLogger(RelativeHumidity.class).warn("Unknown relative humidity value: " + value, ex);
            return new RelativeHumidity(UNKNOW_VALUE);
        }
    }
     
    @Override
    public String getShortName() {
        return "Humid";
    }

    @Override
    public String toString() {
        return "RelativeHumidity: " + value;
    }
}
