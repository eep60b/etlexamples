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
import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.UOM;
import com.etlsolutions.examples.utility.EnumUtilities;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;
import com.etlsolutions.examples.data.api.LanguageCode;

/**
 * The BookMapList class contains maps which can populate the BOOK table in database.
 * 
 * @author Zhipeng Chang
 * @since 1.0.0
 * 
 * @version 1.0.0 - Created,
 * @version 2.0.0 - Moved the common stuff into Item.
*/
public final class BookMapList extends AbstractMapList {
    
    private final RandomStringGenerator stringGenerator = new RandomStringGenerator();
    private final RandomNumberGenerator valueGenerator = new RandomNumberGenerator(); 
    private final DateTimeGenerator dateTimeGenerator = new DateTimeGenerator();    
    private final List<Integer> allItemCommonDetailIds;
    private final PublisherMapList publisherMapList;
     private final Set<Integer> itemCommonDetailIds;
     
    public BookMapList(ItemCommonDetailMapList itemCommonDetailMapList, PublisherMapList publisherMapList, IdGenerationDefinition definition) {
        super(definition);
        allItemCommonDetailIds = itemCommonDetailMapList.getIds();
        this.publisherMapList = publisherMapList;
        itemCommonDetailIds = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {
                        
        Map<String, Object> map = new HashMap<>();
        map.put(BOOK_ID, ids[0]);
        map.put(BOOK_ITEM_COMMON_DETAIL_ID, keyGenerator.generateUniqueObjectFromList(itemCommonDetailIds, allItemCommonDetailIds));        
        map.put(BOOK_PUBLISHER_ID, keyGenerator.generateRandomKeyFromList(publisherMapList.getIds()));
        map.put(BOOK_ISBN, stringGenerator.generateFixedLengthString(13));
        map.put(BOOK_PDF_CONTENT, valueGenerator.generteRandomBytes(1000));
        map.put(BOOK_EDITION, valueGenerator.generatePositiveNumber(10));
        map.put(BOOK_PUBLISH_DATE, dateTimeGenerator.generateRandomOldDate(10));      
        map.put(BOOK_WIDTH, valueGenerator.generateNumber(2.2, 100, 2));
        map.put(BOOK_LENGTH, valueGenerator.generateNumber(5.0, 50.0, 2));
        map.put(BOOK_THICKNESS, valueGenerator.generateNumber(0.5, 10.1, 2));
        map.put(BOOK_UOM, stringGenerator.generateStringFromArray(EnumUtilities.names(UOM.class)));
        map.put(BOOK_FORMAT, stringGenerator.generateStringFromArray(EnumUtilities.names(BookFormat.class)));
        map.put(BOOK_LANGUAGE, stringGenerator.generateStringFromArray(EnumUtilities.names(LanguageCode.class)));
        return map;
    }
}
