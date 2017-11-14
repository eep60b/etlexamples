/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "dms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dms.findAll", query = "SELECT d FROM Dms d"),
    @NamedQuery(name = "Dms.findByEtlDmsid", query = "SELECT d FROM Dms d WHERE d.etlDmsid = :etlDmsid"),
    @NamedQuery(name = "Dms.findByEtlDmsname", query = "SELECT d FROM Dms d WHERE d.dmsPK.etlDmsname = :etlDmsname"),
    @NamedQuery(name = "Dms.findByEtlDmsvendor", query = "SELECT d FROM Dms d WHERE d.dmsPK.etlDmsvendor = :etlDmsvendor"),
    @NamedQuery(name = "Dms.findByEtlDmsversion", query = "SELECT d FROM Dms d WHERE d.dmsPK.etlDmsversion = :etlDmsversion"),
    @NamedQuery(name = "Dms.findByEtlDmsnotes", query = "SELECT d FROM Dms d WHERE d.etlDmsnotes = :etlDmsnotes"),
    @NamedQuery(name = "Dms.findByEtlDateLoaded", query = "SELECT d FROM Dms d WHERE d.etlDateLoaded = :etlDateLoaded"),
    @NamedQuery(name = "Dms.findByLastLoaddetail", query = "SELECT d FROM Dms d WHERE d.lastLoaddetail = :lastLoaddetail")})
public class Dms implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DmsPK dmsPK;
    @Basic(optional = false)
    @Column(name = "etl_dmsid")
    private long etlDmsid;
    @Basic(optional = false)
    @Column(name = "etl_dmsnotes")
    private String etlDmsnotes;
    @Basic(optional = false)
    @Column(name = "etl_date_loaded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etlDateLoaded;
    @Column(name = "last_loaddetail")
    private BigInteger lastLoaddetail;

    public Dms() {
    }

    public Dms(DmsPK dmsPK) {
        this.dmsPK = dmsPK;
    }

    public Dms(DmsPK dmsPK, long etlDmsid, String etlDmsnotes, Date etlDateLoaded) {
        this.dmsPK = dmsPK;
        this.etlDmsid = etlDmsid;
        this.etlDmsnotes = etlDmsnotes;
        this.etlDateLoaded = etlDateLoaded;
    }

    public Dms(String etlDmsname, String etlDmsvendor, String etlDmsversion) {
        this.dmsPK = new DmsPK(etlDmsname, etlDmsvendor, etlDmsversion);
    }

    public DmsPK getDmsPK() {
        return dmsPK;
    }

    public void setDmsPK(DmsPK dmsPK) {
        this.dmsPK = dmsPK;
    }

    public long getEtlDmsid() {
        return etlDmsid;
    }

    public void setEtlDmsid(long etlDmsid) {
        this.etlDmsid = etlDmsid;
    }

    public String getEtlDmsnotes() {
        return etlDmsnotes;
    }

    public void setEtlDmsnotes(String etlDmsnotes) {
        this.etlDmsnotes = etlDmsnotes;
    }

    public Date getEtlDateLoaded() {
        return etlDateLoaded;
    }

    public void setEtlDateLoaded(Date etlDateLoaded) {
        this.etlDateLoaded = etlDateLoaded;
    }

    public BigInteger getLastLoaddetail() {
        return lastLoaddetail;
    }

    public void setLastLoaddetail(BigInteger lastLoaddetail) {
        this.lastLoaddetail = lastLoaddetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dmsPK != null ? dmsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dms)) {
            return false;
        }
        Dms other = (Dms) object;
        if ((this.dmsPK == null && other.dmsPK != null) || (this.dmsPK != null && !this.dmsPK.equals(other.dmsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.Dms[ dmsPK=" + dmsPK + " ]";
    }
    
}
