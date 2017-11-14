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
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Review;
import com.etlsolutions.examples.data.api.Reviewer;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.specific.item.ItemAvailabilityNumber;
import com.etlsolutions.examples.data.specific.item.ItemBarcode;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.data.specific.item.ItemDescription;
import com.etlsolutions.examples.data.specific.item.ItemImage;
import com.etlsolutions.examples.data.specific.item.ItemRanking;
import com.etlsolutions.examples.data.specific.item.ListPrice;
import com.etlsolutions.examples.data.specific.item.SalePrice;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.PersonalPassword;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.ReviewerEntity;
import com.etlsolutions.examples.data.specific.person.PersonalUsername;
import com.etlsolutions.examples.data.specific.item.ReviewEntity;
import com.etlsolutions.examples.data.specific.item.ReviewRanking;
import com.etlsolutions.examples.data.specific.item.ReviewText;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.ReviewPojo;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ReviewProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ReviewProcessorTest {

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

    private final PersonalTitle titleColumn = new PersonalTitle("Mr.");
    private final GivenName givenNameColumn = new GivenName("Zak");
    private final FamilyName familyNameColumn = new FamilyName("Kongs");
    private final Date dateOfBith = new Date(3210129019L);
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(dateOfBith);
    private final byte[] profile = {1, 4};
    private final PersonalProfile profileColumn = new PersonalProfile(profile);

    private final PersonalDetail personalDetail = new PersonalDetailEntity(titleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);

    private final Reviewer reviewer = new ReviewerEntity(personalDetail, new PersonalUsername("9alfdalfa"), new PersonalPassword("1348qeajsdfl"), new ImageBytes(new byte[]{38, 92, 17}));

    private final Review review1 = new ReviewEntity(itemCommonDetail, new ReviewRanking(12837), new ReviewText("diandk lada "), reviewer);
    private final Review review2 = new ReviewEntity(itemCommonDetail, new ReviewRanking(12837), new ReviewText("diandk lada "), reviewer);
    private final Review review3 = new ReviewEntity(itemCommonDetail, new ReviewRanking(37), new ReviewText("diandk lada "), reviewer);

    private final ReviewProcessor instance = new ReviewProcessor(facade);

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

        ReviewPojo expResult = instance.save(review1);
        
        assertEquals(expResult, instance.retrieve(review1));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(review1));
    }

    /**
     * Test of doSave method, of class ReviewProcessor.
     */
    @Test
    public void testDoSave() {

        ReviewPojo result = instance.doSave(review1);
        assertEquals(0, result.getId());
        assertTrue(result.hasSameParameters(review1));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {

        ReviewPojo expResult = instance.save(review1);
        assertEquals(expResult, instance.doSave(review1));
        assertEquals(expResult, instance.doSave(review2));
    }

    /**
     * Test of doSave method.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoSave_Exception() {

        instance.save(review1);
        instance.save(review3);
    }
}
