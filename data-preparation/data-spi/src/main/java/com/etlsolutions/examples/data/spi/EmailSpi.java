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

import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableEmail;

/**
 * The EmailSpi interface represents an email address.
 *
 * @author Zhipeng Chang

 * @since 1.0.0
 *
 * @param <P>
 * 
 * @version 1.0.0
 */
public interface EmailSpi<P extends PersonalDetail> extends IdentifiableEmail, IdentifiableSpi {

    
    /**
     * Set the email address.
     * @param emailAddress - The email address string.
     */
    void setEmailAddress(String emailAddress);

    /**
     * Set the personal information for this email object.
     * @param personalDetail - The personal information.
     */
    void setPersonalDetail(P personalDetail);
}
