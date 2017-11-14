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

import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.data.specific.person.CustomerEntity;
import com.etlsolutions.examples.utility.NumberUtilities;
import java.math.BigDecimal;
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
@PrepareForTest({VoucherEntity.class, CustomerEntity.class})
public final class VoucherEntityTest {

    private final CustomerEntity customerEntity = PowerMockito.mock(CustomerEntity.class);
    private final CustomerEntity customerEntity1 = PowerMockito.mock(CustomerEntity.class);
    private final Customer customer = Mockito.mock(Customer.class);
    private final VoucherTotal voucherTotal = new VoucherTotal(231.11);
    private final VoucherTotal voucherTotal2 = new VoucherTotal(86.99);
    private final String voucherTokenString = "8913491-uoqwrej-422";
    private final String voucherTokenString3 = "oafoasfu-afda-adjjd-afa";
    private final VoucherToken voucherToken = new VoucherToken(voucherTokenString);
    private final Date date = new Date(519341947146184983L);
    private final Date date4 = new Date(91348713471484983L);
    private final ExpireDate expireDate = new ExpireDate(519341947146184983L);
    private final Voucher voucher = Mockito.mock(Voucher.class);

    private final VoucherEntity instance = new VoucherEntity(customerEntity, voucherTotal, voucherTokenString, date);
    private final VoucherEntity instance00 = new VoucherEntity(customerEntity, voucherTotal, voucherTokenString, date);
    private final VoucherEntity instance01 = new VoucherEntity(customerEntity1, voucherTotal, voucherTokenString, date);
    private final VoucherEntity instance02 = new VoucherEntity(customerEntity, voucherTotal2, voucherTokenString, date);
    private final VoucherEntity instance03 = new VoucherEntity(customerEntity, voucherTotal, voucherTokenString3, date);
    private final VoucherEntity instance04 = new VoucherEntity(customerEntity, voucherTotal, voucherTokenString, date4);
    private VoucherEntity instance05;
    private VoucherEntity instance06;

    @Before
    public void setUp() throws Exception {

        Mockito.when(voucher.getCustomer()).thenReturn(customerEntity);
        Mockito.when(voucher.getExpireDate()).thenReturn(date);
        Mockito.when(voucher.getTotal()).thenReturn(new BigDecimal(231.11));
        Mockito.when(voucher.getVoucherToken()).thenReturn(voucherTokenString);

        PowerMockito.whenNew(CustomerEntity.class).withArguments(customer).thenReturn(customerEntity);

        instance05 = new VoucherEntity(customer, voucherTotal, voucherToken, expireDate);
        instance06 = new VoucherEntity(voucher);
    }

    /**
     * Test of getCustomer method.
     */
    @Test
    public void testGetCustomer() {

        assertEquals(customerEntity, instance.getCustomer());
        assertEquals(customerEntity, instance05.getCustomer());
        assertEquals(customerEntity, instance06.getCustomer());
    }

    /**
     * Test of getTotal method.
     */
    @Test
    public void testGetTotal() {

        assertTrue(NumberUtilities.equals(new BigDecimal(231.11), instance.getTotal()));
        assertTrue(NumberUtilities.equals(new BigDecimal(231.11), instance05.getTotal()));
        assertTrue(NumberUtilities.equals(new BigDecimal(231.11), instance06.getTotal()));
    }

    /**
     * Test of getVoucherToken method.
     */
    @Test
    public void testGetVoucherToken() {

        assertEquals("8913491-uoqwrej-422", instance.getVoucherToken());
        assertEquals("8913491-uoqwrej-422", instance05.getVoucherToken());
        assertEquals("8913491-uoqwrej-422", instance06.getVoucherToken());
    }

    /**
     * Test of getExpireDate method.
     */
    @Test
    public void testGetExpireDate() {

        assertEquals(new Date(519341947146184983L), instance.getExpireDate());
        assertEquals(new Date(519341947146184983L), instance05.getExpireDate());
        assertEquals(new Date(519341947146184983L), instance06.getExpireDate());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance02.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
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
        assertTrue(instance.equals(instance05));
        assertTrue(instance.equals(instance06));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(voucher));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("", instance.toString());
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
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(voucher));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));
    }

}
