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

import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.data.specific.person.CustomerEntity;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.PersonalPassword;
import com.etlsolutions.examples.data.specific.person.PersonalUsername;
import com.etlsolutions.examples.utility.CalendarUtilities;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * The VoucherEntity class represents a voucher.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class VoucherEntity implements Voucher {

    private final CustomerEntity customer;
    private final VoucherTotal voucherTotal;
    private final String voucherToken;
    private final ExpireDate expireDate;

    /**
     * Construct an object using the given value.
     *
     * @param customer - The customer who owns the voucher.
     * @param voucherTotal - The total amount of money on the voucher.
     * @param voucherToken - The voucher token.
     * @param expireDate - The expire date of the voucher.
     */
    public VoucherEntity(Customer customer, VoucherTotal voucherTotal, String voucherToken, Date expireDate) {
        this.customer = customer instanceof CustomerEntity ? (CustomerEntity) customer : new CustomerEntity(new PersonAddressLinkEntity(customer.getPersonAddressLink()), new ImageBytes(customer.getImage()), new PersonalPassword(customer.getPassword()), new PersonalUsername(customer.getUsername()));
        this.voucherTotal = voucherTotal;
        this.voucherToken = voucherToken;
        this.expireDate = new ExpireDate(expireDate);
    }

    /**
     * Construct an object using the given value.
     *
     * @param customer - The customer who owns the voucher.
     * @param voucherTotal - The total amount of money on the voucher.
     * @param voucherToken - The voucher token.
     * @param expireDate - The expire date of the voucher.
     */
    public VoucherEntity(Customer customer, VoucherTotal voucherTotal, VoucherToken voucherToken, ExpireDate expireDate) {
        this.customer = customer instanceof CustomerEntity ? (CustomerEntity) customer : new CustomerEntity(customer);
        this.voucherTotal = voucherTotal;
        this.voucherToken = voucherToken.getValue();
        this.expireDate = expireDate;
    }

    /**
     *
     * @param voucher
     */
    public VoucherEntity(Voucher voucher) {
        this(voucher.getCustomer(), new VoucherTotal(voucher.getTotal()), voucher.getVoucherToken(), voucher.getExpireDate());
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public BigDecimal getTotal() {
        return voucherTotal.getValue();
    }

    @Override
    public String getVoucherToken() {
        return voucherToken;
    }

    @Override
    public Date getExpireDate() {
        return expireDate.getValue();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.customer);
        hash = 17 * hash + Objects.hashCode(this.voucherTotal);
        hash = 17 * hash + Objects.hashCode(this.voucherToken);
        hash = 17 * hash + Objects.hashCode(this.expireDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        final VoucherEntity other = (VoucherEntity) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.voucherTotal, other.voucherTotal)) {
            return false;
        }
        if (!Objects.equals(this.voucherToken, other.voucherToken)) {
            return false;
        }
        return Objects.equals(this.expireDate, other.expireDate);
    }

    @Override
    public String toString() {
        return "VoucherEntity{token=" + voucherToken + '}';
    }

    @Override
    public boolean hasSameConstraint(Voucher voucher) {

        if (this == voucher) {
            return true;
        }

        if (voucher == null) {
            return false;
        }

        return Objects.equals(getVoucherToken(), voucher.getVoucherToken());
    }

    @Override
    public boolean hasSameParameters(Voucher voucher) {

        if (this == voucher) {
            return true;
        }

        if (voucher == null) {
            return false;
        }

        if (!getCustomer().hasSameParameters(voucher.getCustomer())) {
            return false;
        }

        return CalendarUtilities.areSameDates(getExpireDate(), voucher.getExpireDate());
    }
}
