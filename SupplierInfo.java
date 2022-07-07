/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asterisk.asterisk;

import java.util.Date;

public class SupplierInfo {

    private long supplierID;
    private String supplierName;
    private String supplierAddress;
    private String binNumber;
    private String supplierCurrency;
    private String supplierGroup;
    private String supplierCategory;
    private String supplierType;
    private String contactPerson;
    private String contactNumber;
    private String secondaryContactNumber;
    private String mailingAddress;
    private String supplierEmail;
    private String supplierWebsite;
    private String supplierFaxNumber;
    private String supplierStatus;
    private String supplierBankName;
    private String paymentTerms;
    private String creditLimit;
    private String discount;
    private String taxable;
    private long purchaseAccount;
    private long purchaseDiscountAccount;
    private long createBy;
    private String createFromIP;
    private String createFromMAC;
    private Date createDate;

    public SupplierInfo() {
    }

    public SupplierInfo(long supplierID, String supplierName, String supplierAddress, String binNumber, String supplierCurrency, String supplierGroup, String supplierCategory, String supplierType, String contactPerson, String contactNumber, String secondaryContactNumber, String mailingAddress, String supplierEmail, String supplierWebsite, String supplierFaxNumber, String supplierStatus, String supplierBankName, String paymentTerms, String creditLimit, String discount, String taxable, long purchaseAccount, long purchaseDiscountAccount, long createBy, String createFromIP, String createFromMAC, Date createDate) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.binNumber = binNumber;
        this.supplierCurrency = supplierCurrency;
        this.supplierGroup = supplierGroup;
        this.supplierCategory = supplierCategory;
        this.supplierType = supplierType;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.secondaryContactNumber = secondaryContactNumber;
        this.mailingAddress = mailingAddress;
        this.supplierEmail = supplierEmail;
        this.supplierWebsite = supplierWebsite;
        this.supplierFaxNumber = supplierFaxNumber;
        this.supplierStatus = supplierStatus;
        this.supplierBankName = supplierBankName;
        this.paymentTerms = paymentTerms;
        this.creditLimit = creditLimit;
        this.discount = discount;
        this.taxable = taxable;
        this.purchaseAccount = purchaseAccount;
        this.purchaseDiscountAccount = purchaseDiscountAccount;
        this.createBy = createBy;
        this.createFromIP = createFromIP;
        this.createFromMAC = createFromMAC;
        this.createDate = createDate;
    }

    public String getCreateFromMAC() {
        return createFromMAC;
    }

    public void setCreateFromMAC(String createFromMAC) {
        this.createFromMAC = createFromMAC;
    }

    public long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(long supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String getSupplierCurrency() {
        return supplierCurrency;
    }

    public void setSupplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
    }

    public String getSupplierGroup() {
        return supplierGroup;
    }

    public void setSupplierGroup(String supplierGroup) {
        this.supplierGroup = supplierGroup;
    }

    public String getSupplierCategory() {
        return supplierCategory;
    }

    public void setSupplierCategory(String supplierCategory) {
        this.supplierCategory = supplierCategory;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSecondaryContactNumber() {
        return secondaryContactNumber;
    }

    public void setSecondaryContactNumber(String secondaryContactNumber) {
        this.secondaryContactNumber = secondaryContactNumber;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierWebsite() {
        return supplierWebsite;
    }

    public void setSupplierWebsite(String supplierWebsite) {
        this.supplierWebsite = supplierWebsite;
    }

    public String getSupplierFaxNumber() {
        return supplierFaxNumber;
    }

    public void setSupplierFaxNumber(String supplierFaxNumber) {
        this.supplierFaxNumber = supplierFaxNumber;
    }

    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public String getSupplierBankName() {
        return supplierBankName;
    }

    public void setSupplierBankName(String supplierBankName) {
        this.supplierBankName = supplierBankName;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTaxable() {
        return taxable;
    }

    public void setTaxable(String taxable) {
        this.taxable = taxable;
    }

    public long getPurchaseAccount() {
        return purchaseAccount;
    }

    public void setPurchaseAccount(long purchaseAccount) {
        this.purchaseAccount = purchaseAccount;
    }

    public long getPurchaseDiscountAccount() {
        return purchaseDiscountAccount;
    }

    public void setPurchaseDiscountAccount(long purchaseDiscountAccount) {
        this.purchaseDiscountAccount = purchaseDiscountAccount;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public String getCreateFromIP() {
        return createFromIP;
    }

    public void setCreateFromIP(String createFromIP) {
        this.createFromIP = createFromIP;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
