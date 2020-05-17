package com.ibs.vehiclemanagementservice.controller;

import com.ibs.vehiclemanagementservice.exception.VehicleDetailsNotFoundException;
import com.ibs.vehiclemanagementservice.model.Employee;
import com.ibs.vehiclemanagementservice.model.VehicleDtls;
import com.ibs.vehiclemanagementservice.service.UserVehicleDtlsService;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserVehicleDtlsController {

    @Autowired
    UserVehicleDtlsService vehicleDtlsService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to save vehicleDtls in the db.
     *
     * @param dtls
     * @return
     */
    @PostMapping(value = "vehicleDtls/create")
    public String create(@RequestBody VehicleDtls dtls) {
        logger.info("Saving VehicleDtls.");
        vehicleDtlsService.createVehicleDtls(dtls);
        return "VehicleDtls records created.";
    }

    /**
     * Method to fetch all vehicleDtls from the db.
     *
     * @return
     */
    @GetMapping(value = "vehicleDtls/getall")
    public Collection<VehicleDtls> getAll() {
        logger.info("Getting all VehicleDtls.");
        return vehicleDtlsService.getAllVehicleDtls();
    }

    /**
     * Method to fetch vehicleDtls by id.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "vehicleDtls/getbyid/{vehicleDtls-id}")
    public Optional<VehicleDtls> getById(@PathVariable(value = "vehicleDtls-id") int id) {
        logger.info("Getting VehicleDtls with vehicleDtls-id= {}.", id);
        return vehicleDtlsService.findVehicleDtlsById(id);
    }

    /**
     * Method to update vehicleDtls by id.
     *
     * @param id
     * @param dtls
     * @return
     */
    @PutMapping(value = "vehicleDtls/update/{vehicleDtls-id}")
    public String update(
            @PathVariable(value = "vehicleDtls-id") int id,
            @RequestBody VehicleDtls dtls) {
        logger.info("Updating vehicleDtls with vehicleDtls-id= {}.", id);
        final VehicleDtls vehicleDtls = vehicleDtlsService.findVehicleDtlsById(id)
                .orElseThrow(()-> new VehicleDetailsNotFoundException("No vehicle details found with this id"));
      	vehicleDtls.setRequestStatus(dtls.getRequestStatus());
        vehicleDtlsService.updateVehicleDtls(vehicleDtls);
        return "VehicleDtls record for vehicleDtls-id= " + id + " updated.";
    }

    /**
     * Method to delete vehicleDtls by id.
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "vehicleDtls/delete/{vehicleDtls-id}")
    public String delete(@PathVariable(value = "vehicleDtls-id") int id) {
        logger.info("Deleting vehicleDtls with vehicleDtls-id= {}.", id);
        vehicleDtlsService.deleteVehicleDtlsById(id);
        return "VehicleDtls record for vehicleDtls-id= " + id + " deleted.";
    }

    /**
     * Method to delete all vehicleDtls from the db.
     *
     * @return
     */
    @DeleteMapping(value = "vehicleDtls/deleteall")
    public String deleteAll() {
        logger.info("Deleting all VehicleDtls.");
        vehicleDtlsService.deleteAllVehicleDtls();
        return "All vehicleDtls records deleted.";
    }

    /**
     * Method to fetch employee info by emp id to show employee details.
     *
     * @param empId
     * @return
     */
    @GetMapping(value = "employee/getbyempid/{empId}")
    public Optional<Employee> getbyempid(@PathVariable(value = "empId") String empId) {
        logger.info("Getting Employee info with employee-id= {}.", empId);
        return vehicleDtlsService.getEmployeeByEmpId(empId);
    }

    /**
     * Method to fetch employee info by id to show employee details.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "employee/getbyid/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(value = "id") int id) {
        logger.info("Getting Employee info with id= {}.", id);
        return vehicleDtlsService.getEmployeeById(id);
    }

    /**
     * Method to fetch vehicledetails info by empid.
     *
     * @param empId
     * @return
     */
    @GetMapping(value = "vehicleDtls/getbyempid/{emp-id}")
    public List<VehicleDtls> getVehicleDtlsByEmpId(@PathVariable(value = "emp-id") String empId) {
        logger.info("Getting vehicleDtls info with employee-id= {}.", empId);
        return vehicleDtlsService.getVehicleDtlsByEmpId(empId);
    }
}