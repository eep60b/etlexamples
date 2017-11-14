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
import javax.faces.context.FacesContext;

/**
 * Delegate to some of the JSF classes and methods. This is currently used to
 * demonstrate how to use PowerMockito to test classes with static fields.
 *
 * @author zc
 */
public final class JsfDelegator {

    /**
     * Get the locale from view root.
     *
     * @return the Locale object.
     */
    public Locale getLocale() {
        return FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }
}
