/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asterisk.asterisk;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SupplierController {

    @Autowired
    JdbcTemplate jdbc;

    //------SUPPLIER BANK INFORMATION CRUD OPERATION------
    @RequestMapping("/saveBankInformation")
    public String saveStudentInformation(@RequestParam String BankInformation) {
        String returnValue;
        try {
            SupplierBankInfo supplier = new Gson().fromJson(BankInformation, SupplierBankInfo.class);
            String sql = "select supplierID from SupplierInfo where supplierName=?";
            long supplierID = jdbc.queryForObject(sql, Long.class, new Object[]{supplier.getSupplierName()});
            //---------------------------------
            sql = "select nvl(max(supplierBankID),0)+1 as num from SupplierBankInfo";
            long supplierBankID = jdbc.queryForObject(sql, Long.class);
            //------------------------------------
            sql = "insert into SupplierBankInfo(supplierBankID,supplierBankName,supplierBranch,"
                    + " swiftCode, supplierID, createBy, createFromIP, createFromMAC) values(?,?,?,?,?,?,?,?)";
            jdbc.update(sql, new Object[]{supplierBankID, supplier.getSupplierBankName(),
                supplier.getSupplierBranch(), supplier.getSwiftCode(), supplierID, supplier.getCreateBy(),
                supplier.getCreateFromIP(), supplier.getCreateFromMAC()});
            returnValue = "Bank information saved.";
        } catch (JsonSyntaxException | DataAccessException ex) {
            returnValue = ex.getMessage();
        }
        return new Gson().toJson(returnValue);
    }

    @RequestMapping("/retriveSupplierBankInformation")
    public String retriveSupplierBankInformation() {
        String sql = "select A.supplierBankID, A.supplierBankName, A.supplierBranch, "
                + "A.swiftCode, A.createBy, A.createFromIP, A.createFromMAC, B.supplierName "
                + "from SupplierBankInfo A, SupplierInfo B "
                + "where A.supplierID=B.supplierID order by supplierName asc";
        //-------------------------------------------------------------
        List<SupplierBankInfo> bankInformationList = jdbc.query(sql, new BeanPropertyRowMapper(SupplierBankInfo.class));
        return new Gson().toJson(bankInformationList);
    }

    @RequestMapping("/updateSupplierBankInfo")
    public String changeSupplierBankInformation(@RequestParam String bankSupplierInfo) {
        SupplierBankInfo supplierbankinfo = new Gson().fromJson(bankSupplierInfo, SupplierBankInfo.class);
        String returnValue;
        //-------------------------------------------------------------------------------
        String sql = "select supplierID from SupplierInfo where supplierName=?";
        long supplierID = jdbc.queryForObject(sql, Long.class, new Object[]{supplierbankinfo.getSupplierName()});
        //------------------------------------------------------------------------------------
        sql = "select supplierBankName from SupplierBankInfo where supplierBankID=?";
        String supplierName = jdbc.queryForObject(sql, String.class, new Object[]{supplierbankinfo.getSupplierBankID()});
        //----------------------------------------------------------------
        sql = "update SupplierBankInfo set supplierBankName=?, supplierBranch=?, supplierID=?"
                + " where supplierBankID=? and supplierBankName=?";
        jdbc.update(sql, new Object[]{supplierbankinfo.getSupplierBankName(),
            supplierbankinfo.getSupplierBranch(), supplierID, supplierbankinfo.getSupplierBankID(), supplierName});
        returnValue = "Bank Information changed.";
        return new Gson().toJson(returnValue);
    }

    @RequestMapping("/deleteSupplierBankInfo")
    public String deleteSupplierBankInfo(@RequestParam String supplierBankID) {
        String returnValue;
        try {
            String sql = "delete from SupplierBankInfo where supplierBankID=?";
            jdbc.update(sql, new Object[]{supplierBankID});
            returnValue = "Deleted Successfully";

        } catch (DataAccessException Ex) {
            returnValue = "Error on Deletion";
        }
        return new Gson().toJson(returnValue);

    }

    @RequestMapping("/retriveBankInformationByNameLike")
    public String retriveBankInformationByNameLike(@RequestParam String BankNameLike) {
        String sql = "select A.supplierBankID, A.supplierBankName, A.supplierBranch, "
                + "A.swiftCode, A.createBy,A.createFromIP, A.createFromMAC, B.supplierName "
                + "from SupplierBankInfo A, SupplierInfo B "
                + "where A.supplierID=B.supplierID and A.supplierBankName LIKE '%" + BankNameLike + "%' order by supplierBankName asc";
        List<SupplierBankInfo> studentInformationList = jdbc.query(sql, new BeanPropertyRowMapper(SupplierBankInfo.class));
        return new Gson().toJson(studentInformationList);
    }

    //----- SUPPLIER INFORMATION CRUD OPERATION--------
    @RequestMapping("/saveSupplierInformation")
    public String saveSupplierInformation(@RequestParam String supplierInfo) {
        String returnValue;
        try {
            SupplierInfo supplier = new Gson().fromJson(supplierInfo, SupplierInfo.class);
            String sql = "select supplierBankID from SupplierBankInfo where supplierBankName=?";
            long supplierBankID = jdbc.queryForObject(sql, Long.class, new Object[]{supplier.getSupplierBankName()});
            //---------------------------------
            sql = "select nvl(max(supplierID),0)+1 as num from SupplierInfo";
            long supplierID = jdbc.queryForObject(sql, Long.class);
            //------------------------------------
            sql = "insert into SupplierInfo(supplierID,supplierName,supplierAddress, binNumber, supplierCurrency, "
                    + "supplierGroup, supplierCategory, supplierType,contactPerson,contactNumber,secondaryContactNumber,"
                    + "mailingAddress, supplierEmail, supplierWebsite, supplierFaxNumber, supplierStatus, paymentTerms, "
                    + "creditLimit,discount, taxable, purchaseAccount, purchaseDiscountAccount,"
                    + " createBy, createFromIP, createFromMAC,supplierBankID)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbc.update(sql, new Object[]{supplierID, supplier.getSupplierName(), supplier.getSupplierAddress(),
                supplier.getBinNumber(), supplier.getSupplierCurrency(), supplier.getSupplierGroup(),
                supplier.getSupplierCategory(), supplier.getSupplierType(), supplier.getContactPerson(), supplier.getContactNumber(),
                supplier.getSecondaryContactNumber(), supplier.getMailingAddress(), supplier.getSupplierEmail(),
                supplier.getSupplierWebsite(), supplier.getSupplierFaxNumber(), supplier.getSupplierStatus(),
                supplier.getPaymentTerms(), supplier.getCreditLimit(), supplier.getDiscount(), supplier.getTaxable(),
                supplier.getPurchaseAccount(), supplier.getPurchaseDiscountAccount(), supplier.getCreateBy(),
                supplier.getCreateFromIP(), supplier.getCreateFromMAC(), supplierBankID});
            returnValue = "supplier information saved.";
        } catch (JsonSyntaxException | DataAccessException ex) {
            returnValue = ex.getMessage();
        }
        return new Gson().toJson(returnValue);
    }

    @RequestMapping("/retriveSupplierInformation")
    public String retriveSupplierInformation() {
        String sql = "select A.supplierID, A.supplierName, A.supplierAddress, A.binNumber,"
                + " A.supplierCurrency, A.supplierGroup, A.supplierCategory, A.supplierType, "
                + "A.contactPerson, A.contactNumber, A.secondaryContactNumber, A.mailingAddress,"
                + " A.supplierEmail, A.supplierWebsite, A.supplierFaxNumber, A.supplierStatus,"
                + " B.supplierBankName, A.paymentTerms,A.creditLimit, A.discount, A.taxable,"
                + " A.purchaseAccount, A.purchaseDiscountAccount, A.createBy, A.createFromIP, A.createFromMAC "
                + "from SupplierInfo A, SupplierBankInfo B "
                + "where A.supplierBankID=B.supplierBankID order by supplierBankName asc";
        //-------------------------------------------------------------
        List<SupplierInfo> supplierInformationList = jdbc.query(sql, new BeanPropertyRowMapper(SupplierInfo.class));
        return new Gson().toJson(supplierInformationList);
    }

    @RequestMapping("/changeSupplierInformation")
    public String changeSupplierInformation(@RequestParam String supplierInfo) {
        SupplierInfo supplier = new Gson().fromJson(supplierInfo, SupplierInfo.class);
        String returnValue;
        //-------------------------------------------------------------------------------
        String sql = "select supplierBankID from SupplierBankInfo where supplierBankName=?";
        long supplierBankID = jdbc.queryForObject(sql, Long.class, new Object[]{supplier.getSupplierBankName()});
        //------------------------------------------------------------------------------------
        sql = "select supplierName from SupplierInfo where supplierID=?";
        String supplierName = jdbc.queryForObject(sql, String.class, new Object[]{supplier.getSupplierID()});
        //----------------------------------------------------------------
        sql = "update SupplierInfo set supplierName=?, supplierAddress=?, supplierBankID=? where supplierID=? and supplierName=?";
        jdbc.update(sql, new Object[]{supplier.getSupplierName(),
            supplier.getSupplierAddress(), supplierBankID, supplier.getSupplierID(), supplierName});
        returnValue = "Student information changed.";
        return new Gson().toJson(returnValue);
    }

    @RequestMapping("/deleteSupplierInfo")
    public String deleteSupplierInfo(@RequestParam String supplierID) {
        String returnValue;
        try {
            String sql = "delete from SupplierInfo where supplierID=?";
            jdbc.update(sql, new Object[]{supplierID});
            returnValue = "Deleted Successfully";

        } catch (DataAccessException Ex) {
            returnValue = "Error on Deletion";
        }
        return new Gson().toJson(returnValue);

    }

    @RequestMapping("/retriveSupplierInformationByNameLike")
    public String retriveSupplierInformationByNameLike(@RequestParam String SupplierNameLike) {
        String sql = "select A.supplierID, A.supplierName, A.supplierAddress, A.binNumber,"
                + " A.supplierCurrency, A.supplierGroup, A.supplierCategory, A.supplierType,"
                + " A.contactPerson, A.contactNumber, A.secondaryContactNumber, A.mailingAddress,"
                + " A.supplierEmail, A.supplierWebsite, A.supplierFaxNumber, A.supplierStatus, "
                + "B.supplierBankName, A.paymentTerms,A.creditLimit, A.discount, A.taxable,"
                + " A.purchaseAccount, A.purchaseDiscountAccount, A.createBy, A.createFromIP, A.createFromMAC "
                + "from SupplierInfo A, SupplierBankInfo B "
                + "where A.supplierBankID=B.supplierBankID and A.supplierName LIKE '%" + SupplierNameLike + "%' order by supplierName asc";
        List<SupplierInfo> supplierInformationList = jdbc.query(sql, new BeanPropertyRowMapper(SupplierInfo.class));
        return new Gson().toJson(supplierInformationList);
    }

}
