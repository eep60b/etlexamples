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

package com.etlsolutions.examples.dataretrieval.dao;

import com.etlsolutions.examples.dataretrieval.model.Customer;
import java.sql.SQLException;

/**
 * The CustomerDao interface defines the methods to retrieve data from the BOOK table in the database.
 *
 * @author Zhipeng Chang
 * 
 * @version 1.0.0
 */

public interface CustomerDao {
    
        
    /**
     * find a row in the CUSTOMER table with the specified ID (primary key) then convert it into a Customer object. Return null if there is no such a row.
     * @param id - The given ID.
     * @return the valid Customer object or null
     * @throws SQLException if the process is failed due an SQL issue.
     */
    Customer findById(int id) throws SQLException ;
}
