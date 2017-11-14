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
package com.etlsolutions.examples.mainwebapp.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zhipeng Chang
 */
@Entity
@Table(name = "personal_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalDetail.findAll", query = "SELECT p FROM PersonalDetail p"),
    @NamedQuery(name = "PersonalDetail.findByPersonalDetailId", query = "SELECT p FROM PersonalDetail p WHERE p.personalDetailId = :personalDetailId"),
    @NamedQuery(name = "PersonalDetail.findByTitle", query = "SELECT p FROM PersonalDetail p WHERE p.title = :title"),
    @NamedQuery(name = "PersonalDetail.findByGivenName", query = "SELECT p FROM PersonalDetail p WHERE p.givenName = :givenName"),
    @NamedQuery(name = "PersonalDetail.findByFamilyName", query = "SELECT p FROM PersonalDetail p WHERE p.familyName = :familyName"),
    @NamedQuery(name = "PersonalDetail.findByDateOfBirth", query = "SELECT p FROM PersonalDetail p WHERE p.dateOfBirth = :dateOfBirth")})
public class PersonalDetail implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "personal_detail_id")
    private Integer personalDetailId;
    
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @Column(name = "given_name")
    private String givenName;
    
    @Basic(optional = false)
    @Column(name = "family_name")
    private String familyName;
    
    @Basic(optional = false)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Lob
    @Column(name = "profile")
    private byte[] profile;
    
    @Basic(optional = false)
    @Column(name = "identification")
    private String identification; 
    
    @JoinTable(name = "person_telephone_link", joinColumns = {
        @JoinColumn(name = "personal_detail_id", referencedColumnName = "personal_detail_id")}, inverseJoinColumns = {
        @JoinColumn(name = "telephone_id", referencedColumnName = "telephone_id")})
    @ManyToMany
    private Collection<Telephone> telephoneCollection;
    
    @OneToOne(mappedBy = "personalDetailId")
    private Administrator administrator;
    
    @OneToMany(mappedBy = "personalDetailId")
    private Collection<Email> emailCollection;
    
    @OneToMany(mappedBy = "personalDetailId")
    private Collection<PersonAddressLink> personAddressLinkCollection;
    
    @OneToOne(mappedBy = "personalDetailId")
    private Author author;
    
    @OneToMany(mappedBy = "personalDetailId")
    private Collection<Reviewer> reviewerCollection;

    public PersonalDetail() {
    }

    public PersonalDetail(Integer personalDetailId) {
        this.personalDetailId = personalDetailId;
    }

    public PersonalDetail(Integer personalDetailId, String title, String givenName, String familyName, Date dateOfBirth) {
        this.personalDetailId = personalDetailId;
        this.title = title;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getPersonalDetailId() {
        return personalDetailId;
    }

    public void setPersonalDetailId(Integer personalDetailId) {
        this.personalDetailId = personalDetailId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @XmlTransient
    public Collection<Telephone> getTelephoneCollection() {
        return telephoneCollection;
    }

    public void setTelephoneCollection(Collection<Telephone> telephoneCollection) {
        this.telephoneCollection = telephoneCollection;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @XmlTransient
    public Collection<Email> getEmailCollection() {
        return emailCollection;
    }

    public void setEmailCollection(Collection<Email> emailCollection) {
        this.emailCollection = emailCollection;
    }

    @XmlTransient
    public Collection<PersonAddressLink> getPersonAddressLinkCollection() {
        return personAddressLinkCollection;
    }

    public void setPersonAddressLinkCollection(Collection<PersonAddressLink> personAddressLinkCollection) {
        this.personAddressLinkCollection = personAddressLinkCollection;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @XmlTransient
    public Collection<Reviewer> getReviewerCollection() {
        return reviewerCollection;
    }

    public void setReviewerCollection(Collection<Reviewer> reviewerCollection) {
        this.reviewerCollection = reviewerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personalDetailId != null ? personalDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalDetail)) {
            return false;
        }
        
        PersonalDetail other = (PersonalDetail) object;
        
        return !((this.personalDetailId == null && other.personalDetailId != null) || (this.personalDetailId != null && !this.personalDetailId.equals(other.personalDetailId)));
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.mainwebapp.entity.PersonalDetail[ personalDetailId=" + personalDetailId + " ]";
    }    
}
