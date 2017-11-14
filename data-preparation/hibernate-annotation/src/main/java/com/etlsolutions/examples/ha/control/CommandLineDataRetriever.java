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
package com.etlsolutions.examples.ha.control;

import com.etlsolutions.examples.data.spi.CategorySpi;
import com.etlsolutions.examples.ha.pojo.SoldItemPojo;
import com.etlsolutions.examples.ha.pojo.InvoicePojo;
import com.etlsolutions.examples.utility.annotation.OperationClass;
import com.etlsolutions.examples.utility.annotation.StatelessClass;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 * The CommandLineDataRetriever class contains one method which retrieve some
 * data from the connected database. This class is used as a quick test for the
 * database and hibernate settings.
 *
 * @author Zhipeng Chang
 * @version 1.0.0
 * @since 1.0.0
 */
@StatelessClass
@OperationClass
public final class CommandLineDataRetriever {

    /**
     * The method is used to test the database connection. It should run without
     * error and print out something according to the database data.
     */
    public void retrieve() {
        try {

            DataRetriever retriever = new DataRetriever();

            List<InvoicePojo> invoices = retriever.<InvoicePojo>findAll(QueryNames.findInvoicesNative);
            System.out.println(invoices.get(0).getViewInvoice().getId());
            System.out.println(invoices.get(1).getViewInvoice());

            List<SoldItemPojo> bookSoldPrice = retriever.<SoldItemPojo>findAll(QueryNames.findSoldItemsNative);
            System.out.println(bookSoldPrice.get(0).getQuantity());

            DatabaseManager databaseManager = DatabaseManager.getInstance();
            List<CategorySpi> categorys = databaseManager.findAll(CategorySpi.class);
            System.out.println(categorys.get(0).getName());
        } finally {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            sessionFactory.close();
            System.exit(0);
        }
    }

    @Override
    public boolean equals(Object obj) {

        return (obj instanceof CommandLineDataRetriever);
    }

    @Override
    public int hashCode() {
        return 503588274;
    }
}
