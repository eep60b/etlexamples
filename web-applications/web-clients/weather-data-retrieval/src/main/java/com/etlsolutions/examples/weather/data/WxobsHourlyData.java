package com.etlsolutions.examples.weather.data;

/**
 * The WxobsHourlyData class represents a single poind of data for the UK hourly
 * site-specific observations.
 *
 * @author zc
 */
public final class WxobsHourlyData extends AbstractResponseData  {

    private final AbsolutePressure absolutePressure;
    private final PressureTendency pressureTendency;
    private final RealTemperature realTemprature;
    private final RealVisibility realVisibility;
    private final RelativeHumidity relativeHumidity;
    private final DewPoint dewPoint;
    private final WeatherType weatherType;
    private final WindDirection windDirection;
    private final WindGust windGust;
    private final WindSpeed windSpeed;

    public WxobsHourlyData(DateTime dateTime, AbsolutePressure absolutePressure, PressureTendency pressureTendency, RealTemperature realTemprature, RealVisibility realVisibility, RelativeHumidity relativeHumidity, DewPoint dewPoint, WeatherType weatherType, WindDirection windDirection, WindGust windGust, WindSpeed windSpeed) {
        super(dateTime);
        this.absolutePressure = absolutePressure;
        this.pressureTendency = pressureTendency;
        this.realTemprature = realTemprature;
        this.realVisibility = realVisibility;
        this.relativeHumidity = relativeHumidity;
        this.dewPoint = dewPoint;
        this.weatherType = weatherType;
        this.windDirection = windDirection;
        this.windGust = windGust;
        this.windSpeed = windSpeed;
    }

    @Override
    public Valuable[] getValuables() {
        return new Valuable[]{absolutePressure, pressureTendency, realTemprature, realVisibility, relativeHumidity, dewPoint, weatherType, windDirection, windGust, windSpeed};
    }
}
