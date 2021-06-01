package com.project.favorite.recipes.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
/**
 * {@link IngredientsRestController}
 * 
 * Ingredients rest controller to perform CRUD operations 
 * 
 * @author Sumit.Vaidya
 *
 */

@RestController
public class IngredientsRestController {
	
	private static final Logger logger = LogManager.getLogger(IngredientsRestController.class);
	
	@Autowired
	private IIngredientsService  service;
	
	@GetMapping(value="/v1/ingredients", produces="application/json")
	@ApiOperation("Returns all ingredients details from database.")
	public ResponseEntity<List<IngredientsDTO>>  findAllIngredients() {
		logger.info("FR-INFO Method  IngredientsRestController.findAllIngredients");
		List<IngredientsDTO>  ingredientsDTOList=service.searchAllIngredients();
		return new ResponseEntity<List<IngredientsDTO>>(ingredientsDTOList, HttpStatus.OK);		
	}
	
	@PostMapping(value="/v1/ingredient/add", consumes="application/json", produces="text/plain")
	@ApiOperation("Adds a new ingredients details to the database.")
	public String addIngredient(@RequestBody IngredientsDTO ingredientsDTO) {
		logger.info("FR-INFO Method  IngredientsRestController.addIngredient");
		return service.addIngredient(ingredientsDTO);		
	}
	
	@PutMapping(value="/v1/ingredient/update", consumes="application/json", produces="text/plain")
	@ApiOperation("Updates an existing ingredients details in database.")
	public  String  updateIngredient(@RequestBody IngredientsDTO ingredientsDTO) {
		logger.info("FR-INFO Method  IngredientsRestController.updateIngredient");
		String message = "Ingredient doesn't exist...";
		IngredientsDTO dto=service.updateIngredient(ingredientsDTO);
		if(dto!=null) {
			message = "Ingredient is updated...";
		}
		return message;
	}
	
	@GetMapping(value="/v1/ingredient/{ingredientsName}", produces="application/json")
	@ApiOperation("Returns details of ingredients from database belongs to a specific ingredient name.")
	public IngredientsDTO  findIngredientsByIngredientsName(@PathVariable String ingredientsName) {
		logger.info("FR-INFO Method  IngredientsRestController.findIngredientsByIngredientsName : " + ingredientsName);
		return service.searchIngredientsByIngredientsName(ingredientsName);	
	}
	
	@DeleteMapping(value="/v1/ingredient/delete/{id}")
	@ApiOperation("Deletes a specific ingredients details from the database.")
	public String deleteIngredient(@PathVariable Integer id) {
		logger.info("FR-INFO Method  IngredientsRestController.deleteIngredient : " + id);
		return service.deleteIngredient(id);
	}
}
