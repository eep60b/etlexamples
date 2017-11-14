/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ForecastData;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author zc
 */
public final class DataFileReader {

    @SuppressWarnings("NestedAssignment")
    public static final List<ForecastData> readData(File file) throws IOException {
        
        List<ForecastData> list = new VirtualFlow.ArrayLinkedList<>();
        
        if (file.isFile()) {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {

                    ForecastData f = ForecastDataBuilder.build(line);
                    if(f != null) {
                        list.add(f);
                    }
                }
            }
        }
        
        return list;
    }
}
