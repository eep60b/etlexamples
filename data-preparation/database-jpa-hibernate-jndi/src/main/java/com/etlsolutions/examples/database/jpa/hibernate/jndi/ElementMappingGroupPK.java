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
public class ElementMappingGroupPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "element_mapping_id")
    private int elementMappingId;
    @Basic(optional = false)
    @Column(name = "dealer_id")
    private int dealerId;
    @Basic(optional = false)
    @Column(name = "transform_id")
    private int transformId;

    public ElementMappingGroupPK() {
    }

    public ElementMappingGroupPK(int elementMappingId, int dealerId, int transformId) {
        this.elementMappingId = elementMappingId;
        this.dealerId = dealerId;
        this.transformId = transformId;
    }

    public int getElementMappingId() {
        return elementMappingId;
    }

    public void setElementMappingId(int elementMappingId) {
        this.elementMappingId = elementMappingId;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public int getTransformId() {
        return transformId;
    }

    public void setTransformId(int transformId) {
        this.transformId = transformId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) elementMappingId;
        hash += (int) dealerId;
        hash += (int) transformId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementMappingGroupPK)) {
            return false;
        }
        ElementMappingGroupPK other = (ElementMappingGroupPK) object;
        if (this.elementMappingId != other.elementMappingId) {
            return false;
        }
        if (this.dealerId != other.dealerId) {
            return false;
        }
        if (this.transformId != other.transformId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.ElementMappingGroupPK[ elementMappingId=" + elementMappingId + ", dealerId=" + dealerId + ", transformId=" + transformId + " ]";
    }
    
}
