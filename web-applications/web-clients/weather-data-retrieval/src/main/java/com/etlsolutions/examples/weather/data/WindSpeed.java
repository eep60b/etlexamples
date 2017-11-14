package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class WindSpeed {

    private final int speed;

    public WindSpeed(String speed) {

        this.speed = Integer.parseInt(speed);
    }

    public int getSpeed() {
        return speed;
    }
}
