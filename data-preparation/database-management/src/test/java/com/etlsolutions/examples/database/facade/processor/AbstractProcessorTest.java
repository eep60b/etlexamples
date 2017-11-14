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

import com.etlsolutions.examples.database.facade.BookshopFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class AbstractProcessor.
 *
 * @author Zhieng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AbstractProcessor.class, BookshopFacade.class})
public final class AbstractProcessorTest {

    private final BookshopFacade facade1 = PowerMockito.mock(BookshopFacade.class);
    private final BookshopFacade facade3 = PowerMockito.mock(BookshopFacade.class);
    
    private final AbstractProcessor<Object> instance1 = new MockAbstractProcessor(facade1);
    private final AbstractProcessor<Object> instance2 = new MockAbstractProcessor(facade1);
    private final AbstractProcessor<Object> instance3 = new MockAbstractProcessor(facade3);

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance1.hashCode(), instance1.hashCode());
        assertEquals(instance2.hashCode(), instance1.hashCode());
        assertNotEquals(instance3.hashCode(), instance1.hashCode());        
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {
        
        assertTrue(instance1.equals(instance1));
        assertTrue(instance1.equals(instance2));
        
        assertFalse(instance1.equals(instance3));        
        assertFalse(instance1.equals(new Object()));
        assertFalse(instance1.equals(null));            
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        Mockito.when(facade1.toString()).thenReturn("1FX");
        assertEquals("MockAbstractProcessor{facade=1FX}", instance1.toString());
    }

    private static class MockAbstractProcessor extends AbstractProcessor<Object> {

        public MockAbstractProcessor(BookshopFacade facade) {
            super(facade);
        }

        @Override
        public Object retrieve(Object object) {
            return null;
        }

        @Override
        public Object save(Object object) {
            return null;
        }
    }

}
