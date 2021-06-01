package com.project.favorite.recipes.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.favorite.recipes.entity.Users;
import com.project.favorite.recipes.model.LoginUserDTO;
import com.project.favorite.recipes.model.RegisterUserDTO;
import com.project.favorite.recipes.repository.UsersRepository;
import com.project.favorite.recipes.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public boolean addUser(RegisterUserDTO registerUserDto) {
		boolean flag = false;
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
		return (usersRepository.checkLogin(loginUserDto.getUserName(), loginUserDto.getPassword()) == 1) ? true : false;
	}

}
