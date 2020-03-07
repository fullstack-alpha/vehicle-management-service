package com.ibs.vehiclemanagementservice.repository;

import com.ibs.vehiclemanagementservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmployeeId(String email);

    Optional<Employee> findById(Integer id);

}
