package com.example.getcash.GetCashApi.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GETCASH_USER")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getcash_user_seq")
	@SequenceGenerator(name = "getcash_user_seq", sequenceName = "GETCASH_USER_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "EMAIL", length = 30)
	private String email;

	@Column(name = "ROLE_PRIMARY", length = 10)
	private String rolePrimary;

	@Column(name = "TEMPORARY_ROLE", length = 10)
	private String temporaryRole;

	@Column(name = "LOCATION_INFO", length = 10)
	private String locationInfo;
	
	
	@Value(instance.id)
	private String instaceid; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRolePrimary() {
		return rolePrimary;
	}

	public void setRolePrimary(String rolePrimary) {
		this.rolePrimary = rolePrimary;
	}
	public String getTemporaryRole() {
		return temporaryRole;
	}

	public void setTemporaryRole(String temporaryRole) {
		this.temporaryRole = temporaryRole;
	}

	public String getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		this.locationInfo = locationInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
