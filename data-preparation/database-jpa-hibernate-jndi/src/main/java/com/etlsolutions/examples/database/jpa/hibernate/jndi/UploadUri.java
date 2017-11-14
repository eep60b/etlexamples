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
@Table(name = "upload_uri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UploadUri.findAll", query = "SELECT u FROM UploadUri u"),
    @NamedQuery(name = "UploadUri.findById", query = "SELECT u FROM UploadUri u WHERE u.id = :id"),
    @NamedQuery(name = "UploadUri.findByUri", query = "SELECT u FROM UploadUri u WHERE u.uri = :uri")})
public class UploadUri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "uri")
    private String uri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uploadUri")
    private List<UploadUriGroup> uploadUriGroupList;

    public UploadUri() {
    }

    public UploadUri(Integer id) {
        this.id = id;
    }

    public UploadUri(Integer id, String uri) {
        this.id = id;
        this.uri = uri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @XmlTransient
    public List<UploadUriGroup> getUploadUriGroupList() {
        return uploadUriGroupList;
    }

    public void setUploadUriGroupList(List<UploadUriGroup> uploadUriGroupList) {
        this.uploadUriGroupList = uploadUriGroupList;
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
        if (!(object instanceof UploadUri)) {
            return false;
        }
        UploadUri other = (UploadUri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.UploadUri[ id=" + id + " ]";
    }
    
}
