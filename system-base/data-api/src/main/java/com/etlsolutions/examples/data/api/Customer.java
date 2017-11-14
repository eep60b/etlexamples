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
 * The Customer interface contains information about a customer.
 * 
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public interface Customer extends Constrainable<Customer> {

    /**
     * Get the personal detail and address for this customer.
     * @return the PersonAddressLink object.
     */
    PersonAddressLink getPersonAddressLink();
    
    /**
     * Get the image of this customer.
     * @return the image in a byte array.
     */
    byte[] getImage();

    /**
     * Get the password of this customer.
     * @return the password string.
     */
    String getPassword();

    /**
     * Get the username of this customer.
     * @return the username string.
     */
    String getUsername();
}
