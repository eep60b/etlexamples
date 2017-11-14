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
package com.etlsolutions.examples.primefaces.datatable.filter.calendar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Zhipeng Chang
 */
@ManagedBean(name = "datedCarService")
@ApplicationScoped
public class DatedCarService implements Serializable {
    
    private static final long serialVersionUID = 787505400128748931L;
            
    private final static String[] colors;
     
    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";
    }
         
    
      public List<DatedCar> createCars(int size) {
        List<DatedCar> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new DatedCar(getRandomId(), getRandomDate(), getRandomColor()));
        }
         
        return list;
    }
     
    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
     
    private Date getRandomDate() {
        
        long time = new Date().getTime();
               
        int hours = (int) (Math.random() * 360); 
        
        return new Date( time - hours*3600*1000);
    }  
 
    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }    
    
    public List<String> getColors() {
        return Arrays.asList(colors);
    }    
}
