/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author zc
 */
@Embeddable
public class DateInclusionsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "schedule_id")
    private int scheduleId;
    @Basic(optional = false)
    @Column(name = "day")
    private long day;

    public DateInclusionsPK() {
    }

    public DateInclusionsPK(int scheduleId, long day) {
        this.scheduleId = scheduleId;
        this.day = day;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) scheduleId;
        hash += (int) day;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DateInclusionsPK)) {
            return false;
        }
        DateInclusionsPK other = (DateInclusionsPK) object;
        if (this.scheduleId != other.scheduleId) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.DateInclusionsPK[ scheduleId=" + scheduleId + ", day=" + day + " ]";
    }
    
}
