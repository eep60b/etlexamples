/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.database.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "reviewer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reviewer.findAll", query = "SELECT r FROM Reviewer r"),
    @NamedQuery(name = "Reviewer.findByReviewerId", query = "SELECT r FROM Reviewer r WHERE r.reviewerId = :reviewerId"),
    @NamedQuery(name = "Reviewer.findByUsername", query = "SELECT r FROM Reviewer r WHERE r.username = :username"),
    @NamedQuery(name = "Reviewer.findByPassword", query = "SELECT r FROM Reviewer r WHERE r.password = :password")})
public class Reviewer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "reviewer_id")
    private Integer reviewerId;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "reviewerId")
    private Set<Review> reviewSet;
    @JoinColumn(name = "personal_detail_id", referencedColumnName = "personal_detail_id")
    @ManyToOne
    private PersonalDetail personalDetailId;

    public Reviewer() {
    }

    public Reviewer(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Reviewer(Integer reviewerId, String username, String password) {
        this.reviewerId = reviewerId;
        this.username = username;
        this.password = password;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Set<Review> getReviewSet() {
        return reviewSet;
    }

    public void setReviewSet(Set<Review> reviewSet) {
        this.reviewSet = reviewSet;
    }

    public PersonalDetail getPersonalDetailId() {
        return personalDetailId;
    }

    public void setPersonalDetailId(PersonalDetail personalDetailId) {
        this.personalDetailId = personalDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewerId != null ? reviewerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reviewer)) {
            return false;
        }
        Reviewer other = (Reviewer) object;
        if ((this.reviewerId == null && other.reviewerId != null) || (this.reviewerId != null && !this.reviewerId.equals(other.reviewerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.entity.Reviewer[ reviewerId=" + reviewerId + " ]";
    }
    
}
