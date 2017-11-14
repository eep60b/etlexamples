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

import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableSoldItem;
import java.math.BigDecimal;

/**
 * 
 * @author Zhipeng Chang
 * @param <IN>
 * @param <ICD>
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public interface SoldItemSpi<IN extends Invoice, ICD extends ItemCommonDetail> extends IdentifiableSoldItem, IdentifiableSpi {

    /**
     * 
     * @param invoice 
     */
    void setInvoice(IN invoice);
    
    /**
     * 
     * @param quantity 
     */
    void setQuantity(int quantity);

    /**
     * 
     * @param unitPrice 
     */
    void setUnitPrice(BigDecimal unitPrice);
    
    /**
     * 
     * @param itemCommonDetail 
     */
    void setItemCommonDetail(ICD itemCommonDetail);
}
