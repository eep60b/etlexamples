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
package com.etlsolutions.examples.ha.pojo;

import com.etlsolutions.examples.ha.control.DataRetriever;
import com.etlsolutions.examples.ha.control.QueryNames;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AddressPojo.
 *
 * @author Zhipeng
 */
public class AddressPojoTest {

    private final AddressPojo instance = new AddressPojo();

    @Before
    public void setUp() {
    }

    /**
     * Test of getAddressId method.
     */
    @Test
    public void testGetAddressId() {
        assertEquals(0, instance.getId());
    }

    /**
     * Test of setAddressId method.
     */
    @Test
    public void testSetAddressId() {
        instance.setId(3454);
        assertEquals(3454, instance.getId());
    }

    /**
     * Test of getStreet method.
     */
    @Test
    public void testGetAddressMain() {
        assertNull(instance.getStreet());
    }

    /**
     * Test of setStreet method.
     */
    @Test
    public void testSetAddressMain() {
        String addressMain = "kladal afdkla fdal a";
        instance.setStreet(addressMain);
        assertEquals(addressMain, instance.getStreet());
    }

    /**
     * Test of getAddtional method.
     */
    @Test
    public void testGetAddtional() {

        assertNull(instance.getAdditional());
    }

    /**
     * Test of setAddtional method.
     */
    @Test
    public void testSetAddtional() {

        String addressAddtional = "setAddressAddtional";
        instance.setAdditional(addressAddtional);
        assertEquals(addressAddtional, instance.getAdditional());
    }

    /**
     * Test of getCity method.
     */
    @Test
    public void testGetCity() {

        assertNull(instance.getCity());
    }

    /**
     * Test of setCity method.
     */
    @Test
    public void testSetCity() {

        String addressCity = "setAddressCity";
        instance.setCity(addressCity);
        assertEquals(addressCity, instance.getCity());
    }

    /**
     * Test of getArea method.
     */
    @Test
    public void testGetArea() {

        assertNull(instance.getArea());
    }

    /**
     * Test of setArea method.
     */
    @Test
    public void testSetArea() {
        
        String addressArea = "setAddressArea";
        instance.setArea(addressArea);
        assertEquals(addressArea, instance.getArea());
    }

    /**
     * Test of getPostcode method.
     */
    @Test
    public void testGetsPostcode() {

        assertNull(instance.getPostcode());
    }

    /**
     * Test of setPostcode method.
     */
    @Test
    public void testSetPostcode() {

        String addressPostcode = "setAddressPostcode";
        instance.setPostcode(addressPostcode);
        assertEquals(addressPostcode, instance.getPostcode());
    }

    /**
     * Test of getCountry method.
     */
    @Test
    public void testGetCountry() {

        assertNull(instance.getCountry());
    }

    /**
     * Test of setCountry method.
     */
    @Test
    public void testSetsCountry() {

        String addressCountry = "setAddressCountry";
        instance.setCountry(addressCountry);
        assertEquals(addressCountry, instance.getCountry());
    }

    /**
     * Test of getPublishers method.
     */
    @Test
    public void testGetPublishers() {

        assertTrue(instance.getPublishers().isEmpty());
    }

    /**
     * Test of setPublishers method.
     */
    @Test
    public void testSetPublishers() {

        Set<PublisherPojo> publishers = new HashSet<>();
        publishers.add(new PublisherPojo());
        instance.setPublishers(publishers);
        assertEquals(publishers, instance.getPublishers());
    }

    /**
     * Test of getPersonAddressLinks method.
     */
    @Test
    public void testGetPersonAddressLinks() {

        assertTrue(instance.getPersonAddressLinks().isEmpty());
    }

    /**
     * Test of setPersonAddressLinks method.
     */
    @Test
    public void testSetPersonAddressLinks() {
        
        Set<PersonAddressLinkPojo> personAddressLinks = new HashSet<>();
        personAddressLinks.add(new PersonAddressLinkPojo());
        instance.setPersonAddressLinks(personAddressLinks);
        assertEquals(personAddressLinks, instance.getPersonAddressLinks());
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(0, instance.getId());
    }

    /**
     * Test of setId method, of class AddressPojo.
     */
    @Test
    public void testSetId() {
        int id = 4564;
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    
    @Test
    public void testQueries() {
        DataRetriever retriever = new DataRetriever();
        
        List<AddressPojo> list = retriever.<AddressPojo>findAll(QueryNames.findAddresses);
        assertEquals(3, list.size());
        
        assertEquals("Gwynedd", list.get(0).getArea());
    }  
    
    @Test
    public void testQueriesNative() {
        DataRetriever retriever = new DataRetriever();
        
        List<AddressPojo> list = retriever.<AddressPojo>findAll(QueryNames.findAddressesNative);
        assertEquals(3, list.size());
        
        assertEquals("Gwynedd", list.get(0).getArea());
    }    
    
}
