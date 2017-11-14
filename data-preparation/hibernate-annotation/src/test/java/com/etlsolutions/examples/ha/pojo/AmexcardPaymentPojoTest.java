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
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AmexcardPaymentPojo.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class AmexcardPaymentPojoTest {

    private final AmexcardPaymentPojo instance = new AmexcardPaymentPojo();

    @Before
    public void setUp() {
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetPaymentId() {

        assertEquals(0, instance.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetPaymentId() {
        
        int paymentId = 2131;
        
        instance.setId(paymentId);
        
        assertEquals(paymentId, instance.getId());
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPayment() {

        assertNull(instance.getPaymentDetail());
    }

    /**
     * Test of setPaymentDetail method.
     */
    @Test
    public void testSetPayment() {

        PaymentDetailPojo payment = new PaymentDetailPojo();
        instance.setPaymentDetail(payment);
        assertEquals(payment, instance.getPaymentDetail());
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertNull(instance.getPersonAddressLink());
    }

    /**
     * Test of setPersonAddressLink method.
     */
    @Test
    public void testSetPersonAddressLink() {

        PersonAddressLinkPojo personAddressLink = new PersonAddressLinkPojo();
        instance.setPersonAddressLink(personAddressLink);
        assertEquals(personAddressLink, instance.getPersonAddressLink());
    }

    /**
     * Test of getCardNumber method.
     */
    @Test
    public void testGetCardNumber() {

        assertNull(instance.getCardNumber());
    }

    /**
     * Test of setCardNumber method.
     */
    @Test
    public void testSetCardNumber() {

        String cardNumber = "43532522542352";
        instance.setCardNumber(cardNumber);
       assertEquals(cardNumber, instance.getCardNumber());
    }

    /**
     * Test of getSecurityCode method.
     */
    @Test
    public void testGetSecurityCode() {

        assertNull(instance.getSecurityCode());
    }

    /**
     * Test of setSecurityCode method.
     */
    @Test
    public void testSetSecurityCode() {

        String securityCode = "432";
        instance.setSecurityCode(securityCode);
        assertEquals(securityCode, instance.getSecurityCode());
    }

    /**
     * Test of getExpireDate method.
     */
    @Test
    public void testGetExpireDate() {

        assertNull(instance.getExpireDate());
    }

    /**
     * Test of setExpireDate method.
     */
    @Test
    public void testSetExpireDate() {
        Date date = new Date();
        instance.setExpireDate(date);
        assertEquals(date, instance.getExpireDate());
    }

    /**
     * Test of getAddress method.
     */
    @Test
    public void testGetAddress() {
        assertNull(instance.getPersonAddressLink());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        instance.setId(23054);

        assertEquals(new AmexcardPaymentPojo(23054, null, null, null, null).hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {
        instance.setId(23054);

        assertTrue(instance.equals(new AmexcardPaymentPojo(23054, null, null, null, null)));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_false() {
        instance.setId(23054);

        assertFalse(instance.equals(new AmexcardPaymentPojo(23052, null, null, null, null)));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_other_object() {
        assertFalse(instance.equals(new Object()));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals_null() {
        assertFalse(instance.equals(null));
    } 
    
    @Test
    public void testQueries() {
        
        DataRetriever retriever = new DataRetriever();       
        List<AmexcardPaymentPojo> list = retriever.<AmexcardPaymentPojo>findAll(QueryNames.findAmexcardPayments);
        
        assertEquals(3, list.size());        
        assertEquals("Gwynedd", list.get(0).getPersonAddressLink().getAddress().getArea());
    }   
    
    @Test
    public void testQueriesNative() {
        
        DataRetriever retriever = new DataRetriever();        
        List<AmexcardPaymentPojo> list = retriever.<AmexcardPaymentPojo>findAll(QueryNames.findAmexcardPaymentsNative);
        assertEquals(3, list.size());
        
        assertEquals("Gwynedd", list.get(0).getPersonAddressLink().getAddress().getArea());
    }     
}
