package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.model.Employee;
import com.ibs.vehiclemanagementservice.repository.UserRepository;
import com.ibs.vehiclemanagementservice.security.CommonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Employee findEmployeeById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int employeeId = CommonRequest.getUserId(authentication);
        Employee employee = userRepository.findById(employeeId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        employee.setId(null);
        employee.setPassword(null);
        employee.setRole(null);
        return employee;
    }
}
