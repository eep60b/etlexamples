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
package com.etlsolutions.examples.data;

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.communication.EmailAddress;
import java.util.Random;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class AddressGenerator.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AddressGenerator.class})
public final class AddressGeneratorTest {

    private final RandomStringGenerator singleWordGenerator = PowerMockito.mock(RandomStringGenerator.class);
    private final Random random = Mockito.mock(Random.class);

    private AddressGenerator instance;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(RandomStringGenerator.class).withNoArguments().thenReturn(singleWordGenerator);
        PowerMockito.whenNew(Random.class).withNoArguments().thenReturn(random);
        instance = new AddressGenerator();
    }

    /**
     * Test of generatePostcode method.
     */
    @Test
    public void testGeneratePostcode() {

        assertEquals(new AddressPostcode(""), instance.generatePostcode());
    }

    /**
     * Test of generateAddressStreet method.
     */
    @Test
    public void testGenerateAddressStreet() {
        assertEquals(new AddressStreet(""), instance.generateAddressStreet());
    }

    /**
     * Test of generateAdditionalInformation method.
     */
    @Test
    public void testGenerateAdditionalInformation() {
        assertEquals(new AddressAdditionalInformation(""), instance.generateAdditionalInformation());
    }

    /**
     * Test of generateCity method.
     */
    @Test
    public void testGenerateCity() {
        assertEquals(new AddressCity(""), instance.generateCity());
    }

    /**
     * Test of generateArea method.
     */
    @Test
    public void testGenerateArea() {
        assertEquals(new AddressArea(""), instance.generateArea());
    }

    /**
     * Test of generateCountry method, of class AddressGenerator.
     */
    @Test
    public void testGenerateCountry() {
        System.out.println("generateCountry");
        AddressGenerator instance = new AddressGenerator();
        String expResult = "";
        assertEquals(expResult, instance.generateCountry());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateEmailAddress method, of class AddressGenerator.
     */
    @Test
    public void testGenerateEmailAddress() {
        System.out.println("generateEmailAddress");
        AddressGenerator instance = new AddressGenerator();
        EmailAddress expResult = null;
        assertEquals(expResult, instance.generateEmailAddress());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateUniqueAddress method, of class AddressGenerator.
     */
    @Test
    public void testGenerateUniqueAddress() {
        System.out.println("generateUniqueAddressArray");
        Set<Address> constraintArrays = null;
        AddressGenerator instance = new AddressGenerator();
        Object[] expResult = null;
        assertEquals(expResult, instance.generateUniqueAddress(constraintArrays));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateHouseName method, of class AddressGenerator.
     */
    @Test
    public void testGenerateHouseName() {
        System.out.println("generateHouseName");
        AddressGenerator instance = new AddressGenerator();
        AddressHouse expResult = null;
        AddressHouse result = instance.generateHouseName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
