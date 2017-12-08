package com.etlsolutions.examples.weather.data;

/**
 * The PrecipitationProbability class represents a precipitation probability.
 *
 * @author zc
 */
public final class PrecipitationProbability extends AbstractValuable<Double> {
    
    public static final String SHORT_PARAMETER_NAME = "Pp";
    
    public PrecipitationProbability(String value) {

        super(Double.parseDouble(value));

        if ((this.value < 0 || this.value > 100) && this.value != -100) {
            throw new IllegalArgumentException("Invalid precipitation probability value: " + this.value);
        }
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
