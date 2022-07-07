/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asterisk.asterisk;

public class SPRDetails {

    private long requisitionID;
    private long slNo;
    private String itemName;
    private String remarks;
    private long requiredQuantity;
    private String departmentName;

    public SPRDetails() {
    }

    public SPRDetails(long requisitionID, long slNo, String itemName, String remarks, long requiredQuantity, String departmentName) {
        this.requisitionID = requisitionID;
        this.slNo = slNo;
        this.itemName = itemName;
        this.remarks = remarks;
        this.requiredQuantity = requiredQuantity;
        this.departmentName = departmentName;
    }

    public long getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(long requisitionID) {
        this.requisitionID = requisitionID;
    }

    public long getSlNo() {
        return slNo;
    }

    public void setSlNo(long slNo) {
        this.slNo = slNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(long requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
