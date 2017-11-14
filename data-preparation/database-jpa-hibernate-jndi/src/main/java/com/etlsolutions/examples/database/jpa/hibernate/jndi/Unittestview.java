/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "unittestview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unittestview.findAll", query = "SELECT u FROM Unittestview u"),
    @NamedQuery(name = "Unittestview.findByDealerCode", query = "SELECT u FROM Unittestview u WHERE u.dealerCode = :dealerCode"),
    @NamedQuery(name = "Unittestview.findByDealerName", query = "SELECT u FROM Unittestview u WHERE u.dealerName = :dealerName"),
    @NamedQuery(name = "Unittestview.findByDmsName", query = "SELECT u FROM Unittestview u WHERE u.dmsName = :dmsName"),
    @NamedQuery(name = "Unittestview.findByDmsVersion", query = "SELECT u FROM Unittestview u WHERE u.dmsVersion = :dmsVersion"),
    @NamedQuery(name = "Unittestview.findByTransformRunDate", query = "SELECT u FROM Unittestview u WHERE u.transformRunDate = :transformRunDate"),
    @NamedQuery(name = "Unittestview.findByTransformRunDateFormatted", query = "SELECT u FROM Unittestview u WHERE u.transformRunDateFormatted = :transformRunDateFormatted"),
    @NamedQuery(name = "Unittestview.findByAgeDays", query = "SELECT u FROM Unittestview u WHERE u.ageDays = :ageDays"),
    @NamedQuery(name = "Unittestview.findByCustomerHost", query = "SELECT u FROM Unittestview u WHERE u.customerHost = :customerHost"),
    @NamedQuery(name = "Unittestview.findByEntryPointId", query = "SELECT u FROM Unittestview u WHERE u.entryPointId = :entryPointId"),
    @NamedQuery(name = "Unittestview.findByProjectclassname", query = "SELECT u FROM Unittestview u WHERE u.projectclassname = :projectclassname"),
    @NamedQuery(name = "Unittestview.findByDescription", query = "SELECT u FROM Unittestview u WHERE u.description = :description"),
    @NamedQuery(name = "Unittestview.findByWeekday", query = "SELECT u FROM Unittestview u WHERE u.weekday = :weekday"),
    @NamedQuery(name = "Unittestview.findByIsLive", query = "SELECT u FROM Unittestview u WHERE u.isLive = :isLive")})
public class Unittestview implements Serializable {
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
    private BigInteger transformRunDate;
    @Column(name = "transform_run_date_formatted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transformRunDateFormatted;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "age_days")
    private Double ageDays;
    @Column(name = "customer_host")
    private String customerHost;
    @Column(name = "entry_point_id")
    private Integer entryPointId;
    @Column(name = "projectclassname")
    private String projectclassname;
    @Column(name = "description")
    private String description;
    @Column(name = "weekday")
    private Integer weekday;
    @Column(name = "is_live")
    private Boolean isLive;

    public Unittestview() {
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

    public BigInteger getTransformRunDate() {
        return transformRunDate;
    }

    public void setTransformRunDate(BigInteger transformRunDate) {
        this.transformRunDate = transformRunDate;
    }

    public Date getTransformRunDateFormatted() {
        return transformRunDateFormatted;
    }

    public void setTransformRunDateFormatted(Date transformRunDateFormatted) {
        this.transformRunDateFormatted = transformRunDateFormatted;
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
    
}
