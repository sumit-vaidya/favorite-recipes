package com.project.favorite.recipes.model;

import java.io.Serializable;

/**
 * {@link RegisterUserDTO}
 * 
 * Register user dto used to store register user information from UI and send to UI
 * 
 * @author Sumit.Vaidya
 *
 */
public class RegisterUserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9159626824295673397L;
	
	private Long phoneNumber;
	
	private String userName;
	
	private String password;
	
	private String userEmailId;
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	
}
