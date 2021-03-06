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

import com.etlsolutions.examples.data.RandomNumberGenerator;
import com.etlsolutions.examples.data.api.PaymentType;
import java.util.Map;


/**
 * The CategoryMapList class contains maps which can populate the
 * DEBITCARD_PAYMENT table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class DebitcardPaymentMapList extends AbstractCardPaymentMapList {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    
    public DebitcardPaymentMapList(PaymentDetailMapList paymentDetailMapList, PersonAddressLinkMapList personAddressLinkMapList, IdGenerationDefinition definition) {
        super(paymentDetailMapList, personAddressLinkMapList, definition);
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {

        Map<String, Object> map = createMap(ids, PaymentType.DEBIT_CARD);
        map.put("cardNumber", randomStringGenerator.generateFixedLengthDigitalString(16));
        map.put("securityCode", randomStringGenerator.generateFixedLengthDigitalString(3));        
        map.put("issueNumber", randomNumberGenerator.generatePositiveNumber(20));
        map.put("startDate", dateTimeGenerator.generateRandomOldDate(5));
        return map;
    }

}
