package com.etlsolutions.examples.weather.data;

/**
 * The RelativeHumidity class represents the relative humidity.
 * @author zc
 */
public class RelativeHumidity extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "H";


    public RelativeHumidity(String value) {

        super(Double.parseDouble(value));
    }

    @Override
    public String getShortName() {
        return "Humid";
    }
}
