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
@Table(name = "log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByCustomerHost", query = "SELECT l FROM Log l WHERE l.customerHost = :customerHost"),
    @NamedQuery(name = "Log.findById", query = "SELECT l FROM Log l WHERE l.id = :id"),
    @NamedQuery(name = "Log.findByTmversion", query = "SELECT l FROM Log l WHERE l.tmversion = :tmversion")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "customer_host")
    private String customerHost;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tmversion")
    private String tmversion;
    @JoinColumn(name = "entry_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EntryPoint entryPointId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logId")
    private List<LogEntry> logEntryList;

    public Log() {
    }

    public Log(Integer id) {
        this.id = id;
    }

    public Log(Integer id, String customerHost, String tmversion) {
        this.id = id;
        this.customerHost = customerHost;
        this.tmversion = tmversion;
    }

    public String getCustomerHost() {
        return customerHost;
    }

    public void setCustomerHost(String customerHost) {
        this.customerHost = customerHost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTmversion() {
        return tmversion;
    }

    public void setTmversion(String tmversion) {
        this.tmversion = tmversion;
    }

    public EntryPoint getEntryPointId() {
        return entryPointId;
    }

    public void setEntryPointId(EntryPoint entryPointId) {
        this.entryPointId = entryPointId;
    }

    @XmlTransient
    public List<LogEntry> getLogEntryList() {
        return logEntryList;
    }

    public void setLogEntryList(List<LogEntry> logEntryList) {
        this.logEntryList = logEntryList;
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
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.Log[ id=" + id + " ]";
    }
    
}
