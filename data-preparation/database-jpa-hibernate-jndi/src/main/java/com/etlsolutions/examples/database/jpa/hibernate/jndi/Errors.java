/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "errors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Errors.findAll", query = "SELECT e FROM Errors e"),
    @NamedQuery(name = "Errors.findByEtlErrorid", query = "SELECT e FROM Errors e WHERE e.etlErrorid = :etlErrorid"),
    @NamedQuery(name = "Errors.findByEtlDateCreated", query = "SELECT e FROM Errors e WHERE e.etlDateCreated = :etlDateCreated"),
    @NamedQuery(name = "Errors.findByDealerCode", query = "SELECT e FROM Errors e WHERE e.dealerCode = :dealerCode"),
    @NamedQuery(name = "Errors.findByInvoiceNumber", query = "SELECT e FROM Errors e WHERE e.invoiceNumber = :invoiceNumber"),
    @NamedQuery(name = "Errors.findByErrormessage", query = "SELECT e FROM Errors e WHERE e.errormessage = :errormessage"),
    @NamedQuery(name = "Errors.findByEtlInvoiceid", query = "SELECT e FROM Errors e WHERE e.etlInvoiceid = :etlInvoiceid"),
    @NamedQuery(name = "Errors.findByEtlTableWithError", query = "SELECT e FROM Errors e WHERE e.etlTableWithError = :etlTableWithError")})
public class Errors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "etl_errorid")
    private Long etlErrorid;
    @Basic(optional = false)
    @Column(name = "etl_date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etlDateCreated;
    @Column(name = "dealer_code")
    private String dealerCode;
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @Basic(optional = false)
    @Column(name = "errormessage")
    private String errormessage;
    @Basic(optional = false)
    @Column(name = "etl_invoiceid")
    private String etlInvoiceid;
    @Column(name = "etl_table_with_error")
    private String etlTableWithError;

    public Errors() {
    }

    public Errors(Long etlErrorid) {
        this.etlErrorid = etlErrorid;
    }

    public Errors(Long etlErrorid, Date etlDateCreated, String errormessage, String etlInvoiceid) {
        this.etlErrorid = etlErrorid;
        this.etlDateCreated = etlDateCreated;
        this.errormessage = errormessage;
        this.etlInvoiceid = etlInvoiceid;
    }

    public Long getEtlErrorid() {
        return etlErrorid;
    }

    public void setEtlErrorid(Long etlErrorid) {
        this.etlErrorid = etlErrorid;
    }

    public Date getEtlDateCreated() {
        return etlDateCreated;
    }

    public void setEtlDateCreated(Date etlDateCreated) {
        this.etlDateCreated = etlDateCreated;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getEtlInvoiceid() {
        return etlInvoiceid;
    }

    public void setEtlInvoiceid(String etlInvoiceid) {
        this.etlInvoiceid = etlInvoiceid;
    }

    public String getEtlTableWithError() {
        return etlTableWithError;
    }

    public void setEtlTableWithError(String etlTableWithError) {
        this.etlTableWithError = etlTableWithError;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etlErrorid != null ? etlErrorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Errors)) {
            return false;
        }
        Errors other = (Errors) object;
        if ((this.etlErrorid == null && other.etlErrorid != null) || (this.etlErrorid != null && !this.etlErrorid.equals(other.etlErrorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.Errors[ etlErrorid=" + etlErrorid + " ]";
    }
    
}
