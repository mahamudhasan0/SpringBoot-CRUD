/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asterisk.asterisk;

import java.util.Date;


public class StoreInformation {
    long storeID;
    String storeName;
    String storeAddress;
    long createBy;
    String createFromIP;
    String createFromMAC;
    Date createDate;

    public StoreInformation() {
    }

    public StoreInformation(long storeID, String storeName, String storeAddress, long createBy, String createFromIP, String createFromMAC, Date createDate) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.createBy = createBy;
        this.createFromIP = createFromIP;
        this.createFromMAC = createFromMAC;
        this.createDate = createDate;
    }

    public long getStoreID() {
        return storeID;
    }

    public void setStoreID(long storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
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
