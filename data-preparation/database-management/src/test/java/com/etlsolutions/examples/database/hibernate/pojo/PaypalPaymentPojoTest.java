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

import com.etlsolutions.examples.data.api.PaypalPayment;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class PaypalPaymentPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PaypalPaymentPojoTest {

    private final int id = 3924;
    private final int id1 = 6712823;
    private final PaymentDetailPojo paymentDetail = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetail2 = Mockito.mock(PaymentDetailPojo.class);
    private final PaymentDetailPojo paymentDetailx = Mockito.mock(PaymentDetailPojo.class);
    private final String paypalAccountId = "1903489194379";
    private final String paypalAccountId3 = "adfoapdfaoe1";
    private final String paypalIdentityToken = "oanfaldkalafjalffadfa";
    private final String paypalIdentityToken4 = "kasdjk34jkd8aifa13";
    private final PaypalPayment paypalPayment = Mockito.mock(PaypalPayment.class);

    private final PaypalPaymentPojo instance = new PaypalPaymentPojo(id, paymentDetail, paypalAccountId, paypalIdentityToken);
    private final PaypalPaymentPojo instance00 = new PaypalPaymentPojo(id, paymentDetail, paypalAccountId, paypalIdentityToken);
    private final PaypalPaymentPojo instance01 = new PaypalPaymentPojo(id1, paymentDetail, paypalAccountId, paypalIdentityToken);
    private final PaypalPaymentPojo instance02 = new PaypalPaymentPojo(id, paymentDetail2, paypalAccountId, paypalIdentityToken);
    private final PaypalPaymentPojo instance03 = new PaypalPaymentPojo(id, paymentDetail, paypalAccountId3, paypalIdentityToken);
    private final PaypalPaymentPojo instance04 = new PaypalPaymentPojo(id, paymentDetail, paypalAccountId, paypalIdentityToken4);
    private final PaypalPaymentPojo instance05 = new PaypalPaymentPojo();
    private final PaypalPaymentPojo instance06 = new PaypalPaymentPojo(paymentDetail, paypalAccountId, paypalIdentityToken);
    private final PaypalPaymentPojo instance07 = new HibernateProxyPaypalPaymentPojo(instance);
    private final PaypalPaymentPojo instance08 = new PaypalPaymentPojo(id, new PaymentDetailPojo(), paypalAccountId, paypalIdentityToken);
    
    @Before
    public void setUp() {

        Mockito.when(paypalPayment.getPaymentDetail()).thenReturn(paymentDetailx);
        Mockito.when(paypalPayment.getPaypalAccountId()).thenReturn(paypalAccountId);
        Mockito.when(paypalPayment.getPaypalIdentityToken()).thenReturn(paypalIdentityToken);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(3924, instance.getId());
        assertEquals(0, instance05.getId());
        assertEquals(0, instance06.getId());
        assertEquals(0, instance07.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(8392);
        assertEquals(8392, instance.getId());
    }

    /**
     * Test of getPaymentDetail method.
     */
    @Test
    public void testGetPaymentDetail() {

        assertEquals(paymentDetail, instance.getPaymentDetail());
        assertNull(instance05.getPaymentDetail());
        assertEquals(paymentDetail, instance06.getPaymentDetail());
        assertNull(instance07.getPaymentDetail());
    }

    /**
     * Test of setPaymentDetail method.
     */
    @Test
    public void testSetPaymentDetail() {

        instance.setPaymentDetail(paymentDetailx);
        assertEquals(paymentDetailx, instance.getPaymentDetail());
    }

    /**
     * Test of getPaypalAccountId method.
     */
    @Test
    public void testGetPaypalAccountId() {

        assertEquals("1903489194379", instance.getPaypalAccountId());
        assertNull(instance05.getPaypalAccountId());
        assertEquals("1903489194379", instance.getPaypalAccountId());
        assertNull(instance07.getPaypalAccountId());
    }

    /**
     * Test of setPaypalAccountId method.
     */
    @Test
    public void testSetPaypalAccountId() {

        instance.setPaypalAccountId("setPaypalAccountIdcc");
        assertEquals("setPaypalAccountIdcc", instance.getPaypalAccountId());
    }

    /**
     * Test of getPaypalIdentityToken method.
     */
    @Test
    public void testGetPaypalIdentityToken() {

        assertEquals("oanfaldkalafjalffadfa", instance.getPaypalIdentityToken());
        assertNull(instance05.getPaypalIdentityToken());
        assertEquals("oanfaldkalafjalffadfa", instance06.getPaypalIdentityToken());
        assertNull(instance07.getPaypalIdentityToken());
    }

    /**
     * Test of setPaypalIdentityToken method.
     */
    @Test
    public void testSetPaypalIdentityToken() {

        instance.setPaypalIdentityToken("paypalIdentityTokenxts");
        assertEquals("paypalIdentityTokenxts", instance.getPaypalIdentityToken());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        Mockito.when(paymentDetail.hasSameConstraint(paymentDetailx)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance07.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(paypalPayment));

        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {
        Mockito.when(paymentDetail.hasSameParameters(paymentDetailx)).thenReturn(Boolean.TRUE);
        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance07));
        assertTrue(instance07.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(paypalPayment));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance07.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance07));
        assertTrue(instance07.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(paypalPayment));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("PaypalPaymentPojo{invoice reference number=null, paypal identity token=oanfaldkalafjalffadfa}", instance.toString());

        InvoicePojo invoice = Mockito.mock(InvoicePojo.class);
        Mockito.when(paymentDetail.getInvoice()).thenReturn(invoice);
        Mockito.when(invoice.getReferenceNumber()).thenReturn("aodaldfasldfal");
        assertEquals("PaypalPaymentPojo{invoice reference number=aodaldfasldfal, paypal identity token=oanfaldkalafjalffadfa}", instance.toString());   
        
        assertEquals("PaypalPaymentPojo{invoice reference number=null, paypal identity token=null}", instance05.toString());
    }

   
    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance08));
    }     
    
    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyPaypalPaymentPojo extends PaypalPaymentPojo implements HibernateProxy {

        private static final long serialVersionUID = 354176384785528556L;
        private final PaypalPaymentPojo pojo;

        public HibernateProxyPaypalPaymentPojo(PaypalPaymentPojo pojo) {

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
                public PaypalPaymentPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
