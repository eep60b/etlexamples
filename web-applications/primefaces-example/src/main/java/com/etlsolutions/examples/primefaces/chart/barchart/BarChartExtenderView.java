package com.etlsolutions.examples.primefaces.chart.barchart;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author zc
 */
@ManagedBean
@ViewScoped
public class BarChartExtenderView implements Serializable {

    private static final long serialVersionUID = 1L;

    public BarChartModel getBarChartModel() {

        BarChartModel model = new BarChartModel();
        ChartSeries chartSeries = new BarChartSeries();
        chartSeries.set("car", 1222);
        chartSeries.set("bus", 3323);
        model.addSeries(chartSeries);
        model.setExtender("ext");
        return model;
    }
}
