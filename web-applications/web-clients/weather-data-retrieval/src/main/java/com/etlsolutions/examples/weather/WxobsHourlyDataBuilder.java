package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.AbsolutePressure;
import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.DewPoint;
import com.etlsolutions.examples.weather.data.PressureTendency;
import com.etlsolutions.examples.weather.data.RealTemperature;
import com.etlsolutions.examples.weather.data.RealVisibility;
import com.etlsolutions.examples.weather.data.RelativeHumidity;
import com.etlsolutions.examples.weather.data.WeatherType;
import com.etlsolutions.examples.weather.data.WindDirection;
import com.etlsolutions.examples.weather.data.WindGust;
import com.etlsolutions.examples.weather.data.WindSpeed;
import com.etlsolutions.examples.weather.data.WxobsHourlyData;
import java.text.ParseException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 *
 * @author zc
 */
public final class WxobsHourlyDataBuilder extends ResponseDataBuilder {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public final WxobsHourlyData build(String inputLine, ApplicationParameters parameters) throws ParseException {

        String line = inputLine;

        if (line.isEmpty()) {
            return null;
        }

        String[] cells = line.split(parameters.getDelimiter());
        DateTime dateTime = new DateTime(parameters.getDatetimeFormat().parse(cells[0]));
        AbsolutePressure absolutePressure = new AbsolutePressure(cells[1]);
        PressureTendency pressureTendency = PressureTendency.getPressureTendencyByValue(cells[2]);
        RealTemperature realTemprature = new RealTemperature(cells[3]);
        RealVisibility realVisibility = new RealVisibility(cells[4]);
        RelativeHumidity relativeHumidity = new RelativeHumidity(cells[5]);
        DewPoint dewPoint = new DewPoint(cells[6]);
        WeatherType weatherType = WeatherType.getWeatherType(cells[7]);
        WindDirection windDirection = WindDirection.getWindDirection(Integer.parseInt(cells[8]));
        WindGust windGust = new WindGust(cells[9]);
        WindSpeed windSpeed = new WindSpeed(cells[10]);

        return new WxobsHourlyData(dateTime, absolutePressure, pressureTendency, realTemprature, realVisibility, relativeHumidity, dewPoint, weatherType, windDirection, windGust, windSpeed);
    }

    @Override
    public WxobsHourlyData createData(NamedNodeMap repAttributes, DateTime dateTime) {
        
        Node pAttr = repAttributes.getNamedItem("P");
        AbsolutePressure absolutePressure = new AbsolutePressure(pAttr == null ? "-100" : pAttr.getTextContent());
        Node ptAttr = repAttributes.getNamedItem("Pt");
        PressureTendency pressureTendency = ptAttr == null ? PressureTendency.UNKOWN : PressureTendency.getPressureTendency(ptAttr.getTextContent());
        Node tAttr = repAttributes.getNamedItem("T");
        RealTemperature realTemprature = new RealTemperature(tAttr == null ? "-100" : tAttr.getTextContent());
        Node vAttr = repAttributes.getNamedItem("V");
        RealVisibility realVisibility = new RealVisibility(vAttr == null ? "-100" : vAttr.getTextContent());
        Node hAttr = repAttributes.getNamedItem("H");
        RelativeHumidity relativeHumidity = new RelativeHumidity(hAttr == null ? "-100" : hAttr.getTextContent());
        Node dpAttr = repAttributes.getNamedItem("Dp");
        DewPoint dewPoint = new DewPoint(dpAttr == null ? "-100" : dpAttr.getTextContent());
        Node wAttr = repAttributes.getNamedItem("W");
        WeatherType weatherType = wAttr == null ? WeatherType.UNKOWN : WeatherType.getWeatherTypeByCode(wAttr.getTextContent());
        Node dAttr = repAttributes.getNamedItem("D");
        WindDirection windDirection = dAttr == null ? WindDirection.UNKOWN : WindDirection.getWindDirection(dAttr.getTextContent());
        Node sAttr = repAttributes.getNamedItem("S");
        WindSpeed windSpeed = new WindSpeed(sAttr == null ? "-100" : sAttr.getTextContent());
        Node windGustAttribute = repAttributes.getNamedItem("G");
        WindGust windGust = windGustAttribute == null ? new WindGust(windSpeed) : new WindGust(windGustAttribute.getTextContent());
        
        return new WxobsHourlyData(dateTime, absolutePressure, pressureTendency, realTemprature, realVisibility, relativeHumidity, dewPoint, weatherType, windDirection, windGust, windSpeed);
    }
}
