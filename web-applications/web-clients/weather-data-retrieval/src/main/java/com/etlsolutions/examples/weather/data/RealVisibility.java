package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class RealVisibility extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "V";

    public RealVisibility(String value) {

        super(Double.parseDouble(value));
    }

    @Override
    public String getShortName() {
        return "Vsblt";
    }
}
