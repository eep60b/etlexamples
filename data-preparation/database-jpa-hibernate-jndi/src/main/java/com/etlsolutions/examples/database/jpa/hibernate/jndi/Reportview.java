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
@Table(name = "reportview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reportview.findAll", query = "SELECT r FROM Reportview r"),
    @NamedQuery(name = "Reportview.findByDealerCode", query = "SELECT r FROM Reportview r WHERE r.dealerCode = :dealerCode"),
    @NamedQuery(name = "Reportview.findByDealerName", query = "SELECT r FROM Reportview r WHERE r.dealerName = :dealerName"),
    @NamedQuery(name = "Reportview.findByDmsName", query = "SELECT r FROM Reportview r WHERE r.dmsName = :dmsName"),
    @NamedQuery(name = "Reportview.findByDmsVersion", query = "SELECT r FROM Reportview r WHERE r.dmsVersion = :dmsVersion"),
    @NamedQuery(name = "Reportview.findByTransformRunDate", query = "SELECT r FROM Reportview r WHERE r.transformRunDate = :transformRunDate"),
    @NamedQuery(name = "Reportview.findByAgeDays", query = "SELECT r FROM Reportview r WHERE r.ageDays = :ageDays"),
    @NamedQuery(name = "Reportview.findByCustomerHost", query = "SELECT r FROM Reportview r WHERE r.customerHost = :customerHost"),
    @NamedQuery(name = "Reportview.findByEntryPointId", query = "SELECT r FROM Reportview r WHERE r.entryPointId = :entryPointId"),
    @NamedQuery(name = "Reportview.findByErrors", query = "SELECT r FROM Reportview r WHERE r.errors = :errors"),
    @NamedQuery(name = "Reportview.findByStandardError", query = "SELECT r FROM Reportview r WHERE r.standardError = :standardError"),
    @NamedQuery(name = "Reportview.findByStandardOut", query = "SELECT r FROM Reportview r WHERE r.standardOut = :standardOut"),
    @NamedQuery(name = "Reportview.findByProjectclassname", query = "SELECT r FROM Reportview r WHERE r.projectclassname = :projectclassname"),
    @NamedQuery(name = "Reportview.findByDescription", query = "SELECT r FROM Reportview r WHERE r.description = :description"),
    @NamedQuery(name = "Reportview.findByWeekday", query = "SELECT r FROM Reportview r WHERE r.weekday = :weekday"),
    @NamedQuery(name = "Reportview.findByIsLive", query = "SELECT r FROM Reportview r WHERE r.isLive = :isLive"),
    @NamedQuery(name = "Reportview.findByTransformTypeId", query = "SELECT r FROM Reportview r WHERE r.transformTypeId = :transformTypeId")})
public class Reportview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "dealer_code")
    private String dealerCode;
    @Column(name = "dealer_name")
    private String dealerName;
    @Column(name = "dms_name")
    private String dmsName;
    @Column(name = "dms_version")
    private String dmsVersion;
    @Column(name = "transform_run_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transformRunDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "age_days")
    private Double ageDays;
    @Column(name = "customer_host")
    private String customerHost;
    @Column(name = "entry_point_id")
    private Integer entryPointId;
    @Column(name = "errors")
    private Boolean errors;
    @Column(name = "standard_error")
    private String standardError;
    @Column(name = "standard_out")
    private String standardOut;
    @Column(name = "projectclassname")
    private String projectclassname;
    @Column(name = "description")
    private String description;
    @Column(name = "weekday")
    private Integer weekday;
    @Column(name = "is_live")
    private Boolean isLive;
    @Column(name = "transform_type_id")
    private Integer transformTypeId;

    public Reportview() {
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDmsName() {
        return dmsName;
    }

    public void setDmsName(String dmsName) {
        this.dmsName = dmsName;
    }

    public String getDmsVersion() {
        return dmsVersion;
    }

    public void setDmsVersion(String dmsVersion) {
        this.dmsVersion = dmsVersion;
    }

    public Date getTransformRunDate() {
        return transformRunDate;
    }

    public void setTransformRunDate(Date transformRunDate) {
        this.transformRunDate = transformRunDate;
    }

    public Double getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(Double ageDays) {
        this.ageDays = ageDays;
    }

    public String getCustomerHost() {
        return customerHost;
    }

    public void setCustomerHost(String customerHost) {
        this.customerHost = customerHost;
    }

    public Integer getEntryPointId() {
        return entryPointId;
    }

    public void setEntryPointId(Integer entryPointId) {
        this.entryPointId = entryPointId;
    }

    public Boolean getErrors() {
        return errors;
    }

    public void setErrors(Boolean errors) {
        this.errors = errors;
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

    public String getProjectclassname() {
        return projectclassname;
    }

    public void setProjectclassname(String projectclassname) {
        this.projectclassname = projectclassname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getTransformTypeId() {
        return transformTypeId;
    }

    public void setTransformTypeId(Integer transformTypeId) {
        this.transformTypeId = transformTypeId;
    }
    
}
