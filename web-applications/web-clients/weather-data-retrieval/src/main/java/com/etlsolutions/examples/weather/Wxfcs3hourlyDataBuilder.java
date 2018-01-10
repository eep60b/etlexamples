package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ResponseData;
import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.FeelTemperature;
import com.etlsolutions.examples.weather.data.PrecipitationProbability;
import com.etlsolutions.examples.weather.data.RealTemperature;
import com.etlsolutions.examples.weather.data.PredictedVisibility;
import com.etlsolutions.examples.weather.data.RelativeHumidity;
import com.etlsolutions.examples.weather.data.UvIndex;
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
 * The Wxfcs3hourlyDataBuilder class builds the ForcastData objects.
 *
 * @author zc
 */
public final class Wxfcs3hourlyDataBuilder extends ResponseDataBuilder {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public final ResponseData build(String line, ApplicationParameters parameters) throws ParseException {

        List<Valuable> valuables = new ArrayList<>();
        if (line == null || line.trim().isEmpty()) {
            return null;
        }

        String[] cells = line.split(parameters.getDelimiter());
        int index = 0;
        DateTime dateTime = DateTime.getInstance(parameters.getDatetimeFormat().parse(cells[index++]));
        valuables.add(FeelTemperature.getInstance(cells[index++]));
        valuables.add(PrecipitationProbability.getInstance(cells[index++]));
        valuables.add(RealTemperature.getInstance(cells[index++]));
        valuables.add(PredictedVisibility.getPredictedVisibility(Double.parseDouble(cells[index++])));
        valuables.add(RelativeHumidity.getInstance(cells[index++]));
        valuables.add(UvIndex.getInstance(cells[index++]));
        valuables.add(WeatherType.getWeatherType(cells[index++]));
        valuables.add(WindDirection.getWindDirection(Integer.parseInt(cells[index++])));
        valuables.add(WindSpeed.getInstance(cells[index++]));
        valuables.add(WindGust.getInstance(cells[index++]));
        
        return new ResponseData(dateTime, valuables);
    }

    @Override
    public ResponseData createData(NamedNodeMap repAttributes, DateTime dateTime) {

        List<Valuable> valuables = new ArrayList<>();        
        Node fAttr = repAttributes.getNamedItem(FeelTemperature.SHORT_PARAMETER_NAME);
        valuables.add(FeelTemperature.getInstance(fAttr == null ? FeelTemperature.UNKNOW_VALUE : fAttr.getTextContent()));
        Node ppAttr = repAttributes.getNamedItem(PrecipitationProbability.SHORT_PARAMETER_NAME);
        valuables.add(PrecipitationProbability.getInstance(ppAttr == null ? PrecipitationProbability.UNKNOW_VALUE : ppAttr.getTextContent()));
        Node tAttr = repAttributes.getNamedItem(RealTemperature.SHORT_PARAMETER_NAME);
        valuables.add(RealTemperature.getInstance(tAttr == null ? RealTemperature.UNKNOW_VALUE : tAttr.getTextContent()));
        Node vAttr = repAttributes.getNamedItem(PredictedVisibility.SHORT_PARAMETER_NAME);
        valuables.add(vAttr == null ? PredictedVisibility.UNKOWN: PredictedVisibility.getPredictedVisibility(vAttr.getTextContent()));
        Node hAttr = repAttributes.getNamedItem(RelativeHumidity.SHORT_PARAMETER_NAME);
        valuables.add(RelativeHumidity.getInstance(hAttr == null ? RelativeHumidity.UNKNOW_VALUE : hAttr.getTextContent()));
        Node uAttr = repAttributes.getNamedItem(UvIndex.SHORT_PARAMETER_NAME);
        valuables.add(UvIndex.getInstance(uAttr == null ? UvIndex.UNKNOW_VALUE : uAttr.getTextContent()));
        Node wAttr = repAttributes.getNamedItem(WeatherType.SHORT_PARAMETER_NAME);
        valuables.add(wAttr == null ? WeatherType.UNKOWN : WeatherType.getWeatherType(wAttr.getTextContent()));
        Node dAttr = repAttributes.getNamedItem(WindDirection.SHORT_PARAMETER_NAME);
        valuables.add(dAttr == null ? WindDirection.UNKOWN : WindDirection.valueOf(dAttr.getTextContent()));
        Node sAttr = repAttributes.getNamedItem(WindSpeed.SHORT_PARAMETER_NAME);
        WindSpeed windSpeed = WindSpeed.getInstance(sAttr == null ? WindSpeed.UNKNOW_VALUE : sAttr.getTextContent());
        valuables.add(windSpeed);
        Node windGustAttribute = repAttributes.getNamedItem(WindGust.SHORT_PARAMETER_NAME);
        valuables.add(windGustAttribute == null ? WindGust.getInstance(windSpeed) : WindGust.getInstance(windGustAttribute.getTextContent()));
        return new ResponseData(dateTime, valuables);
    }
}
