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
package com.etlsolutions.examples.data.specific.person;

import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import java.util.Date;
import org.junit.Test;

/**
 * Test of class PersonalDetailEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonalDetailEntityConstructorTest {

    private final PersonalTitle personTitleColumn = new PersonalTitle("Me.");
    private final GivenName givenNameColumn = new GivenName("Ton");
    private final FamilyName familyNameColumn = new FamilyName("Snigh");
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(new Date());
    private final PersonalProfile personalProfileColumn = new PersonalProfile(new byte[]{1, 16, 92});

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_1() {

        new PersonalDetailEntity(null, givenNameColumn, familyNameColumn, dateOfBirthColumn, personalProfileColumn);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_2() {

        new PersonalDetailEntity(personTitleColumn, null, familyNameColumn, dateOfBirthColumn, personalProfileColumn);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_3() {

        new PersonalDetailEntity(personTitleColumn, givenNameColumn, null, dateOfBirthColumn, personalProfileColumn);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_4() {

        new PersonalDetailEntity(personTitleColumn, givenNameColumn, familyNameColumn, null, personalProfileColumn);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_5() {

        new PersonalDetailEntity(personTitleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, null);
    }
}
