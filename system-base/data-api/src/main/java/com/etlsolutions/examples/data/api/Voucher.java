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

/**
 * The Voucher interface defines an entry of voucher table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface Voucher extends Constrainable<Voucher> {

    /**
     * Get the total credit in this voucher.
     *
     * @return the total credit.
     */
    BigDecimal getTotal();

    /**
     * Get the customer who owns this voucher.
     *
     * @return the customer.
     */
    Customer getCustomer();

    /**
     * Get the voucher token string.
     *
     * @return voucher token string.
     */
    String getVoucherToken();
    

    /**
     * Get the expired date of the voucher.
     *
     * @return the date object.
     */
    Date getExpireDate();    
}
