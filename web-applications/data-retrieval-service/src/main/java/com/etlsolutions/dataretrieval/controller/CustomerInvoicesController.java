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
package com.etlsolutions.dataretrieval.controller;

import com.etlsolutions.dataretrieval.model.CustomerInfo;
import com.etlsolutions.dataretrieval.model.CustomerInvoicesInfo;
import com.etlsolutions.dataretrieval.model.InvoiceInfo;
import com.etlsolutions.examples.dataretrieval.dao.CustomerDao;
import com.etlsolutions.examples.dataretrieval.dao.InvoiceDao;
import com.etlsolutions.examples.dataretrieval.model.Customer;
import com.etlsolutions.examples.dataretrieval.model.Invoice;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The CustomerInvoicesController class
 *
 * @author Zhipeng Chang
 */
//TODO: Implementation. Add tests. Add Java docs. Add annotations.
@Controller
@RequestMapping("/customerInvoices")
public class CustomerInvoicesController extends AbstractContextAwareController {

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public String processRequest(@PathVariable String customerId, ModelMap model) {
        try {
            return processItem(customerId, model);
        } catch (SQLException | RuntimeException | Error ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            return "empty-page";
        }
    }

    private String processItem(String customerId, ModelMap model) throws NumberFormatException, BeansException, SQLException {
        CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");

        Customer customer = customerDao.findById(Integer.parseInt(customerId));

        if (customer == null) {
            return "empty-page";
        }

        CustomerInfo customerInfo = new CustomerInfo(customer);

        InvoiceDao invoiceDao = (InvoiceDao) context.getBean("invoiceDao");

        Set<Invoice> invoices = invoiceDao.findAllForCustomer(customer);
        List<InvoiceInfo> invoiceInfos = new ArrayList<>();

        for (Invoice invoice : invoices) {
            invoiceInfos.add(new InvoiceInfo(invoice));
        }

        CustomerInvoicesInfo customerInvoicesInfo = new CustomerInvoicesInfo(customerInfo, invoiceInfos);

        model.addAttribute("customerInvoicesInfo", customerInvoicesInfo);
        return "customer-invoices";
    }
}
