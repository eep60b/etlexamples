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

import com.etlsolutions.examples.data.api.AdministratorRole;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAdministrator;

/**
 * The AdministratorSpi interface defines an object which represents an entry of
 * administrator table in the database and has setter methods to modify its fields.
 *
 * @param <P> - The concrete  personal detail type used in this object.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface AdministratorSpi<P extends PersonalDetail> extends IdentifiableAdministrator, IdentifiableSpi {

    /**
     * Set the personal detail for this administrator..
     *
     * @param personalDetail - The specified PersonalDetail object.
     */
    void setPersonalDetail(P personalDetail);

    /**
     * Set the password for this administrator.
     *
     * @param password
     */
    void setPassword(String password);

    /**
     * Set the role for this administrator.
     *
     * @param role - The role object.
     */
    void setRole(AdministratorRole role);

    /**
     * Set the username for this administrator.
     * @param username - The username string.
     */
    void setUsername(String username);
}
