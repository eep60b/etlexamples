package com.etlsolutions.examples.weather;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The ApplicationParameters class contains all parameters to run the
 * application.
 *
 * @author zc
 */
public final class ApplicationParameters {

    private final String dataDirectoryPath;
    private final String url;
    private final String forecastMethod;
    private final Date startTime;
    private final Date stopTime;
    private final boolean runMultiple;
    private final String[] addtionalDataPaths;
    private final String dataEncoding;
    private final String dataFilePrefix;
    private final String dataFileExtension;
    private final long intervalMiliSeconds;

    public ApplicationParameters(String dataDirectoryPath, String url, String forecastMethod, Date startTime, Date stopTime, boolean runMultiple, String[] addtionalDataPaths,
            String dataEncoding, String dataFilePrefix, String dataFileExtension, String intervalInMinutes) {

        this.dataDirectoryPath = dataDirectoryPath;
        this.url = url;
        this.forecastMethod = forecastMethod;
        this.startTime = new Date(startTime.getTime());
        this.stopTime = stopTime == null ? null : new Date(stopTime.getTime());
        this.runMultiple = runMultiple;
        this.addtionalDataPaths = addtionalDataPaths;
        this.dataEncoding = dataEncoding;
        this.dataFileExtension = dataFileExtension;
        this.dataFilePrefix = dataFilePrefix;
        this.intervalMiliSeconds = 60 * 1000 * Long.parseLong(intervalInMinutes);
    }

    public String getDataDirectoryPath() {
        return dataDirectoryPath;
    }

    public String getUrl() {
        return url;
    }

    public String getForecastMethod() {
        return forecastMethod;
    }

    public Date getStartTime() {
        return new Date(startTime.getTime());
    }

    public Date getStopTime() {
        return stopTime == null ? null : new Date(stopTime.getTime());
    }

    public boolean isRunMultiple() {
        return runMultiple;
    }

    public List<String> getAddtionalDataPaths() {
        return Collections.unmodifiableList(Arrays.asList(addtionalDataPaths));
    }

    public String getDataEncoding() {
        return dataEncoding;
    }

    public String getDataFilePrefix() {
        return dataFilePrefix;
    }

    public String getDataFileExtension() {
        return dataFileExtension;
    }

    public long getIntervalMiliSeconds() {
        return intervalMiliSeconds;
    }

    @Override
    public String toString() {
        return    "dataDirectoryPath = " + dataDirectoryPath + "\n"
                + "URL = " + url + "\n"
                + "forecastMethod = " + forecastMethod + "\n"
                + "startTime = " + startTime + "\n"
                + "stopTime  = " + stopTime + "\n"
                + "runMultiple  = " + runMultiple + "\n"
                + "addtionalDataPaths  = " + Arrays.toString(addtionalDataPaths) + "\n"
                + "dataEncoding  = " + dataEncoding + "\n"
                + "dataFileExtension  = " + dataFileExtension + "\n"
                + "dataFilePrefix  = " + dataFilePrefix + "\n"
                + "intervalMiliSeconds  = " + intervalMiliSeconds / 60 / 1000;
    }

}
