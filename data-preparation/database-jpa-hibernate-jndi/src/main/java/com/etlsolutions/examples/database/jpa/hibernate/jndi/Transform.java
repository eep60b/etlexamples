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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "transform")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transform.findAll", query = "SELECT t FROM Transform t"),
    @NamedQuery(name = "Transform.findById", query = "SELECT t FROM Transform t WHERE t.id = :id"),
    @NamedQuery(name = "Transform.findByProjectclassname", query = "SELECT t FROM Transform t WHERE t.projectclassname = :projectclassname"),
    @NamedQuery(name = "Transform.findByDescription", query = "SELECT t FROM Transform t WHERE t.description = :description")})
public class Transform implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "projectclassname")
    private String projectclassname;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "transformList")
    private List<Channel> channelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transform")
    private List<TransformGroup> transformGroupList;
    @OneToMany(mappedBy = "transformFilterId")
    private List<SystemProperties> systemPropertiesList;
    @JoinColumn(name = "source_adapter_property_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdapterProperties sourceAdapterPropertyId;
    @JoinColumn(name = "target_adapter_property_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdapterProperties targetAdapterPropertyId;
    @OneToMany(mappedBy = "childTransformId")
    private List<Transform> transformList;
    @JoinColumn(name = "child_transform_id", referencedColumnName = "id")
    @ManyToOne
    private Transform childTransformId;
    @JoinColumn(name = "transform_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransformType transformTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transform")
    private List<ElementMappingGroup> elementMappingGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transformId")
    private List<LogEntry> logEntryList;

    public Transform() {
    }

    public Transform(Integer id) {
        this.id = id;
    }

    public Transform(Integer id, String projectclassname) {
        this.id = id;
        this.projectclassname = projectclassname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectclassname() {
        return projectclassname;
    }

    public void setProjectclassname(String projectclassname) {
        this.projectclassname = projectclassname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    @XmlTransient
    public List<TransformGroup> getTransformGroupList() {
        return transformGroupList;
    }

    public void setTransformGroupList(List<TransformGroup> transformGroupList) {
        this.transformGroupList = transformGroupList;
    }

    @XmlTransient
    public List<SystemProperties> getSystemPropertiesList() {
        return systemPropertiesList;
    }

    public void setSystemPropertiesList(List<SystemProperties> systemPropertiesList) {
        this.systemPropertiesList = systemPropertiesList;
    }

    public AdapterProperties getSourceAdapterPropertyId() {
        return sourceAdapterPropertyId;
    }

    public void setSourceAdapterPropertyId(AdapterProperties sourceAdapterPropertyId) {
        this.sourceAdapterPropertyId = sourceAdapterPropertyId;
    }

    public AdapterProperties getTargetAdapterPropertyId() {
        return targetAdapterPropertyId;
    }

    public void setTargetAdapterPropertyId(AdapterProperties targetAdapterPropertyId) {
        this.targetAdapterPropertyId = targetAdapterPropertyId;
    }

    @XmlTransient
    public List<Transform> getTransformList() {
        return transformList;
    }

    public void setTransformList(List<Transform> transformList) {
        this.transformList = transformList;
    }

    public Transform getChildTransformId() {
        return childTransformId;
    }

    public void setChildTransformId(Transform childTransformId) {
        this.childTransformId = childTransformId;
    }

    public TransformType getTransformTypeId() {
        return transformTypeId;
    }

    public void setTransformTypeId(TransformType transformTypeId) {
        this.transformTypeId = transformTypeId;
    }

    @XmlTransient
    public List<ElementMappingGroup> getElementMappingGroupList() {
        return elementMappingGroupList;
    }

    public void setElementMappingGroupList(List<ElementMappingGroup> elementMappingGroupList) {
        this.elementMappingGroupList = elementMappingGroupList;
    }

    @XmlTransient
    public List<LogEntry> getLogEntryList() {
        return logEntryList;
    }

    public void setLogEntryList(List<LogEntry> logEntryList) {
        this.logEntryList = logEntryList;
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
        if (!(object instanceof Transform)) {
            return false;
        }
        Transform other = (Transform) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.Transform[ id=" + id + " ]";
    }
    
}
