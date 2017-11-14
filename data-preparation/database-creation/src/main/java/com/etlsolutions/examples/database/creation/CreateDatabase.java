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
package com.etlsolutions.examples.database.creation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.ds.PGPoolingDataSource;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class CreateDatabase {

    public static void main(String[] args) throws SQLException {
        PGPoolingDataSource source1 = new PGPoolingDataSource();
        source1.setDataSourceName("postgres Source");
        source1.setServerName("192.168.250.148");
        source1.setDatabaseName("postgres");
        source1.setUser("datahubdev");
        source1.setPassword("youlneverguessthis");
        source1.setMaxConnections(10);
        Connection c = source1.getConnection();
        Statement stmt = c.createStatement();
        
        stmt.execute("SELECT 1 FROM pg_roles WHERE rolname='datahubtest';");
        System.out.println(stmt.getResultSet().next());
        
        stmt.execute("DROP ROLE IF EXISTS datahubtest;");
        
        stmt.execute("CREATE ROLE datahubtest LOGIN ENCRYPTED PASSWORD 'youlneverguessthis' SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;");        
        stmt.execute("DROP DATABASE IF EXISTS datahubtest;");
        stmt.execute("CREATE DATABASE datahubtest\n"
                + "  WITH OWNER = datahubdev\n"
                + "       ENCODING = 'UTF8'\n"
                + "       LC_COLLATE = 'en_GB.UTF-8'\n"
                + "       LC_CTYPE = 'en_GB.UTF-8'\n"
                + "       CONNECTION LIMIT = -1;");
    }
}
