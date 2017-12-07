package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author zc
 */
public final class NeaRequestLocationsFinder {
     
    public static void main(String[] args) throws Throwable {

        List<RequestLocation> locations = new ArrayList<>(RequestLocationsLoader.getInstance().load(DEFAULT_REQUEST_LOCATIONS_FILE_PATH));
        
        Collections.sort(locations, new DistanceComparator(DEFAULT_LATITUDE, DEFAULT_LONGITUDE));
        
        for (RequestLocation location : locations) {
            System.out.println(location);
        }
    }
}
