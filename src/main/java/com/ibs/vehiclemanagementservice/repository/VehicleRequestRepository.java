package com.ibs.vehiclemanagementservice.repository;

import com.ibs.vehiclemanagementservice.model.VehiclePassRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRequestRepository extends MongoRepository<VehiclePassRequest,String> {
}
