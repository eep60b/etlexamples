/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "logdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logdetail.findAll", query = "SELECT l FROM Logdetail l"),
    @NamedQuery(name = "Logdetail.findByStandardError", query = "SELECT l FROM Logdetail l WHERE l.standardError = :standardError"),
    @NamedQuery(name = "Logdetail.findByParentLogEntryId", query = "SELECT l FROM Logdetail l WHERE l.parentLogEntryId = :parentLogEntryId"),
    @NamedQuery(name = "Logdetail.findByStandardOut", query = "SELECT l FROM Logdetail l WHERE l.standardOut = :standardOut"),
    @NamedQuery(name = "Logdetail.findByTransformRunDate", query = "SELECT l FROM Logdetail l WHERE l.transformRunDate = :transformRunDate"),
    @NamedQuery(name = "Logdetail.findByErrors", query = "SELECT l FROM Logdetail l WHERE l.errors = :errors"),
    @NamedQuery(name = "Logdetail.findByTransformBuildDate", query = "SELECT l FROM Logdetail l WHERE l.transformBuildDate = :transformBuildDate"),
    @NamedQuery(name = "Logdetail.findByTransformId", query = "SELECT l FROM Logdetail l WHERE l.transformId = :transformId"),
    @NamedQuery(name = "Logdetail.findByAutolinehackingId", query = "SELECT l FROM Logdetail l WHERE l.autolinehackingId = :autolinehackingId"),
    @NamedQuery(name = "Logdetail.findBySystemId", query = "SELECT l FROM Logdetail l WHERE l.systemId = :systemId"),
    @NamedQuery(name = "Logdetail.findByName", query = "SELECT l FROM Logdetail l WHERE l.name = :name"),
    @NamedQuery(name = "Logdetail.findByEntryPointId", query = "SELECT l FROM Logdetail l WHERE l.entryPointId = :entryPointId"),
    @NamedQuery(name = "Logdetail.findById", query = "SELECT l FROM Logdetail l WHERE l.id = :id"),
    @NamedQuery(name = "Logdetail.findByCustomerHost", query = "SELECT l FROM Logdetail l WHERE l.customerHost = :customerHost"),
    @NamedQuery(name = "Logdetail.findByTmversion", query = "SELECT l FROM Logdetail l WHERE l.tmversion = :tmversion")})
public class Logdetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "standard_error")
    private String standardError;
    @Column(name = "parent_log_entry_id")
    private Integer parentLogEntryId;
    @Column(name = "standard_out")
    private String standardOut;
    @Column(name = "transform_run_date")
    private BigInteger transformRunDate;
    @Column(name = "errors")
    private Boolean errors;
    @Column(name = "transform_build_date")
    private BigInteger transformBuildDate;
    @Column(name = "transform_id")
    private Integer transformId;
    @Column(name = "autolinehacking_id")
    private Integer autolinehackingId;
    @Column(name = "system_id")
    private Integer systemId;
    @Column(name = "name")
    private String name;
    @Column(name = "entry_point_id")
    private Integer entryPointId;
    @Column(name = "id")
    private Integer id;
    @Column(name = "customer_host")
    private String customerHost;
    @Column(name = "tmversion")
    private String tmversion;

    public Logdetail() {
    }

    public String getStandardError() {
        return standardError;
    }

    public void setStandardError(String standardError) {
        this.standardError = standardError;
    }

    public Integer getParentLogEntryId() {
        return parentLogEntryId;
    }

    public void setParentLogEntryId(Integer parentLogEntryId) {
        this.parentLogEntryId = parentLogEntryId;
    }

    public String getStandardOut() {
        return standardOut;
    }

    public void setStandardOut(String standardOut) {
        this.standardOut = standardOut;
    }

    public BigInteger getTransformRunDate() {
        return transformRunDate;
    }

    public void setTransformRunDate(BigInteger transformRunDate) {
        this.transformRunDate = transformRunDate;
    }

    public Boolean getErrors() {
        return errors;
    }

    public void setErrors(Boolean errors) {
        this.errors = errors;
    }

    public BigInteger getTransformBuildDate() {
        return transformBuildDate;
    }

    public void setTransformBuildDate(BigInteger transformBuildDate) {
        this.transformBuildDate = transformBuildDate;
    }

    public Integer getTransformId() {
        return transformId;
    }

    public void setTransformId(Integer transformId) {
        this.transformId = transformId;
    }

    public Integer getAutolinehackingId() {
        return autolinehackingId;
    }

    public void setAutolinehackingId(Integer autolinehackingId) {
        this.autolinehackingId = autolinehackingId;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEntryPointId() {
        return entryPointId;
    }

    public void setEntryPointId(Integer entryPointId) {
        this.entryPointId = entryPointId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
}
