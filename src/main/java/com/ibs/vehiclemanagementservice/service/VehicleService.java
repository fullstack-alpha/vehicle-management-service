package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.model.VehiclePassRequest;
import com.ibs.vehiclemanagementservice.repository.VehicleRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {

    @Autowired
    private VehicleRequestRepository vehicleRequestRepository;

    public VehiclePassRequest addVehiclePassRequest(VehiclePassRequest vehiclePassRequest) {
        try {
            return vehicleRequestRepository.save(vehiclePassRequest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}