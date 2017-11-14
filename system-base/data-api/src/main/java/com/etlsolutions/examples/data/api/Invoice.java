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
package com.etlsolutions.examples.data.api;

import com.etlsolutions.examples.data.general.Constrainable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * The Invoice interface defines an object which contains information of an invoice.
 * 
 * 
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public interface Invoice extends Constrainable<Invoice>{

    /**
     * Get information of the customer to whom this invoice belongs.
     * 
     * @return the Customer object. 
     */
    Customer getCustomer();

    /**
     * Get the delivery address of this invoice.
     * @return 
     */
    Address getDeliveryAddress();
   
    /**
     * Get the date which this invoice is produced.
     * @return the invoice date.
     */
    Date getInvoiceDate();

    /**
     * Get the total price in this invoice.
     * @return the total price.
     */
    BigDecimal getTotal();
    
    /**
     * Get the validity of this invoice. The voices are YES or NO.
     * @return the InvoiceValidity object.
     */
    InvoiceValidity getValidity();
    
    /**
     * Get the reference number for this invoice.
     * @return the reference number string.
     */
    String getReferenceNumber();    
}
