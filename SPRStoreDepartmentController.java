/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asterisk.asterisk;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
public class SPRStoreDepartmentController {

    @Autowired
    JdbcTemplate jdbc;
    private String sql;

    //------STORE INFORMATION CRUD OPERATION----------
    @RequestMapping("/saveStoreInformation")
    public String saveStoreInformation(@RequestParam String storeInformation) {
        String returnValue;
        try {
            StoreInformation store = new Gson().fromJson(storeInformation, StoreInformation.class);
            sql = "select nvl(max(storeID), 0)+1 as num from StoreInformation";
            long storeID = jdbc.queryForObject(sql, Long.class);
            //--------------------------------------------------------------------
            sql = "insert into StoreInformation(storeID, storeName, storeAddress, createBy, createFromIP, createFromMAC)"
                    + " values(?,?,?,?,?,?)";
            jdbc.update(sql, new Object[]{storeID, store.getStoreName(), store.getStoreAddress(), store.getCreateBy(),
                store.getCreateFromIP(), store.getCreateFromMAC()});
            returnValue = "Store Information Saved";
        } catch (JsonSyntaxException | DataAccessException ex) {
            returnValue = ex.getMessage();
        }
        return new Gson().toJson(returnValue);
    }

    @RequestMapping("/retriveStoreInformation")
    public String retriveStoreInformation() {

        String sql = "select storeID, storeName, storeAddress, createBy, createFromIP, createFromMAC from StoreInformation order by storeName asc";
        List<StoreInformation> storeInformationList = jdbc.query(sql, new BeanPropertyRowMapper(StoreInformation.class));
        return new Gson().toJson(storeInformationList);

    }

    @RequestMapping("/updateStoreInfo")
    public String updateStoreInfo(@RequestParam String storeInfo) {
        StoreInformation store = new Gson().fromJson(storeInfo, StoreInformation.class);
        String returnValue;
        try {
            String sql = "select count(*) from StoreInformation where storeName=? and storeID=?";
            int res = jdbc.queryForObject(sql, Integer.class, new Object[]{store.getStoreName(), store.getStoreID()});
            if (res > 0) {
                returnValue = "Exist Value";
            } else {
                String sqlr = "update StoreInformation set storeName=?, createBy=?, createFromIP=?, "
                        + "createFromMAC=? where storeID=?";
                jdbc.update(sqlr, new Object[]{store.getStoreName(), store.getCreateBy(),
                    store.getCreateFromIP(), store.getCreateFromMAC(), store.getStoreID()});
                returnValue = "Updated Record";
            }
        } catch (DataAccessException Ex) {
            returnValue = "Error" + Ex.getMessage();
        }
        return new Gson().toJson(returnValue);
    }

    @RequestMapping("/deleteStoreInformation")
    public String deleteStoreInformation(@RequestParam String storeID) {
        String returnValue;
        try {
            String sql = "delete from StoreInformation where storeID=?";
            jdbc.update(sql, new Object[]{storeID});
            returnValue = "Deleted Successfully";

        } catch (DataAccessException Ex) {
            returnValue = "Error on Deletion";
        }
        return new Gson().toJson(returnValue);

    }

    //-----------DEPARTMENT INFO CRUD OPERATION---------------------
    @RequestMapping("/saveDepartmentInfo")
    public String saveDepartmentInfo(@RequestParam String departmentInfo) {
        String returnValue;
        try {
            DepartmentInfo store = new Gson().fromJson(departmentInfo, DepartmentInfo.class);
            sql = "select nvl(max(departmentID), 0)+1 as num from DepartmentInfo";
            long departmentID = jdbc.queryForObject(sql, Long.class);
            //--------------------------------------------------------------------
            sql = "insert into DepartmentInfo(departmentID, departmentName,createBy, createFromIP, createFromMAC)"
                    + "values(?,?,?,?,?)";
            jdbc.update(sql, new Object[]{departmentID, store.getDepartmentName(), store.getCreateBy(),
                store.getCreateFromIP(), store.getCreateFromMAC()});
            returnValue = "Department Information Saved";
        } catch (JsonSyntaxException | DataAccessException ex) {
            returnValue = ex.getMessage();
        }
        return new Gson().toJson(returnValue);
    }

