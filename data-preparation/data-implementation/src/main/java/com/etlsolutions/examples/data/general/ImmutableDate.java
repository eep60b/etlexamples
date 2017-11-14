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
package com.etlsolutions.examples.data.general;

import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Date;

/**
 * The <code>ImmutableDate</code> class is created in an effort to allow developers to use
 * <code>Date</code> objects without being able to modify them. The setTime method and all
 * deprecated methods are unsupported in <code>ImmutableDate</code>.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
public final class ImmutableDate extends Date {

    private static final long serialVersionUID = 277456625867616981L;

    public ImmutableDate() {
        super();
    }

    public ImmutableDate(long time) {
        super(time);
    }

    public ImmutableDate(Date date) {
        this(date.getTime());
    }

    @Override
    public ImmutableDate clone() {
        return new ImmutableDate((Date) super.clone());
    }

    @Override
    public String toString() {
        return "ImmutalbeDate{date=" + super.toString() + "}";
    }

    @Deprecated
    @Override
    public void setTime(long time) {
        throw new UnsupportedOperationException("The time of ImmutalbeDate cannot be reset.");
    }

    @Deprecated
    @Override
    public int getTimezoneOffset() {
        throw new UnsupportedOperationException("The time of ImmutalbeDate cannot be reset.");
    }

    @Deprecated
    @Override
    public String toGMTString() {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public String toLocaleString() {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public void setSeconds(int seconds) {
        throw new UnsupportedOperationException("The time of ImmutalbeDate cannot be reset.");
    }

    @Deprecated
    @Override
    public int getSeconds() {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public void setMinutes(int minutes) {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public int getMinutes() {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public void setHours(int hours) {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public int getHours() {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public int getDay() {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public void setDate(int date) {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public int getDate() {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public void setMonth(int month) {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public int getMonth() {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public void setYear(int year) {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Deprecated
    @Override
    public int getYear() {
        throw new UnsupportedOperationException("Deprecated operation which is nolonger supported.");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ImmutableDate && super.equals(obj);
    }

    //TODO: Check the hashcode. There is an exception.
    @Override
    public int hashCode() {

        try {
            return super.hashCode();
        } catch (Throwable ex) {
            throw new RuntimeException("A strange exception thrown by data hashcode.", ex);
        }
    }
}
