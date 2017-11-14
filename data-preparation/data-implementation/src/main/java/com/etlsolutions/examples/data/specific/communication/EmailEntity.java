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

import com.etlsolutions.examples.data.api.Email;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The EmailEntity represents an entry of EMAIL table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class EmailEntity implements Email {

    private final String emailAddress;
    private final PersonalDetailEntity personalDetailEntity;

    /**
     * Construct an object using the given email address and personal detail.
     *
     * @param emailAddress - The email address.
     * @param personalDetail - The personal detail.
     */
    public EmailEntity(String emailAddress, PersonalDetail personalDetail) {
        this.emailAddress = emailAddress;
        this.personalDetailEntity = personalDetail instanceof PersonalDetailEntity ? (PersonalDetailEntity) personalDetail : new PersonalDetailEntity(personalDetail);
    }

    /**
     * Construct an object using the given email address and personal detail.
     *
     * @param emailAddress - The email address.
     * @param personalDetail - The personal detail.
     */
    public EmailEntity(EmailAddress emailAddress, PersonalDetail personalDetail) {

        this(emailAddress.getValue(), personalDetail);
    }
    
    /**
     * Construct an EmailEntity using the information in the given Email object.
     *
     * @param email - The given email object.
     *
     * @throws NullPointerException if the email parameter is null.
     */
    public EmailEntity(Email email) {
        this(email.getEmailAddress(), email.getPersonalDetail());
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public PersonalDetailEntity getPersonalDetail() {
        return personalDetailEntity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.emailAddress);
        hash = 31 * hash + Objects.hashCode(this.personalDetailEntity);
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

        if (getClass() != obj.getClass()) {
            return false;
        }

        final EmailEntity other = (EmailEntity) obj;

        if (!Objects.equals(this.emailAddress, other.emailAddress)) {
            return false;
        }

        return Objects.equals(this.personalDetailEntity, other.personalDetailEntity);
    }

    @Override
    public String toString() {
        return "EmailEnitity{Email address=" + getEmailAddress() + '}';
    }

    @Override
    public boolean hasSameConstraint(Email email) {

        if (this == email) {
            return true;
        }

        if (email == null) {
            return false;
        }

        return Objects.equals(getEmailAddress(), email.getEmailAddress());
    }

    @Override
    public boolean hasSameParameters(Email email) {

        if (this == email) {
            return true;
        }

        if (email == null) {
            return false;
        }

        if (!Objects.equals(getEmailAddress(), email.getEmailAddress())) {
            return false;
        }

        PersonalDetail p = email.getPersonalDetail();

        return personalDetailEntity == p || personalDetailEntity.hasSameParameters(p);
    }
}
