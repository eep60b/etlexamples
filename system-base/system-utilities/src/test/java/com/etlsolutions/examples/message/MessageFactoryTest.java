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
package com.etlsolutions.examples.message;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test of class MessageFactory.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class MessageFactoryTest {

    /**
     * Test of the private constructor.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = InvocationTargetException.class)
    public void testConstructor() throws Exception {
        Constructor[] constructors = MessageFactory.class.getDeclaredConstructors();
        assertEquals(1, constructors.length);

        Constructor constructor = constructors[0];
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    /**
     * Test of getMessage method.
     */
    @Test
    public void testGetMessage_MessageType() {

        assertEquals("There are duplicated values.\n", MessageFactory.getMessage(ErrorType.DUPLICATED_VALUE));
    }

    /**
     * Test of getMessage method.
     */
    @Test
    public void testGetMessage_MessageType_String() {
        assertEquals("Failed to create the directory: /als/kls/fsaa\n", MessageFactory.getMessage(ErrorType.FAILED_TO_CREATE_DIRECTORY, "/als/kls/fsaa"));
    }

    /**
     * Test of getMessage method.
     */
    @Test
    public void testGetMessage_MessageType_ObjectArr() {
        
        Object[] objects = {12, null, 12.34};
        assertEquals("At least one null value has been found in the following parameters: [12], [null], [12.34].\n", MessageFactory.getMessage(ErrorType.NULL_PARAMETER, objects));
    }

    /**
     * Test of getMessage method.
     */
    @Test
    public void testGetMessage_3args() {

        Object[] objects = {12, 12.34, "dukky"};

        assertEquals("There are duplicated values.\nThese value are: [12], [12.34], [dukky].\n", MessageFactory.getMessage(ErrorType.DUPLICATED_VALUE, "These value are: ", objects));
    }
    

    /**
     * Test of getMessage method.
     */
    @Test
    public void testGetMessage_4args() {

        Object[] objects = {12, 12.34, "dukky"};

        assertEquals("There are duplicated values.\nThese value are: [12], [12.34], [dukky].\nThere should be removed from the database A.\n", MessageFactory.getMessage(ErrorType.DUPLICATED_VALUE, "These value are: ", objects, "There should be removed from the database A."));
    }    

}
