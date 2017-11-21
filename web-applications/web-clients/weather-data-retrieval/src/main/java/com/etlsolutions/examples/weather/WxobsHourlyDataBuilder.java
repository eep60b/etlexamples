package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.AbsolutePressure;
import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.DewPoint;
import com.etlsolutions.examples.weather.data.PressureTendency;
import com.etlsolutions.examples.weather.data.RealTemperature;
import com.etlsolutions.examples.weather.data.RealVisibility;
import com.etlsolutions.examples.weather.data.RelativeHumidity;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.ResponseData;
import com.etlsolutions.examples.weather.data.WeatherType;
import com.etlsolutions.examples.weather.data.WindDirection;
import com.etlsolutions.examples.weather.data.WindGust;
import com.etlsolutions.examples.weather.data.WindSpeed;
import com.etlsolutions.examples.weather.data.WxobsHourlyData;
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
public final class WxobsHourlyDataBuilder implements DataBuilder {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public final WxobsHourlyData build(String inputLine) {

        String line = inputLine;

        if (line.isEmpty()) {
            return null;
        }

        String[] cells = line.split(",");

        DateTime dateTime = new DateTime(cells[0]);
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
                                        AbsolutePressure absolutePressure = new AbsolutePressure(repAttributes.getNamedItem("P").getTextContent());
                                        PressureTendency pressureTendency = PressureTendency.getPressureTendency(repAttributes.getNamedItem("Pt").getTextContent());
                                        RealTemperature realTemprature = new RealTemperature(repAttributes.getNamedItem("T").getTextContent());
                                        RealVisibility realVisibility = new RealVisibility(repAttributes.getNamedItem("V").getTextContent());
                                        RelativeHumidity relativeHumidity = new RelativeHumidity(repAttributes.getNamedItem("H").getTextContent());
                                        DewPoint dewPoint = new DewPoint(repAttributes.getNamedItem("Dp").getTextContent());
                                        WeatherType weatherType = WeatherType.getWeatherType(repAttributes.getNamedItem("W").getTextContent());
                                        WindDirection windDirection = WindDirection.getWindDirection(repAttributes.getNamedItem("D").getTextContent());
                                        WindSpeed windSpeed = new WindSpeed(repAttributes.getNamedItem("S").getTextContent());
                                        Node windGustAttribute = repAttributes.getNamedItem("G");
                                        WindGust windGust = windGustAttribute == null ? new WindGust(windSpeed) : new WindGust(windGustAttribute.getTextContent());
                                        WxobsHourlyData data = new WxobsHourlyData(dateTime, absolutePressure, pressureTendency, realTemprature, realVisibility, relativeHumidity, dewPoint, weatherType, windDirection, windGust, windSpeed);

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
