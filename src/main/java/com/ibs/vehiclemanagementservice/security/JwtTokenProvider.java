package com.ibs.vehiclemanagementservice.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author vigil
 *
 */
@Component
public class JwtTokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Value("${app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${app.jwtIssuer}")
	private String jwtIssuer;

	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	@Value("${app.jwtSecret.register}")
	private String jwtRegister;

	@Value("${app.jwtExpirationInMs.register}")
	private int jwtExpirationInMsRegister;

	public String generateToken(Authentication authentication) {

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

		Claims claims = Jwts.claims().setSubject(Long.toString(CommonRequest.getUserId(authentication)));
		claims.put("scopes", CommonRequest.getGrantedAuthorities(authentication));
		
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date())
				.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

		return Long.parseLong(claims.getSubject());
	}

	public String refreshToken(String token) {

		String refreshedToken;
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			claims.setIssuedAt(new Date());
			refreshedToken = Jwts.builder().setClaims(claims).setExpiration(expiryDate)
					.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		} catch (Exception e) {
			return null;
		}
		return refreshedToken;
	}

	private Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	/**
	 * Getting the token from Authentication header
	 */
	public String getToken(HttpServletRequest request) {

		String authHeader = getAuthHeaderFromHeader(request);
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}

		return null;
	}

	private String getAuthHeaderFromHeader(HttpServletRequest request) {
		return request.getHeader("Authorization");
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			logger.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			logger.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			logger.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			logger.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			logger.error("JWT claims string is empty.");
		}
		return false;
	}
}
