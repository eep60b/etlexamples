/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.primefaces.chart.linechart;

import com.etlsolutions.examples.data.RandomSerialDataGenerator;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Zhipeng Chang
 *
 */
@ManagedBean(name = "lineChartSizeView")
@ViewScoped
public class LineChartSizeView implements Serializable {

    private static final long serialVersionUID = 314459040802163669L;

    private LineChartModel newBookLineChartModel = new LineChartModel();
    private LineChartModel usedBookLineChartModel = new LineChartModel();

    /**
     * Initialise the properties.
     */
    @PostConstruct
    public void init() {
        RandomSerialDataGenerator generator = new RandomSerialDataGenerator();
        int newBooks = 100;
        int maxNewBookNumber = 100;
        List<Integer> newBookNumbers = generator.getDataList(maxNewBookNumber, newBooks);
        LineChartSeries newSeries = new LineChartSeries();
        for (int i = 0; i < newBooks; i++) {
            newSeries.set(i + 1, newBookNumbers.get(i));
        }

        newBookLineChartModel.addSeries(newSeries);

        int usedBooks = 50;
        int maxUsedBookNumber = 100;
        List<Integer> usedBookNumbers = generator.getDataList(maxUsedBookNumber, newBooks);
        LineChartSeries usedSeries = new LineChartSeries();
        for (int i = 0; i < usedBooks; i++) {
            usedSeries.set(i + 1, usedBookNumbers.get(i));
        }

        usedBookLineChartModel.addSeries(usedSeries);
    }

    /**
     * Get the data model for the new book line chart.
     * @return the LineChartModel object.
     */
    public LineChartModel getNewBookLineChartModel() {
        return newBookLineChartModel;
    }
    
    
    /**
     * Set the data model for the new book line chart.
     * @param newBookLineChartModel - The LineChartModel object to be used.
     */
    public void setNewBookLineChartModel(LineChartModel newBookLineChartModel) {
        this.newBookLineChartModel = newBookLineChartModel;
    }


    /**
     * Get the data model for the used book line chart.
     * @return the LineChartModel object.
     */    
    public LineChartModel getUsedBookLineChartModel() {
        return usedBookLineChartModel;
    }
    
    /**
     * Set the data model for the used book line chart.
     * @param usedBookLineChartModel - The LineChartModel object to be used.
     */
    public void setUsedBookLineChartModel(LineChartModel usedBookLineChartModel) {
        this.usedBookLineChartModel = usedBookLineChartModel;
    }

}
