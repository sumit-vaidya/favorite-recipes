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
	IngredientsRepository productRepository;
	
	@Override
	public List<IngredientsDTO> searchAllIngredients() {
		List<Ingredients> ingredientsList = productRepository.findAll();

		List<IngredientsDTO> ingredientsDTOList = new ArrayList<>();

		ingredientsList.forEach(ingredient -> {
			IngredientsDTO ingredientsDTO = new IngredientsDTO();
			BeanUtils.copyProperties(ingredient, ingredientsDTO);
			ingredientsDTOList.add(ingredientsDTO);
		});

		return ingredientsDTOList;
	}

}
