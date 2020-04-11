package com.ibs.vehiclemanagementservice.model;

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

	public VehicleDtls(int id, String vehicleType, String employeeId, String employeeName, String requestStatus, String vehicleNumber) {
		this.id = id;
		this.vehicleType = vehicleType;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.requestStatus = requestStatus;
		this.vehicleNumber = vehicleNumber;
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

	@Override
	public String toString() {
		return "VehicleDtls{" +
				"id=" + id +
				", vehicleType='" + vehicleType + '\'' +
				", employeeId='" + employeeId + '\'' +
				", employeeName='" + employeeName + '\'' +
				", requestStatus='" + requestStatus + '\'' +
				", vehicleNumber='" + vehicleNumber + '\'' +
				'}';
	}
}