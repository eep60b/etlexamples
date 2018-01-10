package com.etlsolutions.examples.weather.data;

import org.apache.log4j.Logger;

/**
 * The WeatherTyp enum defines all the weather types in data.
 *
 * @author zc
 */
public enum WeatherType implements Valuable {

    CLEAR_NIGHT(0, "clear night"),
    SUNNY_DAY(1, "sunny day"),
    PARTLY_CLOUDY_NIGHT(2, "partly cloudy night"),
    PARTLY_CLOUDY_DAY(3, "partly cloudy day"),
    NOT_USED(4, "not used"),
    MIST(5, "mist"),
    FOG(6, "fog"),
    CLOUDY(7, "cloudy"),
    OVERCAST(8, "overcast"),
    LIGHT_RAIN_SHOWER_NIGHT(9, "light rain shower night"),
    LIGHT_RAIN_SHOWER_DAY(10, "light rain shower day"),
    DRIZZLE(11, "drizzle"),
    LIGHT_RAIN(12, "light rain"),
    HEAVY_RAIN_SHOWER_NIGHT(13, "heavy rain shower night"),
    HEAVY_RAIN_SHOWER_DAY(14, "heavy rain shower day"),
    HEAVY_RAIN(15, "heavy rain"),
    SLEET_SHOWER_NIGHT(16, "sleet shower night"),
    SLEET_SHOWER_DAY(17, "sleet shower day"),
    SLEET(18, "sleet"),
    HAIL_SHOWER_NIGHT(19, "hail shower night"),
    HAIL_SHOWER_DAY(20, "hail shower day"),
    HAIL(21, "hail"),
    LIGHT_SNOW_SHOWER_NIGHT(22, "light snow night"),
    LIGHT_SNOW_SHOWER_DAY(23, "light snow night"),
    LIGHT_SNOW(24, "light snow"),
    HEAVY_SNOW_SHOWER_NIGHT(25, "heavy snow shower night"),
    HEAVY_SNOW_SHOWER_DAY(26, "heavy snow shower day"),
    HEAVY_SNOW(27, "heavy snow"),
    THUNDER_SHOWER_NIGHT(28, "thunder shower night"),
    THUNDER_SHOWER_DAY(29, "thunder shower day"),
    THUNDER(30, "thunder"),
    UNKOWN(-100, "unknown");

    public static final String SHORT_PARAMETER_NAME = "W";

    private final int value;
    private final String description;

    private WeatherType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static WeatherType getWeatherType(String value) {

        try {
            for (WeatherType type : values()) {
                if (type.value == Integer.parseInt(value)) {
                    return type;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(WeatherType.class).warn("Unknown weather type value: " + value, ex);
        }
        
        return UNKOWN;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "WeatherType: " + description;
    }

    @Override
    public String getShortName() {
        return "WType";
    }
}
