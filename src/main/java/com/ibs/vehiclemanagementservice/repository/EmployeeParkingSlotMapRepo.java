package com.ibs.vehiclemanagementservice.repository;

import com.ibs.vehiclemanagementservice.model.EmployeeParkingSlotMap;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeParkingSlotMapRepo extends MongoRepository<EmployeeParkingSlotMap, String> {
    List<EmployeeParkingSlotMap> findByEmployeeIdAndActive(Integer employeeId, boolean active);

    List<EmployeeParkingSlotMap> findByActive(boolean active);
}
