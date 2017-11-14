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
package com.etlsolutions.dataretrieval.view;

import com.etlsolutions.dataretrieval.model.CustomerInfo;
import com.etlsolutions.dataretrieval.model.CustomerInvoicesInfo;
import com.etlsolutions.dataretrieval.model.InvoiceInfo;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.List;

/**
 * The PdfView class
 *
 * @author Zhipeng Chang
 */
//TODO: Implementation. Add tests. Add Java docs. Add annotations.
public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest req, HttpServletResponse resp) throws Exception {

        // Fonts
        Font fontTitle = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
        Font fontTag = new Font(FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.GREEN);

        CustomerInfo customerInfo = (CustomerInfo) model.get("customerInfo");
        InvoiceInfo invoiceInfo = (InvoiceInfo) model.get("invoiceInfo");
        CustomerInvoicesInfo customerInvoicesInfo = (CustomerInvoicesInfo) model.get("customerInvoicesInfo");

        if (invoiceInfo != null) {
            createInvoiceDocument(invoiceInfo, document, fontTitle, fontTag);
        } else if (customerInfo != null) {
            createCustomerDocument(customerInfo, document, fontTitle, fontTag);
        } else if (customerInvoicesInfo != null) {

            createCustomerInvoicesDocument(customerInvoicesInfo, document, fontTitle, fontTag);
        } else {
            createErrorDocument(document, fontTitle, fontTag);
        }
    }

    private void createCustomerInvoicesDocument(CustomerInvoicesInfo customerInvoicesInfo, Document document, Font fontTitle, Font fontTag) throws DocumentException {
        CustomerInfo customerInfo = customerInvoicesInfo.getCustomerInfo();
        document.add(new Chunk("Customer Name: "));
        Chunk customerName = new Chunk(String.valueOf(customerInfo.getName()), fontTitle);
        document.add(customerName);
        document.add(new Chunk(" "));

        // -- newline
        document.add(Chunk.NEWLINE);

        document.add(new Chunk("Customer ID: "));
        Chunk id = new Chunk(String.valueOf(customerInfo.getId()), fontTitle);
        document.add(id);
        document.add(new Chunk(" "));

        // -- newline
        document.add(Chunk.NEWLINE);

        List<InvoiceInfo> infos = customerInvoicesInfo.getInvoiceInfoList();

        for (InvoiceInfo info : infos) {

            createInvoiceDocument(info, document, fontTag, fontTag);

            // -- newline
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

        }
    }

    private void createInvoiceDocument(InvoiceInfo invoiceInfo, Document document, Font fontID, Font fontAmount) throws DocumentException {
        // 1.Title
        document.add(new Chunk("Invoice ID: "));
        Chunk title = new Chunk(String.valueOf(invoiceInfo.getId()), fontID);
        document.add(title);
        document.add(new Chunk(" "));

        // -- newline
        document.add(Chunk.NEWLINE);

        // 2. amount
        document.add(new Chunk("Amount: "));
        Chunk amount = new Chunk(String.valueOf(invoiceInfo.getAmount()), fontAmount);
        document.add(amount);
        document.add(new Chunk(" "));
    }

    private void createCustomerDocument(CustomerInfo customerInfo, Document document, Font fontTitle, Font fontTag) throws DocumentException {

        document.add(new Chunk("Customer Name: "));
        Chunk customerName = new Chunk(String.valueOf(customerInfo.getName()), fontTitle);
        document.add(customerName);
        document.add(new Chunk(" "));

        // -- newline
        document.add(Chunk.NEWLINE);

        document.add(new Chunk("Customer ID: "));
        Chunk id = new Chunk(String.valueOf(customerInfo.getId()), fontTitle);
        document.add(id);
        document.add(new Chunk(" "));
    }

    private void createErrorDocument(Document document, Font fontTitle, Font fontTag) throws DocumentException {

        document.add(new Chunk("Invalid documpent"));
    }
}
