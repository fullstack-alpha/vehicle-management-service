package com.ibs.vehiclemanagementservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document(collection= "parkingViolationDtls")
public class ParkingViolation {
    @Id
    private Integer violationId;
    private String employeeId;
    private String remarks;
    private Date dateOfOffence;

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

    public Date getDateOfOffence() {
        return dateOfOffence;
    }

    public void setDateOfOffence(Date dateOfOffence) {
        this.dateOfOffence = dateOfOffence;
    }

    public ParkingViolation(Integer violationId, String employeeId, String remarks, Date dateOfOffence) {
        this.violationId = violationId;
        this.employeeId = employeeId;
        this.remarks = remarks;
        this.dateOfOffence = dateOfOffence;
    }
}
