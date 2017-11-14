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
package com.etlsolutions.examples.data.specific.person;

import com.etlsolutions.examples.data.api.PersonTelephoneLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.data.specific.communication.TelephoneEnitity;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import java.util.Objects;

/**
 * The PersonTelephoneLinkEntity class represents a link between a telephone and
 * a person.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonTelephoneLinkEntity implements PersonTelephoneLink {

    private final PersonalDetailEntity personalDetailEntity;
    private final TelephoneEnitity telephoneEnitity;

    /**
     * Construct an object using the given person detail and telephone number.
     * @param personalDetail - The personal detail.
     * @param telephone - The telephone information.
     */
    public PersonTelephoneLinkEntity(PersonalDetail personalDetail, Telephone telephone) {
        this.personalDetailEntity = new PersonalDetailEntity(new PersonalTitle(personalDetail.getTitle()), new GivenName(personalDetail.getGivenName()), new FamilyName(personalDetail.getFamilyName()), new DateOfBirth(personalDetail.getDateOfBirth()), new PersonalProfile(personalDetail.getProfile()));
        this.telephoneEnitity = (telephone instanceof TelephoneEnitity) ? (TelephoneEnitity) telephone : new TelephoneEnitity(telephone);
    }

    public PersonTelephoneLinkEntity(PersonTelephoneLink personTelephoneLink) {
        this(personTelephoneLink.getPersonalDetail(), personTelephoneLink.getTelephone());
    }

    @Override
    public PersonalDetailEntity getPersonalDetail() {
        return personalDetailEntity;
    }

    @Override
    public TelephoneEnitity getTelephone() {
        return telephoneEnitity;
    }

    @Override
    public boolean hasSameConstraint(PersonTelephoneLink personTelephoneLink) {

        if (this == personTelephoneLink) {
            return true;
        }

        if (personTelephoneLink == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(personalDetailEntity, personTelephoneLink.getPersonalDetail()) && ConstrainableUtilities.hasSameConstraint(telephoneEnitity, personTelephoneLink.getTelephone());
    }

    @Override
    public boolean hasSameParameters(PersonTelephoneLink personTelephoneLink) {

        if (this == personTelephoneLink) {
            return true;
        }

        if (personTelephoneLink == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameParameters(telephoneEnitity, personTelephoneLink.getTelephone()) && ConstrainableUtilities.hasSameParameters(personalDetailEntity, personTelephoneLink.getPersonalDetail());
    }

    @Override
    public int hashCode() {

        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.personalDetailEntity);
        hash = 59 * hash + Objects.hashCode(this.telephoneEnitity);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final PersonTelephoneLinkEntity other = (PersonTelephoneLinkEntity) obj;

        return Objects.equals(this.telephoneEnitity, other.telephoneEnitity) && Objects.equals(this.personalDetailEntity, other.personalDetailEntity);
    }

    @Override
    public String toString() {
        return "PersonTelephoneLinkEntity{personalDetailEntity=" + personalDetailEntity + ", telephoneEnitity=" + telephoneEnitity + '}';
    }
}
