package com.example.getcash.GetCashApi.models;

public class UserModel {
private String username ; 
private String token; 
private String password; 
private String primaryRoll; 
private String tempRoll; 
private String locatInfo; 
private String email;
private String otpValid; 
private String status; 




public UserModel() {
	super();
	// TODO Auto-generated constructor stub
}

public UserModel(String username, String token, String password, String primaryRoll, String tempRoll, String locatInfo,
		String email, String otpValid, String status) {
	super();
	this.username = username;
	this.token = token;
	this.password = password;
	this.primaryRoll = primaryRoll;
	this.tempRoll = tempRoll;
	this.locatInfo = locatInfo;
	this.email = email;
	this.otpValid = otpValid;
	this.status = status;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
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
public String getPrimaryRoll() {
	return primaryRoll;
}
public void setPrimaryRoll(String primaryRoll) {
	this.primaryRoll = primaryRoll;
}
public String getTempRoll() {
	return tempRoll;
}
public void setTempRoll(String tempRoll) {
	this.tempRoll = tempRoll;
}
public String getLocatInfo() {
	return locatInfo;
}
public void setLocatInfo(String locatInfo) {
	this.locatInfo = locatInfo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getOtpValid() {
	return otpValid;
}
public void setOtpValid(String otpValid) {
	this.otpValid = otpValid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
} 


	
	
}
