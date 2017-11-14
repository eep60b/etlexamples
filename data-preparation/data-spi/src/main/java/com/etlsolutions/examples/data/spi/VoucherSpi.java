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
package com.etlsolutions.examples.data.spi;

import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableVoucher;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Zhipeng Chang
 *
 * @param <C> - The concrete Customer object type.
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface VoucherSpi<C extends Customer> extends IdentifiableVoucher, IdentifiableSpi {

    /**
     * Set the total amount credit in this voucher.
     *
     * @param total - The total amount.
     */
    void setTotal(BigDecimal total);

    /**
     * Set the customer to whom this voucher belongs.
     *
     * @param customer
     */
    void setCustomer(C customer);

    /**
     *
     * @param voucherToken
     */
    void setVoucherToken(String voucherToken);
    
    /**
     * Set the expire date for this voucher.
     * @param expireDate - The expire date to be set.
     */
    void setExpireDate(Date expireDate);    
}
