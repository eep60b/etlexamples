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
package com.etlsolutions.examples.data.specific.book;

import com.etlsolutions.examples.data.api.Publisher;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class PublisherEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PublisherEntityTest {

    private final AddressEntity address = new AddressEntity(new AddressHouse("hhouse"), new AddressStreet("streett"), new AddressAdditionalInformation("addtiionaal"), new AddressArea("areea"), new AddressCity("citycity"), new AddressCountry("US"), new AddressPostcode("NY 11973"));
    private final AddressEntity address1 = new AddressEntity(new AddressHouse("81"), new AddressStreet("Carn Road"), new AddressAdditionalInformation("addtiionaalInor"), new AddressArea("Gwynedd"), new AddressCity("Bangor"), new AddressCountry("Walse"), new AddressPostcode("LL574LN"));
    private final String name = "lafaknk";
    private final String name2 = "alkjnaksfdafda";    
    private final NameWrapper publisherName = new NameWrapper(name);
    private final Publisher publisher = Mockito.mock(Publisher.class);

    private final PublisherEntity instance = new PublisherEntity(address, name);
    private final PublisherEntity instance00 = new PublisherEntity(address, name);    
    private final PublisherEntity instance01 = new PublisherEntity(address1, name);
    private final PublisherEntity instance02 = new PublisherEntity(address, name2);    
    private final PublisherEntity instance03 = new PublisherEntity(address, publisherName);
    private PublisherEntity instance05;

    @Before
    public void setUp() {
        Mockito.when(publisher.getAddress()).thenReturn(address);
        Mockito.when(publisher.getName()).thenReturn("lafaknk");
        instance05 = new PublisherEntity(publisher);
    }

    /**
     * Test of getAddress method.
     */
    @Test
    public void testGetAddress() {

        assertEquals(address, instance.getAddress());
        assertEquals(address1, instance01.getAddress());
        assertEquals(address, instance03.getAddress());
        assertEquals(address, instance05.getAddress());
    }

    /**
     * Test of getName method.
     */
    @Test
    public void testGetName() {

        assertEquals("lafaknk", instance.getName());
        assertEquals("alkjnaksfdafda", instance02.getName());
        assertEquals("lafaknk", instance03.getName());
        assertEquals("lafaknk", instance05.getName());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance03));
        assertTrue(instance.equals(instance05));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("PublisherEntity{Name=lafaknk}", instance.toString());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(publisher));

        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(null));        
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance.hasSameParameters(publisher));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(null));        
    }
}
