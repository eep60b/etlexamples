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

import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.AuthorBookLink;
import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.LanguageCode;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.UOM;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAuthorBookLink;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.book.AuthorBookLinkEntity;
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
import com.etlsolutions.examples.data.specific.person.AuthorEntity;
import com.etlsolutions.examples.data.specific.person.PersonalBiography;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.WebpageUrl;
import com.etlsolutions.examples.data.specific.book.PublisherEntity;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.HibernateUtil;
import com.etlsolutions.examples.database.hibernate.pojo.AuthorBookLinkPojo;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AuthorBookLinkProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AuthorBookLinkProcessorTest {

    private final SessionFactory factory = HibernateUtil.getSessionFactory("hibernate-test.cfg.xml");
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

    private final PersonalBiography biographyColumn = new PersonalBiography(new byte[]{44, 66});
    private final WebpageUrl webpageUrlColumn = new WebpageUrl("http://www.my.page");
    private final ImageBytes imageColumn = new ImageBytes(new byte[]{33, 32});

    private final Author author = new AuthorEntity(personalDetail, biographyColumn, webpageUrlColumn, imageColumn);

    private final AddressStreet addressMainColumn = new AddressStreet("832 llps kxy");
    private final AddressAdditionalInformation addressAdditionalColumn = new AddressAdditionalInformation("f f");
    private final AddressArea addressAreaColumn = new AddressArea("mancester");
    private final AddressCity addressCityColumn = new AddressCity("Potou");
    private final AddressCountry addressCountryColumn = new AddressCountry("UN");
    private final AddressPostcode addressPostcodeColumn = new AddressPostcode("K1432");
    private final AddressEntity addressEntity = new AddressEntity(new AddressHouse("3321"), addressMainColumn, addressAdditionalColumn, addressAreaColumn, addressCityColumn, addressCountryColumn, addressPostcodeColumn);

    private final ItemCommonDetailEntity itemCommonDetailEntity = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, new ItemAvailabilityNumber(32),
            new ItemDescription("ff dsknk"), new ItemImage(new byte[]{35, 63, 22}), new NameWrapper("ite name"),
            new ItemRanking(23921), new ListPrice(), SalePrice.ZERO, new ItemBarcode("fadaalfdkank"));
    private final PublisherEntity publisherEntity = new PublisherEntity(addressEntity, new NameWrapper("kaak publ ish"));

    private final Book book = new BookEntity(itemCommonDetailEntity, publisherEntity, new BookPdfContent(new byte[]{22, 11, 78}),
            new BookEdition(2), BookFormat.PAPERBACK, new BookIsbn("1382373383778"),
            LanguageCode.EN, new PublishDate(new Date(2130095302349L)), new BookWidth(new BigDecimal(33.77)),
            new BookLength(new BigDecimal(33.36)), new BookThickness(new BigDecimal(3.34)), UOM.IN);

    private final AuthorBookLink authorBookLink1 = new AuthorBookLinkEntity(author, book);
    private final AuthorBookLink authorBookLink2 = new AuthorBookLinkEntity(author, book);
    private final AuthorBookLink authorBookLink3 = new AuthorBookLinkEntity(author, book);

    private final AuthorBookLinkProcessor instance = new AuthorBookLinkProcessor(facade);

    @Before
    public void setUp() throws Exception {
        databaseManager.clear();
    }

    @After
    public void tearDown() throws Exception {
        databaseManager.clear();
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave() {

        AuthorBookLink expResult = new AuthorBookLinkEntity(author, book);
        AuthorBookLink result = instance.save(authorBookLink1);
        assertTrue(expResult.hasSameParameters(result));
    }
    
    /**
     * Test of save method.
     */
    @Test
    public void testSave_again() {

        IdentifiableAuthorBookLink expResult = instance.save(authorBookLink1);
        IdentifiableAuthorBookLink result = instance.save(authorBookLink1);
        assertEquals(expResult.getAuthorId(), result.getAuthorId());       
        assertEquals(expResult.getBookId(), result.getBookId()); 
        assertTrue(result.hasSameParameters(expResult));
    }        

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {

        IdentifiableAuthorBookLink expResult = instance.save(authorBookLink1);
        AuthorBookLinkPojo result = instance.retrieve(authorBookLink1);
        assertEquals(expResult.getAuthorId(), result.getAuthorId());       
        assertEquals(expResult.getBookId(), result.getBookId());         
        assertTrue(result.hasSameParameters(expResult));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(authorBookLink1));
    }
}
