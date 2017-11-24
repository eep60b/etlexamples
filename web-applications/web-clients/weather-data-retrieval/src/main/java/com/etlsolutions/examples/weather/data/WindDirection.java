package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum WindDirection implements Valuable {
    N(0), NNE(225), NE(450), ENE(675), E(900), ESE(1125), SE(1350), SSE(1575), S(1800), SSW(2025), SW(2250), WSW(2475), W(2700), WNW(2925), NW(3150), NNW(3375), UNKOWN(-100);
    
        private final int value;
    
    private WindDirection(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
    
    public static WindDirection getWindDirection(int value) {
        
        for(WindDirection windDirection : values()) {
            if(windDirection.value == value) {
                return windDirection;
            }
        }
        
        throw new IllegalArgumentException("Unknow wind direction value:" + value);
    }    
    
    public static WindDirection getWindDirection(String code) {
        
        for(WindDirection windDirection : values()) {
            if(windDirection.name().equals(code)) {
                return windDirection;
            }
        }
        
        throw new IllegalArgumentException("Unknow wind direction value:" + code);
    }

    @Override
    public String getShortName() {
        return "WdDrc";
    }
}
