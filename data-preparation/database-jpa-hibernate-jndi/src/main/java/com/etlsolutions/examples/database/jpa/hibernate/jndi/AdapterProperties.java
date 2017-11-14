/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "adapter_properties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdapterProperties.findAll", query = "SELECT a FROM AdapterProperties a"),
    @NamedQuery(name = "AdapterProperties.findById", query = "SELECT a FROM AdapterProperties a WHERE a.id = :id"),
    @NamedQuery(name = "AdapterProperties.findByClassname", query = "SELECT a FROM AdapterProperties a WHERE a.classname = :classname"),
    @NamedQuery(name = "AdapterProperties.findByDescription", query = "SELECT a FROM AdapterProperties a WHERE a.description = :description")})
public class AdapterProperties implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "classname")
    private String classname;
    @Column(name = "description")
    private String description;
    @JoinTable(name = "propertyset", joinColumns = {
        @JoinColumn(name = "adapter_properties_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "property_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Property> propertyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sourceAdapterPropertyId")
    private List<Transform> transformList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetAdapterPropertyId")
    private List<Transform> transformList1;

    public AdapterProperties() {
    }

    public AdapterProperties(Integer id) {
        this.id = id;
    }

    public AdapterProperties(Integer id, String classname) {
        this.id = id;
        this.classname = classname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    @XmlTransient
    public List<Transform> getTransformList() {
        return transformList;
    }

    public void setTransformList(List<Transform> transformList) {
        this.transformList = transformList;
    }

    @XmlTransient
    public List<Transform> getTransformList1() {
        return transformList1;
    }

    public void setTransformList1(List<Transform> transformList1) {
        this.transformList1 = transformList1;
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
        if (!(object instanceof AdapterProperties)) {
            return false;
        }
        AdapterProperties other = (AdapterProperties) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.AdapterProperties[ id=" + id + " ]";
    }
    
}
