/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
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
@Table(name = "dealer_system_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DealerSystemType.findAll", query = "SELECT d FROM DealerSystemType d"),
    @NamedQuery(name = "DealerSystemType.findByDealer", query = "SELECT d FROM DealerSystemType d WHERE d.dealer = :dealer"),
    @NamedQuery(name = "DealerSystemType.findByDmsgroup", query = "SELECT d FROM DealerSystemType d WHERE d.dmsgroup = :dmsgroup"),
    @NamedQuery(name = "DealerSystemType.findByDms", query = "SELECT d FROM DealerSystemType d WHERE d.dms = :dms"),
    @NamedQuery(name = "DealerSystemType.findByDmsgroupName", query = "SELECT d FROM DealerSystemType d WHERE d.dmsgroupName = :dmsgroupName"),
    @NamedQuery(name = "DealerSystemType.findByDmsName", query = "SELECT d FROM DealerSystemType d WHERE d.dmsName = :dmsName"),
    @NamedQuery(name = "DealerSystemType.findByDmsVersion", query = "SELECT d FROM DealerSystemType d WHERE d.dmsVersion = :dmsVersion"),
    @NamedQuery(name = "DealerSystemType.findByDmsType", query = "SELECT d FROM DealerSystemType d WHERE d.dmsType = :dmsType")})
public class DealerSystemType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "dealer")
    private String dealer;
    @Column(name = "dmsgroup")
    private Integer dmsgroup;
    @Column(name = "dms")
    private Integer dms;
    @Column(name = "dmsgroup_name")
    private String dmsgroupName;
    @Column(name = "dms_name")
    private String dmsName;
    @Column(name = "dms_version")
    private String dmsVersion;
    @Column(name = "dms_type")
    private String dmsType;

    public DealerSystemType() {
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public Integer getDmsgroup() {
        return dmsgroup;
    }

    public void setDmsgroup(Integer dmsgroup) {
        this.dmsgroup = dmsgroup;
    }

    public Integer getDms() {
        return dms;
    }

    public void setDms(Integer dms) {
        this.dms = dms;
    }

    public String getDmsgroupName() {
        return dmsgroupName;
    }

    public void setDmsgroupName(String dmsgroupName) {
        this.dmsgroupName = dmsgroupName;
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

    public String getDmsType() {
        return dmsType;
    }

    public void setDmsType(String dmsType) {
        this.dmsType = dmsType;
    }
    
}
