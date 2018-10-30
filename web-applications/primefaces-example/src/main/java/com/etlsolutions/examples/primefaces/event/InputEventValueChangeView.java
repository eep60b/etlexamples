package com.etlsolutions.examples.primefaces.event;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author zc
 */
@ManagedBean
@ViewScoped
public class InputEventValueChangeView {

    private static final long serialVersionUID = 958593203991107684L;

    private String startDateString = "12/2008";

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

}
