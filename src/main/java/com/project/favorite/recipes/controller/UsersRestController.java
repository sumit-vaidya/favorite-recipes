package com.project.favorite.recipes.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.favorite.recipes.model.LoginUserDTO;
import com.project.favorite.recipes.model.RegisterUserDTO;
import com.project.favorite.recipes.service.IUserService;

import io.swagger.annotations.ApiOperation;

/**
 * {@link UsersRestController}
 * 
 * User rest controller for sign in and sign up functionality
 * 
 * @author Sumit.Vaidya
 *
 */

@RestController
public class UsersRestController {
	
	private static final Logger logger = LogManager.getLogger(UsersRestController.class);
	
	@Autowired
	private IUserService  service;
	
	@PostMapping("/v1/signUp")
	@ApiOperation("Adds new user to the database.")
	public boolean  addUser(@RequestBody RegisterUserDTO  registerUserDto) {
		logger.info("FR-INFO Method  UsersRestController.addUser");
		return service.addUser(registerUserDto);
	}
	
	@PostMapping("/v1/signIn")
	@ApiOperation("Returns login user details from database.")
	public  boolean  loginUser(@RequestBody  LoginUserDTO loginUserDto) {
		logger.info("FR-INFO Method  UsersRestController.loginUser");
		return  service.loginUser(loginUserDto);
	}
}
