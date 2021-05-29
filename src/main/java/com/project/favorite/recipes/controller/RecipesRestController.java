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

import com.project.favorite.recipes.model.RecipesDTO;
import com.project.favorite.recipes.service.IRecipesService;

import io.swagger.annotations.ApiOperation;

@RestController
public class RecipesRestController {
	
	@Autowired
	IRecipesService  service;

	@GetMapping(value="/v1/recipes", produces="application/json")
	@ApiOperation("Returns all recipes details from database")
	public ResponseEntity<List<RecipesDTO>>  findAllRecipes() {
		
		List<RecipesDTO>  recipesDTOList=service.searchAllRecipes();
		return new ResponseEntity<List<RecipesDTO>>(recipesDTOList, HttpStatus.OK);		
	}
	
	@PostMapping(value="/v1/recipe/add", consumes="application/json", produces="text/plain")
	@ApiOperation("Adds a new recipe details to the database")
	public String addRecipe(@RequestBody RecipesDTO recipesDTO) {
		return service.addRecipe(recipesDTO);		
	}
	
	@PutMapping(value="/v1/recipe/update", consumes="application/json", produces="text/plain")
	@ApiOperation("Updates an existing recipe details in database")
	public  String  updateRecipe(@RequestBody RecipesDTO recipesDTO) {
		String message = "Recipe doesn't exist...";
		RecipesDTO dto=service.updateRecipe(recipesDTO);
		if(dto!=null) {
			message = "Recipe is updated...";
		}
		return message;
	}
	
	@GetMapping(value="/v1/recipe/{recipeName}", produces="application/json")
	@ApiOperation("Returns details of recipe from database belongs to a specific recipe name")
	public RecipesDTO  findRecipeByRecipeName(@PathVariable String recipeName) {
		return service.searchRecipeByRecipeName(recipeName);	
	}
	
	@DeleteMapping(value="/v1/recipe/delete/{id}")
	@ApiOperation("Deletes a specific recipe details from the database")
	public String deleteRecipe(@PathVariable Integer id) {
		return service.deleteRecipe(id);
	}
}
