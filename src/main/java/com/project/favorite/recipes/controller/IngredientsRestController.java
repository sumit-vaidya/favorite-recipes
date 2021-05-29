package com.project.favorite.recipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.favorite.recipes.model.IngredientsDTO;
import com.project.favorite.recipes.service.IIngredientsService;

import io.swagger.annotations.ApiOperation;

@RestController
public class IngredientsRestController {
	
	@Autowired
	IIngredientsService  service;

	@GetMapping(value="/allIngredients", produces="application/json")
	@ApiOperation("Returns all ingredients details from Database")
	public ResponseEntity<List<IngredientsDTO>>  findAllIngredients() {
		
		List<IngredientsDTO>  productDTOList=service.searchAllIngredients();
		return new ResponseEntity<List<IngredientsDTO>>(productDTOList, HttpStatus.OK);
		
	}
	
}
