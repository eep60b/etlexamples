package com.etlsolutions.examples.weather.data;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.predictedVisibility);
        hash = 97 * hash + Objects.hashCode(this.uvIndex);
        hash = 97 * hash + Objects.hashCode(this.weatherType);
        hash = 97 * hash + Objects.hashCode(this.windSpeed);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Wxfcs3hourlyData other = (Wxfcs3hourlyData) obj;
        if (!Objects.equals(this.feelTemperature, other.feelTemperature)) {
            return false;
        }
        
        if (!Objects.equals(this.precipitationProbability, other.precipitationProbability)) {
            return false;
        }
        
        if (!Objects.equals(this.realTemprature, other.realTemprature)) {
            return false;
        }
        
        if (this.predictedVisibility != other.predictedVisibility) {
            return false;
        }
        
        if (!Objects.equals(this.relativeHumidity, other.relativeHumidity)) {
            return false;
        }
        
        if (!Objects.equals(this.uvIndex, other.uvIndex)) {
            return false;
        }
        
        if (this.weatherType != other.weatherType) {
            return false;
        }
        
        if (this.windDirection != other.windDirection) {
            return false;
        }
        
        if (!Objects.equals(this.windGust, other.windGust)) {
            return false;
        }
        
        if (!Objects.equals(this.windSpeed, other.windSpeed)) {
            return false;
        }
        
        return Objects.equals(this.dateTime, other.dateTime);
    }
}
