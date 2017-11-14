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
package com.etlsolutions.examples.data.specific.payment;

import com.etlsolutions.examples.data.specific.payment.PaymentDetailEntity;
import com.etlsolutions.examples.data.specific.payment.PaymentSubtotal;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.PaymentType;
import java.math.BigDecimal;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test of class PaymentDetailEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PaymentDetailEntityConstructorTest_NPE {

    private final Invoice invoice = Mockito.mock(Invoice.class);
    private final PaymentSubtotal paymentSubtotalColumn = new PaymentSubtotal(new BigDecimal(29.22));

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_1() {

        new PaymentDetailEntity(null, paymentSubtotalColumn, CurrencyCode.DMK, PaymentType.MASTER_CARD);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_2() {

        new PaymentDetailEntity(invoice, paymentSubtotalColumn, null, PaymentType.MASTER_CARD);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_3() {

        new PaymentDetailEntity(invoice, paymentSubtotalColumn, CurrencyCode.DMK, null);
    }
}
