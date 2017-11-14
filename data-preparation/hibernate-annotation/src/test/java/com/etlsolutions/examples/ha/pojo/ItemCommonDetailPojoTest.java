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
package com.etlsolutions.examples.ha.pojo;

import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import java.math.BigDecimal;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of getCurrencyCode method, of class ItemCommonDetailPojo.
 *
 * @author Zhipeng Chang
 */
public class ItemCommonDetailPojoTest {

    public ItemCommonDetailPojoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        byte[] expResult = null;
        byte[] result = instance.getImage();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        byte[] image = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setImage(image);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPrice method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetListPrice() {
        System.out.println("getListPrice");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        BigDecimal expResult = null;
        BigDecimal result = instance.getListPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListPrice method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetListPrice() {
        System.out.println("setListPrice");
        BigDecimal listPrice = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setListPrice(listPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalePrice method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetSalePrice() {
        System.out.println("getSalePrice");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        BigDecimal expResult = null;
        BigDecimal result = instance.getSalePrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalePrice method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetSalePrice() {
        System.out.println("setSalePrice");
        BigDecimal salePrice = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setSalePrice(salePrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrencyCode method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetCurrencyCode() {
        System.out.println("getCurrencyCode");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        String expResult = "";
        assertEquals(expResult, instance.getCurrencyCode());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrencyCode method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetCurrencyCode() {
        System.out.println("setCurrencyCode");
        String currencyCode = "";
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setCurrencyCode(CurrencyCode.YEN);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRanking method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetRanking() {
        System.out.println("getRanking");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        int expResult = 0;
        int result = instance.getRanking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRanking method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetRanking() {
        System.out.println("setRanking");
        int ranking = 0;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setRanking(ranking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailability method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetAvailability() {
        System.out.println("getAvailability");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        String expResult = "";
        assertEquals(expResult, instance.getAvailability());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailability method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetAvailability() {
        System.out.println("setAvailability");
        String availability = "";
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setAvailability(AvailabilityType.TO_BE_PRODUCED);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailabilityNumber method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetAvailableNumber() {
        System.out.println("getAvailableNumber");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        Integer expResult = null;
        Integer result = instance.getAvailabilityNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailabilityNumber method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetAvailableNumber() {
        System.out.println("setAvailableNumber");
        Integer availableNumber = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        //    instance.setAvailabilityNumber(itemAvailableNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSoldItems method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetSoldItems() {
        System.out.println("getSoldItems");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        Set<SoldItemPojo> expResult = null;
        Set<SoldItemPojo> result = instance.getSoldItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSoldItems method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetSoldItems() {
        System.out.println("setSoldItems");
        Set<SoldItemPojo> soldItems = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setSoldItems(soldItems);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReviews method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetReviews() {
        System.out.println("getReviews");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        Set<ReviewPojo> expResult = null;
        Set<ReviewPojo> result = instance.getReviews();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReviews method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetReviews() {
        System.out.println("setReviews");
        Set<ReviewPojo> reviews = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setReviews(reviews);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWishlists method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetWishlists() {
        System.out.println("getWishlists");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        Set<WishlistPojo> expResult = null;
        Set<WishlistPojo> result = instance.getWishlists();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWishlists method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetWishlists() {
        System.out.println("setWishlists");
        Set<WishlistPojo> wishlists = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setWishlists(wishlists);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBooks method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        Set<BookPojo> expResult = null;
        Set<BookPojo> result = instance.getBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBooks method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetBooks() {
        System.out.println("setBooks");
        Set<BookPojo> books = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setBooks(books);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShoppingCart method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetShoppingCart() {
        System.out.println("getShoppingCart");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        Set<ShoppingCartItemPojo> expResult = null;
        Set<ShoppingCartItemPojo> result = instance.getShoppingCart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShoppingCart method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetShoppingCart() {
        System.out.println("setShoppingCart");
        Set<ShoppingCartItemPojo> shoppingCart = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setShoppingCart(shoppingCart);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategories method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        Set<CategoryPojo> expResult = null;
        Set<CategoryPojo> result = instance.getCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategories method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetCategories() {
        System.out.println("setCategories");
        Set<CategoryPojo> categories = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setCategories(categories);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailabilityNumber method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetAvailabilityNumber() {
        System.out.println("getAvailabilityNumber");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        int expResult = 0;
        int result = instance.getAvailabilityNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailabilityNumber method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetAvailabilityNumber() {
        System.out.println("setAvailabilityNumber");
        int availabilityNumber = 0;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setAvailabilityNumber(availabilityNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBarcode method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testSetBarcode() {
        System.out.println("setBarcode");
        String barcode = "";
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        instance.setBarcode(barcode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBarcode method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testGetBarcode() {
        System.out.println("getBarcode");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        String expResult = "";
        String result = instance.getBarcode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameConstraint method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testHasSameConstraint() {
        System.out.println("hasSameConstraint");
        ItemCommonDetail itemCommonDetail = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        boolean expResult = false;
        boolean result = instance.hasSameConstraint(itemCommonDetail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameParameters method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testHasSameParameters() {
        System.out.println("hasSameParameters");
        ItemCommonDetail constraintable = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        boolean expResult = false;
        boolean result = instance.hasSameParameters(constraintable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ItemCommonDetailPojo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ItemCommonDetailPojo instance = new ItemCommonDetailPojo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
