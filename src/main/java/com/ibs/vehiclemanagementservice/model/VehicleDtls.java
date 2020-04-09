package com.ibs.vehiclemanagementservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Mongo database annotation.
@Document(collection= "vehicledtls")
public class VehicleDtls {

	@Id
	private int id;
	private String vehicletype;
	private String employee_id;
	private String employee_name;
	private String requestStatus;
	private String vehicleNumber;

	public VehicleDtls(int id, String vehicletype, String employee_id, String employee_name, String requestStatus, String vehicleNumber) {
		this.id = id;
		this.vehicletype = vehicletype;
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.requestStatus = requestStatus;
		this.vehicleNumber = vehicleNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
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
				", vehicletype='" + vehicletype + '\'' +
				", employee_id='" + employee_id + '\'' +
				", employee_name='" + employee_name + '\'' +
				", requestStatus='" + requestStatus + '\'' +
				", vehicleNumber='" + vehicleNumber + '\'' +
				'}';
	}
}