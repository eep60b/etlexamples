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
        double la = 53.214571;
        double lo =  -4.151543;
        
        List<RequestLocation> locations = new ArrayList<>(RequestLocationsLoader.getInstance().load(DEFAULT_REQUEST_LOCATIONS_FILE_PATH));
        
        Collections.sort(locations, new DistanceComparator(la, lo));
        
        locations.stream().forEach((location) -> {
            System.out.println(location);
        });
    }
}
