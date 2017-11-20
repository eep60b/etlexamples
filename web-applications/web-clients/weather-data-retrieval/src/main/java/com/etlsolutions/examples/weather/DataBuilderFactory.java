package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestMethod;

/**
 *
 * @author zc
 */
public final class DataBuilderFactory {

    private static final DataBuilderFactory INSTANCE = new DataBuilderFactory();

    private DataBuilderFactory() {
    }

    public static final DataBuilderFactory getInstance() {
        return INSTANCE;
    }

    public DataBuilder createDataBuilder(RequestMethod requestMethod) {

        switch (requestMethod) {

            case FCS_3HOURLY:
                return new Wxfcs3hourlyDataBuilder();
            case OBS_HOURLY:
                return new WxobsHourlyDataBuilder();
            default:
                throw new IllegalArgumentException("Invalid request method: " + requestMethod);
        }
    }

}
