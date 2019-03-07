package com.etlsolutions.examples.primefaces.chart.barchart;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author zc
 */
@ManagedBean
@ViewScoped
public class LineChartPointsColourView implements Serializable {
 
    private static final long serialVersionUID = 1L;    

    private LineChartModel lineModel;

 
    @PostConstruct
    public void init() {

        createLineModel();

    }

    private void createLineModel() {
        lineModel = new LineChartModel();
 
        LineChartSeries boys1 = new LineChartSeries();
        boys1.setLabel("Boys");
        boys1.set(2000, 120);
        boys1.set(4000, 100);
        boys1.set(6000, 44);
        boys1.set(12000, 150);
        boys1.set(20000, 25);

        LineChartSeries boys2 = new LineChartSeries();
        boys2.set(2000, 120);
        boys2.set(12000, 150);        
        
        LineChartSeries boys3 = new LineChartSeries();
        boys3.set(4000, 100);
        boys3.set(6000, 44);
        boys3.set(20000, 25);        
        
        boys1.setShowMarker(false);
        boys2.setShowLine(false);
        boys3.setShowLine(false);
        
        lineModel.addSeries(boys1);
        lineModel.addSeries(boys2);
        lineModel.addSeries(boys3);   
        lineModel.setSeriesColors("000000,00FF00,FF0000");  //FFCC33 is yellow. 58BA27 is greenish. F74A4A is redish, A30303 is brown.
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

}