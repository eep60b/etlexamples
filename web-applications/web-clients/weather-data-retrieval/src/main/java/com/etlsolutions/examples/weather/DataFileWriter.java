package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.DATA_LOGGING_DIRECTORY_PATH;
import com.etlsolutions.examples.weather.data.ResponseData;
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

    /**
     * Write the list of data to the files using the given character encoding.
     * @param list - The data list.
     * @param file - The main file.
     * @param additionalFiles - The additional files.
     * @param dataEncoding - The encoding.
     * @param titleAdditional - The additional information to add to the titles. 
     * @throws IOException if one of the files cannot be written.
     */
    public void write(List<ResponseData> list, File file, List<File> additionalFiles, String dataEncoding, String titleAdditional) throws IOException {
        
        StringBuilder builder = new StringBuilder();
        list.stream().forEach((data) -> {
            
            //Add an title before the added data.
            if (builder.length() == 0) {
                builder.append(data.getTitle(titleAdditional)).append("\n");
            }

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
