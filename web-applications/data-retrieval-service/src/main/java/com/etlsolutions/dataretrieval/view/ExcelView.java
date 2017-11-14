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
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * The ExcelView class
 *
 * @author Zhipeng Chang
 */
//TODO: Implementation. Add tests. Add Java docs. Add annotations.
public class ExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        CustomerInfo customerInfo = (CustomerInfo) model.get("customerInfo");
        InvoiceInfo invoiceInfo = (InvoiceInfo) model.get("invoicesInfo");
        CustomerInvoicesInfo customerInvoicesInfo = (CustomerInvoicesInfo) model.get("customerInvoicesInfo");

        if (invoiceInfo != null) {
            Sheet sheet = workbook.createSheet("Sheet 1");
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("Empty file");
            //TODO: add invalidy here.

        } else if (customerInfo != null) {
            Sheet sheet = workbook.createSheet("Sheet 1");
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("Empty file");
            
        } else if (customerInvoicesInfo != null) {

            customerInfo = customerInvoicesInfo.getCustomerInfo();

            Sheet sheet = workbook.createSheet(customerInfo.getName() + "(" + customerInfo.getId() + ")");
            List<InvoiceInfo> invoiceInfos = customerInvoicesInfo.getInvoiceInfoList();

            int r = 0;
            int c = 0;

            //Style for header cell
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            style.setAlignment(CellStyle.ALIGN_CENTER);

            //Create header cells
            Row row = sheet.createRow(r++);

            Cell cell = row.createCell(c++);
            cell.setCellStyle(style);
            cell.setCellValue("Invoice ID");

            cell = row.createCell(c++);
            cell.setCellStyle(style);
            cell.setCellValue("BOOK ID");

            cell = row.createCell(c++);
            cell.setCellStyle(style);
            cell.setCellValue("Amount");

            //Create data cell
            for (InvoiceInfo info : invoiceInfos) {
                row = sheet.createRow(r++);
                c = 0;
                row.createCell(c++).setCellValue(info.getId());
                row.createCell(c++).setCellValue(info.getBookName());
                row.createCell(c++).setCellValue(info.getAmount());
            }

            for (int i = 0; i < 4; i++) {
                sheet.autoSizeColumn(i, true);
            }
        }
    }
}
