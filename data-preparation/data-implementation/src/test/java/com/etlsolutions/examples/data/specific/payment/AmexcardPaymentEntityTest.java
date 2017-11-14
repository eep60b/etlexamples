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

import com.etlsolutions.examples.data.api.AmexcardPayment;
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
 * Test of class AmexcardPaymentEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AmexcardPaymentEntity.class, PaymentDetailEntity.class, PersonAddressLinkEntity.class, ExpireDate.class})
public final class AmexcardPaymentEntityTest {

    private final PaymentDetailEntity paymentDetailEntity = PowerMockito.mock(PaymentDetailEntity.class);
    private final PaymentDetailEntity paymentDetailEntity1 = PowerMockito.mock(PaymentDetailEntity.class);
    private final PaymentDetail paymentDetail = Mockito.mock(PaymentDetail.class);
    private final PersonAddressLinkEntity personAddressLinkEntity = PowerMockito.mock(PersonAddressLinkEntity.class);
    private final PersonAddressLinkEntity personAddressLinkEntity2 = PowerMockito.mock(PersonAddressLinkEntity.class);
    private final PersonAddressLink personAddressLink = Mockito.mock(PersonAddressLink.class);
    private final PaymentCardNumber cardNumber = new PaymentCardNumber("014308103097134904");
    private final PaymentCardNumber cardNumber3 = new PaymentCardNumber("84311471941901341");
    private final ExpireDate expireDate = new ExpireDate(new Date(32843174914831924L));
    private final ExpireDate expireDate4 = new ExpireDate(new Date(6124391914893221L));
    private final SecurityCode securityCode = new SecurityCode("5768");
    private final SecurityCode securityCode5 = new SecurityCode("9234");
    private final AmexcardPayment amexcardPayment = Mockito.mock(AmexcardPayment.class);

    private final AmexcardPaymentEntity instance = new AmexcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, cardNumber, expireDate, securityCode);
    private final AmexcardPaymentEntity instance00 = new AmexcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, cardNumber, expireDate, securityCode);
    private final AmexcardPaymentEntity instance01 = new AmexcardPaymentEntity(paymentDetailEntity1, personAddressLinkEntity, cardNumber, expireDate, securityCode);
    private final AmexcardPaymentEntity instance02 = new AmexcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity2, cardNumber, expireDate, securityCode);
    private final AmexcardPaymentEntity instance03 = new AmexcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, cardNumber3, expireDate, securityCode);
    private final AmexcardPaymentEntity instance04 = new AmexcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, cardNumber, expireDate4, securityCode);
    private final AmexcardPaymentEntity instance05 = new AmexcardPaymentEntity(paymentDetailEntity, personAddressLinkEntity, cardNumber, expireDate, securityCode5);

    private AmexcardPaymentEntity instance06;

    @Before
    public void setUp() throws Exception {
        
        PowerMockito.whenNew(PaymentDetailEntity.class).withArguments(paymentDetail).thenReturn(paymentDetailEntity);

        Mockito.when(amexcardPayment.getCardNumber()).thenReturn("014308103097134904");
        Mockito.when(amexcardPayment.getExpireDate()).thenReturn(new Date(32843174914831924L));
        Mockito.when(amexcardPayment.getPaymentDetail()).thenReturn(paymentDetailEntity);
        Mockito.when(amexcardPayment.getPersonAddressLink()).thenReturn(personAddressLinkEntity);
        Mockito.when(amexcardPayment.getSecurityCode()).thenReturn("5768");

        instance06 = new AmexcardPaymentEntity(amexcardPayment);
    }

    /**
     * Test of getCardNumber method.
     */
    @Test
    public void testGetCardNumber() {

        assertEquals("014308103097134904", instance.getCardNumber());
        assertEquals("014308103097134904", instance06.getCardNumber());
    }

    /**
     * Test of getExpireDate method.
     */
    @Test
    public void testGetExpireDate() {

        assertEquals(new Date(32843174914831924L), instance.getExpireDate());
        assertEquals(new Date(32843174914831924L), instance06.getExpireDate());
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertEquals(personAddressLinkEntity, instance.getPersonAddressLink());
        assertEquals(personAddressLinkEntity, instance06.getPersonAddressLink());
    }

    /**
     * Test of getSecurityCode method.
     */
    @Test
    public void testGetSecurityCode() {

        assertEquals("5768", instance.getSecurityCode());
        assertEquals("5768", instance06.getSecurityCode());
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPaymentDetail() {

        assertEquals(paymentDetailEntity, instance.getPaymentDetail());
        assertEquals(paymentDetailEntity, instance06.getPaymentDetail());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
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
        assertTrue(instance.equals(instance06));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
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
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(amexcardPayment));

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
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(amexcardPayment));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(null));
    }
}
