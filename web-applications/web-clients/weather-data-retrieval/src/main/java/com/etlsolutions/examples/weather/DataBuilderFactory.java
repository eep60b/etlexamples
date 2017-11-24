package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestMethod;

/**
 * The DataBuilderFactory class is a factory class to create ResponseDataBuilder
 objects.
 *
 * @author zc
 */
public final class DataBuilderFactory {

    private static final DataBuilderFactory INSTANCE = new DataBuilderFactory();

    private DataBuilderFactory() {
    }

    /**
     * Get an instance of DataBuilderFactory.
     *
     * @return the DataBuilderFactory object.
     */
    public static final DataBuilderFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Create a ResponseDataBuilder object according to the the given request method.
     *
     * @param requestMethod - The specified request method.
     * @return the newly created ResponseDataBuilder object.
     */
    public ResponseDataBuilder createDataBuilder(RequestMethod requestMethod) {

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
