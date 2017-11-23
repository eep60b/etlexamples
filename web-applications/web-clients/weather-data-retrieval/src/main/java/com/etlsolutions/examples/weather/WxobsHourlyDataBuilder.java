package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.DEFAULT_DATETIME_FORMAT;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public final WxobsHourlyData build(String inputLine) throws ParseException {

        String line = inputLine;

        if (line.isEmpty()) {
            return null;
        }

        String[] cells = line.split(",");

        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
        DateTime dateTime = new DateTime(dateFormat.parse(cells[0]));
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
                                        WeatherType weatherType = wAttr == null ? WeatherType.UNKOWN : WeatherType.getWeatherType(wAttr.getTextContent());
                                        Node dAttr = repAttributes.getNamedItem("D");
                                        WindDirection windDirection = dAttr == null ? WindDirection.UNKOWN : WindDirection.getWindDirection(dAttr.getTextContent());
                                        Node sAttr = repAttributes.getNamedItem("S");
                                        WindSpeed windSpeed = new WindSpeed(sAttr == null ? "-100" : sAttr.getTextContent());
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
