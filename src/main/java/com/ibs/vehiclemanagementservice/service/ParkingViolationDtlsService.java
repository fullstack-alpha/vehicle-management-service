package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.model.Employee;
import com.ibs.vehiclemanagementservice.model.ParkingViolation;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ParkingViolationDtlsService {

    /**
     * Method to create new parkingViolationDtls in the db using mongo-db repository.
     * @param dtls
     */
    public void createParkingViolation(ParkingViolation dtls);

    /**
     * Method to fetch all parkingViolationDtls from the db using mongo-db repository.
     * @return
     */
    public Collection<ParkingViolation> getAllParkingViolation();

    /**
     * Method to fetch parkingViolationDtls by id using mongo-db repository.
     * @param id
     * @return
     */
    public Optional<ParkingViolation> findParkingViolationById(int id);

    /**
     * Method to delete parkingViolationDtls by id using mongo-db repository.
     * @param id
     */
    public void deleteParkingViolationById(int id);

    /**
     * Method to update parkingViolationDtls by id using mongo-db repository.
     * @param dtls
     */
    public void updateParkingViolation(ParkingViolation dtls);

    /**
     * Method to delete all parkingViolationDtls using mongo-db repository.
     */
    public void deleteAllParkingViolation();

    /**
     * Method to fetch employee details to auto populate by id using Mysql repository.
     * @param empId
     * @return
     */
    public Optional<Employee> getEmployeeById(String empId);

    /**
     * Method to fetch parkingViolationDtls by emp id using mongo-db repository.
     * @param empId
     * @return
     */
    public List<ParkingViolation> getParkingViolationByEmpId(String empId);

}