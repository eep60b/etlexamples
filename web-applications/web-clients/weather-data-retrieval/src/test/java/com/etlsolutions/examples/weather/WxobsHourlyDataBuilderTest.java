package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.AbsolutePressure;
import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.DewPoint;
import com.etlsolutions.examples.weather.data.PressureTendency;
import com.etlsolutions.examples.weather.data.RealTemperature;
import com.etlsolutions.examples.weather.data.RealVisibility;
import com.etlsolutions.examples.weather.data.RelativeHumidity;
import com.etlsolutions.examples.weather.data.RequestConfig;
import com.etlsolutions.examples.weather.data.ResponseData;
import com.etlsolutions.examples.weather.data.Valuable;
import com.etlsolutions.examples.weather.data.WeatherType;
import com.etlsolutions.examples.weather.data.WindDirection;
import com.etlsolutions.examples.weather.data.WindGust;
import com.etlsolutions.examples.weather.data.WindSpeed;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Test of WxobsHourlyDataBuilder class.
 *
 * @author zc
 */
public final class WxobsHourlyDataBuilderTest {

    private final String line = "12/06/2017 04:00:00,1026.0,-2,10.7,11000.0,83.8,8.1,7,2250,21.0,30.0";
    @SuppressWarnings("Convert2Diamond")
    private final ApplicationParameters parameters = new ApplicationParameters("", "", new ArrayList<RequestConfig>(), new String[0], "a", "", "", "1", "MM/dd/yyyy HH:mm:ss", ",", "dev", "usera", "ppa", "/ddas", "fff");
    private final DateTime dateTime = DateTime.getInstance("2017-12-06z", "240");
    private final AbsolutePressure absolutePressure = AbsolutePressure.getInstance("1026.0");
    private final PressureTendency pressureTendency = PressureTendency.F;
    private final RealTemperature realTemperature = RealTemperature.getInstance("10.7");
    private final RealVisibility realVisibility = RealVisibility.getInstance("11000.0");
    private final RelativeHumidity relativeHumidity = RelativeHumidity.getInstance("83.8");
    private final DewPoint dewPoint = DewPoint.getInstance("8.1");
    private final WeatherType weatherType = WeatherType.CLOUDY;
    private final WindDirection windDirection = WindDirection.SW;
    private final WindSpeed windSpeed = WindSpeed.getInstance("21.0");
    private final WindGust windGust = WindGust.getInstance("30.0");
    private final List<Valuable> valuables = Arrays.asList(absolutePressure, pressureTendency, realTemperature, realVisibility, relativeHumidity, dewPoint, weatherType, windDirection, windSpeed, windGust);
    private final ResponseData responseData = new ResponseData(dateTime, valuables);

    private final NamedNodeMap repAttributes = Mockito.mock(NamedNodeMap.class);
    private final Node pAttr = Mockito.mock(Node.class);
    private final Node ptAttr = Mockito.mock(Node.class);
    private final Node tAttr = Mockito.mock(Node.class);
    private final Node vAttr = Mockito.mock(Node.class);
    private final Node hAttr = Mockito.mock(Node.class);
    private final Node dpAttr = Mockito.mock(Node.class);
    private final Node wAttr = Mockito.mock(Node.class);
    private final Node dAttr = Mockito.mock(Node.class);
    private final Node sAttr = Mockito.mock(Node.class);
    private final Node gAttr = Mockito.mock(Node.class);

    private final WxobsHourlyDataBuilder instance = new WxobsHourlyDataBuilder();

    /**
     * Test of build method.
     *
     * @throws ParseException if the data time string cannot be parsed.
     */
    @Test
    public void testBuild() throws ParseException {

        assertEquals(responseData, instance.build(line, parameters));
        assertNull(instance.build("", parameters));
        assertNull(instance.build(null, parameters));
    }

    /**
     * Test of createData method.
     */
    @Test
    public void testCreateData() {

        Mockito.when(repAttributes.getNamedItem("P")).thenReturn(pAttr);
        Mockito.when(repAttributes.getNamedItem("Pt")).thenReturn(ptAttr);
        Mockito.when(repAttributes.getNamedItem("T")).thenReturn(tAttr);
        Mockito.when(repAttributes.getNamedItem("V")).thenReturn(vAttr);
        Mockito.when(repAttributes.getNamedItem("H")).thenReturn(hAttr);
        Mockito.when(repAttributes.getNamedItem("Dp")).thenReturn(dpAttr);
        Mockito.when(repAttributes.getNamedItem("W")).thenReturn(wAttr);
        Mockito.when(repAttributes.getNamedItem("D")).thenReturn(dAttr);
        Mockito.when(repAttributes.getNamedItem("S")).thenReturn(sAttr);
        Mockito.when(repAttributes.getNamedItem("G")).thenReturn(gAttr);

        Mockito.when(pAttr.getTextContent()).thenReturn("1026.0");
        Mockito.when(ptAttr.getTextContent()).thenReturn("F");
        Mockito.when(tAttr.getTextContent()).thenReturn("10.7");
        Mockito.when(vAttr.getTextContent()).thenReturn("11000.0");
        Mockito.when(hAttr.getTextContent()).thenReturn("83.8");
        Mockito.when(dpAttr.getTextContent()).thenReturn("8.1");
        Mockito.when(wAttr.getTextContent()).thenReturn("7");
        Mockito.when(dAttr.getTextContent()).thenReturn("SW");
        Mockito.when(sAttr.getTextContent()).thenReturn("21.0");
        Mockito.when(gAttr.getTextContent()).thenReturn("30.0");

        assertEquals(responseData, instance.createData(repAttributes, dateTime));
    }

    /**
     * Test of createData method.
     */
    @Test
    public void testCreateData_Unknown_Data() {

        assertEquals(new ResponseData(dateTime, Arrays.asList(AbsolutePressure.getInstance(AbsolutePressure.UNKNOW_VALUE), PressureTendency.UNKOWN,
                RealTemperature.getInstance(RealTemperature.UNKNOW_VALUE), RealVisibility.getInstance(RealVisibility.UNKNOW_VALUE), RelativeHumidity.getInstance(RelativeHumidity.UNKNOW_VALUE),
                DewPoint.getInstance(DewPoint.UNKNOW_VALUE), WeatherType.UNKOWN, WindDirection.UNKOWN, WindSpeed.getInstance(WindSpeed.UNKNOW_VALUE), WindGust.getInstance(WindGust.UNKNOW_VALUE))), instance.createData(repAttributes, dateTime));
    }
}
