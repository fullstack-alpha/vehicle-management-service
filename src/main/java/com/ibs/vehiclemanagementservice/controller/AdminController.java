package com.ibs.vehiclemanagementservice.controller;

import com.ibs.vehiclemanagementservice.model.VehicleDtls;
import com.ibs.vehiclemanagementservice.service.AdminService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/admin")
@CrossOrigin
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping(value = "vehicleDtls/getAll")
    public Page<VehicleDtls> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return adminService.getAllVehicleDtlsWithPagination(page, size);
    }

    @PutMapping(value = "vehicleDtls/update/{vehicleDtls-id}")
    public String update(@PathVariable(value = "vehicleDtls-id") int id, @RequestBody VehicleDtls dtls) {
        adminService.updateAndSendMail(dtls, id);
        return "VehicleDtls record for vehicleDtls-id= " + id + " updated.";
    }

}
