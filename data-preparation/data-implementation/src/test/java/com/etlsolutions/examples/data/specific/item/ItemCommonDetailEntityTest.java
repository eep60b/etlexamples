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
package com.etlsolutions.examples.data.specific.item;

import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class ItemCommonDetailEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ItemCommonDetailEntityTest {

    private final ItemAvailabilityNumber itemAvailabilityNumberColumn = new ItemAvailabilityNumber(32);
    private final ItemAvailabilityNumber itemAvailabilityNumberColumn3 = new ItemAvailabilityNumber(67);
    private final ItemDescription itemDescriptionColumn = new ItemDescription("aianal alda laf alf a");
    private final ItemDescription itemDescriptionColumn4 = new ItemDescription("aintkin onnda8iq kkda");
    private final ItemImage itemImageColumn = new ItemImage(new byte[]{21, 54, 11});
    private final ItemImage itemImageColumn5 = new ItemImage(new byte[]{90, 17, 26});
    private final NameWrapper itemNameColumn = new NameWrapper("iandkahk");
    private final NameWrapper itemNameColumn6 = new NameWrapper("itemAName");
    private final ItemRanking itemRankingColumn = new ItemRanking(7123);
    private final ItemRanking itemRankingColumn7 = new ItemRanking(181612);
    private final ListPrice listPriceColumn = new ListPrice(new BigDecimal(92.178));
    private final ListPrice listPriceColumn8 = new ListPrice(new BigDecimal(28.99));
    private final SalePrice salePriceColumn = new SalePrice(new BigDecimal(22.37));
    private final SalePrice salePriceColumn9 = new SalePrice(new BigDecimal(47.22));
    private final ItemBarcode itemBarcodeColumn = new ItemBarcode("ad89hadoajdfaoaf2");
    private final ItemBarcode itemBarcodeColumn10 = new ItemBarcode("901401opu41oo14uo12");
    private final ItemCommonDetail itemCommonDetail = Mockito.mock(ItemCommonDetail.class);

    private final ItemCommonDetailEntity instance = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn, itemNameColumn, itemRankingColumn, listPriceColumn, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance00 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn, itemNameColumn, itemRankingColumn, listPriceColumn, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance01 = new ItemCommonDetailEntity(CurrencyCode.BRP, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn, itemNameColumn, itemRankingColumn, listPriceColumn, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance02 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.TO_BE_PRODUCED, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn, itemNameColumn, itemRankingColumn, listPriceColumn, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance03 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn3, itemDescriptionColumn, itemImageColumn, itemNameColumn, itemRankingColumn, listPriceColumn, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance04 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn4, itemImageColumn, itemNameColumn, itemRankingColumn, listPriceColumn, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance05 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn5, itemNameColumn, itemRankingColumn, listPriceColumn, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance06 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn, itemNameColumn6, itemRankingColumn, listPriceColumn, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance07 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn, itemNameColumn, itemRankingColumn7, listPriceColumn, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance08 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn, itemNameColumn, itemRankingColumn, listPriceColumn8, salePriceColumn, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance09 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn, itemNameColumn, itemRankingColumn, listPriceColumn, salePriceColumn9, itemBarcodeColumn);
    private final ItemCommonDetailEntity instance10 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, itemAvailabilityNumberColumn, itemDescriptionColumn, itemImageColumn, itemNameColumn, itemRankingColumn, listPriceColumn, salePriceColumn, itemBarcodeColumn10);
    private final ItemCommonDetailEntity instance11 = new ItemCommonDetailEntity(instance);

    private ItemCommonDetailEntity instance12;

    @Before
    public void setUp() {
        Mockito.when(itemCommonDetail.getCurrencyCode()).thenReturn(CurrencyCode.USD);
        Mockito.when(itemCommonDetail.getAvailability()).thenReturn(AvailabilityType.OUT_OF_STOCK);
        Mockito.when(itemCommonDetail.getAvailabilityNumber()).thenReturn(32);
        Mockito.when(itemCommonDetail.getBarcode()).thenReturn("ad89hadoajdfaoaf2");
        Mockito.when(itemCommonDetail.getDescription()).thenReturn("aianal alda laf alf a");
        Mockito.when(itemCommonDetail.getImage()).thenReturn(new byte[]{21, 54, 11});
        Mockito.when(itemCommonDetail.getListPrice()).thenReturn(new BigDecimal(92.178).setScale(2, RoundingMode.HALF_UP));
        Mockito.when(itemCommonDetail.getName()).thenReturn("iandkahk");
        Mockito.when(itemCommonDetail.getRanking()).thenReturn(7123);
        Mockito.when(itemCommonDetail.getSalePrice()).thenReturn(new BigDecimal(22.37).setScale(2, RoundingMode.HALF_UP));
        instance12 = new ItemCommonDetailEntity(itemCommonDetail);
    }

    /**
     * Test of getCurrencyCode method.
     */
    @Test
    public void testGetCurrencyCode() {

        assertEquals(CurrencyCode.USD, instance.getCurrencyCode());
        assertEquals(CurrencyCode.BRP, instance01.getCurrencyCode());
        assertEquals(CurrencyCode.USD, instance11.getCurrencyCode());
        assertEquals(CurrencyCode.USD, instance12.getCurrencyCode());
    }

    /**
     * Test of getAvailability method.
     */
    @Test
    public void testGetAvailability() {

        assertEquals(AvailabilityType.OUT_OF_STOCK, instance.getAvailability());
        assertEquals(AvailabilityType.TO_BE_PRODUCED, instance02.getAvailability());
        assertEquals(AvailabilityType.OUT_OF_STOCK, instance11.getAvailability());
        assertEquals(AvailabilityType.OUT_OF_STOCK, instance12.getAvailability());
    }

    /**
     * Test of getAvailabilityNumber method.
     */
    @Test
    public void testGetAvailabilityNumber() {

        assertEquals(32, instance.getAvailabilityNumber());
        assertEquals(67, instance03.getAvailabilityNumber());
        assertEquals(32, instance11.getAvailabilityNumber());
        assertEquals(32, instance12.getAvailabilityNumber());
    }

    /**
     * Test of getDescription method.
     */
    @Test
    public void testGetDescription() {

        assertEquals("aianal alda laf alf a", instance.getDescription());
        assertEquals("aintkin onnda8iq kkda", instance04.getDescription());
        assertEquals("aianal alda laf alf a", instance11.getDescription());
        assertEquals("aianal alda laf alf a", instance12.getDescription());
    }

    /**
     * Test of getImage method.
     */
    @Test
    public void testGetImage() {

        assertArrayEquals(new byte[]{21, 54, 11}, instance.getImage());
        assertArrayEquals(new byte[]{90, 17, 26}, instance05.getImage());
        assertArrayEquals(new byte[]{21, 54, 11}, instance11.getImage());
        assertArrayEquals(new byte[]{21, 54, 11}, instance12.getImage());
    }

    /**
     * Test of getName method.
     */
    @Test
    public void testGetName() {

        assertEquals("iandkahk", instance.getName());
        assertEquals("itemAName", instance06.getName());
        assertEquals("iandkahk", instance11.getName());
        assertEquals("iandkahk", instance12.getName());
    }

    /**
     * Test of getRanking method.
     */
    @Test
    public void testGetRanking() {

        assertEquals(7123, instance.getRanking());
        assertEquals(181612, instance07.getRanking());
        assertEquals(7123, instance11.getRanking());
        assertEquals(7123, instance12.getRanking());
    }

    /**
     * Test of getListPrice method.
     */
    @Test
    public void testGetListPrice() {

        assertEquals(new BigDecimal(92.178).setScale(2, RoundingMode.HALF_UP), instance.getListPrice());
        assertEquals(new BigDecimal(28.99).setScale(2, RoundingMode.HALF_UP), instance08.getListPrice());
        assertEquals(new BigDecimal(92.178).setScale(2, RoundingMode.HALF_UP), instance11.getListPrice());
        assertEquals(new BigDecimal(92.178).setScale(2, RoundingMode.HALF_UP), instance12.getListPrice());
    }

    /**
     * Test of getSalePrice method.
     */
    @Test
    public void testGetSalePrice() {

        assertEquals(new BigDecimal(22.37).setScale(2, RoundingMode.HALF_UP), instance.getSalePrice());
        assertEquals(new BigDecimal(47.22).setScale(2, RoundingMode.HALF_UP), instance09.getSalePrice());
        assertEquals(new BigDecimal(22.37).setScale(2, RoundingMode.HALF_UP), instance11.getSalePrice());
        assertEquals(new BigDecimal(22.37).setScale(2, RoundingMode.HALF_UP), instance12.getSalePrice());
    }

    /**
     * Test of getBarcode method.
     */
    @Test
    public void testGetBarcode() {

        assertEquals("ad89hadoajdfaoaf2", instance.getBarcode());
        assertEquals("901401opu41oo14uo12", instance10.getBarcode());
        assertEquals("ad89hadoajdfaoaf2", instance11.getBarcode());
        assertEquals("ad89hadoajdfaoaf2", instance12.getBarcode());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        assertEquals(instance09.hashCode(), instance.hashCode());
        assertEquals(instance11.hashCode(), instance.hashCode());
        assertEquals(instance12.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance07.hashCode(), instance.hashCode());
        assertNotEquals(instance10.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance11));
        assertTrue(instance.equals(instance12));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(instance08));
        assertFalse(instance.equals(instance09));
        assertFalse(instance.equals(instance10));
        assertFalse(instance.equals(itemCommonDetail));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("ItemCommonDetailEntity{name=iandkahk}", instance.toString());
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
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance.hasSameConstraint(instance11));
        assertTrue(instance.hasSameConstraint(instance12));
        assertTrue(instance.hasSameConstraint(itemCommonDetail));

        assertFalse(instance.hasSameConstraint(instance10));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {
        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance11));
        assertTrue(instance.hasSameParameters(instance12));
        assertTrue(instance.hasSameParameters(itemCommonDetail));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(instance07));
        assertFalse(instance.hasSameParameters(instance08));
        assertFalse(instance.hasSameParameters(instance09));
        assertFalse(instance.hasSameParameters(instance10));
    }

}
