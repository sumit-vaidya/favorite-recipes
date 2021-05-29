package com.project.favorite.recipes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.favorite.recipes.entity.Ingredients;
import com.project.favorite.recipes.model.IngredientsDTO;
import com.project.favorite.recipes.repository.IngredientsRepository;
import com.project.favorite.recipes.service.IIngredientsService;

@Service
public class IngredientsServiceImpl implements IIngredientsService {

	@Autowired
	IngredientsRepository ingredientsRepository;
	
	@Override
	public List<IngredientsDTO> searchAllIngredients() {
		List<Ingredients> ingredientsList = ingredientsRepository.findAll();

		List<IngredientsDTO> ingredientsDTOList = new ArrayList<>();

		ingredientsList.forEach(ingredient -> {
			IngredientsDTO ingredientsDTO = new IngredientsDTO();
			BeanUtils.copyProperties(ingredient, ingredientsDTO);
			ingredientsDTOList.add(ingredientsDTO);
		});

		return ingredientsDTOList;
	}

	@Override
	public String addIngredient(IngredientsDTO ingredientsDTO) {
		Ingredients ingredients=new Ingredients();
		BeanUtils.copyProperties(ingredientsDTO, ingredients);
		Ingredients searchedIngredients = ingredientsRepository.findByIngredientsName(ingredients.getIngredientsName());
		if(searchedIngredients != null && searchedIngredients.getIngredientId() != 0) {
			return "Ingredients already exist";
		}
		else {
			ingredientsRepository.save(ingredients);
			return "Ingredient is added to database";
		}
	}
	
	@Override
	public IngredientsDTO searchIngredientsByIngredientsName(String ingredientsName) {
		
		Ingredients ingredient=ingredientsRepository.findByIngredientsName(ingredientsName);
		
		IngredientsDTO ingredientsDTO = new IngredientsDTO();
		BeanUtils.copyProperties(ingredient, ingredientsDTO);
		
		return ingredientsDTO;
		
	}

	@Override
	public IngredientsDTO updateIngredient(IngredientsDTO ingredientsDTO) {
		Ingredients ingredients=new Ingredients();
		BeanUtils.copyProperties(ingredientsDTO, ingredients);
		if(ingredientsRepository.existsById(ingredients.getIngredientId())) {
			ingredientsRepository.saveAndFlush(ingredients);
			return ingredientsDTO;
		}
		else {
			
			return null;
		}
	}

	@Override
	public String deleteIngredient(Integer id) {
		if(ingredientsRepository.existsById(id)) {
			ingredientsRepository.deleteById(id);
			return "Ingredient is deleted from database";
		}
		else {
			return "Ingredient doesn't exist";
		}
	}

}
