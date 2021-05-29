package com.project.favorite.recipes.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	private Integer userId;
	
	@Column(length = 15)
	private String userName;
	
	private String userPassword;
	
	@Column(length = 25)
	private String userEmailId;
	
	private String status;
	
	private LocalDate createdAt;
	
	private LocalDate updatedAt;

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userEmailId=" + userEmailId + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
