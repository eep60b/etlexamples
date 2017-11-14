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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zhipeng
 */
@Entity
@Table(name = "person_address_link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonAddressLink.findAll", query = "SELECT p FROM PersonAddressLink p"),
    @NamedQuery(name = "PersonAddressLink.findByLinkId", query = "SELECT p FROM PersonAddressLink p WHERE p.linkId = :linkId"),
    @NamedQuery(name = "PersonAddressLink.findByAddressType", query = "SELECT p FROM PersonAddressLink p WHERE p.addressType = :addressType")})
public class PersonAddressLink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "link_id")
    private Integer linkId;
    @Basic(optional = false)
    @Column(name = "address_type")
    private String addressType;
    @OneToMany(mappedBy = "personAddressLinkId")
    private Collection<MastercardPayment> mastercardPaymentCollection;
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne
    private Address addressId;
    @JoinColumn(name = "personal_detail_id", referencedColumnName = "personal_detail_id")
    @ManyToOne
    private PersonalDetail personalDetailId;
    @OneToMany(mappedBy = "personAddressLinkId")
    private Collection<VisacardPayment> visacardPaymentCollection;
    @OneToMany(mappedBy = "personAddressLinkId")
    private Collection<AmexcardPayment> amexcardPaymentCollection;
    @OneToMany(mappedBy = "personAddressLinkId")
    private Collection<DebitcardPayment> debitcardPaymentCollection;
    @OneToOne(mappedBy = "personAddressLinkId")
    private Customer customer;

    public PersonAddressLink() {
    }

    public PersonAddressLink(Integer linkId) {
        this.linkId = linkId;
    }

    public PersonAddressLink(Integer linkId, String addressType) {
        this.linkId = linkId;
        this.addressType = addressType;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @XmlTransient
    public Collection<MastercardPayment> getMastercardPaymentCollection() {
        return mastercardPaymentCollection;
    }

    public void setMastercardPaymentCollection(Collection<MastercardPayment> mastercardPaymentCollection) {
        this.mastercardPaymentCollection = mastercardPaymentCollection;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public PersonalDetail getPersonalDetailId() {
        return personalDetailId;
    }

    public void setPersonalDetailId(PersonalDetail personalDetailId) {
        this.personalDetailId = personalDetailId;
    }

    @XmlTransient
    public Collection<VisacardPayment> getVisacardPaymentCollection() {
        return visacardPaymentCollection;
    }

    public void setVisacardPaymentCollection(Collection<VisacardPayment> visacardPaymentCollection) {
        this.visacardPaymentCollection = visacardPaymentCollection;
    }

    @XmlTransient
    public Collection<AmexcardPayment> getAmexcardPaymentCollection() {
        return amexcardPaymentCollection;
    }

    public void setAmexcardPaymentCollection(Collection<AmexcardPayment> amexcardPaymentCollection) {
        this.amexcardPaymentCollection = amexcardPaymentCollection;
    }

    @XmlTransient
    public Collection<DebitcardPayment> getDebitcardPaymentCollection() {
        return debitcardPaymentCollection;
    }

    public void setDebitcardPaymentCollection(Collection<DebitcardPayment> debitcardPaymentCollection) {
        this.debitcardPaymentCollection = debitcardPaymentCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linkId != null ? linkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonAddressLink)) {
            return false;
        }
        PersonAddressLink other = (PersonAddressLink) object;
        if ((this.linkId == null && other.linkId != null) || (this.linkId != null && !this.linkId.equals(other.linkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.mainwebapp.entity.PersonAddressLink[ linkId=" + linkId + " ]";
    }
    
}
