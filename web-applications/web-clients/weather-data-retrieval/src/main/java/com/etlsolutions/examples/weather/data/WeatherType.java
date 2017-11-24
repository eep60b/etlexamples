package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public enum WeatherType implements Valuable {

    CLEAR_NIGHT(0, 0, "clear night"),
    SUNNY_DAY(1, 0, "sunny day"),
    PARTLY_CLOUDY_NIGHT(2, 10, "partly cloudy night"),
    PARTLY_CLOUDY_DAY(3, 10, "partly cloudy day"),
    NOT_USED(4, -1, "not used"),
    MIST(5, 40, "mist"),
    FOG(6, 50, "fog"),
    CLOUDY(7, 20, "cloudy"),
    OVERCAST(8, 30, "overcast"),
    LIGHT_RAIN_SHOWER_NIGHT(9, 80, "light rain shower night"),
    LIGHT_RAIN_SHOWER_DAY(10, 80, "light rain shower day"),
    DRIZZLE(11, 70, "drizzle"),
    LIGHT_RAIN(12, 80, "light rain"),
    HEAVY_RAIN_SHOWER_NIGHT(13, 100, "heavy rain shower night"),
    HEAVY_RAIN_SHOWER_DAY(14, 100, "heavy rain shower day"),
    HEAVY_RAIN(15, 90, "heavy rain"),
    SLEET_SHOWER_NIGHT(16, 90, "sleet shower night"),
    SLEET_SHOWER_DAY(17, 90, "sleet shower day"),
    SLEET(18, 80, "sleet"),
    HAIL_SHOWER_NIGHT(19, 90, "hail shower night"),
    HAIL_SHOWER_DAY(20, 90, "hail shower day"),
    HAIL(21, 80, "hail"),
    LIGHT_SNOW_SHOWER_NIGHT(22, 80, "light snow night"),
    LIGHT_SNOW_SHOWER_DAY(23, 80, "light snow night"),
    LIGHT_SNOW(24, 80, "light snow"),
    HEAVY_SNOW_SHOWER_NIGHT(25, 100, "heavy snow shower night"),
    HEAVY_SNOW_SHOWER_DAY(26, 100, "heavy snow shower day"),
    HEAVY_SNOW(27, 100, "heavy snow"),
    THUNDER_SHOWER_NIGHT(28, 100, "thunder shower night"),
    THUNDER_SHOWER_DAY(29, 100, "thunder shower day"),
    THUNDER(30, 100, "thunder"),
    UNKOWN(-100, -100, "unknown");

    private final int code;
    private final int value;
    private final String description;

    private WeatherType(int code, int value, String description) {
        this.code = code;
        this.value = value;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public static WeatherType getWeatherType(String value) {

        for (WeatherType type : values()) {
            if (type.value == Integer.parseInt(value)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknow weather type code: " + value);
    }


    public static WeatherType getWeatherTypeByCode(String code) {

        for (WeatherType type : values()) {
            if (type.code == Integer.parseInt(code)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknow weather type code: " + code);
    }    
    
    @Override
    public Integer getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return description ;
    }

    @Override
    public String getShortName() {
        return "WType";
    }
}
