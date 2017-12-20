package com.etlsolutions.examples.weather.data;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.absolutePressure);
        hash = 79 * hash + Objects.hashCode(this.pressureTendency);
        hash = 79 * hash + Objects.hashCode(this.realTemprature);
        hash = 79 * hash + Objects.hashCode(this.realVisibility);
        hash = 79 * hash + Objects.hashCode(this.relativeHumidity);
        hash = 79 * hash + Objects.hashCode(this.dewPoint);
        hash = 79 * hash + Objects.hashCode(this.weatherType);
        hash = 79 * hash + Objects.hashCode(this.windDirection);
        hash = 79 * hash + Objects.hashCode(this.windGust);
        hash = 79 * hash + Objects.hashCode(this.windSpeed);
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
        
        final WxobsHourlyData other = (WxobsHourlyData) obj;
        if (!Objects.equals(this.absolutePressure, other.absolutePressure)) {
            return false;
        }
        
        if (this.pressureTendency != other.pressureTendency) {
            return false;
        }
        
        if (!Objects.equals(this.realTemprature, other.realTemprature)) {
            return false;
        }
        
        if (!Objects.equals(this.realVisibility, other.realVisibility)) {
            return false;
        }
        
        if (!Objects.equals(this.relativeHumidity, other.relativeHumidity)) {
            return false;
        }
        
        if (!Objects.equals(this.dewPoint, other.dewPoint)) {
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
