package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestConfig;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The ApplicationParameters class contains all parameters to run the
 * application.
 *
 * @author zc
 */
public final class ApplicationParameters {

    private final String configFilePath;
    private final String dataDirectoryPath;
    private final List<RequestConfig> requestConfigs;
    private final List<String> additionalDataDirectoryPaths = new ArrayList<>();
    private final String dataEncoding;
    private final String dataFileExtension;
    private final long intervalMiliSeconds;
    private final SimpleDateFormat datetimeFormat;
    private final String delimiter;

    public ApplicationParameters(String configFilePath, String dataDirectoryPath, List<RequestConfig> requestConfigs, String[] additionalDataDirectoryPaths,
            String dataEncoding, String dataFileExtension, String intervalInMinutes, String datetimeFormat, String delimiter) {

        this.configFilePath = new File(configFilePath).getAbsolutePath();
        this.dataDirectoryPath = new File(dataDirectoryPath).getAbsolutePath();
        this.requestConfigs = Collections.unmodifiableList(requestConfigs);

        for (String path : additionalDataDirectoryPaths) {
            if (path != null && !path.trim().isEmpty()) {
                this.additionalDataDirectoryPaths.add(new File(path).getAbsolutePath());
            }
        }

        this.dataEncoding = dataEncoding;
        this.dataFileExtension = dataFileExtension;
        this.intervalMiliSeconds = MILI_SECONDS_PER_MINUTE * Long.parseLong(intervalInMinutes);
        this.datetimeFormat = new SimpleDateFormat(datetimeFormat);
        this.delimiter = delimiter;
    }

    public String getConfigFilePath() {
        return configFilePath;
    }

    public String getDataDirectoryPath() {
        return dataDirectoryPath;
    }

    public List<RequestConfig> getRequestConfigs() {
        return requestConfigs;
    }

    public List<String> getAdditionalDataDirectoryPaths() {
        return Collections.unmodifiableList(additionalDataDirectoryPaths);
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

    public DateFormat getDatetimeFormat() {
        return datetimeFormat;
    }

    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.configFilePath);
        hash = 59 * hash + Objects.hashCode(this.dataDirectoryPath);
        hash = 59 * hash + Objects.hashCode(this.requestConfigs);
        hash = 59 * hash + Objects.hashCode(this.additionalDataDirectoryPaths);
        hash = 59 * hash + Objects.hashCode(this.dataEncoding);
        hash = 59 * hash + Objects.hashCode(this.dataFileExtension);
        hash = 59 * hash + (int) (this.intervalMiliSeconds ^ (this.intervalMiliSeconds >>> 32));
        hash = 59 * hash + Objects.hashCode(this.datetimeFormat);
        hash = 59 * hash + Objects.hashCode(this.delimiter);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final ApplicationParameters other = (ApplicationParameters) obj;
        if (!Objects.equals(this.configFilePath, other.configFilePath)) {
            return false;
        }
        if (!Objects.equals(this.dataDirectoryPath, other.dataDirectoryPath)) {
            return false;
        }
        if (!Objects.equals(this.requestConfigs, other.requestConfigs)) {
            return false;
        }
        if (!Objects.equals(this.additionalDataDirectoryPaths, other.additionalDataDirectoryPaths)) {
            return false;
        }
        if (!Objects.equals(this.dataEncoding, other.dataEncoding)) {
            return false;
        }
        if (!Objects.equals(this.dataFileExtension, other.dataFileExtension)) {
            return false;
        }
        if (this.intervalMiliSeconds != other.intervalMiliSeconds) {
            return false;
        }
        if (!Objects.equals(this.datetimeFormat, other.datetimeFormat)) {
            return false;
        }
        return Objects.equals(this.delimiter, other.delimiter);
    }

    
    
    
    @Override
    public String toString() {
        return "Configuration file =       " + configFilePath + "\n"
                + "Request configs =          " + requestConfigs + "\n"
                + "Data file directory =      " + dataDirectoryPath + "\n"
                + "Addtional data directory = " + additionalDataDirectoryPaths + "\n"
                + "Data encoding  =           " + dataEncoding + "\n"
                + "Data file extension  =     " + dataFileExtension + "\n"
                + "Interval in minutes  =     " + intervalMiliSeconds/MILI_SECONDS_PER_MINUTE + "\n"
                + "Date time format =         " + datetimeFormat.toLocalizedPattern() + "\n"
                + "Delimiter =                [" + delimiter + "]";
    }
}
