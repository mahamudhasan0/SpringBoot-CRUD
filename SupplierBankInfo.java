/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asterisk.asterisk;

import java.util.Date;

public class SupplierBankInfo {

    private long supplierBankID;
    private String supplierBankName;
    private String supplierBranch;
    private String swiftCode;
    private String supplierName;
    private long createBy;
    private String createFromIP;
    private String createFromMAC;
    private Date createDate;

    public SupplierBankInfo() {
    }

    public SupplierBankInfo(long supplierBankID, String supplierBankName, String supplierBranch, String swiftCode, String supplierName, long createBy, String createFromIP, String createFromMAC, Date createDate) {
        this.supplierBankID = supplierBankID;
        this.supplierBankName = supplierBankName;
        this.supplierBranch = supplierBranch;
        this.swiftCode = swiftCode;
        this.supplierName = supplierName;
        this.createBy = createBy;
        this.createFromIP = createFromIP;
        this.createFromMAC = createFromMAC;
        this.createDate = createDate;
    }

    public SupplierBankInfo(long supplierBankID, String supplierBankName, String supplierBranch, String supplierName) {
        this.supplierBankID = supplierBankID;
        this.supplierBankName = supplierBankName;
        this.supplierBranch = supplierBranch;
        this.supplierName = supplierName;
    }

    public long getSupplierBankID() {
        return supplierBankID;
    }

    public void setSupplierBankID(long supplierBankID) {
        this.supplierBankID = supplierBankID;
    }

    public String getSupplierBankName() {
        return supplierBankName;
    }

    public void setSupplierBankName(String supplierBankName) {
        this.supplierBankName = supplierBankName;
    }

    public String getSupplierBranch() {
        return supplierBranch;
    }

    public void setSupplierBranch(String supplierBranch) {
        this.supplierBranch = supplierBranch;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public String getCreateFromMAC() {
        return createFromMAC;
    }

    public void setCreateFromMAC(String createFromMAC) {
        this.createFromMAC = createFromMAC;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
