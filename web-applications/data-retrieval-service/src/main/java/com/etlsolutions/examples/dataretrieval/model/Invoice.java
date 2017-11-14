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

package com.etlsolutions.examples.dataretrieval.model;

/**
 * The Invoice class
 *
 * @author Zhipeng Chang
 */

//TODO: Implementation. Add tests. Add Java docs. Add annotations.
public class Invoice implements Cloneable {
    private int id;
    private Book book;
    private Customer customer;
    private double amount;

    public Invoice(int id, Book book, Customer customer, double amount) {
        this.id = id;
        this.book = book;
        this.customer = customer;
        this.amount = amount;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", bookId=" + book.getId() + ", customerId=" + customer .getId() + ", amount=" + amount + '}';
    }

    @Override
    @SuppressWarnings({"CloneDoesntCallSuperClone", "CloneDeclaresCloneNotSupported"})
    public Invoice clone()  {
        return new Invoice(id, book.clone(), customer.clone(), amount);
    }
    
    
}
