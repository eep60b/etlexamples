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
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.LanguageCode;
import com.etlsolutions.examples.data.api.UOM;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.book.BookEdition;
import com.etlsolutions.examples.data.specific.book.BookEntity;
import com.etlsolutions.examples.data.specific.book.BookIsbn;
import com.etlsolutions.examples.data.specific.book.BookLength;
import com.etlsolutions.examples.data.specific.book.BookThickness;
import com.etlsolutions.examples.data.specific.book.BookWidth;
import com.etlsolutions.examples.data.specific.book.BookPdfContent;
import com.etlsolutions.examples.data.specific.book.PublishDate;
import com.etlsolutions.examples.data.specific.item.ItemAvailabilityNumber;
import com.etlsolutions.examples.data.specific.item.ItemBarcode;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.data.specific.item.ItemDescription;
import com.etlsolutions.examples.data.specific.item.ItemImage;
import com.etlsolutions.examples.data.specific.item.ItemRanking;
import com.etlsolutions.examples.data.specific.item.ListPrice;
import com.etlsolutions.examples.data.specific.item.SalePrice;
import com.etlsolutions.examples.data.specific.book.PublisherEntity;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.HibernateUtil;
import com.etlsolutions.examples.database.hibernate.pojo.BookPojo;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class BookProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class BookProcessorTest {

    private final SessionFactory factory = HibernateUtil.getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final AddressStreet addressMainColumn = new AddressStreet("832 llps kxy");
    private final AddressAdditionalInformation addressAdditionalColumn = new AddressAdditionalInformation("f f");
    private final AddressArea addressAreaColumn = new AddressArea("mancester");
    private final AddressCity addressCityColumn = new AddressCity("Potou");
    private final AddressCountry addressCountryColumn = new AddressCountry("UN");
    private final AddressPostcode addressPostcodeColumn = new AddressPostcode("K1432");
    private final AddressEntity addressEntity = new AddressEntity(new AddressHouse("3321"), addressMainColumn, addressAdditionalColumn, addressAreaColumn, addressCityColumn, addressCountryColumn, addressPostcodeColumn);
    
    private final ItemCommonDetailEntity itemCommonDetailEntity1 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, new ItemAvailabilityNumber(32),
            new ItemDescription("ff dsknk"), new ItemImage(new byte[]{35, 63, 22}), new NameWrapper("ite name"),
            new ItemRanking(23921), new ListPrice(), SalePrice.ZERO, new ItemBarcode("fadaalfdkank"));
    private final ItemCommonDetailEntity itemCommonDetailEntity2 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, new ItemAvailabilityNumber(32),
            new ItemDescription("ff dsknk"), new ItemImage(new byte[]{35, 63, 22}), new NameWrapper("ite name"),
            new ItemRanking(23921), new ListPrice(), SalePrice.ZERO, new ItemBarcode("fadaalfdkankafad"));
    private final PublisherEntity publisherEntity1 = new PublisherEntity(addressEntity, new NameWrapper("kaak publ ish"));
    private final PublisherEntity publisherEntity2 = new PublisherEntity(addressEntity, new NameWrapper("bubll ish"));
    
    private final Book book1 = new BookEntity(itemCommonDetailEntity1, publisherEntity1, new BookPdfContent(new byte[]{22, 11, 78}),
                new BookEdition(2), BookFormat.PAPERBACK, new BookIsbn("1382373383778"),
                LanguageCode.EN, new PublishDate(new Date(2130095302349L)), new BookWidth(new BigDecimal(33.77)),
                new BookLength(new BigDecimal(33.36)), new BookThickness(new BigDecimal(3.34)), UOM.IN);
    
    private final Book book2 = new BookEntity(itemCommonDetailEntity2, publisherEntity2, new BookPdfContent(new byte[]{22, 11, 78}),
                new BookEdition(2), BookFormat.PAPERBACK, new BookIsbn("1382373383778"),
                LanguageCode.EN, new PublishDate(new Date(2130095302349L)), new BookWidth(new BigDecimal(33.77)),
                new BookLength(new BigDecimal(33.36)), new BookThickness(new BigDecimal(3.34)), UOM.IN);
    
    private final BookProcessor instance = new BookProcessor(facade);

    @Before
    public void setUp() {
        databaseManager.clear();
    }

    @After
    public void tearDown() {
        databaseManager.clear();
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {
        BookPojo expResult = instance.save(book1);
        BookPojo result = instance.retrieve(book1);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {
        assertNull(instance.retrieve(book1));
    }
    
    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        BookPojo result = instance.doSave(book1);
        assertEquals(0, result.getId());
        assertTrue(result.hasSameParameters(book1));
        assertTrue(book1.hasSameParameters(result));
    }
    
    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {
        
        BookPojo expResult = instance.save(book1);        
        BookPojo result = instance.doSave(book1);
        assertEquals(expResult, result);
    }
    
        
    /**
     * Test of doSave method.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoSave_again_excepton() {
        
        instance.save(book1);        
        instance.doSave(book2);
    }
}
