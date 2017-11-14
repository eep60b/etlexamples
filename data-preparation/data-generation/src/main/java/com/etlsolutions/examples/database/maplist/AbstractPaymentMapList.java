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

import com.etlsolutions.examples.data.RandomStringGenerator;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The AmexcardPaymentMapList class contains maps which can populate the
 * AMEXCARD_PAYMENT table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@DataClass
@NotThreadSafe
public abstract class AbstractPaymentMapList extends AbstractMapList {

    protected final RandomStringGenerator randomStringGenerator = new RandomStringGenerator();   
    protected final PaymentDetailMapList paymentDetailMapList; 
    private final Set<Integer> paymentDetailIds;
    
    /**
     * 
     * @param paymentMapList
     * @param definition 
     */
    public AbstractPaymentMapList(PaymentDetailMapList paymentMapList, IdGenerationDefinition definition) {
        super(definition);
        this.paymentDetailMapList = paymentMapList;
        paymentDetailIds = new HashSet<>(definition.getSize());
    }

    /**
     * 
     * @param allPaymentDetailIds
     * @param paymentType
     * @return
     * @throws IllegalStateException 
     */
    protected int createPaymentDetailId(List<Integer> allPaymentDetailIds, PaymentType paymentType) throws IllegalStateException {
        if (paymentDetailIds.size() >= allPaymentDetailIds.size()) {
            throw new IllegalStateException("No payment id is available.");
        }
        int paymentDetailId;
        while (true) {
            paymentDetailId = keyGenerator.generateRandomKeyFromList(allPaymentDetailIds);
            Map<String, Object> map = paymentDetailMapList.getMap(PAYMENT_DETAIL_ID, paymentDetailId);
            if (map != null && paymentType.name().equals(map.get(PAYMENT_TYPE)) && !paymentDetailIds.contains(paymentDetailId)) {
                paymentDetailIds.add(paymentDetailId);
                break;
            }
        }
        return paymentDetailId;
    }
}
