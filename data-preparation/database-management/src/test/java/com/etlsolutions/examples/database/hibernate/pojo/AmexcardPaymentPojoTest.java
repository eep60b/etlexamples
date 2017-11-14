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

import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.AmexcardPayment;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class AmexcardPaymentPojo.
 *
 * @author zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AmexcardPaymentPojoTest {

    private final int id = 19034;
    private final int id1 = 983;
    private final PersonAddressLinkPojo personAddressLinkPojo = new PersonAddressLinkPojo(28287, new AddressPojo(2392, "juous", "sstreeettet", "adaj", "citiy", "aareaara", "couuuntrrry", "pposoostcode"), new PersonalDetailPojo(id, "Mr.", "GGivvennnv Nammm", "FammaklllyNmae", new Date(21789134781984719L), new byte[]{}), AddressType.CONTACT);
    private final PersonAddressLinkPojo personAddressLinkPojo2 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PaymentDetailPojo paymentDetailPojo = new PaymentDetailPojo(new PaymentDetailIdPojo(28281, PaymentType.VISA_CARD), new InvoicePojo(new CustomerPojo(personAddressLinkPojo, "uusadalnmae", "!£$££AFDafdasQ£adfa", new byte[]{68, 93, 44}), new AddressPojo(2392, "juous", "sstreeettet", "adaj", "citiy", "aareaara", "couuuntrrry", "pposoostcode"), new Date(9430128048104L), BigDecimal.ZERO, InvoiceValidity.YES, "19347jop1u431o34"), BigDecimal.ZERO, CurrencyCode.USD);
    private final PaymentDetailPojo paymentDetailPojo3 = Mockito.mock(PaymentDetailPojo.class);
    private final String cardNumber = "92134912034794";
    private final String cardNumber4 = "91234813912491";
    private final String securityCode = "3812";
    private final String securityCode5 = "9899";
    private final Date expireDate = new Date(1903718931094438L);
    private final Date expireDate6 = new Date(9018341934190489L);
    private final AmexcardPayment amexcardPayment = Mockito.mock(AmexcardPayment.class);

    private final AmexcardPaymentPojo instance = new AmexcardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, expireDate);
    private final AmexcardPaymentPojo instance00 = new AmexcardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, expireDate);
    private final AmexcardPaymentPojo instance01 = new AmexcardPaymentPojo(id1, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, expireDate);
    private final AmexcardPaymentPojo instance02 = new AmexcardPaymentPojo(id, personAddressLinkPojo2, paymentDetailPojo, cardNumber, securityCode, expireDate);
    private final AmexcardPaymentPojo instance03 = new AmexcardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo3, cardNumber, securityCode, expireDate);
    private final AmexcardPaymentPojo instance04 = new AmexcardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber4, securityCode, expireDate);
    private final AmexcardPaymentPojo instance05 = new AmexcardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode5, expireDate);
    private final AmexcardPaymentPojo instance06 = new AmexcardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, expireDate6);
    private final AmexcardPaymentPojo instance07 = new AmexcardPaymentPojo();
    private final AmexcardPaymentPojo instance08 = new AmexcardPaymentPojo(id, paymentDetailPojo, cardNumber, securityCode, expireDate);
    private final AmexcardPaymentPojo instance09 = new AmexcardPaymentPojo(personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, expireDate);
    private final AmexcardPaymentPojo instance10 = new HibernateProxyAmexcardPaymentPojo(new AmexcardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, expireDate));

    @Before
    public void setUp() {

        Mockito.when(amexcardPayment.getCardNumber()).thenReturn(cardNumber);
        Mockito.when(amexcardPayment.getExpireDate()).thenReturn(expireDate);
        Mockito.when(amexcardPayment.getPaymentDetail()).thenReturn(paymentDetailPojo);
        Mockito.when(amexcardPayment.getPersonAddressLink()).thenReturn(personAddressLinkPojo);
        Mockito.when(amexcardPayment.getSecurityCode()).thenReturn(securityCode);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(19034, instance.getId());
        assertEquals(0, instance07.getId());
        assertEquals(19034, instance08.getId());
        assertEquals(0, instance09.getId());
        assertEquals(0, instance10.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(6576);
        assertEquals(6576, instance.getId());
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertEquals(personAddressLinkPojo, instance.getPersonAddressLink());
        assertNull(instance07.getPersonAddressLink());
        assertNull(instance08.getPersonAddressLink());
        assertEquals(personAddressLinkPojo, instance09.getPersonAddressLink());
        assertNull(instance10.getPersonAddressLink());
    }

    /**
     * Test of setPersonAddressLink method.
     */
    @Test
    public void testSetPersonAddressLink() {

        PersonAddressLinkPojo personAddressLink = Mockito.mock(PersonAddressLinkPojo.class);
        instance.setPersonAddressLink(personAddressLink);
        assertEquals(personAddressLink, instance.getPersonAddressLink());
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPaymentDetail() {

        assertEquals(paymentDetailPojo, instance.getPaymentDetail());
        assertNull(instance07.getPaymentDetail());
        assertEquals(paymentDetailPojo, instance08.getPaymentDetail());
        assertEquals(paymentDetailPojo, instance09.getPaymentDetail());
        assertNull(instance10.getPaymentDetail());
    }

    /**
     * Test of setPaymentDetail method.
     */
    @Test
    public void testSetPaymentDetail() {

        PaymentDetailPojo paymentDetail = Mockito.mock(PaymentDetailPojo.class);
        instance.setPaymentDetail(paymentDetail);
        assertEquals(paymentDetail, instance.getPaymentDetail());
    }

    /**
     * Test of getCardNumber method.
     */
    @Test
    public void testGetCardNumber() {

        assertEquals("92134912034794", instance.getCardNumber());
        assertNull(instance07.getCardNumber());
        assertEquals("92134912034794", instance08.getCardNumber());
        assertEquals("92134912034794", instance09.getCardNumber());
        assertNull(instance10.getCardNumber());
    }

    /**
     * Test of setCardNumber method.
     */
    @Test
    public void testSetCardNumber() {

        instance.setCardNumber("228826762627278");
        assertEquals("228826762627278", instance.getCardNumber());
    }

    /**
     * Test of getSecurityCode method.
     */
    @Test
    public void testGetSecurityCode() {

        assertEquals("3812", instance.getSecurityCode());
        assertNull(instance07.getSecurityCode());
        assertEquals("3812", instance08.getSecurityCode());
        assertEquals("3812", instance09.getSecurityCode());
        assertNull(instance10.getSecurityCode());

    }

    /**
     * Test of setSecurityCode method.
     */
    @Test
    public void testSetSecurityCode() {

        instance.setSecurityCode("3480");
        assertEquals("3480", instance.getSecurityCode());
    }

    /**
     * Test of getExpireDate method.
     */
    @Test
    public void testGetExpireDate() {

        assertEquals(new Date(1903718931094438L), instance.getExpireDate());
        assertNull(instance07.getExpireDate());
        assertEquals(new Date(1903718931094438L), instance08.getExpireDate());
        assertEquals(new Date(1903718931094438L), instance09.getExpireDate());
        assertNull(instance10.getExpireDate());
    }

    /**
     * Test of setExpireDate method.
     */
    @Test
    public void testSetExpireDate() {

        instance.setExpireDate(new Date(7198734917439128419L));
        assertEquals(new Date(7198734917439128419L), instance.getExpireDate());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());        
        assertEquals(instance10.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance10));
        assertTrue(instance10.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(amexcardPayment));
        assertFalse(instance.equals(null));
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
        assertTrue(instance.hasSameConstraint(instance10));
        assertTrue(instance10.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(amexcardPayment));

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
        assertTrue(instance.hasSameParameters(instance10));
        assertTrue(instance10.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(amexcardPayment));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("AmexcardPaymentPojo{invoice reference number=19347jop1u431o34, card number=92134912034794}", instance.toString());
        instance.getPaymentDetail().setInvoice(null);
        assertEquals("AmexcardPaymentPojo{invoice reference number=null, card number=92134912034794}", instance.toString());
        instance.setPaymentDetail(null);
        assertEquals("AmexcardPaymentPojo{invoice reference number=null, card number=92134912034794}", instance.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyAmexcardPaymentPojo extends AmexcardPaymentPojo implements HibernateProxy {

        private static final long serialVersionUID = 49452440571667194L;
                
        private final AmexcardPaymentPojo pojo;

        public HibernateProxyAmexcardPaymentPojo(AmexcardPaymentPojo pojo) {

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
                public AmexcardPaymentPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
