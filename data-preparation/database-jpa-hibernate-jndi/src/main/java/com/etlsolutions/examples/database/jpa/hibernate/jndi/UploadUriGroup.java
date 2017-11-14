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
@Table(name = "upload_uri_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UploadUriGroup.findAll", query = "SELECT u FROM UploadUriGroup u"),
    @NamedQuery(name = "UploadUriGroup.findById", query = "SELECT u FROM UploadUriGroup u WHERE u.uploadUriGroupPK.id = :id"),
    @NamedQuery(name = "UploadUriGroup.findByUploadUriId", query = "SELECT u FROM UploadUriGroup u WHERE u.uploadUriGroupPK.uploadUriId = :uploadUriId"),
    @NamedQuery(name = "UploadUriGroup.findByPriority", query = "SELECT u FROM UploadUriGroup u WHERE u.priority = :priority")})
public class UploadUriGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UploadUriGroupPK uploadUriGroupPK;
    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;
    @JoinColumn(name = "upload_uri_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UploadUri uploadUri;

    public UploadUriGroup() {
    }

    public UploadUriGroup(UploadUriGroupPK uploadUriGroupPK) {
        this.uploadUriGroupPK = uploadUriGroupPK;
    }

    public UploadUriGroup(UploadUriGroupPK uploadUriGroupPK, int priority) {
        this.uploadUriGroupPK = uploadUriGroupPK;
        this.priority = priority;
    }

    public UploadUriGroup(int id, int uploadUriId) {
        this.uploadUriGroupPK = new UploadUriGroupPK(id, uploadUriId);
    }

    public UploadUriGroupPK getUploadUriGroupPK() {
        return uploadUriGroupPK;
    }

    public void setUploadUriGroupPK(UploadUriGroupPK uploadUriGroupPK) {
        this.uploadUriGroupPK = uploadUriGroupPK;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public UploadUri getUploadUri() {
        return uploadUri;
    }

    public void setUploadUri(UploadUri uploadUri) {
        this.uploadUri = uploadUri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uploadUriGroupPK != null ? uploadUriGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UploadUriGroup)) {
            return false;
        }
        UploadUriGroup other = (UploadUriGroup) object;
        if ((this.uploadUriGroupPK == null && other.uploadUriGroupPK != null) || (this.uploadUriGroupPK != null && !this.uploadUriGroupPK.equals(other.uploadUriGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.UploadUriGroup[ uploadUriGroupPK=" + uploadUriGroupPK + " ]";
    }
    
}
