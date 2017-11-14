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
package com.etlsolutons.examples.dataretrieval.dao;

import com.etlsolutons.examples.dataretrieval.model.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * The JdbcInvoiceDao class
 *
 * @author Zhipeng Chang
 */
//TODO: Implementation. Add tests. Add Java docs. Add annotations.
public class JdbcInvoiceDao implements InvoiceDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Invoice findById(int id) throws SQLException {

        String sql = "SELECT * FROM INVOICE WHERE ID = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Invoice invoice = null;
            rs = ps.executeQuery();
            if (rs.next()) {
                invoice = new Invoice(
                        rs.getInt("ID"),
                        rs.getInt("BOOK_ID"),
                        rs.getInt("CUSTOMER_ID"),
                        rs.getDouble("AMOUNT")
                );
            }
            return invoice;
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
