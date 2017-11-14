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
@Table(name = "element_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElementMapping.findAll", query = "SELECT e FROM ElementMapping e"),
    @NamedQuery(name = "ElementMapping.findById", query = "SELECT e FROM ElementMapping e WHERE e.id = :id"),
    @NamedQuery(name = "ElementMapping.findByElementPrefix", query = "SELECT e FROM ElementMapping e WHERE e.elementPrefix = :elementPrefix"),
    @NamedQuery(name = "ElementMapping.findByNewElementPrefix", query = "SELECT e FROM ElementMapping e WHERE e.newElementPrefix = :newElementPrefix")})
public class ElementMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "element_prefix")
    private String elementPrefix;
    @Basic(optional = false)
    @Column(name = "new_element_prefix")
    private String newElementPrefix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elementMapping")
    private List<ElementMappingGroup> elementMappingGroupList;

    public ElementMapping() {
    }

    public ElementMapping(Integer id) {
        this.id = id;
    }

    public ElementMapping(Integer id, String elementPrefix, String newElementPrefix) {
        this.id = id;
        this.elementPrefix = elementPrefix;
        this.newElementPrefix = newElementPrefix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElementPrefix() {
        return elementPrefix;
    }

    public void setElementPrefix(String elementPrefix) {
        this.elementPrefix = elementPrefix;
    }

    public String getNewElementPrefix() {
        return newElementPrefix;
    }

    public void setNewElementPrefix(String newElementPrefix) {
        this.newElementPrefix = newElementPrefix;
    }

    @XmlTransient
    public List<ElementMappingGroup> getElementMappingGroupList() {
        return elementMappingGroupList;
    }

    public void setElementMappingGroupList(List<ElementMappingGroup> elementMappingGroupList) {
        this.elementMappingGroupList = elementMappingGroupList;
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
        if (!(object instanceof ElementMapping)) {
            return false;
        }
        ElementMapping other = (ElementMapping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.ElementMapping[ id=" + id + " ]";
    }
    
}
