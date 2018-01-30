package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum PredictedVisibility implements Valuable {

    UNKOWN("UN", -100, 0), VERY_POOR("VP", 0, 1000), POOR("PO", 1000, 4000), MODEARATE("MO", 4000, 10000), GOOD("GO", 10000, 20000), VERY_GOOD("VG", 20000, 40000), EXCELLENT("EX", 40000, 80000);

    public static final String SHORT_PARAMETER_NAME = "V";

    private final String code;    
    private final double value;
    private final double maxValue;

    private PredictedVisibility(String code, double minValue, double maxValue) {
        this.code = code;
        this.value = minValue;
        this.maxValue = maxValue;
    }

    public String getCode() {
        return code;
    }

    @Override
    public Double getValue() {
        return value;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public static PredictedVisibility getPredictedVisibility(double value) {

        for (PredictedVisibility visibility : values()) {
            if (visibility.value <= value && visibility.maxValue > value) {
                return visibility;
            }
        }

        return UNKOWN;
    }

    public static PredictedVisibility getPredictedVisibility(String code) {

        for (PredictedVisibility visibility : values()) {
            if (visibility.code.equals(code)) {
                return visibility;
            }
        }

        return UNKOWN;
    }

    @Override
    public String getShortName() {
        return "PrVis";
    }

    @Override
    public String toString() {
        return "Predicted visibility: " + name() + "(" + value + "-" + maxValue+ ")";
    }
}
