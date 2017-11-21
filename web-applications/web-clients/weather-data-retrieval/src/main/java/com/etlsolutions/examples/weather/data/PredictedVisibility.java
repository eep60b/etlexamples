package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum PredictedVisibility {
    
    UNKOWN("UN", -1000, 0), VERY_POOR("VP", 0, 1000), POOR("PO", 1000, 4000), MODEARATE("MO", 4000, 10000), GOOD("GO", 10000, 20000), VERY_GOOD("VG", 20000, 40000), EXCELLENT("EX", 40000, 80000);
    
    private final double minValue;
    private final double maxValue;
    private final String code;
    
    private PredictedVisibility(String code, double minValue, double maxValue) {
        this.code = code;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getCode() {
        return code;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }
        
    public static PredictedVisibility getPredictedVisibility(double value) {
        
        for(PredictedVisibility visibility : values()) {
            if(visibility.minValue <= value && visibility.maxValue > value) {
                return visibility;
            }
        }
        
        throw new IllegalArgumentException("Unknow visibility code.");
    }    
    
    public static PredictedVisibility getPredictedVisibility(String code) {
        
        for(PredictedVisibility visibility : values()) {
            if(visibility.code.equals(code)) {
                return visibility;
            }
        }
        
        throw new IllegalArgumentException("Unknow visibility code.");
    }    
}
