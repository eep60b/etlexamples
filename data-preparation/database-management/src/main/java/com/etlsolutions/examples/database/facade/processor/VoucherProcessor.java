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
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.VoucherPojo;

/**
 * The VoucherProcessor class contains methods which process operations
 * associated to the VOUCHER table in database.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class VoucherProcessor extends AbstractIdentifiableEdentityProcessor<VoucherPojo, Voucher> {

    /**
     * 
     * @param facade 
     */
    public VoucherProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    public VoucherPojo retrieve(Voucher voucher) {
        return findConstraintableWithSameParameters(QueryNames.FIND_VOUCHER_BY_UNIQUE_CONSTRAINT, voucher, new StringKeyValuePair(KeyNames.VOUCHER_TOKEN, voucher.getVoucherToken()));
    }

    @Override
    protected VoucherPojo doSave(Voucher voucher) {
        VoucherPojo pojo = retrieve(voucher);

        if (pojo == null) {

            CustomerPojo customerPojo = new CustomerProcessor(facade).save(voucher.getCustomer());
            return new VoucherPojo(customerPojo, voucher.getVoucherToken(), voucher.getTotal(), voucher.getExpireDate());
        }

        return pojo;
    }
}
