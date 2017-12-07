package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class WindGust implements Valuable {

    public static final String SHORT_PARAMETER_NAME = "G";

    private final double value;

    public WindGust(String value) {

        this.value = Double.parseDouble(value);
    }

    public WindGust(WindSpeed windSpeed) {
        this.value = windSpeed.getValue();
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String getShortName() {
        return "WdGst";
    }
}
