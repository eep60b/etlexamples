package com.etlsolutions.examples.weather.data;

/**
 * TheWxfcs3hourlyData class represents a single poind of data for the UK
 * 3-hourly site-specific forecast.
 *
 * @author zc
 */
public final class Wxfcs3hourlyData extends AbstractResponseData {
    
    private final FeelTemperature feelTemperature;
    private final PrecipitationProbability precipitationProbability;
    private final RealTemperature realTemprature;
    private final PredictedVisibility predictedVisibility;
    private final RelativeHumidity relativeHumidity;
    private final UvIndex uvIndex;
    private final WeatherType weatherType;
    private final WindDirection windDirection;
    private final WindGust windGust;
    private final WindSpeed windSpeed;

    public Wxfcs3hourlyData(DateTime dateTime, FeelTemperature feelTemperature, PrecipitationProbability precipitationProbability, RealTemperature realTemprature, PredictedVisibility predictedVisibility, RelativeHumidity relativeHumidity, UvIndex uvIndex, WeatherType weatherType, WindDirection windDirection, WindGust windGust, WindSpeed windSpeed) {
        super(dateTime);
        this.feelTemperature = feelTemperature;
        this.precipitationProbability = precipitationProbability;
        this.realTemprature = realTemprature;
        this.predictedVisibility = predictedVisibility;
        this.relativeHumidity = relativeHumidity;
        this.uvIndex = uvIndex;
        this.weatherType = weatherType;
        this.windDirection = windDirection;
        this.windGust = windGust;
        this.windSpeed = windSpeed;
    }

    @Override
    public Valuable[] getValuables() {
        return new Valuable[]{feelTemperature, precipitationProbability, realTemprature, predictedVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed};
    }
}
