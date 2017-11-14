/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author zc
 */
@Embeddable
public class DmsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "etl_dmsname")
    private String etlDmsname;
    @Basic(optional = false)
    @Column(name = "etl_dmsvendor")
    private String etlDmsvendor;
    @Basic(optional = false)
    @Column(name = "etl_dmsversion")
    private String etlDmsversion;

    public DmsPK() {
    }

    public DmsPK(String etlDmsname, String etlDmsvendor, String etlDmsversion) {
        this.etlDmsname = etlDmsname;
        this.etlDmsvendor = etlDmsvendor;
        this.etlDmsversion = etlDmsversion;
    }

    public String getEtlDmsname() {
        return etlDmsname;
    }

    public void setEtlDmsname(String etlDmsname) {
        this.etlDmsname = etlDmsname;
    }

    public String getEtlDmsvendor() {
        return etlDmsvendor;
    }

    public void setEtlDmsvendor(String etlDmsvendor) {
        this.etlDmsvendor = etlDmsvendor;
    }

    public String getEtlDmsversion() {
        return etlDmsversion;
    }

    public void setEtlDmsversion(String etlDmsversion) {
        this.etlDmsversion = etlDmsversion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etlDmsname != null ? etlDmsname.hashCode() : 0);
        hash += (etlDmsvendor != null ? etlDmsvendor.hashCode() : 0);
        hash += (etlDmsversion != null ? etlDmsversion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DmsPK)) {
            return false;
        }
        DmsPK other = (DmsPK) object;
        if ((this.etlDmsname == null && other.etlDmsname != null) || (this.etlDmsname != null && !this.etlDmsname.equals(other.etlDmsname))) {
            return false;
        }
        if ((this.etlDmsvendor == null && other.etlDmsvendor != null) || (this.etlDmsvendor != null && !this.etlDmsvendor.equals(other.etlDmsvendor))) {
            return false;
        }
        if ((this.etlDmsversion == null && other.etlDmsversion != null) || (this.etlDmsversion != null && !this.etlDmsversion.equals(other.etlDmsversion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.DmsPK[ etlDmsname=" + etlDmsname + ", etlDmsvendor=" + etlDmsvendor + ", etlDmsversion=" + etlDmsversion + " ]";
    }
    
}
