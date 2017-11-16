package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.DATA_LOGGING_DIRECTORY_PATH;
import com.etlsolutions.examples.weather.data.ForecastData;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * The DataFileWriter class write data to local hard drive.
 *
 * @author zc
 */
public final class DataFileWriter {

    private static final DataFileWriter INSTANCE = new DataFileWriter();
    
    private DataFileWriter() {
    }

    private final DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
    
    public static final DataFileWriter getInstance() {
        return INSTANCE;
    }
    
    public void write(List<ForecastData> list, File file, List<File> additionalFiles, String dataEncoding) throws IOException {
        StringBuilder builder = new StringBuilder();
        list.stream().forEach((data) -> {
            builder.append(data.getOutputString()).append("\n");
        });

        String content = new String(builder).substring(0, builder.length() - 1);
        
        FileUtils.writeStringToFile(file, content, dataEncoding, false);
        
        Date currentTime = new Date();
        
        File dataLogFile = new File(DATA_LOGGING_DIRECTORY_PATH + File.separator + dateFormat.format(currentTime) + ".log");
        FileUtils.writeStringToFile(dataLogFile, "\n\n\nData updated at: " + currentTime + "\n\n" + content, dataEncoding, true);        
        
        for (File additionFile : additionalFiles) {
            FileUtils.writeStringToFile(additionFile, content, dataEncoding, false);
        }
    }
}
