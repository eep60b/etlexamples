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
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;

/**
 * The CustomerProcessor class contains methods which process the operations
 * associated to CUSTOMER table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class CustomerProcessor extends AbstractIdentifiableEdentityProcessor<CustomerPojo, Customer> {

    /**
     * Construct an object with the given BookshopFacade object.
     *
     * @param facade - The given BookshopFacade object.
     */
    public CustomerProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    protected CustomerPojo doSave(Customer customer) {

        CustomerPojo pojo = retrieve(customer);
        if (pojo == null) {
            PersonAddressLinkPojo personAddressLinkPojo = new PersonAddressLinkProcessor(facade).save(customer.getPersonAddressLink());
            return new CustomerPojo(personAddressLinkPojo, customer.getUsername(), customer.getPassword(), customer.getImage());
        }
        return pojo;
    }

    @Override
    public CustomerPojo retrieve(Customer customer) {

        return findConstraintableWithSameParameters(QueryNames.FIND_CUSTOMER_BY_UNIQUE_CONSTRAINT, customer,
                new StringKeyValuePair(KeyNames.CUSTOMER_USERNAME, customer.getUsername()));
    }

}
