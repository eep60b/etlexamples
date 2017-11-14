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

import com.etlsolutions.examples.data.api.AdministratorRole;
import com.etlsolutions.examples.data.api.Administrator;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The AdministratorEntity class represents an entry in the Administrator table
 * in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class AdministratorEntity implements Administrator {

    private final PersonalDetailEntity personalDetail;
    private final String password;
    private final String username;
    private final AdministratorRole administratorRole;

    /**
     * Construct an object using the given parameters.
     *
     * @param personalDetail - The personal detail.
     * @param password - The administrator password.
     * @param username - The administrator username.
     * @param administratorRole - The administrator role.
     *
     * @throws NullPointerException if one the parameter is null.
     */
    private AdministratorEntity(PersonalDetail personalDetail, String password, String username, AdministratorRole administratorRole) {

        this.personalDetail = personalDetail instanceof PersonalDetailEntity ? (PersonalDetailEntity) personalDetail : new PersonalDetailEntity(new PersonalTitle(personalDetail.getTitle()), new GivenName(personalDetail.getGivenName()), new FamilyName(personalDetail.getFamilyName()), new DateOfBirth(personalDetail.getDateOfBirth()), new PersonalProfile(personalDetail.getProfile()));

        this.password = password;
        this.username = username;
        this.administratorRole = administratorRole;
    }

    /**
     * Construct an object using the given parameters.
     *
     * @param personalDetail - The personal detail.
     * @param password - The administrator password.
     * @param username - The administrator username.
     * @param administratorRole - The administrator role.
     *
     * @throws NullPointerException if one the parameter is null.
     */
    public AdministratorEntity(PersonalDetail personalDetail, PersonalPassword password, PersonalUsername username, AdministratorRole administratorRole) {
        this.personalDetail = personalDetail instanceof PersonalDetailEntity ? (PersonalDetailEntity) personalDetail : new PersonalDetailEntity(new PersonalTitle(personalDetail.getTitle()), new GivenName(personalDetail.getGivenName()), new FamilyName(personalDetail.getFamilyName()), new DateOfBirth(personalDetail.getDateOfBirth()), new PersonalProfile(personalDetail.getProfile()));

        this.password = password.getValue();
        this.username = username.getValue();
        this.administratorRole = administratorRole;
    }

    /**
     * Construct an object using the given Administrator object.
     *
     * @param administrator - The specified Administrator object.
     * @throws NullPointerException if the Administrator object is null.
     */
    public AdministratorEntity(Administrator administrator) {
        this(administrator.getPersonalDetail(), new PersonalPassword(administrator.getPassword()),
                new PersonalUsername(administrator.getUsername()), administrator.getRole());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public AdministratorRole getRole() {
        return administratorRole;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public PersonalDetail getPersonalDetail() {
        return personalDetail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.personalDetail);
        hash = 61 * hash + Objects.hashCode(this.password);
        hash = 61 * hash + Objects.hashCode(this.username);
        hash = 61 * hash + Objects.hashCode(this.administratorRole);
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

        final AdministratorEntity other = (AdministratorEntity) obj;

        if (!Objects.equals(this.personalDetail, other.personalDetail)) {
            return false;
        }

        if (!Objects.equals(this.password, other.password)) {
            return false;
        }

        if (!Objects.equals(this.username, other.username)) {
            return false;
        }

        return this.administratorRole == other.administratorRole;
    }

    @Override
    public String toString() {
        return "AdministratorEntity{username=" + username + '}';
    }

    @Override
    public boolean hasSameConstraint(Administrator administrator) {

        if (this == administrator) {
            return true;
        }

        if (administrator == null) {
            return false;
        }

        return Objects.equals(getUsername(), administrator.getUsername());
    }

    @Override
    public boolean hasSameParameters(Administrator administrator) {

        if (this == administrator) {
            return true;
        }

        if (administrator == null) {
            return false;
        }

        PersonalDetail p = administrator.getPersonalDetail();

        if (personalDetail != p && !personalDetail.hasSameParameters(p)) {          //personalDetail will not be null.
            return false;
        }

        if (!Objects.equals(getPassword(), administrator.getPassword())) {
            return false;
        }

        if (!Objects.equals(getUsername(), administrator.getUsername())) {
            return false;
        }

        return administratorRole == administrator.getRole();
    }
}
