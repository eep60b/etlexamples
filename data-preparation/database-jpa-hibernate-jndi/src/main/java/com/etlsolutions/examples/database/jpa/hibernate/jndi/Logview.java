/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "logview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logview.findAll", query = "SELECT l FROM Logview l"),
    @NamedQuery(name = "Logview.findBySystemName", query = "SELECT l FROM Logview l WHERE l.systemName = :systemName"),
    @NamedQuery(name = "Logview.findByEntryId", query = "SELECT l FROM Logview l WHERE l.entryId = :entryId"),
    @NamedQuery(name = "Logview.findByName", query = "SELECT l FROM Logview l WHERE l.name = :name"),
    @NamedQuery(name = "Logview.findById", query = "SELECT l FROM Logview l WHERE l.id = :id"),
    @NamedQuery(name = "Logview.findByParentLogEntryId", query = "SELECT l FROM Logview l WHERE l.parentLogEntryId = :parentLogEntryId"),
    @NamedQuery(name = "Logview.findByDealerId", query = "SELECT l FROM Logview l WHERE l.dealerId = :dealerId"),
    @NamedQuery(name = "Logview.findByInternalDealerCode", query = "SELECT l FROM Logview l WHERE l.internalDealerCode = :internalDealerCode"),
    @NamedQuery(name = "Logview.findByTransformRunDate", query = "SELECT l FROM Logview l WHERE l.transformRunDate = :transformRunDate"),
    @NamedQuery(name = "Logview.findByErrors", query = "SELECT l FROM Logview l WHERE l.errors = :errors"),
    @NamedQuery(name = "Logview.findByTransformBuildDate", query = "SELECT l FROM Logview l WHERE l.transformBuildDate = :transformBuildDate"),
    @NamedQuery(name = "Logview.findByEntryPointId", query = "SELECT l FROM Logview l WHERE l.entryPointId = :entryPointId"),
    @NamedQuery(name = "Logview.findByCustomerHost", query = "SELECT l FROM Logview l WHERE l.customerHost = :customerHost"),
    @NamedQuery(name = "Logview.findByTmversion", query = "SELECT l FROM Logview l WHERE l.tmversion = :tmversion"),
    @NamedQuery(name = "Logview.findByProjectclassname", query = "SELECT l FROM Logview l WHERE l.projectclassname = :projectclassname")})
public class Logview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "system_name")
    private String systemName;
    @Column(name = "entry_id")
    private Integer entryId;
    @Column(name = "name")
    private String name;
    @Column(name = "id")
    private Integer id;
    @Column(name = "parent_log_entry_id")
    private Integer parentLogEntryId;
    @Column(name = "dealer_id")
    private String dealerId;
    @Column(name = "internal_dealer_code")
    private String internalDealerCode;
    @Column(name = "transform_run_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transformRunDate;
    @Column(name = "errors")
    private Boolean errors;
    @Column(name = "transform_build_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transformBuildDate;
    @Column(name = "entry_point_id")
    private Integer entryPointId;
    @Column(name = "customer_host")
    private String customerHost;
    @Column(name = "tmversion")
    private String tmversion;
    @Column(name = "projectclassname")
    private String projectclassname;

    public Logview() {
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentLogEntryId() {
        return parentLogEntryId;
    }

    public void setParentLogEntryId(Integer parentLogEntryId) {
        this.parentLogEntryId = parentLogEntryId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getInternalDealerCode() {
        return internalDealerCode;
    }

    public void setInternalDealerCode(String internalDealerCode) {
        this.internalDealerCode = internalDealerCode;
    }

    public Date getTransformRunDate() {
        return transformRunDate;
    }

    public void setTransformRunDate(Date transformRunDate) {
        this.transformRunDate = transformRunDate;
    }

    public Boolean getErrors() {
        return errors;
    }

    public void setErrors(Boolean errors) {
        this.errors = errors;
    }

    public Date getTransformBuildDate() {
        return transformBuildDate;
    }

    public void setTransformBuildDate(Date transformBuildDate) {
        this.transformBuildDate = transformBuildDate;
    }

    public Integer getEntryPointId() {
        return entryPointId;
    }

    public void setEntryPointId(Integer entryPointId) {
        this.entryPointId = entryPointId;
    }

    public String getCustomerHost() {
        return customerHost;
    }

    public void setCustomerHost(String customerHost) {
        this.customerHost = customerHost;
    }

    public String getTmversion() {
        return tmversion;
    }

    public void setTmversion(String tmversion) {
        this.tmversion = tmversion;
    }

    public String getProjectclassname() {
        return projectclassname;
    }

    public void setProjectclassname(String projectclassname) {
        this.projectclassname = projectclassname;
    }
    
}
