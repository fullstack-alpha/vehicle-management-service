package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.model.Employee;
import com.ibs.vehiclemanagementservice.model.VehicleDtls;

import java.util.Collection;
import java.util.Optional;

public interface UserVehicleDtlsService {

	/**
	 * Method to create new vehicleDtls in the db using mongo-db repository.
	 * @param dtls
	 */
	public void createVehicleDtls(VehicleDtls dtls);

	/**
	 * Method to fetch all vehicleDtls from the db using mongo-db repository.
	 * @return
	 */
	public Collection<VehicleDtls> getAllVehicleDtls();

	/**
	 * Method to fetch vehicleDtls by id using mongo-db repository.
	 * @param id
	 * @return
	 */
	public Optional<VehicleDtls> findVehicleDtlsById(int id);

	/**
	 * Method to delete vehicleDtls by id using mongo-db repository.
	 * @param id
	 */
	public void deleteVehicleDtlsById(int id);

	/**
	 * Method to update vehicleDtls by id using mongo-db repository.
	 * @param dtls
	 */
	public void updateVehicleDtls(VehicleDtls dtls);

	/**
	 * Method to delete all vehicleDtls using mongo-db repository.
	 */
	public void deleteAllVehicleDtls();

	/**
	 * Method to fetch employee details to auto populate by id using Mysql repository.
	 * @param empId
	 * @return
	 */
	public Optional<Employee> getEmployeeById(String empId);

	/**
	 * Method to fetch vehicleDtls by emp id using mongo-db repository.
	 * @param empId
	 * @return
	 */
	public Optional<VehicleDtls> getbyVehicleDtldByEmpId(String empId);

}