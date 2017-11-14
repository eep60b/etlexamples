/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.mainwebapp.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author zc
 */
//TODO:
@Named("bookSearchController")
@SessionScoped
public class BookSearchController implements Serializable {
    
    private String searchString;

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }   
    
    public void searchByTitle(String searchString) {
        
    }
    
    public void showResult() {
        
    }
}
