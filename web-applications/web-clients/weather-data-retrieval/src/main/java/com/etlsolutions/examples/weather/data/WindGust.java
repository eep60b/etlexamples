package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class WindGust {
    
     private final int speed;
    
    public WindGust(String speed) {
        
        this.speed = Integer.parseInt(speed);
    } 

    public int getSpeed() {
        return speed;
    }   
}
