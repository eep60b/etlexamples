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
@Table(name = "date_exclusions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DateExclusions.findAll", query = "SELECT d FROM DateExclusions d"),
    @NamedQuery(name = "DateExclusions.findByScheduleId", query = "SELECT d FROM DateExclusions d WHERE d.dateExclusionsPK.scheduleId = :scheduleId"),
    @NamedQuery(name = "DateExclusions.findByDay", query = "SELECT d FROM DateExclusions d WHERE d.dateExclusionsPK.day = :day"),
    @NamedQuery(name = "DateExclusions.findByRecurring", query = "SELECT d FROM DateExclusions d WHERE d.dateExclusionsPK.recurring = :recurring")})
public class DateExclusions implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DateExclusionsPK dateExclusionsPK;
    @JoinColumn(name = "schedule_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Schedule schedule;

    public DateExclusions() {
    }

    public DateExclusions(DateExclusionsPK dateExclusionsPK) {
        this.dateExclusionsPK = dateExclusionsPK;
    }

    public DateExclusions(int scheduleId, long day, boolean recurring) {
        this.dateExclusionsPK = new DateExclusionsPK(scheduleId, day, recurring);
    }

    public DateExclusionsPK getDateExclusionsPK() {
        return dateExclusionsPK;
    }

    public void setDateExclusionsPK(DateExclusionsPK dateExclusionsPK) {
        this.dateExclusionsPK = dateExclusionsPK;
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
        hash += (dateExclusionsPK != null ? dateExclusionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DateExclusions)) {
            return false;
        }
        DateExclusions other = (DateExclusions) object;
        if ((this.dateExclusionsPK == null && other.dateExclusionsPK != null) || (this.dateExclusionsPK != null && !this.dateExclusionsPK.equals(other.dateExclusionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.DateExclusions[ dateExclusionsPK=" + dateExclusionsPK + " ]";
    }
    
}
