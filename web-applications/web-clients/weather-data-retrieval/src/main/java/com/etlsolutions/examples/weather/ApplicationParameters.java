package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestSource;
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
    private final List<RequestSource> requestSources; 
    private final Date startTime;
    private final Date stopTime;
    private final boolean runMultiple;
    private final String[] addtionalDataPaths;
    private final String dataEncoding;
    private final String dataFileExtension;
    private final long intervalMiliSeconds;

    public ApplicationParameters(String dataDirectoryPath, List<RequestSource> requestSources, Date startTime, Date stopTime, boolean runMultiple, String[] addtionalDataPaths,
            String dataEncoding, String dataFileExtension, String intervalInMinutes) {

        this.dataDirectoryPath = dataDirectoryPath;
        this.requestSources = Collections.unmodifiableList(requestSources);
        this.startTime = new Date(startTime.getTime());
        this.stopTime = stopTime == null ? null : new Date(stopTime.getTime());
        this.runMultiple = runMultiple;
        this.addtionalDataPaths = addtionalDataPaths;
        this.dataEncoding = dataEncoding;
        this.dataFileExtension = dataFileExtension;
        this.intervalMiliSeconds = 60 * 1000 * Long.parseLong(intervalInMinutes);
    }

    public String getDataDirectoryPath() {
        return dataDirectoryPath;
    }

    public List<RequestSource> getRequestSources() {
        return requestSources;
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

    public String getDataFileExtension() {
        return dataFileExtension;
    }

    public long getIntervalMiliSeconds() {
        return intervalMiliSeconds;
    }

    @Override
    public String toString() {
        return    "dataDirectoryPath = " + dataDirectoryPath + "\n"
                + "Request sources = " + requestSources + "\n"
                + "startTime = " + startTime + "\n"
                + "stopTime  = " + stopTime + "\n"
                + "runMultiple  = " + runMultiple + "\n"
                + "addtionalDataPaths  = " + Arrays.toString(addtionalDataPaths) + "\n"
                + "dataEncoding  = " + dataEncoding + "\n"
                + "dataFileExtension  = " + dataFileExtension + "\n"
                + "interval in minutes  = " + intervalMiliSeconds / 60 / 1000;
    }

}
