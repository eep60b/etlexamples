/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id"),
    @NamedQuery(name = "Schedule.findByWarningHours", query = "SELECT s FROM Schedule s WHERE s.warningHours = :warningHours"),
    @NamedQuery(name = "Schedule.findByErrorHours", query = "SELECT s FROM Schedule s WHERE s.errorHours = :errorHours")})
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "warning_hours")
    private int warningHours;
    @Basic(optional = false)
    @Column(name = "error_hours")
    private int errorHours;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
    private List<DateExclusions> dateExclusionsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
    private List<DateInclusions> dateInclusionsList;
    @OneToMany(mappedBy = "scheduleId")
    private List<Dealer> dealerList;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, int warningHours, int errorHours) {
        this.id = id;
        this.warningHours = warningHours;
        this.errorHours = errorHours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getWarningHours() {
        return warningHours;
    }

    public void setWarningHours(int warningHours) {
        this.warningHours = warningHours;
    }

    public int getErrorHours() {
        return errorHours;
    }

    public void setErrorHours(int errorHours) {
        this.errorHours = errorHours;
    }

    @XmlTransient
    public List<DateExclusions> getDateExclusionsList() {
        return dateExclusionsList;
    }

    public void setDateExclusionsList(List<DateExclusions> dateExclusionsList) {
        this.dateExclusionsList = dateExclusionsList;
    }

    @XmlTransient
    public List<DateInclusions> getDateInclusionsList() {
        return dateInclusionsList;
    }

    public void setDateInclusionsList(List<DateInclusions> dateInclusionsList) {
        this.dateInclusionsList = dateInclusionsList;
    }

    @XmlTransient
    public List<Dealer> getDealerList() {
        return dealerList;
    }

    public void setDealerList(List<Dealer> dealerList) {
        this.dealerList = dealerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.Schedule[ id=" + id + " ]";
    }
    
}