    @RequestMapping("/retriveDepartmentInfo")
    public String retriveDepartmentInfo() {

        String sql = "select departmentID, departmentName, createBy, createFromIP, createFromMAC from DepartmentInfo order by departmentName asc";
        List<DepartmentInfo> departmentInformationList = jdbc.query(sql, new BeanPropertyRowMapper(DepartmentInfo.class));
        return new Gson().toJson(departmentInformationList);

    }

    @RequestMapping("/updateDepartmentInfo")
    public String updateDepartmentInfo(@RequestParam String departmentInfo) {
        DepartmentInfo store = new Gson().fromJson(departmentInfo, DepartmentInfo.class);
        String returnValue;
        try {
            String sql = "select count(*) from DepartmentInfo where departmentName=? and departmentID=?";
            int res = jdbc.queryForObject(sql, Integer.class, new Object[]{store.getDepartmentName(), store.getDepartmentID()});
            if (res > 0) {
                returnValue = "Exist Value";
            } else {
                String sqlr = "update DepartmentInfo set departmentName=?, createBy=?, createFromIP=?, "
                        + "createFromMAC=? where departmentID=?";
                jdbc.update(sqlr, new Object[]{store.getDepartmentName(), store.getCreateBy(),
                    store.getCreateFromIP(), store.getCreateFromMAC(), store.getDepartmentID()});
                returnValue = "Updated Record";
            }
        } catch (DataAccessException Ex) {
            returnValue = "Error" + Ex.getMessage();
        }
        return new Gson().toJson(returnValue);
    }

    @RequestMapping("/deleteDepartmentInformation")
    public String deleteDepartmentInformation(@RequestParam String departmentID) {
        String returnValue;
        try {
            String sql = "delete from DepartmentInfo where departmentID=?";
            jdbc.update(sql, new Object[]{departmentID});
            returnValue = "Deleted Successfully";

        } catch (DataAccessException Ex) {
            returnValue = "Error on Deletion";
        }
        return new Gson().toJson(returnValue);
    }

    //-------------------SPR CRUD OPERATION------------------------
    @RequestMapping("/saveSprDetailsInfo")
    public String saveSprDetailsInfo(@RequestParam String masterDetailsInfo) {
        String returnValue = "";
        try {
            MasterDetails masterDetails = new Gson().fromJson(masterDetailsInfo, MasterDetails.class);
            SPRMaster sprMaster = new Gson().fromJson(masterDetails.getMaster(), SPRMaster.class);

            //---------SPR MASTER TABLE--------------   
            String sqlrss = "select nvl(max(requisitionID),0)+1 as num from SPRMaster";
            long requisitionID = jdbc.queryForObject(sqlrss, Long.class);

            String sql = "select storeID from StoreInformation where storeName=?";
            long storeID = jdbc.queryForObject(sql, Long.class, new Object[]{sprMaster.getStoreName()});

            sql = "insert into SPRMaster(requisitionID, sprNumber, storeID, requisitionDate, requiredDate,"
                    + " createBy, createFromIP, createFromMAC) values(?,?,?,?,?,?,?,?)";
            jdbc.update(sql, new Object[]{requisitionID, sprMaster.getSprNumber(), storeID,
                sprMaster.getRequisitionDate(), sprMaster.getRequiredDate(), sprMaster.getCreateBy(),
                sprMaster.getCreateFromIP(), sprMaster.getCreateFromMAC()});
            returnValue = "SPR MASTER information saved.";

            //--------- SPR DETAILS-----------    
            Type listType = new TypeToken<ArrayList<SPRDetails>>() {
            }.getType();
            List<SPRDetails> SPRDetailsList = new Gson().fromJson(masterDetails.getDetails(), listType);
            for (SPRDetails sprDetails : SPRDetailsList) {

                String sqls = "select itemID from Item where itemName=?";
                long itemID = jdbc.queryForObject(sqls, Long.class, new Object[]{sprDetails.getItemName()});

                String sqlrs = "select departmentID from DepartmentInfo where departmentName = ?";
                long departmentID = jdbc.queryForObject(sqlrs, Long.class, new Object[]{sprDetails.getDepartmentName()});

                sql = "insert into SPRDetails(requisitionID, slNo, itemID, remarks,"
                        + " requiredQuantity, departmentID) values(?,?,?,?,?,?)";
                jdbc.update(sql, new Object[]{requisitionID, sprDetails.getSlNo(), itemID, sprDetails.getRemarks(), sprDetails.getRequiredQuantity(), departmentID});
                returnValue = "SPR Details information saved.";
            }
        } catch (JsonSyntaxException | DataAccessException ex) {
            returnValue = ex.getMessage();
        }
        return new Gson().toJson(returnValue);
    }

