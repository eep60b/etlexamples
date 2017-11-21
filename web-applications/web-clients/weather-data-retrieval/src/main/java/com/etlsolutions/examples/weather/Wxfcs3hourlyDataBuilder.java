package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.FeelTemperature;
import com.etlsolutions.examples.weather.data.Wxfcs3hourlyData;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.PrecipitationProbability;
import com.etlsolutions.examples.weather.data.RealTemperature;
import com.etlsolutions.examples.weather.data.PredictedVisibility;
import com.etlsolutions.examples.weather.data.RelativeHumidity;
import com.etlsolutions.examples.weather.data.ResponseData;
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
 * The Wxfcs3hourlyDataBuilder class builds the ForcastData objects.
 *
 * @author zc
 */
public final class Wxfcs3hourlyDataBuilder implements DataBuilder {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public final Wxfcs3hourlyData build(String inputLine) {

        String line = inputLine;

        if (line.isEmpty()) {
            return null;
        }

        String[] cells = line.split(",");

        DateTime dateTime = new DateTime(cells[0]);
        FeelTemperature feelTemperature = new FeelTemperature(cells[1]);
        PrecipitationProbability precipitationProbability = new PrecipitationProbability(cells[2]);
        RealTemperature realTemprature = new RealTemperature(cells[3]);
        PredictedVisibility realVisibility = PredictedVisibility.getPredictedVisibility(Integer.parseInt(cells[4]));
        RelativeHumidity relativeHumidity = new RelativeHumidity(cells[5]);
        UvIndex uvIndex = new UvIndex(cells[6]);
        WeatherType weatherType = WeatherType.getWeatherType(cells[7]);
        WindDirection windDirection = WindDirection.getWindDirection(Integer.parseInt(cells[8]));
        WindGust windGust = new WindGust(cells[9]);
        WindSpeed windSpeed = new WindSpeed(cells[10]);

        return new Wxfcs3hourlyData(dateTime, feelTemperature, precipitationProbability, realTemprature, realVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed);
    }

    @Override
    public final List<ResponseData> build(Document document, List<ResponseData> savedData, RequestMethod requestMethod) {

        List<ResponseData> oldList = new ArrayList<>(savedData);
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

                                        for (int n = oldList.size() - 1; n >= 0; n--) {
                                            ResponseData data = oldList.get(n);
                                            if (data.getDateTime().equals(dateTime)) {
                                                oldList.remove(n);
                                            }
                                        }
                                        NamedNodeMap repAttributes = repNode.getAttributes();
                                        FeelTemperature feelTemperature = new FeelTemperature(repAttributes.getNamedItem("F").getTextContent());
                                        PrecipitationProbability precipitationProbability = new PrecipitationProbability(repAttributes.getNamedItem("Pp").getTextContent());
                                        RealTemperature realTemprature = new RealTemperature(repAttributes.getNamedItem("T").getTextContent());
                                        PredictedVisibility realVisibility = PredictedVisibility.getPredictedVisibility(repAttributes.getNamedItem("V").getTextContent());
                                        RelativeHumidity relativeHumidity = new RelativeHumidity(repAttributes.getNamedItem("H").getTextContent());
                                        UvIndex uvIndex = new UvIndex(repAttributes.getNamedItem("U").getTextContent());
                                        WeatherType weatherType = WeatherType.getWeatherType(repAttributes.getNamedItem("W").getTextContent());
                                        WindDirection windDirection = WindDirection.getWindDirection(repAttributes.getNamedItem("D").getTextContent());
                                        WindGust windGust = new WindGust(repAttributes.getNamedItem("G").getTextContent());
                                        WindSpeed windSpeed = new WindSpeed(repAttributes.getNamedItem("S").getTextContent());
                                        Wxfcs3hourlyData data = new Wxfcs3hourlyData(dateTime, feelTemperature, precipitationProbability, realTemprature, realVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed);

                                        oldList.add(data);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return oldList;
    }
}
