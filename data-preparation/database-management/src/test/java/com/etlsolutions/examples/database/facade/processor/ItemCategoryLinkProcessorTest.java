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
package com.etlsolutions.examples.database.facade.processor;

import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.Category;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.ItemCategoryLink;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.specific.item.CategoryEntity;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.specific.item.ItemAvailabilityNumber;
import com.etlsolutions.examples.data.specific.item.ItemBarcode;
import com.etlsolutions.examples.data.specific.item.ItemCategoryLinkEntity;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.data.specific.item.ItemDescription;
import com.etlsolutions.examples.data.specific.item.ItemImage;
import com.etlsolutions.examples.data.specific.item.ItemRanking;
import com.etlsolutions.examples.data.specific.item.ListPrice;
import com.etlsolutions.examples.data.specific.item.SalePrice;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.CategoryPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCategoryLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;
import java.math.BigDecimal;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ItemCategoryLinkProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ItemCategoryLinkProcessorTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final ItemAvailabilityNumber availabilityNumberColumn = new ItemAvailabilityNumber(5);
    private final ItemDescription descriptionColumn = new ItemDescription("this is an item..bblla");
    private final ItemImage imageColumn = new ItemImage(new byte[]{44, 51, 22, 67});
    private final NameWrapper nameColumn = new NameWrapper("item kO.");
    private final ItemRanking ranking = new ItemRanking(28677);
    private final ListPrice listPrice = new ListPrice(new BigDecimal(65.33));
    private final SalePrice salePrice = new SalePrice(new BigDecimal(34.66));
    private final ItemBarcode barcode = new ItemBarcode("0348915613822381");

    private final ItemCommonDetail itemCommonDetail = new ItemCommonDetailEntity(CurrencyCode.USD,
            AvailabilityType.YES, availabilityNumberColumn, descriptionColumn, imageColumn, nameColumn,
            ranking, listPrice, salePrice, barcode);

    private final ItemCommonDetail itemCommonDetail3 = new ItemCommonDetailEntity(CurrencyCode.EUR,
            AvailabilityType.YES, availabilityNumberColumn, descriptionColumn, imageColumn, nameColumn,
            ranking, listPrice, salePrice, barcode);

    private final Category category = new CategoryEntity(new NameWrapper("catname1"));

    private final ItemCategoryLink itemCategoryLink1 = new ItemCategoryLinkEntity(itemCommonDetail, category);
    private final ItemCategoryLink itemCategoryLink2 = new ItemCategoryLinkEntity(itemCommonDetail, category);
    private final ItemCategoryLink itemCategoryLink3 = new ItemCategoryLinkEntity(itemCommonDetail3, category);

    private final ItemCategoryLinkProcessor instance = new ItemCategoryLinkProcessor(facade);

    @Before
    public void setUp() {
        databaseManager.clear();
    }

    @After
    public void tearDown() {
        databaseManager.clear();
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave() {

        ItemCategoryLinkPojo expResult = new ItemCategoryLinkPojo(new ItemCommonDetailPojo(1, "item kO.", new byte[]{44, 51, 22, 67}, new BigDecimal(65.33), new BigDecimal(34.66), CurrencyCode.USD, 28677, "this is an item..bblla", AvailabilityType.YES, 5, "0348915613822381"), new CategoryPojo(1, "catname1"));
        assertTrue(instance.save(itemCategoryLink1).hasSameParameters(expResult));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Existing() {

        ItemCategoryLinkPojo expResult = instance.save(itemCategoryLink1);
        assertEquals(expResult, instance.save(itemCategoryLink2));
    }

    /**
     * Test of save method.
     */
    @Test(expected = IllegalStateException.class)
    public void testSave_Exception() {

        instance.save(itemCategoryLink1);
        instance.save(itemCategoryLink3);
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {

        ItemCategoryLinkPojo expResult = instance.save(itemCategoryLink1);
        ItemCategoryLinkPojo result = instance.retrieve(itemCategoryLink1);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(itemCategoryLink1));
    }

}
