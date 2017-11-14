/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.ha.pojo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zhipeng
 */
public class ReviewPojoTest {
    
    public ReviewPojoTest() {
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
     * Test of getId method, of class ReviewPojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ReviewPojo instance = new ReviewPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class ReviewPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        ReviewPojo instance = new ReviewPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemDetail method, of class ReviewPojo.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        ReviewPojo instance = new ReviewPojo();
        ItemCommonDetailPojo expResult = null;
        ItemCommonDetailPojo result = instance.getItemCommonDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class ReviewPojo.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        ItemCommonDetailPojo item = null;
        ReviewPojo instance = new ReviewPojo();
        instance.setItemCommonDetail(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReviewer method, of class ReviewPojo.
     */
    @Test
    public void testGetReviewer() {
        System.out.println("getReviewer");
        ReviewPojo instance = new ReviewPojo();
        ReviewerPojo expResult = null;
        ReviewerPojo result = instance.getReviewer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReviewer method, of class ReviewPojo.
     */
    @Test
    public void testSetReviewer() {
        System.out.println("setReviewer");
        ReviewerPojo reviewer = null;
        ReviewPojo instance = new ReviewPojo();
        instance.setReviewer(reviewer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReviewRanking method, of class ReviewPojo.
     */
    @Test
    public void testGetReviewRanking() {
        System.out.println("getReviewRanking");
        ReviewPojo instance = new ReviewPojo();
        int expResult = 0;
        int result = instance.getReviewRanking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReviewRanking method, of class ReviewPojo.
     */
    @Test
    public void testSetReviewRanking() {
        System.out.println("setReviewRanking");
        int reviewRanking = 0;
        ReviewPojo instance = new ReviewPojo();
        instance.setReviewRanking(reviewRanking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReviewText method, of class ReviewPojo.
     */
    @Test
    public void testGetReviewText() {
        System.out.println("getReviewText");
        ReviewPojo instance = new ReviewPojo();
        String expResult = "";
        String result = instance.getReviewText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReviewText method, of class ReviewPojo.
     */
    @Test
    public void testSetReviewText() {
        System.out.println("setReviewText");
        String reviewText = "";
        ReviewPojo instance = new ReviewPojo();
        instance.setReviewText(reviewText);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
