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
package com.etlsolutions.examples.data.specific.book;

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.Publisher;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The PublisherEntity class represent a book publisher. This class is partially
 * immutable. The address and the publisher name fields cannot be modified after
 * the object is constructed. The books, however, can be added to or removed
 * from the publisher.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class PublisherEntity implements Publisher {

    private final AddressEntity address;
    private final String name;

    /**
     * Construct an object using the given Publisher object. If the given object
     * is a type of PublisherEntity.
     *
     * @param publisher - The Publisher object.
     * @throws NullPointerException if the Publisher object in null.
     */
    public PublisherEntity(Publisher publisher) {
        this(publisher.getAddress(), publisher.getName());
    }

    /**
     * Construct an object using the given address and publish name.
     *
     * @param address - The publisher address.
     * @param publisherName - The publisher name.
     * @throws NullPointerException if either the Address object or the
     * PublisherName object is null.
     */
    public PublisherEntity(Address address, NameWrapper publisherName) {
        this(address, publisherName.getValue());
    }

    /**
     * Construct an object using the given address and publish name.
     *
     * @param address - The publisher address.
     * @param name - The publisher name.
     */
    public PublisherEntity(Address address, String name) {
        this.address = address instanceof AddressEntity ? (AddressEntity) address : new AddressEntity(address);
        this.name = name;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.address);
        hash = 89 * hash + Objects.hashCode(this.name);
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

        final PublisherEntity other = (PublisherEntity) obj;

        return Objects.equals(this.name, other.name) && Objects.equals(this.address, other.address);
    }

    @Override
    public String toString() {
        return "PublisherEntity{Name=" + getName() + '}';
    }

    @Override
    public boolean hasSameConstraint(Publisher publisher) {

        if (this == publisher) {
            return true;
        }

        if (publisher == null) {
            return false;
        }

        return Objects.equals(getName(), publisher.getName());
    }

    @Override
    public boolean hasSameParameters(Publisher publisher) {

        return hasSameConstraint(publisher) && ConstrainableUtilities.hasSameParameters(address, publisher.getAddress());
    }
}
