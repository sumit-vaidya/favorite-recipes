package com.project.favorite.recipes.model;

import java.io.Serializable;

public class LoginUserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1092817027842742307L;
	
	private String userName;
	
	private String password;

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
	
}
