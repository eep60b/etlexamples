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

/**
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public enum DatabaseType {

    /**
     * 
     */
    POSTGRES("org.postgresql.Driver"),
    
    /**
     * 
     */
    ORACLE("oracle.jdbc.driver.OracleDriver"),
    
    /**
     * 
     */
    MYSQL("org.gjt.mm.mysql.Driver"),
    
    /**
     * 
     */
    MICROSOFT_SQL_SERVER("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    private final String driver;

    
    private DatabaseType(String driver) {
        this.driver = driver;
    }

    /**
     * Get the JDBC driver string for this database type.
     * @return 
     */
    public String getDriver() {
        return driver;
    }

}
