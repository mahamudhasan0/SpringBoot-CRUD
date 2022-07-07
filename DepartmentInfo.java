/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asterisk.asterisk;

import java.util.Date;

public class DepartmentInfo {

    private long departmentID;
    private String departmentName;
    private long createBy;
    private String createFromIP;
    private String createFromMAC;
    private Date createDate;

    public DepartmentInfo() {
    }

    public DepartmentInfo(long departmentID, String departmentName, long createBy, String createFromIP, String createFromMAC, Date createDate) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
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

    public long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(long departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
