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

import com.etlsolutions.examples.data.api.TelephoneType;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableTelephone;

/**
 * The TelephoneSpi interface represents a full telephone number including
 * country code, area code, local telephone number part etc.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public interface TelephoneSpi extends IdentifiableTelephone, IdentifiableSpi {

    /**
     * Set the country code for this telephone number.
     *
     * @param countryCode - The specified country code.
     */
    void setCountryCode(String countryCode);

    /**
     * Set the area code for this telephone number.
     *
     * @param areaCode - The specified area code.
     */
    void setAreaCode(String areaCode);

    /**
     * Set the local telephone number part for this telephone number.
     *
     * @param telephoneNumber - The specified local telephone number part.
     */
    void setTelephoneNumber(String telephoneNumber);

    /**
     * Set the type for this telephone number.
     *
     * @param telephoneType - The specified type.
     */
    void setTelephoneType(TelephoneType telephoneType);
}
