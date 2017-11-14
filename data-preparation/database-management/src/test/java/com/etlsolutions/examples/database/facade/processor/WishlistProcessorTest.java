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
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
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
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.HibernateUtil;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.WishlistPojo;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class WishlistProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class WishlistProcessorTest {

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
    private final Customer customer1 = new CustomerEntity(personAddressLink, new ImageBytes(new byte[]{22, 33, 11, 66, 77}), new PersonalPassword("aldafallad"), new PersonalUsername("inakkkdal"));

    private final NameWrapper wishlistNameColumn1 = new NameWrapper("wish 1");
    private final NameWrapper wishlistNameColumn2 = new NameWrapper("wish 1");
    
    private final Wishlist wishlist1 = new WishlistEntity(customer1, wishlistNameColumn1);
    private final Wishlist wishlist2 = new WishlistEntity(customer1, wishlistNameColumn2);

    private final WishlistProcessor instance = new WishlistProcessor(facade);

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

        WishlistPojo expResult = instance.save(wishlist1);
        assertEquals(expResult, instance.retrieve(wishlist2));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(wishlist1));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {
        WishlistPojo expResult = new WishlistPojo(new CustomerPojo(new PersonAddressLinkPojo(new AddressPojo("dk9", "832 llps kxy", "f f", "Potou", "mancester", "K1432", "UN"), 
                new PersonalDetailPojo("Mr.", "Zak", "Kongs", dateOfBith, profile), AddressType.CONTACT), "inakkkdal", "aldafallad", new byte[]{22, 33, 11, 66, 77}), "wish 1");
        WishlistPojo result = instance.doSave(wishlist1);
        assertEquals(0, result.getId());
        assertTrue(result.hasSameParameters(expResult));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {

        WishlistPojo expResult = instance.save(wishlist1);
        assertEquals(expResult, instance.doSave(wishlist2));
    }
}
