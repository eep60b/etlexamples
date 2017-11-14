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

import com.etlsolutions.examples.data.api.DebitcardPayment;
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
 * Test of class DebitcardPaymentEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DebitcardPaymentEntity.class, PaymentDetailEntity.class, PersonAddressLinkEntity.class})
public final class DebitcardPaymentEntityTest {

    private final PaymentDetailEntity paymentDetailEntity = PowerMockito.mock(PaymentDetailEntity.class);
    private final PaymentDetailEntity paymentDetailEntity1 = PowerMockito.mock(PaymentDetailEntity.class);
    private final PaymentDetail paymentDetail = Mockito.mock(PaymentDetail.class);
    private final PersonAddressLinkEntity personAddressLinkEntity = PowerMockito.mock(PersonAddressLinkEntity.class);
    private final PersonAddressLinkEntity personAddressLinkEntity2 = PowerMockito.mock(PersonAddressLinkEntity.class);
    private final PersonAddressLink personAddressLink = Mockito.mock(PersonAddressLink.class);
    private final int issueNumberInteger = 3;
    private final int issueNumberInteger3 = 2;
    private final IssueNumber issueNumber = new IssueNumber(3);
    private final StartDate startDate = new StartDate(7294719482394L);
    private final StartDate startDate4 = new StartDate(4913894103954L);
    private final String cardNumberString = "8993791910401931947147";
    private final String cardNumberString5 = "36213813419879123419L";
    private final PaymentCardNumber cardNumber = new PaymentCardNumber("8993791910401931947147");
    private final ExpireDate expireDate = new ExpireDate(901943184168882L);
    private final ExpireDate expireDate6 = new ExpireDate(229434897194782L);
    private final String securityCodeString = "8731";
    private final String securityCodeString7 = "8391";
    private final SecurityCode securityCode = new SecurityCode("8731");
    private final DebitcardPayment debitcardPayment = Mockito.mock(DebitcardPayment.class);

    private final DebitcardPaymentEntity instance = new DebitcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, issueNumberInteger, startDate, cardNumberString, expireDate, securityCodeString);
    private final DebitcardPaymentEntity instance00 = new DebitcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, issueNumberInteger, startDate, cardNumberString, expireDate, securityCodeString);
    private final DebitcardPaymentEntity instance01 = new DebitcardPaymentEntity(paymentDetailEntity1, personAddressLinkEntity, issueNumberInteger, startDate, cardNumberString, expireDate, securityCodeString);
    private final DebitcardPaymentEntity instance02 = new DebitcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity2, issueNumberInteger, startDate, cardNumberString, expireDate, securityCodeString);
    private final DebitcardPaymentEntity instance03 = new DebitcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, issueNumberInteger3, startDate, cardNumberString, expireDate, securityCodeString);
    private final DebitcardPaymentEntity instance04 = new DebitcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, issueNumberInteger, startDate4, cardNumberString, expireDate, securityCodeString);
    private final DebitcardPaymentEntity instance05 = new DebitcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, issueNumberInteger, startDate, cardNumberString5, expireDate, securityCodeString);
    private final DebitcardPaymentEntity instance06 = new DebitcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, issueNumberInteger, startDate, cardNumberString, expireDate6, securityCodeString);
    private final DebitcardPaymentEntity instance07 = new DebitcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, issueNumberInteger, startDate, cardNumberString, expireDate, securityCodeString7);
    private DebitcardPaymentEntity instance08;
    private DebitcardPaymentEntity instance09;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(PaymentDetailEntity.class).withArguments(paymentDetail).thenReturn(paymentDetailEntity);
        PowerMockito.whenNew(PersonAddressLinkEntity.class).withArguments(personAddressLinkEntity).thenReturn(personAddressLinkEntity);

        Mockito.when(debitcardPayment.getCardNumber()).thenReturn(cardNumberString);
        Mockito.when(debitcardPayment.getExpireDate()).thenReturn(new Date(901943184168882L));
        Mockito.when(debitcardPayment.getIssueNumber()).thenReturn(issueNumberInteger);
        Mockito.when(debitcardPayment.getPaymentDetail()).thenReturn(paymentDetailEntity);
        Mockito.when(debitcardPayment.getPersonAddressLink()).thenReturn(personAddressLink);
        Mockito.when(debitcardPayment.getSecurityCode()).thenReturn(securityCodeString);
        Mockito.when(debitcardPayment.getStartDate()).thenReturn(new Date(7294719482394L));

        instance08 = new DebitcardPaymentEntity(paymentDetail, personAddressLink, issueNumber, startDate, cardNumber, expireDate, securityCode);
        instance09 = new DebitcardPaymentEntity(debitcardPayment);
    }

    /**
     * Test of getIssueNumber method.
     */
    @Test
    public void testGetIssueNumber() {

        assertEquals(3, instance.getIssueNumber());
        assertEquals(3, instance08.getIssueNumber());
        assertEquals(3, instance09.getIssueNumber());
    }

    /**
     * Test of getStartDate method.
     */
    @Test
    public void testGetStartDate() {

        assertEquals(new Date(7294719482394L), instance.getStartDate());
        assertEquals(new Date(7294719482394L), instance08.getStartDate());
        assertEquals(new Date(7294719482394L), instance09.getStartDate());
    }

    /**
     * Test of getCardNumber method.
     */
    @Test
    public void testGetCardNumber() {

        assertEquals("8993791910401931947147", instance.getCardNumber());
        assertEquals("8993791910401931947147", instance08.getCardNumber());
        assertEquals("8993791910401931947147", instance09.getCardNumber());
    }

    /**
     * Test of getExpireDate method.
     */
    @Test
    public void testGetExpireDate() {

        assertEquals(new Date(901943184168882L), instance.getExpireDate());
        assertEquals(new Date(901943184168882L), instance08.getExpireDate());
        assertEquals(new Date(901943184168882L), instance09.getExpireDate());
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertEquals(personAddressLinkEntity, instance.getPersonAddressLink());
        assertEquals(personAddressLinkEntity, instance08.getPersonAddressLink());
        assertEquals(personAddressLinkEntity, instance09.getPersonAddressLink());
    }

    /**
     * Test of getSecurityCode method.
     */
    @Test
    public void testGetSecurityCode() {

        assertEquals("8731", instance.getSecurityCode());
        assertEquals("8731", instance08.getSecurityCode());
        assertEquals("8731", instance09.getSecurityCode());
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
        assertEquals(instance04.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        assertEquals(instance09.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
        assertNotEquals(instance07.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance08));
        assertTrue(instance.equals(instance09));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(debitcardPayment));
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
        assertTrue(instance.hasSameConstraint(instance09));

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
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance.hasSameParameters(instance09));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(instance07));
        assertFalse(instance.hasSameParameters(null));
    }
}
