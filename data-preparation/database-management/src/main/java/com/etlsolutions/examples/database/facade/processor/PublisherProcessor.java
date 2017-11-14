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
package com.etlsolutions.examples.database.facade.processor;

import com.etlsolutions.examples.data.constant.KeyNames;
import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import com.etlsolutions.examples.data.api.Publisher;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PublisherPojo;

/**
 * The PublisherProcessor class contains methods which process the operations
 * associated to PUBLISHER table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PublisherProcessor extends AbstractIdentifiableEdentityProcessor<PublisherPojo, Publisher> {

    /**
     * Construct an object with the given facade object.
     * 
     * @param facade - The facade to be used.
     */
    public PublisherProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    public PublisherPojo retrieve(Publisher publisher) {
        return findConstraintableWithSameParameters(QueryNames.FIND_PUBLISHER_BY_UNIQUE_CONSTRAINT, publisher, new StringKeyValuePair(KeyNames.PUBLISHER_NAME, publisher.getName()));
    }

    @Override
    protected PublisherPojo doSave(Publisher publisher) {

        PublisherPojo pojo = retrieve(publisher);

        if (pojo == null) {
            AddressPojo address = new AddressProcessor(facade).save(publisher.getAddress());
            pojo = new PublisherPojo(address, publisher.getName());
        }

        return pojo;
    }
}
