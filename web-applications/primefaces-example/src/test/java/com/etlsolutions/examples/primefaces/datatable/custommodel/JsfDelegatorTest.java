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
package com.etlsolutions.examples.primefaces.datatable.custommodel;

import java.util.Locale;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class JsfDelegator.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor({"javax.faces.component.UIViewRoot", "javax.faces.component.UIComponent", "javax.faces.component.UIComponentBase"})
@PrepareForTest({JsfDelegator.class, FacesContext.class, UIViewRoot.class, UIComponentBase.class, UIComponent.class, Locale.class})
public final class JsfDelegatorTest {

    private final FacesContext facesContext = Mockito.mock(FacesContext.class);
    private final UIViewRoot uiViewRoot = Mockito.mock(UIViewRoot.class);
    private final Locale locale = PowerMockito.mock(Locale.class);
    

    private final JsfDelegator instance = new JsfDelegator();

    @Before
    public void setUp() {
        PowerMockito.mockStatic(FacesContext.class);
        Mockito.when(FacesContext.getCurrentInstance()).thenReturn(facesContext);
        
        Mockito.when(facesContext.getViewRoot()).thenReturn(uiViewRoot);
        Mockito.when(uiViewRoot.getLocale()).thenReturn(locale);
    }

    /**
     * Test of getLocale method, of class JsfDelegator.
     */
    @Test
    public void testGetLocale() {

        assertEquals(locale, instance.getLocale());
    }
}
