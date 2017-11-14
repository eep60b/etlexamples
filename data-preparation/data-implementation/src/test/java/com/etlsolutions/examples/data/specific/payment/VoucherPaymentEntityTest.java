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

import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.data.api.VoucherPayment;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
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
@PrepareForTest({VoucherPaymentEntity.class, PaymentDetailEntity.class, VoucherEntity.class})
public final class VoucherPaymentEntityTest {

    private final PaymentDetailEntity paymentDetailEntity = PowerMockito.mock(PaymentDetailEntity.class);
    private final PaymentDetailEntity paymentDetailEntity1 = PowerMockito.mock(PaymentDetailEntity.class);
    private final PaymentDetail paymentDetail = Mockito.mock(PaymentDetail.class);
    private final VoucherEntity voucherEntity = PowerMockito.mock(VoucherEntity.class);
    private final VoucherEntity voucherEntity2 = PowerMockito.mock(VoucherEntity.class);
    private final Voucher voucher = Mockito.mock(Voucher.class);
    private final VoucherPayment voucherPayment = Mockito.mock(VoucherPayment.class);

    private final VoucherPaymentEntity instance = new VoucherPaymentEntity(paymentDetailEntity, voucherEntity);
    private final VoucherPaymentEntity instance00 = new VoucherPaymentEntity(paymentDetailEntity, voucherEntity);
    private final VoucherPaymentEntity instance01 = new VoucherPaymentEntity(paymentDetailEntity1, voucherEntity);
    private final VoucherPaymentEntity instance02 = new VoucherPaymentEntity(paymentDetailEntity, voucherEntity2);
    private VoucherPaymentEntity instance03;
    private VoucherPaymentEntity instance04;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(PaymentDetailEntity.class).withArguments(paymentDetail).thenReturn(paymentDetailEntity);
        PowerMockito.whenNew(VoucherEntity.class).withArguments(voucher).thenReturn(voucherEntity);

        Mockito.when(voucherPayment.getPaymentDetail()).thenReturn(paymentDetailEntity);
        Mockito.when(voucherPayment.getVoucher()).thenReturn(voucher);

        instance03 = new VoucherPaymentEntity(paymentDetail, voucher);
        instance04 = new VoucherPaymentEntity(voucherPayment);
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPaymentDetail() {

        assertEquals(paymentDetailEntity, instance.getPaymentDetail());
        assertEquals(paymentDetailEntity, instance03.getPaymentDetail());
        assertEquals(paymentDetailEntity, instance04.getPaymentDetail());
    }

    /**
     * Test of getVoucher method.
     */
    @Test
    public void testGetVoucher() {

        assertEquals(voucher, instance.getVoucher());
        assertEquals(voucher, instance03.getVoucher());
        assertEquals(voucher, instance04.getVoucher());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance03));
        assertTrue(instance.equals(instance04));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(voucherPayment));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(voucherPayment));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance03));
        assertTrue(instance.hasSameParameters(instance04));
        assertTrue(instance.hasSameParameters(voucherPayment));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(null));
    }

}
