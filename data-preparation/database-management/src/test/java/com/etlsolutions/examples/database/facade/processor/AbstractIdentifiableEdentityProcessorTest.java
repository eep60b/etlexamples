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

import com.etlsolutions.examples.data.general.Identifiable;
import com.etlsolutions.examples.data.general.Constrainable;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import com.etlsolutions.examples.data.spi.IdentifiableSpi;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class AbstractIdentifiableEdentityProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AbstractIdentifiableEdentityProcessor.class, BookshopFacade.class, StringKeyValuePair.class})
public final class AbstractIdentifiableEdentityProcessorTest {

    private final BookshopFacade facade = PowerMockito.mock(BookshopFacade.class);
    private final IdentifiableSpi identifiableSpi = Mockito.mock(IdentifiableSpi.class);
    @SuppressWarnings("unchecked")
    private final List<Object> ids = Mockito.mock(List.class);

    private final MockConstrainable constrainable1 = Mockito.mock(MockConstrainable.class);
    private final MockConstrainable constrainable2 = Mockito.mock(MockConstrainable.class);
    private final MockConstrainable constrainable3 = Mockito.mock(MockConstrainable.class);

    private final String queryString = "querStringa";
    private final StringKeyValuePair stringKeyValuePair = PowerMockito.mock(StringKeyValuePair.class);
    private final List<Object> list = Arrays.asList(constrainable2, constrainable3);

    private AbstractIdentifiableEdentityProcessor<IdentifiableSpi, Identifiable> instance;

    @Before
    public void setUp() {

        Mockito.when(facade.save(identifiableSpi)).thenReturn(ids);
        Mockito.when(ids.get(0)).thenReturn(12231);
        Mockito.when(constrainable2.hasSameConstraint(constrainable1)).thenReturn(Boolean.TRUE);
        Mockito.when(facade.retrieveList(queryString, stringKeyValuePair)).thenReturn(list);
        instance = new MockAbstractIdentifiableEdentityProcessor(facade);
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave() {

        Mockito.when(identifiableSpi.getId()).thenReturn(0);
        assertEquals(identifiableSpi, instance.save(identifiableSpi));
        Mockito.verify(identifiableSpi).setId(12231);
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_GetOld() {

        Mockito.when(identifiableSpi.getId()).thenReturn(12);
        assertEquals(identifiableSpi, instance.save(identifiableSpi));
    }

    /**
     * Test of findConstraintableWithSameParameters method.
     */
    @Test
    public void testFindConstraintableWithSameParameters() {

        Mockito.when(constrainable1.hasSameParameters(constrainable2)).thenReturn(Boolean.TRUE);
        Mockito.when(constrainable2.hasSameParameters(constrainable1)).thenReturn(Boolean.TRUE);
        
        assertEquals(constrainable2, instance.findConstraintableWithSameParameters(queryString, constrainable1, stringKeyValuePair));
    }

    /**
     * Test of findConstraintableWithSameParameters method.
     */
    @Test(expected = IllegalStateException.class)
    public void testFindConstraintableWithSameParameters_Exception() {

        Mockito.when(constrainable1.hasSameParameters(constrainable2)).thenReturn(Boolean.FALSE);

        instance.findConstraintableWithSameParameters(queryString, constrainable1, stringKeyValuePair);
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(new MockAbstractIdentifiableEdentityProcessor(facade).hashCode(), instance.hashCode());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode_false() {

        BookshopFacade facade1 = PowerMockito.mock(BookshopFacade.class);
        assertNotEquals(new MockAbstractIdentifiableEdentityProcessor(facade1).hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {
        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(new MockAbstractIdentifiableEdentityProcessor(facade)));
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals_false() {
        BookshopFacade facade1 = PowerMockito.mock(BookshopFacade.class);

        assertFalse(instance.equals(null));
        assertFalse(instance.equals(new MockAbstractIdentifiableEdentityProcessor(facade1)));
        assertFalse(instance.equals(new Object()));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        assertEquals("MockAbstractIdentifiableEdentityProcessor{facade=bookshopFacade}", instance.toString());
    }

    private final class MockAbstractIdentifiableEdentityProcessor extends AbstractIdentifiableEdentityProcessor<IdentifiableSpi, Identifiable> {

        private MockAbstractIdentifiableEdentityProcessor(BookshopFacade facade) {
            super(facade);
        }

        @Override
        public IdentifiableSpi retrieve(Identifiable identifiable) {
            return identifiableSpi;
        }

        @Override
        public IdentifiableSpi doSave(Identifiable identifiable) {
            return identifiableSpi;
        }
    }
    
    private static interface MockConstrainable extends Constrainable<MockConstrainable>{
    }
}
