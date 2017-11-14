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
import com.etlsolutions.examples.data.api.Reviewer;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The ReviewerEntity class is the simplest implementation of the Reviewer
 * interface.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class ReviewerEntity implements Reviewer {

    private final PersonalDetailEntity personalDetail;
    private final String username;
    private final String password;
    private final ImageBytes image;

    private ReviewerEntity(PersonalDetail personalDetail, String username, String password, ImageBytes image) {
        this.personalDetail = personalDetail instanceof PersonalDetailEntity ? (PersonalDetailEntity) personalDetail : new PersonalDetailEntity(personalDetail);
        this.username = username;
        this.password = password;
        this.image = image;
    }

    /**
     *
     * @param personalDetail
     * @param username
     * @param password
     * @param image
     */
    public ReviewerEntity(PersonalDetail personalDetail, PersonalUsername username, PersonalPassword password, ImageBytes image) {

        this(personalDetail, username.getValue(), password.getValue(), image);
    }

    public ReviewerEntity(Reviewer reviewer) {
        this(reviewer.getPersonalDetail(), reviewer.getUsername(), reviewer.getPassword(), new ImageBytes(reviewer.getImage()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public byte[] getImage() {
        return image == null ? null : image.getValue();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public PersonalDetailEntity getPersonalDetail() {
        return personalDetail;
    }

    @Override
    public boolean hasSameConstraint(Reviewer reviewer) {

        if (this == reviewer) {
            return true;
        }

        if (reviewer == null) {
            return false;
        }

        return Objects.equals(reviewer.getUsername(), getUsername());
    }

    @Override
    public boolean hasSameParameters(Reviewer reviewer) {

        if (this == reviewer) {
            return true;
        }

        if (reviewer == null) {
            return false;
        }

        if (!Objects.equals(getUsername(), reviewer.getUsername())) {
            return false;
        }

        if (!Objects.equals(getPassword(), reviewer.getPassword())) {
            return false;
        }

        if (!Objects.deepEquals(getImage(), reviewer.getImage())) {
            return false;
        }
        
        return ConstrainableUtilities.hasSameParameters(personalDetail, reviewer.getPersonalDetail());
    }

    @Override
    public int hashCode() {

        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.personalDetail);
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.password);
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

        final ReviewerEntity other = (ReviewerEntity) obj;
        if (!Objects.equals(this.personalDetail, other.personalDetail)) {
            return false;
        }

        if (!Objects.equals(this.username, other.username)) {
            return false;
        }

        if (!Objects.equals(this.password, other.password)) {
            return false;
        }

        return Objects.equals(this.image, other.image);
    }

    @Override
    public String toString() {
        return "ReviewerEntity{name=" + personalDetail.getGivenName() + " " + personalDetail.getFamilyName() + ", username=" + getUsername() + '}';
    }
}
