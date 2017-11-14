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

import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.utility.NumberUtilities;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of getId method, of class SoldItemPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class SoldItemPojoTest {

    private final int id = 1199;
    private final int id1 = 2362;
    private final ItemCommonDetailPojo itemCommonDetail = new ItemCommonDetailPojo(6773, "i namm", new BigDecimal(22.33), new BigDecimal(44.76), CurrencyCode.USD, AvailabilityType.YES, "ladfnladkflafk");
    private final ItemCommonDetailPojo itemCommonDetail2 = Mockito.mock(ItemCommonDetailPojo.class);
    private final InvoicePojo invoice = new InvoicePojo(88754, new CustomerPojo(id, new PersonAddressLinkPojo(id, new AddressPojo(id, "afds3", "13kkadfl", "d88ad", "iink1", "88a13k", "kkhak3l", "dalnk221"), new PersonalDetailPojo(id, "Mrr..", "ggveeNN", "kkk134l214", new Date(1289793129934L), new byte[]{76, 45, 33}), AddressType.CONTACT), "uuunnnak", "lla; a;a; f"), new Date(19327129034821947L), new BigDecimal(849.66), InvoiceValidity.YES, "830io134uio1u34o1341");
    private final InvoicePojo invoice3 = Mockito.mock(InvoicePojo.class);
    private final int quantity = 22;
    private final int quantity4 = 10;
    private final BigDecimal unitPrice = new BigDecimal(92.29);
    private final BigDecimal unitPrice5 = new BigDecimal(33.17);
    private final SoldItem soldItem = Mockito.mock(SoldItem.class);

    private final SoldItemPojo instance = new SoldItemPojo(id, itemCommonDetail, invoice, quantity, unitPrice);
    private final SoldItemPojo instance00 = new SoldItemPojo(id, itemCommonDetail, invoice, quantity, unitPrice);
    private final SoldItemPojo instance01 = new SoldItemPojo(id1, itemCommonDetail, invoice, quantity, unitPrice);
    private final SoldItemPojo instance02 = new SoldItemPojo(id, itemCommonDetail2, invoice, quantity, unitPrice);
    private final SoldItemPojo instance03 = new SoldItemPojo(id, itemCommonDetail, invoice3, quantity, unitPrice);
    private final SoldItemPojo instance04 = new SoldItemPojo(id, itemCommonDetail, invoice, quantity4, unitPrice);
    private final SoldItemPojo instance05 = new SoldItemPojo(id, itemCommonDetail, invoice, quantity, unitPrice5);
    private final SoldItemPojo instance06 = new SoldItemPojo();
    private final SoldItemPojo instance07 = new SoldItemPojo(id, unitPrice);
    private final SoldItemPojo instance08 = new SoldItemPojo(itemCommonDetail, invoice, quantity, unitPrice);
    private final SoldItemPojo instance09 = new HibernateProxySoldItemPojo(new SoldItemPojo(id, itemCommonDetail, invoice, quantity, unitPrice));

    @Before
    public void setUp() {

        Mockito.when(soldItem.getInvoice()).thenReturn(invoice);
        Mockito.when(soldItem.getItemCommonDetail()).thenReturn(itemCommonDetail);
        Mockito.when(soldItem.getQuantity()).thenReturn(22);
        Mockito.when(soldItem.getUnitPrice()).thenReturn(new BigDecimal(92.29));
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(1199, instance.getId());
        assertEquals(0, instance06.getId());
        assertEquals(1199, instance07.getId());
        assertEquals(0, instance08.getId());
        assertEquals(0, instance09.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(6632);
        assertEquals(6632, instance.getId());
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetail, instance.getItemCommonDetail());
        assertNull(instance06.getItemCommonDetail());
        assertNull(instance07.getItemCommonDetail());
        assertEquals(itemCommonDetail, instance08.getItemCommonDetail());
        assertNull(instance09.getItemCommonDetail());
    }

    /**
     * Test of setItemCommonDetail method.
     */
    @Test
    public void testSetItemCommonDetail() {

        ItemCommonDetailPojo itemCommonDetailAA = Mockito.mock(ItemCommonDetailPojo.class);
        instance.setItemCommonDetail(itemCommonDetailAA);
        assertEquals(itemCommonDetailAA, instance.getItemCommonDetail());
    }

    /**
     * Test of getInvoice method.
     */
    @Test
    public void testGetInvoice() {

        assertEquals(invoice, instance.getInvoice());
        assertNull(instance06.getInvoice());
        assertNull(instance07.getInvoice());
        assertEquals(invoice, instance08.getInvoice());
        assertNull(instance09.getInvoice());

    }

    /**
     * Test of setInvoice method.
     */
    @Test
    public void testSetInvoice() {

        InvoicePojo invoiceKA = Mockito.mock(InvoicePojo.class);
        instance.setInvoice(invoiceKA);
        assertEquals(invoiceKA, instance.getInvoice());
    }

    /**
     * Test of getQuantity method.
     */
    @Test
    public void testGetQuantity() {

        assertEquals(22, instance.getQuantity());
        assertEquals(0, instance06.getQuantity());
        assertEquals(0, instance07.getQuantity());
        assertEquals(22, instance08.getQuantity());
        assertEquals(0, instance09.getQuantity());
    }

    /**
     * Test of setQuantity method.
     */
    @Test
    public void testSetQuantity() {

        instance.setQuantity(32);
        assertEquals(32, instance.getQuantity());
    }

    /**
     * Test of getUnitPrice method.
     */
    @Test
    public void testGetUnitPrice() {

        assertTrue(NumberUtilities.equals(new BigDecimal(92.29), instance.getUnitPrice(), 2));
        assertNull(instance06.getUnitPrice());
        assertTrue(NumberUtilities.equals(new BigDecimal(92.29), instance07.getUnitPrice(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(92.29), instance08.getUnitPrice(), 2));
        assertNull(instance09.getUnitPrice());
    }

    /**
     * Test of setUnitPrice method.
     */
    @Test
    public void testSetUnitPrice() {

        instance.setUnitPrice(new BigDecimal(66.66));
        assertTrue(NumberUtilities.equals(new BigDecimal(66.66), instance.getUnitPrice(), 2));
    }

    /**
     * Test of hasSameConstraint method,.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance09.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(soldItem));

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
        assertTrue(instance.hasSameParameters(instance09));
        assertTrue(instance09.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(soldItem));

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
        assertEquals(instance09.hashCode(), instance.hashCode());

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
        assertTrue(instance.equals(instance09));
        assertTrue(instance09.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(soldItem));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxySoldItemPojo extends SoldItemPojo implements HibernateProxy {

        private static final long serialVersionUID = 795187011996570009L;

        private final SoldItemPojo pojo;

        public HibernateProxySoldItemPojo(SoldItemPojo pojo) {

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
                public SoldItemPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }

}
