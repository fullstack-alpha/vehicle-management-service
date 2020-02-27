package com.ibs.vehiclemanagementservice.controller;

import com.ibs.vehiclemanagementservice.model.VehiclePassRequest;
import com.ibs.vehiclemanagementservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/vehicle")
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

   @PostMapping("/add/vehiclePassRequest")
    public VehiclePassRequest addVehicelPassRequest(@RequestBody VehiclePassRequest vehiclePassRequest){
          return vehicleService.addVehiclePassRequest(vehiclePassRequest);
    }



}
