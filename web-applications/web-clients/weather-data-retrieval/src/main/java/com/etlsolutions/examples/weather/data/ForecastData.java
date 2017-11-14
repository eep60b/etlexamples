package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class ForecastData {
    
    private final DateTime dateTime;
    private final ForecastMethod forecastMethod;    
    private final FeelTemperature feelTemperature;
    private final PrecipitationProbability precipitationProbability;
    private final RealTemperature realTemprature;
    private final RealVisibility realVisibility;
    private final RelativeHumidity relativeHumidity;
    private final UvIndex uvIndex;
    private final WeatherType weatherType;
    private final WindDirection windDirection;
    private final WindGust windGust;
    private final WindSpeed windSpeed;

    public ForecastData(DateTime dateTime, ForecastMethod forecastMethod, FeelTemperature feelTemperature, PrecipitationProbability precipitationProbability, RealTemperature realTemprature, RealVisibility realVisibility, RelativeHumidity relativeHumidity, UvIndex uvIndex, WeatherType weatherType, WindDirection windDirection, WindGust windGust, WindSpeed windSpeed) {
        this.dateTime = dateTime;
        this.feelTemperature = feelTemperature;
        this.forecastMethod = forecastMethod;
        this.precipitationProbability = precipitationProbability;
        this.realTemprature = realTemprature;
        this.realVisibility = realVisibility;
        this.relativeHumidity = relativeHumidity;
        this.uvIndex = uvIndex;
        this.weatherType = weatherType;
        this.windDirection = windDirection;
        this.windGust = windGust;
        this.windSpeed = windSpeed;
    }

    public DateTime getDateTime() {
        return dateTime;
    }    
    
    
    public String getOutputString() {
        return dateTime.getDateTime() + "," + forecastMethod.getValue() + "," + feelTemperature.getValue() + "," + precipitationProbability.getValue() + ","
                + realTemprature.getValue() + "," + realVisibility.getValue()+ "," + relativeHumidity.getValue() + "," + uvIndex.getValue() + "," + weatherType.getValue() + ","
                        + windDirection.getValue() + "," + windGust.getSpeed() + "," + windSpeed.getSpeed();
    }
}
