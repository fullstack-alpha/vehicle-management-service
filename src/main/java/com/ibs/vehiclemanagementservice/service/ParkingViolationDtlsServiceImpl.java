package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.model.Employee;
import com.ibs.vehiclemanagementservice.model.ParkingViolation;
import com.ibs.vehiclemanagementservice.repository.ParkingViolationDtlsRepository;
import com.ibs.vehiclemanagementservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ParkingViolationDtlsServiceImpl implements ParkingViolationDtlsService {

    // The dao UserParkingViolationRepository repository will use the Mongodb-Repository to perform the database operations.
    @Autowired
    ParkingViolationDtlsRepository parkingViolationDtlsRepository;

    // The dao UserRepository repository will use the Mysql-Repository to perform the database operations.
    @Autowired
    private UserRepository userRepository;

    // 	 * Implementaion Method to create new parkingViolation in the db using mongo-db repository.
    @Override
    public void createParkingViolation(ParkingViolation dtls) {
        Random random = new Random();
        dtls.setViolationId(random.nextInt());
        parkingViolationDtlsRepository.insert(dtls);
    }

    //	 * Method to fetch all parkingViolation from the db using mongo-db repository.
    @Override
    public Collection<ParkingViolation> getAllParkingViolation() {
        return parkingViolationDtlsRepository.findAll();
    }

    //	 * Method to fetch parkingViolation by id using mongo-db repository.
    @Override
    public Optional<ParkingViolation> findParkingViolationById(int id) {
        return parkingViolationDtlsRepository.findById(id);
    }

    //	 * Method to delete parkingViolation by id using mongo-db repository.
    @Override
    public void deleteParkingViolationById(int id) {
        parkingViolationDtlsRepository.deleteByViolationId(id);
    }

    //	 * Method to update parkingViolation by id using mongo-db repository.
    @Override
    public void updateParkingViolation(ParkingViolation dtls) {
        parkingViolationDtlsRepository.save(dtls);
    }

    //	 * Method to delete all parkingViolation using mongo-db repository.
    @Override
    public void deleteAllParkingViolation() {
        parkingViolationDtlsRepository.deleteAll();
    }

    //	 * Method to fetch Employee info by id using Mysql-db repository.
    @Override
    public Optional<Employee> getEmployeeById(String empId) {
        Employee employee = userRepository.findByEmployeeId(empId)
                .orElseThrow(() -> new UsernameNotFoundException("Employee details not found with employee_id : " + empId));
        Optional<Employee> emp = Optional.of(employee);
        return emp;
    }

    //	 * Method to fetch parkingViolation by emp_id using mongo-db repository.
    @Override
    public List<ParkingViolation> getParkingViolationByEmpId(String empId) {
        List<ParkingViolation> parkingViolations = parkingViolationDtlsRepository.findByEmployeeId(empId);
        return parkingViolations;
    }

}