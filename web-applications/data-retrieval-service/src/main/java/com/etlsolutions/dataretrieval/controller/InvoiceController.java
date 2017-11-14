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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.etlsolutions.dataretrieval.model.InvoiceInfo;
import com.etlsolutions.examples.dataretrieval.dao.InvoiceDao;
import com.etlsolutions.examples.dataretrieval.model.Invoice;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeansException;

//TODO: Implementation. Add tests. Add Java docs. Add annotations.
@Controller
@RequestMapping("/invoice")
public class InvoiceController extends AbstractContextAwareController {

    @RequestMapping(value = "{invoiceId}", method = RequestMethod.GET)
    public String processRequest(@PathVariable String invoiceId, ModelMap model) {
        try {
            return processItem(invoiceId, model);
        } catch (SQLException | RuntimeException | Error ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            return "empty-page";
        }
    }

    protected String processItem(String invoiceId, ModelMap model) throws NumberFormatException, SQLException, BeansException {
        InvoiceDao invoiceDao = (InvoiceDao) context.getBean("invoiceDao");
        Invoice invoice = invoiceDao.findById(Integer.parseInt(invoiceId));
        
        if (invoice == null) {
            return "empty-page";
        }
        
        InvoiceInfo invoiceInfo = new InvoiceInfo(invoice);
        model.addAttribute("invoiceInfo", invoiceInfo);
        return "invoice";
    }
}
