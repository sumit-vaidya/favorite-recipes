package com.project.favorite.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.favorite.recipes.model.LoginUserDTO;
import com.project.favorite.recipes.model.RegisterUserDTO;
import com.project.favorite.recipes.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserRestController {
	
	@Autowired
	IUserService  service;
	
	@PostMapping("/v1/signUp")
	@ApiOperation("Adds new user to the database")
	public boolean  addUser(@RequestBody RegisterUserDTO  registerUserDto) {
		return service.addUser(registerUserDto);
	}
	
	@PostMapping("/v1/signIn")
	@ApiOperation("Returns login user details from database")
	public  boolean  loginUser(@RequestBody  LoginUserDTO loginUserDto) {
		return  service.loginUser(loginUserDto);
	}
}
