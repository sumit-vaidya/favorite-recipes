package com.project.favorite.recipes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.favorite.recipes.entity.Ingredients;
import com.project.favorite.recipes.model.IngredientsDTO;
import com.project.favorite.recipes.repository.IngredientsRepository;
import com.project.favorite.recipes.service.IIngredientsService;

/**
 * {@link IngredientsServiceImpl}
 * 
 * Ingredients service is created to write business logic for ingredients
 * 
 * @author Sumit.Vaidya
 *
 */
@Service
public class IngredientsServiceImpl implements IIngredientsService {
	
	private static final Logger logger = LogManager.getLogger(IngredientsServiceImpl.class);
	
	@Autowired
	private IngredientsRepository ingredientsRepository;
	
	@Override
	public List<IngredientsDTO> searchAllIngredients() {
		logger.info("FR-INFO Method  IngredientsServiceImpl.searchAllIngredients");
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
		logger.info("FR-INFO Method  IngredientsServiceImpl.addIngredient");
		Ingredients ingredients=new Ingredients();
		BeanUtils.copyProperties(ingredientsDTO, ingredients);
		Ingredients searchedIngredients = ingredientsRepository.findByIngredientsName(ingredients.getIngredientsName());
		if(searchedIngredients != null && searchedIngredients.getIngredientId() != 0) {
			return "Ingredient already exists";
		}
		else {
			ingredientsRepository.save(ingredients);
			return "Ingredient is added to database";
		}
	}
	
	@Override
	public IngredientsDTO searchIngredientsByIngredientsName(String ingredientsName) {
		logger.info("FR-INFO Method  IngredientsServiceImpl.searchIngredientsByIngredientsName : "+ ingredientsName);
		Ingredients ingredient=ingredientsRepository.findByIngredientsName(ingredientsName);
		
		IngredientsDTO ingredientsDTO = new IngredientsDTO();
		BeanUtils.copyProperties(ingredient, ingredientsDTO);
		
		return ingredientsDTO;
		
	}

	@Override
	public IngredientsDTO updateIngredient(IngredientsDTO ingredientsDTO) {
		logger.info("FR-INFO Method  IngredientsServiceImpl.updateIngredient");
		Ingredients ingredients=new Ingredients();
		BeanUtils.copyProperties(ingredientsDTO, ingredients);
		if(ingredientsRepository.existsById(ingredients.getIngredientId())) {
			ingredientsRepository.saveAndFlush(ingredients);
			return ingredientsDTO;
		}
		return null;
	}

	@Override
	public String deleteIngredient(Integer id) {
		logger.info("FR-INFO Method  IngredientsServiceImpl.deleteIngredient : "+id);
		String message = "Ingredient doesn't exist";
		if(ingredientsRepository.existsById(id)) {
			ingredientsRepository.deleteById(id);
			message = "Ingredient is deleted from database";
		}
		return message;
	}

}
