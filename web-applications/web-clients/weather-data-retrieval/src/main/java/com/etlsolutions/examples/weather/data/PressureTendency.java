package com.etlsolutions.examples.weather.data;

import org.apache.log4j.Logger;

/**
 * The PressureTendency enum represents the pressure tendency forecast.
 *
 * @author zc
 */
public enum PressureTendency implements Valuable {

    R(2, "rising"), RF(1, "rising then falling"), S(0, "steady"), FR(-1, "falling then rising"), F(-2, "falling"), UNKOWN(-100, "unkown");

    public static final String SHORT_PARAMETER_NAME = "Pt";
    private final int value;
    private final String description;

    private PressureTendency(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public static PressureTendency getPressureTendencyByValue(String value) {

        try {
            for (PressureTendency pressureTendency : values()) {
                if (pressureTendency.value == Integer.parseInt(value)) {
                    return pressureTendency;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PressureTendency.class).warn("Unkown Pressure Tendency value: " + value, ex);
        }
        return UNKOWN;
    }

    public static PressureTendency getPressureTendency(String name) {

        for (PressureTendency pressureTendency : values()) {
            if (pressureTendency.name().equalsIgnoreCase(name)) {
                return pressureTendency;
            }
        }

        return UNKOWN;
    }

    @Override
    public String toString() {
        return "PressureTendency: " + description;
    }

    @Override
    public String getShortName() {
        return "PrTdc";
    }
}
