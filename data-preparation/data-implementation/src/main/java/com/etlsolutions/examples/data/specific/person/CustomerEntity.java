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

import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Arrays;
import java.util.Objects;

/**
 * The CustomerEntity class represents an entry of the customer table in the
 * database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class CustomerEntity implements Customer {

    private final PersonAddressLinkEntity personAddressLink;
    private final ImageBytes imageBytes;
    private final String password;
    private final String username;

    /**
     * Construct an object using the given parameters.
     *
     * @param personAddressLink
     * @param imageBytes
     * @param password
     * @param username
     */
    private CustomerEntity(PersonAddressLink personAddressLink, ImageBytes imageBytes, String password, String username) {
        this.personAddressLink = personAddressLink instanceof PersonAddressLinkEntity ? (PersonAddressLinkEntity) personAddressLink : new PersonAddressLinkEntity(personAddressLink);
        this.imageBytes = imageBytes;
        this.password = password;
        this.username = username;
    }

    /**
     * Construct an object using the given parameters.
     *
     * @param personAddressLink
     * @param imageBytes
     * @param password
     * @param username
     */
    public CustomerEntity(PersonAddressLink personAddressLink, ImageBytes imageBytes, PersonalPassword password, PersonalUsername username) {
        this(personAddressLink, imageBytes, password.getValue(), username.getValue());
    }

    /**
     * Construct an object using the given Customer object.
     *
     * @param customer - The specified Customer object.
     */
    public CustomerEntity(Customer customer) {
        this(customer.getPersonAddressLink(), new ImageBytes(customer.getImage()), new PersonalPassword(customer.getPassword()), new PersonalUsername(customer.getUsername()));
    }

    @Override
    public PersonAddressLink getPersonAddressLink() {
        return personAddressLink;
    }

    @Override
    public byte[] getImage() {
        return imageBytes == null ? null : imageBytes.getValue();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.personAddressLink);
        hash = 53 * hash + Objects.hashCode(this.imageBytes);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.username);
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

        final CustomerEntity other = (CustomerEntity) obj;

        return Objects.equals(this.username, other.username) && Objects.equals(this.password, other.password) && Objects.equals(this.imageBytes, other.imageBytes) && Objects.equals(this.personAddressLink, other.personAddressLink);
    }

    @Override
    public boolean hasSameConstraint(Customer customer) {

        if (this == customer) {
            return true;
        }

        if (customer == null) {
            return false;
        }

        return Objects.equals(getUsername(), customer.getUsername());
    }

    @Override
    public boolean hasSameParameters(Customer customer) {

        if (this == customer) {
            return true;
        }

        if (customer == null) {
            return false;
        }

        return Objects.equals(getUsername(), customer.getUsername()) && Objects.equals(getPassword(), customer.getPassword()) && Arrays.equals(getImage(), customer.getImage())
                && ConstrainableUtilities.hasSameParameters(personAddressLink, customer.getPersonAddressLink());
    }
}
