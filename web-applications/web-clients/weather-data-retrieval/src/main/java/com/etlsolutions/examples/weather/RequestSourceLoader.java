package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.RequestSource;
import com.etlsolutions.examples.weather.data.RequestToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * The
 *
 * @author zc
 */
public final class RequestSourceLoader {

    private static final RequestSourceLoader INSTANCE = new RequestSourceLoader();

    private RequestSourceLoader() {
    }
    
    public static final RequestSourceLoader getInstance() {
        return INSTANCE;
    }
    
    public List<RequestSource> load(String resourcePropertiesFilesPath, String requestLocationsPath) throws ParserConfigurationException, SAXException, IOException {

        List<RequestLocation> locations = RequestLocationsLoader.getInstance().load(requestLocationsPath);
        List<Properties> propertieses = new ArrayList<>();
        List<RequestSource> list = new ArrayList<>();

        File resourcePropertiesFiles = new File(resourcePropertiesFilesPath);
        
        if (resourcePropertiesFiles.isFile()) {

            Properties properties = new Properties();
            properties.load(new FileInputStream(resourcePropertiesFiles));
            propertieses.add(properties);

        } else {

            File[] files = resourcePropertiesFiles.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(RESOURCES_PROPERTIES_FILE_EXTENSION )) {
                    Properties properties = new Properties();
                    properties.load(new FileInputStream(file));
                    propertieses.add(properties);
                }
            }
        }

        propertieses.stream().forEach((properties) -> {
            String locationId = properties.getProperty(LOCATION_TOKEN);
            RequestLocation location = getRequestLocation(locationId, locations);
            RequestMethod requesttMethod = RequestMethod.getRequesttMethod(properties.getProperty(REQUEST_METHOD_TOKEN), properties.getProperty(REQUEST_INTERVAL_TOKEN));
            RequestToken requestToken = new RequestToken(properties.getProperty(REQUEST_TOEKN));
            list.add(new RequestSource(requesttMethod, location, requestToken));
        });
        
        return Collections.unmodifiableList(list);
    }

    private RequestLocation getRequestLocation(String locationId, List<RequestLocation> locations) {

        for (RequestLocation location : locations) {
            if (location.getId().equals(locationId)) {
                return location;
            }
        }

        throw new IllegalArgumentException("Invald location ID: " + locationId);
    }
}
