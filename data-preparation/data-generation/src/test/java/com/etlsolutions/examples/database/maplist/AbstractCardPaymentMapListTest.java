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
package com.etlsolutions.examples.database.maplist;

import com.etlsolutions.examples.data.DateTimeGenerator;
import com.etlsolutions.examples.data.api.PaymentType;
import java.util.Map;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class AbstractCardPaymentMapList.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AbstractCardPaymentMapList.class, DateTimeGenerator.class, PaymentDetailMapList.class})
public final class AbstractCardPaymentMapListTest {

    private final DateTimeGenerator dateTimeGenerator = PowerMockito.mock(DateTimeGenerator.class);

    private final PaymentDetailMapList paymentMapList = PowerMockito.mock(PaymentDetailMapList.class);
    private final PersonAddressLinkMapList personAddressLinkMapList = PowerMockito.mock(PersonAddressLinkMapList.class);
    private final IdGenerationDefinition definition = Mockito.mock(IdGenerationDefinition.class);    
    
    
    private AbstractCardPaymentMapList instance;
    
    @Before
    public void setUp() {
        
        instance = new MockAbstractCardPaymentMapList(paymentMapList, personAddressLinkMapList, definition);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createMap method, of class AbstractCardPaymentMapList.
     */
    @Test
    public void testCreateMap() {
        System.out.println("createMap");
        Integer[] ids = null;
        PaymentType paymentType = null;
        AbstractCardPaymentMapList instance = null;
        Map<String, Object> expResult = null;
        Map<String, Object> result = instance.createMap(ids, paymentType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private final class MockAbstractCardPaymentMapList extends AbstractCardPaymentMapList {

        public MockAbstractCardPaymentMapList(PaymentDetailMapList paymentMapList, PersonAddressLinkMapList personAddressLinkMapList, IdGenerationDefinition definition) {
            super(paymentMapList, personAddressLinkMapList, definition);
        }

        @Override
        protected Map<String, Object> createMap(Integer... ids) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
