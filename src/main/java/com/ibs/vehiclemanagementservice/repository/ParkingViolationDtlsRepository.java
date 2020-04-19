package com.ibs.vehiclemanagementservice.repository;

import com.ibs.vehiclemanagementservice.model.ParkingViolation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ParkingViolationDtlsRepository extends MongoRepository<ParkingViolation, Integer> {

    Optional<ParkingViolation> findByEmployeeId(String empId);

}