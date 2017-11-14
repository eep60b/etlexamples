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

import com.etlsolutions.examples.data.api.TelephoneType;
import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The TelephoneEnitity class represents an entry of telephone table in the
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
public final class TelephoneEnitity implements Telephone {

    private final String countryCode;
    private final String areaCode;
    private final String telephoneNumber;
    private final TelephoneType telephoneType;

    /**
     * Construct an object using the given Telephone object.
     *
     * @param telephone - The specified telephone object.
     */
    public TelephoneEnitity(Telephone telephone) {
        this(telephone.getCountryCode(), telephone.getAreaCode(), telephone.getTelephoneNumber(), telephone.getTelephoneType());
    }

    /**
     * Construct an object using the given information.
     *
     * @param countryCode - The country code.
     * @param areaCode - The area code.
     * @param telephoneNumber - The telephone number.
     * @param telephoneType - The telephone type.
     */
    private TelephoneEnitity(String countryCode, String areaCode, String telephoneNumber, TelephoneType telephoneType) {

        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.telephoneNumber = telephoneNumber;
        this.telephoneType = telephoneType;
    }

    /**
     * Construct an object using the given information.
     *
     * @param countryCode - The country code.
     * @param areaCode - The area code.
     * @param telephoneNumber - The telephone number.
     * @param telephoneType - The telephone type.
     */
    public TelephoneEnitity(CountryCode countryCode, AreaCode areaCode, TelephoneNumber telephoneNumber, TelephoneType telephoneType) {
        this(countryCode.getValue(), areaCode.getValue(), telephoneNumber.getValue(), telephoneType);
    }

    @Override
    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String getAreaCode() {
        return areaCode;
    }

    @Override
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public TelephoneType getTelephoneType() {
        return telephoneType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.countryCode);
        hash = 53 * hash + Objects.hashCode(this.areaCode);
        hash = 53 * hash + Objects.hashCode(this.telephoneNumber);
        hash = 53 * hash + Objects.hashCode(this.telephoneType);
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

        final TelephoneEnitity other = (TelephoneEnitity) obj;

        return this.telephoneType == other.telephoneType && Objects.equals(this.countryCode, other.countryCode)
                && Objects.equals(this.areaCode, other.areaCode) && Objects.equals(this.telephoneNumber, other.telephoneNumber);
    }

    @Override
    public String toString() {
        return "TelephoneEnitity{country code=" + getCountryCode() + ", area code=" + getAreaCode() + ", telephone number=" + getTelephoneNumber() + ", type=" + telephoneType.name() + '}';
    }

    @Override
    public boolean hasSameConstraint(Telephone telephone) {
        return hasSameParameters(telephone);
    }

    @Override
    public boolean hasSameParameters(Telephone telephone) {

        if (this == telephone) {
            return true;
        }

        if (telephone == null) {
            return false;
        }

        return this.telephoneType == telephone.getTelephoneType() && Objects.equals(getCountryCode(), telephone.getCountryCode())
                && Objects.equals(getAreaCode(), telephone.getAreaCode()) && Objects.equals(getTelephoneNumber(), telephone.getTelephoneNumber());
    }
}
