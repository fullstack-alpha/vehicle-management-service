package com.ibs.vehiclemanagementservice.repository;

import com.ibs.vehiclemanagementservice.model.VehicleDtls;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserVehicleDtlsRepository extends MongoRepository<VehicleDtls, Integer> {

    List<VehicleDtls> findByEmployeeId(String empId);

}