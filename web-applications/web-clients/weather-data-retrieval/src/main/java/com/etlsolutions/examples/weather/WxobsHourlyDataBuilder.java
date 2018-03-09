package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.AbsolutePressure;
import com.etlsolutions.examples.weather.data.ResponseData;
import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.DewPoint;
import com.etlsolutions.examples.weather.data.PressureTendency;
import com.etlsolutions.examples.weather.data.RealTemperature;
import com.etlsolutions.examples.weather.data.RealVisibility;
import com.etlsolutions.examples.weather.data.RelativeHumidity;
import com.etlsolutions.examples.weather.data.Valuable;
import com.etlsolutions.examples.weather.data.WeatherType;
import com.etlsolutions.examples.weather.data.WindDirection;
import com.etlsolutions.examples.weather.data.WindGust;
import com.etlsolutions.examples.weather.data.WindSpeed;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * The WxobsHourlyDataBuilder class
 * @author zc
 */
public final class WxobsHourlyDataBuilder extends ResponseDataBuilder {

    @Override
    public final ResponseData build(String inputLine, ApplicationParameters parameters) throws ParseException {

        List<Valuable> valuables = new ArrayList<>();            
        String line = inputLine;

        if (line == null || line.isEmpty()) {
            return null;
        }

        String[] cells = line.split(parameters.getDelimiter());
        int index = 0;
        DateTime dateTime = DateTime.getInstance(parameters.getDatetimeFormat().parse(cells[index++]));
        valuables.add(AbsolutePressure.getInstance(cells[index++]));
        valuables.add(PressureTendency.getPressureTendencyByValue(cells[index++]));
        valuables.add(RealTemperature.getInstance(cells[index++]));
        valuables.add(RealVisibility.getInstance(cells[index++]));
        valuables.add(RelativeHumidity.getInstance(cells[index++]));
        valuables.add(DewPoint.getInstance(cells[index++]));
        valuables.add(WeatherType.getWeatherType(cells[index++]));
        valuables.add(WindDirection.getWindDirection(Integer.parseInt(cells[index++])));
        valuables.add(WindSpeed.getInstance(cells[index++]));
        valuables.add(WindGust.getInstance(cells[index++]));

        return new ResponseData(dateTime, valuables);
    }

    @Override
    public ResponseData createData(NamedNodeMap repAttributes, DateTime dateTime) {

        List<Valuable> valuables = new ArrayList<>();         
        Node pAttr = repAttributes.getNamedItem(AbsolutePressure.SHORT_PARAMETER_NAME);
        valuables.add(AbsolutePressure.getInstance(pAttr == null ? AbsolutePressure.UNKNOW_VALUE : pAttr.getTextContent()));
        Node ptAttr = repAttributes.getNamedItem(PressureTendency.SHORT_PARAMETER_NAME);
        valuables.add(ptAttr == null ? PressureTendency.UNKOWN : PressureTendency.getPressureTendency(ptAttr.getTextContent()));
        Node tAttr = repAttributes.getNamedItem(RealTemperature.SHORT_PARAMETER_NAME);
        valuables.add(RealTemperature.getInstance(tAttr == null ? RealTemperature.UNKNOW_VALUE : tAttr.getTextContent()));
        Node vAttr = repAttributes.getNamedItem(RealVisibility.SHORT_PARAMETER_NAME);
        valuables.add(RealVisibility.getInstance(vAttr == null ? RealVisibility.UNKNOW_VALUE : vAttr.getTextContent()));
        Node hAttr = repAttributes.getNamedItem(RelativeHumidity.SHORT_PARAMETER_NAME);
        valuables.add(RelativeHumidity.getInstance(hAttr == null ? RelativeHumidity.UNKNOW_VALUE : hAttr.getTextContent()));
        Node dpAttr = repAttributes.getNamedItem(DewPoint.SHORT_PARAMETER_NAME);
        valuables.add(DewPoint.getInstance(dpAttr == null ? DewPoint.UNKNOW_VALUE : dpAttr.getTextContent()));
        Node wAttr = repAttributes.getNamedItem(WeatherType.SHORT_PARAMETER_NAME);
        valuables.add(wAttr == null ? WeatherType.UNKOWN : WeatherType.getWeatherType(wAttr.getTextContent()));
        Node dAttr = repAttributes.getNamedItem(WindDirection.SHORT_PARAMETER_NAME);
        valuables.add(dAttr == null ? WindDirection.UNKOWN : WindDirection.valueOf(dAttr.getTextContent()));
        Node sAttr = repAttributes.getNamedItem(WindSpeed.SHORT_PARAMETER_NAME);
        WindSpeed windSpeed = WindSpeed.getInstance(sAttr == null ? WindSpeed.UNKNOW_VALUE : sAttr.getTextContent());
        valuables.add(windSpeed);
        Node gAttr = repAttributes.getNamedItem(WindGust.SHORT_PARAMETER_NAME);
        valuables.add(gAttr == null ? WindGust.getInstance(windSpeed) : WindGust.getInstance(gAttr.getTextContent()));

        return new ResponseData(dateTime, valuables);
    }
}
