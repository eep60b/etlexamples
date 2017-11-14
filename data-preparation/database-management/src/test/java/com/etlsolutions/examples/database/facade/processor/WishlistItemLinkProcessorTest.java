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

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.data.api.WishlistItemLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableWishlistItemLink;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
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
import com.etlsolutions.examples.data.specific.purchase.WishlistEntity;
import com.etlsolutions.examples.data.specific.purchase.WishlistItemLinkEntity;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.HibernateUtil;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class WishlistItemLinkProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class WishlistItemLinkProcessorTest {

    private final SessionFactory factory = HibernateUtil.getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final AddressStreet addressMainColumn = new AddressStreet("832 llps kxy");
    private final AddressAdditionalInformation addressAdditionalColumn = new AddressAdditionalInformation("f f");
    private final AddressArea addressAreaColumn = new AddressArea("mancester");
    private final AddressCity addressCityColumn = new AddressCity("Potou");
    private final AddressCountry addressCountryColumn = new AddressCountry("UN");
    private final AddressPostcode addressPostcodeColumn = new AddressPostcode("K1432");
    private final Address address = new AddressEntity(new AddressHouse("dk9"), addressMainColumn, addressAdditionalColumn, addressAreaColumn, addressCityColumn, addressCountryColumn, addressPostcodeColumn);

    private final PersonalTitle titleColumn = new PersonalTitle("Mr.");
    private final GivenName givenNameColumn = new GivenName("Zak");
    private final FamilyName familyNameColumn = new FamilyName("Kongs");
    private final Date dateOfBith = new Date(3210129019L);
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(dateOfBith);
    private final byte[] profile = {1, 4};
    private final PersonalProfile profileColumn = new PersonalProfile(profile);
    private final PersonalDetail personalDetail = new PersonalDetailEntity(titleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);

    private final PersonAddressLink personAddressLink = new PersonAddressLinkEntity(address, personalDetail, AddressType.CONTACT);
    private final Customer customer = new CustomerEntity(personAddressLink, new ImageBytes(new byte[]{22, 33, 11, 66, 77}), new PersonalPassword("aldafallad"), new PersonalUsername("inakkkdal"));

    private final NameWrapper wishlistNameColumn = new NameWrapper("wish 1");

    private final Wishlist wishlist = new WishlistEntity(customer, wishlistNameColumn);

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

    private final WishlistItemLink wishlistItemLink1 = new WishlistItemLinkEntity(itemCommonDetail, wishlist);
    private final WishlistItemLink wishlistItemLink2 = new WishlistItemLinkEntity(itemCommonDetail, wishlist);
    
    private final WishlistItemLinkProcessor instance = new WishlistItemLinkProcessor(facade);

    @Before
    public void setUp() {
        databaseManager.clear();
    }

    @After
    public void tearDown() {
        databaseManager.clear();
    }

    /**
     * Test of save method
     */
    @Test
    public void testSave() {

        IdentifiableWishlistItemLink result = instance.save(wishlistItemLink1);
        assertTrue(result.hasSameParameters(wishlistItemLink2));
    }

 
    /**
     * Test of save method
     */
    @Test
    public void testSave_again() {

        IdentifiableWishlistItemLink expResult = instance.save(wishlistItemLink1);
        assertEquals(expResult, instance.save(wishlistItemLink2));
    }   
    
    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {

        IdentifiableWishlistItemLink expResult = instance.save(wishlistItemLink1);
        assertEquals(expResult, instance.retrieve(wishlistItemLink2));
    }
    
    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {
        
        assertNull(instance.retrieve(wishlistItemLink1));
    }    
}
