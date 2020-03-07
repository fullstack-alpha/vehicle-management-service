package com.ibs.vehiclemanagementservice.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "active")
	private boolean active;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public UserRole(String roleName, boolean active) {
		this.roleName = roleName;
		this.active = active;
	}

	public UserRole() {
	}

}
