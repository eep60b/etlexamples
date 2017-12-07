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
        int index = 0;
        DateTime dateTime = new DateTime(parameters.getDatetimeFormat().parse(cells[index++]));
        AbsolutePressure absolutePressure = new AbsolutePressure(cells[index++]);
        PressureTendency pressureTendency = PressureTendency.getPressureTendencyByValue(cells[index++]);
        RealTemperature realTemprature = new RealTemperature(cells[index++]);
        RealVisibility realVisibility = new RealVisibility(cells[index++]);
        RelativeHumidity relativeHumidity = new RelativeHumidity(cells[index++]);
        DewPoint dewPoint = new DewPoint(cells[index++]);
        WeatherType weatherType = WeatherType.getWeatherType(cells[index++]);
        WindDirection windDirection = WindDirection.getWindDirection(Integer.parseInt(cells[index++]));
        WindGust windGust = new WindGust(cells[index++]);
        WindSpeed windSpeed = new WindSpeed(cells[index++]);

        return new WxobsHourlyData(dateTime, absolutePressure, pressureTendency, realTemprature, realVisibility, relativeHumidity, dewPoint, weatherType, windDirection, windGust, windSpeed);
    }

    @Override
    public WxobsHourlyData createData(NamedNodeMap repAttributes, DateTime dateTime) {

        Node pAttr = repAttributes.getNamedItem(AbsolutePressure.SHORT_PARAMETER_NAME);
        AbsolutePressure absolutePressure = new AbsolutePressure(pAttr == null ? AbsolutePressure.UNKNOW_VALUE : pAttr.getTextContent());
        Node ptAttr = repAttributes.getNamedItem(PressureTendency.SHORT_PARAMETER_NAME);
        PressureTendency pressureTendency = ptAttr == null ? PressureTendency.UNKOWN : PressureTendency.getPressureTendency(ptAttr.getTextContent());
        Node tAttr = repAttributes.getNamedItem(RealTemperature.SHORT_PARAMETER_NAME);
        RealTemperature realTemprature = new RealTemperature(tAttr == null ? RealTemperature.UNKNOW_VALUE : tAttr.getTextContent());
        Node vAttr = repAttributes.getNamedItem(RealVisibility.SHORT_PARAMETER_NAME);
        RealVisibility realVisibility = new RealVisibility(vAttr == null ? RealVisibility.UNKNOW_VALUE : vAttr.getTextContent());
        Node hAttr = repAttributes.getNamedItem(RelativeHumidity.SHORT_PARAMETER_NAME);
        RelativeHumidity relativeHumidity = new RelativeHumidity(hAttr == null ? RelativeHumidity.UNKNOW_VALUE : hAttr.getTextContent());
        Node dpAttr = repAttributes.getNamedItem(DewPoint.SHORT_PARAMETER_NAME);
        DewPoint dewPoint = new DewPoint(dpAttr == null ? DewPoint.UNKNOW_VALUE : dpAttr.getTextContent());
        Node wAttr = repAttributes.getNamedItem(WeatherType.SHORT_PARAMETER_NAME);
        WeatherType weatherType = wAttr == null ? WeatherType.UNKOWN : WeatherType.getWeatherTypeByCode(wAttr.getTextContent());
        Node dAttr = repAttributes.getNamedItem(WindDirection.SHORT_PARAMETER_NAME);
        WindDirection windDirection = dAttr == null ? WindDirection.UNKOWN : WindDirection.getWindDirection(dAttr.getTextContent());
        Node sAttr = repAttributes.getNamedItem(WindSpeed.SHORT_PARAMETER_NAME);
        WindSpeed windSpeed = new WindSpeed(sAttr == null ? WindSpeed.UNKNOW_VALUE : sAttr.getTextContent());
        Node windGustAttribute = repAttributes.getNamedItem(WindGust.SHORT_PARAMETER_NAME);
        WindGust windGust = windGustAttribute == null ? new WindGust(windSpeed) : new WindGust(windGustAttribute.getTextContent());

        return new WxobsHourlyData(dateTime, absolutePressure, pressureTendency, realTemprature, realVisibility, relativeHumidity, dewPoint, weatherType, windDirection, windGust, windSpeed);
    }
}
