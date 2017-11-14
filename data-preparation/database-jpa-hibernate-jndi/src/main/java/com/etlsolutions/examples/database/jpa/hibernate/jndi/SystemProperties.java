/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "system_properties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemProperties.findAll", query = "SELECT s FROM SystemProperties s"),
    @NamedQuery(name = "SystemProperties.findById", query = "SELECT s FROM SystemProperties s WHERE s.id = :id")})
public class SystemProperties implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    @ManyToOne
    private Property propertyId;
    @JoinColumn(name = "system_id", referencedColumnName = "id")
    @ManyToOne
    private System systemId;
    @JoinColumn(name = "transform_filter_id", referencedColumnName = "id")
    @ManyToOne
    private Transform transformFilterId;

    public SystemProperties() {
    }

    public SystemProperties(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Property getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Property propertyId) {
        this.propertyId = propertyId;
    }

    public System getSystemId() {
        return systemId;
    }

    public void setSystemId(System systemId) {
        this.systemId = systemId;
    }

    public Transform getTransformFilterId() {
        return transformFilterId;
    }

    public void setTransformFilterId(Transform transformFilterId) {
        this.transformFilterId = transformFilterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemProperties)) {
            return false;
        }
        SystemProperties other = (SystemProperties) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.SystemProperties[ id=" + id + " ]";
    }
    
}
