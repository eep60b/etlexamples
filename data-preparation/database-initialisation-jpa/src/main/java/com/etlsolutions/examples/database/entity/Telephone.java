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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "telephone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telephone.findAll", query = "SELECT t FROM Telephone t"),
    @NamedQuery(name = "Telephone.findByTelephoneId", query = "SELECT t FROM Telephone t WHERE t.telephoneId = :telephoneId"),
    @NamedQuery(name = "Telephone.findByCountryCode", query = "SELECT t FROM Telephone t WHERE t.countryCode = :countryCode"),
    @NamedQuery(name = "Telephone.findByAreaCode", query = "SELECT t FROM Telephone t WHERE t.areaCode = :areaCode"),
    @NamedQuery(name = "Telephone.findByTelephoneNumber", query = "SELECT t FROM Telephone t WHERE t.telephoneNumber = :telephoneNumber"),
    @NamedQuery(name = "Telephone.findByTelephoneType", query = "SELECT t FROM Telephone t WHERE t.telephoneType = :telephoneType")})
public class Telephone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "telephone_id")
    private Integer telephoneId;
    @Basic(optional = false)
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "area_code")
    private String areaCode;
    @Basic(optional = false)
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Basic(optional = false)
    @Column(name = "telephone_type")
    private String telephoneType;
    @ManyToMany(mappedBy = "telephoneSet")
    private Set<PersonalDetail> personalDetailSet;

    public Telephone() {
    }

    public Telephone(Integer telephoneId) {
        this.telephoneId = telephoneId;
    }

    public Telephone(Integer telephoneId, String countryCode, String telephoneNumber, String telephoneType) {
        this.telephoneId = telephoneId;
        this.countryCode = countryCode;
        this.telephoneNumber = telephoneNumber;
        this.telephoneType = telephoneType;
    }

    public Integer getTelephoneId() {
        return telephoneId;
    }

    public void setTelephoneId(Integer telephoneId) {
        this.telephoneId = telephoneId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneType() {
        return telephoneType;
    }

    public void setTelephoneType(String telephoneType) {
        this.telephoneType = telephoneType;
    }

    @XmlTransient
    public Set<PersonalDetail> getPersonalDetailSet() {
        return personalDetailSet;
    }

    public void setPersonalDetailSet(Set<PersonalDetail> personalDetailSet) {
        this.personalDetailSet = personalDetailSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telephoneId != null ? telephoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telephone)) {
            return false;
        }
        Telephone other = (Telephone) object;
        if ((this.telephoneId == null && other.telephoneId != null) || (this.telephoneId != null && !this.telephoneId.equals(other.telephoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.entity.Telephone[ telephoneId=" + telephoneId + " ]";
    }
    
}
