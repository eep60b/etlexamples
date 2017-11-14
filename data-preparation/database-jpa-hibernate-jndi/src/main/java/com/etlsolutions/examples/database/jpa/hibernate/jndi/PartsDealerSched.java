/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "parts_dealer_sched")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartsDealerSched.findAll", query = "SELECT p FROM PartsDealerSched p"),
    @NamedQuery(name = "PartsDealerSched.findById", query = "SELECT p FROM PartsDealerSched p WHERE p.id = :id"),
    @NamedQuery(name = "PartsDealerSched.findByDealername", query = "SELECT p FROM PartsDealerSched p WHERE p.dealername = :dealername"),
    @NamedQuery(name = "PartsDealerSched.findByTown", query = "SELECT p FROM PartsDealerSched p WHERE p.town = :town"),
    @NamedQuery(name = "PartsDealerSched.findByStartdate", query = "SELECT p FROM PartsDealerSched p WHERE p.startdate = :startdate"),
    @NamedQuery(name = "PartsDealerSched.findByEnddate", query = "SELECT p FROM PartsDealerSched p WHERE p.enddate = :enddate"),
    @NamedQuery(name = "PartsDealerSched.findByIsWebupload", query = "SELECT p FROM PartsDealerSched p WHERE p.isWebupload = :isWebupload"),
    @NamedQuery(name = "PartsDealerSched.findByWeekday", query = "SELECT p FROM PartsDealerSched p WHERE p.weekday = :weekday"),
    @NamedQuery(name = "PartsDealerSched.findByIsLive", query = "SELECT p FROM PartsDealerSched p WHERE p.isLive = :isLive"),
    @NamedQuery(name = "PartsDealerSched.findByXmloutWeekday", query = "SELECT p FROM PartsDealerSched p WHERE p.xmloutWeekday = :xmloutWeekday"),
    @NamedQuery(name = "PartsDealerSched.findByXmloutGroup", query = "SELECT p FROM PartsDealerSched p WHERE p.xmloutGroup = :xmloutGroup"),
    @NamedQuery(name = "PartsDealerSched.findByWeekdayParts", query = "SELECT p FROM PartsDealerSched p WHERE p.weekdayParts = :weekdayParts")})
public class PartsDealerSched implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dealername")
    private String dealername;
    @Column(name = "town")
    private String town;
    @Column(name = "startdate")
    private String startdate;
    @Column(name = "enddate")
    private String enddate;
    @Column(name = "is_webupload")
    private Boolean isWebupload;
    @Column(name = "weekday")
    private Integer weekday;
    @Column(name = "is_live")
    private Boolean isLive;
    @Column(name = "xmlout_weekday")
    private Integer xmloutWeekday;
    @Basic(optional = false)
    @Column(name = "xmlout_group")
    private int xmloutGroup;
    @Column(name = "weekday_parts")
    private Integer weekdayParts;
    @JoinColumn(name = "dealercode", referencedColumnName = "id")
    @OneToOne(optional = false)
    private UniqueDealer dealercode;

    public PartsDealerSched() {
    }

    public PartsDealerSched(Integer id) {
        this.id = id;
    }

    public PartsDealerSched(Integer id, String dealername, int xmloutGroup) {
        this.id = id;
        this.dealername = dealername;
        this.xmloutGroup = xmloutGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDealername() {
        return dealername;
    }

    public void setDealername(String dealername) {
        this.dealername = dealername;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Boolean getIsWebupload() {
        return isWebupload;
    }

    public void setIsWebupload(Boolean isWebupload) {
        this.isWebupload = isWebupload;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
    }

    public Integer getXmloutWeekday() {
        return xmloutWeekday;
    }

    public void setXmloutWeekday(Integer xmloutWeekday) {
        this.xmloutWeekday = xmloutWeekday;
    }

    public int getXmloutGroup() {
        return xmloutGroup;
    }

    public void setXmloutGroup(int xmloutGroup) {
        this.xmloutGroup = xmloutGroup;
    }

    public Integer getWeekdayParts() {
        return weekdayParts;
    }

    public void setWeekdayParts(Integer weekdayParts) {
        this.weekdayParts = weekdayParts;
    }

    public UniqueDealer getDealercode() {
        return dealercode;
    }

    public void setDealercode(UniqueDealer dealercode) {
        this.dealercode = dealercode;
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
        if (!(object instanceof PartsDealerSched)) {
            return false;
        }
        PartsDealerSched other = (PartsDealerSched) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.PartsDealerSched[ id=" + id + " ]";
    }
    
}
