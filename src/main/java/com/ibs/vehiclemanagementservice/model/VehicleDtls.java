package com.ibs.vehiclemanagementservice.model;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Mongo database annotation.
@Document(collection= "vehicledtls")
public class VehicleDtls {

	@Id
	private int id;
	private String vehicleType;
	private String employeeId;
	private String employeeName;
	private String requestStatus;
	private String vehicleNumber;
	private String emailId;

	public VehicleDtls(int id, String vehicleType, String employeeId, String employeeName, String requestStatus, String vehicleNumber, String emailId) {
		this.id = id;
		this.vehicleType = vehicleType;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.requestStatus = requestStatus;
		this.vehicleNumber = vehicleNumber;
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "VehicleDtls{" +
				"id=" + id +
				", vehicleType='" + vehicleType + '\'' +
				", employeeId='" + employeeId + '\'' +
				", employeeName='" + employeeName + '\'' +
				", requestStatus='" + requestStatus + '\'' +
				", vehicleNumber='" + vehicleNumber + '\'' +
				", emailId='" + emailId + '\'' +
				'}';
	}
}

