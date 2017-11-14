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
@Table(name = "system")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "System.findAll", query = "SELECT s FROM System s"),
    @NamedQuery(name = "System.findById", query = "SELECT s FROM System s WHERE s.id = :id"),
    @NamedQuery(name = "System.findByPriority", query = "SELECT s FROM System s WHERE s.priority = :priority"),
    @NamedQuery(name = "System.findByName", query = "SELECT s FROM System s WHERE s.name = :name")})
public class System implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "systemId")
    private List<SystemProperties> systemPropertiesList;
    @JoinColumn(name = "db_connection_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DbConnection dbConnectionId;
    @JoinColumn(name = "entry_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EntryPoint entryPointId;
    @JoinColumn(name = "system_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SystemType systemTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemId")
    private List<LogEntry> logEntryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemId")
    private List<Dealer> dealerList;

    public System() {
    }

    public System(Integer id) {
        this.id = id;
    }

    public System(Integer id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<SystemProperties> getSystemPropertiesList() {
        return systemPropertiesList;
    }

    public void setSystemPropertiesList(List<SystemProperties> systemPropertiesList) {
        this.systemPropertiesList = systemPropertiesList;
    }

    public DbConnection getDbConnectionId() {
        return dbConnectionId;
    }

    public void setDbConnectionId(DbConnection dbConnectionId) {
        this.dbConnectionId = dbConnectionId;
    }

    public EntryPoint getEntryPointId() {
        return entryPointId;
    }

    public void setEntryPointId(EntryPoint entryPointId) {
        this.entryPointId = entryPointId;
    }

    public SystemType getSystemTypeId() {
        return systemTypeId;
    }

    public void setSystemTypeId(SystemType systemTypeId) {
        this.systemTypeId = systemTypeId;
    }

    @XmlTransient
    public List<LogEntry> getLogEntryList() {
        return logEntryList;
    }

    public void setLogEntryList(List<LogEntry> logEntryList) {
        this.logEntryList = logEntryList;
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
        if (!(object instanceof System)) {
            return false;
        }
        System other = (System) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.System[ id=" + id + " ]";
    }
    
}
