/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "log_entry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogEntry.findAll", query = "SELECT l FROM LogEntry l"),
    @NamedQuery(name = "LogEntry.findById", query = "SELECT l FROM LogEntry l WHERE l.id = :id"),
    @NamedQuery(name = "LogEntry.findByStandardError", query = "SELECT l FROM LogEntry l WHERE l.standardError = :standardError"),
    @NamedQuery(name = "LogEntry.findByStandardOut", query = "SELECT l FROM LogEntry l WHERE l.standardOut = :standardOut"),
    @NamedQuery(name = "LogEntry.findByTransformRunDate", query = "SELECT l FROM LogEntry l WHERE l.transformRunDate = :transformRunDate"),
    @NamedQuery(name = "LogEntry.findByErrors", query = "SELECT l FROM LogEntry l WHERE l.errors = :errors"),
    @NamedQuery(name = "LogEntry.findByTransformBuildDate", query = "SELECT l FROM LogEntry l WHERE l.transformBuildDate = :transformBuildDate"),
    @NamedQuery(name = "LogEntry.findByInvalidated", query = "SELECT l FROM LogEntry l WHERE l.invalidated = :invalidated"),
    @NamedQuery(name = "LogEntry.findByParentLogEntryId", query = "SELECT l FROM LogEntry l WHERE l.parentLogEntryId = :parentLogEntryId"),
    @NamedQuery(name = "LogEntry.findByInternalDealerCode", query = "SELECT l FROM LogEntry l WHERE l.internalDealerCode = :internalDealerCode")})
public class LogEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "standard_error")
    private String standardError;
    @Column(name = "standard_out")
    private String standardOut;
    @Basic(optional = false)
    @Column(name = "transform_run_date")
    private long transformRunDate;
    @Basic(optional = false)
    @Column(name = "errors")
    private boolean errors;
    @Basic(optional = false)
    @Column(name = "transform_build_date")
    private long transformBuildDate;
    @Column(name = "invalidated")
    private BigInteger invalidated;
    @Column(name = "parent_log_entry_id")
    private Integer parentLogEntryId;
    @Column(name = "internal_dealer_code")
    private String internalDealerCode;
    @JoinTable(name = "source_parameter_history", joinColumns = {
        @JoinColumn(name = "log_entry_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "parameter_history_pair_id", referencedColumnName = "id")})
    @ManyToMany
    private List<ParameterHistoryPair> parameterHistoryPairList;
    @JoinTable(name = "target_parameter_history", joinColumns = {
        @JoinColumn(name = "log_entry_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "parameter_history_pair_id", referencedColumnName = "id")})
    @ManyToMany
    private List<ParameterHistoryPair> parameterHistoryPairList1;
    @JoinTable(name = "system_parameter_history", joinColumns = {
        @JoinColumn(name = "log_entry_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "parameter_history_pair_id", referencedColumnName = "id")})
    @ManyToMany
    private List<ParameterHistoryPair> parameterHistoryPairList2;
    @JoinTable(name = "parameter_history", joinColumns = {
        @JoinColumn(name = "log_entry_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "parameter_history_pair_id", referencedColumnName = "id")})
    @ManyToMany
    private List<ParameterHistoryPair> parameterHistoryPairList3;
    @JoinColumn(name = "autolinehacking_id", referencedColumnName = "id")
    @ManyToOne
    private AutolineHacking autolinehackingId;
    @JoinColumn(name = "log_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Log logId;
    @JoinColumn(name = "system_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private System systemId;
    @JoinColumn(name = "transform_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transform transformId;

    public LogEntry() {
    }

    public LogEntry(Integer id) {
        this.id = id;
    }

    public LogEntry(Integer id, long transformRunDate, boolean errors, long transformBuildDate) {
        this.id = id;
        this.transformRunDate = transformRunDate;
        this.errors = errors;
        this.transformBuildDate = transformBuildDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStandardError() {
        return standardError;
    }

    public void setStandardError(String standardError) {
        this.standardError = standardError;
    }

    public String getStandardOut() {
        return standardOut;
    }

    public void setStandardOut(String standardOut) {
        this.standardOut = standardOut;
    }

    public long getTransformRunDate() {
        return transformRunDate;
    }

    public void setTransformRunDate(long transformRunDate) {
        this.transformRunDate = transformRunDate;
    }

    public boolean getErrors() {
        return errors;
    }

    public void setErrors(boolean errors) {
        this.errors = errors;
    }

    public long getTransformBuildDate() {
        return transformBuildDate;
    }

    public void setTransformBuildDate(long transformBuildDate) {
        this.transformBuildDate = transformBuildDate;
    }

    public BigInteger getInvalidated() {
        return invalidated;
    }

    public void setInvalidated(BigInteger invalidated) {
        this.invalidated = invalidated;
    }

    public Integer getParentLogEntryId() {
        return parentLogEntryId;
    }

    public void setParentLogEntryId(Integer parentLogEntryId) {
        this.parentLogEntryId = parentLogEntryId;
    }

    public String getInternalDealerCode() {
        return internalDealerCode;
    }

    public void setInternalDealerCode(String internalDealerCode) {
        this.internalDealerCode = internalDealerCode;
    }

    @XmlTransient
    public List<ParameterHistoryPair> getParameterHistoryPairList() {
        return parameterHistoryPairList;
    }

    public void setParameterHistoryPairList(List<ParameterHistoryPair> parameterHistoryPairList) {
        this.parameterHistoryPairList = parameterHistoryPairList;
    }

    @XmlTransient
    public List<ParameterHistoryPair> getParameterHistoryPairList1() {
        return parameterHistoryPairList1;
    }

    public void setParameterHistoryPairList1(List<ParameterHistoryPair> parameterHistoryPairList1) {
        this.parameterHistoryPairList1 = parameterHistoryPairList1;
    }

    @XmlTransient
    public List<ParameterHistoryPair> getParameterHistoryPairList2() {
        return parameterHistoryPairList2;
    }

    public void setParameterHistoryPairList2(List<ParameterHistoryPair> parameterHistoryPairList2) {
        this.parameterHistoryPairList2 = parameterHistoryPairList2;
    }

    @XmlTransient
    public List<ParameterHistoryPair> getParameterHistoryPairList3() {
        return parameterHistoryPairList3;
    }

    public void setParameterHistoryPairList3(List<ParameterHistoryPair> parameterHistoryPairList3) {
        this.parameterHistoryPairList3 = parameterHistoryPairList3;
    }

    public AutolineHacking getAutolinehackingId() {
        return autolinehackingId;
    }

    public void setAutolinehackingId(AutolineHacking autolinehackingId) {
        this.autolinehackingId = autolinehackingId;
    }

    public Log getLogId() {
        return logId;
    }

    public void setLogId(Log logId) {
        this.logId = logId;
    }

    public System getSystemId() {
        return systemId;
    }

    public void setSystemId(System systemId) {
        this.systemId = systemId;
    }

    public Transform getTransformId() {
        return transformId;
    }

    public void setTransformId(Transform transformId) {
        this.transformId = transformId;
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
        if (!(object instanceof LogEntry)) {
            return false;
        }
        LogEntry other = (LogEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.LogEntry[ id=" + id + " ]";
    }
    
}
