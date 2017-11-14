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

import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.utility.NumberUtilities;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class VoucherPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class VoucherPojoTest {

    private final int id = 5499;
    private final int id1 = 77543;
    private final CustomerPojo customer = Mockito.mock(CustomerPojo.class);
    private final CustomerPojo customer2 = Mockito.mock(CustomerPojo.class);
    private final String voucherToken = "diain adkad alda2";
    private final String voucherToken3 = "5l432l54j 3425k3";
    private final BigDecimal total = new BigDecimal(58.85);
    private final BigDecimal total4 = new BigDecimal(93.5);

    private final PaymentDetailPojo paymentDetailIdPojo1 = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetailIdPojo2 = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetailIdPojo3 = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetailIdPojo4 = Mockito.mock(PaymentDetailPojo.class);
    private final Set<PaymentDetailPojo> paymentDetails = new HashSet<>(Arrays.asList(paymentDetailIdPojo1, paymentDetailIdPojo2, paymentDetailIdPojo3));
    private final Set<PaymentDetailPojo> paymentDetails6 = new HashSet<>(Arrays.asList(paymentDetailIdPojo3, paymentDetailIdPojo4, paymentDetailIdPojo2));
    private final Set<PaymentDetailPojo> paymentDetails7 = null;

    private final Date expireDate = new Date(9120348190419L);
    private final Date expireDate5 = new Date(1493119341983412L);
    private final Voucher voucher = Mockito.mock(Voucher.class);

    private final VoucherPojo instance = new VoucherPojo(id, customer, voucherToken, total, expireDate, paymentDetails);
    private final VoucherPojo instance00 = new VoucherPojo(id, customer, voucherToken, total, expireDate, paymentDetails);
    private final VoucherPojo instance01 = new VoucherPojo(id1, customer, voucherToken, total, expireDate, paymentDetails);
    private final VoucherPojo instance02 = new VoucherPojo(id, customer2, voucherToken, total, expireDate, paymentDetails);
    private final VoucherPojo instance03 = new VoucherPojo(id, customer, voucherToken3, total, expireDate, paymentDetails);
    private final VoucherPojo instance04 = new VoucherPojo(id, customer, voucherToken, total4, expireDate, paymentDetails);
    private final VoucherPojo instance05 = new VoucherPojo(id, customer, voucherToken, total, expireDate5, paymentDetails);
    private final VoucherPojo instance06 = new VoucherPojo(id, customer, voucherToken, total, expireDate, paymentDetails6);
    private final VoucherPojo instance07 = new VoucherPojo(id, customer, voucherToken, total, expireDate, paymentDetails7);
    private final VoucherPojo instance08 = new VoucherPojo();
    private final VoucherPojo instance09 = new VoucherPojo(customer, voucherToken, total, expireDate);
    private final VoucherPojo instance10 = new VoucherPojo(id, voucherToken, total, expireDate);
    private final VoucherPojo instance11 = new VoucherPojo(id, customer, voucherToken, total, expireDate);
    private final VoucherPojo instance12 = new VoucherPojo(customer, voucherToken, total, expireDate, paymentDetails);
    private final VoucherPojo instance13 = new HibernateProxyVoucherPojo(new VoucherPojo(id, customer, voucherToken, total, expireDate, paymentDetails));
    private final VoucherPojo instance14 = new VoucherPojo(id, new CustomerPojo(), voucherToken, total, expireDate);

    @Before
    public void setUp() {

        Mockito.when(voucher.getCustomer()).thenReturn(customer);
        Mockito.when(voucher.getExpireDate()).thenReturn(expireDate);
        Mockito.when(voucher.getTotal()).thenReturn(total);
        Mockito.when(voucher.getVoucherToken()).thenReturn(voucherToken);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(5499, instance.getId());
        assertEquals(0, instance08.getId());
        assertEquals(0, instance09.getId());
        assertEquals(5499, instance10.getId());
        assertEquals(5499, instance11.getId());
        assertEquals(0, instance12.getId());
        assertEquals(0, instance13.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(2693);
        assertEquals(2693, instance.getId());
    }

    /**
     * Test of getCustomer method.
     */
    @Test
    public void testGetCustomer() {

        assertEquals(customer, instance.getCustomer());
        assertNull(instance08.getCustomer());
        assertEquals(customer, instance09.getCustomer());
        assertNull(instance10.getCustomer());
        assertEquals(customer, instance11.getCustomer());
        assertEquals(customer, instance12.getCustomer());
        assertNull(instance13.getCustomer());

    }

    /**
     * Test of setCustomer method.
     */
    @Test
    public void testSetCustomer() {

        CustomerPojo customerK = Mockito.mock(CustomerPojo.class);
        instance.setCustomer(customerK);
        assertEquals(customerK, instance.getCustomer());
    }

    /**
     * Test of getVoucherToken method.
     */
    @Test
    public void testGetVoucherToken() {

        assertEquals("diain adkad alda2", instance.getVoucherToken());
        assertNull(instance08.getVoucherToken());
        assertEquals("diain adkad alda2", instance09.getVoucherToken());
        assertEquals("diain adkad alda2", instance10.getVoucherToken());
        assertEquals("diain adkad alda2", instance11.getVoucherToken());
        assertEquals("diain adkad alda2", instance12.getVoucherToken());
        assertNull(instance13.getVoucherToken());
    }

    /**
     * Test of setVoucherToken method.
     */
    @Test
    public void testSetVoucherToken() {

        instance.setVoucherToken("3903ldfjadlsfadkll alfdak");
        assertEquals("3903ldfjadlsfadkll alfdak", instance.getVoucherToken());
    }

    /**
     * Test of getTotal method.
     */
    @Test
    public void testGetTotal() {

        assertTrue(NumberUtilities.equals(new BigDecimal(58.85), instance.getTotal(), 2));
        assertNull(instance08.getTotal());
        assertTrue(NumberUtilities.equals(new BigDecimal(58.85), instance09.getTotal(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(58.85), instance10.getTotal(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(58.85), instance11.getTotal(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(58.85), instance12.getTotal(), 2));
        assertNull(instance13.getTotal());
    }

    /**
     * Test of setTotal method.
     */
    @Test
    public void testSetTotal() {

        instance.setTotal(new BigDecimal(333.3));
        assertTrue(NumberUtilities.equals(new BigDecimal(333.3), instance.getTotal(), 2));
    }

    /**
     * Test of getPaymentDetails method.
     */
    @Test
    public void testGetPaymentDetails() {

        assertEquals(new HashSet<>(Arrays.asList(paymentDetailIdPojo1, paymentDetailIdPojo2, paymentDetailIdPojo3)), instance.getPaymentDetails());
        instance.getPaymentDetails().add(paymentDetailIdPojo4);
        assertEquals(new HashSet<>(Arrays.asList(paymentDetailIdPojo1, paymentDetailIdPojo2, paymentDetailIdPojo3)), instance.getPaymentDetails());
        paymentDetails.add(paymentDetailIdPojo4);
        assertEquals(new HashSet<>(Arrays.asList(paymentDetailIdPojo1, paymentDetailIdPojo2, paymentDetailIdPojo3)), instance.getPaymentDetails());

        assertNull(instance07.getPaymentDetails());
        assertTrue(instance08.getPaymentDetails().isEmpty());
        assertTrue(instance09.getPaymentDetails().isEmpty());
        assertTrue(instance10.getPaymentDetails().isEmpty());
        assertTrue(instance11.getPaymentDetails().isEmpty());
        assertEquals(new HashSet<>(Arrays.asList(paymentDetailIdPojo1, paymentDetailIdPojo2, paymentDetailIdPojo3)), instance12.getPaymentDetails());
        assertTrue(instance13.getPaymentDetails().isEmpty());
    }

    /**
     * Test of setPaymentDetails method.
     */
    @Test
    public void testSetPaymentDetails() {

        Set<PaymentDetailPojo> paymentDetailsK = new HashSet<>(Arrays.asList(paymentDetailIdPojo2));
        instance.setPaymentDetails(paymentDetailsK);
        assertEquals(new HashSet<>(Arrays.asList(paymentDetailIdPojo2)), instance.getPaymentDetails());
        paymentDetailsK.add(paymentDetailIdPojo1);
        assertEquals(new HashSet<>(Arrays.asList(paymentDetailIdPojo2)), instance.getPaymentDetails());

        instance.setPaymentDetails(null);
        assertNull(instance.getPaymentDetails());
    }

    /**
     * Test of getExpireDate method.
     */
    @Test
    public void testGetExpireDate() {

        assertEquals(new Date(9120348190419L), instance.getExpireDate());
        instance.getExpireDate().setTime(1L);
        assertEquals(new Date(9120348190419L), instance.getExpireDate());
        expireDate.setTime(1L);
        assertEquals(new Date(9120348190419L), instance.getExpireDate());

        assertNull(instance08.getExpireDate());
        assertEquals(new Date(9120348190419L), instance09.getExpireDate());
        assertEquals(new Date(9120348190419L), instance10.getExpireDate());
        assertEquals(new Date(9120348190419L), instance11.getExpireDate());
        assertEquals(new Date(9120348190419L), instance12.getExpireDate());
        assertNull(instance13.getExpireDate());
    }

    /**
     * Test of setExpireDate method.
     */
    @Test
    public void testSetExpireDate() {

        Date expireDateA = new Date(329182937199389L);
        instance.setExpireDate(expireDateA);
        assertEquals(new Date(329182937199389L), instance.getExpireDate());
        expireDateA.setTime(0);
        assertEquals(new Date(329182937199389L), instance.getExpireDate());
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
        assertTrue(instance.hasSameConstraint(instance13));
        assertTrue(instance13.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(voucher));

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
        assertTrue(instance.hasSameParameters(instance13));
        assertTrue(instance13.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(voucher));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        assertEquals(instance13.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
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
        assertTrue(instance.equals(instance13));
        assertTrue(instance13.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(voucher));
        assertFalse(instance.equals(null));

    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance14));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyVoucherPojo extends VoucherPojo implements HibernateProxy {

        private static final long serialVersionUID = 282561550633884851L;

        private final VoucherPojo pojo;

        public HibernateProxyVoucherPojo(VoucherPojo pojo) {

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
                public VoucherPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
