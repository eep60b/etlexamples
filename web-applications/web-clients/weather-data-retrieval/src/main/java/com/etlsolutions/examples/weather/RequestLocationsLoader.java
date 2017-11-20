package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestLocation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * The RequestLocationsLoader class load locations from a request-locations.xml
 * file.
 *
 * @author zc
 */
public final class RequestLocationsLoader {

    private static final RequestLocationsLoader INSTANCE = new RequestLocationsLoader();

    public RequestLocationsLoader() {
    }

    public static final RequestLocationsLoader getInstance() {
        return INSTANCE;
    }

    public List<RequestLocation> load(String path) throws ParserConfigurationException, SAXException, IOException {

        List<RequestLocation> locaitons;
        Logger logger = Logger.getLogger(RequestLocationsLoader.class);

        logger.info("\nTry to load request locations from " + path + ".");

        File file = new File(path);

        if (file.isFile()) {
            locaitons = loadFile(new FileInputStream(file));
        } else {
            logger.warn("\nThe file, " + path + ", does NOT exist.");
            logger.info("Try to load request locations from " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ".");

            File defaultFile = new File(DEFAULT_REQUEST_LOCATIONS_FILE_PATH);

            if (defaultFile.isFile()) {
                locaitons = loadFile(new FileInputStream(defaultFile));
            } else {
                logger.warn("\nThe file, " + DEFAULT_REQUEST_LOCATIONS_FILE_PATH + ", does NOT exist.");
                logger.info("Try to load request locations from the embedded location.");
                locaitons = loadFile(RequestLocationsLoader.class.getResourceAsStream(EMBEDDED_LOCATIONS_FILE_PATH));
            }
        }

        logger.info("The request locations has been successfully loaded.");
        return locaitons;
    }

    private List<RequestLocation> loadFile(InputStream in) throws ParserConfigurationException, SAXException, IOException {

        List<RequestLocation> locaitons = new ArrayList<>();
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource(in);
        Document doc = db.parse(is);
        NodeList documentChildren = doc.getChildNodes();

        for (int i = 0; i < documentChildren.getLength(); i++) {

            Node node = documentChildren.item(i);
            if (node.getNodeName().equals("Locations")) {
                NodeList locationsChildren = node.getChildNodes();
                for (int j = 0; j < locationsChildren.getLength(); j++) {
                    Node locationsChild = locationsChildren.item(j);
                    if (locationsChild.getNodeName().endsWith("Location")) {
                        NamedNodeMap locationAttributes = locationsChild.getAttributes();
                        String id = locationAttributes.getNamedItem("id").getTextContent();
                        String name = locationAttributes.getNamedItem("name").getTextContent();
                        double latitude = Double.parseDouble(locationAttributes.getNamedItem("latitude").getTextContent());
                        double longitude = Double.parseDouble(locationAttributes.getNamedItem("longitude").getTextContent());
                        Node elevationAttribute = locationAttributes.getNamedItem("elevation");
                        double elevation = Double.parseDouble(elevationAttribute == null ? "-1.0" : elevationAttribute.getTextContent());

                        locaitons.add(new RequestLocation(id, name, latitude, longitude, elevation));
                    }
                }
            }
        }

        return Collections.unmodifiableList(locaitons);
    }
}
