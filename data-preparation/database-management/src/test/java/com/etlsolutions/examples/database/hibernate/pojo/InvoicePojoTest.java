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

import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.utility.NumberUtilities;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;

/**
 * Test of getId method, of class InvoicePojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class InvoicePojoTest {

    private final int id = 3772;
    private final int id1 = 3659;
    private final CustomerPojo customer = new CustomerPojo(21, Mockito.mock(PersonAddressLinkPojo.class), "usernn", "pass");
    private final CustomerPojo customer2 = new CustomerPojo();
    private final AddressPojo address = new AddressPojo(334, "9ad", "mak addx", "Sp");
    private final AddressPojo address3 = new AddressPojo();
    private final Date invoiceDate = new Date(93421826812L);
    private final Date invoiceDate4 = new Date(84339271282L);
    private final BigDecimal total = new BigDecimal(83.66);
    private final BigDecimal total5 = new BigDecimal(66.66);
    private final InvoiceValidity invoiceValidity = InvoiceValidity.YES;
    private final InvoiceValidity invoiceValidity6 = InvoiceValidity.NO;
    private final String referenceNumber = "ainakd1288121";
    private final String referenceNumber7 = "0-1983401909312";

    private final SoldItemPojo soldItemPojo1 = Mockito.mock(SoldItemPojo.class);
    private final SoldItemPojo soldItemPojo2 = Mockito.mock(SoldItemPojo.class);
    private final SoldItemPojo soldItemPojo3 = Mockito.mock(SoldItemPojo.class);
    private final SoldItemPojo soldItemPojo4 = Mockito.mock(SoldItemPojo.class);
    private final Set<SoldItem> soldItems = new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo2, soldItemPojo3));
    private final Set<SoldItem> soldItems8 = new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo4));
    private final Set<SoldItem> soldItems9 = null;

    private final PaymentDetailPojo paymentDetailPojo1 = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetailPojo2 = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetailPojo3 = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetailPojo4 = Mockito.mock(PaymentDetailPojo.class);
    private final Set<PaymentDetail> paymentDetails = new HashSet<>(Arrays.asList(paymentDetailPojo1, paymentDetailPojo2, paymentDetailPojo3));
    private final Set<PaymentDetail> paymentDetails10 = new HashSet<>(Arrays.asList(paymentDetailPojo3, paymentDetailPojo4));
    private final Set<PaymentDetail> paymentDetails11 = null;

    private final Invoice invoice = Mockito.mock(Invoice.class);

    private final InvoicePojo instance = new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity, referenceNumber, soldItems, paymentDetails);
    private final InvoicePojo instance00 = new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity, referenceNumber, soldItems, paymentDetails);
    private final InvoicePojo instance01 = new InvoicePojo(id1, customer, address, invoiceDate, total, invoiceValidity, referenceNumber, soldItems, paymentDetails);
    private final InvoicePojo instance02 = new InvoicePojo(id, customer2, address, invoiceDate, total, invoiceValidity, referenceNumber, soldItems, paymentDetails);
    private final InvoicePojo instance03 = new InvoicePojo(id, customer, address3, invoiceDate, total, invoiceValidity, referenceNumber, soldItems, paymentDetails);
    private final InvoicePojo instance04 = new InvoicePojo(id, customer, address, invoiceDate4, total, invoiceValidity, referenceNumber, soldItems, paymentDetails);
    private final InvoicePojo instance05 = new InvoicePojo(id, customer, address, invoiceDate, total5, invoiceValidity, referenceNumber, soldItems, paymentDetails);
    private final InvoicePojo instance06 = new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity6, referenceNumber, soldItems, paymentDetails);
    private final InvoicePojo instance07 = new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity, referenceNumber7, soldItems, paymentDetails);
    private final InvoicePojo instance08 = new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity, referenceNumber, soldItems8, paymentDetails);
    private final InvoicePojo instance09 = new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity, referenceNumber, soldItems9, paymentDetails);
    private final InvoicePojo instance10 = new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity, referenceNumber, soldItems, paymentDetails10);
    private final InvoicePojo instance11 = new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity, referenceNumber, soldItems, paymentDetails11);
    private final InvoicePojo instance12 = new InvoicePojo();
    private final InvoicePojo instance13 = new InvoicePojo(customer, address, invoiceDate, total, invoiceValidity, referenceNumber);
    private final InvoicePojo instance14 = new InvoicePojo(id, customer, invoiceDate, total, invoiceValidity, referenceNumber);
    private final InvoicePojo instance15 = new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity, referenceNumber);
    private final InvoicePojo instance16 = new HibernateProxyInvoicePojo(new InvoicePojo(id, customer, address, invoiceDate, total, invoiceValidity, referenceNumber, soldItems, paymentDetails));
    private final InvoicePojo instance17 = new InvoicePojo(id, new CustomerPojo(), new AddressPojo(), invoiceDate, total, invoiceValidity, referenceNumber, soldItems, paymentDetails);

    @Before
    public void setUp() {

        Mockito.when(invoice.getCustomer()).thenReturn(customer);
        Mockito.when(invoice.getDeliveryAddress()).thenReturn(address);
        Mockito.when(invoice.getInvoiceDate()).thenReturn(invoiceDate);
        Mockito.when(invoice.getReferenceNumber()).thenReturn(referenceNumber);
        Mockito.when(invoice.getTotal()).thenReturn(total);
        Mockito.when(invoice.getValidity()).thenReturn(invoiceValidity);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(3772, instance.getId());
        assertEquals(0, instance12.getId());
        assertEquals(0, instance13.getId());
        assertEquals(3772, instance14.getId());
        assertEquals(3772, instance15.getId());
        assertEquals(0, instance16.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(6653);
        assertEquals(6653, instance.getId());
    }

    /**
     * Test of getCustomer method.
     */
    @Test
    public void testGetCustomer() {

        assertEquals(customer, instance.getCustomer());
        assertNull(instance12.getCustomer());
        assertEquals(customer, instance13.getCustomer());
        assertEquals(customer, instance14.getCustomer());
        assertEquals(customer, instance15.getCustomer());
        assertNull(instance16.getCustomer());
    }

    /**
     * Test of setCustomer method.
     */
    @Test
    public void testSetCustomer() {

        instance.setCustomer(customer2);
        assertEquals(customer2, instance.getCustomer());
    }

    /**
     * Test of getDeliveryAddress method.
     */
    @Test
    public void testGetDeliveryAddress() {

        assertEquals(address, instance.getDeliveryAddress());
        assertNull(instance12.getDeliveryAddress());
        assertEquals(address, instance13.getDeliveryAddress());
        assertNull(instance14.getDeliveryAddress());
        assertEquals(address, instance15.getDeliveryAddress());
        assertNull(instance16.getDeliveryAddress());
    }

    /**
     * Test of setDeliveryAddress method.
     */
    @Test
    public void testSetDeliveryAddress() {

        AddressPojo addressK = Mockito.mock(AddressPojo.class);
        instance.setDeliveryAddress(addressK);
        assertEquals(addressK, instance.getDeliveryAddress());
    }

    /**
     * Test of getInvoiceDate method.
     */
    @Test
    public void testGetInvoiceDate() {

        assertEquals(new Date(93421826812L), instance.getInvoiceDate());
        assertNull(instance12.getInvoiceDate());
        assertEquals(new Date(93421826812L), instance13.getInvoiceDate());
        assertEquals(new Date(93421826812L), instance14.getInvoiceDate());
        assertEquals(new Date(93421826812L), instance15.getInvoiceDate());
        assertNull(instance16.getInvoiceDate());
    }

    /**
     * Test of setInvoiceDate method.
     */
    @Test
    public void testSetInvoiceDate() {

        instance.setInvoiceDate(new Date(22322191L));
        assertEquals(new Date(22322191L), instance.getInvoiceDate());
    }

    /**
     * Test of getTotal method.
     */
    @Test
    public void testGetTotal() {

        assertTrue(NumberUtilities.equals(new BigDecimal(83.66), instance.getTotal(), 2));
        assertNull(instance12.getTotal());
        assertTrue(NumberUtilities.equals(new BigDecimal(83.66), instance13.getTotal(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(83.66), instance14.getTotal(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(83.66), instance15.getTotal(), 2));
        assertNull(instance16.getTotal());
    }

    /**
     * Test of setTotal method.
     */
    @Test
    public void testSetTotal() {

        instance.setTotal(new BigDecimal(17.72));
        assertTrue(NumberUtilities.equals(new BigDecimal(17.72), instance.getTotal(), 2));
    }

    /**
     * Test of getValidity method.
     */
    @Test
    public void testGetValidity() {

        assertEquals(InvoiceValidity.YES, instance.getValidity());
        assertNull(instance12.getValidity());
        assertEquals(InvoiceValidity.YES, instance13.getValidity());
        assertEquals(InvoiceValidity.YES, instance14.getValidity());
        assertEquals(InvoiceValidity.YES, instance15.getValidity());
        assertNull(instance16.getValidity());
    }

    /**
     * Test of setValidity method.
     */
    @Test
    public void testSetValidity() {

        instance.setValidity(InvoiceValidity.NO);
        assertEquals(InvoiceValidity.NO, instance.getValidity());
    }

    /**
     * Test of getReferenceNumber method.
     */
    @Test
    public void testGetReferenceNumber() {

        assertEquals("ainakd1288121", instance.getReferenceNumber());
        assertNull(instance12.getReferenceNumber());
        assertEquals("ainakd1288121", instance13.getReferenceNumber());
        assertEquals("ainakd1288121", instance14.getReferenceNumber());
        assertEquals("ainakd1288121", instance15.getReferenceNumber());
        assertNull(instance16.getReferenceNumber());
    }

    /**
     * Test of setReferenceNumber method.
     */
    @Test
    public void testSetReferenceNumber() {

        instance.setReferenceNumber("dkanad12231");
        assertEquals("dkanad12231", instance.getReferenceNumber());
    }

    /**
     * Test of getSoldItems method.
     */
    @Test
    public void testGetSoldItems() {

        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo2, soldItemPojo3)), instance.getSoldItems());
        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo2, soldItemPojo3)), instance.getSoldItems());
        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo2, soldItemPojo3)), instance.getSoldItems());

        assertNull(instance09.getSoldItems());
        assertTrue(instance12.getSoldItems().isEmpty());
        assertTrue(instance13.getSoldItems().isEmpty());
        assertTrue(instance14.getSoldItems().isEmpty());
        assertTrue(instance15.getSoldItems().isEmpty());
        assertTrue(instance16.getSoldItems().isEmpty());

    }

    /**
     * Test of setSoldItems method.
     */
    @Test
    public void testSetSoldItems() {

        Set<SoldItem> soldItemsP = new HashSet<>(Arrays.asList(soldItemPojo4));
        instance.setSoldItems(soldItemsP);
        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo4)), instance.getSoldItems());
        soldItemsP.add(soldItemPojo1);
        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo4)), instance.getSoldItems());

        instance.setSoldItems(null);
        assertNull(instance.getSoldItems());
    }

    /**
     * Test of getPaymentDetails method.
     */
    @Test
    public void testGetPaymentDetails() {

        assertEquals(new HashSet<>(Arrays.asList(paymentDetailPojo1, paymentDetailPojo2, paymentDetailPojo3)), instance.getPaymentDetails());
        instance.getPaymentDetails().clear();
        assertEquals(new HashSet<>(Arrays.asList(paymentDetailPojo1, paymentDetailPojo2, paymentDetailPojo3)), instance.getPaymentDetails());
        paymentDetails.clear();
        assertEquals(new HashSet<>(Arrays.asList(paymentDetailPojo1, paymentDetailPojo2, paymentDetailPojo3)), instance.getPaymentDetails());

        assertNull(instance11.getPaymentDetails());
        assertTrue(instance12.getPaymentDetails().isEmpty());
        assertTrue(instance13.getPaymentDetails().isEmpty());
        assertTrue(instance14.getPaymentDetails().isEmpty());
        assertTrue(instance15.getPaymentDetails().isEmpty());

    }

    /**
     * Test of setPaymentDetails method.
     */
    @Test
    public void testSetPaymentDetails() {

        Set<PaymentDetail> paymentDetailsS = new HashSet<>(Arrays.asList(paymentDetailPojo1, paymentDetailPojo4));
        instance.setPaymentDetails(paymentDetailsS);
        assertEquals(new HashSet<>(Arrays.asList(paymentDetailPojo1, paymentDetailPojo4)), instance.getPaymentDetails());
        paymentDetailsS.clear();
        assertEquals(new HashSet<>(Arrays.asList(paymentDetailPojo1, paymentDetailPojo4)), instance.getPaymentDetails());
        instance.setPaymentDetails(null);
        assertNull(instance.getPaymentDetails());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        assertEquals(instance10.hashCode(), instance.hashCode());
        assertEquals(instance15.hashCode(), instance.hashCode());
        assertEquals(instance16.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance07.hashCode(), instance.hashCode());
        assertNotEquals(instance12.hashCode(), instance.hashCode()); 
        assertNotEquals(instance13.hashCode(), instance.hashCode());  
        assertNotEquals(instance14.hashCode(), instance.hashCode());        
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
        assertTrue(instance.equals(instance10));
        assertTrue(instance.equals(instance16));
        assertTrue(instance16.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(invoice));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance.hasSameParameters(instance10));
        assertTrue(instance.hasSameParameters(instance16));
        assertTrue(instance16.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(invoice));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(instance07));
        assertFalse(instance.hasSameParameters(null));
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
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance16));
        assertTrue(instance16.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(invoice));

        assertFalse(instance.hasSameConstraint(instance07));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        assertEquals("InvoicePojo{referenceNumber=ainakd1288121}", instance.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance17));
    }

    private final class HibernateProxyInvoicePojo extends InvoicePojo implements HibernateProxy {

        private static final long serialVersionUID = 406504312267646546L;

        private final InvoicePojo pojo;

        public HibernateProxyInvoicePojo(InvoicePojo pojo) {
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
                public InvoicePojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
