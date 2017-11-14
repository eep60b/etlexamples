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

import com.etlsolutions.examples.data.DateTimeGenerator;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import java.util.HashMap;
import java.util.Map;

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
public abstract class AbstractCardPaymentMapList extends AbstractPaymentMapList {

    /**
     * 
     */
    protected final DateTimeGenerator dateTimeGenerator = new DateTimeGenerator();
    
    /**
     * 
     */
    protected final PersonAddressLinkMapList personAddressLinkMapList;

    /**
     *
     * @param paymentMapList
     * @param personAddressLinkMapList
     * @param definition
     */
    public AbstractCardPaymentMapList(PaymentDetailMapList paymentMapList, PersonAddressLinkMapList personAddressLinkMapList, IdGenerationDefinition definition) {
        super(paymentMapList, definition);
        this.personAddressLinkMapList = personAddressLinkMapList;
    }

    /**
     * Create a map using the specified parameters.
     * @param ids - The specified IDs.
     * @param paymentType - The payment type.
     * @return the created map.
     */
    protected final Map<String, Object> createMap(Integer[] ids, PaymentType paymentType) {

        Map<String, Object> map = new HashMap<>();
        map.put(CARD_PAYMENT_ID, ids[0]);
        map.put(CARD_PAYMENT_PAYMENT_DETAIL_ID, createPaymentDetailId(paymentDetailMapList.getIds(), paymentType));
        map.put(CARD_PAYMENT_PERSON_ADDRESS_LINK_ID, keyGenerator.generateRandomKeyFromList(personAddressLinkMapList.getIds()));
        map.put(CARD_PAYMENT_TYPE, paymentType.name());
        map.put(CARD_PAYMENT_EXPIRE_DATE, dateTimeGenerator.generateRandomFutureDate(5));
        return map;
    }
}
