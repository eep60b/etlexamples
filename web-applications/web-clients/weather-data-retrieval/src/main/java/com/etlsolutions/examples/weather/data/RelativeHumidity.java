package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public class RelativeHumidity extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "H";


    public RelativeHumidity(String value) {

        super(Double.parseDouble(value));

        if (this.value < 0 || this.value > 100) {
            throw new IllegalArgumentException("Invalid relative humidity value.");
        }
    }

    @Override
    public String getShortName() {
        return "Humid";
    }
}
