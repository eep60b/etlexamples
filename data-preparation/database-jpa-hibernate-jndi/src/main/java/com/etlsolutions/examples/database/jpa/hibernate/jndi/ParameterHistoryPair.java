/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "parameter_history_pair")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParameterHistoryPair.findAll", query = "SELECT p FROM ParameterHistoryPair p"),
    @NamedQuery(name = "ParameterHistoryPair.findByName", query = "SELECT p FROM ParameterHistoryPair p WHERE p.name = :name"),
    @NamedQuery(name = "ParameterHistoryPair.findByValue", query = "SELECT p FROM ParameterHistoryPair p WHERE p.value = :value"),
    @NamedQuery(name = "ParameterHistoryPair.findById", query = "SELECT p FROM ParameterHistoryPair p WHERE p.id = :id")})
public class ParameterHistoryPair implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @ManyToMany(mappedBy = "parameterHistoryPairList")
    private List<LogEntry> logEntryList;
    @ManyToMany(mappedBy = "parameterHistoryPairList1")
    private List<LogEntry> logEntryList1;
    @ManyToMany(mappedBy = "parameterHistoryPairList2")
    private List<LogEntry> logEntryList2;
    @ManyToMany(mappedBy = "parameterHistoryPairList3")
    private List<LogEntry> logEntryList3;

    public ParameterHistoryPair() {
    }

    public ParameterHistoryPair(Integer id) {
        this.id = id;
    }

    public ParameterHistoryPair(Integer id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<LogEntry> getLogEntryList() {
        return logEntryList;
    }

    public void setLogEntryList(List<LogEntry> logEntryList) {
        this.logEntryList = logEntryList;
    }

    @XmlTransient
    public List<LogEntry> getLogEntryList1() {
        return logEntryList1;
    }

    public void setLogEntryList1(List<LogEntry> logEntryList1) {
        this.logEntryList1 = logEntryList1;
    }

    @XmlTransient
    public List<LogEntry> getLogEntryList2() {
        return logEntryList2;
    }

    public void setLogEntryList2(List<LogEntry> logEntryList2) {
        this.logEntryList2 = logEntryList2;
    }

    @XmlTransient
    public List<LogEntry> getLogEntryList3() {
        return logEntryList3;
    }

    public void setLogEntryList3(List<LogEntry> logEntryList3) {
        this.logEntryList3 = logEntryList3;
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
        if (!(object instanceof ParameterHistoryPair)) {
            return false;
        }
        ParameterHistoryPair other = (ParameterHistoryPair) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.ParameterHistoryPair[ id=" + id + " ]";
    }
    
}
