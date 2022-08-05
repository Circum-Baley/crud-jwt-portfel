package com.cirbal.portfel.config;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.cirbal.portfel.CrudJwtPortfelApplication;
import com.cirbal.portfel.services.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@PropertySource("classpath:/application.properties")
@Service
public class JwtUtil {
	private final static Logger log = LoggerFactory.getLogger(CrudJwtPortfelApplication.class);


	@Value("${jwt.secret}")
	private String jwtSecret;
	@Value("${jwt.expirationDateInMs}")
	private int jwtExpirationInMs;

	
	public void setjwtSecret(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

	
	public void setJwtExpirationInMs(int jwtExpirationInMs) {
		this.jwtExpirationInMs = jwtExpirationInMs;
	}

	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationInMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			log.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			log.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			log.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			log.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}
//	public boolean validateToken(String authToken) {
//		try {
//			Jws<Claims> claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//			return true;
//		} catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
//			throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
//		} catch (ExpiredJwtException ex) {
//			throw ex;
//		}
//	}

	public String getUsernameFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();

	}

	public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

		List<SimpleGrantedAuthority> roles = null;

		Boolean isAdmin = claims.get("isAdmin", Boolean.class);
		Boolean isUser = claims.get("isUser", Boolean.class);

		if (isAdmin != null && isAdmin) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}

		if (isUser != null && isAdmin) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return roles;

	}

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//@Service
//public class JwtUtil {
//
//	@Value("{jwtSecret}")
//	private String secret;
//	 
//	@Value("${jwtExpirationDateInMs}")
//	private int jwtExpirationDateInMs;
//	
//
//
//    public void setSecret(String secret) {
//        this.secret = secret;
//    }
//	
//
//	public void setJwtExpirationDateInMs(int jwtExpirationDateInMs) {
//		this.jwtExpirationDateInMs = jwtExpirationDateInMs;
//	}
//
//	// generate token for user
//	public String generateToken(UserDetails userDetails) {
//		Map<String, Object> claims = new HashMap<>();
//		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
//		if (roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
//			claims.put("isAdmin", true);
//		}
//		if (roles.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
//			claims.put("isUser", true);
//		}
//		return doGenerateToken(claims, userDetails.getUsername());
//	}
//
//	private String doGenerateToken(Map<String, Object> claims, String subject) {
//
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationDateInMs)).signWith(SignatureAlgorithm.HS512, secret).compact();
//	}
//
//}