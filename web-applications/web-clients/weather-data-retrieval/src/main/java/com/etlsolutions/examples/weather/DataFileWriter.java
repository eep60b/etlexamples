package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ForecastData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * The DataFileWriter class write data to local hard drive.
 * @author zc
 */
public final class DataFileWriter {

    public static final void write(List<ForecastData> list, File file) throws IOException {
        StringBuilder builder = new StringBuilder();
        list.stream().forEach((data) -> {
            builder.append(data.getOutputString()).append("\n");
        });
        
        String content = new String(builder).substring(0, builder.length() - 2);
        
        FileUtils.writeStringToFile(file, content, "ASCII", false);
    }
    
}
