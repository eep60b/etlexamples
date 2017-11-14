package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum RealVisibility {
    
    UNKOWN("UN", 0), VERY_POOR("VP", 1), POOR("PO", 2), MODEARATE("MO", 3), GOOD("GO", 4), VERY_GOOD("VG", 5), EXCELLENT("EX", 6);
    
    private final int value;
    private final String code;
    
    private RealVisibility(String code, int value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public int getValue() {
        return value;
    }
    
    public static RealVisibility getRealVisibility(int value) {
        
        for(RealVisibility visibility : values()) {
            if(visibility.value == value) {
                return visibility;
            }
        }
        
        throw new IllegalArgumentException("Unknow visibility code.");
    }    
    
    public static RealVisibility getRealVisibility(String code) {
        
        for(RealVisibility visibility : values()) {
            if(visibility.code.equals(code)) {
                return visibility;
            }
        }
        
        throw new IllegalArgumentException("Unknow visibility code.");
    }    
}
