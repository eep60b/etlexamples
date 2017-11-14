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
@Table(name = "entry_point")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntryPoint.findAll", query = "SELECT e FROM EntryPoint e"),
    @NamedQuery(name = "EntryPoint.findByRam", query = "SELECT e FROM EntryPoint e WHERE e.ram = :ram"),
    @NamedQuery(name = "EntryPoint.findById", query = "SELECT e FROM EntryPoint e WHERE e.id = :id"),
    @NamedQuery(name = "EntryPoint.findByName", query = "SELECT e FROM EntryPoint e WHERE e.name = :name"),
    @NamedQuery(name = "EntryPoint.findByUploadUriGroupId", query = "SELECT e FROM EntryPoint e WHERE e.uploadUriGroupId = :uploadUriGroupId"),
    @NamedQuery(name = "EntryPoint.findByUseHttps", query = "SELECT e FROM EntryPoint e WHERE e.useHttps = :useHttps")})
public class EntryPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ram")
    private int ram;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "upload_uri_group_id")
    private int uploadUriGroupId;
    @Column(name = "use_https")
    private Boolean useHttps;
    @JoinTable(name = "entry_point_properties", joinColumns = {
        @JoinColumn(name = "entry_point_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "property_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Property> propertyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryPointId")
    private List<Log> logList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryPointId")
    private List<System> systemList;

    public EntryPoint() {
    }

    public EntryPoint(Integer id) {
        this.id = id;
    }

    public EntryPoint(Integer id, int ram, String name, int uploadUriGroupId) {
        this.id = id;
        this.ram = ram;
        this.name = name;
        this.uploadUriGroupId = uploadUriGroupId;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUploadUriGroupId() {
        return uploadUriGroupId;
    }

    public void setUploadUriGroupId(int uploadUriGroupId) {
        this.uploadUriGroupId = uploadUriGroupId;
    }

    public Boolean getUseHttps() {
        return useHttps;
    }

    public void setUseHttps(Boolean useHttps) {
        this.useHttps = useHttps;
    }

    @XmlTransient
    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    @XmlTransient
    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
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
        if (!(object instanceof EntryPoint)) {
            return false;
        }
        EntryPoint other = (EntryPoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.EntryPoint[ id=" + id + " ]";
    }
    
}
