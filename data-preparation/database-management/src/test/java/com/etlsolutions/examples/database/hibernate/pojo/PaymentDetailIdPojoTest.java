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
package com.etlsolutions.examples.database.hibernate.pojo;

import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class PaymentDetailIdPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PaymentDetailIdPojoTest {

    private final int id = 322;
    private final int id1 = 1022;
    private final PaymentType type = PaymentType.PAYPAL;
    private final PaymentType type2 = PaymentType.AMEX_CARD;

    private final PaymentDetailIdPojo instance = new PaymentDetailIdPojo(id, type);
    private final PaymentDetailIdPojo instance00 = new PaymentDetailIdPojo(id, type);
    private final PaymentDetailIdPojo instance01 = new PaymentDetailIdPojo(id1, type);
    private final PaymentDetailIdPojo instance02 = new PaymentDetailIdPojo(id, type2);
    private final PaymentDetailIdPojo instance03 = new PaymentDetailIdPojo();
    private final PaymentDetailIdPojo instance04 = new PaymentDetailIdPojo(type);
    private final PaymentDetailIdPojo instance05 = new HibernateProxyPaymentDetailIdPojo(new PaymentDetailIdPojo(id, type));

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {
        assertEquals(322, instance.getId());
        assertEquals(0, instance03.getId());
        assertEquals(0, instance04.getId());
        assertEquals(0, instance05.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(549);
        assertEquals(549, instance.getId());
    }

    /**
     * Test of getPaymentType method.
     */
    @Test
    public void testGetPaymentType() {

        assertEquals(PaymentType.PAYPAL, instance.getPaymentType());
        assertNull(instance03.getPaymentType());
        assertEquals(PaymentType.PAYPAL, instance04.getPaymentType());
        assertNull(instance05.getPaymentType());
    }

    /**
     * Test of setPaymentType method.
     */
    @Test
    public void testSetPaymentType() {

        instance.setPaymentType(PaymentType.MASTER_CARD);
        assertEquals(PaymentType.MASTER_CARD, instance.getPaymentType());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        
        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance05));
        assertTrue(instance05.equals(instance));
        
        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyPaymentDetailIdPojo extends PaymentDetailIdPojo implements HibernateProxy {

        private static final long serialVersionUID = 579554993785225125L;
        private final PaymentDetailIdPojo pojo;

        public HibernateProxyPaymentDetailIdPojo(PaymentDetailIdPojo pojo) {

            this.pojo = pojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {

            return new AbstractMockLazyInitializer() {

                @Override
                public PaymentDetailIdPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
