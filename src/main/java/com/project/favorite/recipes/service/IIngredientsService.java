package com.project.favorite.recipes.service;

import java.util.List;

import com.project.favorite.recipes.model.IngredientsDTO;

public interface IIngredientsService {
	List<IngredientsDTO>  searchAllIngredients();
}
