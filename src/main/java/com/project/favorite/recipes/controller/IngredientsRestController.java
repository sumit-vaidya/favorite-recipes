package com.project.favorite.recipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.favorite.recipes.model.IngredientsDTO;
import com.project.favorite.recipes.service.IIngredientsService;

import io.swagger.annotations.ApiOperation;

@RestController
public class IngredientsRestController {
	
	@Autowired
	IIngredientsService  service;

	@GetMapping(value="/allIngredients", produces="application/json")
	@ApiOperation("Returns all ingredients details from database")
	public ResponseEntity<List<IngredientsDTO>>  findAllIngredients() {
		
		List<IngredientsDTO>  productDTOList=service.searchAllIngredients();
		return new ResponseEntity<List<IngredientsDTO>>(productDTOList, HttpStatus.OK);		
	}
	
	@PostMapping(value="/ingredients/add", consumes="application/json", produces="text/plain")
	@ApiOperation("Adds a new ingredients details to the database")
	public String addIngredient(@RequestBody IngredientsDTO ingredientsDTO) {
		return service.addIngredient(ingredientsDTO);		
	}
	
	@PutMapping(value="/ingredients/update", consumes="application/json", produces="text/plain")
	@ApiOperation("Updates an existing ingredients details in database")
	public  String  updateIngredient(@RequestBody IngredientsDTO ingredientsDTO) {
		IngredientsDTO dto=service.updateIngredient(ingredientsDTO);
		if(dto==null) {
			return "ingredients doesn't exist ";
		}
		else {
			return "ingredients is updated";
		}
	}
	
	@GetMapping(value="/ingredients/{ingredientsName}", produces="application/json")
	@ApiOperation("Returns details of ingredients from database belongs to a specific ingredient name")
	public IngredientsDTO  findProductsByManufacturer(@PathVariable String ingredientsName) {
		return service.searchIngredientsByIngredientsName(ingredientsName);	
	}
	
	@DeleteMapping(value="/ingredients/delete/{id}")
	@ApiOperation("Deletes a specific ingredients details from the database")
	public String deleteIngredient(@PathVariable Integer id) {
		return service.deleteIngredient(id);
	}
}
