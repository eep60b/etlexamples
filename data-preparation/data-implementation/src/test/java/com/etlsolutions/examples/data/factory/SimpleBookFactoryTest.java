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
package com.etlsolutions.examples.data.factory;

import com.etlsolutions.examples.data.bean.SimpleBookJavaBean;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class SimpleBookFactory.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SimpleBookFactory.class, Date.class})
public final class SimpleBookFactoryTest {

    /**
     * Test of getGeneratedSimpleBookJavaBeanList method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testGetGeneratedSimpleBookJavaBeanList() throws Exception {

        @SuppressWarnings("unchecked")
        ArrayList<SimpleBookJavaBean> list = Mockito.mock(ArrayList.class);
        PowerMockito.whenNew(ArrayList.class).withNoArguments().thenReturn(list);

        SimpleBookJavaBean bean1 = Mockito.mock(SimpleBookJavaBean.class);
        SimpleBookJavaBean bean2 = Mockito.mock(SimpleBookJavaBean.class);
        SimpleBookJavaBean bean3 = Mockito.mock(SimpleBookJavaBean.class);

        Date date1 = PowerMockito.mock(Date.class);
        Date date2 = PowerMockito.mock(Date.class);
        Date date3 = PowerMockito.mock(Date.class);
        PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(date1).thenReturn(date2).thenReturn(date3);

        PowerMockito.whenNew(SimpleBookJavaBean.class).withArguments(0, "untitled", date1).thenReturn(bean1);
        PowerMockito.whenNew(SimpleBookJavaBean.class).withArguments(1, "untitled", date2).thenReturn(bean2);
        PowerMockito.whenNew(SimpleBookJavaBean.class).withArguments(2, "untitled", date3).thenReturn(bean3);

        assertEquals(list, SimpleBookFactory.getGeneratedSimpleBookJavaBeanList(3));

        Mockito.verify(list).add(bean1);
        Mockito.verify(list).add(bean2);
        Mockito.verify(list).add(bean3);
    }

}
