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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "dealer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealer.findAll", query = "SELECT d FROM Dealer d"),
    @NamedQuery(name = "Dealer.findById", query = "SELECT d FROM Dealer d WHERE d.id = :id"),
    @NamedQuery(name = "Dealer.findByInternalDmsId", query = "SELECT d FROM Dealer d WHERE d.internalDmsId = :internalDmsId"),
    @NamedQuery(name = "Dealer.findByDealerName", query = "SELECT d FROM Dealer d WHERE d.dealerName = :dealerName"),
    @NamedQuery(name = "Dealer.findByEtlId", query = "SELECT d FROM Dealer d WHERE d.etlId = :etlId")})
public class Dealer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "internal_dms_id")
    private String internalDmsId;
    @Column(name = "dealer_name")
    private String dealerName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "etl_id")
    private Integer etlId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer")
    private List<ElementMappingGroup> elementMappingGroupList;
    @JoinColumn(name = "autoline_hacking_id", referencedColumnName = "id")
    @ManyToOne
    private AutolineHacking autolineHackingId;
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    @ManyToOne
    private Schedule scheduleId;
    @JoinColumn(name = "system_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private System systemId;

    public Dealer() {
    }

    public Dealer(Integer etlId) {
        this.etlId = etlId;
    }

    public Dealer(Integer etlId, String id) {
        this.etlId = etlId;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInternalDmsId() {
        return internalDmsId;
    }

    public void setInternalDmsId(String internalDmsId) {
        this.internalDmsId = internalDmsId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public Integer getEtlId() {
        return etlId;
    }

    public void setEtlId(Integer etlId) {
        this.etlId = etlId;
    }

    @XmlTransient
    public List<ElementMappingGroup> getElementMappingGroupList() {
        return elementMappingGroupList;
    }

    public void setElementMappingGroupList(List<ElementMappingGroup> elementMappingGroupList) {
        this.elementMappingGroupList = elementMappingGroupList;
    }

    public AutolineHacking getAutolineHackingId() {
        return autolineHackingId;
    }

    public void setAutolineHackingId(AutolineHacking autolineHackingId) {
        this.autolineHackingId = autolineHackingId;
    }

    public Schedule getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Schedule scheduleId) {
        this.scheduleId = scheduleId;
    }

    public System getSystemId() {
        return systemId;
    }

    public void setSystemId(System systemId) {
        this.systemId = systemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etlId != null ? etlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealer)) {
            return false;
        }
        Dealer other = (Dealer) object;
        if ((this.etlId == null && other.etlId != null) || (this.etlId != null && !this.etlId.equals(other.etlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.Dealer[ etlId=" + etlId + " ]";
    }
    
}
