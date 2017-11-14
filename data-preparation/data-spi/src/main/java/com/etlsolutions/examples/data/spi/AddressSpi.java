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
package com.etlsolutions.examples.data.spi;

import com.etlsolutions.examples.data.api.identifiable.IdentifiableAddress;

/**
 * The AddressSpi interface defines an object which represents an entry of
 * address table in database and has setter methods for its fields.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.1.0 - Added extention to IdentifiableSpi.
 */
public interface AddressSpi extends IdentifiableAddress, IdentifiableSpi {

    /**
     * Set the house name or house number of this address.
     *
     * @param house - The house name or house number.
     */
    void setHouse(String house);
    
    /**
     * Set the street name of this address.
     *
     * @param street - The street name.
     */
    void setStreet(String street);
    
    /**
     * Set the additional information of this address.
     *
     * @param additional - The additional information.
     */
    void setAdditional(String additional);

    /**
     * Set the address area name.
     *
     * @param area - The area name.
     */
    void setArea(String area);

    /**
     * Set the city name of this address.
     *
     * @param city - The city name string.
     */
    void setCity(String city);

    /**
     * Set the country name of this address.
     *
     * @param country - The country name string.
     */
    void setCountry(String country);

    /**
     * Set the postcode of this address.
     *
     * @param postcode - The postcode of this address.
     */
    void setPostcode(String postcode);
}
