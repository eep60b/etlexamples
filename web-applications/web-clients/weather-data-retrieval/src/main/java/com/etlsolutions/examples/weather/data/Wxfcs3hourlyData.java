package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class Wxfcs3hourlyData implements ResponseData {
    
    private final DateTime dateTime;
    private final RequestMethod forecastMethod = RequestMethod.FCS_3HOURLY;    
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
        this.dateTime = dateTime;
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
    public DateTime getDateTime() {
        return dateTime;
    }    
    
    
    @Override
    public String getOutputString() {
        return dateTime.getDateTime() + "," + feelTemperature.getValue() + "," + precipitationProbability.getValue() + ","
                + realTemprature.getValue() + "," + predictedVisibility.getMinValue()+ "," + relativeHumidity.getValue() + "," + uvIndex.getValue() + "," + weatherType.getCode() + ","
                        + windDirection.getValue() + "," + windGust.getSpeed() + "," + windSpeed.getSpeed();
    }
}
