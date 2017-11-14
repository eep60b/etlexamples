/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.controller;

import com.etlsolutions.examples.database.entity.Administrator;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zc
 */
public class AdministratorJpaControllerTest {
    
    public AdministratorJpaControllerTest() {
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
     * Test of getEntityManager method, of class AdministratorJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        AdministratorJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class AdministratorJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Administrator administrator = null;
        AdministratorJpaController instance = null;
        instance.create(administrator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class AdministratorJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Administrator administrator = null;
        AdministratorJpaController instance = null;
        instance.edit(administrator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class AdministratorJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        AdministratorJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAdministratorEntities method, of class AdministratorJpaController.
     */
    @Test
    public void testFindAdministratorEntities_0args() {
        System.out.println("findAdministratorEntities");
        AdministratorJpaController instance = null;
        List<Administrator> expResult = null;
        List<Administrator> result = instance.findAdministratorEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAdministratorEntities method, of class AdministratorJpaController.
     */
    @Test
    public void testFindAdministratorEntities_int_int() {
        System.out.println("findAdministratorEntities");
        int maxResults = 0;
        int firstResult = 0;
        AdministratorJpaController instance = null;
        List<Administrator> expResult = null;
        List<Administrator> result = instance.findAdministratorEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAdministrator method, of class AdministratorJpaController.
     */
    @Test
    public void testFindAdministrator() {
        System.out.println("findAdministrator");
        Integer id = null;
        AdministratorJpaController instance = null;
        Administrator expResult = null;
        Administrator result = instance.findAdministrator(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdministratorCount method, of class AdministratorJpaController.
     */
    @Test
    public void testGetAdministratorCount() {
        System.out.println("getAdministratorCount");
        AdministratorJpaController instance = null;
        int expResult = 0;
        int result = instance.getAdministratorCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
