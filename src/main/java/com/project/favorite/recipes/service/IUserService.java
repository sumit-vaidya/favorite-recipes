package com.project.favorite.recipes.service;

import com.project.favorite.recipes.model.LoginUserDTO;
import com.project.favorite.recipes.model.RegisterUserDTO;

public interface IUserService {
	
	boolean addUser(RegisterUserDTO registerUserDto);

	boolean loginUser(LoginUserDTO loginUserDto);
}
