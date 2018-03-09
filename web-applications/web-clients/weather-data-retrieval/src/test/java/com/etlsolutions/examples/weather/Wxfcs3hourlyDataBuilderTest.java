package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.AbsolutePressure;
import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.DewPoint;
import com.etlsolutions.examples.weather.data.FeelTemperature;
import com.etlsolutions.examples.weather.data.PrecipitationProbability;
import com.etlsolutions.examples.weather.data.PredictedVisibility;
import com.etlsolutions.examples.weather.data.RealTemperature;
import com.etlsolutions.examples.weather.data.RelativeHumidity;
import com.etlsolutions.examples.weather.data.RequestConfig;
import com.etlsolutions.examples.weather.data.ResponseData;
import com.etlsolutions.examples.weather.data.UvIndex;
import com.etlsolutions.examples.weather.data.Valuable;
import com.etlsolutions.examples.weather.data.WeatherType;
import com.etlsolutions.examples.weather.data.WindDirection;
import com.etlsolutions.examples.weather.data.WindGust;
import com.etlsolutions.examples.weather.data.WindSpeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Test of class Wxfcs3hourlyDataBuilder.
 *
 * @author zc
 */
public final class Wxfcs3hourlyDataBuilderTest {

    private final String line = "12/08/2017 12:00:00,-2.0,9.0,3.0,40000.0,74.0,1,8,2925,34.0,18.0";
    @SuppressWarnings("Convert2Diamond")
    private final ApplicationParameters parameters = new ApplicationParameters("", "", new ArrayList<RequestConfig>(), new String[0], "a", "", "", "1", "MM/dd/yyyy HH:mm:ss", ",", true, "dev", "usera", "ppa", "/ddas", "fff");
    private final DateTime dateTime = DateTime.getInstance("2017-12-08Z", "720");
    private final FeelTemperature feelTemperature = FeelTemperature.getInstance("-2.0");
    private final PrecipitationProbability precipitationProbability = PrecipitationProbability.getInstance("9.0");
    private final RealTemperature realTemperature = RealTemperature.getInstance("3.0");
    private final PredictedVisibility predictedVisibility = PredictedVisibility.EXCELLENT;
    private final RelativeHumidity relativeHumidity = RelativeHumidity.getInstance("74.0");
    private final UvIndex uvIndex = UvIndex.getInstance("1");
    private final WeatherType weatherType = WeatherType.OVERCAST;
    private final WindDirection windDirection = WindDirection.WNW;
    private final WindSpeed windSpeed = WindSpeed.getInstance("34.0");
    private final WindGust windGust = WindGust.getInstance("18.0");
    private final List<Valuable> valuables = Arrays.asList(feelTemperature, precipitationProbability, realTemperature, predictedVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windSpeed, windGust);
    private final ResponseData responseData = new ResponseData(dateTime, valuables);

    private final NamedNodeMap repAttributes = Mockito.mock(NamedNodeMap.class);
    private final Node fAttr = Mockito.mock(Node.class);
    private final Node ppAttr = Mockito.mock(Node.class);
    private final Node tAttr = Mockito.mock(Node.class);
    private final Node vAttr = Mockito.mock(Node.class);
    private final Node hAttr = Mockito.mock(Node.class);
    private final Node uAttr = Mockito.mock(Node.class);
    private final Node wAttr = Mockito.mock(Node.class);
    private final Node dAttr = Mockito.mock(Node.class);
    private final Node sAttr = Mockito.mock(Node.class);
    private final Node gAttr = Mockito.mock(Node.class);

    private final Wxfcs3hourlyDataBuilder instance = new Wxfcs3hourlyDataBuilder();

    /**
     * Test of build method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testBuild() throws Exception {

        assertEquals(responseData, instance.build(line, parameters));
        assertNull(instance.build("          ", parameters));
        assertNull(instance.build(null, parameters));
    }

    /**
     * Test of createData method.
     */
    @Test
    public void testCreateData() {

        Mockito.when(repAttributes.getNamedItem("F")).thenReturn(fAttr);
        Mockito.when(repAttributes.getNamedItem("Pp")).thenReturn(ppAttr);
        Mockito.when(repAttributes.getNamedItem("T")).thenReturn(tAttr);
        Mockito.when(repAttributes.getNamedItem("V")).thenReturn(vAttr);
        Mockito.when(repAttributes.getNamedItem("H")).thenReturn(hAttr);
        Mockito.when(repAttributes.getNamedItem("U")).thenReturn(uAttr);
        Mockito.when(repAttributes.getNamedItem("W")).thenReturn(wAttr);
        Mockito.when(repAttributes.getNamedItem("D")).thenReturn(dAttr);
        Mockito.when(repAttributes.getNamedItem("S")).thenReturn(sAttr);
        Mockito.when(repAttributes.getNamedItem("G")).thenReturn(gAttr);

        Mockito.when(fAttr.getTextContent()).thenReturn("-2.0");
        Mockito.when(ppAttr.getTextContent()).thenReturn("9.0");
        Mockito.when(tAttr.getTextContent()).thenReturn("3.0");
        Mockito.when(vAttr.getTextContent()).thenReturn("EX");
        Mockito.when(hAttr.getTextContent()).thenReturn("74.0");
        Mockito.when(uAttr.getTextContent()).thenReturn("1");
        Mockito.when(wAttr.getTextContent()).thenReturn("8");
        Mockito.when(dAttr.getTextContent()).thenReturn("WNW");
        Mockito.when(sAttr.getTextContent()).thenReturn("34.0");
        Mockito.when(gAttr.getTextContent()).thenReturn("18.0");

        assertEquals(responseData, instance.createData(repAttributes, dateTime));
    }

    /**
     * Test of createData method.
     */
    @Test
    public void testCreateData_Unknown_Data() {

        assertEquals(new ResponseData(dateTime, Arrays.asList(FeelTemperature.getInstance(AbsolutePressure.UNKNOW_VALUE), PrecipitationProbability.getInstance(PrecipitationProbability.UNKNOW_VALUE),
                RealTemperature.getInstance(RealTemperature.UNKNOW_VALUE), PredictedVisibility.UNKOWN, RelativeHumidity.getInstance(RelativeHumidity.UNKNOW_VALUE),
                UvIndex.getInstance(DewPoint.UNKNOW_VALUE), WeatherType.UNKOWN, WindDirection.UNKOWN, WindSpeed.getInstance(WindSpeed.UNKNOW_VALUE), WindGust.getInstance(WindGust.UNKNOW_VALUE))), instance.createData(repAttributes, dateTime));
    }
}
