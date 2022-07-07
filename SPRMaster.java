/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asterisk.asterisk;

import java.util.Date;

public class SPRMaster {

    private long requisitionID;
    private long sprNumber;
    private String storeName;
    private Date requisitionDate;
    private Date requiredDate;
    private long createBy;
    private String createFromIP;
    private String createFromMAC;
    private Date createDate;

    public SPRMaster() {
    }

    public SPRMaster(long requisitionID, long sprNumber, String storeName, Date requisitionDate, Date requiredDate, long createBy, String createFromIP, String createFromMAC, Date createDate) {
        this.requisitionID = requisitionID;
        this.sprNumber = sprNumber;
        this.storeName = storeName;
        this.requisitionDate = requisitionDate;
        this.requiredDate = requiredDate;
        this.createBy = createBy;
        this.createFromIP = createFromIP;
        this.createFromMAC = createFromMAC;
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(long requisitionID) {
        this.requisitionID = requisitionID;
    }

    public long getSprNumber() {
        return sprNumber;
    }

    public void setSprNumber(long sprNumber) {
        this.sprNumber = sprNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getRequisitionDate() {
        return requisitionDate;
    }

    public void setRequisitionDate(Date requisitionDate) {
        this.requisitionDate = requisitionDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
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

}
