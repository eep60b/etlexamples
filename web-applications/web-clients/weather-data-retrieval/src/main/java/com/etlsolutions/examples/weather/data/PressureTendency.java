package com.etlsolutions.examples.weather.data;

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

        for (PressureTendency pressureTendency : values()) {
            if (pressureTendency.value == Integer.parseInt(value)) {
                return pressureTendency;
            }
        }

        throw new IllegalArgumentException("Unknow pressure tendency value:" + value);
    }

    public static PressureTendency getPressureTendency(String name) {

        for (PressureTendency pressureTendency : values()) {
            if (pressureTendency.name().equals(name)) {
                return pressureTendency;
            }
        }

        throw new IllegalArgumentException("Unknow pressure tendency name:" + name);
    }

    @Override
    public String toString() {
        return "Pressure tendency: " + description;
    }

    @Override
    public String getShortName() {
        return "PrTdc";
    }
}
