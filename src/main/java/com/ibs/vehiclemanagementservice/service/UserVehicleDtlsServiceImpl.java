package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.model.Employee;
import com.ibs.vehiclemanagementservice.model.VehicleDtls;
import com.ibs.vehiclemanagementservice.repository.UserRepository;
import com.ibs.vehiclemanagementservice.repository.UserVehicleDtlsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserVehicleDtlsServiceImpl implements UserVehicleDtlsService {

	private static final String INTIAL_STATUS = "Pending";

	// The dao UserVehicleDtlsRepository repository will use the Mongodb-Repository to perform the database operations.
	@Autowired
	private UserVehicleDtlsRepository userVehicleDtlsRepository;

	@Autowired
	private NextSequenceService sequenceService;

	@Autowired
	private MongoTemplate mongoTemplate;

	// The dao UserRepository repository will use the Mysql-Repository to perform the database operations.
	@Autowired
	private UserRepository userRepository;

	// 	 * Implementaion Method to create new vehicleDtls in the db using mongo-db repository.
	@Override
	public void createVehicleDtls(VehicleDtls dtls) {
		dtls.setId(sequenceService.getNextSequence("customSequences"));
		dtls.setRequestStatus(INTIAL_STATUS);
		userVehicleDtlsRepository.insert(dtls);
	}

	//	 * Method to fetch all vehicleDtls from the db using mongo-db repository.
	@Override
	public Collection<VehicleDtls> getAllVehicleDtls() {
		return userVehicleDtlsRepository.findAll();
	}

	@Override
	public Page<VehicleDtls> getAllVehicleDtlsWithPagination(Integer page, Integer size) {

		Pageable pageable= PageRequest.of(page,size);
		return userVehicleDtlsRepository.findAll(pageable);
	}

	//	 * Method to fetch vehicleDtls by id using mongo-db repository.
	@Override
	public Optional<VehicleDtls> findVehicleDtlsById(int id) {
		return userVehicleDtlsRepository.findById(id);
	}

	//	 * Method to delete vehicleDtls by id using mongo-db repository.
	@Override
	public void deleteVehicleDtlsById(int id) {
		userVehicleDtlsRepository.deleteById(id);
	}

	//	 * Method to update vehicleDtls by id using mongo-db repository.
	@Override
	public void updateVehicleDtls(VehicleDtls dtls) {

			mongoTemplate.save(dtls);
			//userVehicleDtlsRepository.save(dtls);

	}

	//	 * Method to delete all vehicleDtls using mongo-db repository.
	@Override
	public void deleteAllVehicleDtls() {
		userVehicleDtlsRepository.deleteAll();
	}

	//	 * Method to fetch Employee info by emp id using Mysql-db repository.
	@Override
	public Optional<Employee> getEmployeeByEmpId(String empId) {
		Employee employee = userRepository.findByEmployeeId(empId)
				.orElseThrow(() -> new UsernameNotFoundException("Employee details not found with employee_id : " + empId));
		Optional<Employee> emp = Optional.of(employee);
		return emp;
	}

	//	 * Method to fetch Employee info by id using Mysql-db repository.
	@Override
	public Optional<Employee> getEmployeeById(int id) {
		Employee employee = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Employee details not found with id : " + id));
		Optional<Employee> emp = Optional.of(employee);
		return emp;
	}

	//	 * Method to fetch vehicleDtls by emp_id using mongo-db repository.
	@Override
	public List<VehicleDtls> getVehicleDtlsByEmpId(String empId) {
		List<VehicleDtls> vehicleDtls= userVehicleDtlsRepository.findByEmployeeId(empId);
		return vehicleDtls;
	}



}