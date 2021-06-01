package com.project.favorite.recipes.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.favorite.recipes.entity.Recipes;
import com.project.favorite.recipes.entity.SelectedIngredients;
import com.project.favorite.recipes.model.RecipesDTO;
import com.project.favorite.recipes.model.SelectedIngredientsDTO;
import com.project.favorite.recipes.repository.RecipesRepository;
import com.project.favorite.recipes.service.IRecipesService;

@Service
public class RecipesServiceImpl implements IRecipesService {

	@Autowired
	private RecipesRepository recipesRepository;
	
	@Override
	public List<RecipesDTO> searchAllRecipes() {
		List<Recipes> recipesList = recipesRepository.findAll();

		List<RecipesDTO> recipesDTOList = new ArrayList<>();

		for(Recipes recipe : recipesList) {
			RecipesDTO recipesDTO = new RecipesDTO();
			recipesDTO.setRecipesId(recipe.getRecipesId());
			recipesDTO.setRecipesName(recipe.getRecipesName());
			recipesDTO.setRecipesType(recipe.getRecipesType());
			recipesDTO.setNoOfPerson(recipe.getNoOfPerson());
			recipesDTO.setCookingInstruction(recipe.getCookingInstruction());
			List<SelectedIngredientsDTO> list = new ArrayList<SelectedIngredientsDTO>();
			for(SelectedIngredients selected : recipe.getSelectedIngredients()) {
				SelectedIngredientsDTO selectedDto = new SelectedIngredientsDTO();
				selectedDto.setSelectedIngredientId(selected.getSelectedIngredientId());
				selectedDto.setSelectedIngredientsName(selected.getSelectedIngredientsName());
				list.add(selectedDto);
			}
			recipesDTO.setSelectedIngredientsList(list);
			recipesDTOList.add(recipesDTO);
		};

		return recipesDTOList;
	}

	@Override
	public String addRecipe(RecipesDTO recipesDTO) {
		Recipes recipes=new Recipes();
		recipes.setRecipesId(recipesDTO.getRecipesId());
		recipes.setRecipesName(recipesDTO.getRecipesName());
		recipes.setRecipesType(recipesDTO.getRecipesType());
		recipes.setNoOfPerson(recipesDTO.getNoOfPerson());
		List<SelectedIngredientsDTO> list = recipesDTO.getSelectedIngredientsList();
		List<SelectedIngredients> selectedIngredientsList = new ArrayList<>();
		for(SelectedIngredientsDTO dto : list) {
			SelectedIngredients selectedIngredients =new SelectedIngredients();
			selectedIngredients.setSelectedIngredientId(dto.getSelectedIngredientId());
			selectedIngredients.setSelectedIngredientsName(dto.getSelectedIngredientsName());
			selectedIngredients.setCreatedAt(LocalDateTime.now());
			selectedIngredients.setCreatedAt(LocalDateTime.now());
			selectedIngredientsList.add(selectedIngredients);
		}
		recipes.setSelectedIngredients(selectedIngredientsList);
		recipes.setCookingInstruction(recipesDTO.getCookingInstruction());
		recipes.setCreatedAt(LocalDateTime.now());
		recipes.setUpdatedAt(LocalDateTime.now());
		Recipes searchedRecipes = recipesRepository.findByRecipesName(recipes.getRecipesName());
		if(searchedRecipes != null && searchedRecipes.getRecipesId() != 0) {
			return "Recipe already exists";
		}
		else {
			recipesRepository.save(recipes);
			return "Recipe is added to database";
		}
	}

	@Override
	public RecipesDTO searchRecipeByRecipeName(String recipeName) {
		Recipes searchedRecipes = recipesRepository.findByRecipesName(recipeName);
		
		RecipesDTO recipesDTO = new RecipesDTO();
		BeanUtils.copyProperties(searchedRecipes, recipesDTO);
		
		return recipesDTO;
	}

	@Override
	public String deleteRecipe(Integer id) {
		String message = "Recipe doesn't exist";
		if(recipesRepository.existsById(id)) {
			recipesRepository.deleteById(id);
			message = "Recipe is deleted from database";
		}
		return message;
	}

	@Override
	public RecipesDTO updateRecipe(RecipesDTO recipesDTO) {
		Recipes recipes=new Recipes();
		BeanUtils.copyProperties(recipesDTO, recipes);
		if(recipesRepository.existsById(recipes.getRecipesId())) {
			recipesRepository.saveAndFlush(recipes);
			return recipesDTO;
		}
		return null;
	}

}
