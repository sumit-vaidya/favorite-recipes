package com.project.favorite.recipes.service;

import java.util.List;

import com.project.favorite.recipes.model.RecipesDTO;

public interface IRecipesService {

	List<RecipesDTO> searchAllRecipes();

	String addRecipe(RecipesDTO recipesDTO);

	RecipesDTO searchRecipeByRecipeName(String recipeName);

	String deleteRecipe(Integer id);

	RecipesDTO updateRecipe(RecipesDTO recipesDTO);

}
