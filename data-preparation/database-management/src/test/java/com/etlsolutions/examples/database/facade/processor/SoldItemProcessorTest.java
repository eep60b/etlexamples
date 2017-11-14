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

import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.general.wrapper.QuantityWapper;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.data.specific.purchase.InvoiceDate;
import com.etlsolutions.examples.data.specific.purchase.InvoiceEntity;
import com.etlsolutions.examples.data.specific.purchase.InvoiceReferenceNumber;
import com.etlsolutions.examples.data.specific.purchase.InvoiceSubtotal;
import com.etlsolutions.examples.data.specific.item.ItemAvailabilityNumber;
import com.etlsolutions.examples.data.specific.item.ItemBarcode;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.data.specific.item.ItemDescription;
import com.etlsolutions.examples.data.specific.item.ItemImage;
import com.etlsolutions.examples.data.specific.item.ItemRanking;
import com.etlsolutions.examples.data.specific.item.ListPrice;
import com.etlsolutions.examples.data.specific.item.SalePrice;
import com.etlsolutions.examples.data.specific.person.CustomerEntity;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.PersonalPassword;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.PersonalUsername;
import com.etlsolutions.examples.data.specific.purchase.SoldItemEntity;
import com.etlsolutions.examples.data.specific.purchase.UnitPrice;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.SoldItemPojo;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class SoldItemProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class SoldItemProcessorTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final SoldItem soldItem1 = new SoldItemEntity(new InvoiceEntity(new CustomerEntity(
            new PersonAddressLinkEntity(new AddressEntity(new AddressHouse("127"), new AddressStreet("Timber Street"),
                            new AddressAdditionalInformation("addtional extrK"), new AddressArea("Yorkshire"),
                            new AddressCity("Hull"), new AddressCountry("England"), new AddressPostcode("YO11 5HU")),
                    new PersonalDetailEntity(new PersonalTitle("Mr."), new GivenName("TomTom"), new FamilyName("Holand"),
                            new DateOfBirth(new Date(134194894831989L)), new PersonalProfile(new byte[]{38, 91, 34})),
                    AddressType.CONTACT), new ImageBytes(new byte[]{92, 27, 48, 56, 66}), new PersonalPassword("132ojala;djl;aj`"),
            new PersonalUsername("usuuuser")), new AddressEntity(new AddressHouse("127"), new AddressStreet("Timber Street"),
                            new AddressAdditionalInformation("addtional extrK"), new AddressArea("Yorkshire"),
                            new AddressCity("Hull"), new AddressCountry("England"), new AddressPostcode("YO11 5HU")), 
            new InvoiceDate(new Date(3493419494941L)), new InvoiceSubtotal(new BigDecimal(432.33)), 
            new InvoiceReferenceNumber("dkalq3124"), InvoiceValidity.YES), new ItemCommonDetailEntity(CurrencyCode.USD, 
                    AvailabilityType.OUT_OF_STOCK, new ItemAvailabilityNumber(12), new ItemDescription("ggood items is here."), 
                    new ItemImage(new byte[]{47, 92, 11, 76}), new NameWrapper("yoko"), new ItemRanking(3428), 
                    new ListPrice(new BigDecimal(57.88)), new SalePrice(new BigDecimal(32.19)), new ItemBarcode("23ljqlwerjlqkrql")), 
            new QuantityWapper(45), new UnitPrice(new BigDecimal(35.99)));
    
    private final SoldItem soldItem2 = new SoldItemEntity(new InvoiceEntity(new CustomerEntity(
            new PersonAddressLinkEntity(new AddressEntity(new AddressHouse("127"), new AddressStreet("Timber Street"),
                            new AddressAdditionalInformation("addtional extrK"), new AddressArea("Yorkshire"),
                            new AddressCity("Hull"), new AddressCountry("England"), new AddressPostcode("YO11 5HU")),
                    new PersonalDetailEntity(new PersonalTitle("Mr."), new GivenName("TomTom"), new FamilyName("Holand"),
                            new DateOfBirth(new Date(134194894831989L)), new PersonalProfile(new byte[]{38, 91, 34})),
                    AddressType.CONTACT), new ImageBytes(new byte[]{92, 27, 48, 56, 66}), new PersonalPassword("132ojala;djl;aj`"),
            new PersonalUsername("usuuuser")), new AddressEntity(new AddressHouse("127"), new AddressStreet("Timber Street"),
                            new AddressAdditionalInformation("addtional extrK"), new AddressArea("Yorkshire"),
                            new AddressCity("Hull"), new AddressCountry("England"), new AddressPostcode("YO11 5HU")), 
            new InvoiceDate(new Date(3493419494941L)), new InvoiceSubtotal(new BigDecimal(432.33)), 
            new InvoiceReferenceNumber("dkalq3124"), InvoiceValidity.YES), new ItemCommonDetailEntity(CurrencyCode.USD, 
                    AvailabilityType.OUT_OF_STOCK, new ItemAvailabilityNumber(12), new ItemDescription("ggood items is here."), 
                    new ItemImage(new byte[]{47, 92, 11, 76}), new NameWrapper("yoko"), new ItemRanking(3428), 
                    new ListPrice(new BigDecimal(57.88)), new SalePrice(new BigDecimal(32.19)), new ItemBarcode("23ljqlwerjlqkrql")), 
            new QuantityWapper(45), new UnitPrice(new BigDecimal(35.99)));
    
        
    private final SoldItem soldItem3 = new SoldItemEntity(new InvoiceEntity(new CustomerEntity(
            new PersonAddressLinkEntity(new AddressEntity(new AddressHouse("127"), new AddressStreet("Timber Street"),
                            new AddressAdditionalInformation("addtional extrK"), new AddressArea("Yorkshire"),
                            new AddressCity("Hull"), new AddressCountry("England"), new AddressPostcode("YO11 5HU")),
                    new PersonalDetailEntity(new PersonalTitle("Mr."), new GivenName("TomTomA"), new FamilyName("Holand"),
                            new DateOfBirth(new Date(134194894831989L)), new PersonalProfile(new byte[]{38, 91, 34})),
                    AddressType.CONTACT), new ImageBytes(new byte[]{92, 27, 48, 56, 66}), new PersonalPassword("132ojala;djl;aj`"),
            new PersonalUsername("usuuuser")), new AddressEntity(new AddressHouse("127"), new AddressStreet("Timber Street"),
                            new AddressAdditionalInformation("addtional extrK"), new AddressArea("Yorkshire"),
                            new AddressCity("Hull"), new AddressCountry("England"), new AddressPostcode("YO11 5HU")), 
            new InvoiceDate(new Date(3493419494941L)), new InvoiceSubtotal(new BigDecimal(432.33)), 
            new InvoiceReferenceNumber("dkalq3124"), InvoiceValidity.YES), new ItemCommonDetailEntity(CurrencyCode.USD, 
                    AvailabilityType.OUT_OF_STOCK, new ItemAvailabilityNumber(12), new ItemDescription("ggood items is here."), 
                    new ItemImage(new byte[]{47, 92, 11, 76}), new NameWrapper("yoko"), new ItemRanking(3428), 
                    new ListPrice(new BigDecimal(57.88)), new SalePrice(new BigDecimal(32.19)), new ItemBarcode("23ljqlwerjlqkrql")), 
            new QuantityWapper(45), new UnitPrice(new BigDecimal(35.99)));

    private final SoldItemProcessor instance = new SoldItemProcessor(facade);

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

        SoldItemPojo expResult = instance.save(soldItem1);
        assertEquals(expResult, instance.retrieve(soldItem2));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(soldItem1));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        SoldItemPojo result = instance.doSave(soldItem1);
        assertEquals(0, result.getId());
        assertTrue(result.hasSameParameters(soldItem2));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {

        SoldItemPojo expResult = instance.save(soldItem1);
        assertEquals(expResult, instance.doSave(soldItem2));
    }
    
    
    /**
     * Test of doSave method.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoSave_Exception() {

        instance.save(soldItem1);
        instance.doSave(soldItem3);
    }
}
