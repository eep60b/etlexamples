package com.etlsolutions.examples.weather.data;

/**
 * The PrecipitationProbability class represents a precipitation probability.
 *
 * @author zc
 */
public final class PrecipitationProbability implements Valuable {

    private final double value;

    public PrecipitationProbability(String value) {

        this.value = Double.parseDouble(value);

        if ((this.value < 0 || this.value > 100) && this.value != -100) {
            throw new IllegalArgumentException("Invalid precipitation probability value: " + this.value);
        }
    }

    @Override
    public Double getValue() {
        return value;
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
