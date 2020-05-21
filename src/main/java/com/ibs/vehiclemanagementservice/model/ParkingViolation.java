package com.ibs.vehiclemanagementservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document(collection= "parkingViolationDtls")
public class ParkingViolation {
    @Id
    private Integer violationId;
    private String vehicleNo;
    private String employeeId;
    private String employeeName;
    private String dateOfOffence;
    private String remarks;


    public Integer getViolationId() {
        return violationId;
    }

    public void setViolationId(Integer violationId) {
        this.violationId = violationId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDateOfOffence() {
        return dateOfOffence;
    }

    public void setDateOfOffence(String dateOfOffence) {
        this.dateOfOffence = dateOfOffence;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public ParkingViolation(Integer violationId, String vehicleNo, String employeeId, String employeeName, String dateOfOffence, String remarks) {
        this.violationId = violationId;
        this.vehicleNo =  vehicleNo;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.dateOfOffence = dateOfOffence;
        this.remarks = remarks;

    }
}
