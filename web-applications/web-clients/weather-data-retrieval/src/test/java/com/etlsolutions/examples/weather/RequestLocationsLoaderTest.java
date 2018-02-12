package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.DEFAULT_REQUEST_LOCATIONS_FILE_PATH;
import static com.etlsolutions.examples.weather.SettingConstants.EMBEDDED_REQUEST_LOCATIONS_FILE_PATH;
import com.etlsolutions.examples.weather.data.RequestLocation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.FileUtils;
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
@PrepareForTest({RequestLocationsLoader.class, Logger.class, DocumentBuilderFactory.class, RequestLocation.class, FileUtils.class, EmbeddedInputStreamProvider.class})
public final class RequestLocationsLoaderTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final String path = "apbbapath";
    private final DocumentBuilderFactory factory = Mockito.mock(DocumentBuilderFactory.class);
    private final DocumentBuilder db = Mockito.mock(DocumentBuilder.class);
    private final IOException ioe = Mockito.mock(IOException.class);

    private final RequestLocation requestLocation0 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation requestLocation1 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation requestLocation2 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation defaultRequestLocation0 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation defaultRequestLocation1 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation defaultRequestLocation2 = PowerMockito.mock(RequestLocation.class);
    private final File file = Mockito.mock(File.class);
    private final FileInputStream fileInputStream = Mockito.mock(FileInputStream.class);
    private final InputSource inputSource = Mockito.mock(InputSource.class);
    private final Document document = Mockito.mock(Document.class);
    private final NodeList documentChildren = Mockito.mock(NodeList.class);
    private final Node node0 = Mockito.mock(Node.class);
    private final Node node1 = Mockito.mock(Node.class);
    private final NodeList locationsChildren = Mockito.mock(NodeList.class);
    private final Node locationsChild0 = Mockito.mock(Node.class);
    private final Node locationsChild1 = Mockito.mock(Node.class);
    private final Node locationsChild2 = Mockito.mock(Node.class);
    private final Node locationsChild3 = Mockito.mock(Node.class);
    private final NamedNodeMap locationAttributes0 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap locationAttributes1 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap locationAttributes2 = Mockito.mock(NamedNodeMap.class);
    private final Node idNode0 = Mockito.mock(Node.class);
    private final Node idNode1 = Mockito.mock(Node.class);
    private final Node idNode2 = Mockito.mock(Node.class);
    private final Node nameNode0 = Mockito.mock(Node.class);
    private final Node nameNode1 = Mockito.mock(Node.class);
    private final Node nameNode2 = Mockito.mock(Node.class);
    private final Node latitudeNode0 = Mockito.mock(Node.class);
    private final Node latitudeNode1 = Mockito.mock(Node.class);
    private final Node latitudeNode2 = Mockito.mock(Node.class);
    private final Node longitudeNode0 = Mockito.mock(Node.class);
    private final Node longitudeNode1 = Mockito.mock(Node.class);
    private final Node longitudeNode2 = Mockito.mock(Node.class);
    private final Node elevationNode0 = Mockito.mock(Node.class);
    private final Node elevationNode1 = Mockito.mock(Node.class);

    private final File defaultFile = Mockito.mock(File.class);
    private final FileInputStream defaultFileInputStream = Mockito.mock(FileInputStream.class);
    private final InputSource defaultInputSource = Mockito.mock(InputSource.class);
    private final Document defaultDocument = Mockito.mock(Document.class);
    private final NodeList defaultDocumentChildren = Mockito.mock(NodeList.class);
    private final Node defaultNode0 = Mockito.mock(Node.class);
    private final Node defaultNode1 = Mockito.mock(Node.class);
    private final NodeList defaultLocationsChildren = Mockito.mock(NodeList.class);
    private final Node defaultLocationsChild0 = Mockito.mock(Node.class);
    private final Node defaultLocationsChild1 = Mockito.mock(Node.class);
    private final Node defaultLocationsChild2 = Mockito.mock(Node.class);
    private final Node defaultLocationsChild3 = Mockito.mock(Node.class);
    private final NamedNodeMap defaultLocationAttributes0 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap defaultLocationAttributes1 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap defaultLocationAttributes2 = Mockito.mock(NamedNodeMap.class);
    private final Node defaultIdNode0 = Mockito.mock(Node.class);
    private final Node defaultIdNode1 = Mockito.mock(Node.class);
    private final Node defaultIdNode2 = Mockito.mock(Node.class);
    private final Node defaultNameNode0 = Mockito.mock(Node.class);
    private final Node defaultNameNode1 = Mockito.mock(Node.class);
    private final Node defaultNameNode2 = Mockito.mock(Node.class);
    private final Node defaultLatitudeNode0 = Mockito.mock(Node.class);
    private final Node defaultLatitudeNode1 = Mockito.mock(Node.class);
    private final Node defaultLatitudeNode2 = Mockito.mock(Node.class);
    private final Node defaultLongitudeNode0 = Mockito.mock(Node.class);
    private final Node defaultLongitudeNode1 = Mockito.mock(Node.class);
    private final Node defaultLongitudeNode2 = Mockito.mock(Node.class);
    private final Node defaultElevationNode0 = Mockito.mock(Node.class);
    private final Node defaultElevationNode1 = Mockito.mock(Node.class);

    private final EmbeddedInputStreamProvider provider = PowerMockito.mock(EmbeddedInputStreamProvider.class);
    private final InputStream embeddedInputStream = Mockito.mock(InputStream.class);
    private final RequestLocation embeddedrequestLocation0 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation embeddedrequestLocation1 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation embeddedrequestLocation2 = PowerMockito.mock(RequestLocation.class);
    private final InputSource embeddedinputSource = Mockito.mock(InputSource.class);
    private final Document embeddeddocument = Mockito.mock(Document.class);
    private final NodeList embeddeddocumentChildren = Mockito.mock(NodeList.class);
    private final Node embeddednode0 = Mockito.mock(Node.class);
    private final Node embeddednode1 = Mockito.mock(Node.class);
    private final NodeList embeddedlocationsChildren = Mockito.mock(NodeList.class);
    private final Node embeddedlocationsChild0 = Mockito.mock(Node.class);
    private final Node embeddedlocationsChild1 = Mockito.mock(Node.class);
    private final Node embeddedlocationsChild2 = Mockito.mock(Node.class);
    private final Node embeddedlocationsChild3 = Mockito.mock(Node.class);
    private final NamedNodeMap embeddedlocationAttributes0 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap embeddedlocationAttributes1 = Mockito.mock(NamedNodeMap.class);
    private final NamedNodeMap embeddedlocationAttributes2 = Mockito.mock(NamedNodeMap.class);
    private final Node embeddedidNode0 = Mockito.mock(Node.class);
    private final Node embeddedidNode1 = Mockito.mock(Node.class);
    private final Node embeddedidNode2 = Mockito.mock(Node.class);
    private final Node embeddednameNode0 = Mockito.mock(Node.class);
    private final Node embeddednameNode1 = Mockito.mock(Node.class);
    private final Node embeddednameNode2 = Mockito.mock(Node.class);
    private final Node embeddedlatitudeNode0 = Mockito.mock(Node.class);
    private final Node embeddedlatitudeNode1 = Mockito.mock(Node.class);
    private final Node embeddedlatitudeNode2 = Mockito.mock(Node.class);
    private final Node embeddedlongitudeNode0 = Mockito.mock(Node.class);
    private final Node embeddedlongitudeNode1 = Mockito.mock(Node.class);
    private final Node embeddedlongitudeNode2 = Mockito.mock(Node.class);
    private final Node embeddedelevationNode0 = Mockito.mock(Node.class);
    private final Node embeddedelevationNode1 = Mockito.mock(Node.class);

    private final InOrder inOrder = Mockito.inOrder(logger);

    private final RequestLocationsLoader instance = RequestLocationsLoader.getInstance();

    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RequestLocationsLoader.class)).thenReturn(logger);

        PowerMockito.mockStatic(DocumentBuilderFactory.class);
        Mockito.when(DocumentBuilderFactory.newInstance()).thenReturn(factory);
        Mockito.when(factory.newDocumentBuilder()).thenReturn(db);

        PowerMockito.mockStatic(FileUtils.class);

        PowerMockito.whenNew(File.class).withArguments(path).thenReturn(file);
        Mockito.when(file.getAbsolutePath()).thenReturn(path);
        PowerMockito.whenNew(FileInputStream.class).withArguments(file).thenReturn(fileInputStream);
        PowerMockito.whenNew(InputSource.class).withArguments(fileInputStream).thenReturn(inputSource);
        Mockito.when(db.parse(inputSource)).thenReturn(document);

        Mockito.when(document.getChildNodes()).thenReturn(documentChildren);
        Mockito.when(documentChildren.getLength()).thenReturn(2);
        Mockito.when(documentChildren.item(0)).thenReturn(node0);
        Mockito.when(documentChildren.item(1)).thenReturn(node1);
        Mockito.when(node0.getNodeName()).thenReturn("Locations");
        Mockito.when(node1.getNodeName()).thenReturn("LocationsA");
        Mockito.when(node0.getChildNodes()).thenReturn(locationsChildren);
        Mockito.when(locationsChildren.getLength()).thenReturn(4);

        Mockito.when(locationsChildren.item(0)).thenReturn(locationsChild0);
        Mockito.when(locationsChildren.item(1)).thenReturn(locationsChild1);
        Mockito.when(locationsChildren.item(2)).thenReturn(locationsChild2);
        Mockito.when(locationsChildren.item(3)).thenReturn(locationsChild3);

        Mockito.when(locationsChild0.getNodeName()).thenReturn("Location");
        Mockito.when(locationsChild1.getNodeName()).thenReturn("Location");
        Mockito.when(locationsChild2.getNodeName()).thenReturn("Location");
        Mockito.when(locationsChild3.getNodeName()).thenReturn("LocationA");

        Mockito.when(locationsChild0.getAttributes()).thenReturn(locationAttributes0);
        Mockito.when(locationsChild1.getAttributes()).thenReturn(locationAttributes1);
        Mockito.when(locationsChild2.getAttributes()).thenReturn(locationAttributes2);

        Mockito.when(locationAttributes0.getNamedItem("id")).thenReturn(idNode0);
        Mockito.when(locationAttributes1.getNamedItem("id")).thenReturn(idNode1);
        Mockito.when(locationAttributes2.getNamedItem("id")).thenReturn(idNode2);

        Mockito.when(locationAttributes0.getNamedItem("name")).thenReturn(nameNode0);
        Mockito.when(locationAttributes1.getNamedItem("name")).thenReturn(nameNode1);
        Mockito.when(locationAttributes2.getNamedItem("name")).thenReturn(nameNode2);

        Mockito.when(locationAttributes0.getNamedItem("latitude")).thenReturn(latitudeNode0);
        Mockito.when(locationAttributes1.getNamedItem("latitude")).thenReturn(latitudeNode1);
        Mockito.when(locationAttributes2.getNamedItem("latitude")).thenReturn(latitudeNode2);

        Mockito.when(locationAttributes0.getNamedItem("longitude")).thenReturn(longitudeNode0);
        Mockito.when(locationAttributes1.getNamedItem("longitude")).thenReturn(longitudeNode1);
        Mockito.when(locationAttributes2.getNamedItem("longitude")).thenReturn(longitudeNode2);

        Mockito.when(locationAttributes0.getNamedItem("elevation")).thenReturn(elevationNode0);
        Mockito.when(locationAttributes1.getNamedItem("elevation")).thenReturn(elevationNode1);
        Mockito.when(locationAttributes2.getNamedItem("elevation")).thenReturn(null);

        Mockito.when(idNode0.getTextContent()).thenReturn("21235");
        Mockito.when(idNode1.getTextContent()).thenReturn("9996");
        Mockito.when(idNode2.getTextContent()).thenReturn("77459");

        Mockito.when(nameNode0.getTextContent()).thenReturn("Bangor");
        Mockito.when(nameNode1.getTextContent()).thenReturn("Manchester");
        Mockito.when(nameNode2.getTextContent()).thenReturn("London");

        Mockito.when(latitudeNode0.getTextContent()).thenReturn("44.33432");
        Mockito.when(latitudeNode1.getTextContent()).thenReturn("83.776");
        Mockito.when(latitudeNode2.getTextContent()).thenReturn("99.232");

        Mockito.when(longitudeNode0.getTextContent()).thenReturn("83.53");
        Mockito.when(longitudeNode1.getTextContent()).thenReturn("92.11");
        Mockito.when(longitudeNode2.getTextContent()).thenReturn("83.445");

        Mockito.when(elevationNode0.getTextContent()).thenReturn("213.11");
        Mockito.when(elevationNode1.getTextContent()).thenReturn("56.17");

        PowerMockito.whenNew(RequestLocation.class).withArguments("21235", "Bangor", 44.33432, 83.53, 213.11).thenReturn(requestLocation0);
        PowerMockito.whenNew(RequestLocation.class).withArguments("9996", "Manchester", 83.776, 92.11, 56.17).thenReturn(requestLocation1);
        PowerMockito.whenNew(RequestLocation.class).withArguments("77459", "London", 99.232, 83.445, -100.0).thenReturn(requestLocation2);

        PowerMockito.whenNew(File.class).withArguments(DEFAULT_REQUEST_LOCATIONS_FILE_PATH).thenReturn(defaultFile);
        Mockito.when(defaultFile.getAbsolutePath()).thenReturn("dddfauutltttdPathth");
        PowerMockito.whenNew(FileInputStream.class).withArguments(defaultFile).thenReturn(defaultFileInputStream);
        PowerMockito.whenNew(InputSource.class).withArguments(defaultFileInputStream).thenReturn(defaultInputSource);
        Mockito.when(db.parse(defaultInputSource)).thenReturn(defaultDocument);

        Mockito.when(defaultDocument.getChildNodes()).thenReturn(defaultDocumentChildren);
        Mockito.when(defaultDocumentChildren.getLength()).thenReturn(2);
        Mockito.when(defaultDocumentChildren.item(0)).thenReturn(defaultNode0);
        Mockito.when(defaultDocumentChildren.item(1)).thenReturn(defaultNode1);
        Mockito.when(defaultNode0.getNodeName()).thenReturn("Locations");
        Mockito.when(defaultNode1.getNodeName()).thenReturn("LocationsA");
        Mockito.when(defaultNode0.getChildNodes()).thenReturn(defaultLocationsChildren);
        Mockito.when(defaultLocationsChildren.getLength()).thenReturn(4);

        Mockito.when(defaultLocationsChildren.item(0)).thenReturn(defaultLocationsChild0);
        Mockito.when(defaultLocationsChildren.item(1)).thenReturn(defaultLocationsChild1);
        Mockito.when(defaultLocationsChildren.item(2)).thenReturn(defaultLocationsChild2);
        Mockito.when(defaultLocationsChildren.item(3)).thenReturn(defaultLocationsChild3);

        Mockito.when(defaultLocationsChild0.getNodeName()).thenReturn("Location");
        Mockito.when(defaultLocationsChild1.getNodeName()).thenReturn("Location");
        Mockito.when(defaultLocationsChild2.getNodeName()).thenReturn("Location");
        Mockito.when(defaultLocationsChild3.getNodeName()).thenReturn("LocationA");

        Mockito.when(defaultLocationsChild0.getAttributes()).thenReturn(defaultLocationAttributes0);
        Mockito.when(defaultLocationsChild1.getAttributes()).thenReturn(defaultLocationAttributes1);
        Mockito.when(defaultLocationsChild2.getAttributes()).thenReturn(defaultLocationAttributes2);

        Mockito.when(defaultLocationAttributes0.getNamedItem("id")).thenReturn(defaultIdNode0);
        Mockito.when(defaultLocationAttributes1.getNamedItem("id")).thenReturn(defaultIdNode1);
        Mockito.when(defaultLocationAttributes2.getNamedItem("id")).thenReturn(defaultIdNode2);

        Mockito.when(defaultLocationAttributes0.getNamedItem("name")).thenReturn(defaultNameNode0);
        Mockito.when(defaultLocationAttributes1.getNamedItem("name")).thenReturn(defaultNameNode1);
        Mockito.when(defaultLocationAttributes2.getNamedItem("name")).thenReturn(defaultNameNode2);

        Mockito.when(defaultLocationAttributes0.getNamedItem("latitude")).thenReturn(defaultLatitudeNode0);
        Mockito.when(defaultLocationAttributes1.getNamedItem("latitude")).thenReturn(defaultLatitudeNode1);
        Mockito.when(defaultLocationAttributes2.getNamedItem("latitude")).thenReturn(defaultLatitudeNode2);

        Mockito.when(defaultLocationAttributes0.getNamedItem("longitude")).thenReturn(defaultLongitudeNode0);
        Mockito.when(defaultLocationAttributes1.getNamedItem("longitude")).thenReturn(defaultLongitudeNode1);
        Mockito.when(defaultLocationAttributes2.getNamedItem("longitude")).thenReturn(defaultLongitudeNode2);

        Mockito.when(defaultLocationAttributes0.getNamedItem("elevation")).thenReturn(defaultElevationNode0);
        Mockito.when(defaultLocationAttributes1.getNamedItem("elevation")).thenReturn(defaultElevationNode1);
        Mockito.when(defaultLocationAttributes2.getNamedItem("elevation")).thenReturn(null);

        Mockito.when(defaultIdNode0.getTextContent()).thenReturn("9835");
        Mockito.when(defaultIdNode1.getTextContent()).thenReturn("9346");
        Mockito.when(defaultIdNode2.getTextContent()).thenReturn("1287");

        Mockito.when(defaultNameNode0.getTextContent()).thenReturn("defaultBangor");
        Mockito.when(defaultNameNode1.getTextContent()).thenReturn("defaultManchester");
        Mockito.when(defaultNameNode2.getTextContent()).thenReturn("defaultLondon");

        Mockito.when(defaultLatitudeNode0.getTextContent()).thenReturn("75.83");
        Mockito.when(defaultLatitudeNode1.getTextContent()).thenReturn("43.02");
        Mockito.when(defaultLatitudeNode2.getTextContent()).thenReturn("33.96");

        Mockito.when(defaultLongitudeNode0.getTextContent()).thenReturn("66.32");
        Mockito.when(defaultLongitudeNode1.getTextContent()).thenReturn("27.19");
        Mockito.when(defaultLongitudeNode2.getTextContent()).thenReturn("332.11");

        Mockito.when(defaultElevationNode0.getTextContent()).thenReturn("573.001");
        Mockito.when(defaultElevationNode1.getTextContent()).thenReturn("-376.22");

        PowerMockito.whenNew(RequestLocation.class).withArguments("9835", "defaultBangor", 75.83, 66.32, 573.001).thenReturn(defaultRequestLocation0);
        PowerMockito.whenNew(RequestLocation.class).withArguments("9346", "defaultManchester", 43.02, 27.19, -376.22).thenReturn(defaultRequestLocation1);
        PowerMockito.whenNew(RequestLocation.class).withArguments("1287", "defaultLondon", 33.96, 332.11, -100.0).thenReturn(defaultRequestLocation2);

        PowerMockito.mockStatic(EmbeddedInputStreamProvider.class);
        Mockito.when(EmbeddedInputStreamProvider.getInstance()).thenReturn(provider);
        Mockito.when(provider.getInputStream(EMBEDDED_REQUEST_LOCATIONS_FILE_PATH)).thenReturn(embeddedInputStream);
        PowerMockito.whenNew(InputSource.class).withArguments(embeddedInputStream).thenReturn(embeddedinputSource);
        Mockito.when(db.parse(embeddedinputSource)).thenReturn(embeddeddocument);

        Mockito.when(embeddeddocument.getChildNodes()).thenReturn(embeddeddocumentChildren);
        Mockito.when(embeddeddocumentChildren.getLength()).thenReturn(2);
        Mockito.when(embeddeddocumentChildren.item(0)).thenReturn(embeddednode0);
        Mockito.when(embeddeddocumentChildren.item(1)).thenReturn(embeddednode1);
        Mockito.when(embeddednode0.getNodeName()).thenReturn("Locations");
        Mockito.when(embeddednode1.getNodeName()).thenReturn("LocationsA");
        Mockito.when(embeddednode0.getChildNodes()).thenReturn(embeddedlocationsChildren);
        Mockito.when(embeddedlocationsChildren.getLength()).thenReturn(4);

        Mockito.when(embeddedlocationsChildren.item(0)).thenReturn(embeddedlocationsChild0);
        Mockito.when(embeddedlocationsChildren.item(1)).thenReturn(embeddedlocationsChild1);
        Mockito.when(embeddedlocationsChildren.item(2)).thenReturn(embeddedlocationsChild2);
        Mockito.when(embeddedlocationsChildren.item(3)).thenReturn(embeddedlocationsChild3);

        Mockito.when(embeddedlocationsChild0.getNodeName()).thenReturn("Location");
        Mockito.when(embeddedlocationsChild1.getNodeName()).thenReturn("Location");
        Mockito.when(embeddedlocationsChild2.getNodeName()).thenReturn("Location");
        Mockito.when(embeddedlocationsChild3.getNodeName()).thenReturn("LocationA");

        Mockito.when(embeddedlocationsChild0.getAttributes()).thenReturn(embeddedlocationAttributes0);
        Mockito.when(embeddedlocationsChild1.getAttributes()).thenReturn(embeddedlocationAttributes1);
        Mockito.when(embeddedlocationsChild2.getAttributes()).thenReturn(embeddedlocationAttributes2);

        Mockito.when(embeddedlocationAttributes0.getNamedItem("id")).thenReturn(embeddedidNode0);
        Mockito.when(embeddedlocationAttributes1.getNamedItem("id")).thenReturn(embeddedidNode1);
        Mockito.when(embeddedlocationAttributes2.getNamedItem("id")).thenReturn(embeddedidNode2);

        Mockito.when(embeddedlocationAttributes0.getNamedItem("name")).thenReturn(embeddednameNode0);
        Mockito.when(embeddedlocationAttributes1.getNamedItem("name")).thenReturn(embeddednameNode1);
        Mockito.when(embeddedlocationAttributes2.getNamedItem("name")).thenReturn(embeddednameNode2);

        Mockito.when(embeddedlocationAttributes0.getNamedItem("latitude")).thenReturn(embeddedlatitudeNode0);
        Mockito.when(embeddedlocationAttributes1.getNamedItem("latitude")).thenReturn(embeddedlatitudeNode1);
        Mockito.when(embeddedlocationAttributes2.getNamedItem("latitude")).thenReturn(embeddedlatitudeNode2);

        Mockito.when(embeddedlocationAttributes0.getNamedItem("longitude")).thenReturn(embeddedlongitudeNode0);
        Mockito.when(embeddedlocationAttributes1.getNamedItem("longitude")).thenReturn(embeddedlongitudeNode1);
        Mockito.when(embeddedlocationAttributes2.getNamedItem("longitude")).thenReturn(embeddedlongitudeNode2);

        Mockito.when(embeddedlocationAttributes0.getNamedItem("elevation")).thenReturn(embeddedelevationNode0);
        Mockito.when(embeddedlocationAttributes1.getNamedItem("elevation")).thenReturn(embeddedelevationNode1);
        Mockito.when(embeddedlocationAttributes2.getNamedItem("elevation")).thenReturn(null);

        Mockito.when(embeddedidNode0.getTextContent()).thenReturn("9843");
        Mockito.when(embeddedidNode1.getTextContent()).thenReturn("11765");
        Mockito.when(embeddedidNode2.getTextContent()).thenReturn("6562");

        Mockito.when(embeddednameNode0.getTextContent()).thenReturn("embeddedBangor");
        Mockito.when(embeddednameNode1.getTextContent()).thenReturn("embeddedManchester");
        Mockito.when(embeddednameNode2.getTextContent()).thenReturn("embeddedLondon");

        Mockito.when(embeddedlatitudeNode0.getTextContent()).thenReturn("812.0");
        Mockito.when(embeddedlatitudeNode1.getTextContent()).thenReturn("-129.76");
        Mockito.when(embeddedlatitudeNode2.getTextContent()).thenReturn("259.46");

        Mockito.when(embeddedlongitudeNode0.getTextContent()).thenReturn("99.775");
        Mockito.when(embeddedlongitudeNode1.getTextContent()).thenReturn("626.31");
        Mockito.when(embeddedlongitudeNode2.getTextContent()).thenReturn("70.17");

        Mockito.when(embeddedelevationNode0.getTextContent()).thenReturn("63.82");
        Mockito.when(embeddedelevationNode1.getTextContent()).thenReturn("172.09");

        PowerMockito.whenNew(RequestLocation.class).withArguments("9843", "embeddedBangor", 812.0, 99.775, 63.82).thenReturn(embeddedrequestLocation0);
        PowerMockito.whenNew(RequestLocation.class).withArguments("11765", "embeddedManchester", -129.76, 626.31, 172.09).thenReturn(embeddedrequestLocation1);
        PowerMockito.whenNew(RequestLocation.class).withArguments("6562", "embeddedLondon", 259.46, 70.17, -100.0).thenReturn(embeddedrequestLocation2);
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
    @Test(expected = UnsupportedOperationException.class)
    public void testLoad() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.TRUE);

        List<RequestLocation> result = instance.load(path, DEFAULT_REQUEST_LOCATIONS_FILE_PATH, EMBEDDED_REQUEST_LOCATIONS_FILE_PATH);
        assertEquals(Arrays.asList(requestLocation0, requestLocation1, requestLocation2), result);

        inOrder.verify(logger).info("\nTry to load request locations from apbbapath.");
        inOrder.verify(logger).info("The request locations has been successfully loaded from apbbapath.");

        //The results should not changable.
        result.remove(0);
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_from_default() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.FALSE);
        Mockito.when(defaultFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(Arrays.asList(defaultRequestLocation0, defaultRequestLocation1, defaultRequestLocation2), instance.load(path, DEFAULT_REQUEST_LOCATIONS_FILE_PATH, EMBEDDED_REQUEST_LOCATIONS_FILE_PATH));

        inOrder.verify(logger).info("\nTry to load request locations from apbbapath.");
        inOrder.verify(logger).warn("\nThe file, apbbapath, does NOT exist.");
        inOrder.verify(logger).info("Try to load request locations from " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ".");
        inOrder.verify(logger).info("The request locations has been successfully loaded from " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ".");
        inOrder.verify(logger).info("The request locations file has been copied to apbbapath.");

        PowerMockito.verifyStatic();
        FileUtils.copyFile(defaultFile, file);
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_from_default_Exception() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.FALSE);
        Mockito.when(defaultFile.isFile()).thenReturn(Boolean.TRUE);

        PowerMockito.doThrow(ioe).when(FileUtils.class);
        FileUtils.copyFile(defaultFile, file);

        assertEquals(Arrays.asList(defaultRequestLocation0, defaultRequestLocation1, defaultRequestLocation2), instance.load(path, DEFAULT_REQUEST_LOCATIONS_FILE_PATH, EMBEDDED_REQUEST_LOCATIONS_FILE_PATH));

        inOrder.verify(logger).info("\nTry to load request locations from apbbapath.");
        inOrder.verify(logger).warn("\nThe file, apbbapath, does NOT exist.");
        inOrder.verify(logger).info("Try to load request locations from " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ".");
        inOrder.verify(logger).info("The request locations has been successfully loaded from " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ".");
        inOrder.verify(logger).warn("Failed to copy the request locations file to apbbapath.", ioe);
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_from_embedded() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.FALSE);
        Mockito.when(defaultFile.isFile()).thenReturn(Boolean.FALSE);

        assertEquals(Arrays.asList(embeddedrequestLocation0, embeddedrequestLocation1, embeddedrequestLocation2), instance.load(path, DEFAULT_REQUEST_LOCATIONS_FILE_PATH, EMBEDDED_REQUEST_LOCATIONS_FILE_PATH));

        inOrder.verify(logger).info("\nTry to load request locations from apbbapath.");
        inOrder.verify(logger).warn("\nThe file, apbbapath, does NOT exist.");
        inOrder.verify(logger).info("Try to load request locations from " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ".");
        inOrder.verify(logger).warn("\nThe file, " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ", does NOT exist.");
        inOrder.verify(logger).info("Try to load request locations from the embedded location.");
        inOrder.verify(logger).info("The request locations has been successfully loaded from the embedded locaiton.");
        inOrder.verify(logger).info("The request locations file has been copied to dddfauutltttdPathth.");
        inOrder.verify(logger).info("The request locations file has been copied to apbbapath.");

        Mockito.verify(provider, Mockito.times(3)).getInputStream(EMBEDDED_REQUEST_LOCATIONS_FILE_PATH);

        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(embeddedInputStream, file);

        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(embeddedInputStream, defaultFile);
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_from_embedded_no_copying() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.FALSE);
        Mockito.when(defaultFile.isFile()).thenReturn(Boolean.FALSE);

        assertEquals(Arrays.asList(embeddedrequestLocation0, embeddedrequestLocation1, embeddedrequestLocation2), instance.load(DEFAULT_REQUEST_LOCATIONS_FILE_PATH, DEFAULT_REQUEST_LOCATIONS_FILE_PATH, EMBEDDED_REQUEST_LOCATIONS_FILE_PATH));

        inOrder.verify(logger).info("\nTry to load request locations from " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ".");
        inOrder.verify(logger).warn("\nThe file, " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ", does NOT exist.");
        inOrder.verify(logger).info("Try to load request locations from " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ".");
        inOrder.verify(logger).warn("\nThe file, " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ", does NOT exist.");
        inOrder.verify(logger).info("Try to load request locations from the embedded location.");
        inOrder.verify(logger).info("The request locations has been successfully loaded from the embedded locaiton.");
        inOrder.verify(logger).info("The request locations file has been copied to dddfauutltttdPathth.");

        PowerMockito.verifyStatic(Mockito.never());
        FileUtils.copyInputStreamToFile(embeddedInputStream, file);

        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(embeddedInputStream, defaultFile);
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_from_embedded_copying_exception() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.FALSE);
        Mockito.when(defaultFile.isFile()).thenReturn(Boolean.FALSE);

        PowerMockito.doThrow(ioe).when(FileUtils.class);
        FileUtils.copyInputStreamToFile(embeddedInputStream, file);

        assertEquals(Arrays.asList(embeddedrequestLocation0, embeddedrequestLocation1, embeddedrequestLocation2), instance.load(path, DEFAULT_REQUEST_LOCATIONS_FILE_PATH, EMBEDDED_REQUEST_LOCATIONS_FILE_PATH));

        inOrder.verify(logger).info("\nTry to load request locations from apbbapath.");
        inOrder.verify(logger).warn("\nThe file, apbbapath, does NOT exist.");
        inOrder.verify(logger).info("Try to load request locations from " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ".");
        inOrder.verify(logger).warn("\nThe file, " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ", does NOT exist.");
        inOrder.verify(logger).info("Try to load request locations from the embedded location.");
        inOrder.verify(logger).info("The request locations has been successfully loaded from the embedded locaiton.");
        inOrder.verify(logger).info("The request locations file has been copied to dddfauutltttdPathth.");
        inOrder.verify(logger).warn("Failed to copy the request locations file to apbbapath.", ioe);

        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(embeddedInputStream, defaultFile);
    }
}
