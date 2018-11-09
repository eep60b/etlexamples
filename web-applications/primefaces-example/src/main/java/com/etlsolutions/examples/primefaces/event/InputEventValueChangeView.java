package com.etlsolutions.examples.primefaces.event;

import java.util.Date;
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

    private Date startDate = new Date();
    
    private String startDateString = "12/2008";

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    @SuppressWarnings("ReturnOfDateField")
    public Date getStartDate() {
        return startDate;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
    
}
