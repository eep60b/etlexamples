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
 * The DatabaseUtilitiesFactory class
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class DatabaseUtilitiesFactory {

    private static final PostgresDatabaseUtilities POSTGRES_DATABASE_UTILITIES = new PostgresDatabaseUtilities();
    private static final MicrosoftSqlDatabaseUtilites MICROSOFT_SQL_DATABASE_UTILITES = new MicrosoftSqlDatabaseUtilites();
    private static final MysqlDatabaseUtilities MYSQL_DATABASE_UTILITIES = new MysqlDatabaseUtilities();
    private static final OracleDatabaseUtilities ORACLE_DATABASE_UTILITIES = new OracleDatabaseUtilities();

    private DatabaseUtilitiesFactory (){
    }
    
    /**
     * 
     * @param type
     * @return 
     */
    public static final AbstractDatabaseUtilities getDatabaseUtilities(DatabaseType type) {
        switch (type) {

            case MICROSOFT_SQL_SERVER:
                return MICROSOFT_SQL_DATABASE_UTILITES;
            case MYSQL:
                return MYSQL_DATABASE_UTILITIES;
            case ORACLE:
                return ORACLE_DATABASE_UTILITIES;
            case POSTGRES:
                return POSTGRES_DATABASE_UTILITIES;

            default:
                throw new IllegalStateException("Invalid database type.");
        }
    }
}
