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
package com.etlsolutions.examples.data.specific.communication;

import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The PersonAddressLinkEntity class represents a link between a personalDetail
 * and an address.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class PersonAddressLinkEntity implements PersonAddressLink {

    private final AddressEntity address;
    private final PersonalDetailEntity personalDetail;
    private final AddressType addressType;

    /**
     * Construct a PersonAddressLinkEntity object with the same parameters from
     * a PersonAddressLink object.
     *
     * @param personAddressLink - The specified PersonAddressLink object.
     */
    public PersonAddressLinkEntity(PersonAddressLink personAddressLink) {
        this(personAddressLink.getAddress(), personAddressLink.getPersonalDetail(), personAddressLink.getAddressType());
    }

    /**
     * Construct a PersonAddressLinkEntity object with the specified parameters.
     *
     * @param address - The address information.
     * @param personalDetail - The personal detail information.
     * @param addressType - The address type.
     */
    public PersonAddressLinkEntity(Address address, PersonalDetail personalDetail, AddressType addressType) {
        
        if(addressType == null) {
            throw new NullPointerException(MessageFactory.getMessage(ErrorType.NULL_PARAMETER, addressType));
        }
        this.address = address instanceof AddressEntity ? (AddressEntity) address : new AddressEntity(address);
        this.personalDetail  = personalDetail instanceof PersonalDetailEntity ? (PersonalDetailEntity) personalDetail : new PersonalDetailEntity(personalDetail);
        this.addressType = addressType;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public PersonalDetail getPersonalDetail() {
        return personalDetail;
    }

    @Override
    public AddressType getAddressType() {
        return addressType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.address);
        hash = 53 * hash + Objects.hashCode(this.personalDetail);
        hash = 53 * hash + Objects.hashCode(this.addressType);
        return hash;
    }

    @Override
    public boolean hasSameConstraint(PersonAddressLink personAddressLink) {

        if (this == personAddressLink) {
            return true;
        }

        if (personAddressLink == null) {
            return false;
        }

        return address.hasSameConstraint(personAddressLink.getAddress())
                && personalDetail.hasSameConstraint(personAddressLink.getPersonalDetail())
                && addressType == personAddressLink.getAddressType();
    }

    @Override
    public boolean hasSameParameters(PersonAddressLink personAddressLink) {

        if (this == personAddressLink) {
            return true;
        }

        if (personAddressLink == null) {
            return false;
        }

        return address.hasSameParameters(personAddressLink.getAddress())
                && personalDetail.hasSameParameters(personAddressLink.getPersonalDetail())
                && addressType == personAddressLink.getAddressType();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final PersonAddressLinkEntity other = (PersonAddressLinkEntity) obj;

        if (!Objects.equals(this.address, other.address)) {
            return false;
        }

        if (!Objects.equals(this.personalDetail, other.personalDetail)) {
            return false;
        }

        return this.addressType == other.addressType;
    }

    @Override
    public String toString() {
        return "PersonAddressLinkEntity{" + "address=" + address + ", person=" + personalDetail + ", addressType=" + addressType + '}';
    }
}
