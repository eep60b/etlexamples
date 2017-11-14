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

import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.utility.NumberUtilities;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class PaymentDetailPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PaymentDetailPojoTest {

    private final int id = 321919;
    private final int id1 = 2228827;
    private final PaymentDetailIdPojo idObject = new PaymentDetailIdPojo(id, PaymentType.VISA_CARD);
    private final PaymentDetailIdPojo idObject1 = new PaymentDetailIdPojo(id1, PaymentType.VISA_CARD);
    private final PaymentDetailIdPojo idObject2 = new PaymentDetailIdPojo(id, PaymentType.AMEX_CARD);
    private final InvoicePojo invoice = Mockito.mock(InvoicePojo.class);
    private final InvoicePojo invoice3 = Mockito.mock(InvoicePojo.class);
    private final BigDecimal subtotal = new BigDecimal(23.22);
    private final BigDecimal subtotal4 = new BigDecimal(35.22);

    private final DebitcardPaymentPojo debitcardPaymentPojo1 = Mockito.mock(DebitcardPaymentPojo.class);
    private final DebitcardPaymentPojo debitcardPaymentPojo2 = Mockito.mock(DebitcardPaymentPojo.class);
    private final DebitcardPaymentPojo debitcardPaymentPojo3 = Mockito.mock(DebitcardPaymentPojo.class);
    private final DebitcardPaymentPojo debitcardPaymentPojo4 = Mockito.mock(DebitcardPaymentPojo.class);
    private final Set<DebitcardPaymentPojo> debitcardPayments = new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo2, debitcardPaymentPojo3));
    private final Set<DebitcardPaymentPojo> debitcardPayments6 = new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo4));
    private final Set<DebitcardPaymentPojo> debitcardPayments7 = null;

    private final VisacardPaymentPojo visacardPaymentPojo1 = Mockito.mock(VisacardPaymentPojo.class);
    private final VisacardPaymentPojo visacardPaymentPojo2 = Mockito.mock(VisacardPaymentPojo.class);
    private final VisacardPaymentPojo visacardPaymentPojo3 = Mockito.mock(VisacardPaymentPojo.class);
    private final VisacardPaymentPojo visacardPaymentPojo4 = Mockito.mock(VisacardPaymentPojo.class);
    private final Set<VisacardPaymentPojo> visacardPayments = new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo2, visacardPaymentPojo3));
    private final Set<VisacardPaymentPojo> visacardPayments8 = new HashSet<>(Arrays.asList(visacardPaymentPojo2, visacardPaymentPojo4));
    private final Set<VisacardPaymentPojo> visacardPayments9 = null;

    private final MastercardPaymentPojo mastercardPaymentPojo1 = Mockito.mock(MastercardPaymentPojo.class);
    private final MastercardPaymentPojo mastercardPaymentPojo2 = Mockito.mock(MastercardPaymentPojo.class);
    private final MastercardPaymentPojo mastercardPaymentPojo3 = Mockito.mock(MastercardPaymentPojo.class);
    private final MastercardPaymentPojo mastercardPaymentPojo4 = Mockito.mock(MastercardPaymentPojo.class);
    private final Set<MastercardPaymentPojo> mastercardPayments = new HashSet<>(Arrays.asList(mastercardPaymentPojo1, mastercardPaymentPojo2, mastercardPaymentPojo3));
    private final Set<MastercardPaymentPojo> mastercardPayments10 = new HashSet<>(Arrays.asList(mastercardPaymentPojo3, mastercardPaymentPojo4));
    private final Set<MastercardPaymentPojo> mastercardPayments11 = null;

    private final PaypalPaymentPojo paypalPaymentPojo1 = Mockito.mock(PaypalPaymentPojo.class);
    private final PaypalPaymentPojo paypalPaymentPojo2 = Mockito.mock(PaypalPaymentPojo.class);
    private final PaypalPaymentPojo paypalPaymentPojo3 = Mockito.mock(PaypalPaymentPojo.class);
    private final PaypalPaymentPojo paypalPaymentPojo4 = Mockito.mock(PaypalPaymentPojo.class);
    private final Set<PaypalPaymentPojo> paypalPayments = new HashSet<>(Arrays.asList(paypalPaymentPojo1, paypalPaymentPojo2, paypalPaymentPojo3));
    private final Set<PaypalPaymentPojo> paypalPayments12 = new HashSet<>(Arrays.asList(paypalPaymentPojo2, paypalPaymentPojo4));
    private final Set<PaypalPaymentPojo> paypalPayments13 = null;

    private final VoucherPojo voucherPojo1 = Mockito.mock(VoucherPojo.class);
    private final VoucherPojo voucherPojo2 = Mockito.mock(VoucherPojo.class);
    private final VoucherPojo voucherPojo3 = Mockito.mock(VoucherPojo.class);
    private final VoucherPojo voucherPojo4 = Mockito.mock(VoucherPojo.class);
    private final Set<VoucherPojo> vouchers = new HashSet<>(Arrays.asList(voucherPojo1, voucherPojo2, voucherPojo3));
    private final Set<VoucherPojo> vouchers14 = new HashSet<>(Arrays.asList(voucherPojo3, voucherPojo4));
    private final Set<VoucherPojo> vouchers15 = null;

    private final AmexcardPaymentPojo amexcardPaymentPojo1 = Mockito.mock(AmexcardPaymentPojo.class);
    private final AmexcardPaymentPojo amexcardPaymentPojo2 = Mockito.mock(AmexcardPaymentPojo.class);
    private final AmexcardPaymentPojo amexcardPaymentPojo3 = Mockito.mock(AmexcardPaymentPojo.class);
    private final AmexcardPaymentPojo amexcardPaymentPojo4 = Mockito.mock(AmexcardPaymentPojo.class);
    private final Set<AmexcardPaymentPojo> amexcardPayments = new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2, amexcardPaymentPojo3));
    private final Set<AmexcardPaymentPojo> amexcardPayments16 = new HashSet<>(Arrays.asList(amexcardPaymentPojo4, amexcardPaymentPojo2));
    private final Set<AmexcardPaymentPojo> amexcardPayments17 = null;

    private final PaymentDetail paymentDetail = Mockito.mock(PaymentDetail.class);

    private final PaymentDetailPojo instance = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance00 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance01 = new PaymentDetailPojo(idObject1, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance02 = new PaymentDetailPojo(idObject2, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance03 = new PaymentDetailPojo(idObject, invoice3, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance04 = new PaymentDetailPojo(idObject, invoice, subtotal4, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance05 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.BRP, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance06 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments6, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance07 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments7, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance08 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments8, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance09 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments9, mastercardPayments, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance10 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments10, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance11 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments11, paypalPayments, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance12 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments12, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance13 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments13, vouchers, amexcardPayments);
    private final PaymentDetailPojo instance14 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers14, amexcardPayments);
    private final PaymentDetailPojo instance15 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers15, amexcardPayments);
    private final PaymentDetailPojo instance16 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments16);
    private final PaymentDetailPojo instance17 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments17);

    private final PaymentDetailPojo instance18 = new PaymentDetailPojo();
    private final PaymentDetailPojo instance19 = new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD);
    private final PaymentDetailPojo instance20 = new PaymentDetailPojo(PaymentType.AMEX_CARD, invoice, subtotal, CurrencyCode.USD);
    private final PaymentDetailPojo instance21 = new HibernateProxyPaymentDetailPojoPojo(new PaymentDetailPojo(idObject, invoice, subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments));
    private final PaymentDetailPojo instance22 = new PaymentDetailPojo(idObject, new InvoicePojo(), subtotal, CurrencyCode.USD, debitcardPayments, visacardPayments, mastercardPayments, paypalPayments, vouchers, amexcardPayments);

    @Before
    public void setUp() {

        Mockito.when(paymentDetail.getCurrencyCode()).thenReturn(CurrencyCode.USD);
        Mockito.when(paymentDetail.getInvoice()).thenReturn(invoice);
        Mockito.when(paymentDetail.getPaymentType()).thenReturn(PaymentType.VISA_CARD);
        Mockito.when(paymentDetail.getSubtotal()).thenReturn(subtotal);
    }

    /**
     * Test of getIdObject method.
     */
    @Test
    public void testGetIdObject() {

        assertEquals(idObject, instance.getIdObject());
        assertNull(instance18.getIdObject());
        assertEquals(idObject, instance19.getIdObject());
        assertEquals(new PaymentDetailIdPojo(PaymentType.AMEX_CARD), instance20.getIdObject());
        assertNull(instance21.getIdObject());
    }

    /**
     * Test of setIdObject method.
     */
    @Test
    public void testSetIdObject() {

        PaymentDetailIdPojo idObjectK = new PaymentDetailIdPojo(32921, PaymentType.VISA_CARD);
        instance.setIdObject(idObjectK);
        assertEquals(idObjectK, instance.getIdObject());
    }

    /**
     * Test of getInvoice method.
     */
    @Test
    public void testGetInvoice() {

        assertEquals(invoice, instance.getInvoice());
        assertNull(instance18.getInvoice());
        assertEquals(invoice, instance19.getInvoice());
        assertEquals(invoice, instance20.getInvoice());
        assertNull(instance21.getInvoice());
    }

    /**
     * Test of setInvoice method.
     */
    @Test
    public void testSetInvoice() {

        InvoicePojo invoiceK = Mockito.mock(InvoicePojo.class);
        instance.setInvoice(invoiceK);
        assertEquals(invoiceK, instance.getInvoice());
    }

    /**
     * Test of getSubtotal method.
     */
    @Test
    public void testGetSubtotal() {

        assertTrue(NumberUtilities.equals(new BigDecimal(23.22), instance.getSubtotal(), 2));
        assertNull(instance18.getSubtotal());
        assertTrue(NumberUtilities.equals(new BigDecimal(23.22), instance19.getSubtotal(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(23.22), instance20.getSubtotal(), 2));
        assertNull(instance21.getSubtotal());
    }

    /**
     * Test of setSubtotal method.
     */
    @Test
    public void testSetSubtotal() {

        instance.setSubtotal(new BigDecimal(60.662));
        assertTrue(NumberUtilities.equals(new BigDecimal(60.662), instance.getSubtotal(), 2));
    }

    /**
     * Test of getCurrencyCode method.
     */
    @Test
    public void testGetCurrencyCode() {

        assertEquals(CurrencyCode.USD, instance.getCurrencyCode());
        assertNull(instance18.getCurrencyCode());
        assertEquals(CurrencyCode.USD, instance19.getCurrencyCode());
        assertEquals(CurrencyCode.USD, instance20.getCurrencyCode());
        assertNull(instance21.getCurrencyCode());
    }

    /**
     * Test of setCurrencyCode method.
     */
    @Test
    public void testSetCurrencyCode() {

        instance.setCurrencyCode(CurrencyCode.DMK);
        assertEquals(CurrencyCode.DMK, instance.getCurrencyCode());
    }

    /**
     * Test of getDebitcardPayments method.
     */
    @Test
    public void testGetDebitcardPayments() {

        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo2, debitcardPaymentPojo3)), instance.getDebitcardPayments());
        instance.getDebitcardPayments().clear();
        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo2, debitcardPaymentPojo3)), instance.getDebitcardPayments());
        debitcardPayments.clear();
        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo2, debitcardPaymentPojo3)), instance.getDebitcardPayments());
        instance.getDebitcardPayments().add(debitcardPaymentPojo4);
        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo2, debitcardPaymentPojo3)), instance.getDebitcardPayments());

        assertNull(instance07.getDebitcardPayments());
        assertTrue(instance18.getDebitcardPayments().isEmpty());
        assertTrue(instance19.getDebitcardPayments().isEmpty());
        assertTrue(instance20.getDebitcardPayments().isEmpty());
        assertTrue(instance21.getDebitcardPayments().isEmpty());
    }

    /**
     * Test of setDebitcardPayments method.
     */
    @Test
    public void testSetDebitcardPayments() {

        Set<DebitcardPaymentPojo> debitcardPaymentsK = new HashSet<>(Arrays.asList(debitcardPaymentPojo1));
        instance.setDebitcardPayments(debitcardPaymentsK);
        assertEquals(debitcardPaymentsK, instance.getDebitcardPayments());
        debitcardPaymentsK.add(debitcardPaymentPojo2);
        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo1)), instance.getDebitcardPayments());

        instance.setDebitcardPayments(null);
        assertNull(instance.getDebitcardPayments());
    }

    /**
     * Test of getVisacardPayments method.
     */
    @Test
    public void testGetVisacardPayments() {

        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo2, visacardPaymentPojo3)), instance.getVisacardPayments());
        instance.getVisacardPayments().add(visacardPaymentPojo1);
        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo2, visacardPaymentPojo3)), instance.getVisacardPayments());
        visacardPayments.add(visacardPaymentPojo1);
        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo2, visacardPaymentPojo3)), instance.getVisacardPayments());

        assertNull(instance09.getVisacardPayments());
        assertTrue(instance18.getVisacardPayments().isEmpty());
        assertTrue(instance19.getVisacardPayments().isEmpty());
        assertTrue(instance20.getVisacardPayments().isEmpty());
        assertTrue(instance21.getVisacardPayments().isEmpty());
    }

    /**
     * Test of setVisacardPayments method.
     */
    @Test
    public void testSetVisacardPayments() {

        Set<VisacardPaymentPojo> visacardPaymentsK = new HashSet<>(Arrays.asList(visacardPaymentPojo2, visacardPaymentPojo3));
        instance.setVisacardPayments(visacardPaymentsK);
        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo2, visacardPaymentPojo3)), instance.getVisacardPayments());
        visacardPaymentsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo2, visacardPaymentPojo3)), instance.getVisacardPayments());

        instance.setVisacardPayments(null);
        assertNull(instance.getVisacardPayments());
    }

    /**
     * Test of getMastercardPayments method.
     */
    @Test
    public void testGetMastercardPayments() {

        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo1, mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());
        instance.getMastercardPayments().clear();
        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo1, mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());
        mastercardPayments.clear();
        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo1, mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());

        assertNull(instance11.getMastercardPayments());
        assertTrue(instance18.getMastercardPayments().isEmpty());
        assertTrue(instance19.getMastercardPayments().isEmpty());
        assertTrue(instance20.getMastercardPayments().isEmpty());
        assertTrue(instance21.getMastercardPayments().isEmpty());
    }

    /**
     * Test of setMastercardPayments method.
     */
    @Test
    public void testSetMastercardPayments() {

        Set<MastercardPaymentPojo> mastercardPaymentsK = new HashSet<>(Arrays.asList(mastercardPaymentPojo2, mastercardPaymentPojo3));
        instance.setMastercardPayments(mastercardPaymentsK);
        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());

        mastercardPaymentsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());

        instance.setMastercardPayments(null);
        assertNull(instance.getMastercardPayments());
    }

    /**
     * Test of getPaypalPayments method.
     */
    @Test
    public void testGetPaypalPayments() {

        assertEquals(new HashSet<>(Arrays.asList(paypalPaymentPojo1, paypalPaymentPojo2, paypalPaymentPojo3)), instance.getPaypalPayments());
        Set<PaypalPaymentPojo> result = instance.getPaypalPayments();
        result.clear();
        assertEquals(new HashSet<>(Arrays.asList(paypalPaymentPojo1, paypalPaymentPojo2, paypalPaymentPojo3)), instance.getPaypalPayments());
        paypalPayments.clear();
        assertEquals(new HashSet<>(Arrays.asList(paypalPaymentPojo1, paypalPaymentPojo2, paypalPaymentPojo3)), instance.getPaypalPayments());

        assertNull(instance13.getPaypalPayments());
        assertTrue(instance18.getPaypalPayments().isEmpty());
        assertTrue(instance19.getPaypalPayments().isEmpty());
        assertTrue(instance20.getPaypalPayments().isEmpty());
        assertTrue(instance21.getPaypalPayments().isEmpty());
    }

    /**
     * Test of setPaypalPayments method.
     */
    @Test
    public void testSetPaypalPayments() {

        Set<PaypalPaymentPojo> paypalPaymentsK = new HashSet<>(Arrays.asList(paypalPaymentPojo2, paypalPaymentPojo3));
        instance.setPaypalPayments(paypalPaymentsK);
        assertEquals(new HashSet<>(Arrays.asList(paypalPaymentPojo2, paypalPaymentPojo3)), instance.getPaypalPayments());
        paypalPaymentsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(paypalPaymentPojo2, paypalPaymentPojo3)), instance.getPaypalPayments());

        instance.setPaypalPayments(null);
        assertNull(instance.getPaypalPayments());
    }

    /**
     * Test of getVouchers method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetVouchers() {

        assertEquals(new HashSet<>(Arrays.asList(voucherPojo1, voucherPojo2, voucherPojo3)), instance.getVouchers());
        instance.getVouchers().clear();
        assertEquals(new HashSet<>(Arrays.asList(voucherPojo1, voucherPojo2, voucherPojo3)), instance.getVouchers());
        vouchers.clear();
        assertEquals(new HashSet<>(Arrays.asList(voucherPojo1, voucherPojo2, voucherPojo3)), instance.getVouchers());

        assertNull(instance15.getVouchers());
        assertTrue(instance18.getVouchers().isEmpty());
        assertTrue(instance19.getVouchers().isEmpty());
        assertTrue(instance20.getVouchers().isEmpty());
        assertTrue(instance21.getVouchers().isEmpty());
    }

    /**
     * Test of setVouchers method.
     */
    @Test
    public void testSetVouchers() {

        Set<VoucherPojo> vouchersK = new HashSet<>(Arrays.asList(voucherPojo1));
        instance.setVouchers(vouchersK);
        assertEquals(new HashSet<>(Arrays.asList(voucherPojo1)), instance.getVouchers());
        vouchersK.add(voucherPojo2);
        assertEquals(new HashSet<>(Arrays.asList(voucherPojo1)), instance.getVouchers());

        instance.setVouchers(null);
        assertNull(instance.getVouchers());
    }

    /**
     * Test of getAmexcardPayments method.
     */
    @Test
    public void testGetAmexcardPayments() {

        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2, amexcardPaymentPojo3)), instance.getAmexcardPayments());
        instance.getAmexcardPayments().clear();
        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2, amexcardPaymentPojo3)), instance.getAmexcardPayments());
        amexcardPayments.clear();
        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2, amexcardPaymentPojo3)), instance.getAmexcardPayments());

        assertNull(instance17.getAmexcardPayments());
        assertTrue(instance18.getAmexcardPayments().isEmpty());
        assertTrue(instance19.getAmexcardPayments().isEmpty());
        assertTrue(instance20.getAmexcardPayments().isEmpty());
        assertTrue(instance21.getAmexcardPayments().isEmpty());
    }

    /**
     * Test of setAmexcardPayments method.
     */
    @Test
    public void testSetAmexcardPayments() {

        Set<AmexcardPaymentPojo> amexcardPaymentsK = new HashSet<>(Arrays.asList(amexcardPaymentPojo2));
        instance.setAmexcardPayments(amexcardPaymentsK);
        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo2)), instance.getAmexcardPayments());
        amexcardPaymentsK.add(amexcardPaymentPojo1);
        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo2)), instance.getAmexcardPayments());

        instance.setAmexcardPayments(null);
        assertNull(instance.getAmexcardPayments());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance.hasSameConstraint(instance10));
        assertTrue(instance.hasSameConstraint(instance12));
        assertTrue(instance.hasSameConstraint(instance14));
        assertTrue(instance.hasSameConstraint(instance16));
        assertTrue(instance.hasSameConstraint(instance21));
        assertTrue(instance21.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(paymentDetail));

        assertFalse(instance.hasSameConstraint(instance02));
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
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance.hasSameParameters(instance10));
        assertTrue(instance.hasSameParameters(instance12));
        assertTrue(instance.hasSameParameters(instance14));
        assertTrue(instance.hasSameParameters(instance16));
        assertTrue(instance.hasSameParameters(instance21));
        assertTrue(instance21.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(paymentDetail));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of getPaymentType method.
     */
    @Test
    public void testGetPaymentType() {

        assertEquals(PaymentType.VISA_CARD, instance.getPaymentType());
        assertNull(instance18.getPaymentType());
        assertEquals(PaymentType.VISA_CARD, instance19.getPaymentType());
        assertEquals(PaymentType.AMEX_CARD, instance20.getPaymentType());
        assertNull(instance21.getPaymentType());
    }

    /**
     * Test of setPaymentType method.
     */
    @Test
    public void testSetPaymentType() {

        instance.setPaymentType(PaymentType.MASTER_CARD);
        assertEquals(PaymentType.MASTER_CARD, instance.getPaymentType());

        instance16.setPaymentType(PaymentType.MASTER_CARD);
        assertEquals(PaymentType.MASTER_CARD, instance16.getPaymentType());
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(321919, instance.getId());
        assertEquals(0, instance18.getId());
        assertEquals(321919, instance19.getId());
        assertEquals(0, instance20.getId());
        assertEquals(0, instance21.getId());
    }

    /**
     * Test of setId method.
     */
    @Test(expected = IllegalStateException.class)
    public void testSetId() {

        instance.setId(6671);
        assertEquals(6671, instance.getId());

        instance18.setId(6671);
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        assertEquals(instance10.hashCode(), instance.hashCode());
        assertEquals(instance12.hashCode(), instance.hashCode());
        assertEquals(instance14.hashCode(), instance.hashCode());
        assertEquals(instance16.hashCode(), instance.hashCode());
        assertEquals(instance21.hashCode(), instance.hashCode());

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
        assertTrue(instance.equals(instance06));
        assertTrue(instance.equals(instance08));
        assertTrue(instance.equals(instance10));
        assertTrue(instance.equals(instance12));
        assertTrue(instance.equals(instance14));
        assertTrue(instance.equals(instance16));
        assertTrue(instance.equals(instance21));
        assertTrue(instance21.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(paymentDetail));
        assertFalse(instance.equals(null));
    }

    @Test
    public void testToString() {
        Mockito.when(invoice.getReferenceNumber()).thenReturn("902379931202412");
        assertEquals("PaymentDetailPojo{id=321919, invoice number=902379931202412}", instance.toString());
        assertEquals("PaymentDetailPojo{id=0, invoice number=null}", instance18.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance22));
    }

    private final class HibernateProxyPaymentDetailPojoPojo extends PaymentDetailPojo implements HibernateProxy {

        private static final long serialVersionUID = 1L;

        private final PaymentDetailPojo pojo;

        public HibernateProxyPaymentDetailPojoPojo(PaymentDetailPojo addressPojo) {

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
                public PaymentDetailPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
