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

import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableCustomer;

/**
 * The CustomerSpi interface contains information about a customer.
 *
 * @author Zhipeng Chang
 * @param <P> - The concrete type of person-address links.
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface CustomerSpi<P extends PersonAddressLink> extends IdentifiableCustomer, IdentifiableSpi {

    /**
     * Set the customer image.
     *
     * @param customerImage - The byte array
     */
    void setImage(byte[] customerImage);

    /**
     *
     * @param customerPassword
     */
    void setPassword(String customerPassword);

    /**
     *
     * @param customerUsername
     */
    void setUsername(String customerUsername);

    /**
     *
     * @param personAddressLink
     */
    void setPersonAddressLink(P personAddressLink);
}
