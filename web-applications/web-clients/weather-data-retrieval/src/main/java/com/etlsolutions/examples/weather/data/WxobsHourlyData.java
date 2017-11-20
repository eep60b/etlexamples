package com.etlsolutions.examples.weather.data;

/**
 *
 * @author zc
 */
public final class WxobsHourlyData implements ResponseData {
    
    private final DateTime dateTime;
    private final RequestMethod forecastMethod = RequestMethod.OBS_HOURLY;    
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
        this.dateTime = dateTime;
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
    public DateTime getDateTime() {
        return dateTime;
    }    
    
    
    @Override
    public String getOutputString() {
        return dateTime.getDateTime() + "," + forecastMethod.getMethodToken() + "," + forecastMethod.getInterval() + "," + absolutePressure.getValue() + "," + pressureTendency.getValue() + ","
                + realTemprature.getValue() + "," + realVisibility.getValue()+ "," + relativeHumidity.getValue() + "," + dewPoint.getValue() + "," + weatherType.getValue() + ","
                        + windDirection.getValue() + "," + windGust.getSpeed() + "," + windSpeed.getSpeed();
    }
    
}
