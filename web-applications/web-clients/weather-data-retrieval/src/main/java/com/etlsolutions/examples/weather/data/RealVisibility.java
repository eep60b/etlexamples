package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class RealVisibility implements Valuable {

    public static final String SHORT_PARAMETER_NAME = "V";

    private final double value;

    public RealVisibility(String value) {

        this.value = Double.parseDouble(value);
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public String getShortName() {
        return "Vsblt";
    }
}
