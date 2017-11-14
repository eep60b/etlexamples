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
import com.etlsolutions.examples.data.api.VoucherPayment;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.VoucherPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.VoucherPojo;
import java.util.Set;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class VoucherPaymentProcessor extends AbstractProcessor<VoucherPayment> {

    private final PaymentDetailProcessor paymentDetailProcessor;
    private final VoucherProcessor voucherProcessor;

    /**
     * Construct an object using the given BookshopFacade object.
     *
     * @param facade - The given BookshopFacade object.
     */
    public VoucherPaymentProcessor(BookshopFacade facade) {
        super(facade);
        paymentDetailProcessor = new PaymentDetailProcessor(facade);
        voucherProcessor = new VoucherProcessor(facade);
    }

    @Override
    public VoucherPaymentPojo save(VoucherPayment voucherPayment) {

        VoucherPaymentPojo pojo = retrieve(voucherPayment);

        if (pojo == null) {

            PaymentDetailPojo paymentDetailPojo = paymentDetailProcessor.save(voucherPayment.getPaymentDetail());
            VoucherPojo voucherPojo = voucherProcessor.save(voucherPayment.getVoucher());
            
            Set<VoucherPojo> vouchers = paymentDetailPojo.getVouchers();
            vouchers.add(voucherPojo);
            paymentDetailPojo.setVouchers(vouchers);
            
            Set<PaymentDetailPojo> paymentDetailPojos = voucherPojo.getPaymentDetails();
            paymentDetailPojos.add(paymentDetailPojo);
            voucherPojo.setPaymentDetails(paymentDetailPojos);
            
            facade.update(paymentDetailPojo, voucherPojo);
            
            pojo = new VoucherPaymentPojo(paymentDetailPojo, voucherPojo);
        }

        return pojo;
    }

    @Override
    public VoucherPaymentPojo retrieve(VoucherPayment voucherPayment) {

        PaymentDetailPojo p = paymentDetailProcessor.retrieve(voucherPayment.getPaymentDetail());
        VoucherPojo v = voucherProcessor.retrieve(voucherPayment.getVoucher());

        if (p == null || v == null) {
            return null;
        }

        if (facade.retrieveList(QueryNames.SELECT_FROM_VOUCHER_PAYMENT,
                new StringKeyValuePair(KeyNames.VOUCHER_PAYMENT_PAYMENT_DETAIL_ID, p.getId()),
                new StringKeyValuePair(KeyNames.VOUCHER_PAYMENT_VOUCHER_ID, v.getId())).isEmpty()) {
            return null;
        }

        return new VoucherPaymentPojo(p, v);
    }
}
