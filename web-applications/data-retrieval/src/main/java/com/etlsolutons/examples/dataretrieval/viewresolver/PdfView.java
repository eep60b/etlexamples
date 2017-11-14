package com.etlsolutons.examples.dataretrieval.viewresolver;

import com.etlsolutons.examples.dataretrieval.model.Invoice;
import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
            Document document, PdfWriter writer, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Invoice invoice = (Invoice) model.get("invoice");

        PdfPTable table = new PdfPTable(3);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBackgroundColor(Color.lightGray);

        table.addCell("Name");
        table.addCell("Book ID");
        table.addCell("Customer ID");
        table.addCell("Amount");

        table.addCell(String.valueOf(invoice.getId()));
        table.addCell(String.valueOf(invoice.getBookId()));
        table.addCell(String.valueOf(invoice.getCustomerId()));
        table.addCell(String.valueOf(invoice.getAmount()));

        document.add(table);
    }

}
