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

package com.etlsolutons.examples.dataretrieval.dao;

import com.etlsolutons.examples.dataretrieval.model.Invoice;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The App class
 *
 * @author Zhipeng Chang
 */

//TODO: Implementation. Add tests. Add Java docs. Add annotations.
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
        InvoiceDao invoiceDao = (InvoiceDao) context.getBean("invoiceDao");
        Invoice customer =  invoiceDao.findById(1);
        System.out.println(customer);
        
    }
}
