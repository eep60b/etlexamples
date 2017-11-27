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
import java.text.SimpleDateFormat;
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
        DateTime dateTime = new DateTime(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(cells[0]));
        FeelTemperature feelTemperature = new FeelTemperature(cells[1]);
        PrecipitationProbability precipitationProbability = new PrecipitationProbability(cells[2]);
        RealTemperature realTemprature = new RealTemperature(cells[3]);
        PredictedVisibility realVisibility = PredictedVisibility.getPredictedVisibility(Double.parseDouble(cells[4]));
        RelativeHumidity relativeHumidity = new RelativeHumidity(cells[5]);
        UvIndex uvIndex = new UvIndex(cells[6]);
        WeatherType weatherType = WeatherType.getWeatherType(cells[7]);
        WindDirection windDirection = WindDirection.getWindDirection(Integer.parseInt(cells[8]));
        WindGust windGust = new WindGust(cells[9]);
        WindSpeed windSpeed = new WindSpeed(cells[10]);

        return new Wxfcs3hourlyData(dateTime, feelTemperature, precipitationProbability, realTemprature, realVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed);
    }

    @Override
    public Wxfcs3hourlyData createData(NamedNodeMap repAttributes, DateTime dateTime) {

        Node fAttr = repAttributes.getNamedItem("F");
        FeelTemperature feelTemperature = new FeelTemperature(fAttr == null ? "-100" : fAttr.getTextContent());
        Node ppAttr = repAttributes.getNamedItem("Pp");
        PrecipitationProbability precipitationProbability = new PrecipitationProbability(ppAttr == null ? "-100" : ppAttr.getTextContent());
        Node tAttr = repAttributes.getNamedItem("T");
        RealTemperature realTemprature = new RealTemperature(tAttr == null ? "-100" : tAttr.getTextContent());
        Node vAttr = repAttributes.getNamedItem("V");
        PredictedVisibility realVisibility = vAttr == null ? PredictedVisibility.UNKOWN: PredictedVisibility.getPredictedVisibility(vAttr.getTextContent());
        Node hAttr = repAttributes.getNamedItem("H");
        RelativeHumidity relativeHumidity = new RelativeHumidity(hAttr == null ? "-100" : hAttr.getTextContent());
        UvIndex uvIndex = new UvIndex(repAttributes.getNamedItem("U").getTextContent());
        Node wAttr = repAttributes.getNamedItem("W");
        WeatherType weatherType = wAttr == null ? WeatherType.UNKOWN : WeatherType.getWeatherTypeByCode(wAttr.getTextContent());
        Node dAttr = repAttributes.getNamedItem("D");
        WindDirection windDirection = dAttr == null ? WindDirection.UNKOWN : WindDirection.getWindDirection(dAttr.getTextContent());
        Node sAttr = repAttributes.getNamedItem("S");
        WindSpeed windSpeed = new WindSpeed(sAttr == null ? "-100" : sAttr.getTextContent());
        Node windGustAttribute = repAttributes.getNamedItem("G");
        WindGust windGust = windGustAttribute == null ? new WindGust(windSpeed) : new WindGust(windGustAttribute.getTextContent());
        return new Wxfcs3hourlyData(dateTime, feelTemperature, precipitationProbability, realTemprature, realVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed);
    }
}
