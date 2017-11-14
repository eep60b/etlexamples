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

import com.etlsolutions.examples.data.api.VisacardPayment;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Date;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Tests of class VisacardPaymentPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
public final class VisacardPaymentPojoTest {

    private final int id = 1213;
    private final int id1 = 9238;
    private final PersonAddressLinkPojo personAddressLink = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLink2 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PaymentDetailPojo paymentDetail = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetail3 = Mockito.mock(PaymentDetailPojo.class);
    private final String cardNumber = "63913191431i1431";
    private final String cardNumber4 = "1934819478914422";
    private final String securityCode = "821";
    private final String securityCode5 = "923";
    private final Date startDate = new Date(83725891034815794L);
    private final Date startDate6 = new Date(132912793128391111L);
    private final Date expireDate = new Date(9131348183414794L);
    private final Date expireDate7 = new Date(9938149471904444L);
    private final VisacardPayment visacardPayment = Mockito.mock(VisacardPayment.class);

    private final VisacardPaymentPojo instance = new VisacardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, startDate, expireDate);
    private final VisacardPaymentPojo instance00 = new VisacardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, startDate, expireDate);
    private final VisacardPaymentPojo instance01 = new VisacardPaymentPojo(id1, personAddressLink, paymentDetail, cardNumber, securityCode, startDate, expireDate);
    private final VisacardPaymentPojo instance02 = new VisacardPaymentPojo(id, personAddressLink2, paymentDetail, cardNumber, securityCode, startDate, expireDate);
    private final VisacardPaymentPojo instance03 = new VisacardPaymentPojo(id, personAddressLink, paymentDetail3, cardNumber, securityCode, startDate, expireDate);
    private final VisacardPaymentPojo instance04 = new VisacardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber4, securityCode, startDate, expireDate);
    private final VisacardPaymentPojo instance05 = new VisacardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode5, startDate, expireDate);
    private final VisacardPaymentPojo instance06 = new VisacardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, startDate6, expireDate);
    private final VisacardPaymentPojo instance07 = new VisacardPaymentPojo(id, personAddressLink, paymentDetail, cardNumber, securityCode, startDate, expireDate7);
    private final VisacardPaymentPojo instance08 = new VisacardPaymentPojo();
    private final VisacardPaymentPojo instance09 = new VisacardPaymentPojo(id, paymentDetail, cardNumber, securityCode, startDate, expireDate);
    private final VisacardPaymentPojo instance10 = new VisacardPaymentPojo(personAddressLink, paymentDetail, cardNumber, securityCode, startDate, expireDate);
    private final VisacardPaymentPojo instance11 = new HibernateProxyVisacardPaymentPojo(instance);
    private final VisacardPaymentPojo instance12 = new VisacardPaymentPojo(id, new PersonAddressLinkPojo(), new PaymentDetailPojo(), cardNumber, securityCode, startDate, expireDate);
    @Before
    public void setUp() {

        Mockito.when(visacardPayment.getCardNumber()).thenReturn(cardNumber);
        Mockito.when(visacardPayment.getExpireDate()).thenReturn(expireDate);
        Mockito.when(visacardPayment.getPaymentDetail()).thenReturn(paymentDetail);
        Mockito.when(visacardPayment.getPersonAddressLink()).thenReturn(personAddressLink);
        Mockito.when(visacardPayment.getSecurityCode()).thenReturn(securityCode);
        Mockito.when(visacardPayment.getStartDate()).thenReturn(startDate);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(1213, instance.getId());
        assertEquals(0, instance08.getId());
        assertEquals(1213, instance09.getId());
        assertEquals(0, instance10.getId());
        assertEquals(0, instance11.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(2289);
        assertEquals(2289, instance.getId());
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertEquals(personAddressLink, instance.getPersonAddressLink());
        assertNull(instance08.getPersonAddressLink());
        assertNull(instance09.getPersonAddressLink());
        assertEquals(personAddressLink, instance10.getPersonAddressLink());
        assertNull(instance11.getPersonAddressLink());
    }

    /**
     * Test of setPersonAddressLink method.
     */
    @Test
    public void testSetPersonAddressLink() {

        instance.setPersonAddressLink(personAddressLink2);
        assertEquals(personAddressLink2, instance.getPersonAddressLink());
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPaymentDetail() {

        assertEquals(paymentDetail, instance.getPaymentDetail());
        assertNull(instance08.getPaymentDetail());
        assertEquals(paymentDetail, instance09.getPaymentDetail());
        assertEquals(paymentDetail, instance10.getPaymentDetail());
        assertNull(instance11.getPaymentDetail());
    }

    /**
     * Test of setPaymentDetail method.
     */
    @Test
    public void testSetPaymentDetail() {

        instance.setPaymentDetail(paymentDetail3);
        assertEquals(paymentDetail3, instance.getPaymentDetail());
    }

    /**
     * Test of getCardNumber method.
     */
    @Test
    public void testGetCardNumber() {

        assertEquals("63913191431i1431", instance.getCardNumber());
        assertNull(instance08.getCardNumber());
        assertEquals("63913191431i1431", instance09.getCardNumber());
        assertEquals("63913191431i1431", instance10.getCardNumber());
        assertNull(instance11.getCardNumber());
    }

    /**
     * Test of setCardNumber method.
     */
    @Test
    public void testSetCardNumber() {

        instance.setCardNumber("234194712947192");
        assertEquals("234194712947192", instance.getCardNumber());
    }

    /**
     * Test of getSecurityCode method.
     */
    @Test
    public void testGetSecurityCode() {

        assertEquals("821", instance.getSecurityCode());
        assertNull(instance08.getSecurityCode());
        assertEquals("821", instance09.getSecurityCode());
        assertEquals("821", instance10.getSecurityCode());
        assertNull(instance11.getSecurityCode());
    }

    /**
     * Test of setSecurityCode method.
     */
    @Test
    public void testSetSecurityCode() {

        instance.setSecurityCode("555");
        assertEquals("555", instance.getSecurityCode());
    }

    /**
     * Test of getStartDate method.
     */
    @Test
    public void testGetStartDate() {

        assertEquals(new Date(83725891034815794L), instance.getStartDate());
        assertNull(instance08.getStartDate());
        assertEquals(new Date(83725891034815794L), instance09.getStartDate());
        assertEquals(new Date(83725891034815794L), instance10.getStartDate());
        assertNull(instance11.getStartDate());
    }

    /**
     * Test of setStartDate method.
     */
    @Test
    public void testSetStartDate() {

        instance.setStartDate(new Date(83910419348815794L));
        assertEquals(new Date(83910419348815794L), instance.getStartDate());
    }

    /**
     * Test of getExpireDate method.
     */
    @Test
    public void testGetExpireDate() {

        assertEquals(new Date(9131348183414794L), instance.getExpireDate());
        assertNull(instance08.getExpireDate());
        assertEquals(new Date(9131348183414794L), instance09.getExpireDate());
        assertEquals(new Date(9131348183414794L), instance10.getExpireDate());
        assertNull(instance11.getExpireDate());
    }

    /**
     * Test of setExpireDate method.
     */
    @Test
    public void testSetExpireDate() {

        instance.setExpireDate(new Date(8913478141814124L));
        assertEquals(new Date(8913478141814124L), instance.getExpireDate());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(instance11));
        assertTrue(instance11.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(visacardPayment));

        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance11));
        assertTrue(instance11.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(visacardPayment));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(instance07));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance11.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance07.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method, of class VisacardPaymentPojo.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance11));
        assertTrue(instance11.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(visacardPayment));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("VisacardPaymentPojo{invoice reference number=null, card number=63913191431i1431}", instance.toString());

        InvoicePojo invoice = Mockito.mock(InvoicePojo.class);
        Mockito.when(invoice.getReferenceNumber()).thenReturn("re12l4kkafa");
        Mockito.when(paymentDetail.getInvoice()).thenReturn(invoice);

        assertEquals("VisacardPaymentPojo{invoice reference number=re12l4kkafa, card number=63913191431i1431}", instance.toString());

        assertEquals("VisacardPaymentPojo{invoice reference number=null, card number=null}", instance08.toString());

    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance12));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyVisacardPaymentPojo extends VisacardPaymentPojo implements HibernateProxy {

        private static final long serialVersionUID = 205592325689612113L;

        private final VisacardPaymentPojo pojo;

        public HibernateProxyVisacardPaymentPojo(VisacardPaymentPojo pojo) {

            this.pojo = pojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {

            return new AbstractMockLazyInitializer() {

                @Override
                public VisacardPaymentPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
