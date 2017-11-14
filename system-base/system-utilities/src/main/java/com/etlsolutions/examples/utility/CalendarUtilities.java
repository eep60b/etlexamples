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

import com.etlsolutions.examples.message.ErrorType;
import static com.etlsolutions.examples.message.MessageFactory.getMessage;
import com.etlsolutions.examples.utility.annotation.UtilityClass;
import java.util.Calendar;
import java.util.Date;

/**
 * The CalendarUtilities class contains utility methods for date, time and calendar.
 * 
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@UtilityClass
public final class CalendarUtilities {

    private CalendarUtilities() {
        throw new UnsupportedOperationException(getMessage(ErrorType.PRIVATE_CONSTRUCTOR));     
    }

    public static final boolean areSameDates(Date date1, Date date2) {
        
        if(date1 == date2) {
            return true;
        }
        
        if(date1 == null || date2 == null) {
            return false;
        }
        
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();        
        calendar2.setTime(date2);

        return  calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) 
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH) 
                && calendar1.get(Calendar.DATE) == calendar2.get(Calendar.DATE);
    }  
}