    //--------------------RETRIVE ITEM NAME-------------------------------------
    @RequestMapping("/retriveItemName")
    public String retriveItemName() {
        String sql = "select itemName from Item order by itemName asc";
        List<String> itemNameList = jdbc.queryForList(sql, String.class);
        return new Gson().toJson(itemNameList);
    }

    //-------------RETRIVE ITEM UNIT NAME------------------------------
    @RequestMapping("/retriveItemUnitName")
    public String retriveItemUnitName(@RequestParam String itemName) {
        String sqlss = "select B.itemUnitName from Item A, ItemUnit B where A.itemUnitID = B.itemUnitID and A.itemName=?";
        String unitName = jdbc.queryForObject(sqlss, String.class, new Object[]{itemName});
        return new Gson().toJson(unitName);
    }

    //----------RETRIVE SPRMaster TABLE-------------------------------
    @RequestMapping("/retrieveSPRMaster")
    public String retrieveSPRMaster() {
        String sql = "select A.requisitionID, A.sprNumber, B.storeName , A.requisitionDate, "
                + "A.requiredDate from SPRMaster A, StoreInformation B "
                + "where A.storeID = B.storeID order by requisitionID asc";
        List<SPRMaster> itemList = jdbc.query(sql, new BeanPropertyRowMapper(SPRMaster.class));
        return new Gson().toJson(itemList);

    }

    //-------------------RETRIVE SPRDetails TABLE------------------------------------
    @RequestMapping("/retrieveSPRDetails")
    public String retrieveSPRDetails(@RequestParam int SPRID) {

        String sql = "select A.requisitionID, A.slNo, B.itemName, A.remarks, A.requiredQuantity, C.departmentName from"
                + " SPRDetails A, Item B, DepartmentInfo C where A.itemID = B.itemID and "
                + "A.departmentID = C.departmentID and requisitionID=" + SPRID + " order by slNo asc";

        List<SPRDetails> itemList = jdbc.query(sql, new BeanPropertyRowMapper(SPRDetails.class));
        return new Gson().toJson(itemList);

    }

    @RequestMapping("/deleteSPRMasterDetails")
    public String deleteSPRMasterDetails(@RequestParam long requisitionID) {
        String returnValue;
        try {
            String sqll = "delete from SPRMaster where requisitionID=?";
            jdbc.update(sqll, new Object[]{requisitionID});

            sqll = "delete from SPRDetails where requisitionID=?";
            jdbc.update(sqll, new Object[]{requisitionID});

            returnValue = "Record deleted";

        } catch (DataAccessException ex) {
            returnValue = "Error on delete";
        }
        return new Gson().toJson(returnValue);
    }

}
