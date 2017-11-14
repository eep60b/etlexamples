/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author zc
 */
@Embeddable
public class UploadUriGroupPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "upload_uri_id")
    private int uploadUriId;

    public UploadUriGroupPK() {
    }

    public UploadUriGroupPK(int id, int uploadUriId) {
        this.id = id;
        this.uploadUriId = uploadUriId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUploadUriId() {
        return uploadUriId;
    }

    public void setUploadUriId(int uploadUriId) {
        this.uploadUriId = uploadUriId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) uploadUriId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UploadUriGroupPK)) {
            return false;
        }
        UploadUriGroupPK other = (UploadUriGroupPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.uploadUriId != other.uploadUriId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.UploadUriGroupPK[ id=" + id + ", uploadUriId=" + uploadUriId + " ]";
    }
    
}
