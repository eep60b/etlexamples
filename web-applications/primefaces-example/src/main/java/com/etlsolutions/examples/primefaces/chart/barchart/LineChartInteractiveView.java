package com.etlsolutions.examples.primefaces.chart.barchart;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author zc
 */
@ManagedBean
@ViewScoped
public class LineChartInteractiveView implements Serializable {
 
    private static final long serialVersionUID = 1L;    

    private LineChartModel lineModel;

 
    @PostConstruct
    public void init() {

        createLineModel();

    }
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 

    private void createLineModel() {
        lineModel = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set(2000, 120);
        boys.set(4000, 100);
        boys.set(6000, 44);
        boys.set(12000, 150);
        boys.set(20000, 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set(1000, 52);
        girls.set(5000, 60);
        girls.set(10000, 110);
        girls.set(15000, 90);
        girls.set(18000, 120);
 
        lineModel.addSeries(boys);
        lineModel.addSeries(girls);
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

}