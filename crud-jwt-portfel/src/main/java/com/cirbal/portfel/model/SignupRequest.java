package com.cirbal.portfel.model;



import java.io.Serializable;

import java.util.Set;

import javax.persistence.Table;

@Table(name="signupRequest")
public class SignupRequest implements Serializable{
	
	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String email;
	private String password;
	
	private Set<String> role;
	
	public SignupRequest(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}