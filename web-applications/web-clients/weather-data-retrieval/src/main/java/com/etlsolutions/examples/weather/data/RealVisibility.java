package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum RealVisibility {
    
    CLEAR(1);
    
    private final int code;
    
    private RealVisibility(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
    public static RealVisibility getRealVisibility(String code) {
        
        for(RealVisibility value : values()) {
            if(value.code == Integer.parseInt(code)) {
                return value;
            }
        }
        
        throw new IllegalArgumentException("Unknow visibility code.");
    }    
}
