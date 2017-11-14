/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "element_mapping_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElementMappingGroup.findAll", query = "SELECT e FROM ElementMappingGroup e"),
    @NamedQuery(name = "ElementMappingGroup.findByElementMappingId", query = "SELECT e FROM ElementMappingGroup e WHERE e.elementMappingGroupPK.elementMappingId = :elementMappingId"),
    @NamedQuery(name = "ElementMappingGroup.findByDealerId", query = "SELECT e FROM ElementMappingGroup e WHERE e.elementMappingGroupPK.dealerId = :dealerId"),
    @NamedQuery(name = "ElementMappingGroup.findByTransformId", query = "SELECT e FROM ElementMappingGroup e WHERE e.elementMappingGroupPK.transformId = :transformId")})
public class ElementMappingGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ElementMappingGroupPK elementMappingGroupPK;
    @JoinColumn(name = "dealer_id", referencedColumnName = "etl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dealer dealer;
    @JoinColumn(name = "element_mapping_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ElementMapping elementMapping;
    @JoinColumn(name = "transform_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Transform transform;

    public ElementMappingGroup() {
    }

    public ElementMappingGroup(ElementMappingGroupPK elementMappingGroupPK) {
        this.elementMappingGroupPK = elementMappingGroupPK;
    }

    public ElementMappingGroup(int elementMappingId, int dealerId, int transformId) {
        this.elementMappingGroupPK = new ElementMappingGroupPK(elementMappingId, dealerId, transformId);
    }

    public ElementMappingGroupPK getElementMappingGroupPK() {
        return elementMappingGroupPK;
    }

    public void setElementMappingGroupPK(ElementMappingGroupPK elementMappingGroupPK) {
        this.elementMappingGroupPK = elementMappingGroupPK;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public ElementMapping getElementMapping() {
        return elementMapping;
    }

    public void setElementMapping(ElementMapping elementMapping) {
        this.elementMapping = elementMapping;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elementMappingGroupPK != null ? elementMappingGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementMappingGroup)) {
            return false;
        }
        ElementMappingGroup other = (ElementMappingGroup) object;
        if ((this.elementMappingGroupPK == null && other.elementMappingGroupPK != null) || (this.elementMappingGroupPK != null && !this.elementMappingGroupPK.equals(other.elementMappingGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.ElementMappingGroup[ elementMappingGroupPK=" + elementMappingGroupPK + " ]";
    }
    
}
