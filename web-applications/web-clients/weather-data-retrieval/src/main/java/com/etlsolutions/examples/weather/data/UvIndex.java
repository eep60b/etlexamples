package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum UvIndex {
    
    VERY_LOW(0);
    
        
    private final int code;
    
    private UvIndex(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
    public static UvIndex getUvIndex(String code) {
        
        for(UvIndex value : values()) {
            if(value.code == Integer.parseInt(code)) {
                return value;
            }
        }
        
        throw new IllegalArgumentException("Unknow UV index code.");
    }
}
