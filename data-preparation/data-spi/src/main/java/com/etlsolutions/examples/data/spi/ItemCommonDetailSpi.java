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

import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableItemCommonDetail;
import java.math.BigDecimal;

/**
 * The ItemCommonDetailSpi interface defines an entry
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface ItemCommonDetailSpi extends IdentifiableItemCommonDetail, IdentifiableSpi {

    /**
     * The the currency cod for this item.
     *
     * @param currencyCode - The CurrencyCode object.
     */
    void setCurrencyCode(CurrencyCode currencyCode);

    /**
     * Set the availability type for this item.
     *
     * @param availability - The availability type.
     */
    void setAvailability(AvailabilityType availability);

    /**
     *
     * @param availabilityNumber
     */
    void setAvailabilityNumber(int availabilityNumber);

    /**
     *
     * @param description
     */
    void setDescription(String description);

    /**
     *
     * @param image
     */
    void setImage(byte[] image);

    /**
     *
     * @param name
     */
    void setName(String name);

    /**
     *
     * @param ranking
     */
    void setRanking(int ranking);

    /**
     *
     * @param listPrice
     */
    void setListPrice(BigDecimal listPrice);

    /**
     *
     * @param salePrice
     */
    void setSalePrice(BigDecimal salePrice);

    /**
     * Set the bar code for this item.
     * @param barcode - The bar code.
     */
    void setBarcode(String barcode);
}
