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

package com.etlsolutions.examples.datapreparation.springjdbc.model;

/**
 * The Invoice class
 *
 * @author Zhipeng Chang
 */

//TODO: Implementation. Add tests. Add Java docs. Add annotations.
public class Invoice {
    private int id;
    private int bookId;
    private int customerId;
    private double amount;

    public Invoice(int id, int bookId, int customerId, double amount) {
        this.id = id;
        this.bookId = bookId;
        this.customerId = customerId;
        this.amount = amount;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", bookId=" + bookId + ", customerId=" + customerId + ", amount=" + amount + '}';
    }
}
