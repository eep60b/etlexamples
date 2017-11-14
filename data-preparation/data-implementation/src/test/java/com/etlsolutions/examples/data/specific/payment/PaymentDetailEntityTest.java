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

import com.etlsolutions.examples.data.specific.payment.PaymentDetailEntity;
import com.etlsolutions.examples.data.specific.payment.PaymentSubtotal;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.data.specific.purchase.InvoiceEntity;
import com.etlsolutions.examples.utility.NumberUtilities;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class PaymentDetailEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PaymentDetailEntity.class, InvoiceEntity.class})
public final class PaymentDetailEntityTest {

    private final InvoiceEntity invoiceEntity = PowerMockito.mock(InvoiceEntity.class);
    private final InvoiceEntity invoiceEntity1 = PowerMockito.mock(InvoiceEntity.class);
    private final Invoice invoice5 = Mockito.mock(Invoice.class);
    private final PaymentSubtotal paymentSubtotal = new PaymentSubtotal(new BigDecimal(29.22));
    private final PaymentSubtotal paymentSubtotal2 = new PaymentSubtotal(new BigDecimal(33.77));
    private final CurrencyCode currencyType = CurrencyCode.DMK;
    private final CurrencyCode currencyType3 = CurrencyCode.YEN;
    private final PaymentType paymentType = PaymentType.MASTER_CARD;
    private final PaymentType paymentType4 = PaymentType.VISA_CARD;

    private final PaymentDetail paymentDetail = Mockito.mock(PaymentDetail.class);

    private final PaymentDetailEntity instance = new PaymentDetailEntity(invoiceEntity, paymentSubtotal, currencyType, paymentType);
    private final PaymentDetailEntity instance00 = new PaymentDetailEntity(invoiceEntity, paymentSubtotal, currencyType, paymentType);
    private final PaymentDetailEntity instance01 = new PaymentDetailEntity(invoiceEntity1, paymentSubtotal, currencyType, paymentType);
    private final PaymentDetailEntity instance02 = new PaymentDetailEntity(invoiceEntity, paymentSubtotal2, currencyType, paymentType);
    private final PaymentDetailEntity instance03 = new PaymentDetailEntity(invoiceEntity, paymentSubtotal, currencyType3, paymentType);
    private final PaymentDetailEntity instance04 = new PaymentDetailEntity(invoiceEntity, paymentSubtotal, currencyType, paymentType4);
    private PaymentDetailEntity instance05;
    private PaymentDetailEntity instance06;

    @Before
    public void setUp() throws Exception {

        Mockito.when(paymentDetail.getInvoice()).thenReturn(invoiceEntity);
        Mockito.when(paymentDetail.getCurrencyCode()).thenReturn(CurrencyCode.DMK);
        Mockito.when(paymentDetail.getPaymentType()).thenReturn(PaymentType.MASTER_CARD);
        Mockito.when(paymentDetail.getSubtotal()).thenReturn(new BigDecimal(29.22));
        PowerMockito.whenNew(InvoiceEntity.class).withArguments(invoice5).thenReturn(invoiceEntity);

        instance05 = new PaymentDetailEntity(invoice5, paymentSubtotal, currencyType, paymentType);
        instance06 = new PaymentDetailEntity(instance);
    }

    /**
     * Test of getInvoice method.
     */
    @Test
    public void testGetInvoice() {

        assertEquals(invoiceEntity, instance.getInvoice());
        assertEquals(invoiceEntity1, instance01.getInvoice());
        assertEquals(invoiceEntity, instance05.getInvoice());
        assertEquals(invoiceEntity, instance06.getInvoice());
    }

    /**
     * Test of getSubtotal method.
     */
    @Test
    public void testGetSubtotal() {

        assertTrue(NumberUtilities.equals(new BigDecimal(29.22), instance.getSubtotal(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(33.77), instance02.getSubtotal(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(29.22), instance05.getSubtotal(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(29.22), instance06.getSubtotal(), 2));
    }

    /**
     * Test of getCurrencyCode method.
     */
    @Test
    public void testGetCurrencyCode() {

        assertEquals(CurrencyCode.DMK, instance.getCurrencyCode());
        assertEquals(CurrencyCode.YEN, instance03.getCurrencyCode());
        assertEquals(CurrencyCode.DMK, instance05.getCurrencyCode());
        assertEquals(CurrencyCode.DMK, instance06.getCurrencyCode());
    }

    /**
     * Test of getPaymentType method.
     */
    @Test
    public void testGetPaymentType() {

        assertEquals(PaymentType.MASTER_CARD, instance.getPaymentType());
        assertEquals(PaymentType.VOUCHER, instance04.getPaymentType());
        assertEquals(PaymentType.MASTER_CARD, instance05.getPaymentType());
        assertEquals(PaymentType.MASTER_CARD, instance06.getPaymentType());

    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance02.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        
        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings({"ObjectEqualsNull", "IncompatibleEquals"})
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance05));
        assertTrue(instance.equals(instance06));
        
        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(paymentDetail));
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
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(paymentDetail));
        
        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance04));
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
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(paymentDetail));
        
        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        Mockito.when(invoiceEntity.getReferenceNumber()).thenReturn("99184361rq");
        assertEquals("PaymentDetailEntity{invoice=99184361rq, payment type=MASTER_CARD}", instance.toString());
    }
}
