package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestLocation;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Test of class RequestLocationsLoader.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RequestLocationsLoader.class, Logger.class, DocumentBuilderFactory.class})
public final class RequestLocationsLoaderTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final String path = "apbbapath";
    private final DocumentBuilderFactory factory = Mockito.mock(DocumentBuilderFactory.class);
    private final DocumentBuilder db = Mockito.mock(DocumentBuilder.class);
    private final RequestLocation requestLocation1 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation requestLocation2 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation requestLocation3 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation defaultRequestLocation1 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation defaultRequestLocation2 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation defaultRequestLocation3 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation embeddedRequestLocation1 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation embeddedRequestLocation2 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation embeddedRequestLocation3 = PowerMockito.mock(RequestLocation.class);
    private final File file = Mockito.mock(File.class);
    private final FileInputStream fileInputStream = Mockito.mock(FileInputStream.class);
    private final InputSource inputSource = Mockito.mock(InputSource.class);
    private final Document document = Mockito.mock(Document.class);
    private final NodeList documentChildren = Mockito.mock(NodeList.class);
    private final Node node1 = Mockito.mock(Node.class);
    private final Node node2 = Mockito.mock(Node.class);
    private final NodeList locationsChildren = Mockito.mock(NodeList.class);
    private final Node locationsChild1 = Mockito.mock(Node.class);
    private final Node locationsChild2 = Mockito.mock(Node.class);
    private final Node locationsChild3 = Mockito.mock(Node.class);
    private final Node locationsChild4 = Mockito.mock(Node.class);
    private final NamedNodeMap locationAttributes1 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap locationAttributes2 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap locationAttributes3 = Mockito.mock(NamedNodeMap.class);
    private final Node idNode1 = Mockito.mock(Node.class);
    private final Node idNode2 = Mockito.mock(Node.class);
    private final Node idNode3 = Mockito.mock(Node.class);
    private final Node nameNode1 = Mockito.mock(Node.class);
    private final Node nameNode2 = Mockito.mock(Node.class);
    private final Node nameNode3 = Mockito.mock(Node.class);
    private final Node lastitudeNode1 = Mockito.mock(Node.class);
    private final Node lastitudeNode2 = Mockito.mock(Node.class);
    private final Node lastitudeNode3 = Mockito.mock(Node.class);
    private final Node logitudeNode1 = Mockito.mock(Node.class);
    private final Node logitudeNode2 = Mockito.mock(Node.class);
    private final Node logitudeNode3 = Mockito.mock(Node.class);
    private final Node elevationNode1 = Mockito.mock(Node.class);
    private final Node elevationNode2 = Mockito.mock(Node.class);
    private final Node elevationNode3 = Mockito.mock(Node.class);
    
    private final File defaultFile = Mockito.mock(File.class);
    private final FileInputStream defaultFileInputStream = Mockito.mock(FileInputStream.class);
    private final InputStream embeddedInputStream = Mockito.mock(InputStream.class);

    private final InOrder inOrder = Mockito.inOrder(logger);

    private final RequestLocationsLoader instance = RequestLocationsLoader.getInstance();

    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RequestLocationsLoader.class)).thenReturn(logger);

        PowerMockito.mockStatic(DocumentBuilderFactory.class);
        Mockito.when(DocumentBuilderFactory.newInstance()).thenReturn(factory);
        Mockito.when(factory.newDocumentBuilder()).thenReturn(db);

        PowerMockito.whenNew(File.class).withArguments(path).thenReturn(file);
        PowerMockito.whenNew(FileInputStream.class).withArguments(file).thenReturn(fileInputStream);
    }

    /**
     * Test of class RequestLocationsLoader.
     */
    @Test
    public void testGetInstance() {

        assertSame(RequestLocationsLoader.getInstance(), instance);
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.TRUE);
        assertEquals(Arrays.asList(requestLocation1, requestLocation2, requestLocation3), instance.load(path));

        inOrder.verify(logger).info("\nTry to load request locations from apbbapath.");
        inOrder.verify(logger).info("The request locations has been successfully loaded from apbbapath.");
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_from_default() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.FALSE);
        assertEquals(Arrays.asList(defaultRequestLocation1, defaultRequestLocation2, defaultRequestLocation3), instance.load(path));

        inOrder.verify(logger).info("\nTry to load request locations from apbbapath.");

    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_from_embedded() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.FALSE);
        assertEquals(Arrays.asList(embeddedRequestLocation1, embeddedRequestLocation2, embeddedRequestLocation3), instance.load(path));

        inOrder.verify(logger).info("\nTry to load request locations from apbbapath.");

    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_from_embedded_no_copying() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.FALSE);
        assertEquals(Arrays.asList(embeddedRequestLocation1, embeddedRequestLocation2, embeddedRequestLocation3), instance.load(path));

        inOrder.verify(logger).info("\nTry to load request locations from apbbapath.");

    }
}
