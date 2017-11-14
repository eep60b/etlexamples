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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * The JdbcCustomerDao class
 *
 * @author Zhipeng Chang
 */
//TODO: Implementation. Add tests. Add Java docs. Add annotations.
public class JdbcCustomerDao implements CustomerDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Customer findById(int id) throws SQLException {

        String customerSql = "SELECT p.GIVEN_NAME, p.FAMILY_NAME FROM PERSONAL_DETAIL p, CUSTOMER c WHERE c.CUSTOMER_ID = ? "
                + "AND p.PERSONAL_DETAIL_ID = c.PERSONAL_DETAIL_ID";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(customerSql);
            ps.setInt(1, id);
            Customer customer = null;
            rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer(
                        rs.getInt("ID"),
                        rs.getString("GIVEN_NAME"),
                        rs.getString("FAMILY_NAME")
                );
            }
            return customer;
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }
}
