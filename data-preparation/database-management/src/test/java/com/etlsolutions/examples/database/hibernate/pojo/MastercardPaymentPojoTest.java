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

import com.etlsolutions.examples.data.api.MastercardPayment;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Date;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class MastercardPaymentPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class MastercardPaymentPojoTest {

    private final int id = 23219;
    private final int id1 = 8825;
    private final PersonAddressLinkPojo personAddressLinkPojo = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLinkPojo2 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PaymentDetailPojo paymentDetailPojo = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetailPojo3 = Mockito.mock(PaymentDetailPojo.class);
    private final String cardNumber = "3183673494823717";
    private final String cardNumber4 = "8383619278332341";
    private final String securityCode = "992";
    private final String securityCode5 = "883";
    private final Date startDate = new Date(3901437193143L);
    private final Date startDate6 = new Date(8943288278113L);
    private final Date expireDate = new Date(6183914194719L);
    private final Date expireDate7 = new Date(4378813188119L);
    private final MastercardPayment mastercardPayment = Mockito.mock(MastercardPayment.class);

    private final MastercardPaymentPojo instance = new MastercardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, startDate, expireDate);
    private final MastercardPaymentPojo instance00 = new MastercardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, startDate, expireDate);
    private final MastercardPaymentPojo instance01 = new MastercardPaymentPojo(id1, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, startDate, expireDate);
    private final MastercardPaymentPojo instance02 = new MastercardPaymentPojo(id, personAddressLinkPojo2, paymentDetailPojo, cardNumber, securityCode, startDate, expireDate);
    private final MastercardPaymentPojo instance03 = new MastercardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo3, cardNumber, securityCode, startDate, expireDate);
    private final MastercardPaymentPojo instance04 = new MastercardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber4, securityCode, startDate, expireDate);
    private final MastercardPaymentPojo instance05 = new MastercardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode5, startDate, expireDate);
    private final MastercardPaymentPojo instance06 = new MastercardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, startDate6, expireDate);
    private final MastercardPaymentPojo instance07 = new MastercardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, startDate, expireDate7);
    private final MastercardPaymentPojo instance08 = new MastercardPaymentPojo();
    private final MastercardPaymentPojo instance09 = new MastercardPaymentPojo(id, paymentDetailPojo, cardNumber, securityCode, startDate, expireDate);
    private final MastercardPaymentPojo instance10 = new MastercardPaymentPojo(personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, startDate, expireDate);
    private final MastercardPaymentPojo instance11 = new MastercardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, startDate, expireDate);
    private final MastercardPaymentPojo instance12 = new HibernateProxyMastercardPaymentPojo(new MastercardPaymentPojo(id, personAddressLinkPojo, paymentDetailPojo, cardNumber, securityCode, startDate, expireDate));
    private final MastercardPaymentPojo instance13 = new MastercardPaymentPojo(id, new PersonAddressLinkPojo(), new PaymentDetailPojo(), cardNumber, securityCode, startDate, expireDate);

    @Before
    public void setUp() {

        Mockito.when(mastercardPayment.getCardNumber()).thenReturn(cardNumber);
        Mockito.when(mastercardPayment.getExpireDate()).thenReturn(expireDate);
        Mockito.when(mastercardPayment.getPaymentDetail()).thenReturn(paymentDetailPojo);
        Mockito.when(mastercardPayment.getPersonAddressLink()).thenReturn(personAddressLinkPojo);
        Mockito.when(mastercardPayment.getSecurityCode()).thenReturn(securityCode);
        Mockito.when(mastercardPayment.getStartDate()).thenReturn(startDate);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(23219, instance.getId());
        assertEquals(0, instance08.getId());
        assertEquals(23219, instance09.getId());
        assertEquals(0, instance10.getId());
        assertEquals(23219, instance11.getId());
        assertEquals(0, instance12.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(1335);
        assertEquals(1335, instance.getId());
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertEquals(personAddressLinkPojo, instance.getPersonAddressLink());
        assertNull(instance08.getPersonAddressLink());
        assertNull(instance09.getPersonAddressLink());
        assertEquals(personAddressLinkPojo, instance10.getPersonAddressLink());
        assertEquals(personAddressLinkPojo, instance11.getPersonAddressLink());
        assertNull(instance12.getPersonAddressLink());
    }

    /**
     * Test of setPersonAddressLink method.
     */
    @Test
    public void testSetPersonAddressLink() {

        PersonAddressLinkPojo personAddressLinkK = Mockito.mock(PersonAddressLinkPojo.class);
        instance.setPersonAddressLink(personAddressLinkK);
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPaymentDetail() {

        assertEquals(paymentDetailPojo, instance.getPaymentDetail());
        assertNull(instance08.getPaymentDetail());
        assertEquals(paymentDetailPojo, instance09.getPaymentDetail());
        assertEquals(paymentDetailPojo, instance10.getPaymentDetail());
        assertEquals(paymentDetailPojo, instance11.getPaymentDetail());
        assertNull(instance12.getPaymentDetail());
    }

    /**
     * Test of setPaymentDetail method.
     */
    @Test
    public void testSetPaymentDetail() {

        PaymentDetailPojo paymentDetailK = Mockito.mock(PaymentDetailPojo.class);
        instance.setPaymentDetail(paymentDetailK);
        assertEquals(paymentDetailK, instance.getPaymentDetail());
    }

    /**
     * Test of getCardNumber method.
     */
    @Test
    public void testGetCardNumber() {

        assertEquals("3183673494823717", instance.getCardNumber());
        assertNull(instance08.getCardNumber());
        assertEquals("3183673494823717", instance09.getCardNumber());
        assertEquals("3183673494823717", instance10.getCardNumber());
        assertEquals("3183673494823717", instance11.getCardNumber());
        assertNull(instance12.getCardNumber());
    }

    /**
     * Test of setCardNumber method.
     */
    @Test
    public void testSetCardNumber() {

        String cardNumberK = "882227772727272";
        instance.setCardNumber(cardNumberK);
        assertEquals("882227772727272", instance.getCardNumber());
    }

    /**
     * Test of getSecurityCode method.
     */
    @Test
    public void testGetSecurityCode() {

        assertEquals("992", instance.getSecurityCode());
        assertNull(instance08.getSecurityCode());
        assertEquals("992", instance09.getSecurityCode());
        assertEquals("992", instance10.getSecurityCode());
        assertEquals("992", instance11.getSecurityCode());
        assertNull(instance12.getSecurityCode());
    }

    /**
     * Test of setSecurityCode method.
     */
    @Test
    public void testSetSecurityCode() {

        instance.setSecurityCode("231");
        assertEquals("231", instance.getSecurityCode());
    }

    /**
     * Test of getStartDate method.
     */
    @Test
    public void testGetStartDate() {

        assertEquals(new Date(3901437193143L), instance.getStartDate());
        instance.getStartDate().setTime(6143943413947140L);
        assertEquals(new Date(3901437193143L), instance.getStartDate());
        startDate.setTime(6143943413947140L);
        assertEquals(new Date(3901437193143L), instance.getStartDate());

        assertNull(instance08.getStartDate());
       assertEquals(new Date(3901437193143L), instance09.getStartDate());
        assertEquals(new Date(3901437193143L), instance10.getStartDate());
        assertEquals(new Date(3901437193143L), instance11.getStartDate());
        assertNull(instance12.getStartDate());
    }

    /**
     * Test of setStartDate method.
     */
    @Test
    public void testSetStartDate() {

        Date date = new Date(390173261143L);
        instance.setStartDate(date);
        assertEquals(new Date(390173261143L), instance.getStartDate());
        date.setTime(82326267839378L);
        assertEquals(new Date(390173261143L), instance.getStartDate());
    }

    /**
     * Test of getExpireDate method.
     */
    @Test
    public void testGetExpireDate() {

        assertEquals(new Date(6183914194719L), instance.getExpireDate());
        instance.getExpireDate().setTime(1228976781212L);
        assertEquals(new Date(6183914194719L), instance.getExpireDate());
        expireDate.setTime(1228976781212L);
        assertEquals(new Date(6183914194719L), instance.getExpireDate());

        assertNull(instance08.getExpireDate());
        assertEquals(new Date(6183914194719L), instance09.getExpireDate());
        assertEquals(new Date(6183914194719L), instance10.getExpireDate());
        assertEquals(new Date(6183914194719L), instance11.getExpireDate());
        assertNull(instance12.getExpireDate());
    }

    /**
     * Test of setExpireDate method.
     */
    @Test
    public void testSetExpireDate() {

        Date date = new Date(8243914194719L);
        instance.setExpireDate(date);
        assertEquals(new Date(8243914194719L), instance.getExpireDate());
        date.setTime(93791204191234L);
        assertEquals(new Date(8243914194719L), instance.getExpireDate());
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
        assertTrue(instance.hasSameConstraint(instance12));
        assertTrue(instance12.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(mastercardPayment));

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
        assertTrue(instance.hasSameParameters(instance12));
        assertTrue(instance12.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(mastercardPayment));

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
        assertEquals(instance12.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance07.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method, of class MastercardPaymentPojo.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance12));
        assertTrue(instance12.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(mastercardPayment));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        
        Mockito.when(paymentDetailPojo.getId()).thenReturn(2886);
        assertEquals("MastercardPaymentPojo{id=23219, payment id=2886, card number=3183673494823717}", instance.toString());
        assertEquals("MastercardPaymentPojo{id=0, payment id=0, card number=null}", instance08.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance13));
    }

    private final class HibernateProxyMastercardPaymentPojo extends MastercardPaymentPojo implements HibernateProxy {

        private static final long serialVersionUID = 420971482594294978L;

        private final MastercardPaymentPojo pojo;

        public HibernateProxyMastercardPaymentPojo(MastercardPaymentPojo addressPojo) {

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
                public MastercardPaymentPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
