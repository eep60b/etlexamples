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
import com.etlsolutions.examples.data.api.identifiable.IdentifiableCardPayment;
import java.util.Date;

/**
 * The CardPaymentSpi interface represents a payment made by card. It contains
 * both setter and getter methods to modify its internal information.
 *
 * @author Zhipeng Chang
 *
 * @param <PD>
 * @param <PA>
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface CardPaymentSpi<PD extends PaymentDetail, PA extends PersonAddressLink> extends IdentifiableCardPayment, IdentifiableSpi {

    /**
     * Set the card number for this card payment.
     * @param cardNumber - the card number in string format.
     */
    void setCardNumber(String cardNumber);

    /**
     * 
     * @param expireDate 
     */
    void setExpireDate(Date expireDate);

    /**
     * 
     * @param paymentDetail 
     */
    void setPaymentDetail(PD paymentDetail);

    /**
     * 
     * @param securityCode 
     */
    void setSecurityCode(String securityCode);

    /**
     * 
     * @param personAddressLink 
     */
    void setPersonAddressLink(PA personAddressLink);
}
