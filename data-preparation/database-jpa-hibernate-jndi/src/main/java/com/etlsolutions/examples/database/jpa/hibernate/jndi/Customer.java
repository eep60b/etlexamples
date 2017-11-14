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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByEtlCustomerid", query = "SELECT c FROM Customer c WHERE c.etlCustomerid = :etlCustomerid"),
    @NamedQuery(name = "Customer.findByEtlDateCreated", query = "SELECT c FROM Customer c WHERE c.etlDateCreated = :etlDateCreated"),
    @NamedQuery(name = "Customer.findByEtlDateUpdated", query = "SELECT c FROM Customer c WHERE c.etlDateUpdated = :etlDateUpdated"),
    @NamedQuery(name = "Customer.findByCustomerUniqueId", query = "SELECT c FROM Customer c WHERE c.customerUniqueId = :customerUniqueId"),
    @NamedQuery(name = "Customer.findByCompanyName", query = "SELECT c FROM Customer c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Customer.findByTitle", query = "SELECT c FROM Customer c WHERE c.title = :title"),
    @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customer.findBySurnameField1", query = "SELECT c FROM Customer c WHERE c.surnameField1 = :surnameField1"),
    @NamedQuery(name = "Customer.findBySurnameField2", query = "SELECT c FROM Customer c WHERE c.surnameField2 = :surnameField2"),
    @NamedQuery(name = "Customer.findBySalutation", query = "SELECT c FROM Customer c WHERE c.salutation = :salutation"),
    @NamedQuery(name = "Customer.findByAddress1", query = "SELECT c FROM Customer c WHERE c.address1 = :address1"),
    @NamedQuery(name = "Customer.findByAddress2", query = "SELECT c FROM Customer c WHERE c.address2 = :address2"),
    @NamedQuery(name = "Customer.findByAddress3", query = "SELECT c FROM Customer c WHERE c.address3 = :address3"),
    @NamedQuery(name = "Customer.findByAddress4", query = "SELECT c FROM Customer c WHERE c.address4 = :address4"),
    @NamedQuery(name = "Customer.findByAddress5TownOrCity", query = "SELECT c FROM Customer c WHERE c.address5TownOrCity = :address5TownOrCity"),
    @NamedQuery(name = "Customer.findByAddress6County", query = "SELECT c FROM Customer c WHERE c.address6County = :address6County"),
    @NamedQuery(name = "Customer.findByAddress7PostcodeOrZipcode", query = "SELECT c FROM Customer c WHERE c.address7PostcodeOrZipcode = :address7PostcodeOrZipcode"),
    @NamedQuery(name = "Customer.findByAddress8Country", query = "SELECT c FROM Customer c WHERE c.address8Country = :address8Country"),
    @NamedQuery(name = "Customer.findByHomeTelephoneNumber", query = "SELECT c FROM Customer c WHERE c.homeTelephoneNumber = :homeTelephoneNumber"),
    @NamedQuery(name = "Customer.findByBusinessTelephoneNumber", query = "SELECT c FROM Customer c WHERE c.businessTelephoneNumber = :businessTelephoneNumber"),
    @NamedQuery(name = "Customer.findByMobileTelephoneNumber", query = "SELECT c FROM Customer c WHERE c.mobileTelephoneNumber = :mobileTelephoneNumber"),
    @NamedQuery(name = "Customer.findByEmailAddress1", query = "SELECT c FROM Customer c WHERE c.emailAddress1 = :emailAddress1"),
    @NamedQuery(name = "Customer.findByEmailAddress2", query = "SELECT c FROM Customer c WHERE c.emailAddress2 = :emailAddress2"),
    @NamedQuery(name = "Customer.findByPreferredLanguage", query = "SELECT c FROM Customer c WHERE c.preferredLanguage = :preferredLanguage"),
    @NamedQuery(name = "Customer.findByCompleteSuppression", query = "SELECT c FROM Customer c WHERE c.completeSuppression = :completeSuppression"),
    @NamedQuery(name = "Customer.findBySuppressionEmail", query = "SELECT c FROM Customer c WHERE c.suppressionEmail = :suppressionEmail"),
    @NamedQuery(name = "Customer.findBySuppressionPhone", query = "SELECT c FROM Customer c WHERE c.suppressionPhone = :suppressionPhone"),
    @NamedQuery(name = "Customer.findBySuppressionMail", query = "SELECT c FROM Customer c WHERE c.suppressionMail = :suppressionMail"),
    @NamedQuery(name = "Customer.findByGender", query = "SELECT c FROM Customer c WHERE c.gender = :gender"),
    @NamedQuery(name = "Customer.findByPrivateOwner", query = "SELECT c FROM Customer c WHERE c.privateOwner = :privateOwner"),
    @NamedQuery(name = "Customer.findByOwningCompany", query = "SELECT c FROM Customer c WHERE c.owningCompany = :owningCompany"),
    @NamedQuery(name = "Customer.findByUserchooserOrDriver", query = "SELECT c FROM Customer c WHERE c.userchooserOrDriver = :userchooserOrDriver"),
    @NamedQuery(name = "Customer.findByEmployerCompany", query = "SELECT c FROM Customer c WHERE c.employerCompany = :employerCompany"),
    @NamedQuery(name = "Customer.findByMonthAndYearOfBirth", query = "SELECT c FROM Customer c WHERE c.monthAndYearOfBirth = :monthAndYearOfBirth"),
    @NamedQuery(name = "Customer.findByPreferredMethodsOfContact", query = "SELECT c FROM Customer c WHERE c.preferredMethodsOfContact = :preferredMethodsOfContact"),
    @NamedQuery(name = "Customer.findByPermissionsForContact", query = "SELECT c FROM Customer c WHERE c.permissionsForContact = :permissionsForContact")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "etl_customerid")
    private String etlCustomerid;
    @Basic(optional = false)
    @Column(name = "etl_date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etlDateCreated;
    @Basic(optional = false)
    @Column(name = "etl_date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etlDateUpdated;
    @Column(name = "customer_unique_id")
    private String customerUniqueId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "title")
    private String title;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "surname_field_1")
    private String surnameField1;
    @Column(name = "surname_field_2")
    private String surnameField2;
    @Column(name = "salutation")
    private String salutation;
    @Column(name = "address_1")
    private String address1;
    @Column(name = "address_2")
    private String address2;
    @Column(name = "address_3")
    private String address3;
    @Column(name = "address_4")
    private String address4;
    @Column(name = "address_5_town_or_city")
    private String address5TownOrCity;
    @Column(name = "address_6_county")
    private String address6County;
    @Column(name = "address_7_postcode_or_zipcode")
    private String address7PostcodeOrZipcode;
    @Column(name = "address_8_country")
    private String address8Country;
    @Column(name = "home_telephone_number")
    private String homeTelephoneNumber;
    @Column(name = "business_telephone_number")
    private String businessTelephoneNumber;
    @Column(name = "mobile_telephone_number")
    private String mobileTelephoneNumber;
    @Column(name = "email_address_1")
    private String emailAddress1;
    @Column(name = "email_address_2")
    private String emailAddress2;
    @Column(name = "preferred_language")
    private String preferredLanguage;
    @Column(name = "complete_suppression")
    private String completeSuppression;
    @Column(name = "suppression_email")
    private String suppressionEmail;
    @Column(name = "suppression_phone")
    private String suppressionPhone;
    @Column(name = "suppression_mail")
    private String suppressionMail;
    @Column(name = "gender")
    private String gender;
    @Column(name = "private_owner")
    private String privateOwner;
    @Column(name = "owning_company")
    private String owningCompany;
    @Column(name = "userchooser_or_driver")
    private String userchooserOrDriver;
    @Column(name = "employer_company")
    private String employerCompany;
    @Column(name = "month_and_year_of_birth")
    private String monthAndYearOfBirth;
    @Column(name = "preferred_methods_of_contact")
    private String preferredMethodsOfContact;
    @Column(name = "permissions_for_contact")
    private String permissionsForContact;

    public Customer() {
    }

    public Customer(String etlCustomerid) {
        this.etlCustomerid = etlCustomerid;
    }

    public Customer(String etlCustomerid, Date etlDateCreated, Date etlDateUpdated) {
        this.etlCustomerid = etlCustomerid;
        this.etlDateCreated = etlDateCreated;
        this.etlDateUpdated = etlDateUpdated;
    }

    public String getEtlCustomerid() {
        return etlCustomerid;
    }

    public void setEtlCustomerid(String etlCustomerid) {
        this.etlCustomerid = etlCustomerid;
    }

    public Date getEtlDateCreated() {
        return etlDateCreated;
    }

    public void setEtlDateCreated(Date etlDateCreated) {
        this.etlDateCreated = etlDateCreated;
    }

    public Date getEtlDateUpdated() {
        return etlDateUpdated;
    }

    public void setEtlDateUpdated(Date etlDateUpdated) {
        this.etlDateUpdated = etlDateUpdated;
    }

    public String getCustomerUniqueId() {
        return customerUniqueId;
    }

    public void setCustomerUniqueId(String customerUniqueId) {
        this.customerUniqueId = customerUniqueId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurnameField1() {
        return surnameField1;
    }

    public void setSurnameField1(String surnameField1) {
        this.surnameField1 = surnameField1;
    }

    public String getSurnameField2() {
        return surnameField2;
    }

    public void setSurnameField2(String surnameField2) {
        this.surnameField2 = surnameField2;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress5TownOrCity() {
        return address5TownOrCity;
    }

    public void setAddress5TownOrCity(String address5TownOrCity) {
        this.address5TownOrCity = address5TownOrCity;
    }

    public String getAddress6County() {
        return address6County;
    }

    public void setAddress6County(String address6County) {
        this.address6County = address6County;
    }

    public String getAddress7PostcodeOrZipcode() {
        return address7PostcodeOrZipcode;
    }

    public void setAddress7PostcodeOrZipcode(String address7PostcodeOrZipcode) {
        this.address7PostcodeOrZipcode = address7PostcodeOrZipcode;
    }

    public String getAddress8Country() {
        return address8Country;
    }

    public void setAddress8Country(String address8Country) {
        this.address8Country = address8Country;
    }

    public String getHomeTelephoneNumber() {
        return homeTelephoneNumber;
    }

    public void setHomeTelephoneNumber(String homeTelephoneNumber) {
        this.homeTelephoneNumber = homeTelephoneNumber;
    }

    public String getBusinessTelephoneNumber() {
        return businessTelephoneNumber;
    }

    public void setBusinessTelephoneNumber(String businessTelephoneNumber) {
        this.businessTelephoneNumber = businessTelephoneNumber;
    }

    public String getMobileTelephoneNumber() {
        return mobileTelephoneNumber;
    }

    public void setMobileTelephoneNumber(String mobileTelephoneNumber) {
        this.mobileTelephoneNumber = mobileTelephoneNumber;
    }

    public String getEmailAddress1() {
        return emailAddress1;
    }

    public void setEmailAddress1(String emailAddress1) {
        this.emailAddress1 = emailAddress1;
    }

    public String getEmailAddress2() {
        return emailAddress2;
    }

    public void setEmailAddress2(String emailAddress2) {
        this.emailAddress2 = emailAddress2;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getCompleteSuppression() {
        return completeSuppression;
    }

    public void setCompleteSuppression(String completeSuppression) {
        this.completeSuppression = completeSuppression;
    }

    public String getSuppressionEmail() {
        return suppressionEmail;
    }

    public void setSuppressionEmail(String suppressionEmail) {
        this.suppressionEmail = suppressionEmail;
    }

    public String getSuppressionPhone() {
        return suppressionPhone;
    }

    public void setSuppressionPhone(String suppressionPhone) {
        this.suppressionPhone = suppressionPhone;
    }

    public String getSuppressionMail() {
        return suppressionMail;
    }

    public void setSuppressionMail(String suppressionMail) {
        this.suppressionMail = suppressionMail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrivateOwner() {
        return privateOwner;
    }

    public void setPrivateOwner(String privateOwner) {
        this.privateOwner = privateOwner;
    }

    public String getOwningCompany() {
        return owningCompany;
    }

    public void setOwningCompany(String owningCompany) {
        this.owningCompany = owningCompany;
    }

    public String getUserchooserOrDriver() {
        return userchooserOrDriver;
    }

    public void setUserchooserOrDriver(String userchooserOrDriver) {
        this.userchooserOrDriver = userchooserOrDriver;
    }

    public String getEmployerCompany() {
        return employerCompany;
    }

    public void setEmployerCompany(String employerCompany) {
        this.employerCompany = employerCompany;
    }

    public String getMonthAndYearOfBirth() {
        return monthAndYearOfBirth;
    }

    public void setMonthAndYearOfBirth(String monthAndYearOfBirth) {
        this.monthAndYearOfBirth = monthAndYearOfBirth;
    }

    public String getPreferredMethodsOfContact() {
        return preferredMethodsOfContact;
    }

    public void setPreferredMethodsOfContact(String preferredMethodsOfContact) {
        this.preferredMethodsOfContact = preferredMethodsOfContact;
    }

    public String getPermissionsForContact() {
        return permissionsForContact;
    }

    public void setPermissionsForContact(String permissionsForContact) {
        this.permissionsForContact = permissionsForContact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etlCustomerid != null ? etlCustomerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.etlCustomerid == null && other.etlCustomerid != null) || (this.etlCustomerid != null && !this.etlCustomerid.equals(other.etlCustomerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.Customer[ etlCustomerid=" + etlCustomerid + " ]";
    }
    
}
