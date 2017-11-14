package com.etlsolutons.examples.dataretrieval.viewresolver;

import com.etlsolutons.examples.dataretrieval.model.Invoice;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Invoice invoice = (Invoice) model.get("invoice");

        Sheet sheet = workbook.createSheet("sheet 1");
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);

        int rowCount = 0;
        int colCount = 0;

        // Create header cells
        Row row = sheet.createRow(rowCount++);

        Cell cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("ID");

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("Book ID");

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("Customer ID");

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("Amount");

        // Create data cells
        row = sheet.createRow(rowCount++);
        colCount = 0;
        row.createCell(colCount++).setCellValue(invoice.getId());
        row.createCell(colCount++).setCellValue(invoice.getBookId());
        row.createCell(colCount++).setCellValue(invoice.getCustomerId());
        row.createCell(colCount++).setCellValue(invoice.getAmount());

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i, true);
        }
    }
}
