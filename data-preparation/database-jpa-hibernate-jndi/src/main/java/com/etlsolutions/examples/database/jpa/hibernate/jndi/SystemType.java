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
@Table(name = "system_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemType.findAll", query = "SELECT s FROM SystemType s"),
    @NamedQuery(name = "SystemType.findByVendor", query = "SELECT s FROM SystemType s WHERE s.vendor = :vendor"),
    @NamedQuery(name = "SystemType.findByName", query = "SELECT s FROM SystemType s WHERE s.name = :name"),
    @NamedQuery(name = "SystemType.findByVersion", query = "SELECT s FROM SystemType s WHERE s.version = :version"),
    @NamedQuery(name = "SystemType.findById", query = "SELECT s FROM SystemType s WHERE s.id = :id")})
public class SystemType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "vendor")
    private String vendor;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "version")
    private String version;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemType")
    private List<TransformGroup> transformGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemTypeId")
    private List<System> systemList;

    public SystemType() {
    }

    public SystemType(Integer id) {
        this.id = id;
    }

    public SystemType(Integer id, String vendor, String name) {
        this.id = id;
        this.vendor = vendor;
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<TransformGroup> getTransformGroupList() {
        return transformGroupList;
    }

    public void setTransformGroupList(List<TransformGroup> transformGroupList) {
        this.transformGroupList = transformGroupList;
    }

    @XmlTransient
    public List<System> getSystemList() {
        return systemList;
    }

    public void setSystemList(List<System> systemList) {
        this.systemList = systemList;
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
        if (!(object instanceof SystemType)) {
            return false;
        }
        SystemType other = (SystemType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.SystemType[ id=" + id + " ]";
    }
    
}
