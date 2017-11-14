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
package com.etlsolutions.examples.database.maplist;

import com.etlsolutions.examples.data.ConstraintArray;
import com.etlsolutions.examples.data.RandomNumberGenerator;
import com.etlsolutions.examples.data.RandomStringGenerator;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.utility.EnumUtilities;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The PaymentDetailMapList class contains maps which can populate the PAYMENT table
 in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.1.0 - Add the constrain.
 */
public final class PaymentDetailMapList extends AbstractMapList {

    private final RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private final List<String> paymentTypes = Arrays.asList(EnumUtilities.names(PaymentType.class));
    private final List<Integer> invoiceIds;
    private final Set<ConstraintArray> constraintArrays;
    
    /**
     * 
     * @param invoiceMapList
     * @param definition 
     */
    public PaymentDetailMapList(InvoiceMapList invoiceMapList, IdGenerationDefinition definition) {
        super(definition);
        this.invoiceIds = invoiceMapList.getIds();
        constraintArrays = new HashSet<>(definition.getSize());                
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer...ids) {

        Object[] objs = keyGenerator.generateUniqueObjectArrayFromList(constraintArrays, invoiceIds, paymentTypes);
        
        Map<String, Object> map = new HashMap<>(5);
        map.put(PAYMENT_DETAIL_ID, ids[0]);
        map.put(PAYMENT_INVOICE_ID, objs[0]);
        map.put(PAYMENT_TYPE, objs[1]);
        map.put(PAYMENT_SUBTOTAL, randomNumberGenerator.generateNumber(0.01, 1200.00, 2));
        map.put(PAYMENT_CURRENCY_CODE, randomStringGenerator.generateStringFromArray(EnumUtilities.names(CurrencyCode.class)));
        return map;
    }

}
