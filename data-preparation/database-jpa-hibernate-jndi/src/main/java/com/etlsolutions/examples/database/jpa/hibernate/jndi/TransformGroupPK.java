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
public class TransformGroupPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;
    @Basic(optional = false)
    @Column(name = "transform_id")
    private int transformId;
    @Basic(optional = false)
    @Column(name = "system_type_id")
    private int systemTypeId;

    public TransformGroupPK() {
    }

    public TransformGroupPK(int priority, int transformId, int systemTypeId) {
        this.priority = priority;
        this.transformId = transformId;
        this.systemTypeId = systemTypeId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTransformId() {
        return transformId;
    }

    public void setTransformId(int transformId) {
        this.transformId = transformId;
    }

    public int getSystemTypeId() {
        return systemTypeId;
    }

    public void setSystemTypeId(int systemTypeId) {
        this.systemTypeId = systemTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) priority;
        hash += (int) transformId;
        hash += (int) systemTypeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransformGroupPK)) {
            return false;
        }
        TransformGroupPK other = (TransformGroupPK) object;
        if (this.priority != other.priority) {
            return false;
        }
        if (this.transformId != other.transformId) {
            return false;
        }
        if (this.systemTypeId != other.systemTypeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.TransformGroupPK[ priority=" + priority + ", transformId=" + transformId + ", systemTypeId=" + systemTypeId + " ]";
    }
    
}
