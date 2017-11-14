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
package com.etlsolutions.examples.database.hibernate.pojo;

import com.etlsolutions.examples.data.api.DebitcardPayment;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Date;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class DebitcardPaymentPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class DebitcardPaymentPojoTest {

    private final int id = 122394;
    private final int id01 = 53394;
    private final PersonAddressLinkPojo personAddressLink = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLink02 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PaymentDetailPojo paymentDetail = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetail03 = Mockito.mock(PaymentDetailPojo.class);
    private final String cardNumber = "2034104109410431";
    private final String cardNumber04 = "2034913981233431";
    private final String securityCode = "992";
    private final String securityCode05 = "671";
    private final int issueNumber = 3;
    private final int issueNumber06 = 1;
    private final Date startDate = new Date(150780943435218349L);
    private final Date startDate07 = new Date(917831873911989349L);
    private final Date expireDate = new Date(627300986240424319L);
    private final Date expireDate08 = new Date(8193191798131213319L);
    private final DebitcardPayment debitcardPayment = Mockito.mock(DebitcardPayment.class);

    private final DebitcardPaymentPojo instance = new DebitcardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, issueNumber, startDate, expireDate);
    private final DebitcardPaymentPojo instance00 = new DebitcardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, issueNumber, startDate, expireDate);
    private final DebitcardPaymentPojo instance01 = new DebitcardPaymentPojo(id01, personAddressLink, paymentDetail, cardNumber, securityCode, issueNumber, startDate, expireDate);
    private final DebitcardPaymentPojo instance02 = new DebitcardPaymentPojo(id, personAddressLink02, paymentDetail, cardNumber, securityCode, issueNumber, startDate, expireDate);
    private final DebitcardPaymentPojo instance03 = new DebitcardPaymentPojo(id, personAddressLink, paymentDetail03, cardNumber, securityCode, issueNumber, startDate, expireDate);
    private final DebitcardPaymentPojo instance04 = new DebitcardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber04, securityCode, issueNumber, startDate, expireDate);
    private final DebitcardPaymentPojo instance05 = new DebitcardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode05, issueNumber, startDate, expireDate);
    private final DebitcardPaymentPojo instance06 = new DebitcardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, issueNumber06, startDate, expireDate);
    private final DebitcardPaymentPojo instance07 = new DebitcardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, issueNumber, startDate07, expireDate);
    private final DebitcardPaymentPojo instance08 = new DebitcardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, issueNumber, startDate, expireDate08);
    private final DebitcardPaymentPojo instance10 = new DebitcardPaymentPojo();
    private final DebitcardPaymentPojo instance11 = new DebitcardPaymentPojo(id, paymentDetail, cardNumber, securityCode, startDate, expireDate);
    private final DebitcardPaymentPojo instance12 = new DebitcardPaymentPojo(personAddressLink, paymentDetail, cardNumber, securityCode, issueNumber, startDate, expireDate);
    private final DebitcardPaymentPojo instance13 = new HibernateProxyDebitcardPaymentPojo(new DebitcardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, issueNumber, startDate, expireDate));
    private final DebitcardPaymentPojo instance14 = new DebitcardPaymentPojo(id, new PersonAddressLinkPojo(), new PaymentDetailPojo(), cardNumber, securityCode, issueNumber, startDate, expireDate);
    @Before
    public void setUp() {
        Mockito.when(debitcardPayment.getCardNumber()).thenReturn("2034104109410431");
        Mockito.when(debitcardPayment.getExpireDate()).thenReturn(new Date(627300986240424319L));
        Mockito.when(debitcardPayment.getIssueNumber()).thenReturn(3);
        Mockito.when(debitcardPayment.getPaymentDetail()).thenReturn(paymentDetail);
        Mockito.when(debitcardPayment.getPersonAddressLink()).thenReturn(personAddressLink);
        Mockito.when(debitcardPayment.getSecurityCode()).thenReturn("992");
        Mockito.when(debitcardPayment.getStartDate()).thenReturn(new Date(150780943435218349L));
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(122394, instance.getId());
        assertEquals(0, instance10.getId());
        assertEquals(122394, instance11.getId());
        assertEquals(0, instance12.getId());
        assertEquals(0, instance13.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(2233);
        assertEquals(2233, instance.getId());
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertEquals(personAddressLink, instance.getPersonAddressLink());
        assertNull(instance10.getPersonAddressLink());
        assertNull(instance11.getPersonAddressLink());
        assertEquals(personAddressLink, instance.getPersonAddressLink());
        assertNull(instance13.getPersonAddressLink());
    }

    /**
     * Test of setPersonAddressLink method.
     */
    @Test
    public void testSetPersonAddressLink() {

        PersonAddressLinkPojo personAddressLink1 = new PersonAddressLinkPojo();
        instance.setPersonAddressLink(personAddressLink1);
        assertEquals(personAddressLink1, instance.getPersonAddressLink());
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPaymentDetail() {
        assertEquals(paymentDetail, instance.getPaymentDetail());
        assertNull(instance10.getPaymentDetail());
        assertEquals(paymentDetail, instance11.getPaymentDetail());
        assertEquals(paymentDetail, instance12.getPaymentDetail());
        assertNull(instance13.getPaymentDetail());
    }

    /**
     * Test of setPaymentDetail method.
     */
    @Test
    public void testSetPaymentDetail() {
        PaymentDetailPojo paymentDetail1 = Mockito.mock(PaymentDetailPojo.class);
        instance.setPaymentDetail(paymentDetail1);
        assertEquals(paymentDetail1, instance.getPaymentDetail());
    }

    /**
     * Test of getCardNumber method.
     */
    @Test
    public void testGetCardNumber() {

        assertEquals("2034104109410431", instance.getCardNumber());
        assertNull(instance10.getCardNumber());
        assertEquals("2034104109410431", instance11.getCardNumber());
        assertEquals("2034104109410431", instance12.getCardNumber());
        assertNull(instance13.getCardNumber());
    }

    /**
     * Test of setCardNumber method.
     */
    @Test
    public void testSetCardNumber() {
        instance.setCardNumber("85223664322224555");
        assertEquals("85223664322224555", instance.getCardNumber());

    }

    /**
     * Test of getSecurityCode method.
     */
    @Test
    public void testGetSecurityCode() {

        assertEquals("992", instance.getSecurityCode());
        assertNull(instance10.getSecurityCode());
        assertEquals("992", instance11.getSecurityCode());
        assertEquals("992", instance12.getSecurityCode());
        assertNull(instance13.getSecurityCode());
    }

    /**
     * Test of setSecurityCode method.
     */
    @Test
    public void testSetSecurityCode() {

        instance.setSecurityCode("875");
        assertEquals("875", instance.getSecurityCode());
    }

    /**
     * Test of getIssueNumber method.
     */
    @Test
    public void testGetIssueNumber() {

        assertEquals(3, instance.getIssueNumber());
        assertEquals(0, instance10.getIssueNumber());
        assertEquals(0, instance11.getIssueNumber());
        assertEquals(3, instance12.getIssueNumber());
        assertEquals(0, instance13.getIssueNumber());
    }

    /**
     * Test of setIssueNumber method.
     */
    @Test
    public void testSetIssueNumber() {

        instance.setIssueNumber(2);
        assertEquals(2, instance.getIssueNumber());
    }

    /**
     * Test of getStartDate method.
     */
    @Test
    public void testGetStartDate() {

        assertEquals(new Date(150780943435218349L), instance.getStartDate());
        assertNull(instance10.getStartDate());
        assertEquals(new Date(150780943435218349L), instance11.getStartDate());
        assertEquals(new Date(150780943435218349L), instance12.getStartDate());
        assertNull(instance13.getStartDate());
    }

    /**
     * Test of setStartDate method.
     */
    @Test
    public void testSetStartDate() {

        instance.setStartDate(new Date(98134981218349L));
        assertEquals(new Date(98134981218349L), instance.getStartDate());
    }

    /**
     * Test of getExpireDate method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testGetExpireDate() {

        assertEquals(new Date(627300986240424319L), instance.getExpireDate());
        assertNull(instance10.getExpireDate());
        assertEquals(new Date(627300986240424319L), instance11.getExpireDate());
        assertEquals(new Date(627300986240424319L), instance12.getExpireDate());
        assertNull(instance13.getExpireDate());
    }

    /**
     * Test of setExpireDate method.
     */
    @Test
    public void testSetExpireDate() {

        instance.setExpireDate(new Date(6798473129240424319L));
        assertEquals(new Date(6798473129240424319L), instance.getExpireDate());
    }

    /**
     * Test of hasSameConstraint method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testHasSameConstraint() {

        Mockito.when(personAddressLink.hasSameConstraint(personAddressLink)).thenReturn(Boolean.TRUE);
        Mockito.when(paymentDetail.hasSameConstraint(paymentDetail)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance13));
        assertTrue(instance13.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance.hasSameConstraint(debitcardPayment));

        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(null));

        instance.setPaymentDetail(null);
        instance00.setPaymentDetail(null);
        assertTrue(instance.hasSameConstraint(instance00));

        instance.setPersonAddressLink(null);
        instance00.setPersonAddressLink(null);
        assertTrue(instance.hasSameConstraint(instance00));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        Mockito.when(personAddressLink.hasSameParameters(personAddressLink)).thenReturn(Boolean.TRUE);
        Mockito.when(paymentDetail.hasSameParameters(paymentDetail)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance13));
        assertTrue(instance13.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(debitcardPayment));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(instance07));
        assertFalse(instance.hasSameParameters(instance08));

        assertFalse(instance.hasSameParameters(null));

        instance.setPaymentDetail(null);
        instance00.setPaymentDetail(null);
        assertTrue(instance.hasSameParameters(instance00));

        instance.setPersonAddressLink(null);
        instance00.setPersonAddressLink(null);
        assertTrue(instance.hasSameParameters(instance00));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance07.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        assertEquals(instance13.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance13));
        assertTrue(instance13.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(instance08));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance14));
    }

    private final class HibernateProxyDebitcardPaymentPojo extends DebitcardPaymentPojo implements HibernateProxy {

        private static final long serialVersionUID = 723833113221573251L;
        
        private final DebitcardPaymentPojo pojo;

        public HibernateProxyDebitcardPaymentPojo(DebitcardPaymentPojo addressPojo) {

            this.pojo = addressPojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {
            return new AbstractMockLazyInitializer() {

                @Override
                public DebitcardPaymentPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
