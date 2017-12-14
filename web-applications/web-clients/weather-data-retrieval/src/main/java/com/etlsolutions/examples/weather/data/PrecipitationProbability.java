package com.etlsolutions.examples.weather.data;

/**
 * The PrecipitationProbability class represents a precipitation probability.
 *
 * @author zc
 */
public final class PrecipitationProbability extends AbstractValuable<Double> {
    
    public static final String SHORT_PARAMETER_NAME = "Pp";
    public static final double MINIMUM_VALUE = 0;
    public static final double MAXIMUM_VALUE = 100;
    
    public PrecipitationProbability(String value) {

        super(Double.parseDouble(value));
    }

    @Override
    public String toString() {
        return "Precipitation probability: " + value;
    }

    @Override
    public String getShortName() {
        return "PpPrb";
    }
}
