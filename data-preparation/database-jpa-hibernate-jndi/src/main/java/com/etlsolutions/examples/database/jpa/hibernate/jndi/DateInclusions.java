/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "date_inclusions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DateInclusions.findAll", query = "SELECT d FROM DateInclusions d"),
    @NamedQuery(name = "DateInclusions.findByScheduleId", query = "SELECT d FROM DateInclusions d WHERE d.dateInclusionsPK.scheduleId = :scheduleId"),
    @NamedQuery(name = "DateInclusions.findByDay", query = "SELECT d FROM DateInclusions d WHERE d.dateInclusionsPK.day = :day")})
public class DateInclusions implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DateInclusionsPK dateInclusionsPK;
    @JoinColumn(name = "schedule_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Schedule schedule;

    public DateInclusions() {
    }

    public DateInclusions(DateInclusionsPK dateInclusionsPK) {
        this.dateInclusionsPK = dateInclusionsPK;
    }

    public DateInclusions(int scheduleId, long day) {
        this.dateInclusionsPK = new DateInclusionsPK(scheduleId, day);
    }

    public DateInclusionsPK getDateInclusionsPK() {
        return dateInclusionsPK;
    }

    public void setDateInclusionsPK(DateInclusionsPK dateInclusionsPK) {
        this.dateInclusionsPK = dateInclusionsPK;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dateInclusionsPK != null ? dateInclusionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DateInclusions)) {
            return false;
        }
        DateInclusions other = (DateInclusions) object;
        if ((this.dateInclusionsPK == null && other.dateInclusionsPK != null) || (this.dateInclusionsPK != null && !this.dateInclusionsPK.equals(other.dateInclusionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.DateInclusions[ dateInclusionsPK=" + dateInclusionsPK + " ]";
    }
    
}
