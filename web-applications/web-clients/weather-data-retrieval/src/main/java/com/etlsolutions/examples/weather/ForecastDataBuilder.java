package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.FeelTemperature;
import com.etlsolutions.examples.weather.data.ForecastData;
import com.etlsolutions.examples.weather.data.ForecastMethod;
import com.etlsolutions.examples.weather.data.PrecipitationProbability;
import com.etlsolutions.examples.weather.data.RealTemperature;
import com.etlsolutions.examples.weather.data.RealVisibility;
import com.etlsolutions.examples.weather.data.RelativeHumidity;
import com.etlsolutions.examples.weather.data.UvIndex;
import com.etlsolutions.examples.weather.data.WeatherType;
import com.etlsolutions.examples.weather.data.WindDirection;
import com.etlsolutions.examples.weather.data.WindGust;
import com.etlsolutions.examples.weather.data.WindSpeed;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author zc
 */
public final class ForecastDataBuilder {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static final ForecastData build(String inputLine) {

        String line = inputLine;

        if (line.isEmpty()) {
            return null;
        }

        while (line.contains("  ")) {
            line.replace("  ", " ");
        }

        String[] cells = line.split(" ");

        DateTime dateTime = new DateTime(cells[0], cells[1]);
        ForecastMethod forecastMethod = ForecastMethod.getForecastMethod(cells[2]);
        FeelTemperature feelTemperature = new FeelTemperature(cells[3]);
        PrecipitationProbability precipitationProbability = new PrecipitationProbability(cells[4]);
        RealTemperature realTemprature = new RealTemperature(cells[5]);
        RealVisibility realVisibility = RealVisibility.getRealVisibility(cells[6]);
        RelativeHumidity relativeHumidity = new RelativeHumidity(cells[7]);
        UvIndex uvIndex = UvIndex.getUvIndex(cells[8]);
        WeatherType weatherType = WeatherType.getWeatherType(cells[9]);
        WindDirection windDirection = WindDirection.getWindDirection(cells[10]);
        WindGust windGust = new WindGust(cells[11]);
        WindSpeed windSpeed = new WindSpeed(cells[12]);

        return new ForecastData(dateTime, forecastMethod, feelTemperature, precipitationProbability, realTemprature, realVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed);
    }

    public static final List<ForecastData> build(Document document, List<ForecastData> list, String forecastMethodString) {

        List<ForecastData> newList = new ArrayList<>(list);        
        NodeList documentChildren = document.getChildNodes();
        
        for (int i = 0; i < documentChildren.getLength(); i++) {

            Node documentChild = documentChildren.item(i);
            if (documentChild.getNodeName().equals("SiteRep")) {

                NodeList siteRepChildren = documentChild.getChildNodes();

                for (int j = 0; j < siteRepChildren.getLength(); j++) {

                    Node siteRepChild = siteRepChildren.item(j);

                    if (siteRepChild.getNodeName().equals("DV")) {

                        NodeList dvChildren = siteRepChild.getChildNodes();

                        for (int k = 0; k < dvChildren.getLength(); k++) {

                            Node dvChild = dvChildren.item(k);
                            if (dvChild.getNodeName().equals("Location")) {

                                NodeList locationChildren = dvChild.getChildNodes();

                                for (int l = 0; l < locationChildren.getLength(); l++) {

                                    Node periodNode = locationChildren.item(l);                                    
                                    NamedNodeMap periodAttributes = periodNode.getAttributes();
                                    String date = periodAttributes.getNamedItem("value").getTextContent();                                   
                                    NodeList periodChildren = periodNode.getChildNodes();

                                    for (int m = 0; m < periodChildren.getLength(); m++) {

                                        Node repNode = periodChildren.item(m);
                                        String timeString = repNode.getTextContent();
                                        
                                        DateTime dateTime = new DateTime(date, timeString);
                                        
                                        NamedNodeMap repAttributes = repNode.getAttributes();
                                        ForecastMethod forecastMethod = ForecastMethod.getForecastMethod(forecastMethodString);
                                        FeelTemperature feelTemperature = new FeelTemperature(repAttributes.getNamedItem("F").getTextContent());
                                        PrecipitationProbability precipitationProbability = new PrecipitationProbability(repAttributes.getNamedItem("Pp").getTextContent());
                                        RealTemperature realTemprature = new RealTemperature(repAttributes.getNamedItem("T").getTextContent());
                                        RealVisibility realVisibility = RealVisibility.getRealVisibility(repAttributes.getNamedItem("V").getTextContent());
                                        RelativeHumidity relativeHumidity = new RelativeHumidity(repAttributes.getNamedItem("H").getTextContent());
                                        UvIndex uvIndex = UvIndex.getUvIndex(repAttributes.getNamedItem("U").getTextContent());
                                        WeatherType weatherType = WeatherType.getWeatherType(repAttributes.getNamedItem("W").getTextContent());
                                        WindDirection windDirection = WindDirection.getWindDirection(repAttributes.getNamedItem("D").getTextContent());
                                        WindGust windGust = new WindGust(repAttributes.getNamedItem("G").getTextContent());
                                        WindSpeed windSpeed = new WindSpeed(repAttributes.getNamedItem("S").getTextContent());

                                        for (int n = newList.size() - 1; n > 0; n--) {
                                            ForecastData data = newList.get(n);
                                            if (data.getDateTime().equals(dateTime)) {
                                                newList.remove(n);
                                                newList.add(n, new ForecastData(dateTime, forecastMethod, feelTemperature, precipitationProbability, realTemprature, realVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return newList;
    }
}
