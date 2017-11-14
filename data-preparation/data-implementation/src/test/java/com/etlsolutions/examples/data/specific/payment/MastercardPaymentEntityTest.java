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
package com.etlsolutions.examples.data.specific.payment;

import com.etlsolutions.examples.data.api.MastercardPayment;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MastercardPaymentEntity.class, PaymentDetailEntity.class, PersonAddressLinkEntity.class})
public final class MastercardPaymentEntityTest {

    private final PaymentDetailEntity paymentDetailEntity = PowerMockito.mock(PaymentDetailEntity.class);
    private final PaymentDetailEntity paymentDetailEntity1 = PowerMockito.mock(PaymentDetailEntity.class);
    private final PaymentDetail paymentDetail = Mockito.mock(PaymentDetail.class);
    private final PersonAddressLinkEntity personAddressLinkEntity = PowerMockito.mock(PersonAddressLinkEntity.class);
    private final PersonAddressLinkEntity personAddressLinkEntity2 = PowerMockito.mock(PersonAddressLinkEntity.class);
    private final PersonAddressLink personAddressLink = Mockito.mock(PersonAddressLink.class);
    private final StartDate startDate = new StartDate(6582378234281L);
    private final StartDate startDate3 = new StartDate(742394872234281L);
    private final String cardNumber = "478312481947914";
    private final String cardNumber4 = "275934142247914";
    private final PaymentCardNumber paymentCardNumber = new PaymentCardNumber(cardNumber);
    private final ExpireDate expireDate = new ExpireDate(12939127913789L);
    private final ExpireDate expireDate5 = new ExpireDate(28348212413789L);
    private final String securityCodeString = "9341";
    private final String securityCodeString6 = "5362";
    private final SecurityCode securityCode = new SecurityCode(securityCodeString);
    private final MastercardPayment mastercardPayment = Mockito.mock(MastercardPayment.class);

    private final MastercardPaymentEntity instance = new MastercardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, startDate, cardNumber, expireDate, securityCodeString);
    private final MastercardPaymentEntity instance00 = new MastercardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, startDate, cardNumber, expireDate, securityCodeString);
    private final MastercardPaymentEntity instance01 = new MastercardPaymentEntity(paymentDetailEntity1, personAddressLinkEntity, startDate, cardNumber, expireDate, securityCodeString);
    private final MastercardPaymentEntity instance02 = new MastercardPaymentEntity(paymentDetailEntity, personAddressLinkEntity2, startDate, cardNumber, expireDate, securityCodeString);
    private final MastercardPaymentEntity instance03 = new MastercardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, startDate3, cardNumber, expireDate, securityCodeString);
    private final MastercardPaymentEntity instance04 = new MastercardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, startDate, cardNumber4, expireDate, securityCodeString);
    private final MastercardPaymentEntity instance05 = new MastercardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, startDate, cardNumber, expireDate5, securityCodeString);
    private final MastercardPaymentEntity instance06 = new MastercardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, startDate, cardNumber, expireDate, securityCodeString6);
    private final MastercardPaymentEntity instance07 = new MastercardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, startDate, paymentCardNumber, expireDate, securityCode);
    private MastercardPaymentEntity instance08;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(PaymentDetailEntity.class).withArguments(paymentDetail).thenReturn(paymentDetailEntity);
        PowerMockito.whenNew(PersonAddressLinkEntity.class).withArguments(personAddressLink).thenReturn(personAddressLinkEntity);
        Mockito.when(mastercardPayment.getCardNumber()).thenReturn(cardNumber);
        Mockito.when(mastercardPayment.getExpireDate()).thenReturn(new Date(12939127913789L));
        Mockito.when(mastercardPayment.getPaymentDetail()).thenReturn(paymentDetailEntity);
        Mockito.when(mastercardPayment.getPersonAddressLink()).thenReturn(personAddressLinkEntity);
        Mockito.when(mastercardPayment.getSecurityCode()).thenReturn(securityCodeString);
        Mockito.when(mastercardPayment.getStartDate()).thenReturn(new Date(6582378234281L));

        instance08 = new MastercardPaymentEntity(mastercardPayment);
    }

    /**
     * Test of getStartDate method.
     */
    @Test
    public void testGetStartDate() {

        assertEquals(new Date(6582378234281L), instance.getStartDate());
        assertEquals(new Date(6582378234281L), instance07.getStartDate());
        assertEquals(new Date(6582378234281L), instance08.getStartDate());
    }

    /**
     * Test of getCardNumber method.
     */
    @Test
    public void testGetCardNumber() {

        assertEquals("478312481947914", instance.getCardNumber());
        assertEquals("478312481947914", instance07.getCardNumber());
        assertEquals("478312481947914", instance08.getCardNumber());
    }

    /**
     * Test of getExpireDate method.
     */
    @Test
    public void testGetExpireDate() {

        assertEquals(new Date(12939127913789L), instance.getExpireDate());
        assertEquals(new Date(12939127913789L), instance07.getExpireDate());
        assertEquals(new Date(12939127913789L), instance08.getExpireDate());
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertEquals(personAddressLinkEntity, instance.getPersonAddressLink());
        assertEquals(personAddressLinkEntity, instance07.getPersonAddressLink());
        assertEquals(personAddressLinkEntity, instance08.getPersonAddressLink());
    }

    /**
     * Test of getSecurityCode method.
     */
    @Test
    public void testGetSecurityCode() {

        assertEquals("9341", instance.getSecurityCode());
        assertEquals("9341", instance07.getSecurityCode());
        assertEquals("9341", instance08.getSecurityCode());
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPaymentDetail() {

        assertEquals(paymentDetailEntity, instance.getPaymentDetail());
        assertEquals(paymentDetailEntity, instance07.getPaymentDetail());
        assertEquals(paymentDetailEntity, instance08.getPaymentDetail());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance07.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
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
        assertTrue(instance.equals(instance07));
        assertTrue(instance.equals(instance08));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(mastercardPayment));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance.hasSameConstraint(mastercardPayment));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance07));
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance.hasSameParameters(mastercardPayment));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(null));
    }
}
