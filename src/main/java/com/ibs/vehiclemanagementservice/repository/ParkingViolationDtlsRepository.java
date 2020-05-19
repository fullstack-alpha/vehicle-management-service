package com.ibs.vehiclemanagementservice.repository;

import com.ibs.vehiclemanagementservice.model.ParkingViolation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ParkingViolationDtlsRepository extends MongoRepository<ParkingViolation, Integer> {

    List<ParkingViolation> findByEmployeeId(String empId);

}