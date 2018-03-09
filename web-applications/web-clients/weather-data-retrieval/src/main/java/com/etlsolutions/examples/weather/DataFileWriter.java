package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * The DataFileWriter class write data to local hard drive.
 *
 * @author zc
 */
public final class DataFileWriter {

    private static final DataFileWriter INSTANCE = new DataFileWriter();

    private final DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
    private final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
    private DataFileWriter() {
    }

    /**
     * 
     * @return 
     */
    public static final DataFileWriter getInstance() {
        return INSTANCE;
    }

    /**
     * Write the list of data to the files using the given character encoding.
     *
     * @param xmlContent - The XML content which downloaded from met office web site.
     * @param list - The data list.
     * @param file - The main file.
     * @param additionalFiles - The additional files.
     * @param parameters - The parameters.
     * @param titleAdditional - The additional information to add to the titles.
     * @throws IOException if one of the files cannot be written.
     */
    public void write(String xmlContent, List<ResponseData> list, File file, List<File> additionalFiles, ApplicationParameters parameters, String titleAdditional) throws IOException {

        StringBuilder builder = new StringBuilder();

        for (ResponseData data : list) {

            //Add an title before the added data.
            if (builder.length() == 0) {
                builder.append(data.getTitle(parameters.getDelimiter(), titleAdditional)).append("\n");
            }

            builder.append(data.getOutputString(parameters.getDatetimeFormat(), parameters.getDelimiter())).append("\n");
        }

        String content = new String(builder).substring(0, builder.length() - 1);

        String dataEncoding = parameters.getDataEncoding();
        FileUtils.writeStringToFile(file, content, dataEncoding, false);

        Date currentTime = new Date();

        for (File additionFile : additionalFiles) {
            try {
                FileUtils.writeStringToFile(additionFile, content, dataEncoding, false);
            } catch (IOException ex) {
                Logger.getLogger(DataFileWriter.class).warn("Failed to write the additional file: " + additionFile.getAbsolutePath(), ex);
            }
        }

        File dataLogFile = new File(parameters.getDataDirectoryPath() + File.separator + "log" + File.separator + "datalog" + File.separator + dateFormat.format(currentTime) + ".log");
        FileUtils.writeStringToFile(dataLogFile, "\n\nData recorded at " + timeFormat.format(currentTime) + "\n" + xmlContent, dataEncoding, true);
    }
}
