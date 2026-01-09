package com.example.getcash.GetCashApi.models;

public class UserRegisterRequestResponseModel {

	private String name;
	private String email;
	private String mobile;
	private String authtoken;
	private String apiValidation;
	private String userStatus; 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAuthtoken() {
		return authtoken;
	}

	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}

	public String getApiValidation() {
		return apiValidation;
	}

	public void setApiValidation(String apiValidation) {
		this.apiValidation = apiValidation;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}
