package com.etlsolutions.examples.primefaces.selectcheckboxmenu;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean        //Don't use @Named here, it does NOT work.
@ViewScoped
public class CheckboxView {
         
    private String[] selectedCities = {"Barcelona"};
    private List<String> cities;
     
    @PostConstruct
    public void init() {
        cities = new ArrayList<>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Brasilia");
        cities.add("Amsterdam");
    }
 
    public String[] getSelectedCities() {
        return selectedCities;
    }
 
    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }
    
    public List<String> getCities() {
        return cities;
    }
    
    public int getSelectedCityNumbers() {
        
        if(selectedCities == null) {
            return 0;
        }
        
        return selectedCities.length;
    }
}