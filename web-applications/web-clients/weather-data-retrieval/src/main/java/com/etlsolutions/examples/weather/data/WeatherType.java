package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum WeatherType {

    CLEAR_NIGHT(0),
    SUNNY_DAY(1),
    PARTLY_CLOUDY_NIGHT(2),
    PARTLY_CLOUDY_DAY(3),
    NOT_USED(4),
    MIST(5),
    FOG(6),
    CLOUDY(7),
    OVERCAST(8),
    LIGHT_RAIN_SHOWER_NIGHT(9),
    LIGHT_RAIN_SHOWER_DAY(10),
    DRIZZLE(11),
    LIGHT_RAIN(12),
    HEAVY_RAIN_SHOWER_NIGHT(13),
    HEAVY_RAIN_SHOWER_DAY(14),
    HEAVY_RAIN(15),
    SLEET_SHOWER_NIGHT(16),
    SLEET_SHOWER_DAY(17),
    SLEET(18),
    HAIL_SHOWER_NIGHT(19),
    HAIL_SHOWER_DAY(20),
    HAIL(21),
    LIGHT_SNOW_SHOWER_NIGHT(22),
    LIGHT_SNOW_SHOWER_DAY(23),
    LIGHT_SNOW(24),
    HEAVY_SNOW_SHOWER_NIGHT(25),
    HEAVY_SNOW_SHOWER_DAY(26),
    HEAVY_SNOW(27),
    THUNDER_SHOWER_NIGHT(28),
    THUNDER_SHOWER_DAY(29),
    THUNDER(30);

    private final int value;

    private WeatherType(int code) {
        this.value = code;
    }

    public int getValue() {
        return value;
    }

    public static WeatherType getWeatherType(String value) {

        for (WeatherType type : values()) {
            if (type.value == Integer.parseInt(value)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknow weather type code.");
    }
}
