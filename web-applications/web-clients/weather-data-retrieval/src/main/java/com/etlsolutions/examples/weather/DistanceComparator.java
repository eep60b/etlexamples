package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestLocation;
import java.util.Comparator;

/**
 * The DistanceComparator class compares two locations according their latitude and longitude;
 * @author zc
 */
public class DistanceComparator implements Comparator<RequestLocation> {

    private final double latitude;
    private final double longitude;

    public DistanceComparator(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public int compare(RequestLocation r1, RequestLocation r2) {
        double d1 = (r1.getLatitude() - latitude) * (r1.getLatitude() - latitude) + (r1.getLongitude() - longitude) * (r1.getLongitude() - longitude);
        double d2 = (r2.getLatitude() - latitude) * (r2.getLatitude() - latitude) + (r2.getLongitude() - longitude) * (r2.getLongitude() - longitude);

        if (d1 - d2 > 0) {
            return 1;
        } else if (d1 - d2 == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
