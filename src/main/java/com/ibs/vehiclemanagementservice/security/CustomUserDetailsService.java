package com.ibs.vehiclemanagementservice.security;

import com.ibs.vehiclemanagementservice.model.Employee;

import com.ibs.vehiclemanagementservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String empId) {

		Employee employee = userRepository.findByEmployeeId(empId)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username or email : " + empId));

		return UserPrincipal.create(employee);
	}

	@Transactional
	public UserDetails loadUserById(Long id) {
		Employee employee = userRepository.findById(id.intValue()).orElseThrow(() -> new UsernameNotFoundException(String.valueOf(id), null));

		return UserPrincipal.create(employee);
	}
}