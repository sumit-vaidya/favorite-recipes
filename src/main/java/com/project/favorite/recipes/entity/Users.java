package com.project.favorite.recipes.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.project.favorite.recipes.converter.LocalDateTimeConverter;

@Entity
public class Users {
	
	@Id
	@Column(name="PHONE_NO")
	private  Long  phoneNumber;
	
	@Column(length = 20)
	private String userName;
	
	@Column(length = 20)
	private String userPassword;
	
	@Column(length = 30)
	private String userEmailId;
	
	private String status;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime createdAt;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime updatedAt;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Users [phoneNumber=" + phoneNumber + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userEmailId=" + userEmailId + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
