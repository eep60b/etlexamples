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

import com.etlsolutions.examples.data.api.VoucherPayment;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class VoucherPaymentPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class VoucherPaymentPojoTest {

    private final PaymentDetailPojo paymentDetail = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetail1 = Mockito.mock(PaymentDetailPojo.class);
    private final VoucherPojo voucher = Mockito.mock(VoucherPojo.class);
    private final VoucherPojo voucher2 = Mockito.mock(VoucherPojo.class);
    private final VoucherPayment voucherPayment = Mockito.mock(VoucherPayment.class);

    private final VoucherPaymentPojo instance = new VoucherPaymentPojo(paymentDetail, voucher);
    private final VoucherPaymentPojo instance00 = new VoucherPaymentPojo(paymentDetail, voucher);
    private final VoucherPaymentPojo instance01 = new VoucherPaymentPojo(paymentDetail1, voucher);
    private final VoucherPaymentPojo instance02 = new VoucherPaymentPojo(paymentDetail, voucher2);
    private final VoucherPaymentPojo instance03 = new VoucherPaymentPojo();
    private final VoucherPaymentPojo instance04 = new HibernateProxyVoucherPaymentPojo(new VoucherPaymentPojo(paymentDetail, voucher));
    private final VoucherPaymentPojo instance05 = new VoucherPaymentPojo(null, voucher);
    private final VoucherPaymentPojo instance06 = new VoucherPaymentPojo(null, voucher);
    private final VoucherPaymentPojo instance07 = new VoucherPaymentPojo(paymentDetail, null);
    private final VoucherPaymentPojo instance08 = new VoucherPaymentPojo(paymentDetail, null);
    private final VoucherPaymentPojo instance09 = new VoucherPaymentPojo(new PaymentDetailPojo(), new VoucherPojo());
    @Before
    public void setUp() {
        Mockito.when(voucherPayment.getVoucher()).thenReturn(voucher);
        Mockito.when(voucherPayment.getPaymentDetail()).thenReturn(paymentDetail);
        Mockito.when(voucher.getVoucherToken()).thenReturn("FFFF");
        Mockito.when(paymentDetail.getId()).thenReturn(2363);
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPaymentDetail() {

        assertEquals(paymentDetail, instance.getPaymentDetail());
        assertNull(instance03.getPaymentDetail());
        assertNull(instance04.getPaymentDetail());
    }

    /**
     * Test of getVoucher method.
     */
    @Test
    public void testGetVoucher() {
        assertEquals(voucher, instance.getVoucher());
        assertNull(instance03.getVoucher());
        assertNull(instance04.getVoucher());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        Mockito.when(voucher.hasSameConstraint(voucher)).thenReturn(Boolean.TRUE);
        Mockito.when(paymentDetail.hasSameConstraint(paymentDetail)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance04.hasSameConstraint(instance));
        assertTrue(instance05.hasSameConstraint(instance06));
        assertTrue(instance07.hasSameConstraint(instance08));
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

        Mockito.when(voucher.hasSameParameters(voucher)).thenReturn(Boolean.TRUE);
        Mockito.when(paymentDetail.hasSameParameters(paymentDetail)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance04));
        assertTrue(instance04.hasSameParameters(instance));
        assertTrue(instance05.hasSameParameters(instance06));
        assertTrue(instance07.hasSameParameters(instance08));
        assertTrue(instance.hasSameParameters(voucherPayment));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of getVoucherId method.
     */
    @Test
    public void testGetVoucherId() {

        Mockito.when(voucher.getId()).thenReturn(2811);
        assertEquals(2811, instance.getVoucherId());
        assertEquals(0, instance03.getVoucherId());
        assertEquals(0, instance04.getVoucherId());
    }

    /**
     * Test of getPaymentId method.
     */
    @Test
    public void testGetPaymentId() {

        Mockito.when(paymentDetail.getId()).thenReturn(8927);
        assertEquals(8927, instance.getPaymentId());
        assertEquals(0, instance03.getPaymentId());
        assertEquals(0, instance04.getPaymentId());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance.hashCode(), instance.hashCode());
        assertEquals(instance00.hashCode(), instance.hashCode());
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
        assertTrue(instance.equals(instance04));
        assertTrue(instance04.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(voucherPayment));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("VoucherPaymentPojo{payment id=2363, voucher=FFFF}", instance.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance09));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyVoucherPaymentPojo extends VoucherPaymentPojo implements HibernateProxy {

        private static final long serialVersionUID = 947593730197387986L;

        private final VoucherPaymentPojo pojo;

        public HibernateProxyVoucherPaymentPojo(VoucherPaymentPojo pojo) {

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
                public VoucherPaymentPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
