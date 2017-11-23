package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.SettingConstants.DEFAULT_DATETIME_FORMAT;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * The WxobsHourlyData class represents a single poind of data for the UK hourly
 * site-specific observations.
 *
 * @author zc
 */
public final class WxobsHourlyData implements ResponseData {

    private final DateTime dateTime;
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
        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
        return dateFormat.format(dateTime.getDateTime()) + "," + absolutePressure.getValue() + "," + pressureTendency.getValue() + ","
                + realTemprature.getValue() + "," + realVisibility.getValue() + "," + relativeHumidity.getValue() + "," + dewPoint.getValue() + "," + weatherType.getCode() + ","
                + windDirection.getValue() + "," + windGust.getValue() + "," + windSpeed.getValue();
    }

    @Override
    public String getTitle(String additional) {
        return "DTime,Press,PTend,Tempt,Visblt,Humid,DePnt,WType,WdDct,WdGst,WdSpd".replace(",", additional + ",") + additional;
    }
}
