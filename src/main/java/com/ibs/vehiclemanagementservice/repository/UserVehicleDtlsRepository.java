package com.ibs.vehiclemanagementservice.repository;

import com.ibs.vehiclemanagementservice.model.VehicleDtls;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVehicleDtlsRepository extends MongoRepository<VehicleDtls, Integer> {

}