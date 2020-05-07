package com.ibs.vehiclemanagementservice.controller;

import com.ibs.vehiclemanagementservice.model.Employee;
import com.ibs.vehiclemanagementservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/")
public class CommonController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employee")
    public ResponseEntity getEmployeeDetails()
    {
        return ResponseEntity.ok(employeeService.findEmployeeById());
    }
}
