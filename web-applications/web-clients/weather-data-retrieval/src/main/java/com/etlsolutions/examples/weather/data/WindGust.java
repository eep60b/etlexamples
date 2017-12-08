package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class WindGust extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "G";

    public WindGust(WindSpeed windSpeed) {
        super(windSpeed.getValue());
    }
    
    public WindGust(String value) {

        this(new WindSpeed(value));
    }

    @Override
    public String getShortName() {
        return "WdGst";
    }
}
