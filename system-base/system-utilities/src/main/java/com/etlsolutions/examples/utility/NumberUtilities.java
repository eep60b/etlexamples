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

import com.etlsolutions.examples.utility.annotation.UtilityClass;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@UtilityClass
public final class NumberUtilities {

    private NumberUtilities() {
    }
   
    
    /**
     * 
     * @param bigDecimal1
     * @param bigDecimal2
     * @return 
     */
    public static boolean equals(BigDecimal bigDecimal1, BigDecimal bigDecimal2) {

        return equals(bigDecimal1, bigDecimal2, 2);
    }   
    
    /**
     * 
     * @param bigDecimal1
     * @param bigDecimal2
     * @param scale
     * @return 
     */
    public static boolean equals(BigDecimal bigDecimal1, BigDecimal bigDecimal2, int scale) {

        return equals(bigDecimal1, bigDecimal2, scale, RoundingMode.HALF_UP);
    }    
    
    /**
     * 
     * @param bigDecimal1
     * @param bigDecimal2
     * @param scale
     * @param roundingMode
     * @return 
     */
    public static boolean equals(BigDecimal bigDecimal1, BigDecimal bigDecimal2, int scale, RoundingMode roundingMode) {
        
        if(bigDecimal1 == bigDecimal2) {
            return true;
        }
        
        if(bigDecimal1 == null || bigDecimal2 == null) {
            return false;
        }
        
        return bigDecimal1.setScale(scale, roundingMode).equals(bigDecimal2.setScale(scale, roundingMode));
    }
}
