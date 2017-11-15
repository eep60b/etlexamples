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
 * The ForecastDataBuilder class builds the ForcastData objects.
 *
 * @author zc
 */
public final class ForecastDataBuilder {

    
    
    
    
    /**
     * Build a ForecastData object from the given string which is usually a line
     * in a text file.
     *
     * @param inputLine - The string.
     * @return the ForecastData object. This object will be valid in anycase.
     * Otherwise an exception will be thrown.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static final ForecastData build(String inputLine) {

        String line = inputLine;

        if (line.isEmpty()) {
            return null;
        }

        String[] cells = line.split(",");

        DateTime dateTime = new DateTime(cells[0]);
        ForecastMethod forecastMethod = ForecastMethod.getForecastMethod(cells[1]);
        FeelTemperature feelTemperature = new FeelTemperature(cells[2]);
        PrecipitationProbability precipitationProbability = new PrecipitationProbability(cells[3]);
        RealTemperature realTemprature = new RealTemperature(cells[4]);
        RealVisibility realVisibility = RealVisibility.getRealVisibility(Integer.parseInt(cells[5]));
        RelativeHumidity relativeHumidity = new RelativeHumidity(cells[6]);
        UvIndex uvIndex = new UvIndex(cells[7]);
        WeatherType weatherType = WeatherType.getWeatherType(cells[8]);
        WindDirection windDirection = WindDirection.getWindDirection(Integer.parseInt(cells[9]));
        WindGust windGust = new WindGust(cells[10]);
        WindSpeed windSpeed = new WindSpeed(cells[11]);

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

                                        for (int n = newList.size() - 1; n >= 0; n--) {
                                            ForecastData data = newList.get(n);
                                            if (data.getDateTime().equals(dateTime)) {
                                                newList.remove(n);
                                            }
                                        }
                                        NamedNodeMap repAttributes = repNode.getAttributes();
                                        ForecastMethod forecastMethod = ForecastMethod.getForecastMethod(forecastMethodString);
                                        FeelTemperature feelTemperature = new FeelTemperature(repAttributes.getNamedItem("F").getTextContent());
                                        PrecipitationProbability precipitationProbability = new PrecipitationProbability(repAttributes.getNamedItem("Pp").getTextContent());
                                        RealTemperature realTemprature = new RealTemperature(repAttributes.getNamedItem("T").getTextContent());
                                        RealVisibility realVisibility = RealVisibility.getRealVisibility(repAttributes.getNamedItem("V").getTextContent());
                                        RelativeHumidity relativeHumidity = new RelativeHumidity(repAttributes.getNamedItem("H").getTextContent());
                                        UvIndex uvIndex = new UvIndex(repAttributes.getNamedItem("U").getTextContent());
                                        WeatherType weatherType = WeatherType.getWeatherType(repAttributes.getNamedItem("W").getTextContent());
                                        WindDirection windDirection = WindDirection.getWindDirection(repAttributes.getNamedItem("D").getTextContent());
                                        WindGust windGust = new WindGust(repAttributes.getNamedItem("G").getTextContent());
                                        WindSpeed windSpeed = new WindSpeed(repAttributes.getNamedItem("S").getTextContent());
                                        ForecastData f = new ForecastData(dateTime, forecastMethod, feelTemperature, precipitationProbability, realTemprature, realVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed);

                                        newList.add(f);

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
