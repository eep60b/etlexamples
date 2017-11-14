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

import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.utility.NumberUtilities;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class ItemCommonDetailPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ItemCommonDetailPojoTest {

    private final int id = 2392;
    private final int id01 = 912;
    private final String name = "fab";
    private final String name02 = "tank";
    private final byte[] image = {32, 65, 15};
    private final byte[] image03 = {83, 25};
    private final BigDecimal listPrice = new BigDecimal(121.32);
    private final BigDecimal listPrice04 = new BigDecimal(77.33);
    private final BigDecimal listPrice04_1 = new BigDecimal(121.31999);
    private final BigDecimal salePrice = new BigDecimal(65.33);
    private final BigDecimal salePrice05 = new BigDecimal(44.11);
    private final BigDecimal salePrice05_1 = new BigDecimal(65.331);
    private final CurrencyCode currencyCode = CurrencyCode.BRP;
    private final CurrencyCode currencyCode06 = CurrencyCode.USD;
    private final int ranking = 238921;
    private final int ranking07 = 99363;
    private final String description = "a good tool.";
    private final String description08 = "so fo";
    private final AvailabilityType availability = AvailabilityType.YES;
    private final AvailabilityType availability09 = AvailabilityType.TO_BE_PRODUCED;
    private final int availabilityNumber = 21;
    private final int availabilityNumber10 = 32;
    private final String barcode = "92302184034143o1";
    private final String barcode11 = "9afk3q294940q33o1";
    private final ReviewPojo reviewPojo1 = Mockito.mock(ReviewPojo.class);
    private final ReviewPojo reviewPojo2 = Mockito.mock(ReviewPojo.class);
    private final ReviewPojo reviewPojo3 = Mockito.mock(ReviewPojo.class);
    private final ReviewPojo reviewPojo4 = Mockito.mock(ReviewPojo.class);
    private final Set<ReviewPojo> reviews = new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2, reviewPojo3));
    private final Set<ReviewPojo> reviews12 = new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo4));
    private final Set<ReviewPojo> reviews13 = null;
    private final ShoppingCartItemPojo shoppingCartItemPojo1 = Mockito.mock(ShoppingCartItemPojo.class);
    private final ShoppingCartItemPojo shoppingCartItemPojo2 = Mockito.mock(ShoppingCartItemPojo.class);
    private final ShoppingCartItemPojo shoppingCartItemPojo3 = Mockito.mock(ShoppingCartItemPojo.class);
    private final ShoppingCartItemPojo shoppingCartItemPojo4 = Mockito.mock(ShoppingCartItemPojo.class);
    private final Set<ShoppingCartItemPojo> shoppingCart = new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2, shoppingCartItemPojo3));
    private final Set<ShoppingCartItemPojo> shoppingCart14 = new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo4));
    private final Set<ShoppingCartItemPojo> shoppingCart15 = null;
    private final BookPojo bookPojo1 = Mockito.mock(BookPojo.class);
    private final BookPojo bookPojo2 = Mockito.mock(BookPojo.class);
    private final BookPojo bookPojo3 = Mockito.mock(BookPojo.class);
    private final BookPojo bookPojo4 = Mockito.mock(BookPojo.class);
    private final Set<BookPojo> books = new HashSet<>(Arrays.asList(bookPojo1, bookPojo2, bookPojo3));
    private final Set<BookPojo> books16 = new HashSet<>(Arrays.asList(bookPojo1, bookPojo4));
    private final Set<BookPojo> books17 = null;
    private final WishlistPojo wishlistPojo1 = Mockito.mock(WishlistPojo.class);
    private final WishlistPojo wishlistPojo2 = Mockito.mock(WishlistPojo.class);
    private final WishlistPojo wishlistPojo3 = Mockito.mock(WishlistPojo.class);
    private final WishlistPojo wishlistPojo4 = Mockito.mock(WishlistPojo.class);
    private final Set<WishlistPojo> wishlists = new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo2, wishlistPojo3));
    private final Set<WishlistPojo> wishlists18 = new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo4));
    private final Set<WishlistPojo> wishlists19 = null;
    private final CategoryPojo categoryPojo1 = Mockito.mock(CategoryPojo.class);
    private final CategoryPojo categoryPojo2 = Mockito.mock(CategoryPojo.class);
    private final CategoryPojo categoryPojo3 = Mockito.mock(CategoryPojo.class);
    private final CategoryPojo categoryPojo4 = Mockito.mock(CategoryPojo.class);
    private final Set<CategoryPojo> categories = new HashSet<>(Arrays.asList(categoryPojo1, categoryPojo2, categoryPojo3));
    private final Set<CategoryPojo> categories20 = new HashSet<>(Arrays.asList(categoryPojo1, categoryPojo4));
    private final Set<CategoryPojo> categories21 = null;
    private final SoldItemPojo soldItemPojo1 = Mockito.mock(SoldItemPojo.class);
    private final SoldItemPojo soldItemPojo2 = Mockito.mock(SoldItemPojo.class);
    private final SoldItemPojo soldItemPojo3 = Mockito.mock(SoldItemPojo.class);
    private final SoldItemPojo soldItemPojo4 = Mockito.mock(SoldItemPojo.class);
    private final Set<SoldItemPojo> soldItems = new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo2, soldItemPojo3));
    private final Set<SoldItemPojo> soldItems22 = new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo4));
    private final Set<SoldItemPojo> soldItems23 = null;
    private final ItemCommonDetail itemCommonDetail = Mockito.mock(ItemCommonDetail.class);

    private final ItemCommonDetailPojo instance = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance00 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance01 = new ItemCommonDetailPojo(id01, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance02 = new ItemCommonDetailPojo(id, name02, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance03 = new ItemCommonDetailPojo(id, name, image03, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance04 = new ItemCommonDetailPojo(id, name, image, listPrice04, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance04_1 = new ItemCommonDetailPojo(id, name, image, listPrice04_1, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance05 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice05, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance05_1 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice05_1, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance06 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode06, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance07 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking07, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance08 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description08, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance09 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability09, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance10 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber10, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance11 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode11, reviews, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance12 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews12, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance13 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews13, shoppingCart, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance14 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart14, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance15 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart15, books, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance16 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books16, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance17 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books17, wishlists, categories, soldItems);
    private final ItemCommonDetailPojo instance18 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists18, categories, soldItems);
    private final ItemCommonDetailPojo instance19 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists19, categories, soldItems);
    private final ItemCommonDetailPojo instance20 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories20, soldItems);
    private final ItemCommonDetailPojo instance21 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories21, soldItems);
    private final ItemCommonDetailPojo instance22 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems22);
    private final ItemCommonDetailPojo instance23 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode, reviews, shoppingCart, books, wishlists, categories, soldItems23);
    private final ItemCommonDetailPojo instance24 = new ItemCommonDetailPojo();
    private final ItemCommonDetailPojo instance25 = new ItemCommonDetailPojo(id, name, listPrice, salePrice, currencyCode, availability, barcode);
    private final ItemCommonDetailPojo instance26 = new ItemCommonDetailPojo(name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode);
    private final ItemCommonDetailPojo instance27 = new ItemCommonDetailPojo(id, name, image, listPrice, salePrice, currencyCode, ranking, description, availability, availabilityNumber, barcode);
    private final ItemCommonDetailPojo instance28 = new HibernateProxyItemCommonDetailPojo(instance);
    private ItemCommonDetailPojo instance29;

    @Before
    public void setUp() {

        Mockito.when(itemCommonDetail.getName()).thenReturn("fab");
        Mockito.when(itemCommonDetail.getAvailability()).thenReturn(AvailabilityType.YES);
        Mockito.when(itemCommonDetail.getAvailabilityNumber()).thenReturn(21);
        Mockito.when(itemCommonDetail.getBarcode()).thenReturn("92302184034143o1");
        Mockito.when(itemCommonDetail.getCurrencyCode()).thenReturn(CurrencyCode.BRP);
        Mockito.when(itemCommonDetail.getDescription()).thenReturn("a good tool.");
        Mockito.when(itemCommonDetail.getImage()).thenReturn(new byte[]{32, 65, 15});
        Mockito.when(itemCommonDetail.getListPrice()).thenReturn(new BigDecimal(121.32));
        Mockito.when(itemCommonDetail.getRanking()).thenReturn(238921);
        Mockito.when(itemCommonDetail.getSalePrice()).thenReturn(new BigDecimal(65.33));
        instance29 = new ItemCommonDetailPojo(itemCommonDetail);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(2392, instance.getId());
        assertEquals(0, instance24.getId());
        assertEquals(2392, instance25.getId());
        assertEquals(0, instance26.getId());
        assertEquals(2392, instance27.getId());
        assertEquals(0, instance29.getId());
        assertEquals(0, instance28.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(3367);
        assertEquals(3367, instance.getId());
    }

    /**
     * Test of getName method.
     */
    @Test
    public void testGetName() {

        assertEquals("fab", instance.getName());
        assertNull(instance24.getName());
        assertEquals("fab", instance25.getName());
        assertEquals("fab", instance26.getName());
        assertEquals("fab", instance27.getName());
        assertEquals("fab", instance29.getName());
        assertNull(instance28.getName());
    }

    /**
     * Test of setName method.
     */
    @Test
    public void testSetName() {

        instance.setName("nam");
        assertEquals("nam", instance.getName());
    }

    /**
     * Test of getImage method.
     */
    @Test
    public void testGetImage() {

        assertArrayEquals(new byte[]{32, 65, 15}, instance.getImage());
        instance.getImage()[0] = 22;
        assertArrayEquals(new byte[]{32, 65, 15}, instance.getImage());
        image[0] = 11;
        assertArrayEquals(new byte[]{32, 65, 15}, instance.getImage());

        assertNull(instance24.getImage());
        assertNull(instance25.getImage());
        assertArrayEquals(new byte[]{32, 65, 15}, instance26.getImage());
        assertArrayEquals(new byte[]{32, 65, 15}, instance27.getImage());
        assertArrayEquals(new byte[]{32, 65, 15}, instance29.getImage());
        assertNull(instance28.getImage());
    }

    /**
     * Test of setImage method.
     */
    @Test
    public void testSetImage() {
        byte[] imageK = {52, 81, 14};
        instance.setImage(imageK);
        assertArrayEquals(new byte[]{52, 81, 14}, instance.getImage());
        imageK[0] = 45;
        assertArrayEquals(new byte[]{52, 81, 14}, instance.getImage());
    }

    /**
     * Test of getListPrice method.
     */
    @Test
    public void testGetListPrice() {

        assertTrue(NumberUtilities.equals(new BigDecimal(121.32), instance.getListPrice(), 2));
        assertNull(instance24.getListPrice());
        assertTrue(NumberUtilities.equals(new BigDecimal(121.32), instance25.getListPrice(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(121.32), instance26.getListPrice(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(121.32), instance27.getListPrice(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(121.32), instance29.getListPrice(), 2));
        assertNull(instance28.getListPrice());
    }

    /**
     * Test of setListPrice method.
     */
    @Test
    public void testSetListPrice() {
        instance.setListPrice(new BigDecimal(56.32));
        assertTrue(NumberUtilities.equals(new BigDecimal(56.32), instance.getListPrice(), 2));
    }

    /**
     * Test of getSalePrice method.
     */
    @Test
    public void testGetSalePrice() {

        assertTrue(NumberUtilities.equals(new BigDecimal(65.33), instance.getSalePrice(), 2));
        assertNull(instance24.getSalePrice());
        assertTrue(NumberUtilities.equals(new BigDecimal(65.33), instance25.getSalePrice(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(65.33), instance26.getSalePrice(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(65.33), instance27.getSalePrice(), 2));
        assertTrue(NumberUtilities.equals(new BigDecimal(65.33), instance29.getSalePrice(), 2));
        assertNull(instance28.getSalePrice());
    }

    /**
     * Test of setSalePrice method
     */
    @Test
    public void testSetSalePrice() {

        instance.setSalePrice(new BigDecimal(20));
        assertTrue(NumberUtilities.equals(new BigDecimal(20), instance.getSalePrice(), 2));
    }

    /**
     * Test of getCurrencyCode method.
     */
    @Test
    public void testGetCurrencyCode() {

        assertEquals(CurrencyCode.BRP, instance.getCurrencyCode());
        assertNull(instance24.getCurrencyCode());
        assertEquals(CurrencyCode.BRP, instance25.getCurrencyCode());
        assertEquals(CurrencyCode.BRP, instance26.getCurrencyCode());
        assertEquals(CurrencyCode.BRP, instance27.getCurrencyCode());
        assertEquals(CurrencyCode.BRP, instance29.getCurrencyCode());
        assertNull(instance28.getCurrencyCode());
    }

    /**
     * Test of setCurrencyCode method.
     */
    @Test
    public void testSetCurrencyCode() {

        instance.setCurrencyCode(CurrencyCode.DMK);
        assertEquals(CurrencyCode.DMK, instance.getCurrencyCode());
    }

    /**
     * Test of getRanking method.
     */
    @Test
    public void testGetRanking() {

        assertEquals(238921, instance.getRanking());
        assertEquals(0, instance24.getRanking());
        assertEquals(0, instance25.getRanking());
        assertEquals(238921, instance26.getRanking());
        assertEquals(238921, instance27.getRanking());
        assertEquals(238921, instance29.getRanking());
        assertEquals(0, instance28.getRanking());
    }

    /**
     * Test of setRanking method.
     */
    @Test
    public void testSetRanking() {

        instance.setRanking(881726);
        assertEquals(881726, instance.getRanking());
    }

    /**
     * Test of getDescription method.
     */
    @Test
    public void testGetDescription() {

        assertEquals("a good tool.", instance.getDescription());
        assertNull(instance24.getDescription());
        assertNull(instance25.getDescription());
        assertEquals("a good tool.", instance26.getDescription());
        assertEquals("a good tool.", instance27.getDescription());
        assertEquals("a good tool.", instance29.getDescription());
        assertNull(instance28.getDescription());
    }

    /**
     * Test of setDescription method.
     */
    @Test
    public void testSetDescription() {

        instance.setDescription("ooqn  ladf asldf a");
        assertEquals("ooqn  ladf asldf a", instance.getDescription());
    }

    /**
     * Test of getAvailability method.
     */
    @Test
    public void testGetAvailability() {

        assertEquals(AvailabilityType.YES, instance.getAvailability());
        assertNull(instance24.getAvailability());
        assertEquals(AvailabilityType.YES, instance25.getAvailability());
        assertEquals(AvailabilityType.YES, instance26.getAvailability());
        assertEquals(AvailabilityType.YES, instance27.getAvailability());
        assertEquals(AvailabilityType.YES, instance29.getAvailability());
        assertNull(instance28.getAvailability());
    }

    /**
     * Test of setAvailability method.
     */
    @Test
    public void testSetAvailability() {

        instance.setAvailability(AvailabilityType.OUT_OF_STOCK);
        assertEquals(AvailabilityType.OUT_OF_STOCK, instance.getAvailability());
    }

    /**
     * Test of getAvailabilityNumber method.
     */
    @Test
    public void testGetAvailabilityNumber() {

        assertEquals(21, instance.getAvailabilityNumber());
        assertEquals(0, instance24.getAvailabilityNumber());
        assertEquals(0, instance25.getAvailabilityNumber());
        assertEquals(21, instance26.getAvailabilityNumber());
        assertEquals(21, instance27.getAvailabilityNumber());
        assertEquals(21, instance29.getAvailabilityNumber());
        assertEquals(0, instance28.getAvailabilityNumber());
    }

    /**
     * Test of setAvailabilityNumber method.
     */
    @Test
    public void testSetAvailabilityNumber() {

        instance.setAvailabilityNumber(18);
        assertEquals(18, instance.getAvailabilityNumber());
    }

    /**
     * Test of getBarcode method.
     */
    @Test
    public void testGetBarcode() {

        assertEquals("92302184034143o1", instance.getBarcode());
        assertNull(instance24.getBarcode());
        assertEquals("92302184034143o1", instance25.getBarcode());
        assertEquals("92302184034143o1", instance26.getBarcode());
        assertEquals("92302184034143o1", instance27.getBarcode());
        assertEquals("92302184034143o1", instance29.getBarcode());
        assertNull(instance28.getBarcode());
    }

    /**
     * Test of setBarcode method.
     */
    @Test
    public void testSetBarcode() {

        instance.setBarcode("73190234h13i41");
        assertEquals("73190234h13i41", instance.getBarcode());
    }

    /**
     * Test of getReviews method.
     */
    @Test
    public void testGetReviews() {

        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2, reviewPojo3)), instance.getReviews());
        instance.getReviews().clear();
        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2, reviewPojo3)), instance.getReviews());
        reviews.clear();
        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2, reviewPojo3)), instance.getReviews());

        assertNull(instance13.getReviews());
        assertTrue(instance24.getReviews().isEmpty());
        assertTrue(instance25.getReviews().isEmpty());
        assertTrue(instance26.getReviews().isEmpty());
        assertTrue(instance27.getReviews().isEmpty());
        assertTrue(instance29.getReviews().isEmpty());
        assertTrue(instance28.getReviews().isEmpty());
    }

    /**
     * Test of setReviews method.
     */
    @Test
    public void testSetReviews() {

        Set<ReviewPojo> reviewsK = new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2));
        instance.setReviews(reviewsK);
        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2)), instance.getReviews());
        reviewsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2)), instance.getReviews());

        instance.setReviews(null);
        assertNull(instance.getReviews());
    }

    /**
     * Test of getShoppingCart method.
     */
    @Test
    public void testGetShoppingCart() {

        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2, shoppingCartItemPojo3)), instance.getShoppingCart());
        instance.getShoppingCart().clear();
        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2, shoppingCartItemPojo3)), instance.getShoppingCart());
        shoppingCart.clear();
        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo1, shoppingCartItemPojo2, shoppingCartItemPojo3)), instance.getShoppingCart());

        assertNull(instance15.getShoppingCart());
        assertTrue(instance24.getShoppingCart().isEmpty());
        assertTrue(instance25.getShoppingCart().isEmpty());
        assertTrue(instance26.getShoppingCart().isEmpty());
        assertTrue(instance27.getShoppingCart().isEmpty());
        assertTrue(instance29.getShoppingCart().isEmpty());
        assertTrue(instance28.getShoppingCart().isEmpty());
    }

    /**
     * Test of setShoppingCart method.
     */
    @Test
    public void testSetShoppingCart() {

        Set<ShoppingCartItemPojo> shoppingCartK = new HashSet<>(Arrays.asList(shoppingCartItemPojo2, shoppingCartItemPojo3));
        instance.setShoppingCart(shoppingCartK);
        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo2, shoppingCartItemPojo3)), instance.getShoppingCart());
        shoppingCartK.clear();
        assertEquals(new HashSet<>(Arrays.asList(shoppingCartItemPojo2, shoppingCartItemPojo3)), instance.getShoppingCart());
        instance.setShoppingCart(null);
        assertNull(instance.getShoppingCart());
    }

    /**
     * Test of getBooks method.
     */
    @Test
    public void testGetBooks() {
        assertEquals(new HashSet<>(Arrays.asList(bookPojo1, bookPojo2, bookPojo3)), instance.getBooks());
        instance.getBooks().clear();
        assertEquals(new HashSet<>(Arrays.asList(bookPojo1, bookPojo2, bookPojo3)), instance.getBooks());
        books.clear();
        assertEquals(new HashSet<>(Arrays.asList(bookPojo1, bookPojo2, bookPojo3)), instance.getBooks());

        assertNull(instance17.getBooks());
        assertTrue(instance24.getBooks().isEmpty());
        assertTrue(instance25.getBooks().isEmpty());
        assertTrue(instance26.getBooks().isEmpty());
        assertTrue(instance27.getBooks().isEmpty());
        assertTrue(instance29.getBooks().isEmpty());
        assertTrue(instance28.getBooks().isEmpty());
    }

    /**
     * Test of setBooks method.
     */
    @Test
    public void testSetBooks() {

        Set<BookPojo> booksK = new HashSet<>(Arrays.asList(bookPojo1));
        instance.setBooks(booksK);
        assertEquals(new HashSet<>(Arrays.asList(bookPojo1)), instance.getBooks());
        booksK.add(bookPojo4);
        assertEquals(new HashSet<>(Arrays.asList(bookPojo1)), instance.getBooks());

        instance.setBooks(null);
        assertNull(instance.getBooks());
    }

    /**
     * Test of getWishlists method.
     */
    @Test
    public void testGetWishlists() {

        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo2, wishlistPojo3)), instance.getWishlists());
        instance.getWishlists().clear();
        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo2, wishlistPojo3)), instance.getWishlists());
        wishlists.clear();
        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo1, wishlistPojo2, wishlistPojo3)), instance.getWishlists());

        assertNull(instance19.getWishlists());
        assertTrue(instance24.getWishlists().isEmpty());
        assertTrue(instance25.getWishlists().isEmpty());
        assertTrue(instance26.getWishlists().isEmpty());
        assertTrue(instance27.getWishlists().isEmpty());
        assertTrue(instance29.getWishlists().isEmpty());
        assertTrue(instance28.getWishlists().isEmpty());
    }

    /**
     * Test of setWishlists method.
     */
    @Test
    public void testSetWishlists() {

        Set<WishlistPojo> wishlistsK = new HashSet<>(Arrays.asList(wishlistPojo2, wishlistPojo3));
        instance.setWishlists(wishlistsK);
        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo2, wishlistPojo3)), instance.getWishlists());
        wishlistsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(wishlistPojo2, wishlistPojo3)), instance.getWishlists());

        instance.setWishlists(null);
        assertNull(instance.getWishlists());
    }

    /**
     * Test of getCategories method.
     */
    @Test
    public void testGetCategories() {

        assertEquals(new HashSet<>(Arrays.asList(categoryPojo1, categoryPojo2, categoryPojo3)), instance.getCategories());
        instance.getCategories().add(categoryPojo4);
        assertEquals(new HashSet<>(Arrays.asList(categoryPojo1, categoryPojo2, categoryPojo3)), instance.getCategories());
        categories.add(categoryPojo4);
        assertEquals(new HashSet<>(Arrays.asList(categoryPojo1, categoryPojo2, categoryPojo3)), instance.getCategories());

        assertNull(instance21.getCategories());
        assertTrue(instance24.getCategories().isEmpty());
        assertTrue(instance25.getCategories().isEmpty());
        assertTrue(instance26.getCategories().isEmpty());
        assertTrue(instance27.getCategories().isEmpty());
        assertTrue(instance29.getCategories().isEmpty());
        assertTrue(instance28.getCategories().isEmpty());
    }

    /**
     * Test of setCategories method.
     */
    @Test
    public void testSetCategories() {

        Set<CategoryPojo> categoriesK = new HashSet<>(Arrays.asList(categoryPojo2, categoryPojo3));
        instance.setCategories(categoriesK);
        assertEquals(new HashSet<>(Arrays.asList(categoryPojo2, categoryPojo3)), instance.getCategories());
        categoriesK.add(categoryPojo4);
        assertEquals(new HashSet<>(Arrays.asList(categoryPojo2, categoryPojo3)), instance.getCategories());

        instance.setCategories(null);
        assertNull(instance.getCategories());
    }

    /**
     * Test of getSoldItems method.
     */
    @Test
    public void testGetSoldItems() {

        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo2, soldItemPojo3)), instance.getSoldItems());
        instance.getSoldItems().clear();
        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo2, soldItemPojo3)), instance.getSoldItems());
        soldItems.clear();
        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo1, soldItemPojo2, soldItemPojo3)), instance.getSoldItems());

        assertNull(instance23.getSoldItems());
        assertTrue(instance24.getSoldItems().isEmpty());
        assertTrue(instance25.getSoldItems().isEmpty());
        assertTrue(instance26.getSoldItems().isEmpty());
        assertTrue(instance27.getSoldItems().isEmpty());
        assertTrue(instance29.getSoldItems().isEmpty());
        assertTrue(instance28.getSoldItems().isEmpty());

    }

    /**
     * Test of setSoldItems method.
     */
    @Test
    public void testSetSoldItems() {

        Set<SoldItemPojo> soldItemsK = new HashSet<>(Arrays.asList(soldItemPojo3));
        instance.setSoldItems(soldItemsK);
        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo3)), instance.getSoldItems());
        soldItemsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(soldItemPojo3)), instance.getSoldItems());

        instance.setSoldItems(null);
        assertNull(instance.getSoldItems());
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
        assertTrue(instance.hasSameConstraint(instance10));
        assertTrue(instance.hasSameConstraint(instance12));
        assertTrue(instance.hasSameConstraint(instance14));
        assertTrue(instance.hasSameConstraint(instance16));
        assertTrue(instance.hasSameConstraint(instance18));
        assertTrue(instance.hasSameConstraint(instance20));
        assertTrue(instance.hasSameConstraint(instance22));
        assertTrue(instance.hasSameConstraint(instance28));
        assertTrue(instance28.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(itemCommonDetail));

        assertFalse(instance.hasSameConstraint(instance11));
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
        assertTrue(instance.hasSameParameters(instance04_1));
        assertTrue(instance.hasSameParameters(instance05_1));
        assertTrue(instance.hasSameParameters(instance12));
        assertTrue(instance.hasSameParameters(instance14));
        assertTrue(instance.hasSameParameters(instance16));
        assertTrue(instance.hasSameParameters(instance18));
        assertTrue(instance.hasSameParameters(instance20));
        assertTrue(instance.hasSameParameters(instance22));
        assertTrue(instance.hasSameParameters(instance28));
        assertTrue(instance28.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(itemCommonDetail));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(instance07));
        assertFalse(instance.hasSameParameters(instance08));
        assertFalse(instance.hasSameParameters(instance09));
        assertFalse(instance.hasSameParameters(instance10));
        assertFalse(instance.hasSameParameters(instance11));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance12.hashCode(), instance.hashCode());
        assertEquals(instance14.hashCode(), instance.hashCode());
        assertEquals(instance16.hashCode(), instance.hashCode());
        assertEquals(instance18.hashCode(), instance.hashCode());
        assertEquals(instance20.hashCode(), instance.hashCode());
        assertEquals(instance22.hashCode(), instance.hashCode());
        assertEquals(instance28.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance07.hashCode(), instance.hashCode());
        assertNotEquals(instance08.hashCode(), instance.hashCode());
        assertNotEquals(instance09.hashCode(), instance.hashCode());
        assertNotEquals(instance10.hashCode(), instance.hashCode());
        assertNotEquals(instance11.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance04_1));
        assertTrue(instance.equals(instance05_1));
        assertTrue(instance.equals(instance12));
        assertTrue(instance.equals(instance14));
        assertTrue(instance.equals(instance16));
        assertTrue(instance.equals(instance18));
        assertTrue(instance.equals(instance20));
        assertTrue(instance.equals(instance22));
        assertTrue(instance.equals(instance28));
        assertTrue(instance28.equals(instance));

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
        assertFalse(instance.equals(instance11));
        assertFalse(instance.equals(itemCommonDetail));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance));
    }

    private final class HibernateProxyItemCommonDetailPojo extends ItemCommonDetailPojo implements HibernateProxy {

        private static final long serialVersionUID = 688414046929037250L;

        private final ItemCommonDetailPojo itemCommonDetailPojo;

        public HibernateProxyItemCommonDetailPojo(ItemCommonDetailPojo itemCommonDetailPojo) {
            this.itemCommonDetailPojo = itemCommonDetailPojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {

            return new AbstractMockLazyInitializer() {
                @Override
                public ItemCommonDetailPojo getImplementation() {
                    return itemCommonDetailPojo;
                }
            };
        }
    }
}
