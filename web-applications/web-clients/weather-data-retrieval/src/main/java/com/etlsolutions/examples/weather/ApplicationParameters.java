package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequesConfig;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The ApplicationParameters class contains all parameters to run the
 * application.
 *
 * @author zc
 */
public final class ApplicationParameters {

    private final String configFilePath;
    private final String dataDirectoryPath;
    private final List<RequesConfig> requestConfigs;
    private final List<String> additionalDataDirectoryPaths = new ArrayList<>();
    private final String dataEncoding;
    private final String dataFileExtension;
    private final long intervalMiliSeconds;
    private final SimpleDateFormat datetimeFormat;
    private final String delimiter;

    public ApplicationParameters(String configFilePath, String dataDirectoryPath, List<RequesConfig> requestConfigs, String[] additionalDataDirectoryPaths,
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

    public List<RequesConfig> getRequestConfigs() {
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
