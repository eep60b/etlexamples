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

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The AuthorEntity class represents an book author. It implements the Author
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
public final class AuthorEntity implements Author {

    private final PersonalDetailEntity personalDetail;
    private final PersonalBiography biography;
    private final WebpageUrl webPageUrl;
    private final ImageBytes image;

    /**
     * Construct an object using the given parameters.
     * @param personalDetail
     * @param biography
     * @param webPageUrl
     * @param image
     */
    public AuthorEntity(PersonalDetail personalDetail, PersonalBiography biography, WebpageUrl webPageUrl, ImageBytes image) {
        this.personalDetail = personalDetail instanceof PersonalDetailEntity ? (PersonalDetailEntity) personalDetail : new PersonalDetailEntity(new PersonalTitle(personalDetail.getTitle()), new GivenName(personalDetail.getGivenName()), new FamilyName(personalDetail.getFamilyName()), new DateOfBirth(personalDetail.getDateOfBirth()), new PersonalProfile(personalDetail.getProfile()));
        this.biography = biography;
        this.webPageUrl = webPageUrl;
        this.image = image;
    }

    /**
     * Construct an object using the given parameters.
     * @param personalDetail
     * @param biography
     * @param url
     * @param image 
     */
    private AuthorEntity(PersonalDetail personalDetail, byte[] biography, String url, byte[] image) {
        this(personalDetail, new PersonalBiography(biography), new WebpageUrl(url), new ImageBytes(image));
    }
     
    /**
     * Construct an object using the given Author object.
     * 
     * @param author - The specified Author object.
     */
    public AuthorEntity(Author author) {
        this(author.getPersonalDetail(), author.getBiography(), author.getWebpageUrl(), author.getImage());
    }


    @Override
    public byte[] getBiography() {
        return biography.getValue();
    }

    @Override
    public String getWebpageUrl() {
        return webPageUrl.getValue();
    }

    @Override
    public byte[] getImage() {
        return image.getValue();
    }

    @Override
    public PersonalDetailEntity getPersonalDetail() {
        return personalDetail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.personalDetail);
        hash = 37 * hash + Objects.hashCode(this.webPageUrl);
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

        final AuthorEntity other = (AuthorEntity) obj;

        if (!Objects.equals(this.personalDetail, other.personalDetail)) {
            return false;
        }

        if (!Objects.equals(this.biography, other.biography)) {
            return false;
        }

        if (!Objects.equals(this.webPageUrl, other.webPageUrl)) {
            return false;
        }

        return Objects.equals(this.image, other.image);
    }

    @Override
    public boolean hasSameConstraint(Author author) {

        if (this == author) {
            return true;
        }

        if (author == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(personalDetail, author.getPersonalDetail());
    }

    @Override
    public boolean hasSameParameters(Author author) {

        if (this == author) {
            return true;
        }

        if (author == null) {
            return false;
        }
                         
        if (!Objects.deepEquals(getBiography(), author.getBiography())) {
            return false;
        }

        if (!Objects.equals(getWebpageUrl(), author.getWebpageUrl())) {
            return false;
        }

        if (!Objects.deepEquals(getImage(), author.getImage())) {
            return false;
        }

        return ConstrainableUtilities.hasSameParameters(personalDetail, author.getPersonalDetail());
    }

    @Override
    public String toString() {
        return "AuthorEntity{personalDetail=" + personalDetail + '}';
    }
}
