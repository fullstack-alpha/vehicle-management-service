package com.ibs.vehiclemanagementservice.controller;

import com.ibs.vehiclemanagementservice.model.Employee;
import com.ibs.vehiclemanagementservice.model.ParkingViolation;
import com.ibs.vehiclemanagementservice.service.ParkingViolationDtlsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value= "/parkingViolation")
public class ParkingViolationController {

    @Autowired
    ParkingViolationDtlsService parkingViolationDtlsService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to save parkingViolation in the db.
     * @param dtls
     * @return
     */
    @PostMapping(value= "create")
    public Integer create(@RequestBody ParkingViolation dtls) {
        logger.info("Saving ParkingViolation.");
        parkingViolationDtlsService.createParkingViolation(dtls);
        return dtls.getViolationId();
    }

    /**
     * Method to fetch all parkingViolation from the db.
     * @return
     */
    @GetMapping(value= "getall")
    public Collection<ParkingViolation> getAll() {
        logger.info("Getting all ParkingViolation.");
        return parkingViolationDtlsService.getAllParkingViolation();
    }

    /**
     * Method to fetch parkingViolation by id.
     * @param id
     * @return
     */
    @GetMapping(value= "getbyid/{parkingViolation-id}")
    public Optional<ParkingViolation> getById(@PathVariable(value= "parkingViolation-id") int id) {
        logger.info("Getting ParkingViolation with parkingViolation-id= {}.", id);
        return parkingViolationDtlsService.findParkingViolationById(id);
    }

    /**
     * Method to update parkingViolation by id.
     * @param id
     * @param dtls
     * @return
     */
    @PutMapping(value= "update/{parkingViolation-id}")
    public String update(@PathVariable(value= "parkingViolation-id") int id, @RequestBody ParkingViolation dtls) {
        logger.info("Updating parkingViolation with parkingViolation-id= {}.", id);
        dtls.setViolationId(id);
        parkingViolationDtlsService.updateParkingViolation(dtls);
        return "ParkingViolation record for parkingViolation-id= " + id + " updated.";
    }

    /**
     * Method to delete parkingViolation by id.
     * @param id
     * @return
     */
    @DeleteMapping(value= "delete/{parkingViolation-id}")
    public String delete(@PathVariable(value= "parkingViolation-id") int id) {
        logger.info("Deleting parkingViolation with parkingViolation-id= {}.", id);
        parkingViolationDtlsService.deleteParkingViolationById(id);
        return "ParkingViolation record for parkingViolation-id= " + id + " deleted.";
    }

    /**
     * Method to delete all parkingViolation from the db.
     * @return
     */
    @DeleteMapping(value= "deleteall")
    public String deleteAll() {
        logger.info("Deleting all ParkingViolation.");
        parkingViolationDtlsService.deleteAllParkingViolation();
        return "All parkingViolation records deleted.";
    }

    /**
     * Method to fetch employee info by id to show employee details.
     * @param empId
     * @return
     */
    @GetMapping(value= "employee/getbyid/{employee-id}")
    public Optional<Employee> getEmployeeById(@PathVariable(value= "employee-id") String empId) {
        logger.info("Getting Employee info with employee-id= {}.", empId);
        return parkingViolationDtlsService.getEmployeeById(empId);
    }

    /**
     * Method to fetch vehicledetails info by empid.
     * @param empId
     * @return
     */
    @GetMapping(value= "getbyempid/{emp-id}")
    public List<ParkingViolation> getParkingViolationByEmpId(@PathVariable(value= "emp-id") String empId) {
        logger.info("Getting parkingViolation info with employee-id= {}.", empId);
        return parkingViolationDtlsService.getParkingViolationByEmpId(empId);
    }
}