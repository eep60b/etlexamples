package com.etlsolutions.dataretrieval.model;

import com.etlsolutions.examples.dataretrieval.model.Invoice;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "invoiceInfo")
public class InvoiceInfo {

    private int id;
    private String bookName;
    private String customerName;
    private double amount;

    public InvoiceInfo(Invoice invoice) {
        this(invoice.getId(), new BookInfo(invoice.getBook()).getName(), new CustomerInfo(invoice.getCustomer()).getName(), invoice.getAmount());
    }

    public InvoiceInfo(int id, String bookName, String customerName, double amount) {
        this.id = id;
        this.bookName = bookName;
        this.customerName = customerName;
        this.amount = amount;
    }

    public InvoiceInfo() {
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    @XmlElement
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCustomerName() {
        return customerName;
    }

    @XmlElement
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    @XmlElement
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
