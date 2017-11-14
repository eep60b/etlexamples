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

import com.etlsolutions.examples.utility.StringUtilities;
import static com.etlsolutions.examples.utility.jdbc.DatabaseConstantKeys.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.postgresql.ds.PGPoolingDataSource;

/**
 * The PostgresDatabaseUtilities class
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PostgresDatabaseUtilities extends AbstractDatabaseUtilities {

    private final Object lock = new Object();
    private final Logger logger = Logger.getLogger(PostgresDatabaseUtilities.class);

    @Override
    public boolean recreateDatabase(Properties properties) throws SQLException {

        String databaseName = properties.getProperty(TO_BE_CREATED_DATABASE_NAME).trim().toLowerCase();
        String owner = properties.getProperty(OWNER).trim().toLowerCase();
        String encoding = properties.getProperty(ENCODING);
        String lcCollate = properties.getProperty(LC_COLLATE);
        String lcCtype = properties.getProperty(LC_CTYPE);
        String connectionLimit = properties.getProperty(CONNECTION_LIMIT);
        String dropStatement = "DROP DATABASE IF EXISTS " + databaseName.trim().toLowerCase() + ";";
        String createStatement = "CREATE DATABASE " + databaseName + " WITH OWNER = " + owner + " ENCODING = '" + encoding + "' LC_COLLATE = '" + lcCollate + "' LC_CTYPE = '" + lcCtype + "' CONNECTION LIMIT = " + connectionLimit + ";";
        String checkDatabaseExisting = "SELECT 1 FROM pg_database WHERE datname='" + databaseName + "';";

        synchronized (lock) {
            try (Connection connection = getDataSource(properties).getConnection(); Statement stmt = connection.createStatement();) {
                stmt.execute(dropStatement);
                stmt.execute(createStatement);
                return stmt.executeQuery(checkDatabaseExisting).next();
            }
        }
    }

    @Override
    public boolean createUser(Properties properties) throws SQLException {

        String newUser = properties.getProperty(TO_BE_CREATED_USER).trim().toLowerCase();

        String checkUserExistStatement = "SELECT 1 FROM pg_roles WHERE rolname='" + newUser + "';";

        boolean isSuperuser = StringUtilities.getBooleanValue(properties.getProperty(IS_SUPERUSER));
        boolean isInherit = StringUtilities.getBooleanValue(properties.getProperty(IS_INHERIT));
        boolean canCreateDB = StringUtilities.getBooleanValue(properties.getProperty(CAN_CREATEDB));
        boolean canCreateRole = StringUtilities.getBooleanValue(properties.getProperty(CAN_CREATEROLE));
        boolean isReplication = StringUtilities.getBooleanValue(properties.getProperty(IS_REPLICATION));
        String createUserStatement = "CREATE ROLE " + newUser + " LOGIN ENCRYPTED PASSWORD '" + properties.getProperty(TO_BE_CREATED_USER_PASSWORD)
                + (isSuperuser ? "' SUPERUSER " : "' NOSUPERUSER ") + (isInherit ? "INHERIT " : "NOINHERIT ") + (canCreateDB ? "CREATEDB " : "NOCREATEDB ")
                + (canCreateRole ? "CREATEROLE " : "NOCREATEROLE ") + (isReplication ? "NOREPLICATION;" : "NOREPLICATION;");
        synchronized (lock) {
            try (Connection connection = getDataSource(properties).getConnection(); Statement stmt = connection.createStatement();) {

                if (stmt.executeQuery(checkUserExistStatement).next()) {
                    logger.warn("The user [" + newUser + "] already exists. The create user operation has NOT been processed.");
                    return false;
                }

                stmt.execute(createUserStatement);
                return stmt.executeQuery(checkUserExistStatement).next();
            }
        }
    }

    @Override
    public boolean removeUser(Properties properties) throws SQLException {

        String userToBeDeleted = properties.getProperty(TO_BE_DELETED_USER).trim().toLowerCase();

        String checkUserExistStatement = "SELECT 1 FROM pg_roles WHERE rolname='" + userToBeDeleted + "';";
        String dropOwnedStatement = "DROP OWNED BY " + userToBeDeleted + " CASCADE;";
        String dropStatement = "DROP ROLE IF EXISTS " + userToBeDeleted + ";";

        synchronized (lock) {
            try (Connection connection = getDataSource(properties).getConnection(); Statement stmt = connection.createStatement();) {

                if (!stmt.executeQuery(checkUserExistStatement).next()) {
                    logger.info("The user [" + userToBeDeleted + "] does not exist. The drop role operation has NOT been processed.");
                    return false;
                }

                stmt.execute(dropOwnedStatement);
                stmt.execute(dropStatement);
                return !stmt.executeQuery(checkUserExistStatement).next();
            }
        }
    }

    @Override
    public void runScripts(Properties properties, InputStream inputStream) throws SQLException, IOException {
        synchronized (lock) {
            PGPoolingDataSource source = getDataSource(properties);
            try (Connection connection = source.getConnection()) {
               
                runScripts(inputStream, connection);

            } finally {
                //It is important to close both the connection and the source to end the connection session.
                source.close();
            }
        }
    }

    private PGPoolingDataSource getDataSource(Properties properties) {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        String dataSourceName = properties.getProperty(DATASOURCE_NAME);
        if (dataSourceName == null || dataSourceName.trim().isEmpty()) {
            dataSourceName = String.valueOf(UUID.randomUUID().getLeastSignificantBits());
        }
        dataSource.setDataSourceName(dataSourceName);
        dataSource.setServerName(properties.getProperty(SERVER_NAME).trim().toLowerCase());
        dataSource.setDatabaseName(properties.getProperty(CONNECTION_DATABASE_NAME).trim().toLowerCase());
        dataSource.setUser(properties.getProperty(CONNECTION_USER).trim().toLowerCase());
        dataSource.setPassword(properties.getProperty(CONNECTION_PASSWORD));
        return dataSource;
    }
}
