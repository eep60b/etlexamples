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
import com.etlsolutions.examples.data.general.Nameable;
import java.math.BigDecimal;

/**
 * The ItemCommonDetail interface represents the common detail for a product to be sold.
 * 
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public interface ItemCommonDetail extends Nameable, Constrainable<ItemCommonDetail> {

    /**
     * Get the currency code (ISO 4217) for this item.
     * @return 
     */
    CurrencyCode getCurrencyCode();

    /**
     * Get the item availability.
     * @return YES if the item is available.
     */
    AvailabilityType getAvailability();

    /**
     * Get the number how many items are available.
     * @return the number.
     */
   int getAvailabilityNumber();

    /**
     * Get the description of this item. 
     * @return the description string.
     */
    String getDescription();

    /**
     * Get the item image.
     * @return the item image object.
     */
    byte[] getImage();

    /**
     * Get the ranking of this item.
     * @return the book ranking.
     */
    int getRanking();

    /**
     * Get the list price of this item.
     * @return the list price.
     */
    BigDecimal getListPrice();

    /**
     * Get the sale price of this item.
     * @return the sale price.
     */
    BigDecimal getSalePrice();
    
    /**
     * Get the BAR code for this item.
     * @return the BAR code.
     */
    String getBarcode();
}
