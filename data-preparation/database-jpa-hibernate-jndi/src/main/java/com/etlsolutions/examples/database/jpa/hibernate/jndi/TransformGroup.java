/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "transform_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransformGroup.findAll", query = "SELECT t FROM TransformGroup t"),
    @NamedQuery(name = "TransformGroup.findById", query = "SELECT t FROM TransformGroup t WHERE t.id = :id"),
    @NamedQuery(name = "TransformGroup.findByPriority", query = "SELECT t FROM TransformGroup t WHERE t.transformGroupPK.priority = :priority"),
    @NamedQuery(name = "TransformGroup.findByTransformId", query = "SELECT t FROM TransformGroup t WHERE t.transformGroupPK.transformId = :transformId"),
    @NamedQuery(name = "TransformGroup.findBySystemTypeId", query = "SELECT t FROM TransformGroup t WHERE t.transformGroupPK.systemTypeId = :systemTypeId"),
    @NamedQuery(name = "TransformGroup.findByDescription", query = "SELECT t FROM TransformGroup t WHERE t.description = :description")})
public class TransformGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransformGroupPK transformGroupPK;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "system_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SystemType systemType;
    @JoinColumn(name = "transform_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Transform transform;

    public TransformGroup() {
    }

    public TransformGroup(TransformGroupPK transformGroupPK) {
        this.transformGroupPK = transformGroupPK;
    }

    public TransformGroup(TransformGroupPK transformGroupPK, int id) {
        this.transformGroupPK = transformGroupPK;
        this.id = id;
    }

    public TransformGroup(int priority, int transformId, int systemTypeId) {
        this.transformGroupPK = new TransformGroupPK(priority, transformId, systemTypeId);
    }

    public TransformGroupPK getTransformGroupPK() {
        return transformGroupPK;
    }

    public void setTransformGroupPK(TransformGroupPK transformGroupPK) {
        this.transformGroupPK = transformGroupPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SystemType getSystemType() {
        return systemType;
    }

    public void setSystemType(SystemType systemType) {
        this.systemType = systemType;
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
        hash += (transformGroupPK != null ? transformGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransformGroup)) {
            return false;
        }
        TransformGroup other = (TransformGroup) object;
        if ((this.transformGroupPK == null && other.transformGroupPK != null) || (this.transformGroupPK != null && !this.transformGroupPK.equals(other.transformGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.TransformGroup[ transformGroupPK=" + transformGroupPK + " ]";
    }
    
}
