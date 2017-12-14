package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.FeelTemperature;
import com.etlsolutions.examples.weather.data.Wxfcs3hourlyData;
import com.etlsolutions.examples.weather.data.PrecipitationProbability;
import com.etlsolutions.examples.weather.data.RealTemperature;
import com.etlsolutions.examples.weather.data.PredictedVisibility;
import com.etlsolutions.examples.weather.data.RelativeHumidity;
import com.etlsolutions.examples.weather.data.UvIndex;
import com.etlsolutions.examples.weather.data.WeatherType;
import com.etlsolutions.examples.weather.data.WindDirection;
import com.etlsolutions.examples.weather.data.WindGust;
import com.etlsolutions.examples.weather.data.WindSpeed;
import java.text.ParseException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * The Wxfcs3hourlyDataBuilder class builds the ForcastData objects.
 *
 * @author zc
 */
public final class Wxfcs3hourlyDataBuilder extends ResponseDataBuilder {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public final Wxfcs3hourlyData build(String line, ApplicationParameters parameters) throws ParseException {

        if (line.isEmpty()) {
            return null;
        }

        String[] cells = line.split(parameters.getDelimiter());
        int index = 0;
        DateTime dateTime = new DateTime(parameters.getDatetimeFormat().parse(cells[index++]));
        FeelTemperature feelTemperature = new FeelTemperature(cells[index++]);
        PrecipitationProbability precipitationProbability = new PrecipitationProbability(cells[index++]);
        RealTemperature realTemprature = new RealTemperature(cells[index++]);
        PredictedVisibility realVisibility = PredictedVisibility.getPredictedVisibility(Double.parseDouble(cells[index++]));
        RelativeHumidity relativeHumidity = new RelativeHumidity(cells[index++]);
        UvIndex uvIndex = new UvIndex(cells[index++]);
        WeatherType weatherType = WeatherType.getWeatherType(cells[index++]);
        WindDirection windDirection = WindDirection.getWindDirection(Integer.parseInt(cells[index++]));
        WindGust windGust = new WindGust(cells[index++]);
        WindSpeed windSpeed = new WindSpeed(cells[index]);

        return new Wxfcs3hourlyData(dateTime, feelTemperature, precipitationProbability, realTemprature, realVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed);
    }

    @Override
    public Wxfcs3hourlyData createData(NamedNodeMap repAttributes, DateTime dateTime) {

        Node fAttr = repAttributes.getNamedItem(FeelTemperature.SHORT_PARAMETER_NAME);
        FeelTemperature feelTemperature = new FeelTemperature(fAttr == null ? FeelTemperature.UNKNOW_VALUE : fAttr.getTextContent());
        Node ppAttr = repAttributes.getNamedItem(PrecipitationProbability.SHORT_PARAMETER_NAME);
        PrecipitationProbability precipitationProbability = new PrecipitationProbability(ppAttr == null ? PrecipitationProbability.UNKNOW_VALUE : ppAttr.getTextContent());
        Node tAttr = repAttributes.getNamedItem(RealTemperature.SHORT_PARAMETER_NAME);
        RealTemperature realTemprature = new RealTemperature(tAttr == null ? RealTemperature.UNKNOW_VALUE : tAttr.getTextContent());
        Node vAttr = repAttributes.getNamedItem(PredictedVisibility.SHORT_PARAMETER_NAME);
        PredictedVisibility realVisibility = vAttr == null ? PredictedVisibility.UNKOWN: PredictedVisibility.getPredictedVisibility(vAttr.getTextContent());
        Node hAttr = repAttributes.getNamedItem(RelativeHumidity.SHORT_PARAMETER_NAME);
        RelativeHumidity relativeHumidity = new RelativeHumidity(hAttr == null ? RelativeHumidity.UNKNOW_VALUE : hAttr.getTextContent());
        Node uAttr = repAttributes.getNamedItem(UvIndex.SHORT_PARAMETER_NAME);
        UvIndex uvIndex = new UvIndex(uAttr == null ? UvIndex.UNKNOW_VALUE : uAttr.getTextContent());
        Node wAttr = repAttributes.getNamedItem(WeatherType.SHORT_PARAMETER_NAME);
        WeatherType weatherType = wAttr == null ? WeatherType.UNKOWN : WeatherType.getWeatherTypeByCode(wAttr.getTextContent());
        Node dAttr = repAttributes.getNamedItem(WindDirection.SHORT_PARAMETER_NAME);
        WindDirection windDirection = dAttr == null ? WindDirection.UNKOWN : WindDirection.getWindDirection(dAttr.getTextContent());
        Node sAttr = repAttributes.getNamedItem(WindSpeed.SHORT_PARAMETER_NAME);
        WindSpeed windSpeed = new WindSpeed(sAttr == null ? WindSpeed.UNKNOW_VALUE : sAttr.getTextContent());
        Node windGustAttribute = repAttributes.getNamedItem(WindGust.SHORT_PARAMETER_NAME);
        WindGust windGust = windGustAttribute == null ? new WindGust(windSpeed) : new WindGust(windGustAttribute.getTextContent());
        return new Wxfcs3hourlyData(dateTime, feelTemperature, precipitationProbability, realTemprature, realVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed);
    }
}
