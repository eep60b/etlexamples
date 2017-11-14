package com.etlsolutions.examples.weather;

import java.util.Date;

/**
 *
 * @author zc
 */
public final class ApplicationParameters {

    private final String dataDirectoryPath;
    private final String url;
    private final String forecastMethod;
    private final Date startDate;
    private final Date stopDate;
    
    public ApplicationParameters(String dataDirectoryPath, String url, String forecastMethod, Date startDate, Date stopDate) {
        
        this.dataDirectoryPath = dataDirectoryPath;
        this.url = url;
        this.forecastMethod = forecastMethod;
        this.startDate = new Date(startDate.getTime());
        this.stopDate = new Date(startDate.getTime());
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

    public Date getStartDate() {
        return new Date(startDate.getTime());
    }

    public Date getStopDate() {
        return new Date (stopDate.getTime());
    }
}
