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
package com.etlsolutions.examples.database;

import com.etlsolutions.examples.database.hibernate.HibernateUtil;

/**
 * The DatabasePopulaterCommandLineRunner class provides a main method to
 * populate the entire database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Final
 */
public final class DatabasePopulaterCommandLineRunner {

    /**
     * The main method of the application.
     *
     * @param args - The arguments.
     */
    public static void main(String... args) {
        DatabaseManager populater = new DatabaseManager(HibernateUtil.getSessionFactory(args.length == 0 ? "hibernate.cfg.xml" : args[0]));
        populater.populate();
    }
}
