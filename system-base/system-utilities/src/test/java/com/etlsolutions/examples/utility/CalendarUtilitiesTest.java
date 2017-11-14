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
package com.etlsolutions.examples.utility;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class CalendarUtilities.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class CalendarUtilitiesTest {

    private final Date date1 = new Date(21393128L);
    private final Date date2;
    private final Date date3;
    private final Date date4;
    private final Date date5;

    public CalendarUtilitiesTest() {
        Calendar c1 = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        c1.setTime(date1);
        c.set(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DATE), c1.get(Calendar.HOUR_OF_DAY), c1.get(Calendar.MINUTE) + 1, c1.get(Calendar.SECOND) + 1);
        date2 = c.getTime();
        c.set(c1.get(Calendar.YEAR) + 1, c1.get(Calendar.MONTH), c1.get(Calendar.DATE), c1.get(Calendar.HOUR_OF_DAY), c1.get(Calendar.MINUTE), c1.get(Calendar.SECOND));
        date3 = c.getTime();
        c.set(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH) + 1, c1.get(Calendar.DATE), c1.get(Calendar.HOUR_OF_DAY), c1.get(Calendar.MINUTE), c1.get(Calendar.SECOND));
        date4 = c.getTime();
        c.set(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DATE) + 1, c1.get(Calendar.HOUR_OF_DAY), c1.get(Calendar.MINUTE), c1.get(Calendar.SECOND));
        date5 = c.getTime();
    }

    /**
     * Test of areSameDates method.
     */
    @Test
    public void testAreSameDates() {
        
        assertTrue(CalendarUtilities.areSameDates(date1, date2));
    }
    
    /**
     * Test of areSameDates method.
     */
    @Test
    public void testAreSameDates_SameDate() {
        
        assertTrue(CalendarUtilities.areSameDates(date1, date1));
    }    

    /**
     * Test of areSameDates method.
     */
    @Test
    public void testAreSameDates_Year() {
        
        assertFalse(CalendarUtilities.areSameDates(date1, date3));
    }

    /**
     * Test of areSameDates method.
     */
    @Test
    public void testAreSameDates_Month() {
        
        assertFalse(CalendarUtilities.areSameDates(date1, date4));
    }

    /**
     * Test of areSameDates method.
     */
    @Test
    public void testAreSameDates_Date() {
        
        assertFalse(CalendarUtilities.areSameDates(date1, date5));
    }  
    
    /**
     * Test of areSameDates method.
     */
    @Test
    public void testAreSameDates_null() {
        assertFalse(CalendarUtilities.areSameDates(date1, null));        
        assertFalse(CalendarUtilities.areSameDates(null, date1));
        assertTrue(CalendarUtilities.areSameDates(null, null));        
    }    
}
