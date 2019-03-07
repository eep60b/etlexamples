package com.etlsolutions.examples.primefaces.selectonemenu;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
 
/**
 * 
 * @author zc
 */
@ManagedBean
public class SelectOneMenuView {
   
    private Theme theme;   
    private List<Theme> themes;
     
    @ManagedProperty("#{themeService}")
    private ThemeService service;
     
    @PostConstruct
    public void init() {
        //themes
        themes = service.getThemes();
    }
 
    public Theme getTheme() {
        return theme;
    }
 
    public void setTheme(Theme theme) {
        this.theme = theme;
    }
     

    public List<Theme> getThemes() {
        return themes;
    }
     
    public void setService(ThemeService service) {
        this.service = service;
    }
    
    public String getThemeDisplayName(Theme theme){
        return theme == null ? "Not Specified" : theme.getName();
    }
}