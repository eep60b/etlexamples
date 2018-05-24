/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.primefaces.datatable.selection;

import com.etlsolutions.examples.primefaces.data.Car;
import com.etlsolutions.examples.primefaces.data.CarService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
 
@ManagedBean(name="dtSelectionView")
@ViewScoped
public class DtSelectionView implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private List<Car> cars6;
    private Car selectedCar;
    private List<Car> selectedCars;
    
    @ManagedProperty("#{carService}")
    private CarService service;
     
    @PostConstruct
    public void init() {
        cars6 = service.createCars(10);
    }

 
    public List<Car> getCars() {
        return cars6;
    }
     
    public void setService(CarService service) {
        this.service = service;
    }
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
 
    public List<Car> getSelectedCars() {
        return selectedCars;
    }
 
    public void setSelectedCars(List<Car> selectedCars) {
        this.selectedCars = selectedCars;
    }
     
    public int getSelectedCarNumber() {
        return selectedCars == null ? 0 : selectedCars.size();
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}