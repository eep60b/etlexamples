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
package com.etlsolutions.examples.utility.jdbc;

import static com.etlsolutions.examples.utility.jdbc.DatabaseConstantKeys.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.postgresql.ds.PGPoolingDataSource;

/**
 * Test of class PostgresDatabaseUtilities.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PostgresDatabaseUtilitiesTest {

    private final Properties properties = new Properties();
    private final PostgresDatabaseUtilities instance = new PostgresDatabaseUtilities();

    @Before
    public void setUp() throws SQLException {
        PGPoolingDataSource source1 = new PGPoolingDataSource();
        source1.setDataSourceName(String.valueOf(UUID.randomUUID().getLeastSignificantBits()));
        source1.setServerName("192.168.250.148");
        source1.setDatabaseName("postgres");
        source1.setUser("datahubdev");
        source1.setPassword("youlneverguessthis");
        source1.setPortNumber(5432);
        Connection c = source1.getConnection();
        Statement stmt = c.createStatement();
        stmt.execute("DROP DATABASE IF EXISTS datahubABK;");        
        stmt.execute("DROP ROLE IF EXISTS datahubtesta;");
        c.close();
        source1.close();

        properties.setProperty(CONNECTION_DATABASE_NAME, "postgres");
        properties.setProperty(DATASOURCE_NAME, String.valueOf(UUID.randomUUID().getLeastSignificantBits()));
        properties.setProperty(SERVER_NAME, "192.168.250.148");
        properties.setProperty(CONNECTION_PASSWORD, "youlneverguessthis");
        properties.setProperty(CONNECTION_USER, "datahubdev"); 
        properties.setProperty(OWNER, "datahubtestA");
        properties.setProperty(ENCODING, "UTF8");
        properties.setProperty(LC_COLLATE, "en_GB.UTF-8");
        properties.setProperty(LC_CTYPE, "en_GB.UTF-8");
        properties.setProperty(CONNECTION_LIMIT, "-1");
        properties.setProperty(TO_BE_CREATED_DATABASE_NAME, "datahubABK");        
        properties.setProperty(TO_BE_CREATED_USER, "datahubtestA");
        properties.setProperty(TO_BE_CREATED_USER_PASSWORD, "fssfssfssss");        
        
    }
    
    @After
    public void tearDown() throws SQLException {
        PGPoolingDataSource source1 = new PGPoolingDataSource();
        source1.setDataSourceName(String.valueOf(UUID.randomUUID().getLeastSignificantBits()));
        source1.setServerName("192.168.250.148");
        source1.setDatabaseName("postgres");
        source1.setUser("datahub");
        source1.setPassword("youlneverguessthis");
        source1.setPortNumber(5432);
        Connection c = source1.getConnection();
        Statement stmt = c.createStatement();
        stmt.execute("DROP DATABASE IF EXISTS datahubABK;");    
        stmt.execute("DROP ROLE IF EXISTS datahubtesta;");        
        c.close();
        source1.close();                    
    }

    /**
     * Test of recreateDatabase method.
     *
     * @throws Exception if an error occur.
     */
    @Test
    public void testRecreateDatabase() throws Exception {
        properties.setProperty(DATASOURCE_NAME, String.valueOf(UUID.randomUUID().getLeastSignificantBits()));   
        instance.createUser(properties);
        properties.setProperty(DATASOURCE_NAME, String.valueOf(UUID.randomUUID().getLeastSignificantBits()));                  
        assertTrue(instance.recreateDatabase(properties));
    }

    /**
     * Test of createUser method.
     *
     * @throws Exception if an error occur.
     */
    @Test
    public void testCreateUser() throws Exception {
        
        properties.setProperty(DATASOURCE_NAME, String.valueOf(UUID.randomUUID().getLeastSignificantBits()));
        assertTrue(instance.createUser(properties));
    }

    /**
     * Test of removeUser method.
     *
     * @throws Exception if an error occur.
     */
    @Test
    public void testRemoveUser() throws Exception {
        
        properties.setProperty(DATASOURCE_NAME, String.valueOf(UUID.randomUUID().getLeastSignificantBits()));
        properties.setProperty(TO_BE_DELETED_USER, "datahubtestA");
        assertFalse(instance.removeUser(properties));

        properties.setProperty(DATASOURCE_NAME, String.valueOf(UUID.randomUUID().getLeastSignificantBits()));        
        instance.createUser(properties);
        properties.setProperty(DATASOURCE_NAME, String.valueOf(UUID.randomUUID().getLeastSignificantBits()));  
        assertTrue(instance.removeUser(properties));

    }

    /**
     * Test of runScripts method.
     *
     * @throws Exception if an error occur.
     */
    @Test
    public void testRunScripts() throws Exception {
        
        Properties properties1 = new Properties();
        properties1.setProperty(CONNECTION_DATABASE_NAME, "postgres");
        properties1.setProperty(CONNECTION_USER, "datahub");
        properties1.setProperty(SERVER_NAME, "192.168.250.148");
        properties1.setProperty(CONNECTION_PASSWORD, "youlneverguessthis");        
        properties1.setProperty(TO_BE_CREATED_USER, "datahubtestA");       
        properties1.setProperty(TO_BE_CREATED_USER_PASSWORD, "fssfssfssss"); 
        properties1.setProperty(IS_SUPERUSER, "true");
        properties1.setProperty(CAN_CREATEDB, "true");        
        instance.createUser(properties1);
        
        Properties properties2 = new Properties();
        properties2.setProperty(CONNECTION_DATABASE_NAME, "postgres");
        properties2.setProperty(CONNECTION_USER, "datahub");
        properties2.setProperty(SERVER_NAME, "192.168.250.148");
        properties2.setProperty(CONNECTION_PASSWORD, "youlneverguessthis");           
        properties2.setProperty(TO_BE_CREATED_DATABASE_NAME, "datahubABK");
        properties2.setProperty(OWNER, "datahubtestA");        
        properties2.setProperty(ENCODING, "UTF8");
        properties2.setProperty(LC_COLLATE, "en_GB.UTF-8");
        properties2.setProperty(LC_CTYPE, "en_GB.UTF-8");
        properties2.setProperty(CONNECTION_LIMIT, "-1");        
        instance.recreateDatabase(properties2);
        
        Properties properties3 = new Properties();
        properties3.setProperty(DATASOURCE_NAME, String.valueOf(UUID.randomUUID().getLeastSignificantBits()));         
        properties3.setProperty(CONNECTION_DATABASE_NAME, "datahubABK");
        properties3.setProperty(CONNECTION_USER, "datahubtestA");
        properties3.setProperty(SERVER_NAME, "192.168.250.148");
        properties3.setProperty(CONNECTION_PASSWORD, "fssfssfssss");
        
        try (InputStream inputStream = PostgresDatabaseUtilities.class.getResourceAsStream("/sql/postgres/PostgresDatabaseUtilitiesTest/test-script.sql")) {

            instance.runScripts(properties3, inputStream);
        }
    }
}
