package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
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

    private DataFileReader() {
    }

    /**
     * Get an instance of this class.
     *
     * @return the DataFileReader object.
     */
    public static final DataFileReader getInstance() {
        return INSTANCE;
    }

    /**
     * Read data from a base file.
     *
     * @param dataBuilder
     * @param file
     * @param parameters
     * @return
     * @throws IOException
     * @throws ParseException
     */
    @SuppressWarnings("NestedAssignment")
    public final List<ResponseData> readData(ResponseDataBuilder dataBuilder, File file, ApplicationParameters parameters) throws IOException, ParseException {

        List<ResponseData> list = new ArrayList<>();

        if (file.isFile()) {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                br.readLine();  //The first lis is the title. It is skipped.
                while ((line = br.readLine()) != null) {

                    ResponseData data = dataBuilder.build(line, parameters);
                    if (data != null) {
                        list.add(data);
                    }
                }
            }
        }

        return list;
    }
}
