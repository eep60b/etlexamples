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
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.ShoppingCartItem;
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
import com.etlsolutions.examples.data.specific.purchase.ShoppingCartItemEntity;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ShoppingCartItemPojo;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ShoppingCartItemProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ShoppingCartItemProcessorTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final PersonalTitle titleColumn = new PersonalTitle("Mr.");
    private final GivenName givenNameColumn = new GivenName("Zak");
    private final FamilyName familyNameColumn = new FamilyName("Kongs");
    private final Date dateOfBith = new Date(3210129019L);
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(dateOfBith);
    private final byte[] profile = {1, 4};
    private final PersonalProfile profileColumn = new PersonalProfile(profile);
    private final PersonalDetail personalDetail = new PersonalDetailEntity(titleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);
    private final AddressEntity customerAddressEntry = new AddressEntity(new AddressHouse("dk9"), new AddressStreet("1 Faska Adda"), new AddressAdditionalInformation("kll l"), new AddressArea("Akrea"), new AddressCity("ciy"), new AddressCountry("UN"), new AddressPostcode("pos x"));
    private final PersonAddressLink personalAddressLink = new PersonAddressLinkEntity(customerAddressEntry, personalDetail, AddressType.CONTACT);

    private final ImageBytes customerImageColumn = new ImageBytes(new byte[]{68, 121, 3});
    private final PersonalUsername usernameColumn = new PersonalUsername("usnameA");
    private final PersonalPassword passwordColumn = new PersonalPassword("padadnk");

    private final Customer customer = new CustomerEntity(personalAddressLink, customerImageColumn, passwordColumn, usernameColumn);
    
        private final ItemAvailabilityNumber availabilityNumberColumn = new ItemAvailabilityNumber(5);
    private final ItemDescription descriptionColumn = new ItemDescription("this is an item..bblla");
    private final ItemImage itemImageColumn = new ItemImage(new byte[]{44, 51, 22, 67});
    private final NameWrapper nameColumn = new NameWrapper("item kO.");
    private final ItemRanking ranking = new ItemRanking(28677);
    private final ListPrice listPrice = new ListPrice(new BigDecimal(65.33));
    private final SalePrice salePrice = new SalePrice(new BigDecimal(34.66));
    private final ItemBarcode barcode = new ItemBarcode("0348915613822381");
    
    private final ItemCommonDetail itemCommonDetail = new ItemCommonDetailEntity(CurrencyCode.USD, 
            AvailabilityType.YES, availabilityNumberColumn, descriptionColumn, itemImageColumn, nameColumn,
            ranking,listPrice, salePrice, barcode);
    
    
    private final QuantityWapper quantityColumn = new QuantityWapper(12);
    private final QuantityWapper quantityColumn3 = new QuantityWapper(24);
    
    private final ShoppingCartItem shoppingCartItem1 = new ShoppingCartItemEntity(customer, itemCommonDetail, quantityColumn);
    private final ShoppingCartItem shoppingCartItem2 = new ShoppingCartItemEntity(customer, itemCommonDetail, quantityColumn);
    private final ShoppingCartItem shoppingCartItem3 = new ShoppingCartItemEntity(customer, itemCommonDetail, quantityColumn3);
    
    private final ShoppingCartItemProcessor instance = new ShoppingCartItemProcessor(facade);

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

        ShoppingCartItemPojo expResult = instance.save(shoppingCartItem1);
        assertEquals(expResult, instance.retrieve(shoppingCartItem2));
    }
    
    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(shoppingCartItem1));
    }    

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        ShoppingCartItemPojo expResult = new ShoppingCartItemPojo(new CustomerPojo(new PersonAddressLinkPojo(new AddressPojo("dk9", "1 Faska Adda", "kll l", "ciy", "Akrea", "pos x", "UN"), new PersonalDetailPojo("Mr.", "Zak", "Kongs", new Date(3210129019L), new byte[]{1, 4}), AddressType.CONTACT), "usnameA", "padadnk", new byte[]{68, 121, 3}), 
                new ItemCommonDetailPojo("item kO.", new byte[]{44, 51, 22, 67}, new BigDecimal(65.33), new BigDecimal(34.66), CurrencyCode.USD, 28677, "this is an item..bblla", AvailabilityType.YES, 5, "0348915613822381"), 12);        
        
        ShoppingCartItemPojo result = instance.doSave(shoppingCartItem2);
        assertTrue(result.hasSameParameters(expResult));
        assertEquals(0, result.getId());
    }
    
 
    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_Existing() {

        ShoppingCartItemPojo expResult = instance.save(shoppingCartItem1);        
        assertEquals(expResult, instance.doSave(shoppingCartItem2));
    }   
    
    /**
     * Test of doSave method.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoSave_Exception() {

        instance.save(shoppingCartItem1);        
        instance.doSave(shoppingCartItem3);
    }    

}
