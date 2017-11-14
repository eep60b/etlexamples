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

import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.data.general.wrapper.QuantityWapper;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
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
 * Test of class SoldItemEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SoldItemEntity.class, InvoiceEntity.class, ItemCommonDetailEntity.class})
public final class SoldItemEntityTest {

    private final InvoiceEntity invoiceEntity = PowerMockito.mock(InvoiceEntity.class);
    private final Invoice invoiceEntity1 = PowerMockito.mock(InvoiceEntity.class);
    private final Invoice invoice = Mockito.mock(Invoice.class);
    private final ItemCommonDetailEntity itemCommonDetailEntity = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final ItemCommonDetailEntity itemCommonDetailEntity2 = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final ItemCommonDetail itemCommonDetail = Mockito.mock(ItemCommonDetail.class);
    private final int quantity = 21;
    private final int quantity3 = 7;
    private final QuantityWapper itemQuantity = new QuantityWapper(21);
    private final BigDecimal unitpriceDecimal = new BigDecimal(43.13);
    private final BigDecimal unitpriceDecimal4 = new BigDecimal(73.11);
    private final UnitPrice unitprice = new UnitPrice(new BigDecimal(43.13));
    private final SoldItem soldItem = Mockito.mock(SoldItem.class);

    private final SoldItemEntity instance = new SoldItemEntity(invoiceEntity, itemCommonDetailEntity, quantity, unitpriceDecimal);
    private final SoldItemEntity instance00 = new SoldItemEntity(invoiceEntity, itemCommonDetailEntity, quantity, unitpriceDecimal);
    private final SoldItemEntity instance01 = new SoldItemEntity(invoiceEntity1, itemCommonDetailEntity, quantity, unitpriceDecimal);
    private final SoldItemEntity instance02 = new SoldItemEntity(invoiceEntity, itemCommonDetailEntity2, quantity, unitpriceDecimal);
    private final SoldItemEntity instance03 = new SoldItemEntity(invoiceEntity, itemCommonDetailEntity, quantity3, unitpriceDecimal);
    private final SoldItemEntity instance04 = new SoldItemEntity(invoiceEntity, itemCommonDetailEntity, quantity, unitpriceDecimal4);
    private SoldItemEntity instance05;
    private SoldItemEntity instance06;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(ItemCommonDetailEntity.class).withArguments(itemCommonDetail).thenReturn(itemCommonDetailEntity);
        PowerMockito.whenNew(InvoiceEntity.class).withArguments(invoice).thenReturn(invoiceEntity);

        Mockito.when(soldItem.getInvoice()).thenReturn(invoiceEntity);
        Mockito.when(soldItem.getItemCommonDetail()).thenReturn(itemCommonDetailEntity);
        Mockito.when(soldItem.getQuantity()).thenReturn(quantity);
        Mockito.when(soldItem.getUnitPrice()).thenReturn(unitpriceDecimal);

        instance05 = new SoldItemEntity(invoiceEntity, itemCommonDetailEntity, itemQuantity, unitprice);
        instance06 = new SoldItemEntity(soldItem);
    }

    /**
     * Test of getInvoice method.
     */
    @Test
    public void testGetInvoice() {

        assertEquals(invoiceEntity, instance.getInvoice());
        assertEquals(invoiceEntity, instance05.getInvoice());
        assertEquals(invoiceEntity, instance06.getInvoice());
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetailEntity, instance.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance05.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance06.getItemCommonDetail());
    }

    /**
     * Test of getQuantity method.
     */
    @Test
    public void testGetQuantity() {

        assertEquals(quantity, instance.getQuantity());
        assertEquals(quantity, instance05.getQuantity());
        assertEquals(quantity, instance06.getQuantity());
    }

    /**
     * Test of getUnitPrice method.
     */
    @Test
    public void testGetUnitPrice() {

        assertTrue(NumberUtilities.equals(unitpriceDecimal, instance.getUnitPrice()));
        assertTrue(NumberUtilities.equals(unitpriceDecimal, instance05.getUnitPrice()));
        assertTrue(NumberUtilities.equals(unitpriceDecimal, instance06.getUnitPrice()));
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
        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(soldItem));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(soldItem));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance01));
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
        assertTrue(instance.hasSameParameters(soldItem));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));
    }

}
