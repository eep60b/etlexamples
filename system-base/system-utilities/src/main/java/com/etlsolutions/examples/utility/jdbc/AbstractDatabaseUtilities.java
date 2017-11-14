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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 * The AbstractDatabaseUtilities class is an abstract class which process database tasks.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public abstract class AbstractDatabaseUtilities {

    /**
     * Re-create the database using the parameter inside the given Properties
     * object. If the database already exists, it will be dropped before the new
     * database is created.
     *
     * @param properties - The given Properties object.
     * @return true if the database has been successfully re-created.
     * @throws SQLException if there is an error during the process.
     */
    public abstract boolean recreateDatabase(Properties properties) throws SQLException;

    /**
     *
     * @param properties
     * @return
     * @throws SQLException
     */
    public abstract boolean createUser(Properties properties) throws SQLException;

    /**
     *
     * @param properties
     * @return
     * @throws SQLException
     */
    public abstract boolean removeUser(Properties properties) throws SQLException;

    /**
     * #
     * Run the scripts inputed from the given InputStream object.
     *
     * @param properties - The property used to create connection.
     * @param inputStream - The given input stream object.
     * @throws SQLException if an error occurs during the process.
     * @throws IOException if an IO error occurs during the process.
     */
    public abstract void runScripts(Properties properties, InputStream inputStream) throws SQLException, IOException;

    ;
    
    /**
     * Run the script provided by the given input stream.
     * @param inputStream - The given input stream.
     * @param connection - The database connection.
     * @throws IOException if an IO error occurs during the operation.
     */
    protected final void runScripts(InputStream inputStream, Connection connection) throws IOException {

        ScriptRunner r = new ScriptRunner(connection);
        r.setAutoCommit(true);
        r.setStopOnError(true);
        r.setSendFullScript(true);
        try (InputStreamReader reader = new InputStreamReader(inputStream)) {
            r.runScript(reader);
        }
    }
}
