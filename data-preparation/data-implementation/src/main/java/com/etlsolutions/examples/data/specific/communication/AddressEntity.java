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

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The AddressEntity class is a simple implementation of the Address interface.
 * It can represent an entry of the address table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class AddressEntity implements Address {

    private final String house;
    private final String street;
    private final String additional;
    private final String area;
    private final String city;
    private final String country;
    private final String postcode;

    /**
     * Construct an AddressEntity object using the given Address object.
     *
     * @param address - The given Address object.
     * @throws NullPointerException if the specified Address object is null.
     */
    public AddressEntity(Address address) {
        this(new AddressHouse(address.getHouse()), new AddressStreet(address.getStreet()), new AddressAdditionalInformation(address.getAdditional()), new AddressArea(address.getArea()), new AddressCity(address.getCity()), new AddressCountry(address.getCountry()), new AddressPostcode(address.getPostcode()));
    }

    /**
     * Construct an AddressEntity object using the given parameters.
     *
     * @param house - The house name or house number.
     * @param street - The street name.
     * @param additional - The additional information for the address.
     * @param area - The area of the address.
     * @param city -The city of the address.
     * @param country -The country of the address.
     * @param postcode - The postcode of the address.
     * @throws NullPointerException if any of the specified parameters is null.
     */
    public AddressEntity(AddressHouse house, AddressStreet street, AddressAdditionalInformation additional, AddressArea area, AddressCity city, AddressCountry country, AddressPostcode postcode) {

        this(house.getValue(), street.getValue(), additional.getValue(), area.getValue(), city.getValue(), country.getValue(), postcode.getValue());
    }

    /**
     * Construct an object using the given parameter strings. This constructor
     * is NOT allowed to be exposed to outside world since users can easily make
     * mistakes to use it.
     *
     * @param house - The house name or house number.
     * @param street - The street name.
     * @param additional - The additional information for the address.
     * @param area - The area of the address.
     * @param city -The city of the address.
     * @param country -The country of the address.
     * @param postcode - The postcode of the address.
     */
    private AddressEntity(String house, String street, String additional, String area, String city, String country, String postcode) {

        this.house = house;
        this.additional = additional;
        this.area = area;
        this.city = city;
        this.country = country;
        this.street = street;
        this.postcode = postcode;
    }

    @Override
    public String getHouse() {
        return house;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getAdditional() {
        return additional;
    }

    @Override
    public String getArea() {
        return area;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getPostcode() {
        return postcode;
    }

    @Override
    public int hashCode() {

        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.house);
        hash = 19 * hash + Objects.hashCode(this.street);
        hash = 19 * hash + Objects.hashCode(this.additional);
        hash = 19 * hash + Objects.hashCode(this.area);
        hash = 19 * hash + Objects.hashCode(this.city);
        hash = 19 * hash + Objects.hashCode(this.country);
        hash = 19 * hash + Objects.hashCode(this.postcode);
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

        final AddressEntity other = (AddressEntity) obj;

        if (!Objects.equals(this.house, other.house)) {
            return false;
        }

        if (!Objects.equals(this.street, other.street)) {
            return false;
        }

        if (!Objects.equals(this.additional, other.additional)) {
            return false;
        }

        if (!Objects.equals(this.area, other.area)) {
            return false;
        }

        if (!Objects.equals(this.city, other.city)) {
            return false;
        }

        if (!Objects.equals(this.country, other.country)) {
            return false;
        }

        return Objects.equals(this.postcode, other.postcode);
    }

    @Override
    public String toString() {
        return "AddressEntity{address=" + getHouse() + ", " + getStreet() + ", " + getAdditional() + ", " + getArea() + ", " + getCity() + ", " + getPostcode() + ", " + getCountry() + '}';
    }

    @Override
    public boolean hasSameConstraint(Address address) {

        if (this == address) {
            return true;
        }

        if (address == null) {
            return false;
        }

        return Objects.equals(getHouse(), address.getHouse()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getAdditional(), address.getAdditional()) && Objects.equals(getArea(), address.getArea())
                && Objects.equals(getCity(), address.getCity()) && Objects.equals(getPostcode(), address.getPostcode()) && Objects.equals(getCountry(), address.getCountry());
    }

    @Override
    public boolean hasSameParameters(Address address) {
        return hasSameConstraint(address);
    }
}
