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

/**
 * The SoldItem interface contains information (how many items to be sold and
 * the unit price) of one type of items in a particular invoice.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface SoldItem extends Constrainable<SoldItem> {

    /**
     * Get the invoice information for this sold item.
     *
     * @return
     */
    Invoice getInvoice();

    /**
     * Get the number how many items have been sold.
     *
     * @return the sold number.
     */
    int getQuantity();

    /**
     * Get the sold price for one item.
     *
     * @return the sold price.
     */
    BigDecimal getUnitPrice();

    /**
     * Get the common detail for this type of item.
     *
     * @return
     */
    ItemCommonDetail getItemCommonDetail();
}
