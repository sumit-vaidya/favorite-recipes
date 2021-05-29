package com.project.favorite.recipes.service;

import java.util.List;

import com.project.favorite.recipes.model.IngredientsDTO;

public interface IIngredientsService {
	List<IngredientsDTO>  searchAllIngredients();

	String addIngredient(IngredientsDTO ingredientsDTO);

	IngredientsDTO updateIngredient(IngredientsDTO ingredientsDTO);

	String deleteIngredient(Integer id);

	IngredientsDTO searchIngredientsByIngredientsName(String ingredientsName);	
}
