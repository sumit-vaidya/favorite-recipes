package com.project.favorite.recipes.service.impl;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.favorite.recipes.entity.Users;
import com.project.favorite.recipes.model.LoginUserDTO;
import com.project.favorite.recipes.model.RegisterUserDTO;
import com.project.favorite.recipes.repository.UsersRepository;
import com.project.favorite.recipes.service.IUserService;

/**
 * {@link UserServiceImpl}
 * 
 * User service impl is created to handle sign in and sign up functionality for users
 * 
 * @author Sumit.Vaidya
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public boolean addUser(RegisterUserDTO registerUserDto) {
		logger.info("FR-INFO Method  UserServiceImpl.addUser");
		boolean flag = false;
		//trying to find if the user is already register by phone number
		if (!usersRepository.existsById(registerUserDto.getPhoneNumber())) {
			Users users = new Users();
			users.setPhoneNumber(registerUserDto.getPhoneNumber());
			users.setUserName(registerUserDto.getUserName());
			users.setUserPassword(registerUserDto.getPassword());
			users.setUserEmailId(registerUserDto.getUserEmailId());
			users.setCreatedAt(LocalDateTime.now());
			users.setUpdatedAt(LocalDateTime.now());
			usersRepository.save(users);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean loginUser(LoginUserDTO loginUserDto) {
		logger.info("FR-INFO Method  UserServiceImpl.loginUser");
		//checking if the current user is available for login
		return (usersRepository.checkLogin(loginUserDto.getUserName(), loginUserDto.getPassword()) == 1) ? true : false;
	}

}
