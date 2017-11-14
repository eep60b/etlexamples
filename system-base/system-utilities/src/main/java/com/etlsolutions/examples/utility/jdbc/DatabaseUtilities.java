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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * The DatabaseUtilities class is a utility class which provides functionalities to manage database systems.
 * 
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class DatabaseUtilities {

    private DatabaseUtilities() {
    }

    
    /**
     * 
     * @param type
     * @param properties
     * @return
     * @throws SQLException 
     */
    public static boolean recreateDatabase(DatabaseType type, Properties properties) throws SQLException {
        return DatabaseUtilitiesFactory.getDatabaseUtilities(type).recreateDatabase(properties);
    }

    /**
     * 
     * @param type
     * @param properties
     * @return
     * @throws SQLException 
     */
    public static boolean createUser(DatabaseType type, Properties properties) throws SQLException {
        return DatabaseUtilitiesFactory.getDatabaseUtilities(type).createUser(properties);
    }

    /**
     * 
     * @param type
     * @param properties
     * @return
     * @throws SQLException 
     */
    public static boolean removeUser(DatabaseType type, Properties properties) throws SQLException {
        return DatabaseUtilitiesFactory.getDatabaseUtilities(type).removeUser(properties);
    }

    /**
     * 
     * @param type
     * @param properties
     * @param file
     * @throws IOException
     * @throws SQLException 
     */
    public static void runScripts(DatabaseType type, Properties properties, File file) throws IOException, SQLException {

        try (FileInputStream inputStream = new FileInputStream(file)) {
            DatabaseUtilitiesFactory.getDatabaseUtilities(type).runScripts(properties, inputStream);
        }
    }

    /**
     * 
     * @param type
     * @param properties
     * @param file
     * @param fileExtensions
     * @throws SQLException
     * @throws IOException 
     */
    public static void runScripts(DatabaseType type, Properties properties, File file, List<String> fileExtensions) throws SQLException, IOException {

        if (file.isFile()) {
            for (String extension : fileExtensions) {
                if (file.getName().endsWith(extension)) {
                    runScripts(type, properties, file);
                }
            }
        }

        if (file.isDirectory()) {
            File[] children = file.listFiles();

            for (File child : children) {
                runScripts(type, properties, child, fileExtensions);
            }
        }
    }
}
