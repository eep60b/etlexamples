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
package com.etlsolutions.examples.database.hibernate.pojo;
// Generated 19-Nov-2015 11:29:31 by Hibernate Tools 4.3.1

import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.data.api.TelephoneType;
import com.etlsolutions.examples.data.spi.TelephoneSpi;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;

/**
 * The TelephonePojo class is generated automatically then modified manually.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Generated by NetBeans.
 * @version 1.1.0 - Use the integer type for the field "telephoneId".
 * @version 1.1.1 - Change the field name from "telephoneId" to "id".
 * @version 1.1.2 - Set the initial capacities for the set fields.
 * @version 1.2.0 - Add the implementation of TelephoneSpi.
 */
public class TelephonePojo implements Serializable, TelephoneSpi {

    private static final long serialVersionUID = 8052275371248626L;

    private int id;
    private String countryCode;
    private String areaCode;
    private TelephoneType telephoneType;
    private String telephoneNumber;
    private Set<PersonalDetailPojo> personalDetails = new HashSet<>(3);

    /**
     * Construct an object with no fields are initialised.
     */
    public TelephonePojo() {
    }

    /**
     *
     * @param countryCode
     * @param areaCode
     * @param telephoneType
     * @param telephoneNumber
     */
    public TelephonePojo(String countryCode, String areaCode, TelephoneType telephoneType, String telephoneNumber) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.telephoneType = telephoneType;
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Construct an object using the given Telephone object.
     *
     * @param telephone
     */
    public TelephonePojo(Telephone telephone) {
        this(telephone.getCountryCode(), telephone.getAreaCode(), telephone.getTelephoneType(), telephone.getTelephoneNumber());
    }

    /**
     *
     * @param id
     * @param countryCode
     * @param areaCode
     * @param telephoneType
     * @param telephoneNumber
     */
    public TelephonePojo(int id, String countryCode, String areaCode, TelephoneType telephoneType, String telephoneNumber) {

        this(countryCode, areaCode, telephoneType, telephoneNumber);
        this.id = id;
    }

    /**
     *
     * @param id
     * @param countryCode
     * @param areaCode
     * @param telephoneType
     * @param telephoneNumber
     * @param personalDetails
     */
    public TelephonePojo(int id, String countryCode, String areaCode, TelephoneType telephoneType, String telephoneNumber, Set<PersonalDetailPojo> personalDetails) {
        this(id, countryCode, areaCode, telephoneType, telephoneNumber);
        this.personalDetails = personalDetails == null ? null : new HashSet<>(personalDetails);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getCountryCode() {
        return this.countryCode;
    }

    @Override
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String getAreaCode() {
        return this.areaCode;
    }

    @Override
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public TelephoneType getTelephoneType() {
        return this.telephoneType;
    }

    @Override
    public void setTelephoneType(TelephoneType telephoneType) {
        this.telephoneType = telephoneType;
    }

    @Override
    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    @Override
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Set<PersonalDetailPojo> getPersonalDetails() {
        return personalDetails == null ? null : new HashSet<>(personalDetails);
    }

    public void setPersonalDetails(Set<PersonalDetailPojo> personalDetails) {
        this.personalDetails = personalDetails == null ? null : new HashSet<>(personalDetails);
    }

    @Override
    public boolean hasSameConstraint(Telephone telephone) {

        if (this == telephone) {
            return true;
        }

        if (telephone == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return telephone.hasSameConstraint(((Telephone) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (telephone instanceof HibernateProxy) {
            return hasSameConstraint(((Telephone) (((HibernateProxy) telephone).getHibernateLazyInitializer().getImplementation())));
        }

        if (!Objects.equals(this.countryCode, telephone.getCountryCode())) {
            return false;
        }

        if (!Objects.equals(this.areaCode, telephone.getAreaCode())) {
            return false;
        }

        if (this.telephoneType != telephone.getTelephoneType()) {
            return false;
        }

        return Objects.equals(this.telephoneNumber, telephone.getTelephoneNumber());
    }

    @Override
    public boolean hasSameParameters(Telephone telephone) {
        return hasSameConstraint(telephone);
    }

    @Override
    public int hashCode() {

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }

        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.countryCode);
        hash = 89 * hash + Objects.hashCode(this.areaCode);
        hash = 89 * hash + Objects.hashCode(this.telephoneType);
        hash = 89 * hash + Objects.hashCode(this.telephoneNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().equals(obj);
        }

        if (obj instanceof HibernateProxy) {
            return equals(((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation());
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final TelephonePojo other = (TelephonePojo) obj;
        if (this.id != other.id) {
            return false;
        }

        if (!Objects.equals(this.countryCode, other.countryCode)) {
            return false;
        }

        if (!Objects.equals(this.areaCode, other.areaCode)) {
            return false;
        }

        if (this.telephoneType != other.telephoneType) {
            return false;
        }

        return Objects.equals(this.telephoneNumber, other.telephoneNumber);
    }

    @Override
    public String toString() {
        return "TelephonePojo{country code=" + countryCode + ", area code=" + areaCode + ", type=" + telephoneType + ", telephone number=" + telephoneNumber + '}';
    }
}
