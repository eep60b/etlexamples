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
package com.etlsolutions.examples.data.specific.communication;

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.PersonalDetail;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test of class PersonAddressLinkEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonAddressLinkEntityConstructorTest {

    private final Address address = Mockito.mock(Address.class);
    private final PersonalDetail personalDetail = Mockito.mock(PersonalDetail.class);

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_1() {
        new PersonAddressLinkEntity(null);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_2() {
        new PersonAddressLinkEntity(null, personalDetail, AddressType.CONTACT);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_3() {
        new PersonAddressLinkEntity(address, null, AddressType.CONTACT);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_4() {
        new PersonAddressLinkEntity(address, personalDetail, null);
    }

}
