package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.ResponseData;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Test of class ResponseDataBuilder.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ResponseDataBuilder.class, ResponseData.class})
public final class ResponseDataBuilderTest {

    private final ResponseData responseData1 = PowerMockito.mock(ResponseData.class);
    private final ResponseData responseData2 = PowerMockito.mock(ResponseData.class);
    private final ResponseData responseData3 = PowerMockito.mock(ResponseData.class);
    private final ResponseData responseData00 = PowerMockito.mock(ResponseData.class);
    private final ResponseData responseData10 = PowerMockito.mock(ResponseData.class);
    private final ResponseData responseData11 = PowerMockito.mock(ResponseData.class);
    private final ResponseData responseData20 = PowerMockito.mock(ResponseData.class);
    private final List<ResponseData> savedData = Arrays.asList(responseData1, responseData2, responseData3);
    private final Document document = Mockito.mock(Document.class);
    private final NodeList documentChildren = Mockito.mock(NodeList.class);
    private final Node documentChild0 = Mockito.mock(Node.class);
    private final Node documentChild1 = Mockito.mock(Node.class);
    private final NodeList siteRepChildren = Mockito.mock(NodeList.class);
    private final Node siteRepChild0 = Mockito.mock(Node.class);
    private final Node siteRepChild1 = Mockito.mock(Node.class);
    private final NodeList dvChildren = Mockito.mock(NodeList.class);
    private final Node dvChild0 = Mockito.mock(Node.class);
    private final Node dvChild1 = Mockito.mock(Node.class);
    private final NodeList locationChildren = Mockito.mock(NodeList.class);
    private final Node periodNode0 = Mockito.mock(Node.class);
    private final Node periodNode1 = Mockito.mock(Node.class);
    private final Node periodNode2 = Mockito.mock(Node.class);
    private final NamedNodeMap periodAttributes0 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap periodAttributes1 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap periodAttributes2 = Mockito.mock(NamedNodeMap.class);
    private final Node dateAttribute0 = Mockito.mock(Node.class);
    private final Node dateAttribute1 = Mockito.mock(Node.class);
    private final Node dateAttribute2 = Mockito.mock(Node.class);
    private final NodeList periodChildren0 = Mockito.mock(NodeList.class);
    private final NodeList periodChildren1 = Mockito.mock(NodeList.class);
    private final NodeList periodChildren2 = Mockito.mock(NodeList.class);
    private final Node repNode00 = Mockito.mock(Node.class);
    private final Node repNode10 = Mockito.mock(Node.class);
    private final Node repNode11 = Mockito.mock(Node.class);
    private final Node repNode20 = Mockito.mock(Node.class);
    private final NamedNodeMap repAttributes00 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap repAttributes10 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap repAttributes11 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap repAttributes20 = Mockito.mock(NamedNodeMap.class);

    private final ResponseDataBuilder instance = new ResponseDataBuilderImpl();

