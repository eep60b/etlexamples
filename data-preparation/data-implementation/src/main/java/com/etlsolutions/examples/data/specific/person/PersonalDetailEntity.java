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

import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.utility.CalendarUtilities;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Date;
import java.util.Objects;

/**
 * The PersonalDetailEntity class contains detailed information about a person.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @author 1.0.0
 */
@ImmutableClass
@DataClass
public final class PersonalDetailEntity implements PersonalDetail {

    private final String title;
    private final String givenName;
    private final String familyName;
    private final DateOfBirth dateOfBirth;
    private final PersonalProfile personalProfile;
    
     /**
     * Construct an object use the specified columns.
     *
     * @param title - The title column.
     * @param givenName - The given name column.
     * @param familyName - The family name column.
     * @param dateOfBirth - The date of birth column.
     * @param personalProfile - The personal profile column.
     */
    private PersonalDetailEntity(String title, String givenName, String familyName, DateOfBirth dateOfBirth, PersonalProfile personalProfile) {
        
        this.familyName = familyName;
        this.givenName = givenName;
        this.title = title;
        this.dateOfBirth = dateOfBirth;        
        this.personalProfile = personalProfile;
    }   

    /**
     * Construct an object use the specified columns.
     *
     * @param personTitle - The title column.
     * @param givenName - The given name column.
     * @param familyName - The family name column.
     * @param dateOfBirth - The date of birth column.
     * @param personalProfile - The personal profile column.
     */
    public PersonalDetailEntity(PersonalTitle personTitle, GivenName givenName, FamilyName familyName, DateOfBirth dateOfBirth, PersonalProfile personalProfile) {
        
        this.dateOfBirth = dateOfBirth;
        this.familyName = familyName.getValue();
        this.givenName = givenName.getValue();
        this.title = personTitle.getValue();
        this.personalProfile = personalProfile;
    }

    public PersonalDetailEntity(PersonalDetail personalDetail) {
        this(personalDetail.getTitle(), personalDetail.getGivenName(), personalDetail.getFamilyName(), 
                new DateOfBirth(personalDetail.getDateOfBirth()), new PersonalProfile(personalDetail.getProfile()));
    }
       
    @Override
    public Date getDateOfBirth() {
        return dateOfBirth == null ? null : dateOfBirth.getValue();
    }

    @Override
    public String getFamilyName() {
        return familyName;
    }

    @Override
    public String getGivenName() {
        return givenName;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public byte[] getProfile() {
        return personalProfile == null ? null : personalProfile.getValue();
    }

    @Override
    public boolean hasSameConstraint(PersonalDetail personalDetail) {

        if (this == personalDetail) {
            return true;
        }

        return personalDetail == null ? false : Objects.deepEquals(getProfile(), personalDetail.getProfile());
    }

    @Override
    public boolean hasSameParameters(PersonalDetail personalDetail) {
        
        if (this == personalDetail) {
            return true;
        }
        
        if(personalDetail == null) {
            return false;
        }

        if (!Objects.equals(getTitle(), personalDetail.getTitle())) {
            return false;
        }

        if (!Objects.equals(getGivenName(), personalDetail.getGivenName())) {
            return false;
        }
        if (!Objects.equals(getFamilyName(), personalDetail.getFamilyName())) {
            return false;
        }

        if (!CalendarUtilities.areSameDates(getDateOfBirth(), personalDetail.getDateOfBirth())) {
            return false;
        }

        return Objects.deepEquals(getProfile(), personalDetail.getProfile());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.title);
        hash = 31 * hash + Objects.hashCode(this.givenName);
        hash = 31 * hash + Objects.hashCode(this.familyName);
        hash = 31 * hash + Objects.hashCode(this.dateOfBirth);
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

        final PersonalDetailEntity other = (PersonalDetailEntity) obj;

        if (!Objects.equals(this.title, other.title)) {
            return false;
        }

        if (!Objects.equals(this.givenName, other.givenName)) {
            return false;
        }
        if (!Objects.equals(this.familyName, other.familyName)) {
            return false;
        }

        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }

        return Objects.equals(this.personalProfile, other.personalProfile);
    }

    @Override
    public String toString() {
        return "PersonalDetailEntity{title=" + getTitle() + ", given name=" + getGivenName() + ", family name=" + getFamilyName() + '}';
    }
}
