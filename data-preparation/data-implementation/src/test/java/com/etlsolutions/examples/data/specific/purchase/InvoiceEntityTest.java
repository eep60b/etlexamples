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
package com.etlsolutions.examples.data.specific.purchase;

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
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
 * Test of class InvoiceEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({InvoiceEntity.class, CustomerEntity.class, AddressEntity.class})
public final class InvoiceEntityTest {

    private final CustomerEntity customerEntity = PowerMockito.mock(CustomerEntity.class);
    private final CustomerEntity customerEntity1 = PowerMockito.mock(CustomerEntity.class);
    private final Customer customer = Mockito.mock(Customer.class);
    private final AddressEntity addressEntity = Mockito.mock(AddressEntity.class);
    private final AddressEntity addressEntity2 = Mockito.mock(AddressEntity.class);
    private final Address address = Mockito.mock(Address.class);
    private final InvoiceDate invoiceDate = new InvoiceDate(939891846184184L);
    private final InvoiceDate invoiceDate3 = new InvoiceDate(87461781234332L);
    private final InvoiceSubtotal invoiceSubtotal = new InvoiceSubtotal(32.88);
    private final InvoiceSubtotal invoiceSubtotal4 = new InvoiceSubtotal(11.62);
    private final InvoiceReferenceNumber referenceNumber = new InvoiceReferenceNumber("84099y94189");
    private final InvoiceReferenceNumber referenceNumber5 = new InvoiceReferenceNumber("712431456-9");
    private final InvoiceValidity invoiceValidity = InvoiceValidity.YES;
    private final InvoiceValidity invoiceValidity6 = InvoiceValidity.YES;
    
    private final Invoice invoice = Mockito.mock(Invoice.class);

    private final InvoiceEntity instance   = new InvoiceEntity(customerEntity, addressEntity, invoiceDate, invoiceSubtotal, referenceNumber, invoiceValidity);
    private final InvoiceEntity instance00 = new InvoiceEntity(customerEntity, addressEntity, invoiceDate, invoiceSubtotal, referenceNumber, invoiceValidity);
    private final InvoiceEntity instance01 = new InvoiceEntity(customerEntity1, addressEntity, invoiceDate, invoiceSubtotal, referenceNumber, invoiceValidity);
    private final InvoiceEntity instance02 = new InvoiceEntity(customerEntity, addressEntity2, invoiceDate, invoiceSubtotal, referenceNumber, invoiceValidity);
    private final InvoiceEntity instance03 = new InvoiceEntity(customerEntity, addressEntity, invoiceDate3, invoiceSubtotal, referenceNumber, invoiceValidity);
    private final InvoiceEntity instance04 = new InvoiceEntity(customerEntity, addressEntity, invoiceDate, invoiceSubtotal4, referenceNumber, invoiceValidity);
    private final InvoiceEntity instance05 = new InvoiceEntity(customerEntity, addressEntity, invoiceDate, invoiceSubtotal, referenceNumber5, invoiceValidity);
    private final InvoiceEntity instance06 = new InvoiceEntity(customerEntity, addressEntity, invoiceDate, invoiceSubtotal, referenceNumber, invoiceValidity6);
    private InvoiceEntity instance07;
    private InvoiceEntity instance08;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(CustomerEntity.class).withArguments(customer).thenReturn(customerEntity);
        PowerMockito.whenNew(AddressEntity.class).withArguments(address).thenReturn(addressEntity);

        Mockito.when(invoice.getCustomer()).thenReturn(customerEntity);
        Mockito.when(invoice.getDeliveryAddress()).thenReturn(addressEntity);
        Mockito.when(invoice.getInvoiceDate()).thenReturn(new Date(939891846184184L));
        Mockito.when(invoice.getReferenceNumber()).thenReturn("aadaoinka;dl");
        Mockito.when(invoice.getTotal()).thenReturn(new BigDecimal(32.88));
        Mockito.when(invoice.getValidity()).thenReturn(InvoiceValidity.YES);

        instance07 = new InvoiceEntity(customer, address, invoiceDate, this.invoiceSubtotal, referenceNumber, InvoiceValidity.YES);
        instance08 = new InvoiceEntity(invoice);
    }

    /**
     * Test of getCustomer method.
     */
    @Test
    public void testGetCustomer() {
        assertEquals(customerEntity1, instance.getCustomer());
        assertEquals(customerEntity1, instance07.getCustomer());
        assertEquals(customerEntity1, instance08.getCustomer());
    }

    /**
     * Test of getInvoiceDate method.
     */
    @Test
    public void testGetInvoiceDate() {

        assertEquals(invoiceDate.getValue(), instance.getInvoiceDate());
        assertEquals(invoiceDate.getValue(), instance07.getInvoiceDate());
        assertEquals(invoiceDate.getValue(), instance08.getInvoiceDate());
    }

    /**
     * Test of getTotal method.
     */
    @Test
    public void testGetTotal() {

        assertTrue(NumberUtilities.equals(new BigDecimal(32.88), instance.getTotal()));
        assertTrue(NumberUtilities.equals(new BigDecimal(32.88), instance07.getTotal()));
        assertTrue(NumberUtilities.equals(new BigDecimal(32.88), instance08.getTotal()));
    }

    /**
     * Test of getDeliveryAddress method.
     */
    @Test
    public void testGetDeliveryAddress() {

        assertEquals(addressEntity, instance.getDeliveryAddress());
        assertEquals(addressEntity, instance07.getDeliveryAddress());
        assertEquals(addressEntity, instance08.getDeliveryAddress());
    }

    /**
     * Test of getReferenceNumber method.
     */
    @Test
    public void testGetReferenceNumber() {

        assertEquals("84099y94189", instance.getReferenceNumber());
        assertEquals("84099y94189", instance07.getReferenceNumber());
        assertEquals("84099y94189", instance08.getReferenceNumber());
    }

    /**
     * Test of class InvoiceEntity.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance.hasSameConstraint(invoice));

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
        assertTrue(instance.hasSameParameters(instance07));
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance.hasSameParameters(invoice));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of getValidity method.
     */
    @Test
    public void testGetValidity() {

        assertEquals(InvoiceValidity.YES, instance.getValidity());
        assertEquals(InvoiceValidity.YES, instance07.getValidity());
        assertEquals(InvoiceValidity.YES, instance08.getValidity());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance07.hashCode(), instance.hashCode());
        assertEquals(instance02.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
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

        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(invoice));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("InvoiceEntity{reference number=aadaoinka;dl}", instance.toString());
    }
}
