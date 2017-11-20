package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The DataFileReader class create the data file if it exists into a list of
 * ResponseData.
 *
 * @author zc
 */
public final class DataFileReader {

    private static final DataFileReader INSTANCE = new DataFileReader();

    public DataFileReader() {
    }
    
    public static final DataFileReader getInstance() {
        return INSTANCE;
    }
    
    @SuppressWarnings("NestedAssignment")
    public final List<ResponseData> readData(DataBuilder dataBuilder, File file) throws IOException {

        List<ResponseData> list = new ArrayList<>();

        if (file.isFile()) {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {

                    ResponseData data = dataBuilder.build(line);
                    if (data != null) {
                        list.add(data);
                    }
                }
            }
        }

        return list;
    }
}
