package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ForecastData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The DataFileReader class create the data file if it exists into a list of
 * ForecastData.
 *
 * @author zc
 */
public final class DataFileReader {

    @SuppressWarnings("NestedAssignment")
    public static final List<ForecastData> readData(File file) throws IOException {

        List<ForecastData> list = new ArrayList<>();

        if (file.isFile()) {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {

                    ForecastData f = ForecastDataBuilder.build(line);
                    if (f != null) {
                        list.add(f);
                    }
                }
            }
        }

        return list;
    }
}
