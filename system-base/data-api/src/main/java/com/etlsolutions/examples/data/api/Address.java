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
package com.etlsolutions.examples.data.api;

import com.etlsolutions.examples.data.general.Constrainable;

/**
 * The Address interface represents an address. It is also can be used to
 * defines an entry of the address table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface Address extends Constrainable<Address> {

    /**
     * Get the house number or house name of this address.
     *
     * @return the house name or house number.
     */
    String getHouse();

    /**
     * Get the street name of this address.
     *
     * @return the street name.
     */
    String getStreet();

    /**
     * Get the additional information of this address.
     *
     * @return the string of additional information.
     */
    String getAdditional();

    /**
     * Get the area name of this address. The area name can be different
     * according to the country. It can be a county name, a state name or a
     * province name.
     *
     * @return the area name.
     */
    String getArea();

    /**
     * Get the city name of this address.
     *
     * @return the city name.
     */
    String getCity();

    /**
     * Get the country name of this address.
     *
     * @return the country name.
     */
    String getCountry();

    /**
     * Get the postcode of this address.
     *
     * @return the postcode of this address.
     */
    String getPostcode();
}
