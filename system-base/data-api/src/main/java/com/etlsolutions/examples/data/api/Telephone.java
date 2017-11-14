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
 * The Telephone interface represents a full telephone number including country
 * code, area code, local telephone number part etc.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface Telephone extends Constrainable<Telephone> {

    /**
     * Get the country code of this telephone number.
     *
     * @return the country code.
     */
    String getCountryCode();

    /**
     * Get the area code of this telephone number.
     *
     * @return the area code.
     */
    String getAreaCode();

    /**
     * Get the local telephone number part of this telephone number.
     *
     * @return the local telephone number part.
     */
    String getTelephoneNumber();

    /**
     * Get the type of this telephone number.
     *
     * @return the type.
     */
    TelephoneType getTelephoneType();
}
