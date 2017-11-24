package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.RequesConfig;
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
 * The RequestConfigLoader class loads the request resources from disk.
 *
 * @author zc
 */
public final class RequestConfigLoader {

    private static final RequestConfigLoader INSTANCE = new RequestConfigLoader();

    private RequestConfigLoader() {
    }
    
    public static final RequestConfigLoader getInstance() {
        return INSTANCE;
    }
    
    public List<RequesConfig> load(String resourcePropertiesFilesPath, String requestLocationsPath) throws ParserConfigurationException, SAXException, IOException {

        List<RequestLocation> locations = RequestLocationsLoader.getInstance().load(requestLocationsPath);
        
        List<Properties> propertieses = new ArrayList<>();
        List<RequesConfig> list = new ArrayList<>();

        File resourcePropertiesFiles = new File(resourcePropertiesFilesPath);
        
        if (resourcePropertiesFiles.isFile()) {

            Properties properties = new Properties();
            properties.load(new FileInputStream(resourcePropertiesFiles));
            propertieses.add(properties);

        } else if (resourcePropertiesFiles.isDirectory()) {

            File[] files = resourcePropertiesFiles.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(RESOURCES_PROPERTIES_FILE_EXTENSION )) {
                    Properties properties = new Properties();
                    properties.load(new FileInputStream(file));
                    propertieses.add(properties);
                }
            }
        } else {
            throw new IOException("No valid resource properties files can be found at: " + resourcePropertiesFilesPath);
        } 

        if(propertieses.isEmpty()) {
            throw new IOException("There is no valid configuration fould in " + resourcePropertiesFilesPath);
        }
                
        propertieses.stream().forEach((properties) -> {
            String locationId = properties.getProperty(LOCATION_TOKEN);
            RequestLocation location = getRequestLocation(locationId, locations);
            RequestMethod requesttMethod = RequestMethod.getRequesttMethod(properties.getProperty(REQUEST_METHOD_TOKEN), properties.getProperty(REQUEST_INTERVAL_TOKEN));
            RequestToken requestToken = new RequestToken(properties.getProperty(REQUEST_TOEKN));
            list.add(new RequesConfig(requesttMethod, location, requestToken));
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
