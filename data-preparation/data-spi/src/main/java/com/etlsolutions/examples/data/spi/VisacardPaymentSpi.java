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
package com.etlsolutions.examples.data.spi;

import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableVisacardPayment;
import java.util.Date;

/**
 * The VisacardPaymentSpi interface represents a payment made by a Visa credit
 * card. It contains modification methods for the fields.
 *
 * @author Zhipeng Chang
 *
 * @param <PD>
 * @param <PAL>
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface VisacardPaymentSpi<PD extends PaymentDetail, PAL extends PersonAddressLink> extends IdentifiableVisacardPayment, CardPaymentSpi<PD, PAL> {

    /**
     * Set the date from which the card is valid.
     *
     * @param startDate the first valid date.
     */
    void setStartDate(Date startDate);
}