    @Before
    public void setUp() {

        Mockito.when(responseData1.getDateTime()).thenReturn(DateTime.getInstance("2017-11-09Z", "180"));
        Mockito.when(responseData2.getDateTime()).thenReturn(DateTime.getInstance("2017-11-10Z", "180"));
        Mockito.when(responseData3.getDateTime()).thenReturn(DateTime.getInstance("2017-11-11Z", "180"));


        Mockito.when(document.getChildNodes()).thenReturn(documentChildren);
        Mockito.when(documentChildren.getLength()).thenReturn(2);
        Mockito.when(documentChildren.item(0)).thenReturn(documentChild0);
        Mockito.when(documentChildren.item(1)).thenReturn(documentChild1);
        Mockito.when(documentChild1.getNodeName()).thenReturn("SiteRep");
        Mockito.when(documentChild1.getChildNodes()).thenReturn(siteRepChildren);
        Mockito.when(siteRepChildren.getLength()).thenReturn(2);
        Mockito.when(siteRepChildren.item(0)).thenReturn(siteRepChild0);
        Mockito.when(siteRepChildren.item(1)).thenReturn(siteRepChild1);
        Mockito.when(siteRepChild1.getNodeName()).thenReturn("DV");
        Mockito.when(siteRepChild1.getChildNodes()).thenReturn(dvChildren);
        Mockito.when(dvChildren.getLength()).thenReturn(2);
        Mockito.when(dvChildren.item(0)).thenReturn(dvChild0);
        Mockito.when(dvChildren.item(1)).thenReturn(dvChild1);
        Mockito.when(dvChild1.getNodeName()).thenReturn("Location");
        Mockito.when(dvChild1.getChildNodes()).thenReturn(locationChildren);
        Mockito.when(locationChildren.getLength()).thenReturn(3);
        Mockito.when(locationChildren.item(0)).thenReturn(periodNode0);
        Mockito.when(locationChildren.item(1)).thenReturn(periodNode1);
        Mockito.when(locationChildren.item(2)).thenReturn(periodNode2);
        Mockito.when(periodNode0.getAttributes()).thenReturn(periodAttributes0);
        Mockito.when(periodNode1.getAttributes()).thenReturn(periodAttributes1);
        Mockito.when(periodNode2.getAttributes()).thenReturn(periodAttributes2);
        Mockito.when(periodAttributes0.getNamedItem("value")).thenReturn(dateAttribute0);
        Mockito.when(periodAttributes1.getNamedItem("value")).thenReturn(dateAttribute1);
        Mockito.when(periodAttributes2.getNamedItem("value")).thenReturn(dateAttribute2);
        Mockito.when(dateAttribute0.getTextContent()).thenReturn("2017-11-10Z");
        Mockito.when(dateAttribute1.getTextContent()).thenReturn("2017-11-11Z");
        Mockito.when(dateAttribute2.getTextContent()).thenReturn("2017-11-12Z");
        Mockito.when(periodNode0.getChildNodes()).thenReturn(periodChildren0);
        Mockito.when(periodNode1.getChildNodes()).thenReturn(periodChildren1);
        Mockito.when(periodNode2.getChildNodes()).thenReturn(periodChildren2);
        Mockito.when(periodChildren0.getLength()).thenReturn(1);
        Mockito.when(periodChildren1.getLength()).thenReturn(2);
        Mockito.when(periodChildren2.getLength()).thenReturn(1);
        Mockito.when(periodChildren0.item(0)).thenReturn(repNode00);
        Mockito.when(periodChildren1.item(0)).thenReturn(repNode10);
        Mockito.when(periodChildren1.item(1)).thenReturn(repNode11);
        Mockito.when(periodChildren2.item(0)).thenReturn(repNode20);

        Mockito.when(repNode00.getTextContent()).thenReturn("180");
        Mockito.when(repNode10.getTextContent()).thenReturn("180");
        Mockito.when(repNode11.getTextContent()).thenReturn("360");
        Mockito.when(repNode20.getTextContent()).thenReturn("720");

        Mockito.when(repNode00.getAttributes()).thenReturn(repAttributes00);
        Mockito.when(repNode10.getAttributes()).thenReturn(repAttributes10);
        Mockito.when(repNode11.getAttributes()).thenReturn(repAttributes11);
        Mockito.when(repNode20.getAttributes()).thenReturn(repAttributes20);
    }

    /**
     * Test of build method.
     */
    @Test
    public void testBuild_3args() {

        List<ResponseData> result = instance.build(document, savedData);

        assertEquals(5, result.size());
        assertSame(responseData1, result.get(0));
        assertSame(responseData00, result.get(1));
        assertSame(responseData10, result.get(2));
        assertSame(responseData11, result.get(3));
        assertSame(responseData20, result.get(4));
    }

    private final class ResponseDataBuilderImpl extends ResponseDataBuilder {

        @Override
        public ResponseData build(String inputLine, ApplicationParameters parameters) throws ParseException {
            return null;
        }

        @Override
        public ResponseData createData(NamedNodeMap repAttributes, DateTime dateTime) {

            if (repAttributes == repAttributes00 && Objects.equals(dateTime, DateTime.getInstance("2017-11-10Z", "180"))) {
                return responseData00;
            }

            if (repAttributes == repAttributes10 && Objects.equals(dateTime, DateTime.getInstance("2017-11-11Z", "180"))) {
                return responseData10;
            }

            if (repAttributes == repAttributes11 && Objects.equals(dateTime, DateTime.getInstance("2017-11-11Z", "360"))) {
                return responseData11;
            }

            if (repAttributes == repAttributes20 && Objects.equals(dateTime, DateTime.getInstance("2017-11-12Z", "720"))) {
                return responseData20;
            }

            return null;
        }
    }

}
