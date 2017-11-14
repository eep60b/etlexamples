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
import com.etlsolutions.examples.data.RandomNumberGenerator;
import com.etlsolutions.examples.data.RandomStringGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The VoucherMapList class contains maps which can populate the VOUCHER table
 * in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class VoucherMapList extends AbstractMapList {

    private final RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final DateTimeGenerator dateTimeGenerator = new DateTimeGenerator();
    
    private final List<Integer> customerIDs;
    private final Set<String> voucherTokens;

    public VoucherMapList(CustomerMapList customerMapList, IdGenerationDefinition definition) {
        super(definition);
        customerIDs = customerMapList.getIds();
        voucherTokens = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {

        Map<String, Object> map = new HashMap<>(4);
        map.put(VOUCHER_ID, ids[0]);
        map.put(VOUCHER_CUSTOMER_ID, keyGenerator.generateRandomKeyFromList(customerIDs));
        map.put(VOUCHER_TOKEN, randomStringGenerator.generateFixedLengthUniqueString(voucherTokens, 16));
        map.put(VOUCHER_TOTAL, randomNumberGenerator.generateNumber(0.01, 100.00, 2));
        map.put(VOUCHER_EXPIRED_DATE, dateTimeGenerator.generateRandomFutureDate(5));
        return map;
    }

}
