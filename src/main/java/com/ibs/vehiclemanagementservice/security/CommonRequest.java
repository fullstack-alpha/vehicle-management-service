/**
 * This class contains commonly used methods.
 */
package com.ibs.vehiclemanagementservice.security;

import java.util.Collection;

import com.ibs.vehiclemanagementservice.constants.UserTypes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class CommonRequest {

	/**
	 * It returns user principal
	 * 
	 * @param authentication
	 * @return
	 */
	public static UserPrincipal getUserPrincipal(Authentication authentication) {

		return (UserPrincipal) authentication.getPrincipal();

	}

	/**
	 * Checking whether the user is superadmin or not
	 * 
	 * @param authentication
	 * @return
	 */
	public static boolean isSuperAdmin(Authentication authentication) {

		return getUserPrincipal(authentication).getAuthorities().stream().anyMatch(
				grantedAuthority -> grantedAuthority.getAuthority().equalsIgnoreCase(UserTypes.SUPER_ADMIN.toString()));
	}

	/**
	 * Checking whether the user is in-house admin or not
	 * 
	 * @param authentication
	 * @return
	 */
	public static boolean isInhouseAdmin(Authentication authentication) {

		return getUserPrincipal(authentication).getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority
				.getAuthority().equalsIgnoreCase(UserTypes.INHOUSE_ADMIN.toString()));
	}

	/**
	 * Checking whether the user is in-house user or not
	 * 
	 * @param authentication
	 * @return
	 */
	public static boolean isInhouseUser(Authentication authentication) {

		return getUserPrincipal(authentication).getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority
				.getAuthority().equalsIgnoreCase(UserTypes.INHOUSE_USER.toString()));
	}

	/**
	 * Getting user name from Authentication Manager
	 * 
	 * @param authentication
	 * @return
	 */
	public static String getUserEmail(Authentication authentication) {
		return getUserPrincipal(authentication).getEmail();
	}

	/**
	 * Generating custom logger from the application. This logger is used when the
	 * user did something with domain. like register a domain, change plan for a
	 * domain or deactivate a domain.
	 * 
	 * @param user
	 * @param domain
	 * @param message
	 * @return
	 */
	public static String getUserDomainLoggerInfo(String user, String domain, String message) {
		return String.format("USER :: %s :: DOMAIN :: %s :: MESSAGE :: %s", user, domain, message);
	}

	/**
	 * Generating custom logger from the application. This logger is when did any
	 * security related things
	 * 
	 * @param user
	 * @param domain
	 * @param message
	 * @return
	 */
	public static String getUserSecurityLoggerInfo(String user, String security, String message) {
		return String.format("USER :: %s :: SECURITY :: %s :: MESSAGE :: %s", user, security, message);
	}

	/**
	 * Generating custom logger from the application. This logger is used when the
	 * user did something with Role. like add a role, delete a role or update a
	 * role. This logger is only for super admin
	 * 
	 * @param user
	 * @param role
	 * @param message
	 * @return
	 */
	public static String getUserRoleLoggerInfo(String user, String role, String message) {
		return String.format("USER :: %s :: ROLE :: %s :: MESSAGE :: %s", user, role, message);
	}

	/**
	 * Generating custom logger from the application. This logger is used when the
	 * user did something with subscription plan.
	 * 
	 * @param user
	 * @param subscription
	 * @param message
	 * @return
	 */
	public static String getUserSubscriptionLoggerInfo(String user, String subscription, String message) {
		return String.format("USER :: %s :: SUBSCRIPTION :: %s :: MESSAGE :: %s", user, subscription, message);
	}

	/**
	 * Generating custom logger from the application. This logger is used when the
	 * user did something with user group.
	 * 
	 * @param user
	 * @param userGroup
	 * @param message
	 * @return
	 */
	public static String getUserUserGroupLoggerInfo(String user, String userGroup, String message) {
		return String.format("USER :: %s :: USERGROUP :: %s :: MESSAGE :: %s", user, userGroup, message);
	}

	/**
	 * This method is to get user id of loggined user. Once the user loggined then
	 * for that particular session the user details will be reserved. We can get the
	 * user details from Spring Security Context.
	 * 
	 * @param authentication
	 * @return
	 */
	public static Integer getUserId(Authentication authentication) {
		return getUserPrincipal(authentication).getId();
	}

	/**
	 * This method is to get user authorities. Once the user loggined then for that
	 * particular session the user details will be reserved.
	 * 
	 * @param authentication
	 * @return
	 */
	public static Collection<? extends GrantedAuthority> getGrantedAuthorities(Authentication authentication) {
		return getUserPrincipal(authentication).getAuthorities();
	}

	private CommonRequest() {

	}
}
