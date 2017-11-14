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
import java.util.Date;
import java.util.Set;

/**
 * The PersonalDetail interface contains detail information about a person.
 *
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface PersonalDetail extends Constrainable<PersonalDetail> {

    /**
     * Get the person's birthday.
     *
     * @return the date of birth of the person.
     */
    Date getDateOfBirth();

    /**
     * Get the family name of the person.
     *
     * @return the family name string.
     */
    String getFamilyName();

    /**
     * Get the person's given name.
     *
     * @return the given name string.
     */
    String getGivenName();

    /**
     * Get the person title.
     *
     * @return the title string.
     */
    String getTitle();

    /**
     * Get the profile ID for this person.
     *
     * @return the profile in byte array format.
     */
    byte[] getProfile();
}
