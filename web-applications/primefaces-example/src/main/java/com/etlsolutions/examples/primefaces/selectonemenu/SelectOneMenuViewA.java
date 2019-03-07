package com.etlsolutions.examples.primefaces.selectonemenu;

import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
 
/**
 * 
 * @author zc
 */
@ManagedBean
public class SelectOneMenuViewA {
   
    private String theme;   
    private List<String> themes;
     
    @PostConstruct
    public void init() {        
        themes = Arrays.asList("a", "b", "c");
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<String> getThemes() {
        return themes;
    }
}